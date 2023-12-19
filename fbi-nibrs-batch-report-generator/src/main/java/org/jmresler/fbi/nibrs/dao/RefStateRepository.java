package org.jmresler.fbi.nibrs.dao;

import org.jmresler.fbi.nibrs.RefState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefStateRepository extends JpaRepository<RefState, Short> {
}
