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
import java.math.BigInteger;

/**
 *
 * @author John M. Resler
 * @version 1.0.0
 */
@Data
@Entity
@Table(name = "nibrs_arrestee_weapon")
public class NibrsArresteeWeapon implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected NibrsArresteeWeaponPK nibrsArresteeWeaponPK;
    @Column(name = "data_year")
    private Integer dataYear;
    @Column(name = "nibrs_arrestee_weapon_id")
    private BigInteger nibrsArresteeWeaponId;
    @JoinColumn(name = "arrestee_id", referencedColumnName = "arrestee_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsArrestee nibrsArrestee;
    @JoinColumn(name = "weapon_id", referencedColumnName = "weapon_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NibrsWeaponType nibrsWeaponType;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsArresteeWeapon[...]";
    }
}
