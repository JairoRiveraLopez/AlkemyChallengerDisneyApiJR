package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto;

import java.time.LocalDate;

public class AudiovisualProductionDto {

    private String audiovisualProductionImage;
    private String audiovisualProductionTitle;
    private LocalDate audiovisualProductionReleaseDate;

    public String getAudiovisualProductionImage() {
        return audiovisualProductionImage;
    }

    public void setAudiovisualProductionImage(String audiovisualProductionImage) {
        this.audiovisualProductionImage = audiovisualProductionImage;
    }

    public String getAudiovisualProductionTitle() {
        return audiovisualProductionTitle;
    }

    public void setAudiovisualProductionTitle(String audiovisualProductionTitle) {
        this.audiovisualProductionTitle = audiovisualProductionTitle;
    }

    public LocalDate getAudiovisualProductionReleaseDate() {
        return audiovisualProductionReleaseDate;
    }

    public void setAudiovisualProductionReleaseDate(LocalDate audiovisualProductionReleaseDate) {
        this.audiovisualProductionReleaseDate = audiovisualProductionReleaseDate;
    }
}
