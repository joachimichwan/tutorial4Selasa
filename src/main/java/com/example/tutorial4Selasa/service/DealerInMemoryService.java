package com.example.tutorial4Selasa.service;

import com.example.tutorial4Selasa.Repository.CarDB;
import com.example.tutorial4Selasa.Repository.DealerDB;
import com.example.tutorial4Selasa.model.CarModel;
import com.example.tutorial4Selasa.model.DealerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerInMemoryService implements DealerService {
    @Autowired
    private DealerDB dealerDB;

    @Autowired
    private CarDB carDB;

    @Override
    public DealerModel findById(long id) {
        List<CarModel> listCar = carDB.findByCarDealerIdOrderByPriceAsc(id);
        DealerModel dealer = dealerDB.findById(id).get();
        dealer.setCar(listCar);
        return dealer;
    }

    @Override
    public void addDealer(DealerModel dealer) {
        dealerDB.save(dealer);
    }

    @Override
    public boolean deleteDealer(long id) {
        if (dealerDB.existsById(id)) {
            dealerDB.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void updateDealer(DealerModel dealer) {
        if(dealerDB.findById(dealer.getId()) != null){
            DealerModel dealerModel = dealerDB.findById(dealer.getId()).get();
            dealerModel.setAlamat(dealer.getAlamat());
            dealerModel.setTelp(dealer.getTelp());
            dealerModel.setNama(dealer.getNama());
            dealerDB.save(dealerModel);
        }
    }

    @Override
    public List<DealerModel> findAll() { return dealerDB.findAll(); }
}
