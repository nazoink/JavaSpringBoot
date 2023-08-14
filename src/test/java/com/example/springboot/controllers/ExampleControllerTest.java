package com.example.springboot.controllers;

import com.example.springboot.models.ExampleDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import com.example.springboot.service.IExampleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
public class ExampleControllerTest {
    @InjectMocks
    ExampleController exampleController;

    @Mock
    IExampleService exampleService;

    @Test
    public void testGetExample() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ExampleDto exampleDto = new ExampleDto();
        when(exampleService.getExampleData()).thenReturn(exampleDto);
        ResponseEntity<ExampleDto> retrievedExample = exampleController.getExample();
        assertThat(retrievedExample).isEqualTo(new ResponseEntity<>(exampleDto, HttpStatus.OK));
    }

    @Test
    public void testPostBodyExample() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ExampleDto exampleDto = new ExampleDto();
        when(exampleService.addExampleData(exampleDto)).thenReturn(exampleDto);
        ResponseEntity<ExampleDto> retrievedExample = exampleController.postBodyExample(exampleDto);
        assertThat(retrievedExample).isEqualTo(new ResponseEntity<>(exampleDto, HttpStatus.CREATED));
    }

    @Test
    public void testPutExample() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ExampleDto exampleDto = new ExampleDto();
        when(exampleService.updateExampleData(exampleDto)).thenReturn(exampleDto);
        ResponseEntity<ExampleDto> retrievedExample = exampleController.putExample(exampleDto);
        assertThat(retrievedExample).isEqualTo(new ResponseEntity<>(exampleDto, HttpStatus.OK));
    }

    @Test
    public void testDeleteExample() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ExampleDto exampleDto = new ExampleDto();
        when(exampleService.removeExampleData(exampleDto.getId())).thenReturn(String.valueOf(exampleDto.getId()));
        ResponseEntity<String> retrievedExample = exampleController.deleteExample(exampleDto.getId());
        assertThat(retrievedExample).isEqualTo(new ResponseEntity<>(String.valueOf(exampleDto.getId()), HttpStatus.OK));
    }
}
