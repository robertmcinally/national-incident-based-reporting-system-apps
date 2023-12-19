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

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author John M. Resler
 * @version 1.0.0
 */
@Data
@Embeddable
public class NibrsVictimCircumstancesPK implements Serializable {

    @Column(name = "victim_id", nullable = false)
    private long victimId;
    @Column(name = "circumstances_id", nullable = false)
    private short circumstancesId;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsVictimCircumstancesPK[" + victimId + ", " + circumstancesId + "]";
    }

}
