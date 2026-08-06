package com.bytedance.frameworks.baselib.network.http.storeregion;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import coil3.disk.DiskLruCache;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class StoreRegionManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String APP_INIT_REGION_HEADER = "x-tt-app-init-region";
    public static final String LOG_ID_HEADER = "x-tt-logid";
    private static final String RECEIVED_REGION_CONFIG = "received_region_config";
    private static final String REGION_LEGACY_USER = "region_legacy_user";
    public static final String REGION_LEGACY_USER_COOKIE = "region_legacy_user=";
    private static final String REGION_SOURCE_LOCAL = "local";
    public static final String SET_COOKIE = "Set-Cookie";
    public static final String STORE_COUNTRY_CODE_COOKIE = "store-country-code=";
    public static final String STORE_COUNTRY_CODE_SOURCE_COOKIE = "store-country-code-src=";
    private static final String STORE_REGION = "store_region";
    public static final String STORE_REGION_COOKIE = "store-region=";
    private static final String STORE_REGION_DOMAIN = "add_store_idc_host_list";
    public static final String STORE_REGION_HEADER = "x-tt-store-region";
    private static final String STORE_REGION_PATH = "update_store_idc_path_list";
    public static final String STORE_REGION_SOURCE_COOKIE = "store-region-src=";
    private static final String STORE_REGION_SP_NAME = "ttnet_store_region";
    private static final String STORE_REGION_SRC = "store_region_src";
    public static final String STORE_REGION_SRC_HEADER = "x-tt-store-region-src";
    private static final String STORE_SEC_UID = "store_sec_uid";
    public static final String STORE_SEC_UID_HEADER = "x-tt-store-sec-uid";
    private static final String TAG = "StoreRegionManager";
    public static final String TNC_ATTR_HEADER = "x-tt-tnc-attr";
    public static final String TNC_CONFIG_HEADER = "x-tt-tnc-config";
    public static final String TNC_ETAG_HEADER = "x-ss-etag";
    private static final String UPDATE_REGION_INFO = "update_region_info";
    public static final String WITH_TNC_CONFIG_HEADER = "x-tt-with-tnc";
    private static boolean mUseDomesticStoreRegion;
    private static volatile StoreRegionManager sInstance;
    private Context mContext;
    private boolean mReceivedTNCRegionConfig;
    private StoreRegionBridge mStoreRegionBridge;
    private boolean mStoreRegionRuleEnabled;
    private String mStoreRegion = "";
    private String mStoreRegionSrc = "";
    private String mRegionLegacyUser = "";
    private String mStoreSecUid = "";
    private String mStoreRegionLocal = "";
    private String mUpdateRegionInfo = "";
    private String mInitRegion = "";
    private List<String> mStoreRegionPathList = new ArrayList();
    private List<String> mStoreRegionHostList = new ArrayList();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface StoreRegionCallback {
        void notifyStoreRegionUpdatedForCronet(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);
    }

    public static String getStoreRegionSpName() {
        return STORE_REGION_SP_NAME;
    }

    public static StoreRegionManager inst() {
        if (sInstance == null) {
            synchronized (StoreRegionManager.class) {
                if (sInstance == null) {
                    sInstance = new StoreRegionManager();
                }
            }
        }
        return sInstance;
    }

    private StoreRegionManager() {
    }

    public void setReceivedTNCRegionConfig() {
        if (this.mReceivedTNCRegionConfig) {
            return;
        }
        this.mReceivedTNCRegionConfig = true;
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0).edit();
        edit.putBoolean(RECEIVED_REGION_CONFIG, true);
        edit.apply();
    }

    public boolean isStoreRegionRuleEnabled() {
        return this.mStoreRegionRuleEnabled;
    }

    public String getStoreRegion() {
        return this.mStoreRegion;
    }

    public String getStoreRegionSrc() {
        return this.mStoreRegionSrc;
    }

    public String getRegionLegacyUser() {
        return this.mRegionLegacyUser;
    }

    public void initStoreRegionRuleConfig(String str, String str2, String str3, Context context, StoreRegionBridge storeRegionBridge) {
        if (Logger.debug()) {
            Logger.d(TAG, "rule json: " + str2);
        }
        if (TextUtils.isEmpty(str2) || context == null || storeRegionBridge == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONArray optJSONArray = jSONObject.optJSONArray(STORE_REGION_PATH);
            for (int i = 0; i < optJSONArray.length(); i++) {
                String string = optJSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    this.mStoreRegionPathList.add(string);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(STORE_REGION_DOMAIN);
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                String string2 = optJSONArray2.getString(i2);
                if (!TextUtils.isEmpty(string2)) {
                    this.mStoreRegionHostList.add(string2);
                }
            }
            this.mContext = context;
            this.mStoreRegionBridge = storeRegionBridge;
            if (!TextUtils.isEmpty(str)) {
                this.mStoreRegionLocal = str.toLowerCase();
            }
            if (this.mStoreRegionHostList.isEmpty() || this.mStoreRegionPathList.isEmpty()) {
                return;
            }
            this.mStoreRegionRuleEnabled = true;
            this.mInitRegion = str3;
            loadLocalConfig();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadLocalConfig() {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0);
        this.mStoreRegion = sharedPreferences.getString(STORE_REGION, "");
        this.mStoreRegionSrc = sharedPreferences.getString(STORE_REGION_SRC, "");
        this.mRegionLegacyUser = sharedPreferences.getString(REGION_LEGACY_USER, "");
        this.mStoreSecUid = sharedPreferences.getString(STORE_SEC_UID, "");
        this.mUpdateRegionInfo = sharedPreferences.getString(UPDATE_REGION_INFO, "");
        this.mReceivedTNCRegionConfig = sharedPreferences.getBoolean(RECEIVED_REGION_CONFIG, false);
        if (TextUtils.isEmpty(this.mStoreRegion) && !TextUtils.isEmpty(this.mStoreRegionLocal)) {
            this.mStoreRegion = this.mStoreRegionLocal;
            this.mStoreRegionSrc = REGION_SOURCE_LOCAL;
        }
        this.mStoreRegionBridge.onStoreIdcChanged("", this.mStoreRegion, this.mStoreRegionSrc, this.mRegionLegacyUser, this.mStoreSecUid, "");
        if (Logger.debug()) {
            Logger.d(TAG, "Init region:" + this.mStoreRegion + " sec_uid:" + this.mStoreSecUid + " source:" + this.mStoreRegionSrc + " local:" + this.mStoreRegionLocal + " init region:" + this.mInitRegion + " region config:" + this.mReceivedTNCRegionConfig);
        }
    }

    private boolean addExtraParamsForDidAndUidPath(Request request, Request.Builder builder) {
        boolean z;
        if (TextUtils.isEmpty(request.getPath())) {
            return false;
        }
        if ("/get_domains/v5/".equals(request.getPath())) {
            return true;
        }
        Iterator<String> it = this.mStoreRegionPathList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (UrlUtils.matchPattern(request.getPath(), it.next())) {
                z = true;
                break;
            }
        }
        if (!z) {
            return false;
        }
        UrlBuilder urlBuilder = new UrlBuilder(request.getUrl());
        urlBuilder.addParam("okhttp_version", "4.2.243.6-doubao");
        urlBuilder.addParam("use_store_region_cookie", DiskLruCache.VERSION);
        builder.url(urlBuilder.build());
        return true;
    }

    public Request addStoreRegionHeaderForOkHttp(Request request) {
        boolean z;
        boolean z2;
        String str;
        if (!this.mStoreRegionRuleEnabled || TextUtils.isEmpty(request.getHost()) || request.isPureRequest()) {
            return null;
        }
        Iterator<String> it = this.mStoreRegionHostList.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (UrlUtils.matchPattern(request.getHost(), it.next())) {
                z2 = true;
                break;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.mReceivedTNCRegionConfig || TextUtils.isEmpty(this.mInitRegion)) {
            z = z2;
        } else {
            arrayList.add(new Header(APP_INIT_REGION_HEADER, this.mInitRegion));
        }
        if (!z) {
            return null;
        }
        if (request.getHeaders() != null) {
            arrayList.addAll(request.getHeaders());
        }
        Request.Builder newBuilder = request.newBuilder();
        if (addExtraParamsForDidAndUidPath(request, newBuilder)) {
            newBuilder.headers(arrayList);
            return newBuilder.build();
        }
        if (!this.mStoreRegion.isEmpty()) {
            str = this.mStoreRegion;
        } else {
            str = !this.mStoreRegionLocal.isEmpty() ? this.mStoreRegionLocal : "";
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new Header(STORE_REGION_HEADER, str));
        }
        if (!TextUtils.isEmpty(this.mStoreRegionSrc)) {
            arrayList.add(new Header(STORE_REGION_SRC_HEADER, this.mStoreRegionSrc));
        }
        newBuilder.headers(arrayList);
        return newBuilder.build();
    }

    public void addStoreIdcHeaderForGetDomain(Map<String, String> map) {
        if (!this.mStoreRegionRuleEnabled || map == null || this.mReceivedTNCRegionConfig || TextUtils.isEmpty(this.mInitRegion)) {
            return;
        }
        map.put(APP_INIT_REGION_HEADER, this.mInitRegion);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateStoreRegionForOkHttp(Response response, String str, byte[] bArr) {
        JSONObject jSONObject;
        boolean z;
        if (!this.mStoreRegionRuleEnabled) {
            return;
        }
        try {
            URI safeCreateUri = UrlUtils.safeCreateUri(str);
            String str2 = safeCreateUri.getHost() + safeCreateUri.getPath();
            if (safeCreateUri == null || TextUtils.isEmpty(safeCreateUri.getPath()) || !canUpdateStoreRegionFromPath(safeCreateUri.getPath())) {
                return;
            }
            CookieRegionInfo extractStoreRegionFromCookieHeaders = extractStoreRegionFromCookieHeaders(response.headers("Set-Cookie"));
            String header = response.header(TNC_ETAG_HEADER);
            String header2 = response.header(TNC_ATTR_HEADER);
            String header3 = response.header(WITH_TNC_CONFIG_HEADER);
            if (!TextUtils.isEmpty(header3) && header3.equals(DiskLruCache.VERSION)) {
                try {
                    jSONObject = new JSONObject(new String(bArr)).getJSONObject("tnc_data");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (extractStoreRegionFromCookieHeaders != null && jSONObject != null) {
                    this.mStoreRegionBridge.updateTncConfig(jSONObject, header, header2, false);
                    return;
                }
                if (extractStoreRegionFromCookieHeaders != null) {
                    return;
                }
                if (Logger.debug()) {
                    Logger.d(TAG, "origin region:" + this.mStoreRegion + " sec_uid:" + this.mStoreSecUid + " source:" + this.mStoreRegionSrc + " local:" + this.mStoreRegionLocal);
                }
                boolean z2 = !this.mStoreRegion.equals(extractStoreRegionFromCookieHeaders.storeRegion);
                String header4 = response.header(STORE_SEC_UID_HEADER);
                if (header4 == null) {
                    header4 = "";
                }
                SharedPreferences.Editor edit = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0).edit();
                if (this.mStoreRegion.equals(extractStoreRegionFromCookieHeaders.storeRegion) && this.mStoreRegionSrc.equals(extractStoreRegionFromCookieHeaders.storeRegionSrc) && header4.equals(this.mStoreSecUid)) {
                    z = false;
                } else {
                    this.mStoreRegion = extractStoreRegionFromCookieHeaders.storeRegion;
                    this.mStoreRegionSrc = extractStoreRegionFromCookieHeaders.storeRegionSrc;
                    this.mStoreSecUid = header4;
                    edit.putString(STORE_REGION, this.mStoreRegion);
                    edit.putString(STORE_REGION_SRC, this.mStoreRegionSrc);
                    edit.putString(STORE_SEC_UID, this.mStoreSecUid);
                    z = true;
                }
                if (!this.mRegionLegacyUser.equals(extractStoreRegionFromCookieHeaders.regionLegacyUser)) {
                    String str3 = extractStoreRegionFromCookieHeaders.regionLegacyUser;
                    this.mRegionLegacyUser = str3;
                    edit.putString(REGION_LEGACY_USER, str3);
                    z = true;
                }
                if (Logger.debug()) {
                    Logger.d(TAG, "update region:" + this.mStoreRegion + " sec_uid:" + this.mStoreSecUid + " source:" + this.mStoreRegionSrc + " regionLegacyUser:" + this.mRegionLegacyUser + "local:" + this.mStoreRegionLocal);
                    Logger.d(TAG, "save config:" + z + " update tnc:" + z2);
                }
                boolean updateTncConfig = this.mStoreRegionBridge.updateTncConfig(jSONObject, header, header2, z2);
                if (z) {
                    String header5 = response.header("x-tt-logid");
                    String str4 = safeCreateUri.getPath() + "," + header5 + "," + extractStoreRegionFromCookieHeaders.storeRegion + "," + extractStoreRegionFromCookieHeaders.storeRegionSrc;
                    this.mUpdateRegionInfo = str4;
                    edit.putString(UPDATE_REGION_INFO, str4);
                    edit.apply();
                    this.mStoreRegionBridge.sendFeedbackLog(getStoreRegionChangeLog(header5, str2, updateTncConfig), "store_idc");
                    this.mStoreRegionBridge.onStoreIdcChanged("", this.mStoreRegion, this.mStoreRegionSrc, this.mRegionLegacyUser, this.mStoreSecUid, header5);
                    return;
                }
                return;
            }
            jSONObject = null;
            if (extractStoreRegionFromCookieHeaders != null) {
            }
            if (extractStoreRegionFromCookieHeaders != null) {
            }
        } catch (Exception unused) {
        }
    }

    public void saveStoreRegionForCronet(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.mContext == null || !this.mStoreRegionRuleEnabled || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        if (this.mStoreRegion.equalsIgnoreCase(str2) && this.mStoreRegionSrc.equalsIgnoreCase(str3) && this.mStoreSecUid.equalsIgnoreCase(str5)) {
            return;
        }
        this.mStoreSecUid = str5;
        this.mStoreRegion = str2;
        this.mStoreRegionSrc = str3;
        this.mRegionLegacyUser = str4;
        if (Logger.debug()) {
            Logger.d(TAG, "saveStoreRegionForCronet region:" + this.mStoreRegion + " source:" + this.mStoreRegionSrc + " sec uid:" + this.mStoreSecUid);
        }
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(STORE_REGION_SP_NAME, 0).edit();
        edit.putString(STORE_REGION, this.mStoreRegion);
        edit.putString(STORE_REGION_SRC, this.mStoreRegionSrc);
        edit.putString(STORE_SEC_UID, this.mStoreSecUid);
        edit.apply();
    }

    private String getStoreRegionChangeLog(String str, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(StreamTrafficObservable.STREAM_URL, str2);
            jSONObject2.put("logId", str);
            jSONObject.put("tnc", z);
            jSONObject.put("base", jSONObject2);
            jSONObject.put("report_time", System.currentTimeMillis());
            jSONObject.put(STORE_REGION, this.mStoreRegion);
            jSONObject.put("source", this.mStoreRegionSrc);
            jSONObject.put(REGION_LEGACY_USER, this.mRegionLegacyUser);
            jSONObject.put(REGION_SOURCE_LOCAL, this.mStoreRegionLocal);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private boolean canUpdateStoreRegionFromPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = this.mStoreRegionPathList.iterator();
        while (it.hasNext()) {
            if (UrlUtils.matchPattern(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public class CookieRegionInfo {
        String regionLegacyUser;
        String storeRegion;
        String storeRegionSrc;

        CookieRegionInfo(String str, String str2, String str3) {
            this.storeRegion = str;
            this.storeRegionSrc = str2;
            this.regionLegacyUser = str3;
        }
    }

    private String extractValueFromSetCookieLine(String str) {
        String[] split;
        String[] split2;
        return (TextUtils.isEmpty(str) || (split = str.split(";")) == null || split.length <= 0 || (split2 = split[0].trim().split("=")) == null || split2.length != 2) ? "" : split2[1];
    }

    private CookieRegionInfo extractStoreRegionFromCookieHeaders(List<String> list) {
        String str;
        String str2;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (mUseDomesticStoreRegion) {
            str = STORE_REGION_COOKIE;
            str2 = STORE_REGION_SOURCE_COOKIE;
        } else {
            str = STORE_COUNTRY_CODE_COOKIE;
            str2 = STORE_COUNTRY_CODE_SOURCE_COOKIE;
        }
        String str3 = "";
        String str4 = "";
        String str5 = str4;
        for (String str6 : list) {
            if (str6.toLowerCase().startsWith(str)) {
                str3 = str6;
            } else if (str6.toLowerCase().startsWith(str2)) {
                str4 = str6;
            } else if (str6.toLowerCase().startsWith(REGION_LEGACY_USER_COOKIE)) {
                str5 = str6;
            }
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String extractValueFromSetCookieLine = extractValueFromSetCookieLine(str3);
        if (extractValueFromSetCookieLine.isEmpty()) {
            return null;
        }
        return new CookieRegionInfo(extractValueFromSetCookieLine, extractValueFromSetCookieLine(str4), extractValueFromSetCookieLine(str5));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:9|(1:38)|13|(4:17|18|19|(6:(1:25)|26|27|28|29|30)(1:23))|37|(1:21)|(0)|26|27|28|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0112, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0113, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateStoreRegionForCronet(HttpURLConnection httpURLConnection, byte[] bArr, StoreRegionCallback storeRegionCallback) {
        String str;
        if (httpURLConnection != null && this.mStoreRegionRuleEnabled && canUpdateStoreRegionFromPath(httpURLConnection.getURL().getPath())) {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            List<String> list = headerFields.get("Set-Cookie");
            if (list == null || list.isEmpty()) {
                list = headerFields.get("Set-Cookie".toLowerCase());
            }
            CookieRegionInfo extractStoreRegionFromCookieHeaders = extractStoreRegionFromCookieHeaders(list);
            String headerValueIgnoreCase = getHeaderValueIgnoreCase(headerFields, WITH_TNC_CONFIG_HEADER);
            String str2 = "";
            if (!TextUtils.isEmpty(headerValueIgnoreCase) && headerValueIgnoreCase.equals(DiskLruCache.VERSION)) {
                try {
                    str = "{\"data\": " + new JSONObject(new String(bArr)).getString("tnc_data") + "}";
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (extractStoreRegionFromCookieHeaders == null || !TextUtils.isEmpty(str)) {
                    if (extractStoreRegionFromCookieHeaders == null) {
                        extractStoreRegionFromCookieHeaders = new CookieRegionInfo("", "", "");
                    }
                    String headerValueIgnoreCase2 = getHeaderValueIgnoreCase(headerFields, STORE_SEC_UID_HEADER);
                    String headerValueIgnoreCase3 = getHeaderValueIgnoreCase(headerFields, "x-tt-logid");
                    String headerValueIgnoreCase4 = getHeaderValueIgnoreCase(headerFields, TNC_ATTR_HEADER);
                    String headerValueIgnoreCase5 = getHeaderValueIgnoreCase(headerFields, TNC_ETAG_HEADER);
                    String headerValueIgnoreCase6 = getHeaderValueIgnoreCase(headerFields, TNC_CONFIG_HEADER);
                    JSONObject jSONObject = new JSONObject();
                    str2 = httpURLConnection.getURL().getPath();
                    jSONObject.put(StreamTrafficObservable.STREAM_URL, httpURLConnection.getURL().getHost() + str2);
                    jSONObject.put(STORE_REGION, extractStoreRegionFromCookieHeaders.storeRegion + "," + extractStoreRegionFromCookieHeaders.storeRegionSrc);
                    jSONObject.put(REGION_LEGACY_USER, extractStoreRegionFromCookieHeaders.regionLegacyUser);
                    jSONObject.put("logId", headerValueIgnoreCase3);
                    storeRegionCallback.notifyStoreRegionUpdatedForCronet(str2, extractStoreRegionFromCookieHeaders.storeRegion, extractStoreRegionFromCookieHeaders.storeRegionSrc, extractStoreRegionFromCookieHeaders.regionLegacyUser, headerValueIgnoreCase4, headerValueIgnoreCase5, headerValueIgnoreCase6, str, jSONObject.toString(), headerValueIgnoreCase2, headerValueIgnoreCase3);
                }
                return;
            }
            str = "";
            if (extractStoreRegionFromCookieHeaders == null) {
            }
            if (extractStoreRegionFromCookieHeaders == null) {
            }
            String headerValueIgnoreCase22 = getHeaderValueIgnoreCase(headerFields, STORE_SEC_UID_HEADER);
            String headerValueIgnoreCase32 = getHeaderValueIgnoreCase(headerFields, "x-tt-logid");
            String headerValueIgnoreCase42 = getHeaderValueIgnoreCase(headerFields, TNC_ATTR_HEADER);
            String headerValueIgnoreCase52 = getHeaderValueIgnoreCase(headerFields, TNC_ETAG_HEADER);
            String headerValueIgnoreCase62 = getHeaderValueIgnoreCase(headerFields, TNC_CONFIG_HEADER);
            JSONObject jSONObject2 = new JSONObject();
            str2 = httpURLConnection.getURL().getPath();
            jSONObject2.put(StreamTrafficObservable.STREAM_URL, httpURLConnection.getURL().getHost() + str2);
            jSONObject2.put(STORE_REGION, extractStoreRegionFromCookieHeaders.storeRegion + "," + extractStoreRegionFromCookieHeaders.storeRegionSrc);
            jSONObject2.put(REGION_LEGACY_USER, extractStoreRegionFromCookieHeaders.regionLegacyUser);
            jSONObject2.put("logId", headerValueIgnoreCase32);
            storeRegionCallback.notifyStoreRegionUpdatedForCronet(str2, extractStoreRegionFromCookieHeaders.storeRegion, extractStoreRegionFromCookieHeaders.storeRegionSrc, extractStoreRegionFromCookieHeaders.regionLegacyUser, headerValueIgnoreCase42, headerValueIgnoreCase52, headerValueIgnoreCase62, str, jSONObject2.toString(), headerValueIgnoreCase22, headerValueIgnoreCase32);
        }
    }

    private static String getHeaderValueIgnoreCase(Map<String, List<String>> map, String str) {
        List<String> list;
        if (map != null && !TextUtils.isEmpty(str)) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    list = null;
                    break;
                }
                String next = it.next();
                if (str.equalsIgnoreCase(next)) {
                    list = map.get(next);
                    break;
                }
            }
            if (list != null && list.size() > 0) {
                return list.get(list.size() - 1);
            }
        }
        return "";
    }

    public JSONObject getStoreIdcInfo() {
        if (!this.mStoreRegionRuleEnabled) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("region", this.mStoreRegion);
            jSONObject.put("source", this.mStoreRegionSrc);
            jSONObject.put("local_region", this.mStoreRegionLocal);
            jSONObject.put("update_region", this.mUpdateRegionInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void useDomesticStoreRegion(boolean z) {
        mUseDomesticStoreRegion = z;
    }

    public static boolean isDomesticStoreRegion() {
        return mUseDomesticStoreRegion;
    }
}
