package com.bytedance.ttnet.config;

import android.webkit.CookieManager;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.impl.CookieManagerWrap;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SyncMultiProcessConfig implements NetworkParams.CookieShareInterceptor, RequestEncryptUtils.IEncryptConfig, HttpClient.IHttpClientConfig, SsCronetHttpClient.ICronetHttpDnsConfig, SsCronetHttpClient.ICronetBootFailureChecker {
    private static final String TAG = "SyncMainProcessConfig";
    private static volatile SyncMultiProcessConfig mInstance;
    private int mAddSsQueriesHeaderOpen;
    private int mAddSsQueriesOpen;
    private int mAddSsQueriesPlaintextOpen;
    private int mChromiumBootFailures;
    private int mHttpDnsEnabled;
    private String mShareCookieHostList;

    public static SyncMultiProcessConfig inst() {
        if (mInstance == null) {
            synchronized (SyncMultiProcessConfig.class) {
                if (mInstance == null) {
                    mInstance = new SyncMultiProcessConfig();
                }
            }
        }
        return mInstance;
    }

    private SyncMultiProcessConfig() {
        SyncMainProcessConfig();
    }

    private boolean inCookieHostList(String str, List<String> list) {
        if (!StringUtils.isEmpty(str) && !Lists.isEmpty(list)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.endsWith(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void SyncMainProcessConfig() {
        try {
            TTNetInit.getTTNetDepend();
            Logger.w(TAG, "Sync main process config in current process.");
            this.mShareCookieHostList = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "share_cookie_host_list", "");
            TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(this.mShareCookieHostList);
            this.mAddSsQueriesOpen = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_open", 0);
            int providerInt = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_header_open", 0);
            this.mAddSsQueriesHeaderOpen = providerInt;
            if (this.mAddSsQueriesOpen > 0 || providerInt > 0) {
                SsInterceptor.EnableEncryptQuery(true);
            }
            this.mAddSsQueriesPlaintextOpen = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_plaintext_open", 1);
            this.mHttpDnsEnabled = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "http_dns_enabled", 0);
            this.mChromiumBootFailures = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0);
            int providerInt2 = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "query_filter_enabled", Integer.MIN_VALUE);
            String providerString = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "query_filter_actions", "");
            QueryFilterEngine.inst().parseL0ParamsString(TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "L0_params", ""));
            if (providerInt2 != Integer.MIN_VALUE) {
                QueryFilterEngine.inst().enableQueryFilterEngine(providerInt2 > 0);
                QueryFilterEngine.inst().onNetConfigChanged(providerString);
            }
            NetworkParams.setPrivateProtocolEnabled(TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "private_protocol_enabled", 1) >= 1);
            NetworkParams.setDisableRotationHostRetryByTnc(TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "disable_rotating_host_path_retry", -1) >= 1);
            NetworkParams.setEnablePPForceUseSharedStream(TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "pp_force_use_shared_stream", 0) >= 1);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> getShareCookie(CookieManager cookieManager, CookieManagerWrap cookieManagerWrap, URI uri) {
        String str;
        String[] split;
        if (uri == null) {
            return null;
        }
        if ((cookieManager == null && cookieManagerWrap == null) || StringUtils.isEmpty(TTNetInit.getTTNetDepend().getShareCookieMainDomain())) {
            return null;
        }
        try {
            str = uri.getHost();
        } catch (Exception unused) {
            str = null;
        }
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isEmpty(this.mShareCookieHostList)) {
            try {
                split = this.mShareCookieHostList.split(",");
            } catch (Throwable unused2) {
            }
            if (split != null) {
                for (String str2 : split) {
                    if (!StringUtils.isEmpty(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            if (StringUtils.isEmpty(str) && inCookieHostList(str, arrayList)) {
                List arrayList2 = new ArrayList();
                if (cookieManager != null) {
                    String cookie = cookieManager.getCookie(TTNetInit.getTTNetDepend().getShareCookieMainDomain());
                    if (!StringUtils.isEmpty(cookie)) {
                        arrayList2.add(cookie);
                    }
                }
                if (!Lists.isEmpty(arrayList2) || cookieManagerWrap == null) {
                    return arrayList2;
                }
                try {
                    Map map = cookieManagerWrap.get(URI.create(uri.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain()), new LinkedHashMap());
                    if (map == null || map.isEmpty()) {
                        return arrayList2;
                    }
                    List list = (List) map.get("Cookie");
                    if (list != null) {
                        try {
                            list.add("x-tt-cookie-backup-source=1");
                        } catch (Throwable th) {
                            th = th;
                            arrayList2 = list;
                            th.printStackTrace();
                            return arrayList2;
                        }
                    }
                    return list;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        split = null;
        if (split != null) {
        }
        return StringUtils.isEmpty(str) ? null : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> getShareCookieHostList(String str) {
        String[] split;
        String shareCookieMainDomain;
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isEmpty(this.mShareCookieHostList)) {
            try {
                split = this.mShareCookieHostList.split(",");
            } catch (Throwable unused) {
            }
            if (split != null) {
                for (String str2 : split) {
                    if (!StringUtils.isEmpty(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            shareCookieMainDomain = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
            if (!StringUtils.isEmpty(shareCookieMainDomain) && !inCookieHostList(shareCookieMainDomain, arrayList)) {
                arrayList.add(shareCookieMainDomain);
            }
            if (inCookieHostList(str, arrayList)) {
                return null;
            }
            return arrayList;
        }
        split = null;
        if (split != null) {
        }
        shareCookieMainDomain = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
        if (!StringUtils.isEmpty(shareCookieMainDomain)) {
            arrayList.add(shareCookieMainDomain);
        }
        if (inCookieHostList(str, arrayList)) {
        }
    }

    public boolean isSsQueriesOpen() {
        return this.mAddSsQueriesOpen > 0;
    }

    public boolean isSsQueriesHeaderOpen() {
        return this.mAddSsQueriesHeaderOpen > 0;
    }

    public boolean isSsQueriesPlaintextOpen() {
        return this.mAddSsQueriesPlaintextOpen > 0;
    }

    public boolean isCronetHttpDnsOpen() {
        return !AppConfig.sForceNotUseCronet && this.mHttpDnsEnabled > 0;
    }

    @Override // com.bytedance.ttnet.HttpClient.IHttpClientConfig
    public boolean isChromiumOpen() {
        if (AppConfig.sForceNotUseCronet) {
            SsOkHttp3Client.setFallbackReason(0);
            return false;
        }
        if (AppConfig.sCronetUnsupportedModel) {
            SsOkHttp3Client.setFallbackReason(8);
            return false;
        }
        if (AppConfig.isCronetUnsupportedABI()) {
            return false;
        }
        if (!AppConfig.sDisableFallbackReasonBoot && this.mChromiumBootFailures > 5) {
            SsOkHttp3Client.setFallbackReason(3);
            Logger.e(TAG, "After five consecutive crashes of cronet on subprocess, you must reinstall app to enable cronet, or wait until several hours");
            return false;
        }
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled()) {
            return true;
        }
        SsOkHttp3Client.setFallbackReason(6);
        return false;
    }

    public boolean isCronetBootFailureExpected() {
        return AppConfig.sDisableFallbackReasonBoot || TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0) <= 5;
    }
}
