package com.smalaca.controller.initiative;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("initiative")
public class InitiativeController {
    private final Map<String, List<InitiativeDto>> repository = ImmutableMap.of(
            "3X1ST", asList(
                    InitiativeDto.builder()
                            .name("Marvel Universe")
                            .code("3X1ST")
                            .shortDescription("short description")
                            .longDescription("long description")
                            .build()),
            "M4NY", asList(
                    InitiativeDto.builder()
                            .name("DC")
                            .code("M4NY")
                            .shortDescription("no description")
                            .longDescription("really nothing")
                            .build(),
                    InitiativeDto.builder()
                            .name("Detective Comics")
                            .code("M4NY")
                            .shortDescription("tell me something")
                            .longDescription("but what")
                            .build())
    );

    @GetMapping("/{code}")
    public List<InitiativeDto> findAll(@PathVariable String code) {
        return repository.getOrDefault(code, Collections.emptyList());
    }
}
