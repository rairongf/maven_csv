package br.inatel.cdg.models;

import lombok.Data;

@Data
public class Game {
    public enum Platform { Wii, NES, GB, DS, X360, PS3, PS2,
        SNES, GBA, _3DS, PS4, N64,
        PS, PC, ATARI2600, PSP, XB}

    public enum Genre { Sports, Platform, Racing, Role_Play,
        Puzzle, Misc, Shooter, Simulator, Action,
        Fighting, Adventure}

    public enum Publisher { Nintendo, Take2Interactive, Sony,
        Activision, Microsoft, Ubisoft, Bethesda,
        EA, Sega, SquareSoft, Atari}
    private int rank;
    private String name;
    private Platform platform;
    private int year;
    private Genre genre;
    private Publisher publisher;
    private float na_sales;
    private float eu_sales;
    private float jp_sales;
    private float other_sales;
    private float global_sales;

    public Game(int rank, String name, Platform platform, int year, Genre genre, Publisher publisher, float na_sales, float eu_sales, float jp_sales, float other_sales, float global_sales) {
        this.rank = rank;
        this.name = name;
        this.platform = platform;
        this.year = year;
        this.genre = genre;
        this.publisher = publisher;
        this.na_sales = na_sales;
        this.eu_sales = eu_sales;
        this.jp_sales = jp_sales;
        this.other_sales = other_sales;
        this.global_sales = global_sales;
    }
}
