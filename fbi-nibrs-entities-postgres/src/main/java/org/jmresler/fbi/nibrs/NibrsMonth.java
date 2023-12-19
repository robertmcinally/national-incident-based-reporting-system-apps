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
import java.util.Date;
import java.util.List;

/**
 * This class represents a NIBRS (National Incident-Based Reporting System) month.
 * It contains information about the month, year, and status of the NIBRS data.
 * It also includes a reference to the agency that reported the data and a list
 * of NIBRS incidents associated with this month.
 */
@Data
@Entity
@Table(name = "nibrs_month", catalog = "nibrs", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "did")
public class NibrsMonth implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "did", nullable = false)
    private Long did;
    @Column(name = "data_year")
    private Integer dataYear;
    @Basic(optional = false)
    @Column(name = "nibrs_month_id", nullable = false)
    private long nibrsMonthId;
    @Basic(optional = false)
    @Column(name = "month_num", nullable = false)
    private short monthNum;
    @Column(name = "inc_data_year")
    private Integer incDataYear;
    @Column(name = "reported_status", length = 10)
    private String reportedStatus;
    @Column(name = "report_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;
    @Column(name = "update_flag")
    private Character updateFlag;
    @Basic(optional = false)
    @Column(name = "orig_format", nullable = false)
    private Character origFormat;
    @Column(name = "data_home", length = 10)
    private String dataHome;
    @Column(name = "ddocname", length = 50)
    private String ddocname;
    @Column(name = "month_pub_status")
    private Integer monthPubStatus;
    @JoinColumn(name = "agency_id", referencedColumnName = "agency_id", nullable = false)
    @ManyToOne(optional = false)
    private Agencies agencyId;
    @OneToMany(mappedBy = "did")
    private List<NibrsIncident> nibrsIncidentList;

    @Override
    public String toString() {
        return  "org.jmresler.fbi.nibrs.NibrsMonth[" + did + "]";
    }

}
