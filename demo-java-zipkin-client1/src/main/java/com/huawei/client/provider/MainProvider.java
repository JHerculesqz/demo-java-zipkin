package com.huawei.client.provider;

import com.huawei._1_fw.component.http.HttpUtilsEx;
import com.huawei.client.vo.Span1ResVo;
import com.huawei.client.vo.Span1Vo;

public class MainProvider {
	// #region Const

	public static String URL_SPAN3 = "http://localhost:7000/zipkin/client/span3";

	// #endregion

	// #region span2

	public static Span1ResVo span2(Span1Vo oSpan1Vo) {
		return HttpUtilsEx.postByTemplate(URL_SPAN3, oSpan1Vo, Span1ResVo.class);
		// System.out.println(1 / 0);
		// return null;
	}

	// #endregion
}
