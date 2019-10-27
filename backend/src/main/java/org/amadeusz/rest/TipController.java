package org.amadeusz.rest;

import org.amadeusz.model.AllUserTipsDTO;
import org.amadeusz.model.Tip;
import org.amadeusz.repository.TipRepository;
import org.amadeusz.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(path = "rest/api/tip")
public class TipController {

	@Autowired
	private TipService tipService;

	@Autowired
	private TipRepository tipRepository;

	@PostMapping
	public @ResponseBody Tip addNewTip(@RequestBody Tip newTip) {
		Tip tip = new Tip();
		tip.setAmount(newTip.getAmount());
		tip.setDescription(newTip.getDescription());
		tip.setCreationDate(new Date());
		tip = tipRepository.save(tip);
		return tip;
	}

	@GetMapping
	public @ResponseBody
	AllUserTipsDTO getAllTips() {
		return tipService.getAllUserTips();
	}
}
