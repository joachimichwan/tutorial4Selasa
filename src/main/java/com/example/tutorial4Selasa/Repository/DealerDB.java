package com.example.tutorial4Selasa.Repository;

import com.example.tutorial4Selasa.model.DealerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealerDB extends JpaRepository<DealerModel, Long> {

}