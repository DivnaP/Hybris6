/**
 *
 */
package org.training.storefront.controllers.misc;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.AbstractController;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.training.facades.wishlist.impl.WishlistFacade;



/**
 * @author popovicd
 *
 */
@Controller

public class WishlistController extends AbstractController
{

	@Resource(name = "wishlistFacade")
	private WishlistFacade wishlistFacade;


	@RequestMapping(value = "/addToWishlist", method = RequestMethod.GET)
	@ResponseBody
	public boolean addToWishlist(@RequestParam final String code)
	{


		return wishlistFacade.createWishlist(code);


	}

	@RequestMapping(value = "/isProductInWishlist", method = RequestMethod.GET)
	@ResponseBody
	public boolean isProductInWishlist(@RequestParam final String code)
	{


		return wishlistFacade.isProductInList(code);

	}

	@RequestMapping(value = "/removeFromWishlist", method = RequestMethod.GET)
	@ResponseBody
	public boolean removeFromWishlist(@RequestParam final String code)
	{

		return wishlistFacade.removeWish(code);

	}
}

