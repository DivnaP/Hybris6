/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 20, 2016 10:42:33 AM                    ---
 * ----------------------------------------------------------------
 */
package org.training.core.jalo;

import de.hybris.platform.commerceservices.jalo.process.StoreFrontCustomerProcess;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.training.core.constants.MerchandiseCoreConstants;

/**
 * Generated class for type {@link org.training.core.jalo.ContactSendEmailProcess ContactSendEmailProcess}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedContactSendEmailProcess extends StoreFrontCustomerProcess
{
	/** Qualifier of the <code>ContactSendEmailProcess.body</code> attribute **/
	public static final String BODY = "body";
	/** Qualifier of the <code>ContactSendEmailProcess.subject</code> attribute **/
	public static final String SUBJECT = "subject";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(StoreFrontCustomerProcess.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(BODY, AttributeMode.INITIAL);
		tmp.put(SUBJECT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContactSendEmailProcess.body</code> attribute.
	 * @return the body
	 */
	public String getBody(final SessionContext ctx)
	{
		return (String)getProperty( ctx, BODY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContactSendEmailProcess.body</code> attribute.
	 * @return the body
	 */
	public String getBody()
	{
		return getBody( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ContactSendEmailProcess.body</code> attribute. 
	 * @param value the body
	 */
	public void setBody(final SessionContext ctx, final String value)
	{
		setProperty(ctx, BODY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ContactSendEmailProcess.body</code> attribute. 
	 * @param value the body
	 */
	public void setBody(final String value)
	{
		setBody( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContactSendEmailProcess.subject</code> attribute.
	 * @return the subject
	 */
	public String getSubject(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SUBJECT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ContactSendEmailProcess.subject</code> attribute.
	 * @return the subject
	 */
	public String getSubject()
	{
		return getSubject( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ContactSendEmailProcess.subject</code> attribute. 
	 * @param value the subject
	 */
	public void setSubject(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SUBJECT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ContactSendEmailProcess.subject</code> attribute. 
	 * @param value the subject
	 */
	public void setSubject(final String value)
	{
		setSubject( getSession().getSessionContext(), value );
	}
	
}
