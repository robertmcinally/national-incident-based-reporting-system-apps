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
@Table(name = "nibrs_drug_measure_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "drugMeasureTypeId")
public class NibrsDrugMeasureType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "drug_measure_type_id", nullable = false)
    private Short drugMeasureTypeId;
    @Column(name = "drug_measure_code", length = 2)
    private String drugMeasureCode;
    @Column(name = "drug_measure_name", length = 100)
    private String drugMeasureName;
    @OneToMany(mappedBy = "drugMeasureTypeId")
    private List<NibrsSuspectedDrug> nibrsSuspectedDrugList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsDrugMeasureType[" + drugMeasureTypeId + "]";
    }

}
