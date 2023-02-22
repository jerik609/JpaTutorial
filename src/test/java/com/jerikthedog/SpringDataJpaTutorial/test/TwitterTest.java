package com.jerikthedog.SpringDataJpaTutorial.test;

import com.jerikthedog.SpringDataJpaTutorial.one2many.Post;
import com.jerikthedog.SpringDataJpaTutorial.one2many.Tweet;
import com.jerikthedog.SpringDataJpaTutorial.repository.OneToManyTweetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TwitterTest {

    @Autowired
    private OneToManyTweetRepository oneToManyTweetRepository;

    @Test
    public void testTweets() {

        Post post = Post.builder()
                .text("replying to you tweet")
                .build();

        Tweet tweet = Tweet.builder()
                .text("the tweet text")
                .postList(List.of(post))
                .build();

        oneToManyTweetRepository.save(tweet);
    }

}
