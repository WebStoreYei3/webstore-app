package com.webstore;

import com.webstore.core.business.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by oscar on 14/10/2016.
 */
@Controller(value = "index")
@RequestMapping("/")
public class IndexController {
    @Autowired
    UsuarioBusiness usuarioBusiness;
    @RequestMapping(method = RequestMethod.GET)
    public String login() {
         return  "index";
    }

}
