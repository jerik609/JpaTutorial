package com.jerikthedog.SpringDataJpaTutorial.test;

import com.jerikthedog.SpringDataJpaTutorial.many2many.Course;
import com.jerikthedog.SpringDataJpaTutorial.many2many.Student;
import com.jerikthedog.SpringDataJpaTutorial.one2many.Post;
import com.jerikthedog.SpringDataJpaTutorial.one2many.Tweet;
import com.jerikthedog.SpringDataJpaTutorial.repository.ManyManyCourseRepository;
import com.jerikthedog.SpringDataJpaTutorial.repository.ManyManyStudentRepository;
import com.jerikthedog.SpringDataJpaTutorial.repository.OneToManyTweetRepository;
import com.jerikthedog.SpringDataJpaTutorial.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class TwitterTest {

    @Autowired
    private OneToManyTweetRepository oneToManyTweetRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ManyManyStudentRepository manyManyStudentRepository;

    @Autowired
    private ManyManyCourseRepository manyManyCourseRepository;

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

    // https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/

    @Test
    public void testCoursePersistenceDefinesTheJoinTable() {

        Student student = Student.builder()
                .courseList(new HashSet<>())
                .build();

        Course course = Course.builder()
                .students(new HashSet<>())
                .build();

        course.addStudent(student);

        System.out.println("student courses before = " + student.getCourseList());
        manyManyCourseRepository.save(course);
        System.out.println("student courses after = " + student.getCourseList());
    }

    // https://www.infoworld.com/article/3387643/java-persistence-with-jpa-and-hibernate-part-2-many-to-many-relationships.html
    
    @Test
    public void testStudentPersistenceUsesMappedBy() {

        Course course = Course.builder()
                .build();

        Student student = Student.builder()
                .build();

        course.addStudent(student);

        System.out.println("course students before = " + course.getStudents());
        manyManyStudentRepository.save(student);
        System.out.println("course students before = " + course.getStudents());

    }


}
