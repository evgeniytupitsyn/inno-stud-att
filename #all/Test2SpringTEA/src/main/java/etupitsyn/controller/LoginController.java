package etupitsyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class LoginController {

	@Autowired
	private MessageSource resource;

	@RequestMapping(value = ActionConsts.LOGIN, method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Map<String, Object> model) {

		if (error != null) {
			model.put("loginMessage", resource.getMessage("login.failed", null, LocaleContextHolder.getLocale()));
		}

		if (logout != null) {
			model.put("loginMessage", resource.getMessage("login.successful", null, LocaleContextHolder.getLocale()));
		}

		return "loginPage";
	}
}
