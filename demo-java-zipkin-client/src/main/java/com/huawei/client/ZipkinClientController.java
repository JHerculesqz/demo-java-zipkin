package com.huawei.client;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.client.vo.Span1ResVo;
import com.huawei.client.vo.Span1Vo;

@Controller
@EnableAutoConfiguration
public class ZipkinClientController {
	// #region Fields

	@Autowired
	public ZipkinClientService zipkinClientService;

	// #endregion

	// #region span1

	@RequestMapping("zipkin/client/span1")
	@ResponseBody
	public Span1ResVo span1(@RequestBody Span1Vo oSpan1Vo) throws InterruptedException, ExecutionException {
		return zipkinClientService.span1(oSpan1Vo);
	}

	// #endregion

	// #region span3

	@RequestMapping("zipkin/client/span3")
	@ResponseBody
	public Span1ResVo span3(@RequestBody Span1Vo oSpan1Vo) {
		return zipkinClientService.span3(oSpan1Vo);
	}

	// #endregion
}
