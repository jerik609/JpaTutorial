package com.jerikthedog.SpringDataJpaTutorial.one2many;

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
public class Post {

    @Id
    private long postId;

    private String text;

    @ManyToOne // 1
    @JoinColumn(name = "tweet_id_foreign_key", referencedColumnName = "tweetId") // 2
    @Cascade(CascadeType.ALL) // 3
    private Tweet tweet; // 4
}
