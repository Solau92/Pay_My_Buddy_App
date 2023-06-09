package com.paymybuddy.paymybuddyapp.controller;

import com.paymybuddy.paymybuddyapp.dto.TransferDto;
import com.paymybuddy.paymybuddyapp.entity.User;
import com.paymybuddy.paymybuddyapp.exception.ContactNotFoundException;
import com.paymybuddy.paymybuddyapp.exception.IncorrectAmountException;
import com.paymybuddy.paymybuddyapp.exception.InsufficientBalanceException;
import com.paymybuddy.paymybuddyapp.exception.UserNotFoundException;
import com.paymybuddy.paymybuddyapp.service.TransferService;
import com.paymybuddy.paymybuddyapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class TransferController {

	private UserService userService;
	private TransferService transferService;
	private String message;

	public TransferController(UserService userService, TransferService transferService) {
		this.userService = userService;
		this.transferService = transferService;
	}

	public String getMessage() {
		return message;
	}

	@GetMapping("/user/transfer")
	public String transfer(Model model) throws UserNotFoundException, ContactNotFoundException {

		TransferDto transfer = new TransferDto();
		model.addAttribute("transfer", transfer);

		User loggedUser = userService.getLoggedUser();

		if (loggedUser == null) {
			message = "Logged user not found";
			log.info("Transfer error page");
			return "redirect:/user/transfer?error";
		}

		List<TransferDto> transfersDone = transferService.findAllUsersTransfers(loggedUser);

		model.addAttribute("transfersDone", transfersDone);

		List<User> connections = userService.getLoggedUser().getContacts();
		model.addAttribute("connections", connections);

		model.addAttribute("message", message);

		log.info("Transfer page");

		return "transfer";
	}

	@PostMapping("/user/transfer/pay")
	public String addTransfer(@ModelAttribute("transfer") TransferDto transferDto,
	                          BindingResult result,
	                          Model model) {

		User loggedUser = userService.getLoggedUser();

		if (loggedUser == null) {
			message = "Logged user not found, the transfer was not effected";
			log.info("Transfer error page");
			return "redirect:/user/transfer?error";
		}

		try {

			transferService.saveTransfer(loggedUser, transferDto);

			message = "The transfer was successfully done ! You have now " + loggedUser.getAccountBalance() + " € on your account";

			log.info("Transfer success page");

			return "redirect:/user/transfer?success";

		} catch (Exception exception) {

			if (exception instanceof InsufficientBalanceException) {
				double availableAMount = Math.floor(loggedUser.getAccountBalance() / 1.005 * 100) / 100;
				message = "Your balance account is insufficient, the transfer was not effected. You can send a maximum of " + availableAMount + " €";
			} else if (exception instanceof IncorrectAmountException) {
				message = "Amount equals zero, the transfer was not effected";
			} else if (exception instanceof ContactNotFoundException) {
				message = "No contact selected, the transfer was not effected";
			} else {
				message = "Unknown error, the transfer was not effected";
			}
			log.info("Transfer error page");

			return "redirect:/user/transfer?error";
		}
	}

}
