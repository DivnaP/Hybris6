/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package org.training.initialdata.setup;

/**
 * This class provides hooks into the system's initialization and update processes.
 *
 * @see "https://wiki.hybris.com/display/release4/Hooks+for+Initialization+and+Update+Process"
 */
import de.hybris.platform.commerceservices.dataimport.impl.CoreDataImportService;
import de.hybris.platform.commerceservices.dataimport.impl.SampleDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.commerceservices.setup.events.CoreDataImportedEvent;
import de.hybris.platform.commerceservices.setup.events.SampleDataImportedEvent;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetup.Process;
import de.hybris.platform.core.initialization.SystemSetup.Type;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.training.initialdata.constants.MerchandiseInitialDataConstants;


/**
 * This class provides hooks into the system's initialization and update processes.
 *
 * @see "https://wiki.hybris.com/display/release4/Hooks+for+Initialization+and+Update+Process"
 */
@SystemSetup(extension = MerchandiseInitialDataConstants.EXTENSIONNAME)
public class InitialDataSystemSetup extends AbstractSystemSetup
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(InitialDataSystemSetup.class);
	public static final String MSG = "electronicsContentCatalog";
	private static final String IMPORT_CORE_DATA = "importCoreData";
	private static final String IMPORT_SAMPLE_DATA = "importSampleData";
	private static final String ACTIVATE_SOLR_CRON_JOBS = "activateSolrCronJobs";
	private CoreDataImportService coreDataImportService;
	private SampleDataImportService sampleDataImportService;

	/**
	 * Generates the Dropdown and Multi-select boxes for the project data import
	 */
	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();
		params.add(createBooleanSystemSetupParameter(IMPORT_CORE_DATA, "Import Core Data", true));
		params.add(createBooleanSystemSetupParameter(IMPORT_SAMPLE_DATA, "Import Sample Data", true));
		params.add(createBooleanSystemSetupParameter(ACTIVATE_SOLR_CRON_JOBS, "Activate Solr Cron Jobs", true));
		// Add more Parameters here as you require
		return params;
	}

	/**
	 * Implement this method to create initial objects. This method will be called by system creator during
	 * initialization and system update. Be sure that this method can be called repeatedly.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.ESSENTIAL, process = Process.ALL)
	public void createEssentialData(final SystemSetupContext context)
	{
		// Add Essential Data here as you require
	}

	/**
	 * Implement this method to create data that is used in your project. This method will be called during the system
	 * initialization.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.PROJECT, process = Process.ALL)
	public void createProjectData(final SystemSetupContext context)
	{
		final String IMPORT_PREFIX = "/merchandiseinitialdata/import";
		final String SAMPLE = "/sampledata";
		final String CORE = "/coredata";

		final List<ImportData> importData = new ArrayList<ImportData>();

		final ImportData msgImportData = new ImportData();
		msgImportData.setProductCatalogName(MSG);

		msgImportData.setContentCatalogNames(Arrays.asList(MSG));
		msgImportData.setStoreNames(Arrays.asList("merchandise"));
		importData.add(msgImportData);

		getCoreDataImportService().execute(this, context, importData);
		getEventService().publishEvent(new CoreDataImportedEvent(context, importData));

		getSampleDataImportService().execute(this, context, importData);
		/*
		 * importImpexFile(context, IMPORT_PREFIX + CORE + "/productCatalogs/msgProductCatalog/catalog.impex", true);
		 * importImpexFile(context, IMPORT_PREFIX + CORE + "/productCatalogs/msgProductCatalog/catalog_en.impex", true);
		 * // Msg Content Catalog (core data) importImpexFile(context, IMPORT_PREFIX + CORE +
		 * "/contentCatalogs/msgContentCatalog/catalog.impex", true); importImpexFile(context, IMPORT_PREFIX + CORE +
		 * "/contentCatalogs/msgContentCatalog/catalog_en.impex", true); // Msg CMS Content (core data)
		 * importImpexFile(context, IMPORT_PREFIX + CORE + "/contentCatalogs/msgContentCatalog/cms-content.impex", true);
		 * importImpexFile(context, IMPORT_PREFIX + CORE + "/contentCatalogs/msgContentCatalog/cms-content_en.impex",
		 * true);
		 */
		// Msg Store (core data)
		/*
		 * importImpexFile(context, IMPORT_PREFIX + CORE + "/stores/msg/store.impex", true); importImpexFile(context,
		 * IMPORT_PREFIX + CORE + "/stores/msg/store_en.impex", true); importImpexFile(context, IMPORT_PREFIX + CORE +
		 * "/stores/msg/store_en.impex", true); // Msg Site (core data) importImpexFile(context, IMPORT_PREFIX + CORE +
		 * "/stores/msg/site.impex", true); importImpexFile(context, IMPORT_PREFIX + CORE + "/stores/msg/site_en.impex",
		 * true); ​ importImpexFile(context, IMPORT_PREFIX + CORE + "/stores/msg/solr.impex", true);
		 * importImpexFile(context, IMPORT_PREFIX + CORE + "/stores/msg/solr_en.impex", true); importImpexFile(context,
		 * IMPORT_PREFIX + CORE + "/stores/msg/solr.impex", true); ​ importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/productCatalogs/msgProductCatalog/categories.impex", true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/productCatalogs/msgProductCatalog/categories_en.impex", true); importImpexFile(context, IMPORT_PREFIX +
		 * SAMPLE + "/productCatalogs/msgProductCatalog/categories-classifications.impex", true); importImpexFile(context,
		 * IMPORT_PREFIX + SAMPLE + "/productCatalogs/msgProductCatalog/categories-classifications_en.impex", true);
		 * importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/productCatalogs/msgProductCatalog/categories-media.impex",
		 * true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/productCatalogs/msgProductCatalog/classifications-units.impex", true); importImpexFile(context, IMPORT_PREFIX
		 * + SAMPLE + "/productCatalogs/msgProductCatalog/products.impex", true); importImpexFile(context, IMPORT_PREFIX +
		 * SAMPLE + "/productCatalogs/msgProductCatalog/products_en.impex", true); importImpexFile(context, IMPORT_PREFIX
		 * + SAMPLE + "/productCatalogs/msgProductCatalog/products-classifications_en.impex", true); ​
		 * importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/productCatalogs/msgProductCatalog/products-media.impex",
		 * true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/productCatalogs/msgProductCatalog/products-pos-stocklevels.impex", true); importImpexFile(context,
		 * IMPORT_PREFIX + SAMPLE + "/productCatalogs/msgProductCatalog/products-prices.impex", true);
		 * importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/productCatalogs/msgProductCatalog/products-relations.impex", true); importImpexFile(context, IMPORT_PREFIX +
		 * SAMPLE + "/productCatalogs/msgProductCatalog/products-stocklevels.impex", true); importImpexFile(context,
		 * IMPORT_PREFIX + SAMPLE + "/productCatalogs/msgProductCatalog/products-tax.impex", true);
		 * importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/productCatalogs/msgProductCatalog/reviews.impex", true);
		 * importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/productCatalogs/msgProductCatalog/suppliers.impex", true);
		 * importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/productCatalogs/msgProductCatalog/suppliers_en.impex",
		 * true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/productCatalogs/msgProductCatalog/suppliers-media.impex", true);
		 */
		// Msg Content Catalog (sample data)
		/*
		 * importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/contentCatalogs/msgContentCatalog/cms-content.impex",
		 * true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/contentCatalogs/msgContentCatalog/cms-content_en.impex", true); ​ importImpexFile(context, IMPORT_PREFIX +
		 * SAMPLE + "/stores/msg/btg.impex", true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/stores/msg/jobs.impex", true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/stores/msg/points-of-service.impex", true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/stores/msg/points-of-service_en.impex", true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/stores/msg/points-of-service-media.impex", true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/stores/msg/promotions.impex", true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/stores/msg/promotions_en.impex", true); importImpexFile(context, IMPORT_PREFIX + SAMPLE +
		 * "/stores/msg/solr.impex", true); importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/stores/msg/solr_en.impex",
		 * true); importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/stores/msg/warehouses.impex", true); ​ //Responsive
		 * stuff importImpexFile(context, IMPORT_PREFIX + CORE +
		 * "/contentCatalogs/msgContentCatalog/cms-responsive-content.impex", true); importImpexFile(context,
		 * IMPORT_PREFIX + CORE + "/stores/msg/store-responsive.impex", true);
		 */
		importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/contentCatalogs/catalogName/cms-responsive-content.impex", true);
		importImpexFile(context, IMPORT_PREFIX + SAMPLE + "/contentCatalogs/catalogName/cms-responsive-content_en.impex", true);

		getEventService().publishEvent(new SampleDataImportedEvent(context, importData));
		if (this.getBooleanSystemSetupParameter(context, ACTIVATE_SOLR_CRON_JOBS))
		{
			this.logInfo(context, String.format("Activating solr index for [%s]", MSG));
			getSampleDataImportService().runSolrIndex(context.getExtensionName(), MSG);
		}
	}

	public CoreDataImportService getCoreDataImportService()
	{
		return coreDataImportService;
	}

	@Required
	public void setCoreDataImportService(final CoreDataImportService coreDataImportService)
	{
		this.coreDataImportService = coreDataImportService;
	}

	public SampleDataImportService getSampleDataImportService()
	{
		return sampleDataImportService;
	}

	@Required
	public void setSampleDataImportService(final SampleDataImportService sampleDataImportService)
	{
		this.sampleDataImportService = sampleDataImportService;
	}
}