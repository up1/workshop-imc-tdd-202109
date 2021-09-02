package com.example.myapi.product;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.*;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
