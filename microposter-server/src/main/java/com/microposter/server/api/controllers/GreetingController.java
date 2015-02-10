package com.microposter.server.api.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * Testing controller.
 */
@Controller
@RequestMapping("/greeting")
public class GreetingController {

private static final Log LOG = LogFactory.getLog(GreetingController.class);

private static final String template = "Hellob, %s!";
private final AtomicLong counter = new AtomicLong();

@RequestMapping(value = "/{name}/{surname}", method = RequestMethod.GET)
@ResponseBody
public Greeting greeting(@PathVariable("name") String name,
                         @PathVariable("surname") String surname) {
  return new Greeting(counter.incrementAndGet(),
      String.format(template, String.format("%s-%s",name, surname)), "tmp");
}
}
