package ro.cegeka.gfmpoc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import ro.cegeka.gfmpoc.app.dao.DaoPark;
import ro.cegeka.gfmpoc.common.core.intf.IDataRecord;

@Controller
@RequestMapping("/park")
public class ControllerPark {

	@Autowired private DaoPark dao;
	
	@RequestMapping("/list")
	private String list(Model model) {
		List<IDataRecord> recordList = dao.readList();
		model.addAttribute("recordList", recordList);
		return "park-list";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private String view(WebRequest webRequest, Model model) {
		return null;
	}

}
