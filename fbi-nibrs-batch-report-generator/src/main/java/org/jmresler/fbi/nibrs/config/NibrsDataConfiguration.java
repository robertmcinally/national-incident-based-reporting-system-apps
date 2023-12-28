package org.jmresler.fbi.nibrs.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "nibrsEntityManagerFactory",
        transactionManagerRef = "nibrsTransactionManager",
        basePackages = { MetaDataConfiguration.BASE_PACKAGES })
public class NibrsDataConfiguration {

    public static final String BASE_PACKAGES = "org.jmresler.fbi.nibrs";

    @Bean(name="nibrsDsProperties")
    @ConfigurationProperties("spring.datasource.nibrs")
    public DataSourceProperties nibrsDsProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="nibrsDatasource")
    public DataSource datasource(@Qualifier("nibrsDsProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name="nibrsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean nibrsEntityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("nibrsDatasource") DataSource dataSource){
        return builder.dataSource(dataSource)
                .packages(BASE_PACKAGES)
                .persistenceUnit("nibrs")
                .build();
    }

    @Bean(name = "nibrsTransactionManager")
    @ConfigurationProperties("spring.jpa.nibrs")
    public PlatformTransactionManager nibrsTransactionManager(
            @Qualifier("nibrsEntityManagerFactory") EntityManagerFactory nibrsEntityManagerFactory) {

        return new JpaTransactionManager(nibrsEntityManagerFactory);
    }
}