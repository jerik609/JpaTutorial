"One to many" - relationship defined by master table
```agsl
2023-02-21T20:08:15.203+01:00  INFO 16420 --- [    Test worker] c.j.S.test.Entity2Test                   : Started Entity2Test in 3.705 seconds (process running for 5.206)
2023-02-21T20:08:15.404+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Creating new transaction with name [org.springframework.data.jpa.repository.support.SimpleJpaRepository.save]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
2023-02-21T20:08:15.404+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Opened new EntityManager [SessionImpl(1528226950<open>)] for JPA transaction
2023-02-21T20:08:15.409+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Exposing JPA transaction as JDBC [org.springframework.orm.jpa.vendor.HibernateJpaDialect$HibernateConnectionHandle@2cf669f2]
Hibernate: select t1_0.tweet_id,u1_0.id from tweet t1_0 left join userx u1_0 on u1_0.id=t1_0.userx_id where t1_0.tweet_id=?
Hibernate: select u1_0.id,t1_0.userx_id,t1_0.tweet_id from userx u1_0 left join tweet t1_0 on u1_0.id=t1_0.userx_id where u1_0.id=?
2023-02-21T20:08:15.478+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Initiating transaction commit
2023-02-21T20:08:15.479+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Committing JPA transaction on EntityManager [SessionImpl(1528226950<open>)]
Hibernate: insert into userx (id) values (?)
Hibernate: insert into tweet (userx_id, tweet_id) values (?, ?)
2023-02-21T20:08:15.500+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Closing JPA EntityManager [SessionImpl(1528226950<open>)] after transaction
2023-02-21T20:08:15.501+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Creating new transaction with name [org.springframework.data.jpa.repository.support.SimpleJpaRepository.delete]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
2023-02-21T20:08:15.501+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Opened new EntityManager [SessionImpl(928103158<open>)] for JPA transaction
2023-02-21T20:08:15.501+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Exposing JPA transaction as JDBC [org.springframework.orm.jpa.vendor.HibernateJpaDialect$HibernateConnectionHandle@27e656e6]
Hibernate: select t1_0.tweet_id,u1_0.id from tweet t1_0 left join userx u1_0 on u1_0.id=t1_0.userx_id where t1_0.tweet_id=?
Hibernate: select t1_0.userx_id,t1_0.tweet_id from tweet t1_0 where t1_0.userx_id=?
2023-02-21T20:08:15.520+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Initiating transaction commit
2023-02-21T20:08:15.521+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Committing JPA transaction on EntityManager [SessionImpl(928103158<open>)]
Hibernate: update tweet set userx_id=null where userx_id=?
Hibernate: delete from tweet where tweet_id=?
Hibernate: delete from userx where id=?
2023-02-21T20:08:15.526+01:00 DEBUG 16420 --- [    Test worker] o.s.orm.jpa.JpaTransactionManager        : Closing JPA EntityManager [SessionImpl(928103158<open>)] after transaction
2023-02-21T20:08:15.543+01:00  INFO 16420 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2023-02-21T20:08:15.545+01:00  INFO 16420 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2023-02-21T20:08:15.548+01:00  INFO 16420 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```
"Many to one" - relationship defined by subordinate table
