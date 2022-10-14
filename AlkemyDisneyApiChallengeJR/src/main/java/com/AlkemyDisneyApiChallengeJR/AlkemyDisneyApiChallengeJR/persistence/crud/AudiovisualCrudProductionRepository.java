package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.crud;


import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.AudiovisualProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AudiovisualCrudProductionRepository extends JpaRepository<AudiovisualProduction, Long> {
    List<AudiovisualProduction> findAllByOrderByReleaseDateAsc();
    List<AudiovisualProduction> findAllByOrderByReleaseDateDesc();
    Optional<AudiovisualProduction> findById(Long audiovisualProductionId);
    Optional<AudiovisualProduction> findByTitle(String title);
    Optional<List<AudiovisualProduction>> findByIdGenre(Long idGenre);

}
