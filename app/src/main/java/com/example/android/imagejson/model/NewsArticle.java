package com.example.android.imagejson.model;

import com.google.gson.annotations.SerializedName;

public class NewsArticle {
    /**
     * source : {"id":"the-wall-street-journal","name":"The Wall Street Journal"}
     * author : Ben Fritz
     * title : MoviePass Slashes Offering to Three Films a Month
     * description : Short on cash, battered by investors and pronounced dead by critics recently, MoviePass will soon begin limiting customers to three movies a month, a major change from its current allowance of one a day.
     * url : https://www.wsj.com/articles/moviepass-slashes-offering-to-three-films-a-month-1533560401
     * urlToImage : https://images.wsj.net/im-20952/social
     * publishedAt : 2018-08-06T13:03:36Z
     */

    @SerializedName("source")
    private SourceBean source;
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("urlToImage")
    private String urlToImage;
    @SerializedName("publishedAt")
    private String publishedAt;

    public SourceBean getSource() {
        return source;
    }

    public void setSource(SourceBean source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
