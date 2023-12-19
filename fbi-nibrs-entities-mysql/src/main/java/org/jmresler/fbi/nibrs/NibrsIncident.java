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
import java.util.Date;
import java.util.List;

/**
 *
 * @author John M. Resler
 * @version 1.0.0
 */
@Data
@Entity
@Table(name = "nibrs_incident")
public class NibrsIncident implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "data_year")
    private Integer dataYear;
    @Id
    @Column(name = "incident_id", nullable = false)
    private Long incidentId;
    @Column(name = "nibrs_month_id", nullable = false)
    private long nibrsMonthId;
    @Column(name = "cargo_theft_flag")
    private Character cargoTheftFlag;
    @Column(name = "submission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
    @Column(name = "incident_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incidentDate;
    @Column(name = "report_date_flag")
    private Character reportDateFlag;
    @Column(name = "incident_hour")
    private Short incidentHour;
    @Column(name = "cleared_except_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clearedExceptDate;
    @Column(name = "incident_status", length = 100)
    private String incidentStatus;
    @Column(name = "data_home")
    private Character dataHome;
    @Column(name = "orig_format")
    private Character origFormat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsArrestee> nibrsArresteeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsOffense> nibrsOffenseList;
    @JoinColumn(name = "agency_id", referencedColumnName = "agency_id", nullable = false)
    @ManyToOne(optional = false)
    private Agencies agencyId;
    @JoinColumn(name = "cleared_except_id", referencedColumnName = "cleared_except_id", nullable = false)
    @ManyToOne(optional = false)
    private NibrsClearedExcept clearedExceptId;
    @JoinColumn(name = "did", referencedColumnName = "did")
    @ManyToOne
    private NibrsMonth did;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsOffender> nibrsOffenderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsProperty> nibrsPropertyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentId")
    private List<NibrsVictim> nibrsVictimList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsIncident[" + incidentId + "]";
    }

}
