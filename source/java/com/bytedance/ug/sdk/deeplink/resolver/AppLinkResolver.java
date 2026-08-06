package com.bytedance.ug.sdk.deeplink.resolver;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.CallBackForAppLink;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.UriCacheHandler;
import com.bytedance.ug.sdk.deeplink.ZlinkProviderManager;
import com.bytedance.ug.sdk.deeplink.callback.CallBackForFetchScheme;
import com.bytedance.ug.sdk.deeplink.callback.CallbackManager;
import com.bytedance.ug.sdk.deeplink.interfaces.INetwork;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsApi;
import com.bytedance.ug.sdk.deeplink.utils.CollectionsUtils;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.NetworkUtils;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import com.bytedance.ug.sdk.deeplink.utils.UGLogger;
import com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AppLinkResolver implements IResolver {
    private static final String HTTP_URL_CONNECTION = "http_url_connection";
    private static final int LINK_TYPE = 0;
    private static final String TAG = "AppLinkResolver";
    private static final String TTNET = "ttnet";

    @Override // com.bytedance.ug.sdk.deeplink.resolver.IResolver
    public String tag() {
        return TAG;
    }

    public static boolean isAppLink(Uri uri) {
        CallBackForAppLink callBackForAppLink;
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        String host = uri.getHost();
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            List<String> appLinkHostList = ZlinkSettingsApi.getAppLinkHostList(GlobalContext.INSTANCE.getApplication());
            if (CollectionsUtils.isEmptyList(appLinkHostList) && (callBackForAppLink = HostCommonServices.getCallBackForAppLink()) != null) {
                appLinkHostList = callBackForAppLink.getHostList();
            }
            if (!CollectionsUtils.isEmptyList(appLinkHostList)) {
                for (String str : appLinkHostList) {
                    if (host != null && host.equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.ug.sdk.deeplink.resolver.IResolver
    public boolean isSelf(Uri uri) {
        return isAppLink(uri);
    }

    @Override // com.bytedance.ug.sdk.deeplink.resolver.IResolver
    public void consume(Context context, Uri uri, boolean z, UGLogger.LogContext logContext) {
        CallBackForAppLink callBackForAppLink;
        if (uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("scheme");
        if (!TextUtils.isEmpty(queryParameter)) {
            UriCacheHandler.cacheScheme(uri);
        }
        if (TextUtils.isEmpty(uri.getHost()) || (callBackForAppLink = HostCommonServices.getCallBackForAppLink()) == null) {
            return;
        }
        GlobalContext.INSTANCE.setCallUri(uri, z);
        if (!TextUtils.isEmpty(queryParameter)) {
            EventUtil.sendParseAppLinkEvent(2, "", null);
            CallbackManager.callbackForAppLink(callBackForAppLink, queryParameter);
            UGZlinkLogger.onLinkParseSuccess(0, queryParameter, logContext);
            UGZlinkLogger.onLinkInvokeEnd(0, queryParameter, logContext);
            return;
        }
        doRequestForSchema(uri, callBackForAppLink, logContext);
    }

    private static void doRequestForSchema(Uri uri, final CallBackForAppLink callBackForAppLink, final UGLogger.LogContext logContext) {
        String uri2;
        if (uri == null || callBackForAppLink == null) {
            return;
        }
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        long updateVersionCode = zlinkDepend != null ? zlinkDepend.getUpdateVersionCode() : 0L;
        if (updateVersionCode != 0) {
            uri = uri.buildUpon().appendQueryParameter(CommonConstants.ZLINK_UPDATE_VERSION_CODE, String.valueOf(updateVersionCode)).build();
            uri2 = uri.toString();
        } else {
            uri2 = uri.toString();
        }
        final String str = uri2;
        String scheme = uri.getScheme();
        if ("http".equalsIgnoreCase(scheme)) {
            scheme = "https";
        }
        String str2 = scheme + "://" + uri.getHost();
        String query = uri.getQuery();
        String path = uri.getPath();
        if (query != null) {
            path = uri.getPath() + "?" + uri.getQuery();
        }
        String str3 = path;
        final int requestTimeout = ZlinkSettingsApi.getRequestTimeout(GlobalContext.INSTANCE.getApplication());
        try {
            if (((INetwork) ZlinkProviderManager.getProvider(INetwork.class)) == null) {
                Logger.m447e(TAG, "the INetwork is null so the request couldn't be sent !");
            } else {
                final long currentTimeMillis = System.currentTimeMillis();
                NetworkUtils.getInstance().fetchScheme(str2, str3, requestTimeout, new CallBackForFetchScheme() { // from class: com.bytedance.ug.sdk.deeplink.resolver.AppLinkResolver.1
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
                    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
                    /* JADX WARN: Removed duplicated region for block: B:6:0x002c  */
                    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
                    @Override // com.bytedance.ug.sdk.deeplink.callback.CallBackForFetchScheme
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onSuccess(int i, String str4) {
                        String queryParameter;
                        EventUtil.sendNetworkTimeConsumingEvent(str, i, System.currentTimeMillis() - currentTimeMillis, requestTimeout, "ttnet");
                        if (!TextUtils.isEmpty(str4)) {
                            try {
                                queryParameter = Uri.parse(str4).getQueryParameter("scheme");
                            } catch (Throwable unused) {
                            }
                            int i2 = i == -1 ? 1 : 0;
                            if (!TextUtils.isEmpty(queryParameter)) {
                                int i3 = i2 != 0 ? 3 : 0;
                                UGZlinkLogger.onLinkParseFail(i2, str, logContext);
                                EventUtil.sendParseAppLinkEvent(i3, str, "ttnet");
                                return;
                            } else {
                                EventUtil.sendParseAppLinkEvent(1, str, "ttnet");
                                UGZlinkLogger.onLinkParseSuccess(1, queryParameter, logContext);
                                UGZlinkLogger.onLinkInvokeEnd(0, queryParameter, logContext);
                                CallbackManager.callbackForAppLink(callBackForAppLink, queryParameter);
                                return;
                            }
                        }
                        queryParameter = "";
                        if (i == -1) {
                        }
                        if (!TextUtils.isEmpty(queryParameter)) {
                        }
                    }

                    @Override // com.bytedance.ug.sdk.deeplink.callback.CallBackForFetchScheme
                    public void onFailure(Throwable th) {
                        EventUtil.sendNetworkTimeConsumingEvent(str, -1, System.currentTimeMillis() - currentTimeMillis, requestTimeout, "ttnet");
                        UGZlinkLogger.onLinkParseFail(0, str, logContext);
                        EventUtil.sendParseAppLinkEvent(0, str, "ttnet");
                        AppLinkResolver.backupRequestForScheme(str, requestTimeout, logContext, callBackForAppLink);
                    }
                });
            }
        } catch (Throwable th) {
            Logger.m447e(TAG, "the network request occurs exception and the exception is : " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void backupRequestForScheme(final String str, final int i, final UGLogger.LogContext logContext, final CallBackForAppLink callBackForAppLink) {
        ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.resolver.AppLinkResolver.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3 = "";
                long currentTimeMillis = System.currentTimeMillis();
                int i2 = -1;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("accept", "*/*");
                    httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    str2 = httpURLConnection.getHeaderField("Location");
                    try {
                        i2 = httpURLConnection.getResponseCode();
                        httpURLConnection.disconnect();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    str2 = "";
                }
                EventUtil.sendNetworkTimeConsumingEvent(str, i2, System.currentTimeMillis() - currentTimeMillis, i, AppLinkResolver.HTTP_URL_CONNECTION);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        str3 = Uri.parse(str2).getQueryParameter("scheme");
                    } catch (Throwable unused3) {
                    }
                }
                int i3 = (i2 < 200 || i2 >= 400) ? 0 : 1;
                if (TextUtils.isEmpty(str3)) {
                    int i4 = i3 != 0 ? 3 : 0;
                    UGZlinkLogger.onLinkParseFail(i3, str, logContext);
                    EventUtil.sendParseAppLinkEvent(i4, str, AppLinkResolver.HTTP_URL_CONNECTION);
                } else {
                    EventUtil.sendParseAppLinkEvent(1, str, AppLinkResolver.HTTP_URL_CONNECTION);
                    UGZlinkLogger.onLinkParseSuccess(1, str3, logContext);
                    UGZlinkLogger.onLinkInvokeEnd(0, str3, logContext);
                    CallbackManager.callbackForAppLink(callBackForAppLink, str3);
                }
            }
        });
    }
}
