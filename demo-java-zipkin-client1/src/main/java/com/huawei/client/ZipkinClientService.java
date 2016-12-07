package com.huawei.client;

import org.springframework.stereotype.Service;

import com.huawei.client.provider.MainProvider;
import com.huawei.client.vo.Span1ResVo;
import com.huawei.client.vo.Span1Vo;

@Service
public class ZipkinClientService {
	// #region span2

	public Span1ResVo span2(Span1Vo oSpan1Vo) {
		return MainProvider.span2(oSpan1Vo);
	}

	// #endregion
}
