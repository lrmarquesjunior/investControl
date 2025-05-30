package br.com.invest.investControl.service;

import br.com.invest.investControl.entity.AtivosEntity;
import br.com.invest.investControl.repository.AtivosRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtivosService {
    private final AtivosRepository ativosRepository;

    @Autowired
    public AtivosService(AtivosRepository ativosRepository) {
        this.ativosRepository = ativosRepository;
    }

    public AtivosEntity salvarAtivo(AtivosEntity ativo) {
        return (AtivosEntity)this.ativosRepository.save(ativo);
    }

    public Optional<AtivosEntity> buscarPorId(UUID id) {
        return this.ativosRepository.findById(id);
    }

    public List<AtivosEntity> listarTodos() {
        return this.ativosRepository.findAll();
    }

    public void deletarAtivo(UUID id) {
        this.ativosRepository.deleteById(id);
    }

    public List<AtivosEntity> buscarPorNome(String nomeAtivo) {
        return this.ativosRepository.findByNomeAtivo(nomeAtivo);
    }

    public void deletarPorNome(String nomeAtivo) {
        this.ativosRepository.deleteByNomeAtivo(nomeAtivo);
    }
}