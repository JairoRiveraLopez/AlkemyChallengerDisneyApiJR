package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long idGenre;

    @Column
    private String name;

    @Column
    private String image;

    @OneToMany(mappedBy = "genre")
    private List<AudiovisualProduction> audiovisualProductions;

    public Long getIdGenre() {
        return idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
