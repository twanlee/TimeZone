package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

@org.springframework.stereotype.Controller
public class Controller {
   @GetMapping("/time")
    public String showForm(Model model, @RequestParam
                                      (
                                              name = "city",
                                              required = false,
                                              defaultValue = "Asia/Ho_Chi_Minh"

                                      ) String city
                           ){
       Date date = new Date();
       TimeZone local = TimeZone.getDefault();
       TimeZone locale = TimeZone.getTimeZone(city);
       long locale_time = date.getTime()+(locale.getRawOffset()-local.getRawOffset());
       date.setTime(locale_time) ;

       model.addAttribute("city",city);
       model.addAttribute("date",date);

        return "index";
   }

}
