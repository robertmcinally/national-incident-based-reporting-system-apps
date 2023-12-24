/*
 * Copyright 2023 jmres.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmresler.fbi.nibrs.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author John M. Resler
 * @version 1.0.0
 */
@Data
public class NibrsOffenseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long offenseId;
    private Integer dataYear;
    private Character attemptCompleteFlag;
    private Short numPremisesEntered;
    private Character methodEntryCode;
    private NibrsIncidentDTO incidentId;
    private NibrsLocationTypeDTO locationId;
    private NibrsOffenseTypeDTO offenseCode;
    private List<NibrsVictimOffenseDTO> nibrsVictimOffenseList;
    private List<NibrsWeaponDTO> nibrsWeaponList;
    private List<NibrsCriminalActDTO> nibrsCriminalActList;
    private List<NibrsBiasMotivationDTO> nibrsBiasMotivationList;
    private List<NibrsSuspectUsingDTO> nibrsSuspectUsingList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.dto.NibrsOffenseDTO[" + offenseId + "]";
    }

}
