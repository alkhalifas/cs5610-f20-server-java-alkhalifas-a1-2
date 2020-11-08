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

  public List<Widget> findWidgetsForTopic(String topicId) {
    return widgetRepository.findWidgetsForTopic(topicId);
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) widgetRepository.findAll();
  }

  public Widget findWidgetById(Integer widgetId) {
    return widgetRepository.findById(widgetId).get();
  }

  public Widget createWidget(Widget widget) {
    return widgetRepository.save(widget);
  }

  public void deleteWidget(Integer wid) {
    widgetRepository.deleteById(wid);
  }


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
      oldWidget.setUrl(newWidget.getUrl());
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
