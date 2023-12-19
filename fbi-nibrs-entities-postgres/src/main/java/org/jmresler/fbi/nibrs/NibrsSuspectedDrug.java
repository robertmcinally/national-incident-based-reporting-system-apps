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
@Table(name = "nibrs_suspected_drug", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsSuspectedDrugId")
public class NibrsSuspectedDrug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nibrs_suspected_drug_id", nullable = false)
    private Long nibrsSuspectedDrugId;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "est_drug_qty", precision = 17)
    private Double estDrugQty;
    @JoinColumn(name = "drug_measure_type_id", referencedColumnName = "drug_measure_type_id")
    @ManyToOne
    private NibrsDrugMeasureType drugMeasureTypeId;
    @JoinColumn(name = "property_id", referencedColumnName = "property_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsProperty propertyId;
    @JoinColumn(name = "suspected_drug_type_id", referencedColumnName = "suspected_drug_type_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsSuspectedDrugType suspectedDrugTypeId;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsSuspectedDrug[" + nibrsSuspectedDrugId + "]";
    }

}
