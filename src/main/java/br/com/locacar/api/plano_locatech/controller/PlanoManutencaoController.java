package br.com.locacar.api.plano_locatech.controller;

import br.com.locacar.api.plano_locatech.dto.PlanoManutencaoDTO;
import br.com.locacar.api.plano_locatech.service.PlanoManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manutencao/plano")
public class PlanoManutencaoController {
    private final PlanoManutencaoService planoManutencaoService;

    @Autowired
    public PlanoManutencaoController(PlanoManutencaoService planoManutencaoService) {
        this.planoManutencaoService = planoManutencaoService;
    }

    @GetMapping
    public ResponseEntity<Page<PlanoManutencaoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "numero")Pageable pageable) {
        Page<PlanoManutencaoDTO> planosManutencaoDTO = planoManutencaoService.findAll(pageable);
        return ResponseEntity.ok(planosManutencaoDTO);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<PlanoManutencaoDTO> findById(@PathVariable Long numero) {
        PlanoManutencaoDTO planoManutencaoDTO = planoManutencaoService.findById(numero);
        return ResponseEntity.ok(planoManutencaoDTO);
    }

    @PostMapping
    public ResponseEntity<PlanoManutencaoDTO> save(@RequestBody PlanoManutencaoDTO planoManutencaoDTO) {
        PlanoManutencaoDTO savedPlanoManutencaoDTO = planoManutencaoService.save(planoManutencaoDTO);
        return new ResponseEntity<>(savedPlanoManutencaoDTO, HttpStatus.CREATED);
    }
    @PutMapping("/{numero}")
    public ResponseEntity<PlanoManutencaoDTO> elaboraPlano(
            @PathVariable Long numero,
            @RequestBody PlanoManutencaoDTO planoManutencaoDTO
    ) {
        PlanoManutencaoDTO updatedPlanoManutencaoDTO = planoManutencaoService.elaboraPlano(numero, planoManutencaoDTO);
        return ResponseEntity.ok(updatedPlanoManutencaoDTO);
    }

    @DeleteMapping("/encerraplano/{numero}")
    public ResponseEntity<Void> encerraPlano (@PathVariable Long numero) {
        planoManutencaoService.encerraPlano(numero);
        return ResponseEntity.noContent().build();
    }
}
