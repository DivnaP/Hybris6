/**
 * 
 */
package org.training.facades.contact.impl;


import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.services.BaseStoreService;

import org.training.core.event.ContactUsEvent;
import org.training.facades.contact.ContactFacadeInterface;


/**
 * @author popovicd
 *
 */
public class ContactFacade implements ContactFacadeInterface
{

	/* (non-Javadoc)
	 * @see org.training.facades.contact.ContactFacadeInterface#sendEmail()
	 */
	
	private EventService eventService;
	private BaseSiteService baseSiteService;
	private BaseStoreService	baseStoreService;
	private CommonI18NService commonI18NService;
	/**
	 * @return the commonI18NService
	 */
	public CommonI18NService getCommonI18NService()
	{
		return commonI18NService;
	}
	/**
	 * @param commonI18NService the commonI18NService to set
	 */
	public void setCommonI18NService(CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}
	/**
	 * @return the baseStoreService
	 */
	public BaseStoreService getBaseStoreService()
	{
		return baseStoreService;
	}
	/**
	 * @param baseStoreService the baseStoreService to set
	 */
	public void setBaseStoreService(BaseStoreService baseStoreService)
	{
		this.baseStoreService = baseStoreService;
	}
	/**
	 * @return the baseSiteService
	 */
	public BaseSiteService getBaseSiteService()
	{
		return baseSiteService;
	}
	/**
	 * @param baseSiteService the baseSiteService to set
	 */
	public void setBaseSiteService(BaseSiteService baseSiteService)
	{
		this.baseSiteService = baseSiteService;
	}
	/**
	 * @return the eventService
	 */
	public EventService getEventService()
	{
		return eventService;
	}
	/**
	 * @param eventService the eventService to set
	 */
	public void setEventService(EventService eventService)
	{
		this.eventService = eventService;
	}
	@Override
	public void sendEmail(String subject, String body, String email, String name)
	{
	
		
		getEventService().publishEvent(myInitializeEvent(new ContactUsEvent(), subject, body,  email,  name));
		
	}
	
	protected AbstractCommerceUserEvent myInitializeEvent(final ContactUsEvent event, String subject, String body, String email, String name)
	{
		event.setBaseStore(getBaseStoreService().getCurrentBaseStore());
		event.setSite(getBaseSiteService().getCurrentBaseSite());
		event.setLanguage(getCommonI18NService().getCurrentLanguage());	
		event.setSubject(subject);
		event.setBody(body);
		event.setName(name);
		event.setEmail(email);
		return event;
	}

}
