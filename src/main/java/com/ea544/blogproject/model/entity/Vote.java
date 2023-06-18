package com.ea544.blogproject.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


//@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@Entity
public class Vote extends BaseEntity {


    private Integer voteCount;
    //    @JsonManagedReference
    @OneToOne
    private Post post;

    public void upVote() {
        voteCount++;
    }

    public void downVote() {
        voteCount--;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Vote setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Vote setPost(Post post) {
        this.post = post;
        return this;
    }
}
