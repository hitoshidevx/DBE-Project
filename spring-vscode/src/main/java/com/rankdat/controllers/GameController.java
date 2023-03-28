package com.rankdat.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rankdat.models.Game;
import java.util.List;
import java.util.ArrayList;

@RestController
public class GameController {

    Logger log = LoggerFactory.getLogger(GameController.class);

    List<Game> jogos = new ArrayList<>();

    @GetMapping("/api/jogos")
    public List<Game> returnGames() {
        return jogos;
    }

    @PostMapping("/api/jogo")
    public ResponseEntity<Game> createGame(@RequestBody Game jogo) {
        log.info("cadastrando jogo: " + jogo);
        jogo.setId(jogos.size() + 1l);
        jogos.add(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogo);
    }

    @GetMapping("/api/jogo/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        log.info("buscando por jogo com id: " + id);
        var jogoEncontrado = jogos.stream().filter(j -> j.getId().equals(id)).findFirst();

        if(jogoEncontrado.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(jogoEncontrado.get());
    }

    @DeleteMapping("/api/jogo/{id}")
    public ResponseEntity<Game> deleteGame(@PathVariable Long id) {
        log.info("deletando jogo com id: " + id);
        var jogoEncontrado = jogos.stream().filter(j -> j.getId().equals(id)).findFirst();

        if(jogoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        jogos.remove(jogoEncontrado.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/jogo/{id}")
    public ResponseEntity<Game> putGame(@PathVariable Long id, @RequestBody Game jogo) {
        log.info("alterando jogo com id: " + id);
        var jogoEncontrado = jogos.stream().filter(j -> j.getId().equals(id)).findFirst();

        if(jogoEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        jogos.remove(jogoEncontrado.get());
        jogo.setId(id);
        jogos.add(jogo);

        return ResponseEntity.ok(jogo);

    }

}