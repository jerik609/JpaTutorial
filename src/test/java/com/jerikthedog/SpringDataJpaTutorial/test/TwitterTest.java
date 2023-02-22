package com.jerikthedog.SpringDataJpaTutorial.test;

import com.jerikthedog.SpringDataJpaTutorial.many2many.Course;
import com.jerikthedog.SpringDataJpaTutorial.many2many.Student;
import com.jerikthedog.SpringDataJpaTutorial.one2many.Post;
import com.jerikthedog.SpringDataJpaTutorial.one2many.Tweet;
import com.jerikthedog.SpringDataJpaTutorial.repository.ManyManyStudentRepository;
import com.jerikthedog.SpringDataJpaTutorial.repository.OneToManyTweetRepository;
import com.jerikthedog.SpringDataJpaTutorial.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TwitterTest {

    @Autowired
    private OneToManyTweetRepository oneToManyTweetRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ManyManyStudentRepository manyManyStudentRepository;

    @Test
    public void testTweets() {

        Post post = Post.builder()
                .text("replying to you tweet")
//                .tweet(tweet)
                .build();


        Tweet tweet = Tweet.builder()
                .text("the tweet text")
                .postList(List.of(post))
                .build();


        oneToManyTweetRepository.save(tweet);
        //postRepository.save(post);
    }

    @Test
    public void manymanymany() {

        Course course = Course.builder()
                .build();

        Student student = Student.builder()
                .courseList(List.of(course))
                .build();

//        manyManyStudentRepository.save(student);

    }

}
