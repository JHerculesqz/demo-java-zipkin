package com.huawei.client;

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

	// #region span2

	@RequestMapping("zipkin/client/span2")
	@ResponseBody
	public Span1ResVo span2(@RequestBody Span1Vo oSpan1Vo) {
		return zipkinClientService.span2(oSpan1Vo);
	}

	// #endregion
}
