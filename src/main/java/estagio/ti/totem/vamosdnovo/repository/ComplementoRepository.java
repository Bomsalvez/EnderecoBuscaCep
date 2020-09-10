package estagio.ti.totem.vamosdnovo.repository;

import estagio.ti.totem.vamosdnovo.entity.Complemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplementoRepository extends JpaRepository<Complemento, Long> {
}
