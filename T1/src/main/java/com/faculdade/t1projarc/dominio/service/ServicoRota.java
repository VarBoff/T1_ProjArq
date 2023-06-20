package com.faculdade.t1projarc.dominio.service;

import com.faculdade.t1projarc.interfacesAdaptadoras.dto.SlotDTO;
import com.faculdade.t1projarc.dominio.entity.Ocupacao;
import com.faculdade.t1projarc.dominio.entity.Rota;
import com.faculdade.t1projarc.interfacesAdaptadoras.repository.IRepositoryOcupacao;
import com.faculdade.t1projarc.interfacesAdaptadoras.repository.IRepositoryRotas;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServicoRota {

    private IRepositoryRotasCRUD repositoryRotas;
    private IRepositoryOcupacaoCRUD repositoryOcupacao;

    private List<Integer> listaAltitudes =  new ArrayList<>(Arrays.asList(25000, 26000, 27000, 28000, 29000, 30000, 31000, 32000, 33000, 34000));

    public ServicoRota(IRepositoryRotasCRUD repositoryRotas, IRepositoryOcupacaoCRUD repositoryOcupacao) {
        this.repositoryRotas = repositoryRotas;
        this.repositoryOcupacao = repositoryOcupacao;
    }

    public List<Rota> listaRotasEncontradas(String origem, String destino) {
        List<Rota> rotasEncontradas = repositoryRotas.findAll().stream()
                .filter(rota -> rota.getOrigem().getNome().equals(origem) && rota.getDestino().getNome().equals(destino))
                .collect(Collectors.toList());

        return rotasEncontradas;
    }


    public List<SlotDTO> slotsLivres(String nomeRota, Date date) {
        // Recebe os parâmetros da requisição

        // Converte a data para o formato desejado
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = dateFormat.format(date);

        // Converte o horário para o formato desejado
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String horarioStr = timeFormat.format(date);

        // Encontra a rota pelo ID fornecido
        Optional<Rota> rota = getRotaByNome(nomeRota);

        if (rota.isPresent()) {
            // Filtra as ocupações pelo nome da rota e data
            List<Ocupacao> ocupacoesDia = repositoryOcupacao.findByRotaNomeAndData(nomeRota, date);

            // Cria uma lista com todos os slots disponíveis para cada altitude
            List<SlotDTO> slotsLivres = new ArrayList<>();
            for (Integer altitude : listaAltitudes) {
                for (int i = 0; i < 24; i++) {
                    slotsLivres.add(new SlotDTO(altitude, i));
                }
            }

            // Remove os slots ocupados da lista de slots disponíveis
            for (Ocupacao ocupacao : ocupacoesDia) {
                String ocupacaoHorarioStr = timeFormat.format(ocupacao.getData());
                if (horarioStr.equals(ocupacaoHorarioStr)) {
                    slotsLivres.removeIf(slot -> slot.getAltitude().equals(ocupacao.getSlotAltitude()) && slot.getSlot().equals(ocupacao.getSlotHorario()));
                }
            }

            return slotsLivres;
        }

        return Collections.emptyList(); // Retorna uma lista vazia se a rota não for encontrada
    }

    public void ocupa(Long idRota, Date date,Integer altitude, Integer slotHorario){
        Ocupacao ocupacao = Ocupacao.builder().data(date).slotAltitude(altitude).slotHorario(slotHorario)
                .build();
        repositoryOcupacao.save(ocupacao);
    }

    public void libera(Long idRota, Date date, Integer altitude, List<Integer> slots){

        List<Ocupacao> ocupacoes = new ArrayList<Ocupacao>();

        for (Integer slot : slots) {
            Optional<Ocupacao> ocupacao= repositoryOcupacao
                    .findByRotaIdAndDataAndSlotAltitudeAndSlotHorario(idRota,date,altitude,slot);

            ocupacao.ifPresent(ocupacoes::add);
        }

        if(ocupacoes.size()==0){
            throw new IllegalArgumentException();
        }
    }

    public Optional<Rota> getRotaByNome(String nomeRota) {
        return repositoryRotas.findByNome(nomeRota);
    }
}
