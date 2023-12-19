drop schema if exists nibrs;
create schema nibrs;
use nibrs;
-- Tables


create table agencies (
    yearly_agency_id INTEGER,
    agency_id BIGINT,
    data_year INTEGER,
    ori character varying(25),
    legacy_ori character varying(25),
    covered_by_legacy_ori character varying(25),
    direct_contributor_flag character varying(1),
    dormant_flag character varying(1),
    dormant_year INTEGER,
    reporting_type character varying(1),
    ucr_agency_name character varying(100),
    ncic_agency_name character varying(100),
    pub_agency_name character varying(100),
    pub_agency_unit character varying(100),
    agency_status character varying(1),
    state_id INTEGER,
    state_name character varying(100),
    state_abbr character varying(2),
    state_postal_abbr character varying(2),
    division_code INTEGER,
    division_name character varying(100),
    region_code INTEGER,
    region_name character varying(100),
    region_desc character varying(100),
    agency_type_name character varying(100),
    population INTEGER,
    submitting_agency_id INTEGER,
    sai character varying(25),
    submitting_agency_name character varying(200),
    suburban_area_flag character varying(1),
    population_group_id INTEGER,
    population_group_code character varying(2),
    population_group_desc character varying(100),
    parent_pop_group_code INTEGER,
    parent_pop_group_desc character varying(100),
    mip_flag character varying(1),
    pop_sort_order INTEGER,
    summary_rape_def character varying(1),
    pe_reported_flag character varying(1),
    male_officer INTEGER,
    male_civilian INTEGER,
    male_total INTEGER,
    female_officer INTEGER,
    female_civilian INTEGER,
    female_total INTEGER,
    officer_rate DECIMAL,
    employee_rate DECIMAL,
    nibrs_cert_date DATE,
    nibrs_start_date DATE,
    nibrs_leoka_start_date DATE,
    nibrs_ct_start_date DATE,
    nibrs_multi_bias_start_date DATE,
    nibrs_off_eth_start_date DATE,
    covered_flag character varying(1),
    county_name character varying(100),
    msa_name character varying(100),
    publishable_flag character varying(1),
    participated character varying(1),
    nibrs_participated character varying(1)
);

create table nibrs_activity_type (
    activity_type_id smallint not null,
    activity_type_code character(2),
    activity_type_name character varying(100)
);

create table nibrs_age (
    age_id smallint not null,
    age_code character(2),
    age_name character varying(100)
);

create table nibrs_arrest_type (
    arrest_type_id smallint not null,
    arrest_type_code character(1),
    arrest_type_name character varying(100)
);

create table nibrs_assignment_type (
    assignment_type_id smallint not null,
    assignment_type_code character(1),
    assignment_type_name character varying(100)
);

create table nibrs_bias_list (
    bias_id smallint not null,
    bias_code character(2),
    bias_name character varying(100),
    bias_desc character varying(100)
);

create table nibrs_location_type (
    location_id BIGINT not null,
    location_code character(2),
    location_name character varying(100)
);

create table nibrs_offense_type (
    offense_code character varying(5) not null,
    offense_name character varying(100),
    crime_against character varying(100),
    ct_flag character(1),
    hc_flag character(1),
    hc_code character varying(5),
    offense_category_name character varying(100),
    offense_group character(5)
);

create table nibrs_prop_desc_type (
    prop_desc_id smallint not null,
    prop_desc_name character varying(100),
    prop_desc_code character(2)
);

create table nibrs_victim_type (
    victim_type_id smallint not null,
    victim_type_code character(1),
    victim_type_name character varying(100)
);

create table nibrs_circumstances (
    circumstances_id smallint not null,
    circumstances_type character(1),
    circumstances_code smallint,
    circumstances_name character varying(100)
);

create table nibrs_cleared_except (
    cleared_except_id smallint not null,
    cleared_except_code character(1),
    cleared_except_name character varying(100),
    cleared_except_desc character varying(300)
);

create table nibrs_criminal_act (
    data_year INT,
    criminal_act_id smallint not null,
    offense_id BIGINT not null
);

create table nibrs_criminal_act_type (
    criminal_act_id smallint not null,
    criminal_act_code character(1),
    criminal_act_name character varying(100),
    criminal_act_desc character varying(300)
);

