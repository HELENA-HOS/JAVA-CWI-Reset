package br.com.cwi.reset.tcc.service;

import br.com.cwi.reset.tcc.dominio.Endereco;
import br.com.cwi.reset.tcc.dominio.Usuario;
import br.com.cwi.reset.tcc.exceptions.*;
import br.com.cwi.reset.tcc.mapper.UsuariosPorIdResponseMapper;
import br.com.cwi.reset.tcc.mapper.UsuarioMapper;
import br.com.cwi.reset.tcc.repository.EnderecoRepository;
import br.com.cwi.reset.tcc.repository.UsuarioRepository;
import br.com.cwi.reset.tcc.request.UsuarioRequest;
import br.com.cwi.reset.tcc.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UsuariosPorIdResponseMapper usuariosPorIdResponseMapper;

    @Autowired
    private EnderecoRepository enderecoRepository;



    // ------ ***** METÓDO CADASTRO USUARIO ***** ------ //

    public Usuario criarUsuario(UsuarioRequest request) {
        validarEmailUsuario(request);
        validarCpfUsuario(request);

        Usuario usuarioSalvar = usuarioMapper.mapear(request);
        usuarioRepository.save(usuarioSalvar);
        return usuarioSalvar;
    }

    // ------ ***** METÓDOS AUXILIARES - CADASTRO USUARIO ***** ------ //

    private void validarEmailUsuario(UsuarioRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new EmailJaCadastradoException();
        }
    }

    private void validarCpfUsuario(UsuarioRequest request) {
        if (usuarioRepository.existsByCpf(request.getCpf())) {
            throw new CpfJaCadastradoException("CPF já cadastrado para outro usuário.");
        }
    }

    // ------ ***** METÓDO LISTAGEM USUARIO ***** ------ //

    public Page<Usuario> listarUsuarios(Pageable pageable) {
        return usuarioRepository.findAllByOrderByNomeAsc(pageable);
    }


    // ------ ***** METÓDO BUSCAR USUARIO POR ID ***** ------ //

    public UsuarioResponse buscarUsuarioPorId(Long id) {
        Usuario usuarioSalvo = usuarioRepository.findById(id).orElse(null);

        if (usuarioSalvo == null) {
            throw new UsuarioNaoLocalizadoException();
        }

        return usuariosPorIdResponseMapper.mapear(usuarioSalvo);

    }

    // ------ ***** METÓDO ALTERAR USUARIO ***** ------ //

    public Usuario alterarUsuario(Long idUsuario, UsuarioRequest request) {

        Usuario usuarioAlterar = usuarioRepository.findById(idUsuario).orElseThrow(()
                -> new UsuarioNaoLocalizadoException());

        validarEmailUsuario(request);

        usuarioAlterar.setNome(request.getNome());
        usuarioAlterar.setEmail(request.getEmail());
        usuarioAlterar.setSenha(request.getSenha());
        usuarioAlterar.setEnderecos(request.getEnderecos());
        usuarioRepository.save(usuarioAlterar);
        return usuarioAlterar;
    }

    // ------ ***** METÓDO REMOVER ENDEREÇO USUARIO ***** ------ //

    public void deletarEnderecoUsuario(Long idUsuario, Long idEndereco) {
        Usuario usuarioEndereco = usuarioRepository.findById(idUsuario).orElseThrow(()
                -> new UsuarioNaoLocalizadoException());
        Endereco endereco = enderecoRepository.findById(idEndereco).orElseThrow(()
                -> new EnderecoNaoLocalizadoException());

        if(!usuarioEndereco.getEnderecos().contains(endereco)) {
            throw new UsuarioEnderecoInvalidoException();
        }

        usuarioEndereco.getEnderecos().remove(endereco);
        enderecoRepository.delete(endereco);
    }


    // ------ ***** METÓDO ADICIONAR ENDEREÇO USUARIO ***** ------ //

    public void adicionarEndereco(Long idUsuario,Endereco endereco) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(()
                -> new UsuarioNaoLocalizadoException());
        usuario.getEnderecos().add(endereco);
        usuarioRepository.save(usuario);
    }
}
