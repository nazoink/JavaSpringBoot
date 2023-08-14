package com.example.springboot.service;

import com.example.springboot.models.ExampleDto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class ExampleService implements IExampleService {

    public ExampleDto getExampleData() {
        ExampleDto example = new ExampleDto();
        example.setId(1);
        example.setFirstName("Jim");
        example.setLastName("Kirk");
        String result = switch (example.getLastName()) {
            case "Kirk" -> "Warp Speed";
            case "Spock" -> "I'm a doctor";
            default -> {
                yield "Orders Captain?";
            }
        };
        example.setMessage(result);
        example.setCreatedDate(OffsetDateTime.now());
        return example;
    }

    public ExampleDto addExampleData(ExampleDto example) {
        ArrayList examples = new ArrayList<>();
        examples.add(example);
        examples.add(example);
        Optional<ExampleDto> exampleReturn = examples.stream().findFirst(); // Can do things like stream().filter(logic).map(m).findFirst()
        return exampleReturn.get();
    }

    public ExampleDto updateExampleData(ExampleDto example) {
        OffsetDateTime createdDate = example.getCreatedDate();
        OffsetDateTime offsetDateTime = createdDate.plusYears(20000);
        example.setCreatedDate(offsetDateTime);
        return example;
    }

    public String removeExampleData(int exampleId) {
        return String.valueOf(exampleId);
    }
}
