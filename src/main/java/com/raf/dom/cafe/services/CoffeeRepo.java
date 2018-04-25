package com.raf.dom.cafe.services;

import com.raf.dom.cafe.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepo extends JpaRepository<Coffee,Long> {

    Coffee findByName(String name);
    void deleteById(Long id);
}
