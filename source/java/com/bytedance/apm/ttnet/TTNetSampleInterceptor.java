package com.bytedance.apm.ttnet;

import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTNetSampleInterceptor implements Interceptor {
    public static final String X_TT_TRACE_LOG = "x-tt-trace-log";

    public SsResponse intercept(Interceptor.Chain chain) throws Exception {
        Request request = chain.request();
        if (ListUtils.isEmpty(request.headers("x-tt-trace-log")) && NetDataPipeline.getInstance().isNetWorkV2()) {
            if (NetDataPipeline.getInstance().isEnableBaseApiAll() && NetDataPipeline.getInstance().isEnableHookNetSample()) {
                return chain.proceed(getNewRequest(request, "01"));
            }
            if (NetDataPipeline.getInstance().getReportSLA() == 1 && NetDataPipeline.getInstance().isEnableHookNetSample()) {
                return chain.proceed(getNewRequest(request, "02"));
            }
        }
        return chain.proceed(request);
    }

    private Request getNewRequest(Request request, String str) {
        ArrayList arrayList = new ArrayList(request.getHeaders());
        Request.Builder newBuilder = request.newBuilder();
        arrayList.add(new Header("x-tt-trace-log", str));
        return newBuilder.headers(arrayList).build();
    }
}
