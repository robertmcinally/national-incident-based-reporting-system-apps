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

/**
 * activty_type_code,activity_type_name
 * 01 = Responding to Disturbance Call  (family quarrels, person with firearm, etc.)
 * 02 = Burglaries in Progress or Pursuing Burglary Suspects
 * 03 = Robberies in Progress or Pursuing Robbery Suspects
 * 04 = Attempting Other Arrests
 * 05 = Civil Disorder (riot, mass disobedience)
 * 06 = Handling, Transporting, Custody of Prisoners
 * 07 = Investigating Suspicious Persons or Circumstances
 * 08 = Ambush, No Warning
 * 09 = Handling Persons with Mental Illness
 * 10 = Traffic Pursuits and Stops
 * 11 = All Other
 */
@Data
@Entity
@Table(name = "nibrs_activity_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "activityTypeId")
public class NibrsActivityType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "activity_type_id", nullable = false)
    private Short activityTypeId;
    @Column(name = "activity_type_code", length = 2)
    private String activityTypeCode;
    @Column(name = "activity_type_name", length = 100)
    private String activityTypeName;
    @OneToMany(mappedBy = "activityTypeId")
    private List<NibrsVictim> nibrsVictimList;

    @Override
    public String toString() {
        return "org.jmresler.fbi.nibrs.NibrsActivityType[" + activityTypeId + "]";
    }
}
