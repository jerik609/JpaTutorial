package com.jerikthedog.SpringDataJpaTutorial.neo_entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/* freaking postgresql with freaking reserved "user" freaking keyword! */

// https://www.baeldung.com/jpa-one-to-one

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostgresUser {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1,
            initialValue = 7777777
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;

    @OneToOne
    //@JoinColumn(name = "user_details_foreign_key", nullable = false)
    @PrimaryKeyJoinColumn(name = "name = user_details_foreign_key")
    @Cascade(CascadeType.ALL)
    private PostgresUserDetails postgresUserDetails;

}