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
import java.util.List;

@Data
@Entity
@Table(name = "nibrs_offender", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "offenderId")
public class NibrsOffender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "offender_id", nullable = false)
    private Long offenderId;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "offender_seq_num")
    private Short offenderSeqNum;
    @Column(name = "age_num", length = 3)
    private String ageNum;
    @Column(name = "sex_code")
    private Character sexCode;
    @Column(name = "age_range_low_num")
    private Short ageRangeLowNum;
    @Column(name = "age_range_high_num")
    private Short ageRangeHighNum;
    @JoinColumn(name = "age_id", referencedColumnName = "age_id")
    @ManyToOne
    private NibrsAge ageId;
    @JoinColumn(name = "ethnicity_id", referencedColumnName = "ethnicity_id")
    @ManyToOne
    private NibrsEthnicity ethnicityId;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    @ManyToOne
    private RefRace raceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffender")
    private List<NibrsVictimOffenderRel> nibrsVictimOffenderRelList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsOffender[" + offenderId + "]";
    }

}
