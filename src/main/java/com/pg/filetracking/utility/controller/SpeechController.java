package com.pg.filetracking.utility.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pg.filetracking.utility.model.SpeechContentDto;
import com.pg.filetracking.utility.service.SpeechService;



@Controller
public class SpeechController {

	@Autowired
	SpeechService speechService;
	
	
	 @RequestMapping(value = "/speechToText", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout,HttpServletRequest req,HttpSession ses,HttpServletResponse response) {
	 
		 model.addAttribute("speechContentDto", new SpeechContentDto());
	        return "speechToText";
	    }
	
	@PostMapping("/speechToText")
	public String addUser(SpeechContentDto speechContentDto, HttpSession ses, BindingResult re, Model model,RedirectAttributes redir) {
	Long result=0L;
		
		try {
			result = speechService.saveSpeechContent(speechContentDto.getSpeechContent(), (Long) ses.getAttribute("loginId"));
		} catch (Exception e) {

			e.printStackTrace();
		}
		if(result>0) {
			redir.addFlashAttribute("result","Created Successfully");
		}
	
		return "redirect:/speechToTextList";
	}
	
	
	@GetMapping({ "/speechToTextList" })
	public String speechToTextList(Model model, HttpServletRequest req, HttpSession ses) {
		try {
	    model.addAttribute("speechToTextList",speechService.getSpeechContent());
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "speechToTextList";
	}
	
}
