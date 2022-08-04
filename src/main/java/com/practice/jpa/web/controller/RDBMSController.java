package com.practice.jpa.web.controller;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "관계형 데이터베이스 테스트")
@RequestMapping(value = "/api/rdbms")
@RestController
public interface RDBMSController {
    @ApiOperation(value = "현재 저장된 데이터 불러오기")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK")
            }
    )
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{models}")
    ResponseEntity api(
            @ApiParam(examples = @Example(value = @ExampleProperty("member")), name = "불러올 엔티티명") @PathVariable String models);

    @ApiOperation(value = "데이터 삽입")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "CREATED")
            }
    )
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{models}")
    ResponseEntity insert(
            @ApiParam(examples = @Example(value = @ExampleProperty("member")), name = "저장할 엔티티명") @PathVariable String models,
            @ApiParam(examples = @Example(value = {@ExampleProperty("T"), @ExampleProperty("F")}), name = "롤백 여부") @RequestParam String rollback,
            @ApiParam(examples = @Example(value = {@ExampleProperty("10000")}), name = "삽입 개수") @RequestParam Long number);

    @ApiOperation(value = "데이터 수정")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK")
            }
    )
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{models}")
    ResponseEntity update(
            @ApiParam(examples = @Example(value = @ExampleProperty("member")), name = "수정할 엔티티명") @PathVariable String models,
            @ApiParam(examples = @Example(value = {@ExampleProperty("T"), @ExampleProperty("F")}), name = "롤백 여부") @RequestParam String rollback);

    @ApiOperation(value = "데이터 삭제")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK")
            }
    )
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{models}")
    ResponseEntity delete(
            @ApiParam(examples = @Example(value = @ExampleProperty("member")), name = "삭제할 엔티티명") @PathVariable String models,
            @ApiParam(examples = @Example(value = {@ExampleProperty("T"), @ExampleProperty("F")}), name = "롤백 여부") @RequestParam String rollback);
}
