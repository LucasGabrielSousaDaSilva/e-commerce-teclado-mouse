package br.unitins.tp1.service.pessoa;

import java.util.List;

import br.unitins.tp1.dto.pessoa.ClienteDTO;
import br.unitins.tp1.dto.pessoa.ClienteResponseDTO;
import br.unitins.tp1.dto.pessoa.UsuarioResponseDTO;
import br.unitins.tp1.model.pessoa.Cliente;
import br.unitins.tp1.model.pessoa.Pessoa;
import br.unitins.tp1.model.pessoa.Usuario;
import br.unitins.tp1.repository.pessoa.ClienteRepository;
import br.unitins.tp1.repository.pessoa.PessoaRepository;
import br.unitins.tp1.repository.pessoa.UsuarioRepository;
import br.unitins.tp1.service.hash.HashService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService{

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public PessoaRepository pessoaRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    public HashService hashService;

    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto) {
       Cliente cliente = new Cliente();
       Usuario usuario = new Usuario();
       Pessoa pessoa = new Pessoa();

       usuario.setUsername(dto.username());
       // gereando o hash da senha
       usuario.setSenha(hashService.getHashSenha(dto.senha()));

        // salvando o usuario
        usuarioRepository.persist(usuario);

        pessoa.setNome(dto.nome());
        pessoa.setIdade(dto.idade());
        pessoa.setEmail(dto.email());
        pessoa.setUsuario(usuario);

        // salvando pessoa
        pessoaRepository.persist(pessoa);

        cliente.setEndereço(dto.endereco());
        cliente.setPessoa(pessoa);

        // salvando o Cliente
       clienteRepository.persist(cliente);
       return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id);
        Pessoa pessoa = pessoaRepository.findById(id);

        pessoa.setNome(dto.nome());
        pessoa.setIdade(dto.idade());
        pessoa.setEmail(dto.email());
        cliente.setEndereço(dto.endereco());
        cliente.setPessoa(pessoa);

    }

    @Override
    @Transactional
    public void delete(long id) {
       clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        return clienteRepository
        .listAll()
        .stream()
        .map(f -> ClienteResponseDTO.valueOf(f)).toList();
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(clienteRepository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        return clienteRepository.findByNome(nome).stream()
        .map(m -> ClienteResponseDTO.valueOf(m)).toList();
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(cliente.getPessoa());
    }
    
}
