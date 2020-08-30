package Controller;

import Model.Store;
import Model.StoreDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HelloWeb {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String HelloController(ModelMap model) {
        return "hello";


    }

    @RequestMapping(value = "/stores", method = RequestMethod.POST)
    public ModelAndView storeLoader(ModelAndView modelAndView) {
        List<Store> storeList = StoreDao.getStores();
        modelAndView.addObject("storeList", storeList);
        modelAndView.setViewName("store");
        return modelAndView;
    }

    @RequestMapping(value = "/putLocation", method = RequestMethod.GET)
    public ModelAndView logCourierLocation(@RequestParam(value = "courier") int courierId, @RequestParam(value = "time") long time, @RequestParam(value = "lat") double latitude, @RequestParam(value = "lng") double longitude, ModelAndView modelAndView) {
        LogCourierCommand logCourierCommand = new LogCourierCommand(longitude, latitude, time, courierId);
        logCourierCommand.processCommand();
        String result = logCourierCommand.getResult();
        modelAndView.addObject("resultMessage", result);
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping(value = "/getTotalTravelDistance", method = RequestMethod.GET)
    public ModelAndView getTotalTravelDistance(@RequestParam(value="courier") int courierId, ModelAndView modelAndView) {
        double totalTravelDistance = CourierUtils.getTotalTravelDistance(courierId);
        String message = "Total travel distance for courier with id : %s is %s";
        modelAndView.addObject("totalTravelDistanceForCourier", String.format(message,courierId,totalTravelDistance));
        modelAndView.setViewName("hello");
        return modelAndView;
    }

}
