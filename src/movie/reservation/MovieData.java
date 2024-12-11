/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.reservation;

public class MovieData {
    String title;
    String duration;
    String posterPath;
    double price;

    public MovieData(String title, String duration, String posterPath, double price) {
        this.title = title;
        this.duration = duration;
        this.posterPath = posterPath;
        this.price = price;
    }

    // Getters for title, duration, posterPath, and price (add these)
    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public double getPrice() {
        return price;
    }
}



