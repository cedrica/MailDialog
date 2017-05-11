package helper.entities;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import com.preag.model.branches.data.Branch;
import com.preag.model.branches.data.Country;
import com.preag.model.branches.data.Region;
import com.preag.model.estates.data.Estate;
import com.preag.model.estates.data.Project;

import javafx.collections.FXCollections;
import javafx.scene.image.Image;

@Singleton
public class FXEntityConverter {

	private FXEstate convertToFXEstate(Estate estate) {
		if (estate != null) {
			FXEstate fxEstate = new FXEstate();
			fxEstate.setAbbrev(estate.getAbbrev());
			fxEstate.setName(estate.getSection());
			fxEstate.setId(estate.getId());
			return fxEstate;
		}
		return null;
	}

	public FXBranch convertToFXBranch(Branch branch) {
		if (branch != null) {
			FXBranch fxBranch = new FXBranch();
			fxBranch.setAbbrev(branch.getAbbrev());
			fxBranch.setName(branch.getBranchName());
			fxBranch.setId(branch.getId());
			return fxBranch;
		}
		return null;
	}

	public FXRegion convertToFXRegion(Region region) {
		if (region != null) {
			FXRegion fxRegion = new FXRegion();
			fxRegion.setName(region.getName());
			fxRegion.setId(region.getId());
			return fxRegion;
		}
		return null;
	}

	public FXCountry convertToFXCountry(Country country) {
		if (country != null) {
			FXCountry fxCountry = new FXCountry();
			fxCountry.setAbbrev(country.getAbbrev());
			fxCountry.setName(country.getName());
			fxCountry.setId(country.getId());
			fxCountry.setFlagImage(getFlagImageFromAbbrev(country.getAbbrev()));
			return fxCountry;
		}
		return null;
	}

	public FXProject convertToFXProject(Project project) {
		if (project != null) {
			FXProject fxProject = new FXProject();
			fxProject.setName(project.getName());
			fxProject.setAbbrev(project.getAbbrev());
			fxProject.setMarketingName(project.getMarketingName());
			fxProject.setId(project.getId());
			fxProject.setZipCode(project.getZipCode());

			List<FXEstate> estateList = new ArrayList<>();
			for (Estate estate : project.getEstates()) {
				estateList.add(convertToFXEstate(estate));
			}
			fxProject.setEstateList(FXCollections.observableArrayList(estateList));
			return fxProject;
		}
		return null;
	}

	private Image getFlagImageFromAbbrev(String abbrev) {
		if (abbrev != null) {
			String abbrevUpperCase = abbrev.toUpperCase();
			switch (abbrevUpperCase) {
			case "AT":
				return new Image(FXEntityConverter.class.getResource("/images/flag/FLAG_AT.png").toExternalForm());
			case "DE":
				return new Image(FXEntityConverter.class.getResource("/images/flag/FLAG_GER.png").toExternalForm());
			case "FR":
				return new Image(FXEntityConverter.class.getResource("/images/flag/FLAG_FR.png").toExternalForm());
			default:
				return new Image(FXEntityConverter.class.getResource("/images/flag/FLAG_DEFAULT.png").toExternalForm());
			}
		}
		return null;
	}

}
