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

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author John M. Resler
 * @version 1.0.0
 */

@Data
@Entity
@Table(name = "nibrs_arrestee")
public class NibrsArrestee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "arrestee_id", nullable = false)
    private Long arresteeId;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "arrestee_seq_num")
    private BigInteger arresteeSeqNum;
    @Column(name = "arrest_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrestDate;
    @Column(name = "multiple_indicator")
    private Character multipleIndicator;
    @Column(name = "age_num")
    private Short ageNum;
    @Column(name = "sex_code")
    private Character sexCode;
    @Column(name = "resident_code")
    private Character residentCode;
    @Column(name = "under_18_disposition_code")
    private Character under18DispositionCode;
    @Column(name = "clearance_ind")
    private Character clearanceInd;
    @Column(name = "age_range_low_num")
    private Short ageRangeLowNum;
    @Column(name = "age_range_high_num")
    private Short ageRangeHighNum;
    @JoinColumn(name = "age_id", referencedColumnName = "age_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsAge ageId;
    @JoinColumn(name = "arrest_type_id", referencedColumnName = "arrest_type_id")
    @ManyToOne
    private NibrsArrestType arrestTypeId;
    @JoinColumn(name = "ethnicity_id", referencedColumnName = "ethnicity_id")
    @ManyToOne
    private NibrsEthnicity ethnicityId;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "offense_code", referencedColumnName = "offense_code", nullable = false)
    @ManyToOne(optional = false)
    private NibrsOffenseType offenseCode;
    @JoinColumn(name = "race_id", referencedColumnName = "race_id", nullable = false)
    @ManyToOne(optional = false)
    private RefRace raceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsArrestee")
    private List<NibrsArresteeWeapon> nibrsArresteeWeaponList;

    @Override
    public String toString() {
        return "org.jmresler.fbi.nibrs.NibrsArrestee[" + arresteeId + "]";
    }

}
