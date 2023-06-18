package com.ea544.blogproject.vote;

import com.ea544.blogproject.post.Post;
import com.ea544.blogproject.shared.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
public class Vote extends BaseEntity {

    private Integer voteCount = 0;
    @OneToOne(mappedBy = "vote")
    private Post post;

    public void upVote() {
        voteCount = voteCount + 1;
    }

    public void downVote() {
        voteCount = voteCount - 1;
    }
}
