package org.jmresler.fbi.nibrs.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.jmresler.fbi.nibrs.Agencies;
import org.jmresler.fbi.nibrs.dao.AgenciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.jmresler.fbi.nibrs.util.AppConstants.EMPTY_AGENCY;

@Slf4j
@Service
public class AgenciesService {

    @Autowired
    protected AgenciesRepository agenciesRepository;


    @Transactional
    public Agencies getAgenciesById(final long agencyId) {
        var agencies = agenciesRepository.findById(agencyId).orElse(EMPTY_AGENCY);
        agencies.getNibrsIncidentList().forEach(incident -> {
            log.debug(incident.toString());
        });
        agencies.getNibrsMonthList().forEach(month -> {
            log.debug(month.toString());
        });

        return agencies;
    }

    public List<Agencies> getSelectedAgencies(Set<Integer> ids) {
        return agenciesRepository.findAgenciesByAgencyIdIn(ids);
    }
}
