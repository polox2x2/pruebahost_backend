package com.cavaDorada.RestobarCavaDorada.service;

import com.cavaDorada.RestobarCavaDorada.entity.Categoria;
import com.cavaDorada.RestobarCavaDorada.entity.Productos;
import com.cavaDorada.RestobarCavaDorada.entity.Provedor;
import com.cavaDorada.RestobarCavaDorada.repository.PedidosRepository;
import com.cavaDorada.RestobarCavaDorada.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaService categoriaService;
    private final ProvedorService provedorService;


    public List<Productos> getProductos (){
        return productoRepository.findAll();

    }



    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
    public Productos actualizarProducto(Integer id, Productos productoActualizado) {
        productoActualizado.setIdProducto(id);
        return productoRepository.save(productoActualizado);
    }

    public List<Productos> obtenerLicores() {
        return productoRepository.findAllLicores();
    }
    public  List<Productos>obtenerComidas(){
        return  productoRepository.findAllComida();
    }


    /*public List<Object[]> PrecioOrdenar(){
        return productoRepository.OrdenarPorPrecio();
    }
        */

}
