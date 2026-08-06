package com.bytedance.ttnet.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.config.InsecureRequestControlConfig;
import com.bytedance.frameworks.baselib.network.config.TTCookieConfig;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.MiscConfigManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch.TTMetaDispatchManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.redirectdispatch.TTRedirectDispatchManager;
import com.bytedance.frameworks.baselib.network.http.parser.RequestTimeoutParser;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterStateListener;
import com.bytedance.frameworks.baselib.network.requestaudit.TTRequestAuditManager;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.ttnet.TNCRequestFlagHandler;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.config.ExperimentalSwitches;
import com.bytedance.ttnet.config.JsonOptConfig;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TNCConfigHandler {
    private static final String TAG = "TNCConfigHandler";
    private Context mContext;
    private boolean mIsMainProcess;
    private String mStoreRegion = "";
    private String mStoreIdc = "";
    private String mStoreRegionSrc = "";
    private String mTncAbTest = "";
    private TNCConfig mTNCConfig = new TNCConfig();

    public TNCConfigHandler(Context context, boolean z) {
        this.mContext = context;
        this.mIsMainProcess = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleConfigChanged(Object obj, TNCManager.TNCUpdateSource tNCUpdateSource, String str, String str2, long j) {
        String str3;
        String str4;
        boolean z;
        String jsonStr;
        boolean z2;
        if (Logger.debug()) {
            Logger.d(TAG, "handleConfigChanged");
        }
        if (!this.mIsMainProcess) {
            if (Logger.debug()) {
                Logger.d(TAG, "handleConfigChanged: no mainProc");
            }
            return false;
        }
        JSONObject tncJSONObject = JsonOptConfig.tncJSONObject(obj);
        URLDispatcher.inst().onServerConfigChanged(tncJSONObject, tNCUpdateSource.mValue, str, this.mTncAbTest, j);
        notifyTncConfigChanged(tncJSONObject);
        try {
            TNCConfig parseConfigFromJson = parseConfigFromJson(tncJSONObject);
            if (Logger.debug()) {
                Logger.d(TAG, "handleConfigChanged, newConfig: " + (parseConfigFromJson == null ? "null" : parseConfigFromJson.toString()));
            }
            if (parseConfigFromJson == null) {
                SharedPreferences.Editor edit = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
                edit.putBoolean("is_full_config", false);
                edit.putString(TNCManager.TNC_CONFIG_STR, "").apply();
                MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(false));
                MultiProcessFileUtils.saveData(this.mContext, 4, "");
                if (!TextUtils.isEmpty(str)) {
                    edit.putString(TNCManager.TNC_ETAG_NAME, str).apply();
                    MultiProcessFileUtils.saveData(this.mContext, 5, str);
                }
                if (TextUtils.isEmpty(this.mTncAbTest)) {
                    this.mTncAbTest = "";
                }
                edit.putString(TNCManager.TNC_ABTEST_NAME, this.mTncAbTest).apply();
                MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
                return false;
            }
            str3 = str;
            str4 = TNCManager.TNC_ABTEST_NAME;
            try {
                this.mTNCConfig = parseConfigFromJson;
                if (obj instanceof JsonOptConfig.JsonWrapper) {
                    try {
                        jsonStr = ((JsonOptConfig.JsonWrapper) obj).jsonStr();
                        z2 = true;
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        try {
                            th.printStackTrace();
                            this.mTNCConfig = new TNCConfig();
                            SharedPreferences.Editor edit2 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
                            edit2.putBoolean("is_full_config", z);
                            edit2.putString(TNCManager.TNC_CONFIG_STR, "").apply();
                            MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(z));
                            MultiProcessFileUtils.saveData(this.mContext, 4, "");
                            if (!TextUtils.isEmpty(str)) {
                            }
                            if (TextUtils.isEmpty(this.mTncAbTest)) {
                            }
                            edit2.putString(str4, this.mTncAbTest).apply();
                            MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
                            return false;
                        } catch (Throwable th2) {
                            SharedPreferences.Editor edit3 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
                            edit3.putBoolean("is_full_config", z);
                            edit3.putString(TNCManager.TNC_CONFIG_STR, "").apply();
                            MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(z));
                            MultiProcessFileUtils.saveData(this.mContext, 4, "");
                            if (!TextUtils.isEmpty(str)) {
                                edit3.putString(TNCManager.TNC_ETAG_NAME, str3).apply();
                                MultiProcessFileUtils.saveData(this.mContext, 5, str3);
                            }
                            if (TextUtils.isEmpty(this.mTncAbTest)) {
                                this.mTncAbTest = "";
                            }
                            edit3.putString(str4, this.mTncAbTest).apply();
                            MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
                            throw th2;
                        }
                    }
                } else {
                    jsonStr = tncJSONObject.toString();
                    z2 = false;
                }
                SharedPreferences.Editor edit4 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
                edit4.putBoolean("is_full_config", z2);
                edit4.putString(TNCManager.TNC_CONFIG_STR, jsonStr).apply();
                MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(z2));
                MultiProcessFileUtils.saveData(this.mContext, 4, jsonStr);
                if (!TextUtils.isEmpty(str)) {
                    edit4.putString(TNCManager.TNC_ETAG_NAME, str3).apply();
                    MultiProcessFileUtils.saveData(this.mContext, 5, str3);
                }
                if (TextUtils.isEmpty(this.mTncAbTest)) {
                    this.mTncAbTest = "";
                }
                edit4.putString(str4, this.mTncAbTest).apply();
                MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
                return true;
            } catch (Throwable th3) {
                th = th3;
                z = false;
                th.printStackTrace();
                this.mTNCConfig = new TNCConfig();
                SharedPreferences.Editor edit22 = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit();
                edit22.putBoolean("is_full_config", z);
                edit22.putString(TNCManager.TNC_CONFIG_STR, "").apply();
                MultiProcessFileUtils.saveData(this.mContext, 7, MultiProcessFileUtils.bool2Str(z));
                MultiProcessFileUtils.saveData(this.mContext, 4, "");
                if (!TextUtils.isEmpty(str)) {
                    edit22.putString(TNCManager.TNC_ETAG_NAME, str3).apply();
                    MultiProcessFileUtils.saveData(this.mContext, 5, str3);
                }
                if (TextUtils.isEmpty(this.mTncAbTest)) {
                    this.mTncAbTest = "";
                }
                edit22.putString(str4, this.mTncAbTest).apply();
                MultiProcessFileUtils.saveData(this.mContext, 6, this.mTncAbTest);
                return false;
            }
        } catch (Throwable th4) {
            th = th4;
            str3 = str;
            str4 = TNCManager.TNC_ABTEST_NAME;
        }
    }

    private String loadGetDomainDefaultJson() {
        if (TextUtils.isEmpty(TNCManager.getGetDomainDefaultJson())) {
            Logger.d(TAG, "getGetDomainDefaultJson no existed");
            return null;
        }
        try {
            String string = new JSONObject(TNCManager.getGetDomainDefaultJson()).getString("data");
            if (Logger.debug()) {
                Logger.d(TAG, "use get domain default json.");
            }
            return string;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void loadLocalConfig(long j) {
        JSONObject optJSONObject;
        if (Logger.debug()) {
            Logger.d(TAG, "load local config");
        }
        if (this.mIsMainProcess) {
            boolean z = false;
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0);
            boolean z2 = sharedPreferences.getBoolean("is_full_config", false);
            String string = sharedPreferences.getString(TNCManager.TNC_CONFIG_STR, null);
            String string2 = sharedPreferences.getString(TNCManager.TNC_ETAG_NAME, null);
            String string3 = sharedPreferences.getString(TNCManager.TNC_ABTEST_NAME, null);
            if (TextUtils.isEmpty(string)) {
                string = loadGetDomainDefaultJson();
                if (TextUtils.isEmpty(string)) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "load local config failed.");
                        return;
                    }
                    return;
                }
            } else {
                z = z2;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (z && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    jSONObject = optJSONObject;
                }
                URLDispatcher.inst().onServerConfigChanged(jSONObject, TNCManager.TNCUpdateSource.TTCACHE.mValue, string2, string3, j);
                notifyTncConfigChanged(jSONObject);
                TNCConfig parseConfigFromJson = parseConfigFromJson(jSONObject);
                if (parseConfigFromJson != null) {
                    this.mTNCConfig = parseConfigFromJson;
                }
                if (Logger.debug()) {
                    Logger.d(TAG, "loadLocalConfig: " + (parseConfigFromJson == null ? "null" : parseConfigFromJson.toString()));
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (Logger.debug()) {
                    Logger.d(TAG, "loadLocalConfig: except: " + th.getMessage());
                }
            }
        }
    }

    public void loadLocalConfigForOtherProcess(long j) {
        JSONObject optJSONObject;
        try {
            boolean str2Bool = MultiProcessFileUtils.str2Bool(MultiProcessFileUtils.getData(this.mContext, 7));
            String data = MultiProcessFileUtils.getData(this.mContext, 4);
            if (TextUtils.isEmpty(data)) {
                data = loadGetDomainDefaultJson();
                if (TextUtils.isEmpty(data)) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "load local config failed.");
                        return;
                    }
                    return;
                }
                str2Bool = false;
            }
            JSONObject jSONObject = new JSONObject(data);
            if (str2Bool && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                jSONObject = optJSONObject;
            }
            JSONObject jSONObject2 = jSONObject;
            TNCConfig parseConfigFromJson = parseConfigFromJson(jSONObject2);
            URLDispatcher.inst().onServerConfigChanged(jSONObject2, TNCManager.TNCUpdateSource.TTCACHE.mValue, MultiProcessFileUtils.getData(this.mContext, 5), MultiProcessFileUtils.getData(this.mContext, 6), j);
            notifyTncConfigChanged(jSONObject2);
            if (Logger.debug()) {
                Logger.d(TAG, "loadLocalConfigForOtherProcess, config: " + (parseConfigFromJson == null ? "null" : parseConfigFromJson.toString()));
            }
            if (parseConfigFromJson != null) {
                this.mTNCConfig = parseConfigFromJson;
            }
        } catch (Throwable th) {
            if (Logger.debug()) {
                Logger.d(TAG, "loadLocalConfigForOtherProcess, except: " + th.getMessage());
            }
        }
    }

    public TNCConfig getTNCConfig() {
        return this.mTNCConfig;
    }

    private TNCConfig parseConfigFromJson(JSONObject jSONObject) {
        try {
            URLDispatcher.inst().getHostReplaceMap().clear();
            JSONObject optJSONObject = jSONObject.optJSONObject(MultiProcessFileUtils.KEY_TNC_CONFIG);
            TNCConfig tNCConfig = new TNCConfig();
            if (optJSONObject == null) {
                return tNCConfig;
            }
            if (optJSONObject.has("local_enable")) {
                tNCConfig.localEnable = optJSONObject.getInt("local_enable") != 0;
            }
            if (optJSONObject.has("probe_enable")) {
                tNCConfig.probeEnable = optJSONObject.getInt("probe_enable") != 0;
            }
            if (optJSONObject.has("local_host_filter")) {
                JSONArray jSONArray = optJSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                tNCConfig.localHostFilterList = hashMap;
            } else {
                tNCConfig.localHostFilterList = null;
            }
            if (optJSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = optJSONObject.getJSONObject("host_replace_map");
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            URLDispatcher.inst().getHostReplaceMap().put(next, string2);
                        }
                    }
                }
            }
            tNCConfig.reqToCnt = optJSONObject.optInt("req_to_cnt", tNCConfig.reqToCnt);
            tNCConfig.reqToApiCnt = optJSONObject.optInt("req_to_api_cnt", tNCConfig.reqToApiCnt);
            tNCConfig.reqToIpCnt = optJSONObject.optInt("req_to_ip_cnt", tNCConfig.reqToIpCnt);
            tNCConfig.reqErrCnt = optJSONObject.optInt("req_err_cnt", tNCConfig.reqErrCnt);
            tNCConfig.reqErrApiCnt = optJSONObject.optInt("req_err_api_cnt", tNCConfig.reqErrApiCnt);
            tNCConfig.reqErrIpCnt = optJSONObject.optInt("req_err_ip_cnt", tNCConfig.reqErrIpCnt);
            tNCConfig.updateInterval = optJSONObject.optInt("update_interval", tNCConfig.updateInterval);
            tNCConfig.updateRandomRange = optJSONObject.optInt("update_random_range", tNCConfig.updateRandomRange);
            tNCConfig.httpCodeBlack = optJSONObject.optString("http_code_black", tNCConfig.httpCodeBlack);
            return tNCConfig;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void notifyTncConfigChanged(JSONObject jSONObject) {
        if (!AppConfig.getInstance(this.mContext).isChromiumOpen()) {
            HttpDns.getService().onServerConfigChanged(jSONObject);
            TTConfigManager.inst().onServerConfigChanged(jSONObject);
        }
        ExperimentalSwitches.onServerConfigChanged(jSONObject);
        TTHttpCallThrottleControl.getInstance().onServerConfigChangedFromTNCHandler(jSONObject);
        TTHttpCallPriorityControl.getInstance().onServerConfigChangedFromTNCHandler(jSONObject);
        TNCRequestFlagHandler.getInstance().parseJson2Config(jSONObject);
        RequestTimeoutParser.onServerConfigChanged(jSONObject);
        TTDelayStateManager.onServerConfigChanged(jSONObject);
        QueryFilterStateListener.getInstance().onServerConfigChanged(jSONObject);
        TTRequestCompressManager.onServerConfigChanged(jSONObject);
        BoeUtils.onServerConfigChanged(jSONObject);
        InsecureRequestControlConfig.onServerConfigChanged(jSONObject);
        TTCookieConfig.onServerConfigChanged(jSONObject);
        TTMetaDispatchManager.onServerConfigChanged(jSONObject);
        TTRedirectDispatchManager.onServerConfigChanged(jSONObject);
        MiscConfigManager.inst().onServerConfigChanged(jSONObject);
        TTRequestAuditManager.onServerConfigChanged(jSONObject);
    }

    public void setTncAbTest(String str) {
        this.mTncAbTest = str;
        URLDispatcher.inst().setTncAbTest(str);
    }

    public String getRegion() {
        return this.mStoreRegion;
    }

    public String getRegionSrc() {
        return this.mStoreRegionSrc;
    }
}
