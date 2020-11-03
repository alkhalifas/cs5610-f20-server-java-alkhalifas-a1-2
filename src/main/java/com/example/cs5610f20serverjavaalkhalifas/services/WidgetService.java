package com.example.cs5610f20serverjavaalkhalifas.services;

import com.example.cs5610f20serverjavaalkhalifas.models.Widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {
  List<Widget> widgets = new ArrayList<Widget>();
  {

    widgets.add(new Widget("345", "Widget Name 3",
            "PARAGRAPH", 3, "Machine learning (ML) is the study of computer algorithms that improve automatically through experience. It is seen as a subset of artificial intelligence. Machine learning algorithms build a model based on sample data, known as training data, in order to make predictions or decisions without being explicitly programmed to do so.",
            "Heading 5", 650, 200, "CSS Style Here","style.css", "Some Value", "5fa1c27d0df073001729c69a"));
    widgets.add(new Widget("123", "Widget Name 1",
            "HEADING", 1, "What is Machine Learning?",
            "Heading 3", 650, 200, "CSS Style Here","style.css", "Some Value", "5fa1c27d0df073001729c69a"));

  }

  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> WidgetsList = new ArrayList<Widget>();
    for(Widget w: widgets) {
      if(w.getTopicId().equals(tid)) {
        WidgetsList.add(w);
      }
    }
    Collections.reverse(WidgetsList);
    return WidgetsList;
  }
  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public Widget findWidgetById(String widgetId) {
    for(Widget w: widgets) {
      if(w.getId().equals(widgetId))
        return w;
    }
    return null;
  }

  //When creating a new widget, be sure to change these:
  public Widget createWidget(Widget widget) {
    widget.setId((new Date()).toString());
    widget.setName("New Widget");
    widget.setType("HEADING");
    widget.setWidgetOrder(widgets.size() + 1);
    widget.setSize("Heading 1");
    widget.setWidth(650);
    widget.setHeight(200);
    widget.setText("Widget Text");
    widget.setCssClass("style.css");
    widget.setStyle("Enter Style Here");
    widget.setValue("Initial Value");
    widgets.add(widget);
    return widget;
  }

  public int deleteWidget(String wid) {
    widgets = widgets.stream()
            .filter(w -> !w.getId().equals(wid)).collect(Collectors.toList());
    return 1;
  }

//  public Widget createWidgetForTopic(Widget widget, topicId) {
//    widget.setId((new Date()).toString());
//    widget.setName("New Widget");
//    widget.setType("HEADING");
//    widget.setTopicId(topicId);
//    widgets.add(widget);
//    return widget;
//  }

  // add new attributes to this list when you need them to update the API data

  public Integer updateWidget(
          String wid,
          Widget newWidget) {
    for(Widget w: widgets) {
      if(w.getId().equals(wid)) {
        w.setName(newWidget.getName());
        w.setType(newWidget.getType());
        w.setWidgetOrder(newWidget.getWidgetOrder());
        w.setSize(newWidget.getSize());
        w.setText(newWidget.getText());
        return 1;
      }
    }
    return 0;
  }
}