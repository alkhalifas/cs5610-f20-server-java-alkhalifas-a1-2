package com.example.cs5610f20serverjavaalkhalifas.models;

public class Widget {

  private String id;
  private String name;
  private String type;
  private String topicId;

  // Construction to instantiate object > mostly convenience
  // Overloaded constructor
  public Widget(String id, String name, String type, String topicId) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.topicId = topicId;
  }

  // Required!
  // No argument constructor
  public Widget() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }
}
