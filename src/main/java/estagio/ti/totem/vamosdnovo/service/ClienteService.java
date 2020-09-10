package estagio.ti.totem.vamosdnovo.service;

import estagio.ti.totem.vamosdnovo.config.exception.NotFound;
import estagio.ti.totem.vamosdnovo.entity.Cliente;
import estagio.ti.totem.vamosdnovo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Page<Cliente> selectAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente selectById(Long idCliente) {
        return clienteRepository.findById(idCliente).orElseThrow(() -> new NotFound("Falhou"));
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
