/**
 * 
 */
package org.training.storefront.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdateProfileForm;

import java.text.ParseException;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author popovicd
 *
 */
public class CustomUpdateProfileForm extends UpdateProfileForm
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
	 * @throws ParseException 
	 */
	public void setBirthdate(final Date birthdate) throws ParseException
	{	
	/*	SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
	this.birthdate=dt1.parse(dt1.format(birthdate));*/
		this.birthdate = birthdate;
	}
}
