package com.jerikthedog.SpringDataJpaTutorial.test;

import com.jerikthedog.SpringDataJpaTutorial.entity2.Tweet2;
import com.jerikthedog.SpringDataJpaTutorial.entity2.UserX;
import com.jerikthedog.SpringDataJpaTutorial.repository.TweetRepository;
import com.jerikthedog.SpringDataJpaTutorial.repository.UserXRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Entity2Test {

    @Autowired
    TweetRepository repository;

    @Autowired
    UserXRepository userXRepository;

    @Test
    public void testOneToOne() {

        UserX userX = UserX.builder()
                .id(10)
                .build();

        Tweet2 tweet2 = Tweet2.builder()
                .id(111)
                .userX(userX)
                .build();

        repository.save(tweet2);
        //repository.delete(tweet2);

/*
MANY TO ONE ON SUBORDINATE
Hibernate: select t1_0.tweet_id,u1_0.id from tweet t1_0 left join userx u1_0 on u1_0.id=t1_0.user_id where t1_0.tweet_id=?
Hibernate: select u1_0.id,t1_0.user_id,t1_0.tweet_id from userx u1_0 left join tweet t1_0 on u1_0.id=t1_0.user_id where u1_0.id=?
Hibernate: insert into userx (id) values (?)
Hibernate: insert into tweet (user_id, tweet_id) values (?, ?)
Hibernate: delete from tweet where tweet_id=?
Hibernate: delete from userx where id=?
*/

/*
ONE TO MANY ON MASTER
Hibernate: select t1_0.tweet_id,u1_0.id,t2_0.tweets_id,t2_0.tweet_id from tweet t1_0 left join userx u1_0 on u1_0.id=t1_0.userx_id left join tweet t2_0 on u1_0.id=t2_0.tweets_id where t1_0.tweet_id=?
Hibernate: select u1_0.id,t1_0.tweets_id,t1_0.tweet_id,u2_0.id from userx u1_0 left join tweet t1_0 on u1_0.id=t1_0.tweets_id left join userx u2_0 on u2_0.id=t1_0.userx_id where u1_0.id=?
Hibernate: insert into userx (id) values (?)
Hibernate: insert into tweet (userx_id, tweet_id) values (?, ?)
Hibernate: select t1_0.tweet_id,u1_0.id from tweet t1_0 left join userx u1_0 on u1_0.id=t1_0.userx_id where t1_0.tweet_id=?
Hibernate: select t1_0.tweets_id,t1_0.tweet_id,u1_0.id from tweet t1_0 left join userx u1_0 on u1_0.id=t1_0.userx_id where t1_0.tweets_id=?
Hibernate: delete from tweet where tweet_id=?
Hibernate: delete from userx where id=?
 */

    }

}
