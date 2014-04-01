package com.wikia.webdriver.TestCases.VisualEditor.EntryPoint;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wikia.webdriver.Common.ContentPatterns.PageContent;
import com.wikia.webdriver.Common.ContentPatterns.URLsContent;
import com.wikia.webdriver.Common.Properties.Credentials;
import com.wikia.webdriver.Common.Templates.NewTestTemplateBeforeClass;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiBasePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Article.ArticlePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Article.EditMode.SourceEditModePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.VisualEditor.VisualEditorPageObject;

/**
 * @author Robert 'Rochan' Chan
 *
 * Editor Entry Point Test on wiki that has wgEnabledRTEExt = false, wgVisualEditorUI = false
 * User Editor Preference is set to Default Editor
 * VE-958 verify Source Editor is loaded when clicking Add Page from the contribution drop down
 * VE-958 verify Source Editor is loaded when clicking the main edit button on the top of the article
 * VE-958 verify Source Editor is loaded when clicking the red link in the article
 * VE-958 verify Source Editor is loaded when clicking the section edit link in the article
 * VE-958 verify VE Editor is loaded when using ?veaction=edit in the URL
 */

public class VEAndRTEDisabledEditorEntryDefaultPreferredTests extends NewTestTemplateBeforeClass {

	Credentials credentials = config.getCredentials();
	WikiBasePageObject base;
//	String wikiURL;

	@BeforeMethod(alwaysRun = true)
	public void setup_defaultPreferred() {
//		wikiURL = urlBuilder.getUrlForWiki(URLsContent.veAndrteDisabledTestMainPage);
		base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameDefaultPreferred, credentials.passwordDefaultPreferred, wikiURL);
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_001"}
	)
	public void VEAndRTEDisabledEditorEntryDefaultPreferredTests_001_CreatePageEntry() {
		ArticlePageObject article =
				base.openArticleByName(wikiURL, PageContent.articleNamePrefix + base.getTimeStamp());
		SourceEditModePageObject src = article.editArticleInSrcUsingDropdown();
		src.verifySourceOnlyMode();
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_002"}
	)
	public void VEAndRTEDisabledEditorEntryDefaultPreferredTests_002_MainEditEntry() {
		ArticlePageObject article =
				base.openArticleByName(wikiURL, PageContent.articleNamePrefix + base.getTimeStamp());
		SourceEditModePageObject src = article.openSrcModeWithMainEditButton();
		src.verifySourceOnlyMode();
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_003"}
	)
	public void VEAndRTEDisabledEditorEntryDefaultPreferredTests_003_RedlinkEntry() {
		ArticlePageObject article =
				base.openArticleByName(wikiURL, URLsContent.testingPage);
		SourceEditModePageObject src = article.openSrcModeWithRedLinks(0);
		src.verifySourceOnlyMode();
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_004"}
	)
	public void VEAndRTEDisabledEditorEntryDefaultPreferredTests_004_SectionEditEntry() {
		ArticlePageObject article =
				base.openArticleByName(wikiURL, URLsContent.testingPage);
		SourceEditModePageObject src = article.openSrcModeWithSectionEditButton(0);
		src.verifySourceOnlyMode();
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_005"}
	)
	public void VEAndRTEDisabledEditorEntryDefaultPreferredTests_005_URLEntry() {
		VisualEditorPageObject ve = base.openNewArticleEditModeVisual(wikiURL);
		ve.verifyVEToolBarPresent();
		ve.verifyEditorSurfacePresent();
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_006"}
	)
	public void VEAndRTEDisabledEditorEntryDefaultPreferredTests_006_ListNamespace() {
		ArticlePageObject article =
			base.openArticleByName(wikiURL, URLsContent.listPage);
		SourceEditModePageObject src = article.openSrcModeWithMainEditButton();
		src.verifySourceOnlyMode();
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_007"}
	)
	public void RTEDisabledEditorEntryDefaultPreferredTests_007_CategoryNamespace() {
		ArticlePageObject article =
			base.openArticleByName(wikiURL, URLsContent.categoryPage);
		SourceEditModePageObject src = article.openSrcModeWithMainEditButton();
		src.verifySourceOnlyMode();
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_008"}
	)
	public void VEAndRTEDisabledEditorEntryDefaultPreferredTests_008_TemplateNamespace() {
		ArticlePageObject article =
			base.openArticleByName(wikiURL, URLsContent.templatePage);
		SourceEditModePageObject src = article.openSrcModeWithMainEditButton();
		src.verifySourceOnlyMode();
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_009"}
	)
	public void VEAndRTEDisabledEditorEntryDefaultPreferredTests_009_MediawikiNamespace() {
		String wikiURL = urlBuilder.getUrlForWiki(URLsContent.mediaWiki);
		ArticlePageObject article =
			base.openArticleByName(wikiURL, PageContent.articleNamePrefix + base.getTimeStamp());
		SourceEditModePageObject src = article.openSrcModeWithMainEditButton();
		src.verifySourceOnlyMode();
	}

	@Test(
		groups = {"VEAndRTEDisabledEditorEntryDefaultPreferred", "VEAndRTEDisabledEditorEntryDefaultPreferredTests_010"}
	)
	public void VEAndRTEDisabledEditorEntryDefaultPreferredTests_010_actionEdit() {
		SourceEditModePageObject src =
			base.navigateToArticleEditPageSrc(wikiURL, PageContent.articleNamePrefix + base.getTimeStamp());
		src.verifySourceOnlyMode();
	}
}
