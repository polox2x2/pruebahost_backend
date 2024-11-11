package com.cavaDorada.RestobarCavaDorada.controller;

import com.cavaDorada.RestobarCavaDorada.entity.Clientes;
import com.cavaDorada.RestobarCavaDorada.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@AllArgsConstructor
public class ClientesController {

        private final ClienteService clienteService;
    @PostMapping ("/crear")
    public Clientes CrearCliente (@RequestBody Clientes clientes){
        return clienteService.CrearCliente(clientes);
    }

    @GetMapping ("/lista")
    public List <Clientes> getClientes () {
        return clienteService.getClientes();
    }
    @GetMapping ("/{id}")                //patva indicamos en la url un id
    public Clientes getClienteById(@PathVariable Integer id){
        return clienteService.getClienteById(id);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginCliente (@RequestBody Clientes loginCliente ){
        System.out.println("Email: " + loginCliente.getEmail());
        System.out.println("Clave: " + loginCliente.getClave());
        Clientes cliente = clienteService.findByEmailAndClave(loginCliente.getEmail(), loginCliente.getClave());

        if (cliente != null){
            return ResponseEntity.ok("Login Exitoso");

        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }

    }


}
