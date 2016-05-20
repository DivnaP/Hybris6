package org.training.services.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;
import de.hybris.platform.commerceservices.event.RegisterEvent;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.training.core.event.ContactUsEvent;
import org.training.services.CustomCustomerAccountService;


/**
 * 
 */

/**
 * @author popovicd
 *
 */
public class DefaultCustomCustomerAccountService extends
		de.hybris.platform.commerceservices.customer.impl.DefaultCustomerAccountService implements CustomCustomerAccountService
{
	@Deprecated
	@Override
	public void updateCustomProfile(final CustomerModel customerModel, final String titleCode, final String name,
			final String login, final Date date) throws DuplicateUidException
	{
		validateParameterNotNullStandardMessage("customerModel", customerModel);

		customerModel.setUid(login);
		customerModel.setName(name);
		customerModel.setBirthdate(date);
		if (StringUtils.isNotBlank(titleCode))
		{
			customerModel.setTitle(getUserService().getTitleForCode(titleCode));
		}
		else
		{
			customerModel.setTitle(null);
		}
		internalSaveCustomer(customerModel);
	}

}
