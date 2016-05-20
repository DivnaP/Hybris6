/**
 * 
 */
package org.training.core.event;

import de.hybris.platform.acceleratorservices.site.AbstractAcceleratorSiteEventListener;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.enums.SiteChannel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import org.training.core.event.ContactUsEvent;
import org.training.core.model.ContactSendEmailProcessModel;


/**
 * @author popovicd
 *
 */
public class ContactUsEventListener extends AbstractAcceleratorSiteEventListener<ContactUsEvent>
{

	private ModelService modelService;

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the businessProcessService
	 */
	public BusinessProcessService getBusinessProcessService()
	{
		return businessProcessService;
	}

	/**
	 * @param businessProcessService
	 *           the businessProcessService to set
	 */
	public void setBusinessProcessService(BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}

	private BusinessProcessService businessProcessService;

	@Override
	protected SiteChannel getSiteChannelForEvent(ContactUsEvent event)
	{
		final BaseSiteModel site = event.getSite();
		ServicesUtil.validateParameterNotNullStandardMessage("event.order.site", site);
		return site.getChannel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.commerceservices.event.AbstractSiteEventListener#onSiteEvent(de.hybris.platform.servicelayer.
	 * event.events.AbstractEvent)
	 */
	@Override
	protected void onSiteEvent(ContactUsEvent event)
	{
		final ContactSendEmailProcessModel cepm = (ContactSendEmailProcessModel) getBusinessProcessService()
				.createProcess("contactSendEmailProcess-" + System.currentTimeMillis(), "contactSendEmailProcess2");

		cepm.setSite(event.getSite());
		cepm.setLanguage(event.getLanguage());

		cepm.setStore(event.getBaseStore());
		cepm.setBody(event.getBody());
		cepm.setSubject(event.getSubject());
		cepm.setName(event.getName());
		cepm.setEmail(event.getEmail());

		getModelService().save(cepm);
		getBusinessProcessService().startProcess(cepm);

	}

}
