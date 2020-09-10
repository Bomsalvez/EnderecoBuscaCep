package estagio.ti.totem.vamosdnovo.service;

import estagio.ti.totem.vamosdnovo.entity.Complemento;
import estagio.ti.totem.vamosdnovo.repository.ComplementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplementoService {
    private final ComplementoRepository complementoRepository;

    @Autowired
    public ComplementoService(ComplementoRepository complementoRepository) {
        this.complementoRepository = complementoRepository;
    }

    public Complemento saveComplemento(Complemento complemento) {
        return complementoRepository.save(complemento);
    }
}
