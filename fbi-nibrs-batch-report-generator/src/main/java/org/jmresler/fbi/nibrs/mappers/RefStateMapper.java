package org.jmresler.fbi.nibrs.mappers;

import org.jmresler.fbi.nibrs.RefState;
import org.jmresler.fbi.nibrs.dto.RefStateDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RefStateMapper {

    RefStateDTO refStateToRefStateDto(RefState refState);

}
