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
import java.util.List;

/**
 *
 * @author John M. Resler
 * @version 1.0.0
 */
@Data
@Entity
@Table(name = "nibrs_property")
public class NibrsProperty implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "property_id", nullable = false)
    private Long propertyId;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "stolen_count")
    private Short stolenCount;
    @Column(name = "recovered_count")
    private Short recoveredCount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsProperty")
    private List<NibrsPropertyDesc> nibrsPropertyDescList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private List<NibrsSuspectedDrug> nibrsSuspectedDrugList;
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsIncident incidentId;
    @JoinColumn(name = "prop_loss_id", referencedColumnName = "prop_loss_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsPropLossType propLossId;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsProperty[" + propertyId + "]";
    }

}
