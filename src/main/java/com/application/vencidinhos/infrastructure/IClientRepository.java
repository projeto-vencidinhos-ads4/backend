package com.application.vencidinhos.infrastructure;

import com.application.vencidinhos.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