create table nibrs_drug_measure_type (
    drug_measure_type_id smallint not null,
    drug_measure_code character(2),
    drug_measure_name character varying(100)
);

create table nibrs_ethnicity (
    ethnicity_id smallint not null,
    ethnicity_code character(1),
    ethnicity_name character varying(100)
);

create table nibrs_injury (
    injury_id smallint not null,
    injury_code character(1),
    injury_name character varying(100)
);

create table nibrs_justifiable_force (
    justifiable_force_id smallint not null,
    justifiable_force_code character(1),
    justifiable_force_name character varying(100)
);

create table nibrs_prop_loss_type (
    prop_loss_id smallint not null,
    prop_loss_name character varying(100),
    prop_loss_desc character varying(250)
);

create table nibrs_relationship (
    relationship_id smallint not null,
    relationship_code character(2),
    relationship_name character varying(100)
);

create table nibrs_suspected_drug_type (
    suspected_drug_type_id smallint not null,
    suspected_drug_code character(1),
    suspected_drug_name character varying(100)
);

create table nibrs_using_list (
    suspect_using_id smallint not null,
    suspect_using_code character(1),
    suspect_using_name character varying(100)
);

create table nibrs_weapon_type (
    weapon_id smallint not null,
    weapon_code character varying(3),
    weapon_name character varying(100),
    shr_flag character(1)
);

create table ref_race (
    race_id smallint not null,
    race_code character varying(2) not null,
    race_desc character varying(100) not null,
    sort_order smallint,
    start_year smallint,
    end_year smallint,
    notes character varying(1000)
);

create table ref_state (
    state_id smallint not null,
    division_id smallint not null,
    state_name character varying(100),
    state_code character varying(2),
    state_abbr character varying(2),
    state_postal_abbr character varying(2),
    state_fips_code character varying(2),
    state_pub_freq_months smallint,
    change_user character varying(100)
);

create table nibrs_arrestee (
    data_year INT,
    arrestee_id BIGINT not null,
    incident_id BIGINT not null,
    arrestee_seq_num BIGINT,
    arrest_date TIMESTAMP,
    arrest_type_id smallint,
    multiple_indicator character(1),
    offense_code character varying(5) not null,
    age_id smallint not null,
    age_num smallint,
    sex_code character(1),
    race_id smallint not null,
    ethnicity_id smallint,
    resident_code character(1),
    under_18_disposition_code character(1),
    clearance_ind character(1),
    age_range_low_num smallint,
    age_range_high_num smallint
);

create table nibrs_arrestee_weapon (
    data_year INT,
    arrestee_id BIGINT not null,
    nibrs_arrestee_weapon_id BIGINT,
    weapon_id smallint not null
);

create table nibrs_bias_motivation (
    data_year INT,
    bias_id smallint not null,
    offense_id BIGINT not null
);

create table nibrs_month (
    data_year INT,
    nibrs_month_id BIGINT not null,
    agency_id BIGINT not null,
    month_num smallint not null,
    inc_data_year INT,
    reported_status character varying(10),
    report_date TIMESTAMP,
    update_flag character(1) default null,
    orig_format character(1) default null,
    data_home character varying(10),
    ddocname character varying(50),
    did BIGINT,
    month_pub_status INT
);

create table nibrs_offender (
    data_year INT,
    offender_id BIGINT not null,
    incident_id BIGINT not null,
    offender_seq_num smallint,
    age_id smallint,
    age_num character(3),
    sex_code character(1),
    race_id smallint,
    ethnicity_id smallint,
    age_range_low_num smallint,
    age_range_high_num smallint
);

create table nibrs_offense (
    data_year INT,
    offense_id BIGINT not null,
    incident_id BIGINT not null,
    offense_code character varying(5) not null,
    attempt_complete_flag character(1),
    location_id BIGINT not null,
    num_premises_entered smallint,
    method_entry_code character(1)
);

create table nibrs_property (
    data_year INT,
    property_id BIGINT not null,
    incident_id BIGINT not null,
    prop_loss_id smallint not null,
    stolen_count smallint,
    recovered_count smallint
);

