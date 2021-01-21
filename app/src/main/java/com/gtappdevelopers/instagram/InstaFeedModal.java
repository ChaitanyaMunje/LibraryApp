package com.gtappdevelopers.instagram;

public class InstaFeedModal {
    //variables for storing our instagra post data.
    private String authorName;
    private String authorImageUrl;
    private String postImgUrl;
    private int likeCount;
    private String postDescription;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorImageUrl() {
        return authorImageUrl;
    }

    public void setAuthorImageUrl(String authorImageUrl) {
        this.authorImageUrl = authorImageUrl;
    }

    public String getPostImgUrl() {
        return postImgUrl;
    }

    public void setPostImgUrl(String postImgUrl) {
        this.postImgUrl = postImgUrl;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public InstaFeedModal(String authorName, String authorImageUrl, String postImgUrl, int likeCount, String postDescription,String location) {
        this.authorName = authorName;
        this.authorImageUrl = authorImageUrl;
        this.postImgUrl = postImgUrl;
        this.likeCount = likeCount;
        this.postDescription = postDescription;
        this.location = location;
    }
}
