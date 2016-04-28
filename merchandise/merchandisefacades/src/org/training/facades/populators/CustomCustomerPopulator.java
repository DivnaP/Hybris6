/**
 * 
 */
package org.training.facades.populators;


import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.converters.Populator;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

/**
 * @author popovicd
 *
 */
public class CustomCustomerPopulator implements Populator<CustomerModel,CustomerData>
{

	/* (non-Javadoc)
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final CustomerModel source, final CustomerData target) throws ConversionException
	{
		target.setBirthdate(source.getBirthdate());
		
	}

}
