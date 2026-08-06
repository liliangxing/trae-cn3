package com.bytedance.apm.agent.instrumentation.interceptor;

import android.text.TextUtils;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AddHeaderInterceptor implements Interceptor {
    public static final String X_TT_TRACE_LOG = "x-tt-trace-log";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        if (TextUtils.isEmpty(request.header("x-tt-trace-log")) && NetDataPipeline.getInstance().isNetWorkV2()) {
            if (NetDataPipeline.getInstance().isEnableBaseApiAll() && NetDataPipeline.getInstance().isEnableHookNetSample()) {
                newBuilder.addHeader("x-tt-trace-log", "01");
            } else if (NetDataPipeline.getInstance().getReportSLA() == 1 && NetDataPipeline.getInstance().isEnableHookNetSample()) {
                newBuilder.addHeader("x-tt-trace-log", "02");
            }
        }
        return chain.proceed(newBuilder.build());
    }
}
