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
    widgets.add(new Widget("123", "Widget Name 1",
            "HEADING", 1, "Sample Heading Text 1",
            "Heading 5", 650, 200, "5f9b36761a4d420017a4384a"));
    widgets.add(new Widget("234", "Widget Name 2",
            "HEADING", 2, "Sample Heading Text 2",
            "Heading 5", 650, 200, "5f9b36761a4d420017a4384a"));
    widgets.add(new Widget("345", "Widget Name 3",
            "HEADING", 3, "Sample Heading Text 3",
            "Heading 5", 650, 200, "5f9b36761a4d420017a4384a"));
    widgets.add(new Widget("456", "Widget Name 4",
            "HEADING", 1, "Sample Heading Text 4",
            "Heading 5", 650, 200, "5f9b36891a4d420017a4384b"));

  }

  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> ws = new ArrayList<Widget>();
    for(Widget w: widgets) {
      if(w.getTopicId().equals(tid)) {
        ws.add(w);
      }
    }
    return ws;
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