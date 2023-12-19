package org.jmresler.fbi.nibrs.dao;

import org.jmresler.fbi.nibrs.NibrsMonth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthRepository extends JpaRepository<NibrsMonth, Long> {
}
