package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.FuncionarioDTO;
import br.unitins.tp1.dto.FuncionarioResponseDTO;
import br.unitins.tp1.dto.UsuarioResponseDTO;
import br.unitins.tp1.model.Funcionario;
import br.unitins.tp1.model.Pessoa;
import br.unitins.tp1.model.Usuario;
import br.unitins.tp1.repository.FuncionarioRepository;
import br.unitins.tp1.repository.PessoaRepository;
import br.unitins.tp1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService{
    


    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public PessoaRepository pessoaRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    public HashService hashService;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
       Funcionario funcionario = new Funcionario();
       Pessoa pessoa = new Pessoa();
       Usuario usuario = new Usuario();
       usuario.setUsername(dto.username());
       // gereando o hash da senha
       usuario.setSenha(hashService.getHashSenha(dto.senha()));

        // salvando o usuario
        usuarioRepository.persist(usuario);

        pessoa.setNome(dto.nome());
        pessoa.setIdade(dto.idade());
        pessoa.setEmail(dto.email());

        // salvando pessoa
        pessoaRepository.persist(pessoa);

        funcionario.setCargo(dto.cargo());
        funcionario.setSalario(dto.salario());
        funcionario.setPessoa(pessoa);

        // salvando o Funcionario
       funcionarioRepository.persist(funcionario);
       return FuncionarioResponseDTO.valueOf(funcionario);
    }

    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        Pessoa pessoa = pessoaRepository.findById(id);

        pessoa.setNome(dto.nome());
        pessoa.setIdade(dto.idade());
        pessoa.setEmail(dto.email());
        funcionario.setCargo(dto.cargo());
        funcionario.setSalario(dto.salario());
        funcionario.setPessoa(pessoa);

    }

    @Override
    @Transactional
    public void delete(long id) {
       funcionarioRepository.deleteById(id);
    }

    @Override
    public List<FuncionarioResponseDTO> findAll() {
        return funcionarioRepository
        .listAll()
        .stream()
        .map(f -> FuncionarioResponseDTO.valueOf(f)).toList();
    }

    @Override
    public FuncionarioResponseDTO findById(Long id) {
        return FuncionarioResponseDTO.valueOf(funcionarioRepository.findById(id));
    }

    @Override
    public List<FuncionarioResponseDTO> findByNome(String nome) {
        return funcionarioRepository.findByNome(nome).stream()
        .map(m -> FuncionarioResponseDTO.valueOf(m)).toList();
    }
    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Funcionario funcionario = funcionarioRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(funcionario.getPessoa());
    }
}
