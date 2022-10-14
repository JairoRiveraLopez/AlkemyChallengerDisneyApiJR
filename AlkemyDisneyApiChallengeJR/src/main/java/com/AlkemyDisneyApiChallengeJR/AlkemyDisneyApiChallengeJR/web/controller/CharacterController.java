package com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.web.controller;

import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.domain.service.impl.CharacterServiceImpl;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.dto.CharacterDto;
import com.AlkemyDisneyApiChallengeJR.AlkemyDisneyApiChallengeJR.persistence.entity.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterServiceImpl characterServiceImpl;

    @GetMapping()
    public ResponseEntity<List<CharacterDto>> getAll() {
        return new ResponseEntity<>(characterServiceImpl.getAll(), HttpStatus.OK);
        }

    @GetMapping("/name")
    public ResponseEntity<Character> getByName(@RequestParam String name){
            return characterServiceImpl.getByName(name)
                    .map(nameQuery -> new ResponseEntity<>(nameQuery, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/age")
    public ResponseEntity<List<Character>> getByAge(@RequestParam Integer age){
        Optional<List<Character>> charactersByAge = characterServiceImpl.getByAge(age);
        if (charactersByAge.isPresent() && !charactersByAge.get().isEmpty()){
            return new ResponseEntity<>(charactersByAge.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/moviesId")
    public ResponseEntity<List<Character>> getByAudiovisualProduction(@RequestParam Long moviesId){
        Optional<List<Character>> charactersByAudiovisualProduction = characterServiceImpl
                .getByAudiovisualProductionId(moviesId);
        if (charactersByAudiovisualProduction.isPresent() && !charactersByAudiovisualProduction.get().isEmpty()){
            return new ResponseEntity<>(charactersByAudiovisualProduction.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Character> saveCharacter(@RequestBody Character character){
        return new ResponseEntity<>(characterServiceImpl.saveCharacter(character), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Character> modifyCharacter(@RequestBody Character character){
        Optional<Character> characterToUpdate = characterServiceImpl.getByIdCharacter(character.getIdCharacter());
        if (characterToUpdate.isPresent()){
            return ResponseEntity.ok(characterServiceImpl.modifyCharacter(character));
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id){
        Optional<Character> characterQuery = characterServiceImpl.getByIdCharacter(id);
        if (characterQuery.isPresent()){
            characterServiceImpl.deleteCharacter(id);
            return ResponseEntity.ok("The character with ID = " + id + " has been deleted.");
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
