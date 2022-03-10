package com.rong.controller;

import com.rong.config.WxPayConfig;
import com.rong.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonString;

@Api("测试")
@RestController
@RequestMapping("/test")
 public class test {
  @Resource
  private WxPayConfig wxPayConfig;

 @GetMapping("/")
 public String index(){
 return "Hello Spring Boot";
 }

 @ApiOperation("tes")
 @GetMapping("/test")
  public JsonResult<String> test(){
   JsonResult<String> result = new JsonResult(200,wxPayConfig.getMchId());
   result.setMessage("测试");
   return result;
  }



 }
