package com.jerikthedog.SpringDataJpaTutorial.bidirectionalOneToOne;

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
    @JoinColumn(
            // the name of the join column, this will be the FK column, which hibernates creates within this table
            name = "user_details_foreign_key",
            // column name of the id, which our FK refers to (id of the "other" table (= PostgresUserDetails key)
            referencedColumnName = "postgres_user_detail_id",
            nullable = false)
    @Cascade(CascadeType.ALL)
    private PostgresUserDetails postgresUserDetails;

}