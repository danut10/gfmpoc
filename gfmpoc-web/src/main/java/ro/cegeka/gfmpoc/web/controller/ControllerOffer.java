package ro.cegeka.gfmpoc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ro.cegeka.gfmpoc.app.daoLocal.DaoLocalOffer;
import ro.cegeka.gfmpoc.common.core.intf.IDataRecord;

@Controller
@RequestMapping("/offer")
public class ControllerOffer {

	@Autowired private DaoLocalOffer dao;
	
	@RequestMapping("/list")
	private String list(Model model) {
		List<IDataRecord> recordList = dao.readList();
		model.addAttribute("recordList", recordList);
		return "offer-list";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private String view(@RequestParam("id") Integer id, Model model) {
		return null;
	}

}
