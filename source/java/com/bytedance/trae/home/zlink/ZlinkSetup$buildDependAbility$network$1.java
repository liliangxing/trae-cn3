package com.bytedance.trae.home.zlink;

import android.util.Log;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.home.zlink.ZlinkSetup;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.ug.sdk.deeplink.callback.CallBackForFetchScheme;
import com.bytedance.ug.sdk.deeplink.interfaces.INetwork;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Pair;

/* compiled from: ZlinkSetup.kt */
@Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0002JT\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J.\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u0018"}, d2 = {"com/bytedance/trae/home/zlink/ZlinkSetup$buildDependAbility$network$1", "Lcom/bytedance/ug/sdk/deeplink/interfaces/INetwork;", ApiRequest.METHOD_GET, "", IWeixinService.ResponseConstants.URL, "requestHeaders", "", "addCommonParams", "", "maxLength", "", ApiRequest.METHOD_POST, "data", "", "timeout", "useGzip", "contentType", "fetchScheme", "", "baseUrl", "pathAndQuery", "", "callBackForFetchScheme", "Lcom/bytedance/ug/sdk/deeplink/callback/CallBackForFetchScheme;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ZlinkSetup$buildDependAbility$network$1 implements INetwork {
    public String get(String url, Map<String, String> requestHeaders, boolean addCommonParams, long maxLength) {
        Pair parseUrl;
        List<Header> headerList;
        String str = url;
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            parseUrl = ZlinkSetup.INSTANCE.parseUrl(url);
            String str2 = (String) parseUrl.component1();
            String str3 = (String) parseUrl.component2();
            ZlinkSetup.ZlinkNetApi zlinkNetApi = (ZlinkSetup.ZlinkNetApi) RetrofitUtils.createSsService(str2, ZlinkSetup.ZlinkNetApi.class);
            if (zlinkNetApi == null) {
                return "";
            }
            headerList = ZlinkSetup.INSTANCE.toHeaderList(requestHeaders);
            String str4 = (String) zlinkNetApi.get(str3, headerList).execute().body();
            return str4 == null ? "" : str4;
        } catch (Exception e) {
            Log.w("ZlinkSetup", "INetwork.get failed, url=" + url, e);
            return "";
        }
    }

    public String post(String url, Map<String, String> requestHeaders, byte[] data, long timeout, boolean useGzip, String contentType, boolean addCommonParams) {
        Pair parseUrl;
        List<Header> headerList;
        String str = url;
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            parseUrl = ZlinkSetup.INSTANCE.parseUrl(url);
            String str2 = (String) parseUrl.component1();
            String str3 = (String) parseUrl.component2();
            ZlinkSetup.ZlinkNetApi zlinkNetApi = (ZlinkSetup.ZlinkNetApi) RetrofitUtils.createSsService(str2, ZlinkSetup.ZlinkNetApi.class);
            if (zlinkNetApi == null) {
                return "";
            }
            if (contentType == null) {
                contentType = "application/json; charset=utf-8";
            }
            if (data == null) {
                data = new byte[0];
            }
            TypedByteArray typedByteArray = new TypedByteArray(contentType, data, new String[0]);
            headerList = ZlinkSetup.INSTANCE.toHeaderList(requestHeaders);
            String str4 = (String) zlinkNetApi.post(str3, typedByteArray, headerList).execute().body();
            return str4 == null ? "" : str4;
        } catch (Exception e) {
            Log.w("ZlinkSetup", "INetwork.post failed, url=" + url, e);
            return "";
        }
    }

    public void fetchScheme(final String baseUrl, final String pathAndQuery, int timeout, final CallBackForFetchScheme callBackForFetchScheme) {
        ExecutorService executorService;
        String str = baseUrl;
        if (!(str == null || str.length() == 0)) {
            String str2 = pathAndQuery;
            if (!(str2 == null || str2.length() == 0)) {
                executorService = ZlinkSetup.fetchExecutor;
                executorService.execute(new Runnable() { // from class: com.bytedance.trae.home.zlink.ZlinkSetup$buildDependAbility$network$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZlinkSetup$buildDependAbility$network$1.fetchScheme$lambda$0(baseUrl, callBackForFetchScheme, pathAndQuery);
                    }
                });
                return;
            }
        }
        if (callBackForFetchScheme != null) {
            callBackForFetchScheme.onFailure(new IllegalArgumentException("empty url"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchScheme$lambda$0(String str, CallBackForFetchScheme callBackForFetchScheme, String str2) {
        try {
            ZlinkSetup.ZlinkNetApi zlinkNetApi = (ZlinkSetup.ZlinkNetApi) RetrofitUtils.createSsService(str, ZlinkSetup.ZlinkNetApi.class);
            if (zlinkNetApi == null) {
                if (callBackForFetchScheme != null) {
                    callBackForFetchScheme.onFailure(new IllegalStateException("TTNet not initialized"));
                }
            } else {
                String str3 = (String) zlinkNetApi.get(str2, null).execute().body();
                if (str3 == null) {
                    str3 = "";
                }
                if (callBackForFetchScheme != null) {
                    callBackForFetchScheme.onSuccess(200, str3);
                }
            }
        } catch (Exception e) {
            Exception exc = e;
            Log.w("ZlinkSetup", "fetchScheme failed, baseUrl=" + str, exc);
            if (callBackForFetchScheme != null) {
                callBackForFetchScheme.onFailure(exc);
            }
        }
    }
}
