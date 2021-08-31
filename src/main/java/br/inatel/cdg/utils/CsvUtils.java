package br.inatel.cdg.utils;

import br.inatel.cdg.models.Game;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    static public List<Game> readAndParseCsvToGameList(){

        List<Game> gameList = new ArrayList<>();

        try {
            Path csvFilePath = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
            Reader reader = Files.newBufferedReader(csvFilePath);
            CsvToBean<Game> csvToBean = new CsvToBeanBuilder<Game>(reader)
                    .withType(Game.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            gameList = csvToBean.parse();
        } catch(IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return gameList;
    }


}
