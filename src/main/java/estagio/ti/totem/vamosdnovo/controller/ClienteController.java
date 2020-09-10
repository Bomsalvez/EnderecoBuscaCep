package estagio.ti.totem.vamosdnovo.controller;

import estagio.ti.totem.vamosdnovo.controller.dto.CasaFormDTO;
import estagio.ti.totem.vamosdnovo.controller.dto.ClienteDTO;
import estagio.ti.totem.vamosdnovo.controller.dto.ClienteFormDTO;
import estagio.ti.totem.vamosdnovo.entity.Casa;
import estagio.ti.totem.vamosdnovo.entity.Cliente;
import estagio.ti.totem.vamosdnovo.service.CasaService;
import estagio.ti.totem.vamosdnovo.service.ClienteService;
import estagio.ti.totem.vamosdnovo.service.ComplementoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final CasaService casaService;
    private final ClienteService clienteService;
    private final ComplementoService complementoService;
    private final ModelMapper modelMapper;

    @Autowired
    public ClienteController(ClienteService clienteService, CasaService casaService, ComplementoService complementoService, ModelMapper modelMapper) {
        this.clienteService = clienteService;
        this.casaService = casaService;
        this.complementoService = complementoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>> selectAll(Pageable pageable) {
        return ResponseEntity.ok().body(
                clienteService.selectAll(pageable).map(this::mapper));
    }


    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> selectById(@PathVariable Long idCliente) {
        return ResponseEntity.ok().body(mapper(clienteService.selectById(idCliente)));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> saveCliente(@RequestBody @Valid ClienteFormDTO clienteFormDTO, UriComponentsBuilder builder) {
        Cliente cliente = mapper(clienteFormDTO);
        for (Casa casa : clienteFormDTO.getCasas()) {
            casaService.saveCasa(casa);
        }
        atribuirCasa(clienteFormDTO, cliente);
        ClienteDTO clienteDTO = mapper(clienteService.saveCliente(cliente));
        URI uri = builder.path("/cliente/{id}").buildAndExpand(clienteDTO.getIdCliente()).toUri();
        return ResponseEntity.created(uri).body(clienteDTO);
    }

    private void atribuirCasa(ClienteFormDTO clienteFormDTO, Cliente cliente) {
        if (clienteFormDTO.getCasas() != null && !clienteFormDTO.getCasas().isEmpty()) {
            for (Casa casa : clienteFormDTO.getCasas()) {
                cliente.setCasas(casaService.selectById(casa.getIdCasa()));
            }
        }
    }


    private ClienteDTO mapper(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    private Cliente mapper(ClienteFormDTO cliente) {
        return modelMapper.map(cliente, Cliente.class);
    }
}
