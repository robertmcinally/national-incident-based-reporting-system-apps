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
@Table(name = "nibrs_offense_type")
public class NibrsOffenseType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "offense_code", nullable = false, length = 5)
    private String offenseCode;
    @Column(name = "offense_name", length = 100)
    private String offenseName;
    @Column(name = "crime_against", length = 100)
    private String crimeAgainst;
    @Column(name = "ct_flag")
    private Character ctFlag;
    @Column(name = "hc_flag")
    private Character hcFlag;
    @Column(name = "hc_code", length = 5)
    private String hcCode;
    @Column(name = "offense_category_name", length = 100)
    private String offenseCategoryName;
    @Column(name = "offense_group", length = 5)
    private String offenseGroup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offenseCode")
    private List<NibrsArrestee> nibrsArresteeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offenseCode")
    private List<NibrsOffense> nibrsOffenseList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsOffenseType[" + offenseCode + "]";
    }

}
