package br.com.locacar.api.plano_locatech.service;

import br.com.locacar.api.plano_locatech.controller.exception.ControllerNotFoundException;
import br.com.locacar.api.plano_locatech.dto.PlanoManutencaoDTO;
import br.com.locacar.api.plano_locatech.entities.PlanoManutencao;
import br.com.locacar.api.plano_locatech.repository.PlanoManutencaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlanoManutencaoService {
    private final PlanoManutencaoRepository planoManutencaoRepository;

    @Autowired
    public PlanoManutencaoService(PlanoManutencaoRepository planoManutencaoRepository) {
        this.planoManutencaoRepository = planoManutencaoRepository;
    }

    public Page<PlanoManutencaoDTO> findAll(Pageable pageable) {
        Page<PlanoManutencao> planosManutencao = planoManutencaoRepository.findAll(pageable);
        return planosManutencao.map(this::toDTO);
    }

    public PlanoManutencaoDTO findById(Long numero) {
        PlanoManutencao planoManutencao = planoManutencaoRepository.findById(numero).
                orElseThrow(() -> new ControllerNotFoundException("Plano de Manutenção não encontrado"));
        return toDTO(planoManutencao);
    }

    public PlanoManutencaoDTO save(PlanoManutencaoDTO planoManutencaoDTO) {
        PlanoManutencao planoManutencao = toEntity(planoManutencaoDTO);
        planoManutencao = planoManutencaoRepository.save(planoManutencao);
        return  toDTO(planoManutencao);
    }

    public PlanoManutencaoDTO elaboraPlano(Long numero, PlanoManutencaoDTO planoManutencaoDTO) {
        return update(numero, planoManutencaoDTO);
    }

    public PlanoManutencaoDTO update(Long numero, PlanoManutencaoDTO planoManutencaoDTO) {
        try {
            PlanoManutencao planoManutencao = planoManutencaoRepository.getReferenceById(numero);
            planoManutencao.setInspetor(planoManutencaoDTO.inspetor());
            planoManutencao.setVeiculo(planoManutencaoDTO.veiculo());
            planoManutencao.setItens(planoManutencaoDTO.itens());
            planoManutencao = planoManutencaoRepository.save(planoManutencao);
            return toDTO(planoManutencao);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Plano de Manutenção não encontrado");
        }
    }

    public void encerraPlano(Long numero) {
        delete(numero);
    }

    public void delete(Long numero) {
        planoManutencaoRepository.deleteById(numero);
        return;
    }

    private PlanoManutencao toEntity(PlanoManutencaoDTO planoManutencaoDTO) {
        return new PlanoManutencao(
                planoManutencaoDTO.numero(),
                planoManutencaoDTO.inspetor(),
                planoManutencaoDTO.veiculo(),
                planoManutencaoDTO.itens()
        );
    }

    private PlanoManutencaoDTO toDTO(PlanoManutencao planoManutencao) {
        return new PlanoManutencaoDTO(
                planoManutencao.getNumero(),
                planoManutencao.getInspetor(),
                planoManutencao.getVeiculo(),
                planoManutencao.getItens()
        );
    }



}
