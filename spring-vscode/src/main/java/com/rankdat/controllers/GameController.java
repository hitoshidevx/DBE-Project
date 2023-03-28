package com.rankdat.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rankdat.models.Game;
import java.time.LocalDate;

@RestController
public class GameController {

    @GetMapping("/api/jogos")
    public Game show(){
        var jogo = new Game(
                    new BigDecimal(100), 
                    LocalDate.now(), 
                     "cinema",
                    "shutup"
                );

        return jogo;
    }

}