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
@Table(name = "nibrs_weapon_type", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "weaponId")
public class NibrsWeaponType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "weapon_id", nullable = false)
    private Short weaponId;
    @Column(name = "weapon_code", length = 3)
    private String weaponCode;
    @Column(name = "weapon_name", length = 100)
    private String weaponName;
    @Column(name = "shr_flag")
    private Character shrFlag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsWeaponType")
    private List<NibrsArresteeWeapon> nibrsArresteeWeaponList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nibrsWeaponType")
    private List<NibrsWeapon> nibrsWeaponList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsWeaponType[" + weaponId + "]";
    }

}
