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
import java.math.BigInteger;
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_victim", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "victimId")
public class NibrsVictim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "victim_id", nullable = false)
    private Long victimId;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "victim_seq_num")
    private Short victimSeqNum;
    @Column(name = "outside_agency_id")
    private BigInteger outsideAgencyId;
    @Column(name = "age_num", length = 2)
    private String ageNum;
    @Column(name = "sex_code")
    private Character sexCode;
    @Column(name = "resident_status_code")
    private Character residentStatusCode;
    @Column(name = "age_range_low_num")
    private Short ageRangeLowNum;
    @Column(name = "age_range_high_num")
    private Short ageRangeHighNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private List<NibrsVictimOffense> nibrsVictimOffenseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private List<NibrsVictimCircumstances> nibrsVictimCircumstancesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private List<NibrsVictimInjury> nibrsVictimInjuryList;
    @JoinColumn(name = "activity_type_id", referencedColumnName = "activity_type_id")
    @ManyToOne
    private NibrsActivityType activityTypeId;
    @JoinColumn(name = "age_id", referencedColumnName = "age_id")
    @ManyToOne
    private NibrsAge ageId;
    @JoinColumn(name = "assignment_type_id", referencedColumnName = "assignment_type_id")
    @ManyToOne
    private NibrsAssignmentType assignmentTypeId;
    @JoinColumn(name = "ethnicity_id", referencedColumnName = "ethnicity_id")
    @ManyToOne
    private NibrsEthnicity ethnicityId;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "victim_type_id", referencedColumnName = "victim_type_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsVictimType victimTypeId;
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    @ManyToOne
    private RefRace raceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsVictim")
    private List<NibrsVictimOffenderRel> nibrsVictimOffenderRelList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsVictim[" + victimId + "]";
    }

}
