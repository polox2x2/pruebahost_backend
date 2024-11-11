package com.cavaDorada.RestobarCavaDorada.service;

import com.cavaDorada.RestobarCavaDorada.entity.Categoria;
import com.cavaDorada.RestobarCavaDorada.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository  categoriaRepository;

    public Categoria agregarCategoria (Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria>obtenerCategorias (Categoria categoria){
        return  categoriaRepository.findAll();
    }
    public Categoria getCategoriaById(Integer id) {
        return categoriaRepository.findById(id).orElseThrow();
    }

}
