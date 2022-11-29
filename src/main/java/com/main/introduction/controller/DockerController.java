package com.main.introduction.controller;

import com.main.introduction.config.SecurityConfig;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Schema(additionalProperties = Schema.AdditionalPropertiesValue.FALSE)
@RequestMapping("api")
public class DockerController {

    @ApiModelProperty(example = "테스트")
    private String test;

    @GetMapping("/docker")
    @ApiOperation(value="테스트", notes="테스트입니다")
    public String home(){
        return "docker Start";
    }

}
