package org.amadeusz.service;

import org.amadeusz.model.AllUserTipsDTO;
import org.amadeusz.model.Tip;
import org.amadeusz.repository.TipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class TipService {

    @Autowired
    private TipRepository tipRepository;

    public AllUserTipsDTO getAllUserTips() {
        List<Tip> allTips = getAllTipsForCurrentUser();
        Integer sum = sumAllTips(allTips);
        return AllUserTipsDTO.builder()
                .allTips(allTips)
                .sumOfTips(sum)
                .build();
    }

    private List<Tip> getAllTipsForCurrentUser() {
        return newArrayList(tipRepository.findAll());
    }

    private Integer sumAllTips(List<Tip> tips) {
        return tips.stream()
                .map(Tip::getAmount)
                .reduce(0, Integer::sum);
    }


}
