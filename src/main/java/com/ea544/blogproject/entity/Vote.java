package com.ea544.blogproject.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Vote extends BaseEntity {

    private Integer voteCount;

    public void upVote() {
        voteCount++;
    }

    public void downVote() {
        voteCount--;
    }

}
