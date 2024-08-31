package com.application.vencidinhos.infrastructure;

import com.application.vencidinhos.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
