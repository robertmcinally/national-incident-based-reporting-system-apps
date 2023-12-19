package org.jmresler.fbi.nibrs.services;

import org.jmresler.fbi.nibrs.NibrsMonth;
import org.jmresler.fbi.nibrs.dao.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthService {

    @Autowired
    protected MonthRepository repository;

    public List<NibrsMonth> getAllMonths() {
        return repository.findAll();
    }

}
