package com.cernelea.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.cernelea")
@PropertySource("classpath:mySql-Properties.properties")
public class AppConfig {

    @Autowired
    private Environment env;


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource myDataSource() {
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();
        try {
            myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        myDataSource.setUser(env.getProperty("jdbc.user"));
        myDataSource.setPassword(env.getProperty("jdbc.password"));


        myDataSource.setInitialPoolSize(getIntPropertyForConnectionPool("connection.pool.initialPoolSize"));
        myDataSource.setMinPoolSize(getIntPropertyForConnectionPool("connection.pool.minPoolSize"));
        myDataSource.setMaxPoolSize(getIntPropertyForConnectionPool("connection.pool.maxPoolSize"));
        myDataSource.setMaxIdleTime(getIntPropertyForConnectionPool("connection.pool.maxIdleTime"));


        return myDataSource;
    }


    @Bean

    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(myDataSource());

        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));

        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;


    }

    @Bean
    @Autowired

    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;


    }


    private Integer getIntPropertyForConnectionPool(String propertyName) {

        String propertyValue = env.getProperty(propertyName);
        int integerPropertyValue = Integer.parseInt(propertyValue);

        return integerPropertyValue;


    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));


        return properties;
    }


}
