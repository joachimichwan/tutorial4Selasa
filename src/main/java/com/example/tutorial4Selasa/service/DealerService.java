package com.example.tutorial4Selasa.service;

import com.example.tutorial4Selasa.model.DealerModel;

import java.util.List;
import java.util.Optional;

public interface DealerService {
    Optional<DealerModel> findById (long id);
    void addDealer(DealerModel dealer);
    boolean deleteDealer(long id);
    void updateDealer(DealerModel dealer);
    List<DealerModel> findAll();
}
