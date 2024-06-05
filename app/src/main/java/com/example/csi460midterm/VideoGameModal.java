package com.example.csi460midterm;

public class VideoGameModal {
    private String gameName;
    private String gameGenre;
    private int gameRating;
    private String gameDescription;
    private int id;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public int getGameRating() {
        return gameRating;
    }

    public void setGameRating(int gameRating) {
        this.gameRating = gameRating;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public VideoGameModal(String gameName,
                       String gameGenre,
                       int gameRating,
                       String gameDescription)
    {
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.gameRating = gameRating;
        this.gameDescription = gameDescription;
    }

}
