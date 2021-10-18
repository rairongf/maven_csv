package br.inatel.cdg.models;

import lombok.Data;

@Data
public class Game {
    private int rank;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private float na_sales;
    private float eu_sales;
    private float jp_sales;
    private float other_sales;
    private float global_sales;

    public String[] toStringList(){
        return new String[] {String.valueOf(this.rank), this.name, this.platform,
                String.valueOf(this.year), this.genre, this.publisher, String.valueOf(this.na_sales),
                String.valueOf(this.eu_sales), String.valueOf(this.jp_sales), String.valueOf(this.other_sales),
                String.valueOf(this.global_sales)};
    }
}
