package com.microposter.server.api.controllers;

import com.microposter.server.api.domain.FBUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/social")
public class SocialController {
private static final Log LOG = LogFactory.getLog(SocialController.class);
private static final String FB_APP_NAME = "wenudgeyouappdev";

@RequestMapping(value = "/fb/{token}", method = RequestMethod.POST)
@ResponseBody
public FacebookProfile fbAuthHandler(@PathVariable("token") String token) {
  try {
    if(token != null) {
      FacebookTemplate fbTemplate = new FacebookTemplate(token, FB_APP_NAME);
      return fbTemplate.userOperations().getUserProfile();
    }
  } catch (Exception ex) {
    LOG.error(ex.getMessage());
  }
  return null;
}
}
