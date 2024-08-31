package com.application.vencidinhos;

import com.application.vencidinhos.domain.entity.Category;
import com.application.vencidinhos.domain.entity.Client;
import com.application.vencidinhos.domain.entity.Product;
import com.application.vencidinhos.infrastructure.ICategoryRepository;
import com.application.vencidinhos.infrastructure.IClientRepository;
import com.application.vencidinhos.infrastructure.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class VencidinhosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VencidinhosApplication.class, args);
	}

//	IClientRepository clientRepository;
//	IProductRepository productRepository;
//	ICategoryRepository categoryRepository;
//
//	public VencidinhosApplication(IClientRepository clientRepository, IProductRepository productRepository, ICategoryRepository categoryRepository) {
//		this.clientRepository = clientRepository;
//		this.productRepository = productRepository;
//		this.categoryRepository = categoryRepository;
//
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		var cliente = this.clientRepository.save(new Client("teste","teste","teste", "teste"));
//		var categoria = this.categoryRepository.save(new Category("Secos"));
//
//		var produto = new Product(null, "Pão", categoria, 10.9,29,cliente);
//
//		this.productRepository.save(produto);
//	}
}

