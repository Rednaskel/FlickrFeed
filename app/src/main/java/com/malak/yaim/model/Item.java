package com.malak.yaim.model;

import java.util.HashMap;
import java.util.Map;

public class Item {

  private String title;
  private String link;
  private Media media;
  private String dateTaken;
  private String description;
  private String published;
  private String author;
  private String authorId;
  private String tags;
  /*TODO Suppose I dont need any of additionalProperties */
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Media getMedia() {
    return media;
  }

  public void setMedia(Media media) {
    this.media = media;
  }

  public String getDateTaken() {
    return dateTaken;
  }

  public void setDateTaken(String dateTaken) {
    this.dateTaken = dateTaken;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPublished() {
    return published;
  }

  public void setPublished(String published) {
    this.published = published;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthorId() {
    return authorId;
  }

  public void setAuthorId(String authorId) {
    this.authorId = authorId;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}