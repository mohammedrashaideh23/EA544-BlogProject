package com.ea544.blogproject.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
