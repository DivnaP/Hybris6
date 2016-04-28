/**
 *
 */
package org.training.facades.product;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.ArrayList;
import java.util.List;


/**
 * @author popovicd
 *
 */
public class ProductWishlistConvertFacade
{
	private Converter<ProductModel, ProductData> productConverter;

	/**
	 * @return the productConverter
	 */
	public Converter<ProductModel, ProductData> getProductConverter()
	{
		return productConverter;
	}

	/**
	 * @param productConverter
	 *           the productConverter to set
	 */
	public void setProductConverter(final Converter<ProductModel, ProductData> productConverter)
	{
		this.productConverter = productConverter;
	}

	public List<ProductData> convertWishlistToProductData(final List<ProductModel> listModel)
	{

		final List<ProductData> listPoductData = new ArrayList<ProductData>();

		for (final ProductModel model1 : listModel)
		{

			listPoductData.add(getProductConverter().convert(model1));
		}

		return listPoductData;

	}
}
