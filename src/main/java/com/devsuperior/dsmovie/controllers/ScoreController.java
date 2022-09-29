package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

  @Autowired
  private ScoreService scoreService;

  @PutMapping
  public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO) {
    MovieDTO movieDTO = scoreService.saveScore(scoreDTO);
    return movieDTO;
  }

  @GetMapping()
  public Page<ScoreDTO> findAll(Pageable pageable) {
    return scoreService.findAll(pageable);
    //Este metodo na requisicao GET pode receber 2 parametros
    //size e page
    //size eu digo qual o tamanho da minha lista de retorno
    //page eu indico qual pagina eu quero buscar
  }

  @GetMapping("/{id}")
  public ScoreDTO findById(@PathVariable Long id) {
    return scoreService.findById(id);

  }

}
