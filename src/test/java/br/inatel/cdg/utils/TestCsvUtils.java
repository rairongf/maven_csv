package br.inatel.cdg.utils;

import br.inatel.cdg.models.Game;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.List;

public class TestCsvUtils {
    private static List<Game> games;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        games = CsvUtils.readAndParseCsvToGameList();
    }

    @Test
    public void testListNotEmpty(){
        int length = games.size();
        Assert.assertTrue(length > 0);
    }
}
