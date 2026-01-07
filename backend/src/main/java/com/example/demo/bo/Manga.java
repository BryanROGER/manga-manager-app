package com.example.demo.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Mangas") // Correspond au nom exact dans ton SQL
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manga {

    @Id
    @Column(name = "anime_id")
    private Integer animeId;

    private String title;
    private String type;
    private Double score;

    @Column(name = "scored_by")
    private Integer scoredBy;

    private String status;
    private Integer episodes;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    private String source;
    private Integer members;
    private Integer favorites;

    @Column(name = "episode_duration")
    private String episodeDuration;

    @Column(name = "total_duration")
    private String totalDuration;

    private String rating;
    private String sfw;
    private String approved;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "start_season")
    private String startSeason;

    @Column(name = "real_start_date")
    private String realStartDate;

    @Column(name = "real_end_date")
    private String realEndDate;

    @Column(name = "broadcast_day")
    private String broadcastDay;

    @Column(name = "broadcast_time")
    private String broadcastTime;

    private String genres;
    private String themes;
    private String demographics;
    private String studios;
    private String producers;
    private String licensors;

    @Column(length = 512)
    private String synopsis;

    @Column(length = 512)
    private String background;

    @Column(name = "main_picture")
    private String mainPicture;

    private String url;

    @Column(name = "trailer_url")
    private String trailerUrl;

    @Column(name = "title_english")
    private String titleEnglish;

    @Column(name = "title_japanese")
    private String titleJapanese;

    @Column(name = "title_synonyms")
    private String titleSynonyms;
}