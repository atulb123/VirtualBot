package com.test.stepdefs;

import org.testng.Assert;

import com.test.baseclass.BaseClass;
import com.test.missions.PestMission;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class PestStepDefs extends BaseClass {
	private PestMission pestMission=new PestMission();

	@Then("I should see corresponding QRG document when I click on below menu")
	public void i_should_see_corresponding_QRG_document_when_I_click_on_below_menu(DataTable dataTable) {
		Assert.assertTrue(dataTable.asList().stream().allMatch(menu -> pestMission.verifyQRGLinkisDisplayedWhenMenuSelected(menu)),
				"Quick Reference Guide document is not displayed");
	}
	
	@Then("I should see corresponding QRG document when I enter below menu")
	public void i_should_see_corresponding_QRG_document_when_I_enter_below_menu(io.cucumber.datatable.DataTable dataTable) {
		Assert.assertTrue(dataTable.asList().stream().allMatch(menu -> pestMission.verifyQRGLinkisDisplayedWhenEntered(menu)),
				"Quick Reference Guide document is not displayed");
	}
	
	@Then("I should see QRG document download link when I enter below menu")
	public void i_should_see_QRG_document_download_link_when_I_enter_below_menu(DataTable dataTable) {
		Assert.assertTrue(
				dataTable.asList().stream()
						.allMatch(menu -> pestMission.verifyQRGLinkisDisplayedWhenPestNameEnteredDirectly(menu)),
				"Quick Reference Guide document is not displayed");
	}
}
