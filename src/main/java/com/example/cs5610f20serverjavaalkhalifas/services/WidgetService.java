package com.example.cs5610f20serverjavaalkhalifas.services;

import com.example.cs5610f20serverjavaalkhalifas.models.Widget;
import com.example.cs5610f20serverjavaalkhalifas.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository widgetRepository;

//  List<Widget> widgets = new ArrayList<Widget>();
//  {
//
//    widgets.add(new Widget(345, "Widget Name 3",
//            "PARAGRAPH", 3, "Machine learning (ML) is the study of computer algorithms that improve automatically through experience. It is seen as a subset of artificial intelligence. Machine learning algorithms build a model based on sample data, known as training data, in order to make predictions or decisions without being explicitly programmed to do so.",
//            "Heading 5", 650, 200, "CSS Style Here","style.css", "Some Value", "5fa1c27d0df073001729c69a"));
//    widgets.add(new Widget(123, "Widget Name 1",
//            "HEADING", 1, "What is Machine Learning?",
//            "Heading 3", 650, 200, "CSS Style Here","style.css", "Some Value", "5fa1c27d0df073001729c69a"));
//
//  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    return widgetRepository.findWidgetsForTopic(topicId);
//    List<Widget> WidgetsList = new ArrayList<Widget>();
//    for(Widget w: widgets) {
//      if(w.getTopicId().equals(tid)) {
//        WidgetsList.add(w);
//      }
//    }
//    Collections.reverse(WidgetsList);
//    return WidgetsList;
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) widgetRepository.findAll();
  }

  public Widget findWidgetById(Integer widgetId) {
    return widgetRepository.findById(widgetId).get();
//    for(Widget w: widgets) {
//      if(w.getId().equals(widgetId))
//        return w;
//    }
//    return null;
  }

  //When creating a new widget, be sure to change these:
  public Widget createWidget(Widget widget) {
    return widgetRepository.save(widget);

//    widget.setId((new Date()).toString());
//    widget.setId(123);
//    widget.setName("New Widget");
//    widget.setType("HEADING");
//    widget.setWidgetOrder(widgets.size() + 1);
//    widget.setSize("Heading 1");
//    widget.setWidth(650);
//    widget.setHeight(200);
//    widget.setText("Widget Text");
//    widget.setCssClass("style.css");
//    widget.setStyle("Enter Style Here");
//    widget.setValue("Initial Value");
//    widgets.add(widget);
//    return widget;
  }

  public void deleteWidget(Integer wid) {
    widgetRepository.deleteById(wid);
//    widgets = widgets.stream()
//            .filter(w -> !w.getId().equals(wid)).collect(Collectors.toList());
//    return 1;
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

  public Widget updateWidget(
          Integer wid,
          Widget newWidget) {
    Optional oldWidgetO = widgetRepository.findById(wid);
    if (oldWidgetO.isPresent()) {
      Widget oldWidget = (Widget) oldWidgetO.get();
      oldWidget.setName(newWidget.getName());
      oldWidget.setType(newWidget.getType());
      oldWidget.setWidgetOrder(newWidget.getWidgetOrder());
      oldWidget.setText(newWidget.getText());
      oldWidget.setSize(newWidget.getSize());
      oldWidget.setWidth(newWidget.getWidth());
      oldWidget.setHeight(newWidget.getHeight());
      oldWidget.setCssClass(newWidget.getCssClass());
      oldWidget.setStyle(newWidget.getStyle());
      oldWidget.setValue(newWidget.getValue());
      oldWidget.setTopicId(newWidget.getTopicId());


      return widgetRepository.save(oldWidget);
    } else {
      return null;
    }
  }


}
