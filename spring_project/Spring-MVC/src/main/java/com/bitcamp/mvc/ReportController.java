package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitcamp.mvc.domain.ReqReport;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private FileUploadService service;

	// /mvc/report/form
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getReportForm() {
		return "/report/form";
	}
	
	@PostMapping("/submit3")
	public String submit3(
			@ModelAttribute("report") ReqReport report,
			HttpServletRequest request
			) {
		
		
		System.out.println("학번 : " + report.getSno());
		System.out.println("이름 : " + report.getSname());
		System.out.println("리포트 파일 : " + report.getReport().getOriginalFilename());
		System.out.println("리포트 파일 : " + report.getReport().getContentType());
		System.out.println("리포트 파일 : " + report.getReport().getName());
		System.out.println("리포트 파일 : " + report.getReport().getSize());
		System.out.println("리포트 파일 : " + report.getReport().isEmpty());

		//model.addAttribute("sno", request.getParameter("sno"));
		//model.addAttribute("sname", request.getParameter("sname"));
		//model.addAttribute("report", report.getOriginalFilename());

		try {
			String fileName = service.svaeFile("/uploadfile", report.getReport(), request);
			System.out.println("파일저장 완료 : " + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "report/submit";
	}
	
	// /mvc/report/submit2
	@PostMapping("/submit2")
	public String submit2(
			MultipartHttpServletRequest request,
			Model model
			) {
		
		MultipartFile report = request.getFile("report");
		
		System.out.println("학번 : " + request.getParameter("sno"));
		System.out.println("이름 : " + request.getParameter("sname"));
		System.out.println("리포트 파일 : " + report.getOriginalFilename());
		System.out.println("리포트 파일 : " + report.getContentType());
		System.out.println("리포트 파일 : " + report.getName());
		System.out.println("리포트 파일 : " + report.getSize());
		System.out.println("리포트 파일 : " + report.isEmpty());

		model.addAttribute("sno", request.getParameter("sno"));
		model.addAttribute("sname", request.getParameter("sname"));
		model.addAttribute("report", report.getOriginalFilename());

		try {
			String fileName = service.svaeFile("/uploadfile", report, request);
			System.out.println("파일저장 완료 : " + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "report/submit";
	}

	@RequestMapping(value = "/submit1", method = RequestMethod.POST)
	public String submit1(
			@RequestParam("sno") String sno, 
			@RequestParam("sname") String sname,
			@RequestParam("report") MultipartFile report, 
			Model model, 
			HttpServletRequest request) {

		System.out.println("학번 : " + sno);
		System.out.println("이름 : " + sname);
		System.out.println("리포트 파일 : " + report.getOriginalFilename());
		System.out.println("리포트 파일 : " + report.getContentType());
		System.out.println("리포트 파일 : " + report.getName());
		System.out.println("리포트 파일 : " + report.getSize());
		System.out.println("리포트 파일 : " + report.isEmpty());

		String newFileName = sno + "_" + report.getOriginalFilename();

		model.addAttribute("sno", sno);
		model.addAttribute("sname", sname);
		model.addAttribute("report", report.getOriginalFilename());

		try {
			String fileName = service.svaeFile("/uploadfile", report, request);
			System.out.println("파일저장 완료 : " + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "report/submit";
	}

}
