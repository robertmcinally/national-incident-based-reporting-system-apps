package org.jmresler.fbi.nibrs.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class NibrsDsConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.nibrs")
    public DataSourceProperties nibrsdbDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.nibrs.hikari")
    public DataSource nibrsdbDataSource() {
        return nibrsdbDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}
