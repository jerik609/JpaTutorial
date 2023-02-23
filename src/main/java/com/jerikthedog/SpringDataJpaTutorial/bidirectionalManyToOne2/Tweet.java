package com.jerikthedog.SpringDataJpaTutorial.bidirectionalManyToOne2;

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
public class Tweet {

    @Id
    private long tweetId;

    private String text;

    @OneToMany(mappedBy = "tweet") // A
    @Cascade(CascadeType.ALL) // B
    private List<Post> postList; // C

//    @OneToMany
//    @JoinColumn(
//            name = "tweet_id_foreign_key",
//            referencedColumnName = "tweetId"
//    )
//    @Cascade(CascadeType.ALL)
//    private List<Post> postList;
}
