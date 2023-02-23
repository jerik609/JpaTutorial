package com.jerikthedog.SpringDataJpaTutorial.oneToOneUsingPrimaryKey;

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
            // the name of the key within this table - will replace the name of existing key, since we're "MapsId"-ing here
            name = "overrides_the_name_of_the_key_of_this_table",
            // referenced column = key at the "other" table
            referencedColumnName = "id"
    )
    @Cascade(CascadeType.ALL)
    private PKPostgresUser postgresUser;
}
