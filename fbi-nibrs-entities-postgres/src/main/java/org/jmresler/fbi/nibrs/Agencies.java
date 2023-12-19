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
package org.jmresler.fbi.nibrs;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "agencies", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "agencyId")
public class Agencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "agency_id", nullable = false)
    private Integer agencyId;
    @Column(name = "yearly_agency_id")
    private Integer yearlyAgencyId;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "ori", length = 25)
    private String ori;
    @Column(name = "legacy_ori", length = 25)
    private String legacyOri;
    @Column(name = "covered_by_legacy_ori", length = 25)
    private String coveredByLegacyOri;
    @Column(name = "direct_contributor_flag", length = 1)
    private String directContributorFlag;
    @Column(name = "dormant_flag", length = 1)
    private String dormantFlag;
    @Column(name = "dormant_year")
    private Integer dormantYear;
    @Column(name = "reporting_type", length = 1)
    private String reportingType;
    @Column(name = "ucr_agency_name", length = 100)
    private String ucrAgencyName;
    @Column(name = "ncic_agency_name", length = 100)
    private String ncicAgencyName;
    @Column(name = "pub_agency_name", length = 100)
    private String pubAgencyName;
    @Column(name = "pub_agency_unit", length = 100)
    private String pubAgencyUnit;
    @Column(name = "agency_status", length = 1)
    private String agencyStatus;
    @Column(name = "state_id")
    private Integer stateId;
    @Column(name = "state_name", length = 100)
    private String stateName;
    @Column(name = "state_abbr", length = 2)
    private String stateAbbr;
    @Column(name = "state_postal_abbr", length = 2)
    private String statePostalAbbr;
    @Column(name = "division_code")
    private Integer divisionCode;
    @Column(name = "division_name", length = 100)
    private String divisionName;
    @Column(name = "region_code")
    private Integer regionCode;
    @Column(name = "region_name", length = 100)
    private String regionName;
    @Column(name = "region_desc", length = 100)
    private String regionDesc;
    @Column(name = "agency_type_name", length = 100)
    private String agencyTypeName;
    @Column(name = "population")
    private Integer population;
    @Column(name = "submitting_agency_id")
    private Integer submittingAgencyId;
    @Column(name = "sai", length = 25)
    private String sai;
    @Column(name = "submitting_agency_name", length = 200)
    private String submittingAgencyName;
    @Column(name = "suburban_area_flag", length = 1)
    private String suburbanAreaFlag;
    @Column(name = "population_group_id")
    private Integer populationGroupId;
    @Column(name = "population_group_code", length = 2)
    private String populationGroupCode;
    @Column(name = "population_group_desc", length = 100)
    private String populationGroupDesc;
    @Column(name = "parent_pop_group_code")
    private Integer parentPopGroupCode;
    @Column(name = "parent_pop_group_desc", length = 100)
    private String parentPopGroupDesc;
    @Column(name = "mip_flag", length = 1)
    private String mipFlag;
    @Column(name = "pop_sort_order")
    private Integer popSortOrder;
    @Column(name = "summary_rape_def", length = 1)
    private String summaryRapeDef;
    @Column(name = "pe_reported_flag", length = 1)
    private String peReportedFlag;
    @Column(name = "male_officer")
    private Integer maleOfficer;
    @Column(name = "male_civilian")
    private Integer maleCivilian;
    @Column(name = "male_total")
    private Integer maleTotal;
    @Column(name = "female_officer")
    private Integer femaleOfficer;
    @Column(name = "female_civilian")
    private Integer femaleCivilian;
    @Column(name = "female_total")
    private Integer femaleTotal;
    @Column(name = "officer_rate")
    private BigDecimal officerRate;
    @Column(name = "employee_rate")
    private BigDecimal employeeRate;
    @Column(name = "nibrs_cert_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsCertDate;
    @Column(name = "nibrs_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsStartDate;
    @Column(name = "nibrs_leoka_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsLeokaStartDate;
    @Column(name = "nibrs_ct_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsCtStartDate;
    @Column(name = "nibrs_multi_bias_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsMultiBiasStartDate;
    @Column(name = "nibrs_off_eth_start_date")
    @Temporal(TemporalType.DATE)
    private Date nibrsOffEthStartDate;
    @Column(name = "covered_flag", length = 1)
    private String coveredFlag;
    @Column(name = "county_name", length = 100)
    private String countyName;
    @Column(name = "msa_name", length = 100)
    private String msaName;
    @Column(name = "publishable_flag", length = 1)
    private String publishableFlag;
    @Column(name = "participated", length = 1)
    private String participated;
    @Column(name = "nibrs_participated", length = 1)
    private String nibrsParticipated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencyId")
    private List<NibrsMonth> nibrsMonthList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencyId")
    private List<NibrsIncident> nibrsIncidentList;

    @Override
    public String toString() {
        return "org.jmresler.fbi.nibrs.Agencies[" + agencyId + "]";
    }
}
