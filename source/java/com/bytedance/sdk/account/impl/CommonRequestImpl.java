package com.bytedance.sdk.account.impl;

import android.content.Context;
import com.bytedance.sdk.account.api.ICommonRequestApi;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.response.CommonRequestResponse;
import com.bytedance.sdk.account.job.CommonRequestJob;
import com.ss.android.account.TTAccountInit;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CommonRequestImpl implements ICommonRequestApi {
    private static volatile ICommonRequestApi sInstance;
    private Context mContext = TTAccountInit.getConfig().getApplicationContext();

    private CommonRequestImpl() {
    }

    public static ICommonRequestApi instance() {
        if (sInstance == null) {
            synchronized (CommonRequestImpl.class) {
                if (sInstance == null) {
                    sInstance = new CommonRequestImpl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonRequest(String str, Map<String, String> map, Map<String, String> map2, boolean z, AbsApiCall<CommonRequestResponse> absApiCall) {
        CommonRequestJob.doCommonRequest(this.mContext, str, map, map2, z, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonGetRequestWithUrl(String str, Map<String, String> map, AbsApiCall<CommonRequestResponse> absApiCall) {
        doCommonGetRequestWithUrl(str, null, map, absApiCall);
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonGetRequestWithUrl(String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall) {
        CommonRequestJob.doCommonGetRequestWithUrl(this.mContext, str, map, map2, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonGetRequestWithUrlWithCache(String str, Map<String, String> map, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        doCommonGetRequestWithUrlWithCache(str, null, map, j, absApiCall);
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonGetRequestWithUrlWithCache(String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        CommonRequestJob doCommonGetRequestWithUrlWithCache = CommonRequestJob.doCommonGetRequestWithUrlWithCache(this.mContext, str, map, map2, j, absApiCall);
        if (doCommonGetRequestWithUrlWithCache != null) {
            doCommonGetRequestWithUrlWithCache.start();
        }
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonGetRequestWithPath(String str, Map<String, String> map, AbsApiCall<CommonRequestResponse> absApiCall) {
        doCommonGetRequestWithPath(str, null, map, absApiCall);
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonGetRequestWithPath(String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall) {
        CommonRequestJob.doCommonGetRequestWithPath(this.mContext, str, map, map2, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonGetRequestWithPathWithCache(String str, Map<String, String> map, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        doCommonGetRequestWithPathWithCache(str, null, map, j, absApiCall);
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonGetRequestWithPathWithCache(String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        CommonRequestJob doCommonGetRequestWithPathWithCache = CommonRequestJob.doCommonGetRequestWithPathWithCache(this.mContext, str, map, map2, j, absApiCall);
        if (doCommonGetRequestWithPathWithCache != null) {
            doCommonGetRequestWithPathWithCache.start();
        }
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonPostRequestUrl(String str, Map<String, String> map, AbsApiCall<CommonRequestResponse> absApiCall) {
        doCommonPostRequestUrl(str, null, map, absApiCall);
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonPostRequestUrl(String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall) {
        CommonRequestJob.doCommonPostRequestWithUrl(this.mContext, str, map, map2, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonPostRequestUrlWithCache(String str, Map<String, String> map, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        doCommonPostRequestUrlWithCache(str, null, map, j, absApiCall);
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonPostRequestUrlWithCache(String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        CommonRequestJob doCommonPostRequestWithUrlWithCache = CommonRequestJob.doCommonPostRequestWithUrlWithCache(this.mContext, str, map, map2, j, absApiCall);
        if (doCommonPostRequestWithUrlWithCache != null) {
            doCommonPostRequestWithUrlWithCache.start();
        }
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonPostRequestPath(String str, Map<String, String> map, AbsApiCall<CommonRequestResponse> absApiCall) {
        doCommonPostRequestPath(str, null, map, absApiCall);
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonPostRequestPath(String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall) {
        CommonRequestJob.doCommonPostRequestWithPath(this.mContext, str, map, map2, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonPostRequestPathWithCache(String str, Map<String, String> map, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        doCommonPostRequestPathWithCache(str, null, map, j, absApiCall);
    }

    @Override // com.bytedance.sdk.account.api.ICommonRequestApi
    public void doCommonPostRequestPathWithCache(String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall) {
        CommonRequestJob doCommonPostRequestWithPathWithCache = CommonRequestJob.doCommonPostRequestWithPathWithCache(this.mContext, str, map, map2, j, absApiCall);
        if (doCommonPostRequestWithPathWithCache != null) {
            doCommonPostRequestWithPathWithCache.start();
        }
    }
}
