package com.example.cs5610f20serverjavaalkhalifas.models;

public class Widget {

  private String id;
  private String name;
  private String type;
  private Integer widgetOrder;
  private String text;
  private String size;
  private Integer width;
  private Integer height;
  private String topicId;

  // Construction to instantiate object > mostly convenience
  // Overloaded constructor


  public Widget(String id, String name, String type, Integer widgetOrder, String text, String size, Integer width, Integer height, String topicId) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.widgetOrder = widgetOrder;
    this.text = text;
    this.size = size;
    this.width = width;
    this.height = height;
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

  public Integer getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }
}
