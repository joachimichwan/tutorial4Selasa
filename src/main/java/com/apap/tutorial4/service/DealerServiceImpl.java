package com.apap.tutorial4.service;

import java.util.Optional;

import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.repository.DealerDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DealerServiceImpl
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService {
    @Autowired
    private DealerDb dealerDb;
 
    @Override
    public Optional<DealerModel> getDealerDetailById(Long id) {
        return dealerDb.findById(id);
    }

    @Override
    public void addDealer(DealerModel dealer) {
        dealerDb.save(dealer);
    }

    @Override
    public void deleteById(Long id) {
        dealerDb.deleteById(id);
    }
}