package com.aprender.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprender.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{}