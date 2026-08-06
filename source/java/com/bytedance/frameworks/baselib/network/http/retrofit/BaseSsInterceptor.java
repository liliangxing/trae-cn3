package com.bytedance.frameworks.baselib.network.http.retrofit;

import android.os.Looper;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamConfig;
import com.bytedance.frameworks.baselib.network.http.commonparam.CommonParamManager;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class BaseSsInterceptor implements TTInternalInterceptor {
    protected void processAfterReceiveResponse(Request request, SsResponse ssResponse) throws Exception {
    }

    protected Request processBeforeSendRequest(Request request) throws IOException {
        String filterUrl;
        if (NetworkParams.getEnableMainThreadCheck() && Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("You must not send request on main thread");
        }
        if (request == null) {
            return null;
        }
        try {
            URL url = new URL(request.getUrl());
            if ("http".equals(url.getProtocol())) {
                NetworkParams.monitorApiHttp(url.getHost(), url.getPath(), false, request.getMetrics());
            }
        } catch (MalformedURLException unused) {
        }
        String url2 = request.getUrl();
        if (request.getExtraInfo() instanceof BaseRequestContext) {
            filterUrl = NetworkParams.filterUrl(url2, (BaseRequestContext) request.getExtraInfo(), request.getMetrics());
        } else {
            filterUrl = NetworkParams.filterUrl(url2, request.getMetrics());
        }
        if (request.getUrl().startsWith("https:") && filterUrl.startsWith("http:")) {
            try {
                URL url3 = new URL(filterUrl);
                NetworkParams.monitorApiHttp(url3.getHost(), url3.getPath(), true, request.getMetrics());
            } catch (Throwable unused2) {
            }
        }
        if (request.isAddCommonParam()) {
            CommonParamConfig commonParamConfig = CommonParamManager.inst().getCommonParamConfig();
            if (commonParamConfig != null && commonParamConfig.isNewStrategyEnabled()) {
                filterUrl = CommonParamManager.inst().addCommonParams(request, filterUrl, request.getMetrics());
            } else {
                filterUrl = tryAddCommonParams(filterUrl, request.getMetrics());
            }
        }
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.url(filterUrl);
        return newBuilder.build();
    }

    private String tryAddCommonParams(String str, RetrofitMetrics retrofitMetrics) {
        try {
            return NetworkParams.addCommonParams(str, true, retrofitMetrics);
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public SsResponse intercept(Interceptor.Chain chain) throws Exception {
        SsResponse proceed;
        Request processBeforeSendRequest = processBeforeSendRequest(chain.request());
        if (RealInterceptorChain.isProceedWithoutHookEnabled()) {
            proceed = chain.proceedWithoutHook(processBeforeSendRequest);
        } else {
            proceed = chain.proceed(processBeforeSendRequest);
        }
        processAfterReceiveResponse(processBeforeSendRequest, proceed);
        return proceed;
    }
}