create table nibrs_property_desc (
    data_year INT,
    property_id BIGINT not null,
    prop_desc_id smallint not null,
    property_value BIGINT,
    date_recovered TIMESTAMP,
    nibrs_prop_desc_id BIGINT
);

create table nibrs_suspect_using (
    data_year INT,
    suspect_using_id smallint not null,
    offense_id BIGINT not null
);

create table nibrs_suspected_drug (
    data_year INT,
    suspected_drug_type_id smallint not null,
    property_id BIGINT not null,
    est_drug_qty DOUBLE precision,
    drug_measure_type_id smallint,
    nibrs_suspected_drug_id BIGINT not null
);

create table nibrs_victim (
    data_year INT,
    victim_id BIGINT not null,
    incident_id BIGINT not null,
    victim_seq_num smallint,
    victim_type_id smallint not null,
    assignment_type_id smallint,
    activity_type_id smallint,
    outside_agency_id BIGINT,
    age_id smallint,
    age_num character varying(2),
    sex_code character(1),
    race_id smallint,
    ethnicity_id smallint,
    resident_status_code character(1),
    age_range_low_num smallint,
    age_range_high_num smallint
);

create table nibrs_victim_circumstances (
    data_year INT,
    victim_id BIGINT not null,
    circumstances_id smallint not null,
    justifiable_force_id smallint
);

create table nibrs_victim_injury (
    data_year INT,
    victim_id BIGINT not null,
    injury_id smallint not null
);

create table nibrs_victim_offender_rel (
    data_year INT,
    victim_id BIGINT not null,
    offender_id BIGINT not null,
    relationship_id smallint not null,
    nibrs_victim_offender_id BIGINT
);

create table nibrs_victim_offense (
    data_year INT,
    victim_id BIGINT not null,
    offense_id BIGINT not null
);

create table nibrs_weapon (
    data_year INT,
    weapon_id smallint not null,
    offense_id BIGINT not null,
    nibrs_weapon_id BIGINT
);

create table nibrs_incident (
	data_year int,
    agency_id bigint not null,
    incident_id bigint not null,
    nibrs_month_id bigint not null,
    cargo_theft_flag character(1),
    submission_date timestamp,
    incident_date timestamp,
    report_date_flag character(1),
    incident_hour smallint,
    cleared_except_id smallint not null,
    cleared_except_date timestamp,
    incident_status character varying(100),
-- smallint
data_home character(1),
    orig_format character(1),
    did bigint
);
-- Primary Keys

  alter table NIBRS_SUSPECTED_DRUG add constraint NIBRS_SUSPECTED_DRUG_PK primary key (NIBRS_SUSPECTED_DRUG_ID);

alter table NIBRS_RELATIONSHIP add constraint NIBRS_RELATIONSHIP_PK primary key (RELATIONSHIP_ID);

alter table NIBRS_DRUG_MEASURE_TYPE add constraint NIBRS_DRUG_MEASURE_TYPE_PK primary key (DRUG_MEASURE_TYPE_ID);

alter table NIBRS_USING_LIST add constraint NIBRS_SUSPECTED_USING_PK primary key (SUSPECT_USING_ID);

alter table NIBRS_PROP_LOSS_TYPE add constraint NIBRS_PROP_LOSS_TYPE_PK primary key (PROP_LOSS_ID);

alter table NIBRS_ETHNICITY add constraint NIBRS_ETH_PK primary key (ETHNICITY_ID);

alter table NIBRS_PROPERTY add constraint NIBRS_PROPERTY_PK primary key (PROPERTY_ID);

alter table NIBRS_CRIMINAL_ACT add constraint NIBRS_CRIMINAL_ACT_PK primary key (CRIMINAL_ACT_ID,
OFFENSE_ID);

alter table NIBRS_OFFENSE_TYPE add constraint NIBRS_OFFENSE_TYPE_PK primary key (offense_code);

alter table NIBRS_CRIMINAL_ACT_TYPE add constraint NIBRS_CRIMINAL_ACT_TYPE_PK primary key (CRIMINAL_ACT_ID);

alter table NIBRS_PROPERTY_DESC add constraint NIBRS_PROPERTY_DESC_PK primary key (property_id,
prop_desc_id);

