package com.jerikthedog.SpringDataJpaTutorial.bidirectionalOneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostgresUserDetails {

    @Id
    @SequenceGenerator(
            name = "user_details_sequence",
            sequenceName = "user_details_sequence",
            allocationSize = 1,
            initialValue = 1111111
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_details_sequence"
    )
    private long postgres_user_detail_id;

    private String name;
    private String location;
    private String email;

    @OneToOne(mappedBy = "postgresUserDetails")
    private PostgresUser postgresUser;
}

/* I think the example for one-to-one unidirectional relationship is plainly wrong and utterly confusing.

This is how it works: https://www.baeldung.com/jpa-one-to-one

Basically when JPA/Hibernate is given this ...

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "user_details_fk", nullable = false)
    private UserDetails user_details;

}

... the table "tbl_user" will be created, with two columns - the primary key "id" column and the "user_details_fk" foreign key column (which refers to user details. A foreign key constraint will be defined. The owner of the foreign key (constraint) will be

*/