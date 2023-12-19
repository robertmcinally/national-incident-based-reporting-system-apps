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

@Data
@Entity
@Table(name = "ref_state", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "stateId")
public class RefState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "state_id", nullable = false)
    private Short stateId;
    @Basic(optional = false)
    @Column(name = "division_id", nullable = false)
    private short divisionId;
    @Column(name = "state_name", length = 100)
    private String stateName;
    @Column(name = "state_code", length = 2)
    private String stateCode;
    @Column(name = "state_abbr", length = 2)
    private String stateAbbr;
    @Column(name = "state_postal_abbr", length = 2)
    private String statePostalAbbr;
    @Column(name = "state_fips_code", length = 2)
    private String stateFipsCode;
    @Column(name = "state_pub_freq_months")
    private Short statePubFreqMonths;
    @Column(name = "change_user", length = 100)
    private String changeUser;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.RefState[" + stateId + "]";
    }

}
