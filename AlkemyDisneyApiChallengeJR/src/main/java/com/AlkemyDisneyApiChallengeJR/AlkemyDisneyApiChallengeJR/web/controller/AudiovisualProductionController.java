package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.web.controller;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.impl.AudiovisualProductionServiceImpl;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.AudiovisualProductionDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.AudiovisualProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class AudiovisualProductionController {

    @Autowired
    private AudiovisualProductionServiceImpl audiovisualProductionServiceImpl;

    @GetMapping
    public ResponseEntity<List<AudiovisualProductionDto>> getAll() {
        return new ResponseEntity<>(audiovisualProductionServiceImpl.getAll(), HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<AudiovisualProduction> getByTitle(@RequestParam String title){
        return audiovisualProductionServiceImpl.getByTitle(title)
                .map(titleQuery -> new ResponseEntity<>(titleQuery, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/idGenre")
    public ResponseEntity<List<AudiovisualProduction>> getByIdGenre(@RequestParam Long idGenre){
        Optional<List<AudiovisualProduction>> audiovisualProductionsByGenre = audiovisualProductionServiceImpl
                .getByGenreId(idGenre);
        if (audiovisualProductionsByGenre.isPresent() && !audiovisualProductionsByGenre.get().isEmpty()){
            return new ResponseEntity<>(audiovisualProductionsByGenre.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/orderWay")
    public ResponseEntity<List<AudiovisualProduction>> findAllByOrderBy(@RequestParam String orderWay) {
        List<AudiovisualProduction> audiovisualProductionsListSort;
        if(orderWay.equalsIgnoreCase("ASC")){
            audiovisualProductionsListSort = audiovisualProductionServiceImpl.getAllOrderByDateReleaseAsc();
            return new ResponseEntity<>(audiovisualProductionsListSort, HttpStatus.OK);
        } else if(orderWay.equalsIgnoreCase("DESC")){
            audiovisualProductionsListSort = audiovisualProductionServiceImpl.getAllOrderByDateReleaseDesc();
            return new ResponseEntity<>(audiovisualProductionsListSort, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<AudiovisualProduction> saveAudiovisualProduction(@RequestBody AudiovisualProduction audiovisualProduction){
        return new ResponseEntity<>(audiovisualProductionServiceImpl.saveAudiovisualProduction(audiovisualProduction),
                HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AudiovisualProduction> modifyAudiovisualProduction(@RequestBody AudiovisualProduction audiovisualProduction){
        Optional<AudiovisualProduction> audiovisualProductionToUpdate = audiovisualProductionServiceImpl
                .getById(audiovisualProduction.getIdAudiovisualProduction());
        if (audiovisualProductionToUpdate.isPresent()){
            return ResponseEntity.ok(audiovisualProductionServiceImpl.modifyAudiovisualProduction(audiovisualProduction));
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAudiovisualProduction(@PathVariable Long id){
        Optional<AudiovisualProduction> audiovisualProductionQuery = audiovisualProductionServiceImpl.getById(id);
        if (audiovisualProductionQuery.isPresent()){
            audiovisualProductionServiceImpl.deleteAudiovisualProduction(id);
            return ResponseEntity.ok("The movie/serie with ID = " + id + " has been deleted.");
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
