package ramenGo.com.demo.infra.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import ramenGo.com.demo.domain.entities.ProteinsEntity;

public interface ProteinsRepository extends JpaRepository<ProteinsEntity,String> {
}
