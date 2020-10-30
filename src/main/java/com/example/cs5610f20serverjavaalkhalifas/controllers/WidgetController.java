package com.example.cs5610f20serverjavaalkhalifas.controllers;

import com.example.cs5610f20serverjavaalkhalifas.models.Widget;
import com.example.cs5610f20serverjavaalkhalifas.services.WidgetService;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
  WidgetService service = new WidgetService();

  @GetMapping("/hello")
  public String sayHello() {
    return "Hello World!!";
  }

  @GetMapping("/api/topics/{topicId}/widgets")
  public List<Widget> findWidgetsForTopic(
          @PathVariable("topicId") String topicId) {
    return service.findWidgetsForTopic(topicId);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(
          @PathVariable("wid") String widgetId) {
    return service.findWidgetById(widgetId);
  }

  @PostMapping("/api/widgets")
  public Widget createWidget(
          @RequestBody Widget widget) {
    return service.createWidget(widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public int deleteWidget(@PathVariable("wid") String wid) {
    return service.deleteWidget(wid);
  }

  @PostMapping("/api/topics/{topicId}/widgets")
  public Widget createWidgetForTopic(
          @PathVariable("topicId") String topicId,
          @RequestBody Widget widget) {
    widget.setTopicId(topicId);
    //widget.setType("HEADING"); // Did not make difference
    return service.createWidget(widget);
  }

  @PutMapping("/api/widgets/{wid}")
  public Integer updateWidget(
          @PathVariable("wid") String widgetId,
          @RequestBody Widget newWidget) {
    return service.updateWidget(widgetId, newWidget);
  }
  // TODO: updateWidget, deleteWidget
}