package com.example.springboot.controllers;

import com.example.springboot.models.ExampleDto;
import com.example.springboot.service.IExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/example")
public class ExampleController {

    // Configured injection of service
    @Autowired
    private IExampleService exampleService;

    /**
     * Gets an example dto object.
     * @return example ExampleDto.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ExampleDto> getExample() {
        ExampleDto exampleData = null;
        ResponseEntity<ExampleDto> responseEntity;
        try {
            exampleData = exampleService.getExampleData();
            responseEntity = new ResponseEntity<>(exampleData, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(exampleData, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * Adds an example object
     * @param example ExampleDto.
     * @return example ExampleDto.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/post", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ExampleDto> postBodyExample(@RequestBody ExampleDto example) {
        ExampleDto exampleData = null;
        ResponseEntity<ExampleDto> responseEntity;
        try {
            exampleData = exampleService.addExampleData(example);
            responseEntity = new ResponseEntity<>(exampleData, HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(exampleData, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     *
     * @param example
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/put", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ExampleDto> putExample(@RequestBody ExampleDto example) {
        ExampleDto exampleData = null;
        ResponseEntity<ExampleDto> responseEntity;
        try {
            exampleData = exampleService.updateExampleData(example);
            responseEntity = new ResponseEntity<>(exampleData, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(exampleData, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    // Can also call specific Mapping types

    /**
     *
     * @param exampleId
     * @return
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> deleteExample(@RequestBody int exampleId) {
        String exampleData = null;
        ResponseEntity<String> responseEntity;
        try {
            exampleData = exampleService.removeExampleData(exampleId);
            responseEntity = new ResponseEntity<>(exampleData, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(exampleData, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
