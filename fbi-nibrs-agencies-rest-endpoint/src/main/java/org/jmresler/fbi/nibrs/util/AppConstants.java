package org.jmresler.fbi.nibrs.util;

import org.jmresler.fbi.nibrs.Agencies;

import static java.util.Collections.emptyList;
public class AppConstants {

     public static final Agencies EMPTY_AGENCY = new Agencies(){{
        setAgencyId(-1);
        setNibrsMonthList(emptyList());
        setNibrsIncidentList(emptyList());
    }};
}
