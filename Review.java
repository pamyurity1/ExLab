package com.example.demo.Entity;

import lombok.NonNull;

import javax.persistence.*;

@Entity

public class Review {

    public Long getReview_id() { return review_id; }
    public void setReview_id(Long review_id) { this.review_id = review_id; }
    public String getComment_review() { return comment_review; }
    public void setComment_review(String comment_review) { this.comment_review = comment_review; }
    public Review(String comment_review){ this.comment_review = comment_review; }
    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
    public SystemName getSystemName() { return systemName; }
    public void setSystemName(SystemName systemName) { this.systemName = systemName; }
    public Score getScore() { return score; }
    public void setScore(Score score) { this.score = score; }

    @Id
    @SequenceGenerator(name="review_seq",sequenceName="review_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="review_seq")
    private @NonNull Long review_id;
    private @NonNull String comment_review;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Member_ID", insertable = true)
    private Member member;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "SystemStudio_ID", insertable = true)
    private SystemName systemName;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Score_ID", insertable = true)
    private Score score;

    public Review(){}

    public Review(Member member, SystemName systemName,Score score,String comment_review){
        this.member = member;
        this.systemName = systemName;
        this.score = score;
        this.comment_review = comment_review;

    }


}
