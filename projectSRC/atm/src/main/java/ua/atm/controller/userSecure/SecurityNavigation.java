package ua.atm.controller.userSecure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by a.lomako on 2/1/2017.
 */
@Controller
public class SecurityNavigation {

    /**
     *
     * @return  login page view.
     */
    @RequestMapping(value = "/user-login", method = RequestMethod.GET)
    public ModelAndView loginForm() {
        return new ModelAndView("login/login-form");
    }

    /**
     *
     * @return  login page view.
     */
    @RequestMapping(value = "/error-login", method = RequestMethod.GET)
    public ModelAndView invalidLogin() {
        ModelAndView modelAndView = new ModelAndView("login/login-form");
        modelAndView.addObject("error", true);
        return modelAndView;
    }

    /**
     *
     * @return password recovery view.
     */
    @RequestMapping(value = "/password-recovery", method = RequestMethod.GET)
    public ModelAndView passwordRecovert() {
        return new ModelAndView("infrastructure/passwordRecovery");
    }

    /**
     *
     * @return success login view.
     */
    @RequestMapping(value = "/success-login", method = RequestMethod.GET)
    public ModelAndView successLogin() {
        return new ModelAndView("login/success-login");
    }
}
