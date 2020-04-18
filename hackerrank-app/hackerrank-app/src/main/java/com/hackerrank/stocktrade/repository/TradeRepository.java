package com.hackerrank.stocktrade.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackerrank.eshopping.product.dashboard.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Trade, Long> {

}