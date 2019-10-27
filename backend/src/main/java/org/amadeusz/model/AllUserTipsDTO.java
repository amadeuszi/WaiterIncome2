package org.amadeusz.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AllUserTipsDTO {

    private List<Tip> allTips;

    private Integer sumOfTips;

}
