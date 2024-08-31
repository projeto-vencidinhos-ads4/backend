package com.application.vencidinhos.infrastructure;

import com.application.vencidinhos.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
