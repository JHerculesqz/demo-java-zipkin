package com.huawei.client.provider;

import com.huawei._1_fw.HttpUtilsEx;
import com.huawei.client.vo.Span1ResVo;
import com.huawei.client.vo.Span1Vo;

public class MainProvider {
	// #region Const

	private static String URL_SPAN2 = "http://localhost:7000/zipkin/client/span2";

	// #endregion

	// #region span1

	public static Span1ResVo span1(Span1Vo oSpan1Vo) {
		Span1ResVo oSpan1ResVo = HttpUtilsEx.postByTemplate(URL_SPAN2, oSpan1Vo, Span1ResVo.class);
		return oSpan1ResVo;
	}

	// #endregion

	// #region span2

	public static Span1ResVo span2(Span1Vo oSpan1Vo) {
		Span1ResVo oSpan1ResVo = new Span1ResVo();
		oSpan1ResVo.setName("shit....");
		return oSpan1ResVo;
	}

	// #endregion
}
