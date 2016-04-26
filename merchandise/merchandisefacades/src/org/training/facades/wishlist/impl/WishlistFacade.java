/**
 *
 */
package org.training.facades.wishlist.impl;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.wishlist2.Wishlist2Service;
import de.hybris.platform.wishlist2.enums.Wishlist2EntryPriority;
import de.hybris.platform.wishlist2.model.Wishlist2EntryModel;
import de.hybris.platform.wishlist2.model.Wishlist2Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.training.facades.wishlist.SimpleWishlistFacade;


/**
 * @author popovicd
 *
 */
public class WishlistFacade implements SimpleWishlistFacade
{

	private Wishlist2Service wishlistService;
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

	public Wishlist2Service getWishlistService()
	{
		return wishlistService;
	}

	@Required
	public void setWishlistService(final Wishlist2Service wishlistService)
	{
		this.wishlistService = wishlistService;
	}

	private UserService userService;
	private ProductService productService;

	/**
	 * @return the productService
	 */
	public ProductService getProductService()
	{
		return productService;

	}

	public void removeWish(final Wishlist2Model model, final Wishlist2EntryModel entry)
	{

		wishlistService.removeWishlistEntry(model, entry);
	}

	/**
	 * @param productService
	 *           the productService to set
	 */
	public void setProductService(final ProductService productService)
	{
		this.productService = productService;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService()
	{
		return userService;
	}

	/**
	 * @param userService
	 *           the userService to set
	 */
	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.training.facades.wishlist.SimpleWishlistFacade#createWishlist(de.hybris.platform.core.model.user.UserModel,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean createWishlist(final String code)
	{
		final UserModel currentUser = getUserModel();
		final ProductModel productModel = getProductModel(code);

		if (currentUser.getWishlist().isEmpty())
		{
			wishlistService.createDefaultWishlist(currentUser, "", "");
		}
		add2Wishlist(currentUser, productModel, Integer.getInteger("2"), Wishlist2EntryPriority.HIGH, "");

		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.training.facades.wishlist.SimpleWishlistFacade#add2Wishlist(de.hybris.platform.core.model.user.UserModel,
	 * de.hybris.platform.core.model.product.ProductModel, java.lang.Integer,
	 * de.hybris.platform.wishlist2.enums.Wishlist2EntryPriority, java.lang.String)
	 */
	@Override
	public void add2Wishlist(final UserModel user, final ProductModel product, final Integer desired,
			final Wishlist2EntryPriority priority, final String comment)
	{

		wishlistService.addWishlistEntry(user, product, desired, priority, comment);
	}

	public UserModel getUserModel()
	{

		return userService.getCurrentUser();

	}

	public ProductModel getProductModel(final String code)
	{

		return productService.getProductForCode(code);


	}

	/**
	 * @param code
	 */
	public boolean isProductInList(final String code)
	{
		if (code.equals(null))
		{
			return false;
		}
		final UserModel userCurrent = getUserModel();

		final ProductModel model = getProductModel(code);

		final List<Wishlist2Model> list = userCurrent.getWishlist();

		for (final Wishlist2Model wishlist2Model : list)
		{

			for (final Wishlist2EntryModel entryModel : wishlist2Model.getEntries())
			{
				if (entryModel.getProduct().equals(model))
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param code
	 * @return
	 */
	public boolean removeWish(final String code)
	{
		final UserModel userCurrent = getUserModel();


		final ProductModel model = getProductModel(code);

		final List<Wishlist2Model> list = userCurrent.getWishlist();

		for (final Wishlist2Model wishlist2Model : list)
		{

			for (final Wishlist2EntryModel entryModel : wishlist2Model.getEntries())
			{
				if (entryModel.getProduct().equals(model))
				{
					removeWish(wishlist2Model, entryModel);
					return true;

				}
			}
		}
		return false;
	}

	/**
	 * @return
	 * @return
	 */
	public List<ProductModel> getWishlist()
	{
		final UserModel userCurrent = getUserModel();

		final List<Wishlist2Model> wishlistResults = userCurrent.getWishlist();
		//	final List<ProductData> list = new ArrayList<ProductData>();

		final SearchPageData<ProductModel> listmodel = new SearchPageData<ProductModel>();
		final List<ProductModel> listmodelArray = new ArrayList<ProductModel>();
		for (final Wishlist2Model wishlist2Model : wishlistResults)
		{

			for (final Wishlist2EntryModel entryModel : wishlist2Model.getEntries())
			{

				if (entryModel.getProduct() != null)
				{
					listmodelArray.add(entryModel.getProduct());



				}
			}
		}

		//	listmodel.setResults(listmodelArray);
		//	return convertPageData(wishlistResults, getProductConverter());
		return listmodelArray;
	}

	/*
	 * protected <S, T> SearchPageData<T> convertPageData(final List<Wishlist2Model> source, final Converter<S, T>
	 * converter) { final SearchPageData<T> result = new SearchPageData<T>();
	 * result.setPagination(source.getPagination()); result.setSorts(source.getSorts());
	 * result.setResults(Converters.convertAll(source.getResults(), converter)); return result; }
	 */

}
