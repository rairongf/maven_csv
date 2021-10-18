package br.inatel.cdg.utils;

import br.inatel.cdg.models.Game;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileWriter;
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

    static public void writeGamesToCsv(String filePath, List<Game> games)
    {
        File file = new File(filePath);

        try {
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputfile);
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[] {"rank", "name", "platform", "year", "genre", "publisher",
            "na_sales", "eu_sales", "jp_sales", "other_sales", "global_sales"});
            for (Game game: games) {
                data.add(game.toStringList());
            }
            writer.writeAll(data);

            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
