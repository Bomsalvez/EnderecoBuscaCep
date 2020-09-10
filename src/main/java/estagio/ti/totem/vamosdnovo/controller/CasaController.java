package estagio.ti.totem.vamosdnovo.controller;

import estagio.ti.totem.vamosdnovo.controller.dto.CasaDTO;
import estagio.ti.totem.vamosdnovo.controller.dto.CasaFormDTO;
import estagio.ti.totem.vamosdnovo.entity.Casa;
import estagio.ti.totem.vamosdnovo.service.CasaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController@RequestMapping("/casa")
public class CasaController {
    private final CasaService casaService;
    private final ModelMapper modelMapper;

    @Autowired
    public CasaController(CasaService casaService, ModelMapper modelMapper) {
        this.casaService = casaService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CasaDTO> save(@RequestBody CasaFormDTO casa){
        return ResponseEntity.ok(modelMapper.map(casaService.saveCasa(modelMapper.map(casa, Casa.class)),CasaDTO.class));
    }
}
