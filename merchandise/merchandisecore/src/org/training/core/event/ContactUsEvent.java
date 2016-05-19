/**
 * 
 */
package org.training.core.event;

import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.event.AbstractCommerceUserEvent;

/**
 * @author popovicd
 *
 */
public class ContactUsEvent extends AbstractCommerceUserEvent<BaseSiteModel>
{
//
	private String subject;
	/**
	 * @return the subject
	 */
	public String getSubject()
	{
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	/**
	 * @return the body
	 */
	public String getBody()
	{
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body)
	{
		this.body = body;
	}
	private String body;
	
}
