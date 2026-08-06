package com.bytedance.sdk.open.aweme.commonbase.net;

import android.content.Context;
import com.bytedance.sdk.open.aweme.common.constants.OpenConstants;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.C0104a;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.C0105b;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.C0106c;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenException;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor;
import com.bytedance.sdk.open.aweme.commonbase.net.mime.FormUrlEncodedRequestBody;
import com.bytedance.sdk.open.aweme.commonbase.net.mime.JsonRequestBody;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import com.bytedance.sdk.open.aweme.core.net.OpenNetHeaders;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OpenNetworkManager {
    private static volatile OpenNetworkManager INSTANCE;
    private Context mContext;
    private static volatile CopyOnWriteArrayList<OpenInterceptor> sInterceptors = new CopyOnWriteArrayList<>();
    private static volatile Map<String, OpenInterceptor> sInterceptorAndDecoratorMap = new ConcurrentHashMap();

    private OpenNetworkManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized void addInterceptor(OpenInterceptor openInterceptor) {
        synchronized (OpenNetworkManager.class) {
            if (openInterceptor == null) {
                return;
            }
            String name = openInterceptor.getClass().getName();
            if (!sInterceptorAndDecoratorMap.containsKey(name)) {
                sInterceptors.add(openInterceptor);
                sInterceptorAndDecoratorMap.put(name, openInterceptor);
            }
        }
    }

    private OpenHostResponse getResponseWithInterceptorChain(OpenHostRequest openHostRequest) {
        OpenHostResponse openHostResponse;
        try {
            LinkedList linkedList = new LinkedList();
            if (sInterceptors != null) {
                linkedList.addAll(sInterceptors);
            }
            linkedList.add(new C0105b());
            linkedList.add(new C0104a());
            return new C0106c(linkedList, 0, openHostRequest).proceed(openHostRequest);
        } catch (Exception e) {
            if (e instanceof OpenException) {
                OpenException openException = (OpenException) e;
                openHostResponse = new OpenHostResponse(openException.getErrCode(), openException.getErrMsg(), openHostRequest.getUrl(), OpenNetHeaders.empty, null, e);
            } else {
                openHostResponse = new OpenHostResponse(-1, e.getMessage(), openHostRequest.getUrl(), OpenNetHeaders.empty, null, e);
            }
            LogUtils.m28e("", e);
            return openHostResponse;
        }
    }

    private OpenHostRequest handleOpenRequest(OpenHostRequest openHostRequest) {
        String replaceFirst;
        OpenHostRequest.Builder builder;
        if (!DouYinSdkContext.inst().isBoe() || openHostRequest.getUrl() == null) {
            return openHostRequest;
        }
        if (openHostRequest.getUrl().startsWith(OpenConstants.OPEN_DOMAIN)) {
            replaceFirst = openHostRequest.getUrl().replaceFirst(OpenConstants.OPEN_DOMAIN, OpenConstants.BOE_OPEN_DOMAIN);
            builder = new OpenHostRequest.Builder(openHostRequest);
        } else {
            if (!openHostRequest.getUrl().startsWith(OpenConstants.CLIENT_DOMAIN)) {
                return openHostRequest;
            }
            replaceFirst = openHostRequest.getUrl().replaceFirst(OpenConstants.CLIENT_DOMAIN, OpenConstants.BOE_CLIENT_DOMAIN);
            builder = new OpenHostRequest.Builder(openHostRequest);
        }
        return builder.url(replaceFirst).build();
    }

    public static OpenNetworkManager with(Context context) {
        if (INSTANCE == null) {
            synchronized (OpenNetworkManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OpenNetworkManager(context);
                }
            }
        }
        return INSTANCE;
    }

    public OpenHostResponse execute(OpenHostRequest openHostRequest) {
        return getResponseWithInterceptorChain(handleOpenRequest(openHostRequest));
    }

    public OpenHostResponse get(String str) {
        return execute(new OpenHostRequest.Builder(str).get().build());
    }

    public OpenHostResponse get(String str, Map<String, String> map) {
        return execute(new OpenHostRequest.Builder(str).get().setHeaders(map).build());
    }

    public OpenHostResponse get(String str, Map<String, String> map, long j) {
        return execute(new OpenHostRequest.Builder(str).get().setHeaders(map).build());
    }

    public IOpenHostNetCall newCall(OpenHostRequest openHostRequest) {
        OpenHostRequest handleOpenRequest = handleOpenRequest(openHostRequest);
        OpenNetworkService openNetworkService = (OpenNetworkService) OpenServiceManager.getInst().getService(OpenNetworkService.class);
        if (openNetworkService == null) {
            openNetworkService = new C0102a();
        }
        return openNetworkService.newCall(handleOpenRequest);
    }

    public OpenHostResponse postJson(String str, JSONObject jSONObject) {
        return execute(new OpenHostRequest.Builder(str).post(new JsonRequestBody(jSONObject)).build());
    }

    public OpenHostResponse postJson(String str, JSONObject jSONObject, Map<String, String> map) {
        return execute(new OpenHostRequest.Builder(str).post(new JsonRequestBody(jSONObject)).setHeaders(map).build());
    }

    public OpenHostResponse postJson(String str, JSONObject jSONObject, Map<String, String> map, long j) {
        return execute(new OpenHostRequest.Builder(str).post(new JsonRequestBody(jSONObject)).setHeaders(map).connectTimeOut(j).readTimeOut(j).writeTimeOut(j).build());
    }

    public OpenHostResponse postUrlEncode(String str, Map<String, String> map, Map<String, String> map2) {
        FormUrlEncodedRequestBody formUrlEncodedRequestBody = new FormUrlEncodedRequestBody();
        if (map2 != null) {
            formUrlEncodedRequestBody.addFields(map2);
        }
        return execute(new OpenHostRequest.Builder(str).post(formUrlEncodedRequestBody).setHeaders(map).build());
    }

    public OpenHostResponse postUrlEncode(String str, Map<String, String> map, Map<String, String> map2, boolean z) {
        FormUrlEncodedRequestBody formUrlEncodedRequestBody = new FormUrlEncodedRequestBody();
        if (map2 != null) {
            formUrlEncodedRequestBody.addFields(map2);
        }
        return execute(new OpenHostRequest.Builder(str).post(formUrlEncodedRequestBody).setHeaders(map).addHostCommonParams(z).build());
    }
}
