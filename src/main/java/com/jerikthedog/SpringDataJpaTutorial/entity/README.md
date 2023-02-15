## One To Many (= one-to-many & many-to-one)

- there are many ways how to solve this, but not all of them are efficient, since hibernate tends to generate queries differently for each approach
- we need to consider if we have a unidirectional or bidirectional mapping (bi = A has reference to B and B has reference to A)
- the relationship is always Parent->Child (child being on the "many" side, parent being on the "one" side)

so one-to-many vs @OneToMany/@ManyToOne -> it's all about efficient sql statements generated "under the hood" (= always check logs in the dev phase!)

- https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
- https://vladmihalcea.com/14-high-performance-java-persistence-tips/
- https://vladmihalcea.com/the-open-session-in-view-anti-pattern/

@ManyToOne with custom jpql to map "from parent to child" is the way to go, see ^^^

## Many TO Many

in one-to-many and one-to-one, we could always just assign a foreign key to one of the tables in the relationship

here it would be complicated, so how do we do that (hint - the "join table") a new (third) table, which will connect those two tables via keys

- https://thorben-janssen.com/best-practices-many-one-one-many-associations-mappings/
- https://stackoverflow.com/questions/3113885/difference-between-one-to-many-many-to-one-and-many-to-many
- https://www.baeldung.com/jpa-many-to-many

https://www.baeldung.com/jpa-many-to-many

An example is students and courses : "A student can opt for many courses and course can be visited by many students."

-> so student can have many entries differing on course id as foreign key
-> courses can have many students
