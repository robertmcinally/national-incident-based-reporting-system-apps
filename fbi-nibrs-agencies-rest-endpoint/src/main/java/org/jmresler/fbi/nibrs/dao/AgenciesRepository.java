package org.jmresler.fbi.nibrs.dao;

import org.jmresler.fbi.nibrs.Agencies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AgenciesRepository extends JpaRepository<Agencies, Long> {

    List<Agencies> findAgenciesByAgencyIdIn(Set<Integer> ids);
}
