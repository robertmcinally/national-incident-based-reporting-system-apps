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
import java.util.Date;

@Data
@Entity
@Table(name = "nibrs_property_desc", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsPropertyDescPK")
public class NibrsPropertyDesc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsPropertyDescPK nibrsPropertyDescPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "property_value")
    private BigInteger propertyValue;
    @Column(name = "date_recovered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRecovered;
    @Column(name = "nibrs_prop_desc_id")
    private BigInteger nibrsPropDescId;
    @JoinColumn(name = "prop_desc_id", referencedColumnName = "prop_desc_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsPropDescType nibrsPropDescType;
    @JoinColumn(name = "property_id", referencedColumnName = "property_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsProperty nibrsProperty;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsPropertyDesc[...]";
    }

}
