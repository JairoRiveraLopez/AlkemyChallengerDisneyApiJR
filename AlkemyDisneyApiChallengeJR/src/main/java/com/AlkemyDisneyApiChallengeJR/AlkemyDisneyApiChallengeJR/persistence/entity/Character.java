package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private Long idCharacter;

    @Column
    private String image;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private Integer weight;

    @Column
    private String history;

    @Column(name = "fk_audiovisual_production_id")
    private Long audiovisualProductionId;

    @ManyToOne
    @JoinColumn(name = "fk_audiovisual_production_id", insertable = false, updatable = false)
    private AudiovisualProduction audiovisualProduction;

    public Long getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Long idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Long getAudiovisualProductionId() {
        return audiovisualProductionId;
    }

    public void setAudiovisualProductionId(Long audiovisualProductionId) {
        this.audiovisualProductionId = audiovisualProductionId;
    }
}
