package com.apap.tutorial4.repository;

import java.util.List;

import com.apap.tutorial4.model.CarModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CarDb
 */
@Repository
public interface CarDb extends JpaRepository<CarModel, Long> {
    CarModel findByType(String type);

    long deleteByType(String type);

    List<CarModel> findByDealerIdOrderByPriceAsc(Long dealerId);
}