alter table NIBRS_INCIDENT add constraint NIBRS_INCIDENT_PK primary key (INCIDENT_ID);

alter table NIBRS_BIAS_MOTIVATION add constraint NIBRS_BIAS_MOTIVATION_PK primary key (BIAS_ID,
OFFENSE_ID);

alter table NIBRS_SUSPECT_USING add constraint NIBRS_SUSPECT_USING_PK primary key (SUSPECT_USING_ID,
OFFENSE_ID);

alter table NIBRS_VICTIM_TYPE add constraint NIBRS_VICTIM_TYPE_PK primary key (VICTIM_TYPE_ID);

alter table NIBRS_INJURY add constraint NIBRS_INJURY_PK primary key (INJURY_ID);

alter table NIBRS_OFFENDER add constraint NIBRS_OFFENDER_PK primary key (OFFENDER_ID);

alter table NIBRS_CIRCUMSTANCES add constraint NIBRS_CIRCUMSTANCES_PK primary key (CIRCUMSTANCES_ID);

alter table NIBRS_ACTIVITY_TYPE add constraint NIBRS_ACTIVITY_TYPE_PK primary key (ACTIVITY_TYPE_ID);

alter table NIBRS_ARRESTEE add constraint NIBRS_ARRESTEE_PK primary key (ARRESTEE_ID);

alter table NIBRS_WEAPON_TYPE add constraint NIBRS_WEAPON_TYPE_PK primary key (WEAPON_ID);

alter table NIBRS_BIAS_LIST add constraint NIBRS_BIAS_LIST_PK primary key (BIAS_ID);

alter table NIBRS_ARREST_TYPE add constraint NIBRS_ARREST_TYPE_PK primary key (ARREST_TYPE_ID);

alter table NIBRS_VICTIM_INJURY add constraint NIBRS_VICTIM_INJURY_PK primary key (VICTIM_ID,
INJURY_ID);

alter table NIBRS_OFFENSE add constraint NIBRS_OFFENSE_PK primary key (OFFENSE_ID);

alter table NIBRS_VICTIM_OFFENDER_REL add constraint NIBRS_VICTIM_OFFENDER_REL_PK primary key (victim_id,
offender_id);

alter table NIBRS_CLEARED_EXCEPT add constraint NIBRS_CLEARED_EXCEPT_PK primary key (CLEARED_EXCEPT_ID);

alter table NIBRS_VICTIM add constraint NIBRS_VICTIM_PK primary key (VICTIM_ID);

alter table NIBRS_MONTH add constraint NIBRS_MONTH_PK primary key (did);

alter table NIBRS_AGE add constraint NIBRS_AGE_PK primary key (AGE_ID);

alter table NIBRS_PROP_DESC_TYPE add constraint NIBRS_PROP_DESC_TYPE_PK primary key (PROP_DESC_ID);

alter table NIBRS_VICTIM_CIRCUMSTANCES add constraint NIBRS_VICTIM_CIRCUMSTANCES_PK primary key (VICTIM_ID,
CIRCUMSTANCES_ID);

alter table NIBRS_ARRESTEE_WEAPON add constraint NIBRS_ARRESTEE_WEAPON_PK primary key (arrestee_id,
weapon_id);

alter table NIBRS_SUSPECTED_DRUG_TYPE add constraint NIBRS_SUSPECTED_DRUG_TYPE_PK primary key (SUSPECTED_DRUG_TYPE_ID);

alter table NIBRS_VICTIM_OFFENSE add constraint NIBRS_VICTIM_OFFENSE_PK primary key (VICTIM_ID,
OFFENSE_ID);

alter table NIBRS_LOCATION_TYPE add constraint NIBRS_LOCATION_TYPE_PK primary key (LOCATION_ID);

alter table NIBRS_ASSIGNMENT_TYPE add constraint NIBRS_ASSIGN_TYPE_PK primary key (ASSIGNMENT_TYPE_ID);

alter table NIBRS_WEAPON add constraint NIBRS_WEAPON_PK primary key (weapon_id,
offense_id);

alter table REF_RACE add constraint REF_RACE_PK primary key (RACE_ID);

