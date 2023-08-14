package com.example.springboot.service;

import com.example.springboot.models.ExampleDto;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IExampleService {

    ExampleDto getExampleData();
    ExampleDto addExampleData(ExampleDto example);
    ExampleDto updateExampleData(ExampleDto example);
    String removeExampleData(int exampleId);
}
