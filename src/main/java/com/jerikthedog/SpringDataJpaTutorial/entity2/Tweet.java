package com.jerikthedog.SpringDataJpaTutorial.entity2;

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
public class Tweet {

    @Id
    @Column(name = "tweet_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "userX_id")
    @Cascade(CascadeType.ALL)
    private UserX userX;
}