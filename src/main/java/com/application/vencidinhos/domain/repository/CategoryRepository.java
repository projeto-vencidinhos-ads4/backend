package com.application.vencidinhos.domain.repository;

import com.application.vencidinhos.domain.dto.response.CategoryDto;
import com.application.vencidinhos.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new com.application.vencidinhos.domain.dto.response.CategoryDto(c.id, c.name, size(c.products) , c.client.id)" +
            " from Category c where c.client.id = :clientId")
    List<CategoryDto> findAllByClientId(@Param("clientId") Long clientId);
}
