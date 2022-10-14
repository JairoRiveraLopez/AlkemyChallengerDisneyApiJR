package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Character;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "audiovisual_productions")
public class AudiovisualProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audiovisual_production_id")
    private Long idAudiovisualProduction;

    @Column
    private String image;

    @Column
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column
    private Double score;

    @Column(name = "fk_genre_id")
    private Long idGenre;

    @ManyToOne
    @JoinColumn(name = "fk_genre_id", insertable = false, updatable = false)
    private Genre genre;

    @OneToMany(mappedBy = "audiovisualProduction")
    private List<Character> characters;

    public Long getIdGenre() {
        return idGenre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Long getIdAudiovisualProduction() {
        return idAudiovisualProduction;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
