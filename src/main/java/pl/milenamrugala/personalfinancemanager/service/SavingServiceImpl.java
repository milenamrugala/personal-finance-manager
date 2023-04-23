package pl.milenamrugala.personalfinancemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.milenamrugala.personalfinancemanager.dao.SavingDao;
import pl.milenamrugala.personalfinancemanager.entity.Saving;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SavingServiceImpl implements SavingService {

    private SavingDao savingDao;

    @Autowired
    public SavingServiceImpl(SavingDao savingDao) {
        this.savingDao = savingDao;
    }


    @Override
    public List<Saving> findAll() {
        return savingDao.findAll();
    }

    @Override
    public Saving findById(Long id) {
        return savingDao.findById(id);
    }

    @Transactional
    @Override
    public Saving save(Saving saving) {
        return savingDao.save(saving);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        savingDao.deleteById(id);

    }
}
