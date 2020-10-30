package com.example.cs5610f20serverjavaalkhalifas.services;

import com.example.cs5610f20serverjavaalkhalifas.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WidgetService {
  List<Widget> widgets = new ArrayList<Widget>();
  {
    widgets.add(new Widget("123", "Machine Learning", "HEADING", "5f9b36761a4d420017a4384a"));
    widgets.add(new Widget("234", "ML Theory", "PARAGRAPH", "5f9b36761a4d420017a4384a"));
    widgets.add(new Widget("345", "Deep Learning Theory", "HEADING", "5f9b36891a4d420017a4384b"));
    widgets.add(new Widget("456", "NLP Theory", "HEADING", "5f9b36951a4d420017a4384c"));
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

  public Widget createWidget(Widget widget) {
    widget.setId((new Date()).toString());
    widget.setName("New Widget"); // Did not make difference
    widget.setType("HEADING"); // Did not make difference
    widgets.add(widget);
    return widget;
  }

  public int deleteWidget(String wid) {
    for (Widget widget : widgets) {
      if (widget.getTopicId().equals(wid)) {
        widgets.remove(widget);
        return 1;
      }
    }
    return 0;
  }

//  public Widget createWidgetForTopic(Widget widget, topicId) {
//    widget.setId((new Date()).toString());
//    widget.setName("New Widget");
//    widget.setType("HEADING");
//    widget.setTopicId(topicId);
//    widgets.add(widget);
//    return widget;
//  }

  public Integer updateWidget(
          String widgetId,
          Widget newWidget) {
    for(Widget w: widgets) {
      if(w.getId().equals(widgetId)) {
        w.setName(newWidget.getName());
        w.setType(newWidget.getType());
        return 1;
      }
    }
    return 0;
  }
}