/**
 * 
 */
package org.training.facades.customer.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.model.user.UserModel;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.training.services.CustomCustomerAccountService;


/**
 * @author popovicd
 *
 */
public class CustomCustomerFacade extends DefaultCustomerFacade
{
	private CustomCustomerAccountService customCustomerAccountService;

	/**
	 * @return the customerAccountService
	 */
	public CustomCustomerAccountService getCustomCustomerAccountService()
	{
		return customCustomerAccountService;
	}

	/**
	 * @param customerAccountService
	 *           the customerAccountService to set
	 */
	public void setCustomCustomerAccountService(CustomCustomerAccountService customCustomerAccountService)
	{
		this.customCustomerAccountService = customCustomerAccountService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade#register(de.hybris.platform.commercefacades
	 * .user.data.RegisterData)
	 */
	@Override
	public void register(RegisterData registerData) throws DuplicateUidException
	{
		validateParameterNotNullStandardMessage("registerData", registerData);
		Assert.hasText(registerData.getFirstName(), "The field [FirstName] cannot be empty");
		Assert.hasText(registerData.getLastName(), "The field [LastName] cannot be empty");
		Assert.hasText(registerData.getLogin(), "The field [Login] cannot be empty");

		final CustomerModel newCustomer = getModelService().create(CustomerModel.class);
		newCustomer.setName(getCustomerNameStrategy().getName(registerData.getFirstName(), registerData.getLastName()));
		newCustomer.setBirthdate(registerData.getBirthdate());
		if (StringUtils.isNotBlank(registerData.getFirstName()) && StringUtils.isNotBlank(registerData.getLastName()))
		{
			newCustomer.setName(getCustomerNameStrategy().getName(registerData.getFirstName(), registerData.getLastName()));
		}
		final TitleModel title = getUserService().getTitleForCode(registerData.getTitleCode());
		newCustomer.setTitle(title);
		setUidForRegister(registerData, newCustomer);
		newCustomer.setSessionLanguage(getCommonI18NService().getCurrentLanguage());
		newCustomer.setSessionCurrency(getCommonI18NService().getCurrentCurrency());
		getCustomCustomerAccountService().register(newCustomer, registerData.getPassword());
	}

	@Override
	public void updateProfile(final CustomerData customerData) throws DuplicateUidException
	{
		validateDataBeforeUpdate(customerData);
		final String name = getCustomerNameStrategy().getName(customerData.getFirstName(), customerData.getLastName());
		final CustomerModel customer = getCurrentSessionCustomer();
		customer.setOriginalUid(customerData.getDisplayUid());
		getCustomCustomerAccountService().updateCustomProfile(customer, customerData.getTitleCode(), name, customerData.getUid(),
				customerData.getBirthdate());

	}

	public boolean isAnonymus()
	{

		return getUserService().isAnonymousUser(getUserService().getCurrentUser());

	}
}
