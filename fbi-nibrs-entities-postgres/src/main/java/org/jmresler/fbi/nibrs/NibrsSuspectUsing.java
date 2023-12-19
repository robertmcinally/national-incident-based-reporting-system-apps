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
@Table(name = "nibrs_suspect_using", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nibrsSuspectUsingPK")
public class NibrsSuspectUsing implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NibrsSuspectUsingPK nibrsSuspectUsingPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @JoinColumn(name = "offense_id", referencedColumnName = "offense_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsOffense nibrsOffense;
    @JoinColumn(name = "suspect_using_id", referencedColumnName = "suspect_using_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsUsingList nibrsUsingList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsSuspectUsing[...]";
    }

}
