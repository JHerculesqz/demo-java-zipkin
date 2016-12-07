package com.huawei.client;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.huawei.client.provider.MainProvider;
import com.huawei.client.vo.Span1ResVo;
import com.huawei.client.vo.Span1Vo;

@Service
public class ZipkinClientService {
	// #region span1

	public Span1ResVo span1(Span1Vo oSpan1Vo) throws InterruptedException, ExecutionException {
		return MainProvider.span1(oSpan1Vo);
	}

	// #endregion

	// #region span3

	public Span1ResVo span3(Span1Vo oSpan1Vo) {
		return MainProvider.span3(oSpan1Vo);
	}

	// #endregion

}
