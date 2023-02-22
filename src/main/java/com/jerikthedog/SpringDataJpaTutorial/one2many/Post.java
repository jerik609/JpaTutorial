package com.jerikthedog.SpringDataJpaTutorial.one2many;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    private long postId;

    private String text;
}