alter table REF_STATE add constraint REF_STATE_PK primary key (STATE_ID);

alter table AGENCIES add constraint AGENCIES_PK primary key (agency_id);

alter table NIBRS_JUSTIFIABLE_FORCE add constraint NIBRS_JUSTIFIABLE_FORCE_PK primary key (JUSTIFIABLE_FORCE_ID);
-- Foreign Keys
  
  alter table NIBRS_ARRESTEE_WEAPON add constraint NIBRS_ARREST_WEAP_ARREST_FK foreign key (ARRESTEE_ID)
	  references NIBRS_ARRESTEE (ARRESTEE_ID) on
delete
	cascade;

alter table NIBRS_ARRESTEE_WEAPON add constraint NIBRS_ARREST_WEAP_TYPE_FK foreign key (WEAPON_ID)
	  references NIBRS_WEAPON_TYPE (WEAPON_ID);

alter table NIBRS_PROPERTY_DESC add constraint NIBRS_PROP_DESC_PROP_FK foreign key (PROPERTY_ID)
	  references NIBRS_PROPERTY (PROPERTY_ID) on
delete
	cascade;

alter table NIBRS_PROPERTY_DESC add constraint NIBRS_PROP_DESC_TYPE_FK foreign key (PROP_DESC_ID)
	  references NIBRS_PROP_DESC_TYPE (PROP_DESC_ID);

alter table NIBRS_ARRESTEE add constraint NIBRS_ARRESTEE_AGE_FK foreign key (AGE_ID)
	  references NIBRS_AGE (AGE_ID);

alter table NIBRS_ARRESTEE add constraint NIBRS_ARRESTEE_ARREST_TYPE_FK foreign key (ARREST_TYPE_ID)
	  references NIBRS_ARREST_TYPE (ARREST_TYPE_ID);

alter table NIBRS_ARRESTEE add constraint NIBRS_ARRESTEE_ETHNICITY_FK foreign key (ETHNICITY_ID)
	  references NIBRS_ETHNICITY (ETHNICITY_ID);

alter table NIBRS_ARRESTEE add constraint NIBRS_ARRESTEE_INC_FK foreign key (INCIDENT_ID)
	  references NIBRS_INCIDENT (INCIDENT_ID) on
delete
	cascade;

alter table NIBRS_ARRESTEE add constraint NIBRS_ARRESTEE_RACE_FK foreign key (RACE_ID)
	  references REF_RACE (RACE_ID);

alter table NIBRS_ARRESTEE add constraint NIBRS_ARRESTEE_OFFENSE_TYPE_FK foreign key (offense_code)
	  references NIBRS_OFFENSE_TYPE (offense_code);

alter table NIBRS_SUSPECTED_DRUG add constraint NIBRS_SUSP_DRUG_MEAS_TYPE_FK foreign key (DRUG_MEASURE_TYPE_ID)
	  references NIBRS_DRUG_MEASURE_TYPE (DRUG_MEASURE_TYPE_ID);

alter table NIBRS_SUSPECTED_DRUG add constraint NIBRS_SUSP_DRUG_PROP_FK foreign key (PROPERTY_ID)
	  references NIBRS_PROPERTY (PROPERTY_ID) on
delete
	cascade;

alter table NIBRS_SUSPECTED_DRUG add constraint NIBRS_SUSP_DRUG_TYPE_FK foreign key (SUSPECTED_DRUG_TYPE_ID)
	  references NIBRS_SUSPECTED_DRUG_TYPE (SUSPECTED_DRUG_TYPE_ID);

alter table NIBRS_PROPERTY add constraint NIBRS_PROPERTY_INC_FK foreign key (INCIDENT_ID)
	  references NIBRS_INCIDENT (INCIDENT_ID) on
delete
	cascade;

alter table NIBRS_PROPERTY add constraint NIBRS_PROPERTY_LOSS_TYPE_FK foreign key (PROP_LOSS_ID)
	  references NIBRS_PROP_LOSS_TYPE (PROP_LOSS_ID);

alter table NIBRS_CRIMINAL_ACT add constraint NIBRS_CRIMINAL_ACT_OFFENSE_FK foreign key (OFFENSE_ID)
	  references NIBRS_OFFENSE (OFFENSE_ID) on
