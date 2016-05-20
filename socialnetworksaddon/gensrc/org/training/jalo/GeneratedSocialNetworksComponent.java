/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 20, 2016 10:42:33 AM                    ---
 * ----------------------------------------------------------------
 */
package org.training.jalo;

import de.hybris.platform.cms2.jalo.contents.components.CMSParagraphComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.training.constants.SocialnetworksaddonConstants;

/**
 * Generated class for type {@link de.hybris.platform.cms2.jalo.contents.components.CMSParagraphComponent SocialNetworksComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedSocialNetworksComponent extends CMSParagraphComponent
{
	/** Qualifier of the <code>SocialNetworksComponent.image</code> attribute **/
	public static final String IMAGE = "image";
	/** Qualifier of the <code>SocialNetworksComponent.linktext</code> attribute **/
	public static final String LINKTEXT = "linktext";
	/** Qualifier of the <code>SocialNetworksComponent.title</code> attribute **/
	public static final String TITLE = "title";
	/** Qualifier of the <code>SocialNetworksComponent.text</code> attribute **/
	public static final String TEXT = "text";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CMSParagraphComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(IMAGE, AttributeMode.INITIAL);
		tmp.put(LINKTEXT, AttributeMode.INITIAL);
		tmp.put(TITLE, AttributeMode.INITIAL);
		tmp.put(TEXT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.image</code> attribute.
	 * @return the image - Image of social network
	 */
	public Media getImage(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, IMAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.image</code> attribute.
	 * @return the image - Image of social network
	 */
	public Media getImage()
	{
		return getImage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.image</code> attribute. 
	 * @param value the image - Image of social network
	 */
	public void setImage(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, IMAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.image</code> attribute. 
	 * @param value the image - Image of social network
	 */
	public void setImage(final Media value)
	{
		setImage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.linktext</code> attribute.
	 * @return the linktext
	 */
	public String getLinktext(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedSocialNetworksComponent.getLinktext requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, LINKTEXT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.linktext</code> attribute.
	 * @return the linktext
	 */
	public String getLinktext()
	{
		return getLinktext( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.linktext</code> attribute. 
	 * @return the localized linktext
	 */
	public Map<Language,String> getAllLinktext(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,LINKTEXT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.linktext</code> attribute. 
	 * @return the localized linktext
	 */
	public Map<Language,String> getAllLinktext()
	{
		return getAllLinktext( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.linktext</code> attribute. 
	 * @param value the linktext
	 */
	public void setLinktext(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedSocialNetworksComponent.setLinktext requires a session language", 0 );
		}
		setLocalizedProperty(ctx, LINKTEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.linktext</code> attribute. 
	 * @param value the linktext
	 */
	public void setLinktext(final String value)
	{
		setLinktext( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.linktext</code> attribute. 
	 * @param value the linktext
	 */
	public void setAllLinktext(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,LINKTEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.linktext</code> attribute. 
	 * @param value the linktext
	 */
	public void setAllLinktext(final Map<Language,String> value)
	{
		setAllLinktext( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.text</code> attribute.
	 * @return the text
	 */
	public String getText(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedSocialNetworksComponent.getText requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TEXT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.text</code> attribute.
	 * @return the text
	 */
	public String getText()
	{
		return getText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.text</code> attribute. 
	 * @return the localized text
	 */
	public Map<Language,String> getAllText(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TEXT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.text</code> attribute. 
	 * @return the localized text
	 */
	public Map<Language,String> getAllText()
	{
		return getAllText( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.text</code> attribute. 
	 * @param value the text
	 */
	public void setText(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedSocialNetworksComponent.setText requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.text</code> attribute. 
	 * @param value the text
	 */
	public void setText(final String value)
	{
		setText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.text</code> attribute. 
	 * @param value the text
	 */
	public void setAllText(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TEXT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.text</code> attribute. 
	 * @param value the text
	 */
	public void setAllText(final Map<Language,String> value)
	{
		setAllText( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.title</code> attribute.
	 * @return the title
	 */
	public String getTitle(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedSocialNetworksComponent.getTitle requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TITLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.title</code> attribute.
	 * @return the title
	 */
	public String getTitle()
	{
		return getTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.title</code> attribute. 
	 * @return the localized title
	 */
	public Map<Language,String> getAllTitle(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TITLE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SocialNetworksComponent.title</code> attribute. 
	 * @return the localized title
	 */
	public Map<Language,String> getAllTitle()
	{
		return getAllTitle( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.title</code> attribute. 
	 * @param value the title
	 */
	public void setTitle(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedSocialNetworksComponent.setTitle requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.title</code> attribute. 
	 * @param value the title
	 */
	public void setTitle(final String value)
	{
		setTitle( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.title</code> attribute. 
	 * @param value the title
	 */
	public void setAllTitle(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TITLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SocialNetworksComponent.title</code> attribute. 
	 * @param value the title
	 */
	public void setAllTitle(final Map<Language,String> value)
	{
		setAllTitle( getSession().getSessionContext(), value );
	}
	
}
