// many-to-many -> student and courses

student can opt for many courses and course can be visited by many students

-> so student can have many entries differing on course id as foreign key
-> courses can have many students

this is done using a THIRD table! a new table, for many-many

in one-to-many and one-to-one, we could always just assign a foreign key to one of the tables in the relationship
for many-to-many, this would 

- https://thorben-janssen.com/best-practices-many-one-one-many-associations-mappings/
- https://stackoverflow.com/questions/3113885/difference-between-one-to-many-many-to-one-and-many-to-many
- https://www.baeldung.com/jpa-many-to-many

one-to-many vs @OneToMany / @ManyToOne -> it's all about efficient sql statements generated "under the hood"

- https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
- https://vladmihalcea.com/14-high-performance-java-persistence-tips/
- https://vladmihalcea.com/the-open-session-in-view-anti-pattern/

@ManyToOne with custom jpql to map "from parent to child" is the way to go, see ^^^
