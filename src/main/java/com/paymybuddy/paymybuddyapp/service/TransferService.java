package com.paymybuddy.paymybuddyapp.service;

import com.paymybuddy.paymybuddyapp.dto.TransferDto;
import com.paymybuddy.paymybuddyapp.entity.Transfer;
import com.paymybuddy.paymybuddyapp.entity.User;
import com.paymybuddy.paymybuddyapp.exception.ContactNotFoundException;
import com.paymybuddy.paymybuddyapp.exception.IncorrectAmountException;
import com.paymybuddy.paymybuddyapp.exception.UserNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;

public interface TransferService {

	/**
	 * Saves the transfer if the transfer attributes are valid.
	 *
	 * @param transferDto
	 * @throws IncorrectAmountException
	 */
	@Transactional
	Transfer saveTransfer(User loggedUser, TransferDto transferDto) throws Exception;

	/**
	 * Returns the list of TransferDto done by the User given in parameter.
	 *
	 * @param user
	 * @return list of TransferDto
	 */
	List<TransferDto> findAllUsersTransfers(User user) throws ContactNotFoundException, UserNotFoundException;

}