delete
	cascade;

alter table NIBRS_CRIMINAL_ACT add constraint NIBRS_CRIMINAL_ACT_TYPE_FK foreign key (CRIMINAL_ACT_ID)
	  references NIBRS_CRIMINAL_ACT_TYPE (CRIMINAL_ACT_ID);

alter table NIBRS_OFFENDER add constraint NIBRS_OFFENDER_AGE_FK foreign key (AGE_ID)
	  references NIBRS_AGE (AGE_ID);

alter table NIBRS_OFFENDER add constraint NIBRS_OFFENDER_ETHNICITY_FK foreign key (ETHNICITY_ID)
	  references NIBRS_ETHNICITY (ETHNICITY_ID);

alter table NIBRS_OFFENDER add constraint NIBRS_OFFENDER_NIBRS_INCI_FK1 foreign key (INCIDENT_ID)
	  references NIBRS_INCIDENT (INCIDENT_ID) on
delete
	cascade;

alter table NIBRS_OFFENDER add constraint NIBRS_OFFENDER_RACE_FK foreign key (RACE_ID)
	  references REF_RACE (RACE_ID);

alter table NIBRS_VICTIM_INJURY add constraint NIBRS_VIC_INJURY_NIBRS_INJ_FK foreign key (INJURY_ID)
	  references NIBRS_INJURY (INJURY_ID);

alter table NIBRS_VICTIM_INJURY add constraint NIBRS_VIC_INJURY_NIBRS_VIC_FK foreign key (VICTIM_ID)
	  references NIBRS_VICTIM (VICTIM_ID) on
delete
	cascade;

alter table NIBRS_WEAPON add constraint NIBRS_WEAP_WEAP_TYPE_FK foreign key (WEAPON_ID)
	  references NIBRS_WEAPON_TYPE (WEAPON_ID);

alter table NIBRS_WEAPON add constraint NIBRS_WEAP_OFF_FK foreign key (OFFENSE_ID)
	  references NIBRS_OFFENSE (OFFENSE_ID) on
delete
	cascade;

alter table NIBRS_VICTIM_CIRCUMSTANCES add constraint NIBRS_VIC_CIRC_NIBRS_VIC_FK foreign key (VICTIM_ID)
	  references NIBRS_VICTIM (VICTIM_ID) on
delete
	cascade;

alter table NIBRS_VICTIM_CIRCUMSTANCES add constraint NIBRS_VICTIM_CIRC_JUST_HOM_FK foreign key (JUSTIFIABLE_FORCE_ID)
	  references NIBRS_JUSTIFIABLE_FORCE (JUSTIFIABLE_FORCE_ID);

alter table NIBRS_VICTIM_CIRCUMSTANCES add constraint NIBRS_VIC_CIRC_NIBRS_CIRC_FK foreign key (CIRCUMSTANCES_ID)
	  references NIBRS_CIRCUMSTANCES (CIRCUMSTANCES_ID);

alter table NIBRS_SUSPECT_USING add constraint NIBRS_SUSPECT_USING_OFF_FK foreign key (OFFENSE_ID)
	  references NIBRS_OFFENSE (OFFENSE_ID) on
delete
	cascade;

alter table NIBRS_SUSPECT_USING add constraint NIBRS_SUSPECT_USING_LIST_FK foreign key (SUSPECT_USING_ID)
	  references NIBRS_USING_LIST (SUSPECT_USING_ID);

alter table NIBRS_OFFENSE add constraint NIBRS_OFFENSE_INC_FK1 foreign key (INCIDENT_ID)
	  references NIBRS_INCIDENT (INCIDENT_ID) on
delete
	cascade;

alter table NIBRS_OFFENSE add constraint NIBRS_OFFENSE_LOC_TYPE_FK foreign key (LOCATION_ID)
	  references NIBRS_LOCATION_TYPE (LOCATION_ID);

alter table NIBRS_OFFENSE add constraint NIBRS_OFFENSE_OFF_TYPE_FK foreign key (offense_code)
	  references NIBRS_OFFENSE_TYPE (offense_code);

