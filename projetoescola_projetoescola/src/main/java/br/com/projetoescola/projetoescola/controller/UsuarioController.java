package br.com.projetoescola.projetoescola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import br.com.projetoescola.projetoescola.model.Usuario;
import br.com.projetoescola.projetoescola.repository.UsuarioRepository;
import br.com.projetoescola.projetoescola.security.TokenUtil;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // GET - lista todos os usuários
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    // POST - salva um novo usuário
    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    // PUT - atualiza um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }

    // DELETE - remove um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuário removido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }

    // LOGIN - autentica usuário e gera JWT
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Usuario usuarioBanco = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioBanco != null && usuarioBanco.getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.ok(TokenUtil.createToken(usuarioBanco.getUsuario()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro: usuário ou senha inválidos!");
        }
    }
}
