/**
 * 
 */
package org.training.services;

import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Date;

/**
 * @author popovicd
 *
 */
public interface CustomCustomerAccountService extends CustomerAccountService
{
	void updateCustomProfile(CustomerModel customerModel, String titleCode, String name, String login, Date date)
			throws DuplicateUidException;
	
	void sendEmail(String body, String subject);
}
