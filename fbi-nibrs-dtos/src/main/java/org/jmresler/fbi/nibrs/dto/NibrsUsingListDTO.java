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
import java.util.List;

/**
 *
 * @author John M. Resler
 * @version 1.0.0
 */
@Data
public class NibrsUsingListDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Short suspectUsingId;
    private Character suspectUsingCode;
    private String suspectUsingName;
    private List<NibrsSuspectUsingDTO> nibrsSuspectUsingDTOList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.dto.NibrsUsingListDTO["  + suspectUsingId + "]";
    }

}
