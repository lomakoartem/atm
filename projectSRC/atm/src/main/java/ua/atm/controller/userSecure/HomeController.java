package ua.atm.controller.userSecure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.atm.domain.users.User;
import ua.atm.infrastructure.exceptions.EntityNotFoundException;
import ua.atm.service.usersService.PlayerService;

import java.util.HashMap;
import java.util.Map;


@Controller
public class HomeController {

    @Autowired
    private PlayerService userService;

    /**
     * Register user in system.
     * @param user
     * @param result
     * @return model and view
     */
    @RequestMapping("/register")
    public ModelAndView getRegisterForm(@ModelAttribute("user") User user,
                                        BindingResult result) {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView("register/Register", "model", model);
    }

    /**
     * Saves user in database and redirects to home page
     * @param user
     * @param result
     * @return model and view.
     */
    @RequestMapping("/saveUser")
    public ModelAndView saveUserData(@ModelAttribute("user") User user,
                                     BindingResult result) {

   /*   if(userService.getUserByEmail(user.getEmail())!=null ||
              userService.getUserByLogin(user.getUser_login())!=null)
      {
                throw  new UsernameNotFoundException("User with this credentials already exists");
      }*/
        userService.addUser(user);
        return new ModelAndView("redirect:/");
    }

    /**
     * Get users list. Available only for role admin .
     * @return model and view
     */
    @RequestMapping("/admin/userList")
    public ModelAndView getUserList() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user", userService.findAll());
        return new ModelAndView("info/UserDetails", model);
    }

    /**
     * Get information about current user.
     * @return model and view
     */
    @RequestMapping("/getPlayerInfo")
    public ModelAndView getUserInformation() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserById(userService.getUserByLogin(auth.getName()));
        Map<String, Object> model = new HashMap<String, Object>();
        System.out.println(user.toString());
        model.put("user", user);
        return new ModelAndView("info/UserDetail", model);
    }

    /**
     * Generate password for user and sent by mail.
     * @param email
     * @return model and view
     */
    @RequestMapping(value = "/generatePassword")
    public ModelAndView generatePasswordForPlayer(String email) {
        User user = userService.getUserByEmail(email);
        if (user.getId() == null) throw new UsernameNotFoundException("User not in db");
        userService.generatePasswordAndSendByMail(user.getId());
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/admin/editplayer/{id}")
    public ModelAndView editplayer(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return new ModelAndView("infrastructure/playereditform", "command", user);
    }

    /**
     * Edit users of the system. Available only for admin role.
     * @param user
     * @return
     */
    @RequestMapping(value = "/admin/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("player") User user) {
        userService.updateUser(user);
        return new ModelAndView("redirect:/admin/userList");
    }

    /**
     * Delete user. Available only for admin role.
     * @param id
     * @return model and view
     */
    @RequestMapping(value = "/admin/deleteplayer/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/admin/userList");
    }

    @ExceptionHandler({UsernameNotFoundException.class, java.sql.SQLException.class, EntityNotFoundException.class})
    public ModelAndView handleIOException(Exception ex) {
        ModelAndView model = new ModelAndView("errors/error");

        model.addObject("exception", ex.getMessage());

        return model;
    }
}
