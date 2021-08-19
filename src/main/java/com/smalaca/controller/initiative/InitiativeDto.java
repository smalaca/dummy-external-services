package com.smalaca.controller.initiative;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InitiativeDto {
    private String name;
    private String shortDescription;
    private String longDescription;
    private String code;
}
