package com.jerikthedog.SpringDataJpaTutorial.OneToOneUsingPrimaryKey;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PKPostgresUserDetails {

    @Id
    private long postgres_user_detail_id;

    private String name;
    private String location;
    private String email;

    @OneToOne
    @MapsId // maps this primary key to our ID key, so e.g. our ID does not have to be generated, since we'll take the referenced value
    @JoinColumn(
            name = "postgres_user_detail_id", // join on PostgresUser's ID column
            referencedColumnName = "id"
    )
    @Cascade(CascadeType.ALL)
    private PKPostgresUser postgresUser;
}
