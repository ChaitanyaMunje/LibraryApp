package com.gtappdevelopers.instagram;

public class FacebookFeedModal {
    //variables for storing our author image,author name, postDate,postDescription,post image,post likes,post comments.
    private String authorImage;
    private String authorName;
    private String postDate;
    private String postDescription;
    private String postIV;
    private String postLikes;
    private String postComments;
    //creating getter and setter methods.

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostIV() {
        return postIV;
    }

    public void setPostIV(String postIV) {
        this.postIV = postIV;
    }

    public String getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(String postLikes) {
        this.postLikes = postLikes;
    }

    public String getPostComments() {
        return postComments;
    }

    public void setPostComments(String postComments) {
        this.postComments = postComments;
    }

    //creating a constructor class.
    public FacebookFeedModal(String authorImage, String authorName, String postDate, String postDescription, String postIV, String postLikes, String postComments) {
        this.authorImage = authorImage;
        this.authorName = authorName;
        this.postDate = postDate;
        this.postDescription = postDescription;
        this.postIV = postIV;
        this.postLikes = postLikes;
        this.postComments = postComments;
    }
}
