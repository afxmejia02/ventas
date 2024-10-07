package com.software.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.software.ventas.entity.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}