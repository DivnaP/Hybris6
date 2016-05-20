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
	private String body;
	private String name;
	private String email;
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
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
	
	
}
