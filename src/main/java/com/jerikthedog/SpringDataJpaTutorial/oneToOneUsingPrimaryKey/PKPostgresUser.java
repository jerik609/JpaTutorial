package com.jerikthedog.SpringDataJpaTutorial.oneToOneUsingPrimaryKey;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PKPostgresUser {

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

    @OneToOne(
            mappedBy = "postgresUser", // property which maps the one-to-one relationship on the referenced entity
            cascade = CascadeType.ALL
    )
    @PrimaryKeyJoinColumn // we're joining on the primary key here
    private PKPostgresUserDetails postgresUserDetails;

}