package com.smalaca.address;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    @PostMapping
    public String verify(@RequestBody AddressDto addressDto) {
        if (isCorrect(addressDto)) {
            return "CORRECT";
        } else if (isNotComplete(addressDto)) {
            return "NOT COMPLETE";
        }

        return "INCORRECT";
    }

    private boolean isCorrect(AddressDto addressDto) {
        return addressDto.getStreet().equals("Lwowska 1/13")
                && addressDto.getCity().equals("Cracow")
                && addressDto.getCountry().equals("Poland")
                && addressDto.getPostalCode().equals("01-234");
    }

    private boolean isNotComplete(AddressDto addressDto) {
        return addressDto.getStreet().equals("Krakowska 13/1")
                && addressDto.getCity().equals("Warsaw")
                && addressDto.getCountry().equals("Poland");
    }
}
