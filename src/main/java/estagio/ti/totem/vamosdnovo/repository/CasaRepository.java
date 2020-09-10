package estagio.ti.totem.vamosdnovo.repository;

import estagio.ti.totem.vamosdnovo.entity.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Long> {
}
