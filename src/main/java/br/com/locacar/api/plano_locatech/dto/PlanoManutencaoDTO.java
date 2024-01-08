package br.com.locacar.api.plano_locatech.dto;

import br.com.locacar.api.plano_locatech.entities.Inspetor;
import br.com.locacar.api.plano_locatech.entities.Item;
import br.com.locacar.api.plano_locatech.entities.Veiculo;

import java.util.List;

public record PlanoManutencaoDTO(
        Long numero,
        Inspetor inspetor,
        Veiculo veiculo,
        List<Item> itens
) {
}
