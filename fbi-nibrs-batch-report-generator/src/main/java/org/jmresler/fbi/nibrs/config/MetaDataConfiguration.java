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
        entityManagerFactoryRef = "metaEntityManagerFactory",
        transactionManagerRef = "metaTransactionManager",
        basePackages = { MetaDataConfiguration.BASE_PACKAGES })
public class MetaDataConfiguration {

    public static final String BASE_PACKAGES = "org.jmresler.fbi.nibrs.h2";

    @Primary
    @Bean(name="metaProperties")
    @ConfigurationProperties("spring.datasource.meta")
    public DataSourceProperties metaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name="metaDatasource")
    public DataSource datasource(@Qualifier("metaProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name="metaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean metaEntityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("metaDatasource") DataSource dataSource){
        return builder.dataSource(dataSource)
                .packages(BASE_PACKAGES)
                .persistenceUnit("meta")
                .build();
    }

    @Primary
    @Bean(name = "metaTransactionManager")
    @ConfigurationProperties("spring.jpa.meta")
    public PlatformTransactionManager metaTransactionManager(
            @Qualifier("metaEntityManagerFactory") EntityManagerFactory metaEntityManagerFactory) {

        return new JpaTransactionManager(metaEntityManagerFactory);
    }
}