package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.impl;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.mapper.AudiovisualProductionMapper;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.IAudiovisualProductionService;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.crud.AudiovisualCrudProductionRepository;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.crud.GenreRepository;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.AudiovisualProductionDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.AudiovisualProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudiovisualProductionServiceImpl implements IAudiovisualProductionService {

    @Autowired
    private AudiovisualCrudProductionRepository audiovisualCrudProductionRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AudiovisualProductionMapper audiovisualProductionMapper;

    @Override
    public List<AudiovisualProductionDto> getAll() {
        return audiovisualProductionMapper.toDtoList(audiovisualCrudProductionRepository.findAll());
    }

    @Override
    public List<AudiovisualProduction> getAllOrderByDateReleaseAsc() {
        return audiovisualCrudProductionRepository.findAllByOrderByReleaseDateAsc();
    }

    @Override
    public List<AudiovisualProduction> getAllOrderByDateReleaseDesc() {
        return audiovisualCrudProductionRepository.findAllByOrderByReleaseDateDesc();
    }

    @Override
    public Optional<AudiovisualProduction> getById(Long audiovisualProductionId) {
        return audiovisualCrudProductionRepository.findById(audiovisualProductionId);
    }

    @Override
    public Optional<AudiovisualProduction> getByTitle(String title) {
        return audiovisualCrudProductionRepository.findByTitle(title);
    }

    @Override
    public Optional<List<AudiovisualProduction>> getByGenreId(Long idGenre) {
        return audiovisualCrudProductionRepository.findByIdGenre(idGenre);
    }

    @Override
    public AudiovisualProduction saveAudiovisualProduction(AudiovisualProduction audiovisualProduction) {
        return audiovisualCrudProductionRepository.save(audiovisualProduction);
    }

    @Override
    public AudiovisualProduction modifyAudiovisualProduction(AudiovisualProduction audiovisualProduction) {
        return audiovisualCrudProductionRepository.save(audiovisualProduction);
    }

    @Override
    public void deleteAudiovisualProduction(Long audiovisualProductionId) {
        audiovisualCrudProductionRepository.deleteById(audiovisualProductionId);
    }
}
