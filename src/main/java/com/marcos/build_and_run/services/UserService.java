package com.marcos.build_and_run.services;

import com.marcos.build_and_run.dto.ContaDto;
import com.marcos.build_and_run.dto.UsuarioDto;
import com.marcos.build_and_run.entities.Conta;
import com.marcos.build_and_run.entities.EnderecoDeCobranca;
import com.marcos.build_and_run.entities.Usuario;
import com.marcos.build_and_run.repositories.ContaRepository;
import com.marcos.build_and_run.repositories.EnderecoDeCobrancaRepository;
import com.marcos.build_and_run.repositories.UsuarioRepository;
import com.marcos.build_and_run.services.exceptions.DbViolateIntegrityException;
import com.marcos.build_and_run.services.exceptions.UsuarioInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private EnderecoDeCobrancaRepository enderecoDeCobrancaRepository;

    @Transactional
    public Long createUser(UsuarioDto usuarioDto) {
        var usuario = new Usuario(null, usuarioDto.getUsername(), usuarioDto.getEmail(), usuarioDto.getPassword());
        var usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioSalvo.getId();
    }

    @Transactional(readOnly = true)
    public UsuarioDto getUserById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Usuario result = usuario.orElseThrow(() -> new UsuarioInexistenteException("Usuário de ID " + id + " inexistente."));
        return new UsuarioDto(result.getId(), result.getUsername(), result.getEmail(), result.getPassword());
    }

    @Transactional(readOnly = true)
    public List<UsuarioDto> listUsers() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioDto(usuario.getId(), usuario.getUsername(), usuario.getEmail(), usuario.getPassword())).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        try {
            if (usuarioRepository.existsById(id)) {
                usuarioRepository.deleteById(id);
            } else throw new UsuarioInexistenteException("Usuário de ID " + id + " inexistente.");
        } catch (DataIntegrityViolationException e) {
            throw new DbViolateIntegrityException("Erro de integridade referencial. Usuário de ID " + id + " não pode ser excluído porque está associado à outra entidade.");
        }
    }

    @Transactional
    public void updateUserById(Long id, UsuarioDto usuarioDto) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = usuarioRepository.getReferenceById(id);
            usuario.setUsername(usuarioDto.getUsername());
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setPassword(usuarioDto.getPassword());
            usuarioRepository.save(usuario);
        } else throw new UsuarioInexistenteException("Usuário de ID " + usuarioDto.getId() + " inexistente.");
    }

    @Transactional
    public void criarConta(Long id, ContaDto contaDto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioInexistenteException("Usuário de ID " + id + " inexistente."));
        Conta conta = new Conta(null, usuario, contaDto.description(), null);
        Conta contaCriada = contaRepository.save(conta);
        EnderecoDeCobranca enderecoDeCobranca = new EnderecoDeCobranca(null, contaCriada, contaDto.rua(), contaDto.numero());
        enderecoDeCobrancaRepository.save(enderecoDeCobranca);
    }

    @Transactional(readOnly = true)
    public List<ContaDto> listarContas(Long id) {
        var usuario = usuarioRepository.findUsuarioByIdWithConta(id);
        return usuario.getContas()
                .stream()
                .map(conta -> new ContaDto(conta.getId(), conta.getDescription(), conta.getEnderecoDeCobranca().getRua(), conta.getEnderecoDeCobranca().getNumero()))
                .toList();
    }
}
