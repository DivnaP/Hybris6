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

	ContactSendEmailProcessModel cspm;

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
/* (non-Javadoc)
 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getFromEmail()
 */
@Override
public String getFromEmail()
{
	// YTODO Auto-generated method stub
	return cspm.getEmail();
}
/* (non-Javadoc)
 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getFromDisplayName()
 */
@Override
public String getFromDisplayName()
{
	// YTODO Auto-generated method stub
	return cspm.getName();
}
	@Override
	public void init(final ContactSendEmailProcessModel contactSendEmailProcessModel, final EmailPageModel emailPageModel)
	{
		super.init(contactSendEmailProcessModel, emailPageModel);
		cspm= contactSendEmailProcessModel;
		put("subject",contactSendEmailProcessModel.getSubject());
		put("body",contactSendEmailProcessModel.getBody());
		put("name",contactSendEmailProcessModel.getName());
		put("email",contactSendEmailProcessModel.getEmail());
		put("fromEmail",contactSendEmailProcessModel.getEmail());
		//put("fromDisplayName",contactSendEmailProcessModel.getName());
		put("displayName",contactSendEmailProcessModel.getName());
	  
	}
	/* (non-Javadoc)
	 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getSite(de.hybris.platform.processengine.model.BusinessProcessModel)
	 */
	@Override
	protected BaseSiteModel getSite(ContactSendEmailProcessModel businessProcessModel)
	{
		
		return businessProcessModel.getSite();
	}
	/* (non-Javadoc)
	 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getCustomer(de.hybris.platform.processengine.model.BusinessProcessModel)
	 */
	@Override
	protected CustomerModel getCustomer(ContactSendEmailProcessModel businessProcessModel)
	{
		// YTODO Auto-generated method stub
		return businessProcessModel.getCustomer();
	}
	/* (non-Javadoc)
	 * @see de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext#getEmailLanguage(de.hybris.platform.processengine.model.BusinessProcessModel)
	 */
	@Override
	protected LanguageModel getEmailLanguage(ContactSendEmailProcessModel businessProcessModel)
	{
		// YTODO Auto-generated method stub
		return businessProcessModel.getLanguage();
	}



}
