package com.gpdigital.honeypot.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpdigital.honeypot.entity.GPBrands;
import com.gpdigital.honeypot.entity.GPFbPages;
import com.gpdigital.honeypot.entity.GPUsers;
import com.gpdigital.honeypot.service.GPBrandsService;
import com.gpdigital.honeypot.service.GPFbPagesService;
import com.gpdigital.honeypot.service.GPUsersService;

@Controller
public class BaseController {

	@Autowired
	GPUsersService gpUsersService;

	@Autowired
	GPFbPagesService gpFbPagesService;

	@Autowired
	GPBrandsService gpBrandsService;

	// List<ARTLAssetInfo> listARTLAssetInfo = new ArrayList<ARTLAssetInfo>();

	@RequestMapping({ "/", "/index" })
	public String showLoginPage(HttpServletRequest request) {
		System.out.println("Context:" + request.getContextPath());
		return "index";
	}

	@RequestMapping({ "/home" })
	public String showHomePage(HttpServletRequest request) {
		// return "home";
		return "home2";
	}

	@RequestMapping(value = "/searchAssets", method = RequestMethod.POST)
	@ResponseBody
	public String returnSearchAssets(HttpServletRequest request,
			@RequestParam("inputAssetName") String inputAssetName) {
		System.out.println("inputAssetName:" + inputAssetName);
		// listARTLAssetInfo =
		// artlAssetInfoService.getAssetsLikeAssetName(inputAssetName.trim());
		/*
		 * for(ARTLAssetInfo artlAssetInfo:listARTLAssetInfo){
		 * System.out.println("artlAssetInfo:" + artlAssetInfo.getAssetName());
		 * }
		 * 
		 * ObjectMapper mapper = new ObjectMapper(); String jsonInString = "";
		 * try { jsonInString = mapper.writeValueAsString(listARTLAssetInfo); }
		 * catch (JsonGenerationException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (JsonMappingException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		return "test";
	}

	@RequestMapping(value = "/getSummary/{index}", method = RequestMethod.GET)
	public String getSummary(Model model, @PathVariable("index") int index) {

		String[] firstElement = { "Male", "Motolite", "FHM", "FHM" };
		String[] secondElement = { "Female", "Male", "Male", "Motolite" };
		System.out.println("index:" + index);
		model.addAttribute("firstElement", firstElement[index]);
		model.addAttribute("secondElement", secondElement[index]);
		model.addAttribute("firstPercentage", "" + (index + 1) * 25);
		model.addAttribute("secondPercentage", "" + (4 - index) * 25);
		return "home::fragmentSummaryBody";
	}

	// @RequestMapping({ "/controller/registerPage" })
	// public ModelAndView goToRegisterPage(Model model) {
	// System.out.println("register");
	// return new ModelAndView("/register", "command", model);
	// }

	@RequestMapping({ "/registerPage" })
	public ModelAndView goToRegisterPage(Model model) {
		System.out.println("registerPage");
		// return "redirect:register";
		return new ModelAndView("register", "command", model);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(Model model, @RequestParam("addUserBrand") String addUserBrand,
			@RequestParam("addUserUsername") String addUserUsername,
			@RequestParam("addUserPassword") String addUserPassword) {
		System.out.println("addUserBrand:" + addUserBrand);
		System.out.println("addUserUsername:" + addUserUsername);
		System.out.println("addUserPassword:" + addUserPassword);
		GPUsers gpUser = new GPUsers();
		GPBrands gpBrands = new GPBrands();
		gpUser.setUsername(addUserUsername);
		gpUser.setPassword(addUserPassword);
		if (gpBrandsService.findBrandNameByName(addUserBrand) != null) {
			gpBrands = gpBrandsService.findBrandNameByName(addUserBrand);
		} else {
			gpBrands.setBrandName(addUserBrand);
			try {
				gpBrandsService.saveGPBrand(gpBrands);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gpUser.setBrandId(gpBrands.getBrandId());
		
		try {
			gpUsersService.saveGPUser(gpUser);
			return "success";
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
	}

	@RequestMapping(value = "/addFBPage", method = RequestMethod.POST)
	public String addFBPage(Model model, @RequestParam("addFbPageBrand") String addFbPageBrand,
			@RequestParam("addFbPageName") String addFbPageName) {
		System.out.println("addFbPageBrand:" + addFbPageBrand);
		System.out.println("addFbPageName:" + addFbPageName);
		GPBrands gpBrands = new GPBrands();
		GPFbPages gpFbPages= new GPFbPages();
		gpFbPages.setFbPageName(addFbPageName);
		gpFbPages.setFbPageId(Math.random() + "");
		if (gpBrandsService.findBrandNameByName(addFbPageBrand) != null) {
			gpBrands = gpBrandsService.findBrandNameByName(addFbPageBrand);
		} else {
			gpBrands.setBrandName(addFbPageBrand);
			try {
				gpBrandsService.saveGPBrand(gpBrands);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gpFbPages.setBrandId(gpBrands.getBrandId());
		try {
			gpFbPagesService.saveGPFbPage(gpFbPages);
			model.addAttribute("fbPages", gpFbPages);
			return "register::fragmentFBPages";
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
	}

	@RequestMapping(value = "/updateFBPages/{brand}", method = RequestMethod.GET)
	public String updateFBPages(Model model, @PathVariable("brand") String brand) {
		GPBrands gpBrands = gpBrandsService.findBrandNameByName(brand);
		List<GPFbPages> gpFbPages = gpFbPagesService.findFBPagesByBrandId(gpBrands.getBrandId());
		model.addAttribute("fbPages", gpFbPages);
		return "register::fragmentFBPages";
	}
	// @RequestMapping({ "/register" })
	//
	// public String showRegisterPage(Model model) {
	// System.out.println("register");
	// return "register";
	// }

}
