package com.aprender.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprender.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{}