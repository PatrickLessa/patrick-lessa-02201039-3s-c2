package com.example.ac2.repositorio;

import com.example.ac2.dominio.Lutador;
import com.example.ac2.response.LutadorRespostaSimples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {

    List<Lutador> findAllByOrderByForcaGolpeDesc();

    long countAllByVivoTrue();

    @Query("select l from Lutador l where vivo = false")
    List<LutadorRespostaSimples> findByVivoFalse();
}
