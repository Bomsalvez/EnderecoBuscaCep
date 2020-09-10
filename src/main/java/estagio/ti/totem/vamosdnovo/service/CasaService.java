package estagio.ti.totem.vamosdnovo.service;

import estagio.ti.totem.vamosdnovo.config.exception.NotFound;
import estagio.ti.totem.vamosdnovo.entity.Casa;
import estagio.ti.totem.vamosdnovo.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CasaService {
    private final CasaRepository casaRepository;

    @Autowired
    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    public Casa saveCasa( Casa casa) {
        return casaRepository.save(casa);
    }

    public Casa selectById(Long idCasa) {
        return casaRepository.findById(idCasa).orElseThrow(() -> new NotFound("Casa"));
    }
}
