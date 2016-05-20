/**
 * 
 */
package org.training.storefront.controllers.pages;


import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.ThirdPartyConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractSearchPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.user.data.CustomerData;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.training.facades.customer.impl.CustomCustomerFacade;
import org.training.storefront.controllers.ControllerConstants;

import org.training.storefront.forms.ContactForm;

/**
 * @author popovicd
 *
 */
@Controller
@Scope("tenant")
//@RequestMapping("/contactus")
public class ContactUsController extends AbstractSearchPageController
{
	private static final String BREADCRUMBS_ATTR = "breadcrumbs";
	private static final String TEXT_ACCOUNT_CONTACT = "text.contact.contact";
	private static final String CONTACT_DATA_ATTR = "contactData";
	private static final String CONTACT_URL = "/contactus/contact";
	private static final String CONTACT_CMS_PAGE = "contact";


	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "customCustomerFacade")
	private CustomCustomerFacade customCustomerFacade;


	@RequestMapping(value = "/contactus/contact", method = RequestMethod.GET)

	public String getContactPage(final Model model, @RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode)
			throws CMSItemNotFoundException
	{

		CustomerData cd = null;
		ContactForm contactForm = new ContactForm();
		if (customCustomerFacade.getCurrentCustomer() != null)
		{

			cd = customCustomerFacade.getCurrentCustomer();
			contactForm.setFirstName(cd.getFirstName());
			contactForm.setLastName(cd.getLastName());
			contactForm.setEmail(cd.getUid());
		}
		storeCmsPageInModel(model, getContentPageForLabelOrId(CONTACT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONTACT_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_CONTACT));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);
		if (!cd.getUid().equals(null))
			model.addAttribute(contactForm);
		else
			model.addAttribute(new ContactForm());
		return ControllerConstants.Views.Pages.Contact.ContactPage;
	}

	@RequestMapping(value = "/contactus/sendEmail", method = RequestMethod.GET)

	public String sendEmail(final Model model, @RequestParam(value = "show", defaultValue = "Page") final ShowMode showMode,
			@RequestParam("subject") String subject, @RequestParam("message") String message,@RequestParam("email") String email, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{

		storeCmsPageInModel(model, getContentPageForLabelOrId(CONTACT_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(CONTACT_CMS_PAGE));
		model.addAttribute(BREADCRUMBS_ATTR, accountBreadcrumbBuilder.getBreadcrumbs(TEXT_ACCOUNT_CONTACT));
		model.addAttribute(ThirdPartyConstants.SeoRobots.META_ROBOTS, ThirdPartyConstants.SeoRobots.NOINDEX_NOFOLLOW);

	
		customCustomerFacade.getCustomCustomerAccountService().sendEmail(message, subject,email,firstName,lastName);
		model.addAttribute(new ContactForm());
		/*model.addAttribute("sendEmailMessage", "Email is successfully sent");
		return ControllerConstants.Views.Pages.Contact.ContactPage;*/
		
		GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER, "contact.info.success", null);
		return REDIRECT_PREFIX + "/";
	}

}
