package org.jmresler.fbi.nibrs.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MetaDataDsConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.meta")
    public DataSourceProperties metadbDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.meta.hikari")
    public DataSource metadbDataSource() {
        return metadbDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}
