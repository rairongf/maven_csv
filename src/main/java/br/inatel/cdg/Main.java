package br.inatel.cdg;

import br.inatel.cdg.controllers.GamesController;
import br.inatel.cdg.models.Game;
import br.inatel.cdg.models.enums.Platform;
import br.inatel.cdg.models.enums.Publisher;
import br.inatel.cdg.utils.CsvUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Game> games = new ArrayList<Game>();
        List<Game> filteredGames = new ArrayList<Game>();
        games = CsvUtils.readAndParseCsvToGameList();
        GamesController controller = new GamesController(games);
        Scanner entrada = new Scanner(System.in);
        int op = -1;
        int codPlataforma = -1;
        int codPublisher = -1;

        while(op != 0){
            System.out.println(" ### MENU ### ");
            System.out.println(" ! Digite o código da operação que deseja fazer ! ");
            System.out.println(" 1 - Buscar jogos por plataforma e exportar .csv");
            System.out.println(" 2 - Buscar jogos por publisher e exportar .csv");
            System.out.println(" 0 - Fechar programa ");
            System.out.println(" ! Digite sua opção: ");
            op = entrada.nextInt();

            switch (op){
                case 0:
                    System.out.println(" Fechando programa... ");
                    break;
                case 1:
                    System.out.println("\n ## Plataformas ## ");
                    System.out.println(" ! Digite o código da plataforma que deseja filtrar ! ");
                    System.out.println(" 1 - Wii");
                    System.out.println(" 2 - NES");
                    System.out.println(" 3 - GB");
                    System.out.println(" 4 - DS");
                    System.out.println(" 5 - X360");
                    System.out.println(" 6 - PS3");
                    System.out.println(" 7 - PS2");
                    System.out.println(" 8 - SNES");
                    System.out.println(" 9 - GBA");
                    System.out.println(" 10 - 3DS");
                    System.out.println(" 11 - PS4");
                    System.out.println(" 12 - N64");
                    System.out.println(" 13 - PS");
                    System.out.println(" 14 - PC");
                    System.out.println(" 15 - 2600");
                    System.out.println(" 16 - PSP");
                    System.out.println(" 17 - XB");
                    System.out.println(" ! Digite sua opção: ");
                    codPlataforma = entrada.nextInt();

                    System.out.println("\n Opção escolhida:");
                    System.out.println(" Plataforma: " + Platform.values()[codPlataforma - 1]);
                    filteredGames = controller.filterGameListByPlatform(Platform.values()[codPlataforma - 1]);
                    CsvUtils.writeGamesToCsv("filteredGames.csv", filteredGames);
                    break;
                case 2:
                    System.out.println("\n ## Publishers ## ");
                    System.out.println(" ! Digite o código da publisher que deseja filtrar ! ");
                    System.out.println(" 1 - Nintendo");
                    System.out.println(" 2 - Take2 Interactive");
                    System.out.println(" 3 - Sony");
                    System.out.println(" 4 - Activision");
                    System.out.println(" 5 - Microsoft Game Studios");
                    System.out.println(" 6 - Ubisoft");
                    System.out.println(" 7 - Bethesda");
                    System.out.println(" 8 - Electronic Arts");
                    System.out.println(" 9 - Sega");
                    System.out.println(" 10 - SquareSoft");
                    System.out.println(" 11 - Atari");
                    System.out.println(" ! Digite sua opção: ");
                    codPublisher = entrada.nextInt();

                    System.out.println("\n Opção escolhida:");
                    System.out.println(" Publisher: " + Publisher.values()[codPublisher - 1]);
                    filteredGames = controller.filterGameListByPublisher(Publisher.values()[codPublisher - 1]);
                    CsvUtils.writeGamesToCsv("filteredGames.csv", filteredGames);
                    break;
                default:
                    break;
            }
            System.out.println(" ");
        }
    }
}
