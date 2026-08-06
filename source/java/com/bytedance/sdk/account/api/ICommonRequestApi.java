package com.bytedance.sdk.account.api;

import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.response.CommonRequestResponse;
import java.util.Map;

/* loaded from: classes5.dex */
public interface ICommonRequestApi {
    void doCommonGetRequestWithPath(String str, Map<String, String> map, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonGetRequestWithPath(String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonGetRequestWithPathWithCache(String str, Map<String, String> map, long j, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonGetRequestWithPathWithCache(String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonGetRequestWithUrl(String str, Map<String, String> map, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonGetRequestWithUrl(String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonGetRequestWithUrlWithCache(String str, Map<String, String> map, long j, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonGetRequestWithUrlWithCache(String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonPostRequestPath(String str, Map<String, String> map, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonPostRequestPath(String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonPostRequestPathWithCache(String str, Map<String, String> map, long j, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonPostRequestPathWithCache(String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonPostRequestUrl(String str, Map<String, String> map, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonPostRequestUrl(String str, Map<String, String> map, Map<String, String> map2, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonPostRequestUrlWithCache(String str, Map<String, String> map, long j, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonPostRequestUrlWithCache(String str, Map<String, String> map, Map<String, String> map2, long j, AbsApiCall<CommonRequestResponse> absApiCall);

    void doCommonRequest(String str, Map<String, String> map, Map<String, String> map2, boolean z, AbsApiCall<CommonRequestResponse> absApiCall);
}
