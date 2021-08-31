package br.inatel.cdg.controllers;

import br.inatel.cdg.models.Game;
import br.inatel.cdg.models.enums.Platform;
import br.inatel.cdg.models.enums.Publisher;
import br.inatel.cdg.utils.CsvUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.List;

public class TestGamesController {
    static private GamesController controller;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        List<Game> games = CsvUtils.readAndParseCsvToGameList();
        controller = new GamesController(games);
    }

    @Test
    public void testGet3DSGames(){
        List<Game> gamesOn3DS = controller.filterGameListByPlatform(Platform._3DS);
        Assert.assertEquals(7,gamesOn3DS.size());
    }

    @Test
    public void testGetAtari2600Games(){
        List<Game> gamesOnAtari2600 = controller.filterGameListByPlatform(Platform._2600);
        Assert.assertEquals(1,gamesOnAtari2600.size());
    }

    @Test
    public void testGetMicrosoftGames(){
        List<Game> gamesByMicrosoft = controller.filterGameListByPublisher(Publisher.MicrosoftGameStudios);
        Assert.assertEquals(6,gamesByMicrosoft.size());
    }

    @Test
    public void testGetElectronicArtsGames(){
        List<Game> gamesByMicrosoft = controller.filterGameListByPublisher(Publisher.ElectronicArts);
        Assert.assertEquals(5,gamesByMicrosoft.size());
    }
}
