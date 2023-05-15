package com.dev.trabProjarq.InterfacesAdaptadoras.Repositorios;

import com.dev.trabProjarq.dominio.entities.OcupacaoAerovia;
import com.dev.trabProjarq.dominio.entities.PlanoDeVoo;
import com.dev.trabProjarq.dominio.services.IOcupacaoAeroviaRep;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioOcupacaoAerovia implements IOcupacaoAeroviaRep {
	private IOcupacaoAeroviaCrud ocupacaoAeroviaCrud;

	@Autowired
	public RepositorioOcupacaoAerovia(IOcupacaoAeroviaCrud ocupacaoAeroviaCrud) {
		this.ocupacaoAeroviaCrud = ocupacaoAeroviaCrud;
	}

	@Override
	public List<OcupacaoAerovia> findOcupadasSlots(int aeroviaId, LocalDate data, List<Integer> slotsHorarios) {
		return ocupacaoAeroviaCrud.findAll().stream()
		.filter(oa -> oa.aerovia.id == aeroviaId)
		.filter(oa -> oa.data.equals(data))
		.filter(oa -> slotsHorarios.contains(oa.slot_horario))
		.collect(Collectors.toList());
	}

	@Override
	public OcupacaoAerovia ocupa(OcupacaoAerovia ocupacaoAerovia){
		return ocupacaoAeroviaCrud.save(ocupacaoAerovia);
	}

	@Override
	public void removeOcupacao(OcupacaoAerovia ocupacaoAerovia) {
		this.ocupacaoAeroviaCrud.delete(ocupacaoAerovia);
	}

	@Override
	public List<OcupacaoAerovia> findAllOcupacaoAeroviasByData(int aeroviaId, LocalDate data){
		return ocupacaoAeroviaCrud.findAll().stream().filter(oa -> oa.aerovia.id == aeroviaId)
		.filter(oa -> oa.data.equals(data))
		.collect(Collectors.toList());
	}
}
