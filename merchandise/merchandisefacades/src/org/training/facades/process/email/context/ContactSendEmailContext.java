/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *  
 */
package org.training.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.user.data.CustomerData;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.apache.commons.configuration.Configuration;
import org.springframework.beans.factory.annotation.Required;
import org.training.core.model.*;


/**
 * Velocity context for a customer email.
 */
public class ContactSendEmailContext extends AbstractEmailContext<ContactSendEmailProcessModel>
{
	private Converter<UserModel, CustomerData> customerConverter;
	private CustomerData customerData;
	String from;

	/* (non-Javadoc)
	 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getToEmail()
	 */
	@Override
	public String getToEmail()
	{
		Configuration cfg = getConfigurationService().getConfiguration();
		
		return cfg.getString("contactmailto");
	}
	/* (non-Javadoc)
	 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getFromEmail()
	 */
	@Override
	public String getFromEmail()
	{
		
		return customerData.getUid();
	}

	@Override
	public void init(final ContactSendEmailProcessModel contactSendEmailProcessModel, final EmailPageModel emailPageModel)
	{
		super.init(contactSendEmailProcessModel, emailPageModel);
		customerData = getCustomerConverter().convert(getCustomer(contactSendEmailProcessModel));
		put("subject",contactSendEmailProcessModel.getSubject());
		put("body",contactSendEmailProcessModel.getBody());
	//  from = emailPageModel.getFromEmail();
	  
	}

	@Override
	protected BaseSiteModel getSite(final ContactSendEmailProcessModel contactSendEmailProcessModel)
	{
		return contactSendEmailProcessModel.getSite();
	}



	protected Converter<UserModel, CustomerData> getCustomerConverter()
	{
		return customerConverter;
	}

	@Required
	public void setCustomerConverter(final Converter<UserModel, CustomerData> customerConverter)
	{
		this.customerConverter = customerConverter;
	}

	public CustomerData getCustomer()
	{
		return customerData;
	}

	/* (non-Javadoc)
	 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getCustomer(de.hybris.platform.processengine.model.BusinessProcessModel)
	 */
	@Override
	protected CustomerModel getCustomer(ContactSendEmailProcessModel businessProcessModel)
	{
		return businessProcessModel.getCustomer();
	}

	/* (non-Javadoc)
	 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getEmailLanguage(de.hybris.platform.processengine.model.BusinessProcessModel)
	 */
	@Override
	protected LanguageModel getEmailLanguage(final ContactSendEmailProcessModel businessProcessModel)
	{
		return businessProcessModel.getLanguage();
	}

}
