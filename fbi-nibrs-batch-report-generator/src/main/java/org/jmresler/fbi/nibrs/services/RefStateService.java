package org.jmresler.fbi.nibrs.services;

import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.RefState;
import org.jmresler.fbi.nibrs.dao.RefStateRepository;
import org.jmresler.fbi.nibrs.dto.RefStateDTO;
import org.jmresler.fbi.nibrs.mappers.RefStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RefStateService {

    protected RefStateRepository repository;
    protected RefStateMapper mapper;

    @Autowired
    public RefStateService(
            RefStateRepository repository,
            final RefStateMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public List<RefStateDTO> findAllRefStates() {
        var dtos = new ArrayList<RefStateDTO>();
        var entities = repository.findAll();
        entities.forEach(entity -> {
            dtos.add(mapper.refStateToRefStateDto(entity));
        });

        return dtos;
    }

}
