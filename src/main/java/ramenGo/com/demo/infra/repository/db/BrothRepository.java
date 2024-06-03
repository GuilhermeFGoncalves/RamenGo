package ramenGo.com.demo.infra.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import ramenGo.com.demo.domain.entities.BrothEntity;

public interface BrothRepository extends JpaRepository<BrothEntity,String> {
}
