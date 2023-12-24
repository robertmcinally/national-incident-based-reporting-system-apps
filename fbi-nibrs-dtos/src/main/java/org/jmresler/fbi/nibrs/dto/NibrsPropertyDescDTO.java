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
package org.jmresler.fbi.nibrs.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author John M. Resler
 * @version 1.0.0
 */
@Data
public class NibrsPropertyDescDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected NibrsPropertyDescPKDTO nibrsPropertyDescPK;
    private Integer dataYear;
    private BigInteger propertyValue;
    private Date dateRecovered;
    private BigInteger nibrsPropDescId;
    private NibrsPropDescTypeDTO nibrsPropDescType;
    private NibrsPropertyDTO nibrsProperty;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.dto.NibrsPropertyDescDTO[...]";
    }

}
