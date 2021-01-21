package com.gtappdevelopers.instagram;

public class InstaModal {
//variables for storing data of our recycler view item
private String id;
private String media_type;
private String permalink;
private String media_url;
private String username;
private String caption;
private String timestamp;

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    private String author_url;
private int likesCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public InstaModal(String id, String media_type, String permalink, String media_url, String username, String caption, String timestamp, String author_url, int likesCount) {
        this.id = id;
        this.media_type = media_type;
        this.permalink = permalink;
        this.media_url = media_url;
        this.username = username;
        this.caption = caption;
        this.timestamp = timestamp;
        this.author_url = author_url;
        this.likesCount = likesCount;
    }
}
