package com.main.introduction.controller;

import com.main.introduction.config.SecurityConfig;
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

    @GetMapping("/docker")
    @Operation(summary = "Returns List of Audit Log records based on the matching search critera", description = "Returns list of Audit Log records matching the search critera. SLA:500",
            responses = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of list of Audit Log records matching the search criteria", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SecurityConfig.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input provided", content = { @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = { @Content(mediaType = "application/json")}),})
    public String home(){
        return "docker Start";
    }

}
