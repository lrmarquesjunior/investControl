package br.com.invest.investControl.repository;

import br.com.invest.investControl.entity.AtivosEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtivosRepository extends JpaRepository<AtivosEntity, UUID> {
    List<AtivosEntity> findByNomeAtivo(String nomeAtivo);

    void deleteByNomeAtivo(String nomeAtivo);
}