alter table NIBRS_VICTIM_OFFENDER_REL add constraint NIBRS_VICTIM_OFF_REL_VIC_FK foreign key (VICTIM_ID)
	  references NIBRS_VICTIM (VICTIM_ID) on
delete
	cascade;

alter table NIBRS_VICTIM_OFFENDER_REL add constraint NIBRS_VICTIM_OFF_REL_OFF_FK foreign key (OFFENDER_ID)
	  references NIBRS_OFFENDER (OFFENDER_ID) on
delete
	cascade;

alter table NIBRS_VICTIM_OFFENDER_REL add constraint NIBRS_VICTIM_OFF_REL_REL_FK foreign key (RELATIONSHIP_ID)
	  references NIBRS_RELATIONSHIP (RELATIONSHIP_ID);

alter table NIBRS_VICTIM add constraint NIBRS_VICTIMS_VIC_TYPE_FK foreign key (VICTIM_TYPE_ID)
	  references NIBRS_VICTIM_TYPE (VICTIM_TYPE_ID);

alter table NIBRS_VICTIM add constraint NIBRS_VICTIM_ACT_TYPE_FK foreign key (ACTIVITY_TYPE_ID)
	  references NIBRS_ACTIVITY_TYPE (ACTIVITY_TYPE_ID);

alter table NIBRS_VICTIM add constraint NIBRS_VICTIM_AGE_FK foreign key (AGE_ID)
	  references NIBRS_AGE (AGE_ID);

alter table NIBRS_VICTIM add constraint NIBRS_VICTIM_ASSIGN_TYPE_FK foreign key (ASSIGNMENT_TYPE_ID)
	  references NIBRS_ASSIGNMENT_TYPE (ASSIGNMENT_TYPE_ID);

alter table NIBRS_VICTIM add constraint NIBRS_VICTIM_ETHNICITY_FK foreign key (ETHNICITY_ID)
	  references NIBRS_ETHNICITY (ETHNICITY_ID);

alter table NIBRS_VICTIM add constraint NIBRS_VICTIM_RACE_FK foreign key (RACE_ID)
	  references REF_RACE (RACE_ID);

alter table NIBRS_VICTIM add constraint NIBRS_VICTIM_INC_FK foreign key (INCIDENT_ID)
	  references NIBRS_INCIDENT (INCIDENT_ID) on
delete
	cascade;

alter table NIBRS_MONTH add constraint NIBRS_MONTH_AGENCY_FK foreign key (AGENCY_ID)
	  references AGENCIES (AGENCY_ID);

alter table NIBRS_INCIDENT add constraint NIBRS_INCIDENT_AGENCY_FK foreign key (AGENCY_ID)
	  references AGENCIES (AGENCY_ID);

alter table NIBRS_INCIDENT add constraint NIBRS_INCIDENT_CLEAR_EX_FK foreign key (CLEARED_EXCEPT_ID)
	  references NIBRS_CLEARED_EXCEPT (CLEARED_EXCEPT_ID);

alter table NIBRS_INCIDENT add constraint NIBRS_INCIDENT_MONTH_FK foreign key (did)
	  references NIBRS_MONTH (did) on
delete
	cascade;

alter table NIBRS_VICTIM_OFFENSE add constraint NIBRS_VIC_OFF_NIBRS_VIC_FK foreign key (VICTIM_ID)
	  references NIBRS_VICTIM (VICTIM_ID) on
delete
	cascade;

alter table NIBRS_VICTIM_OFFENSE add constraint NIBRS_VIC_OFF_NIBRS_OFF_FK foreign key (OFFENSE_ID)
	  references NIBRS_OFFENSE (OFFENSE_ID) on
delete
	cascade;

alter table NIBRS_BIAS_MOTIVATION add constraint NIBRS_BIAS_MOT_OFFENSE_FK foreign key (OFFENSE_ID)
	  references NIBRS_OFFENSE (OFFENSE_ID) on
delete
	cascade;

alter table NIBRS_BIAS_MOTIVATION add constraint NIBRS_BIAS_MOT_LIST_FK foreign key (BIAS_ID)
	  references NIBRS_BIAS_LIST (BIAS_ID);
	 
-- Indexes	 
	 
	 