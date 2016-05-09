/**
 * 
 */
package org.training.storefront.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author popovicd
 *
 */
public class CustomRegisterForm extends RegisterForm
{
	@DateTimeFormat(iso = ISO.DATE)
	private Date birthdate;
	/**
	 * @return the birthdate
	 */
	public Date getBirthdate()
	{
		return birthdate;
	}

	/**
	 * @param birthdate
	 *           the birthdate to set
	 */
	public void setBirthdate(final Date birthdate)
	{
		this.birthdate = birthdate;
	}
}
