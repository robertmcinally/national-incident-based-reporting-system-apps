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
@Table(name = "nibrs_age", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ageId")
public class NibrsAge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "age_id", nullable = false)
    private Short ageId;
    @Column(name = "age_code", length = 2)
    private String ageCode;
    @Column(name = "age_name", length = 100)
    private String ageName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageId")
    private List<NibrsArrestee> nibrsArresteeList;
    @OneToMany(mappedBy = "ageId")
    private List<NibrsOffender> nibrsOffenderList;
    @OneToMany(mappedBy = "ageId")
    private List<NibrsVictim> nibrsVictimList;

    @Override
    public String toString() {
        return "org.jmresler.fbi.nibrs.NibrsAge[" + ageId + "]";
    }

}
