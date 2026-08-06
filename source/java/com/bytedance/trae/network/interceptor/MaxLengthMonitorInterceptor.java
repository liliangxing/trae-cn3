package com.bytedance.trae.network.interceptor;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.utils.logger.FLogger;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: MaxLengthMonitorInterceptor.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "<init>", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "getHeaderValue", "", "headers", "", "Lcom/bytedance/retrofit2/client/Header;", "headerName", "monitorLog", "", "url", "code", "", "contentLength", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MaxLengthMonitorInterceptor implements Interceptor {
    private static final int DEF_MAX_RESPONSE_LENGTH = 5242880;
    private static final String TAG = "MaxLengthMonitor";

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain chain) {
        Request request;
        String headerValue;
        Integer intOrNull;
        if (chain == null || (request = chain.request()) == null) {
            return null;
        }
        int maxLength = request.getMaxLength();
        SsResponse<?> proceed = chain.proceed(request);
        if (proceed != null) {
            try {
                if (!proceed.isSuccessful() || (headerValue = getHeaderValue(proceed.headers(), "content-length")) == null || (intOrNull = StringsKt.toIntOrNull(headerValue)) == null) {
                    return proceed;
                }
                int intValue = intOrNull.intValue();
                if (maxLength < 0 && Intrinsics.areEqual(request.getMethod(), "GET") && intValue >= DEF_MAX_RESPONSE_LENGTH) {
                    monitorLog(request.getUrl(), proceed.code(), headerValue);
                    return chain.proceed(request.newBuilder().maxLength(intValue).build());
                }
            } catch (Exception e) {
                FLogger.INSTANCE.mo427e(TAG, "intercept error", e);
            }
        }
        return proceed;
    }

    private final String getHeaderValue(List<Header> headers, String headerName) {
        Object obj;
        if (headers == null) {
            return null;
        }
        Iterator<T> it = headers.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.equals(((Header) obj).getName(), headerName, true)) {
                break;
            }
        }
        Header header = (Header) obj;
        if (header != null) {
            return header.getValue();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r4 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void monitorLog(String url, int code, String contentLength) {
        Object obj;
        String str;
        try {
            if (url != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    MaxLengthMonitorInterceptor maxLengthMonitorInterceptor = this;
                    obj = Result.constructor-impl(new URI(url).getPath());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                str = (String) obj;
            }
            str = "";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", str);
            jSONObject.put("code", code);
            jSONObject.put("content_length", contentLength);
            ApmService.INSTANCE.monitorEventForSlardar("request_too_large", jSONObject, null, null);
        } catch (Exception unused) {
        }
    }
}
