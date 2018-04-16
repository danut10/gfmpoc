package ro.cegeka.gfm.poc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import ro.cegeka.gfm.poc.app.core.intf.IDao;
import ro.cegeka.gfm.poc.app.dao.DaoHoliday;
import ro.cegeka.gfm.poc.common.core.intf.IDataRecord;

@Controller
@RequestMapping("/holiday")
public class ControllerHoliday {

	@Autowired private DaoHoliday dao;
	// @Autowired private DaoLocalHoliday daoLocal;
	
	@RequestMapping("/list")
	private String list(Model model, @RequestParam(value="src", required=false) String src) {
		IDao dao = this.dao;
		//if (src != null && src.equalsIgnoreCase("localhost-mysql")) {
		//	dao = this.daoLocal;
		//}
		List<IDataRecord> recordList = dao.readList();
		model.addAttribute("recordList", recordList);
		return "holidays-list";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private String view(WebRequest webRequest, Model model) {
		return null;
	}

}
