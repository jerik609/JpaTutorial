# JpaTutorial
JPA tutorial

Based on: https://youtube.com/watch?v=XszpXoII9Sg&feature=shares

## Notes

### Default CRUD and transactions

- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#transactions

By default, CRUD methods on repository instances inherited from SimpleJpaRepository are transactional.
For read operations, the transaction configuration readOnly flag is set to true.
All others are configured with a plain @Transactional so that default transaction configuration applies.
Repository methods that are backed by transactional repository fragments inherit the transactional attributes from the actual fragment method.

## Links

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

https://www.marcobehler.com/guides/spring-transaction-management-transactional-in-depth

https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#transaction-declarative-annotations)

https://www.postgresql.org/docs/9.5/transaction-iso.html

https://spring.io/blog/2019/05/16/reactive-transactions-with-spring

https://www.baeldung.com/jpa-hibernate-persistence-context

https://www.baeldung.com/transaction-configuration-with-jpa-and-spring

https://www.digitalocean.com/community/tutorials/spring-orm-example-jpa-hibernate-transaction