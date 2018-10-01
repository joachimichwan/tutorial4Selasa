package com.example.tutorial4Selasa.service;

import com.example.tutorial4Selasa.model.DealerModel;

import java.util.List;

public interface DealerService {
    DealerModel findById (long id);
    void addDealer(DealerModel dealer);
    boolean deleteDealer(long id);
    void updateDealer(DealerModel dealer);
    List<DealerModel> findAll();
}
