package com.example.tienda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UsuarioController {
    // Lista para almacenar los Usuarios
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController() {

        // Se agregan Usuarios con su información
        usuarios.add(new Usuario(1, "Carlos", "ca.fabres@duocuc.cl", "Administrador",
                Arrays.asList(new Direccion("Los Lagos", "Puerto Varas", "Real", 666),
                        new Direccion("Metropolitana", "Santiago", "Falsa", 123),
                        new Direccion("Valparaíso", "Viña del Mar", "Inventada", 456))));

        usuarios.add(new Usuario(2, "Ignacio", "ig.salas@duocuc.cl", "Usuario",
                Arrays.asList(new Direccion("Los Lagos", "Puerto Varas", "Real", 666),
                        new Direccion("Metropolitana", "Santiago", "Falsa", 123),
                        new Direccion("Valparaíso", "Viña del Mar", "Inventada", 456))));

        usuarios.add(new Usuario(3, "Vicente", "vi.echeverria@duocuc.cl", "Usuario",
                Arrays.asList(new Direccion("Los Lagos", "Puerto Varas", "Real", 666),
                        new Direccion("Metropolitana", "Santiago", "Falsa", 123),
                        new Direccion("Valparaíso", "Viña del Mar", "Inventada", 456))));

    }

    // Endpoint para obtener todos los Usuarios
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return ResponseEntity.ok(usuario);
            }
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("No se encontró ningun usuario con el id proporcionado");
    }

    @GetMapping("/usuarios/{id}/direcciones")
    public ResponseEntity<?> getDireccionesUsuario(@PathVariable int id) {
        ResponseEntity<?> usuarioResponse = getUsuarioById(id);
        if (usuarioResponse.getStatusCode() == HttpStatus.OK) {
            Usuario usuario = (Usuario) usuarioResponse.getBody();
            return ResponseEntity.ok(usuario.getDirecciones());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró ningún usuario con el ID proporcionado");
        }
    }

    @GetMapping("/usuarios/{id}/rol")
    public ResponseEntity<?> getRolUsuario(@PathVariable int id) {
        ResponseEntity<?> usuarioResponse = getUsuarioById(id);
        if (usuarioResponse.getStatusCode() == HttpStatus.OK) {
            Usuario usuario = (Usuario) usuarioResponse.getBody();
            Map<String, String> response = new HashMap<>();
            response.put("rol", usuario.getRol());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró ningún usuario con el ID proporcionado");
        }
    }

}
