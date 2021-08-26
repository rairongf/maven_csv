package br.inatel.cdg.utils;

import br.inatel.cdg.models.Game;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvUtils {
    static private Path csvFilePath = FileSystems.getDefault().getPath("vendas-games.csv");
    //.getPath("logs", "access.log");

    static public List<Game> readAndParseCsvToGameList(){
        List<Game> gameList = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(csvFilePath);
            CsvToBean<Game> csvToBean = new CsvToBeanBuilder<Game>(reader)
                    .withType(Game.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            gameList = csvToBean.parse();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return gameList;
    }


}
