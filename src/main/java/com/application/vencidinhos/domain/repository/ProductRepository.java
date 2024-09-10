package com.application.vencidinhos.domain.repository;

import com.application.vencidinhos.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByClientId(Long client_id);
}
