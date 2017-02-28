package ua.atm.controller.userSecure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by a.lomako on 2/1/2017.
 */
@Controller
public class LinkNavigation {

    /**
     * Navigation for admin.
     * @return new view of first admin page
     */
    @RequestMapping(value = "/admin/first", method = RequestMethod.GET)
    public ModelAndView firstAdminPage() {
        return new ModelAndView("admin/admin-first");
    }

    /**
     * Navigation for admin.
     * @return new view of second admin page
     */
    @RequestMapping(value = "/admin/second", method = RequestMethod.GET)
    public ModelAndView secondAdminPage() {
        return new ModelAndView("admin/admin-second");
    }

}