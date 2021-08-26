package br.inatel.cdg.controllers;

import br.inatel.cdg.models.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GamesController {
    private List<Game> gameList;

    public GamesController(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<Game> filterGameListByPlatform(Game.Platform platform){
        List<Game> filteredGameList = this.gameList
                .stream()
                .filter(g -> g.getPlatform() == platform)
                .collect(Collectors.toList());

        return filteredGameList;
    }

    public List<Game> filterGameListByPublisher(Game.Publisher publisher){
        List<Game> filteredGameList = this.gameList
                .stream()
                .filter(g -> g.getPublisher() == publisher)
                .collect(Collectors.toList());

        return filteredGameList;
    }
}
