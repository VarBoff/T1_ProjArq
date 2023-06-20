package com.faculdade.t1projarc.interfacesAdaptadoras.repository;

import com.faculdade.t1projarc.dominio.entity.Ocupacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IRepositoryOcupacao extends JpaRepository<Ocupacao, Long> {
    List<Ocupacao> findByRotaNomeAndData(String rotaNome, Date data);

    Optional<Ocupacao> findByRotaIdAndDataAndSlotAltitudeAndSlotHorario(Long idRota, Date date, Integer altitude, Integer slot);

    Optional<Ocupacao> findByDataAndSlotAltitudeAndSlotHorario(Date data, int slotAltitude, Integer slotTempo);
}
