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
@Table(name = "nibrs_cleared_except", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "clearedExceptId")
public class NibrsClearedExcept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cleared_except_id", nullable = false)
    private Short clearedExceptId;
    @Column(name = "cleared_except_code")
    private Character clearedExceptCode;
    @Column(name = "cleared_except_name", length = 100)
    private String clearedExceptName;
    @Column(name = "cleared_except_desc", length = 300)
    private String clearedExceptDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clearedExceptId")
    private List<NibrsIncident> nibrsIncidentList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsClearedExcept[" + clearedExceptId + "]";
    }

}
