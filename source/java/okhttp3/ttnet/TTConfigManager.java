package okhttp3.ttnet;

import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class TTConfigManager {
    private static volatile TTConfigManager mInstance;
    private static AtomicBoolean sIgnoreSlashEnabled = new AtomicBoolean(false);
    private final AtomicInteger mPingProbeTimeOut = new AtomicInteger(10000);
    private final AtomicInteger mPingKeepAliveInterval = new AtomicInteger(60000);
    private final CopyOnWriteArrayList<String> mPingKeepAliveHosts = new CopyOnWriteArrayList<>();
    private final AtomicBoolean mAppResume = new AtomicBoolean(true);
    private final AtomicBoolean mEnableIpReconnectQuickTest = new AtomicBoolean(false);
    private final AtomicInteger mReconnectTimeoutMs = new AtomicInteger(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    private final AtomicInteger mTriplicateIpNumbers = new AtomicInteger(0);
    private final AtomicBoolean mRequestRetryForceHttpDns = new AtomicBoolean(false);
    private final CopyOnWriteArrayList<Integer> mRequestRetryForceHttpDnsErrList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<String> mRequestRetryForceHttpDnsHostList = new CopyOnWriteArrayList<>();
    private final RedirectRequestControlConfig mRedirectRequestControlConfig = new RedirectRequestControlConfig();
    private final List<String> mShareCookieHostList = new CopyOnWriteArrayList();
    private final AtomicBoolean mEnableTls1_1 = new AtomicBoolean(false);

    /* loaded from: classes8.dex */
    public static class RedirectRequestControlConfig {
        public final CopyOnWriteArrayList<String> mSecureHeaders = new CopyOnWriteArrayList<>();
        public final CopyOnWriteArrayList<String> mSecureRedirectWhiteList = new CopyOnWriteArrayList<>();
        public final AtomicBoolean mRmInsecureRedirectHeadersOutWhiteList = new AtomicBoolean(false);
        public final CopyOnWriteArrayList<String> mSecureRedirectBlackList = new CopyOnWriteArrayList<>();
        public final AtomicBoolean mDisableReportInsecureRedirect = new AtomicBoolean(false);
        public final AtomicBoolean mOnlyControlWebview = new AtomicBoolean(false);
        public final AtomicBoolean mReportFullUrl = new AtomicBoolean(false);
        public final AtomicBoolean mV2On = new AtomicBoolean(false);
        public final List<String> mKeepHeadersV2 = new ArrayList();
        public final List<String> mRmStdKeepHeadersV2 = new ArrayList();
    }

    public static TTConfigManager inst() {
        if (mInstance == null) {
            synchronized (TTConfigManager.class) {
                if (mInstance == null) {
                    mInstance = new TTConfigManager();
                }
            }
        }
        return mInstance;
    }

    public static void setIgnoreSlashEnabledV2(boolean z) {
        sIgnoreSlashEnabled.set(z);
    }

    public static boolean isIgnoreSlashEnabled() {
        return sIgnoreSlashEnabled.get();
    }

    public void onServerConfigChanged(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        parseRedirectRequestControlConfig(jSONObject);
        parseMiscConfig(jSONObject);
    }

    public void parseMiscConfig(JSONObject jSONObject) {
        int optInt;
        if (jSONObject != null && (optInt = jSONObject.optInt("ttok_enable_tls1.1", -1)) >= 0) {
            this.mEnableTls1_1.set(optInt == 1);
        }
    }

    public void parseRedirectRequestControlConfig(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("rect_request_control")) == null) {
            return;
        }
        parseJsonArray(optJSONObject, "scy_headers", this.mRedirectRequestControlConfig.mSecureHeaders);
        parseJsonArray(optJSONObject, "scy_rect_wl", this.mRedirectRequestControlConfig.mSecureRedirectWhiteList);
        int optInt = optJSONObject.optInt("rm_inscy_out_wl", -1);
        if (optInt >= 0) {
            this.mRedirectRequestControlConfig.mRmInsecureRedirectHeadersOutWhiteList.set(optInt == 1);
        }
        parseJsonArray(optJSONObject, "scy_rect_bl", this.mRedirectRequestControlConfig.mSecureRedirectBlackList);
        int optInt2 = optJSONObject.optInt("disable_report_inscy_rect", -1);
        if (optInt2 >= 0) {
            this.mRedirectRequestControlConfig.mDisableReportInsecureRedirect.set(optInt2 == 1);
        }
        int optInt3 = optJSONObject.optInt("only_control_webview", -1);
        if (optInt3 >= 0) {
            this.mRedirectRequestControlConfig.mOnlyControlWebview.set(optInt3 == 1);
        }
        int optInt4 = optJSONObject.optInt("enable_report_full_url", -1);
        if (optInt4 >= 0) {
            this.mRedirectRequestControlConfig.mReportFullUrl.set(optInt4 == 1);
        }
        int optInt5 = optJSONObject.optInt("v2_on", -1);
        if (optInt5 >= 0) {
            this.mRedirectRequestControlConfig.mV2On.set(optInt5 == 1);
        }
        parseJsonArray(optJSONObject, "keep_headers_v2", this.mRedirectRequestControlConfig.mKeepHeadersV2);
        parseJsonArray(optJSONObject, "rm_std_keep_headers_v2", this.mRedirectRequestControlConfig.mRmStdKeepHeadersV2);
        parseShareCookieHostList(jSONObject.optString("share_cookie_host_list"), this.mShareCookieHostList);
    }

    public static boolean inCookieHostList(String str) {
        return inCookieHostList(str, inst().mShareCookieHostList);
    }

    public static void parseShareCookieHostList(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null) {
            return;
        }
        for (String str2 : str.split(",")) {
            if (!TextUtils.isEmpty(str2) && !inCookieHostList(str2, list)) {
                list.add(str2.trim());
            }
        }
    }

    public static boolean inCookieHostList(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2) && str.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void parseJsonArray(JSONObject jSONObject, String str, List<String> list) {
        JSONArray optJSONArray;
        if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        list.clear();
        list.addAll(arrayList);
    }

    public int getPingKeepAliveInterval() {
        return this.mPingKeepAliveInterval.get();
    }

    public List<String> getPingKeepAliveHosts() {
        return this.mPingKeepAliveHosts;
    }

    public boolean getAppResume() {
        return this.mAppResume.get();
    }

    public void setAppResume(boolean z) {
        this.mAppResume.set(z);
    }

    public int getReconnctTimeout() {
        return this.mReconnectTimeoutMs.get();
    }

    public int getTriplicateIpNumbers() {
        return this.mTriplicateIpNumbers.get();
    }

    public boolean isIpReconnQuickTestEnable() {
        return this.mEnableIpReconnectQuickTest.get();
    }

    public boolean shouldRetryForceHttpdnsOnError(IOException iOException, Request request, int i) {
        if (iOException == null || request == null || request.url() == null || !this.mRequestRetryForceHttpDns.get() || !this.mRequestRetryForceHttpDnsErrList.contains(Integer.valueOf(i))) {
            return false;
        }
        String host = request.url().host();
        return !TextUtils.isEmpty(host) && this.mRequestRetryForceHttpDnsHostList.contains(host);
    }

    public RedirectRequestControlConfig getRedirectRequestControlConfig() {
        return this.mRedirectRequestControlConfig;
    }

    public boolean enableTls1_1() {
        return this.mEnableTls1_1.get();
    }
}
