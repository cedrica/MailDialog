package helper.database;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.preag.model.branches.BranchRepository;
import com.preag.model.branches.CountryRepository;
import com.preag.model.branches.RegionRepository;
import com.preag.model.branches.data.Branch;
import com.preag.model.branches.data.Country;
import com.preag.model.branches.data.Region;
import com.preag.model.estates.ProjectRepository;
import com.preag.model.estates.data.Project;

import helper.entities.FXBranch;
import helper.entities.FXCountry;
import helper.entities.FXEntityConverter;
import helper.entities.FXProject;
import helper.entities.FXRegion;

@Singleton
public class TaskDatabase {

	@Inject
	FXEntityConverter fxConverter;

	@Inject
	CountryRepository countryRepository;

	@Inject
	BranchRepository branchRepository;

	@Inject
	RegionRepository regionRepository;

	@Inject
	ProjectRepository projectRepository;

	public FXProject findProjectById(Long projectId) {
		Project project = projectRepository.findBy(projectId);
		return fxConverter.convertToFXProject(project);
	}

	public List<FXProject> findAllProjects() {
		List<Project> allProjects = projectRepository.findAll();
		return convertListOfProjects(allProjects);
	}

	public List<FXProject> findProjectsByBranchId(Long branchId) {
		List<Project> allProjects = projectRepository.findByBranchId(branchId);
		return convertListOfProjects(allProjects);
	}

	private List<FXProject> convertListOfProjects(List<Project> allProjects) {
		List<FXProject> allFXProjects = new ArrayList<>();
		for (Project project : allProjects) {
			allFXProjects.add(fxConverter.convertToFXProject(project));
		}
		return allFXProjects;
	}

	public List<FXCountry> findAllCountrys() {
		List<Country> allCountrys = countryRepository.findAll();
		List<FXCountry> allFXCountrys = new ArrayList<>();
		for (Country country : allCountrys) {
			allFXCountrys.add(fxConverter.convertToFXCountry(country));
		}
		return allFXCountrys;
	}

	public FXCountry findCountryById(Long countryId) {
		Country country = countryRepository.findBy(countryId);
		return fxConverter.convertToFXCountry(country);
	}

	public FXRegion findRegionById(Long regionId) {
		Region region = regionRepository.findBy(regionId);
		return fxConverter.convertToFXRegion(region);
	}

	public List<FXRegion> findAllRegions() {
		List<Region> allRegions = regionRepository.findAll();
		return convertListOfRegions(allRegions);
	}

	public List<FXRegion> findRegionByCountryId(Long countryId) {
		List<Region> allRegions = regionRepository.findByCountryId(countryId);
		return convertListOfRegions(allRegions);
	}

	private List<FXRegion> convertListOfRegions(List<Region> allRegions) {
		List<FXRegion> allFXRegions = new ArrayList<>();
		for (Region region : allRegions) {
			allFXRegions.add(fxConverter.convertToFXRegion(region));
		}
		return allFXRegions;
	}

	public FXBranch findBranchById(Long branchId) {
		Branch branch = branchRepository.findBy(branchId);
		return fxConverter.convertToFXBranch(branch);
	}

	public List<FXBranch> findAllBranchs() {
		List<Branch> allBranchs = branchRepository.findAll();
		return convertListOfBranchs(allBranchs);
	}

	public List<FXBranch> findBranchByRegionId(Long regionId) {
		List<Branch> allBranchs = branchRepository.findByRegionId(regionId);
		return convertListOfBranchs(allBranchs);
	}

	private List<FXBranch> convertListOfBranchs(List<Branch> allBranchs) {
		List<FXBranch> allFXBranchs = new ArrayList<>();
		for (Branch branch : allBranchs) {
			allFXBranchs.add(fxConverter.convertToFXBranch(branch));
		}
		return allFXBranchs;
	}

}
