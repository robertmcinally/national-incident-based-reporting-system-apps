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
@Table(name = "nibrs_offense", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "offenseId")
public class NibrsOffense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "offense_id", nullable = false)
    private Long offenseId;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "attempt_complete_flag")
    private Character attemptCompleteFlag;
    @Column(name = "num_premises_entered")
    private Short numPremisesEntered;
    @Column(name = "method_entry_code")
    private Character methodEntryCode;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsLocationType locationId;
    @JoinColumn(name = "offense_code", referencedColumnName = "offense_code", nullable = false)
    @ManyToOne(optional = false)
    private NibrsOffenseType offenseCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private List<NibrsVictimOffense> nibrsVictimOffenseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private List<NibrsWeapon> nibrsWeaponList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private List<NibrsCriminalAct> nibrsCriminalActList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private List<NibrsBiasMotivation> nibrsBiasMotivationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsOffense")
    private List<NibrsSuspectUsing> nibrsSuspectUsingList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsOffense[" + offenseId + "]";
    }

}
