package br.inatel.cdg;

import br.inatel.cdg.controllers.GamesController;
import br.inatel.cdg.models.Game;
import br.inatel.cdg.models.enums.Platform;
import br.inatel.cdg.models.enums.Publisher;
import br.inatel.cdg.utils.CsvUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Game> games = CsvUtils.readAndParseCsvToGameList();
        GamesController controller = new GamesController(games);
        System.out.println(controller.filterGameListByPlatform(Platform._3DS).size());
        System.out.println(controller.filterGameListByPlatform(Platform._2600).size());
        System.out.println(controller.filterGameListByPublisher(Publisher.MicrosoftGameStudios).size());
        System.out.println(controller.filterGameListByPublisher(Publisher.ElectronicArts).size());
    }
}
