package br.inatel.cdg.controllers;

import br.inatel.cdg.models.Game;
import br.inatel.cdg.models.enums.Platform;
import br.inatel.cdg.models.enums.Publisher;

import java.util.List;
import java.util.stream.Collectors;

public class GamesController {
    private List<Game> gameList;

    public GamesController(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<Game> filterGameListByPlatform(Platform platform){
        return this.gameList
                .stream()
                .filter(g -> g.getPlatform().equals(platform.name().replaceAll("_", "")))
                .collect(Collectors.toList());
    }

    public List<Game> filterGameListByPublisher(Publisher publisher){
        return this.gameList
                .stream()
                .filter(g -> g.getPublisher().replaceAll("\\s+", "").equals(publisher.name()))
                .collect(Collectors.toList());
    }
}
