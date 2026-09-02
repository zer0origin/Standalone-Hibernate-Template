package com.willcocks.callum;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProviderConfigurationException;

import java.util.TimeZone;

public class HibernateConfiguration {
    private SessionFactory sessionFactory;

    public void setUpHibernate(String jdbc, String username, String password, Class<?>... annotatedClasses) {
        var configuration = new Configuration()
                .setProperty(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver")
                .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect")
                .setProperty(Environment.JAKARTA_JDBC_URL, jdbc)
                .setProperty(Environment.JAKARTA_JDBC_USER, username)
                .setProperty(Environment.JAKARTA_JDBC_PASSWORD, password)
                .setProperty(Environment.SHOW_SQL, true)
                .setProperty(Environment.FORMAT_SQL, false)
                .setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread")
                .setProperty(Environment.HBM2DDL_AUTO, "update")
                .setProperty("hibernate.connection.provider_class", "org.hibernate.hikaricp.internal.HikariCPConnectionProvider")
                .setProperty("hibernate.hikari.minimumIdle", 5)
                .setProperty("hibernate.hikari.maximumPoolSize", 100)
                .setProperty("hibernate.hikari.idleTimeout", 30000)
                .setProperty("hibernate.hikari.dataSource.cachePrepStmts", true)
                .setProperty("hibernate.hikari.dataSource.prepStmtCacheSize", 250)
                .setProperty("hibernate.hikari.dataSource.prepStmtCacheSqlLimit", 2048)
                .setProperty("hibernate.hikari.dataSource.useServerPrepStmts", true)
                .setProperty("hibernate.hikari.dataSource.useLocalSessionState", true)
                .setProperty("hibernate.hikari.dataSource.rewriteBatchedStatements", true)
                .setProperty("hibernate.hikari.dataSource.cacheResultSetMetadata", true)
                .setProperty("hibernate.hikari.dataSource.cacheServerConfiguration", true)
                .setProperty("hibernate.hikari.dataSource.elideSetAutoCommits", true)
                .setProperty("hibernate.hikari.dataSource.maintainTimeStats", false)
                .setProperty("hibernate.cache.use_second_level_cache", false)
                .setProperty("hibernate.cache.use_query_cache", false)
                .setProperty("hibernate.order_inserts", true)
                .setProperty("hibernate.order_updates", true)
                .setProperty("hibernate.jdbc.batch_size", 15000)
                .addAnnotatedClasses(annotatedClasses);

        try{
            sessionFactory = configuration.buildSessionFactory();
            sessionFactory.withOptions().jdbcTimeZone(TimeZone.getTimeZone("GMT+1"));
        }catch (ConnectionProviderConfigurationException e){
            System.out.println("Ensure that your JDBC url is correct. Currently " + jdbc);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
