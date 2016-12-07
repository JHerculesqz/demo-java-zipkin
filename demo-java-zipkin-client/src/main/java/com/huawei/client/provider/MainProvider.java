package com.huawei.client.provider;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.huawei._1_fw.component.http.HttpUtilsEx;
import com.huawei._1_fw.component.zipkin.ZipkinUtils;
import com.huawei.client.vo.Span1ResVo;
import com.huawei.client.vo.Span1Vo;

public class MainProvider {
	// #region Const

	public static String URL_SPAN2 = "http://localhost:7010/zipkin/client/span2";

	// #endregion

	// #region span1

	public static Span1ResVo span1(Span1Vo oSpan1Vo) throws InterruptedException, ExecutionException {
		Future<Span1ResVo> oFuture = ZipkinUtils.newThread(() -> {
			Span1ResVo oSpan1ResVo = HttpUtilsEx.postByTemplate(URL_SPAN2, oSpan1Vo, Span1ResVo.class);
			return oSpan1ResVo;
		} , "spanInThread");

		return oFuture.get();
	}

	// #endregion

	// #region span3

	public static Span1ResVo span3(Span1Vo oSpan1Vo) {
		Span1ResVo oSpan1ResVo = new Span1ResVo();
		oSpan1ResVo.setName("shit....");
		return oSpan1ResVo;
	}

	// #endregion
}
