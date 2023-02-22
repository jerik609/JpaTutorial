package com.jerikthedog.SpringDataJpaTutorial.entity2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserX {

    @Id
    private long id;

    // https://www.baeldung.com/jpa-joincolumn-vs-mappedby

    // https://vladmihalcea.com/spring-transaction-best-practices/

    // https://vladmihalcea.com/jpa-hibernate-second-level-cache/

    // just wow: https://vladmihalcea.com/best-spring-data-jparepository/

    // https://stackoverflow.com/questions/3113885/difference-between-one-to-many-many-to-one-and-many-to-many

    @OneToMany(mappedBy = "userX")
//    @JoinColumn(
//            name = "userX_id", // name of the joining column (our custom name)
//            referencedColumnName = "id" // this user id
//    )
    @Cascade(CascadeType.ALL)
    private List<Tweet2> tweet2s;

}