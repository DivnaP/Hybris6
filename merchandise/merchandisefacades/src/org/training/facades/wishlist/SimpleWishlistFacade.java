/**
 *
 */
package org.training.facades.wishlist;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.wishlist2.enums.Wishlist2EntryPriority;


/**
 * @author popovicd
 *
 */
public interface SimpleWishlistFacade
{
	public boolean createWishlist(String code);

	public void add2Wishlist(final UserModel user, final ProductModel product, final Integer desired,
			final Wishlist2EntryPriority priority, final String comment);
}
