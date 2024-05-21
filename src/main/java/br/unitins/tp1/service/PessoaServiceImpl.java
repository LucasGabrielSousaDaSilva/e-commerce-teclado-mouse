package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.PessoaDTO;
import br.unitins.tp1.dto.PessoaResponseDTO;
import br.unitins.tp1.model.Pessoa;
import br.unitins.tp1.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PessoaServiceImpl implements PessoaService{

        @Inject
    public PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public PessoaResponseDTO create(@Valid PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(dto.nome());
        pessoa.setIdade(dto.idade());
        pessoa.setEmail(dto.email());

        pessoaRepository.persist(pessoa);
        return PessoaResponseDTO.valueOf(pessoa);
    }

    @Override
    @Transactional
    public void update(Long id, PessoaDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(id);

        pessoa.setNome(dto.nome());
        pessoa.setIdade(dto.idade());
        pessoa.setEmail(dto.email());

    }

    @Override
    @Transactional
    public void delete(long id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        return pessoaRepository
        .listAll()
        .stream()
        .map(e -> PessoaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public PessoaResponseDTO findById(Long id) {
        return PessoaResponseDTO.valueOf(pessoaRepository.findById(id));
    }
    
}
