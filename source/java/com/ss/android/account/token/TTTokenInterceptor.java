package com.ss.android.account.token;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.sdk.account.ticketguard.SecUserIdGuardSettingManager;
import com.ss.android.token.RequestContent;
import com.ss.android.token.TTTokenHeader;
import com.ss.android.token.TTTokenManager;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTTokenInterceptor implements Interceptor {
    public SsResponse intercept(Interceptor.Chain chain) throws Exception {
        Map<String, String> map;
        Request request = chain.request();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders());
        RequestContent addRequestHeader = TTTokenManager.addRequestHeader(request.getUrl(), getRequestParams(request));
        if (addRequestHeader != null && (map = addRequestHeader.headers) != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    arrayList.add(new Header(entry.getKey(), entry.getValue()));
                }
            }
        }
        SsResponse proceed = chain.proceed(request.newBuilder().headers(arrayList).build());
        TTTokenManager.processResponseHeader(request.getUrl(), addRequestHeader, getRequestHeadersAfterProceed(addRequestHeader, proceed), TTTokenUtils.toHeaders(proceed.headers()));
        return proceed;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0058 A[Catch: all -> 0x0072, TryCatch #1 {all -> 0x0072, blocks: (B:6:0x0012, B:8:0x001e, B:17:0x0034, B:20:0x0039, B:30:0x0049, B:31:0x0051, B:35:0x004e, B:24:0x0043, B:36:0x0052, B:38:0x0058, B:40:0x0064, B:10:0x0023, B:12:0x0029, B:14:0x002d, B:22:0x0040), top: B:5:0x0012, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getRequestParams(Request request) {
        String str = null;
        if (!SecUserIdGuardSettingManager.isEnable() || !SecUserIdGuardSettingManager.isPathNeedGuard(request.getPath())) {
            return null;
        }
        try {
            if ("post".equalsIgnoreCase(request.getMethod())) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        TypedOutput body = request.getBody();
                        if (body != null && (body instanceof FormUrlEncodedTypedOutput)) {
                            body.writeTo(byteArrayOutputStream);
                            str = byteArrayOutputStream.toString();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (TextUtils.isEmpty(str)) {
                            }
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        return TextUtils.isEmpty(str) ? str : str;
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            }
            if (TextUtils.isEmpty(str) && request.getUrl().contains("?")) {
                return request.getUrl().split("\\?")[1];
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return str;
        }
    }

    private List<TTTokenHeader> getRequestHeadersAfterProceed(RequestContent requestContent, SsResponse ssResponse) {
        if (requestContent == null || !requestContent.getAllRequestHeader) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Object extraInfo = ssResponse.raw().getExtraInfo();
        if (extraInfo instanceof BaseHttpRequestInfo) {
            try {
                JSONObject jSONObject = new JSONObject(((BaseHttpRequestInfo) extraInfo).requestHeaders);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String optString = jSONObject.optString(next);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(new TTTokenHeader(next, optString));
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
