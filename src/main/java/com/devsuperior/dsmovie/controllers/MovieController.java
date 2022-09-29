package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @GetMapping()
  public Page<MovieDTO> findAll(Pageable pageable) {
    return movieService.findAll(pageable);
    //Este metodo na requisicao GET pode receber 2 parametros
    //size e page
    //size eu digo qual o tamanho da minha lista de retorno
    //page eu indico qual pagina eu quero buscar
  }

  @GetMapping("/{id}")
  public MovieDTO findById(@PathVariable Long id) {
    return movieService.findById(id);

  }


}
