package com.zakaria.task.movies;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Movies")
public class Movie implements Serializable {

    @Id
    private int id;
    private String title;

    @Column(length = 8000)
    private String overview;
    private LocalDate release_date;
    private int popularity;

    @Column(nullable = true)
    private Integer revenue;

    private String poster_path;

    public Movie() {
    }

    public Movie(int id, String title, String overview, LocalDate release_date, int popularity, int revenue, String poster_path) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
        this.popularity = popularity;
        this.revenue = revenue;
        this.poster_path = poster_path;
    }

    public Movie(int id, String title, LocalDate release_date, int popularity) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date=" + release_date +
                ", popularity=" + popularity +
                ", revenue=" + revenue +
                ", poster_path='" + poster_path + '\'' +
                '}';
    }
}
