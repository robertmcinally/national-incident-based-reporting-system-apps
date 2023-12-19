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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class AgenciesDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer yearlyAgencyId;
    private Integer agencyId;
    private Integer dataYear;
    private String ori;
    private String legacyOri;
    private String coveredByLegacyOri;
    private String directContributorFlag;
    private String dormantFlag;
    private Integer dormantYear;
    private String reportingType;
    private String ucrAgencyName;
    private String ncicAgencyName;
    private String pubAgencyName;
    private String pubAgencyUnit;
    private String agencyStatus;
    private Integer stateId;
    private String stateName;
    private String stateAbbr;
    private String statePostalAbbr;
    private Integer divisionCode;
    private String divisionName;
    private Integer regionCode;
    private String regionName;
    private String regionDesc;
    private String agencyTypeName;
    private Integer population;
    private Integer submittingAgencyId;
    private String sai;
    private String submittingAgencyName;
    private String suburbanAreaFlag;
    private Integer populationGroupId;
    private String populationGroupCode;
    private String populationGroupDesc;
    private Integer parentPopGroupCode;
    private String parentPopGroupDesc;
    private String mipFlag;
    private Integer popSortOrder;
    private String summaryRapeDef;
    private String peReportedFlag;
    private Integer maleOfficer;
    private Integer maleCivilian;
    private Integer maleTotal;
    private Integer femaleOfficer;
    private Integer femaleCivilian;
    private Integer femaleTotal;
    private BigDecimal officerRate;
    private BigDecimal employeeRate;
    private Date nibrsCertDate;
    private Date nibrsStartDate;
    private Date nibrsLeokaStartDate;
    private Date nibrsCtStartDate;
    private Date nibrsMultiBiasStartDate;
    private Date nibrsOffEthStartDate;
    private String coveredFlag;
    private String countyName;
    private String msaName;
    private String publishableFlag;
    private String participated;
    private String nibrsParticipated;
    private List<NibrsMonthDTO> nibrsMonthDTOList;
    private List<NibrsIncidentDTO> nibrsIncidentDTOList;

    @Override
    public String toString() {
        return "org.jmresler.fbi.nibrs.dto.Agencies[" + agencyId + "]";
    }
}
