package estagio.ti.totem.vamosdnovo.repository;

import estagio.ti.totem.vamosdnovo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
