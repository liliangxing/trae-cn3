package com.bytedance.framwork.core.sdklib.apm6;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.Tools;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeController;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import com.bytedance.framwork.core.sdkmonitor.MonitorNetUtil;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class NetworkHelper {
    public static final String DICT_INTERVAL = "dict_interval";
    private static final String DICT_VERSION = "dict_version";
    public static final String DICT_VERSION_HEADER_KEY = "slardar-zstd-version";
    private static final String FORCE_ZSTD_TIMESTAMP = "force_zstd_timestamp";
    private static final String GZIP = "gzip";
    private static final String HEADER_LEVEL = "Content-Encoding-Level";
    private static final String KEY_ACCEPT_ENCODING = "Accept-Encoding";
    private static final String KEY_CONTENT_ENCODING = "Content-Encoding";
    private static final String KEY_DECODE = "ran";
    private static final String KEY_DECODE_RAN = "Ran";
    private static final String KEY_MESSAGE = "message";
    private static final int LEVEL = 15;
    private static final int MIN_COMPRESS_LEN = 128;
    private static final String RESPONSE_DELAY = "delay";
    private static final String RESPONSE_DOWNGRADE_RULE = "downgrade_rule";
    private static final String RESPONSE_MESSAGE = "message";
    private static final String RESPONSE_MESSAGE_DROP_DATA = "drop data";
    private static final String RESPONSE_MESSAGE_SUCCESS = "success";
    private static final String RESPONSE_REDIRECT = "redirect";
    private static final String RESPONSE_SERVER_CODE = "server_code";
    private static final long SERVER_CODE_ZSTD_DICT_FIND_FAILED = 10001;
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private static final String VALUE_SUCCESS = "success";
    private int callstackDepth;
    private int channelPosition;
    private int compressType;
    private String lastChannelUrl;
    private volatile boolean moreChannelSwitch;
    private Boolean preNetworkError;
    private String redirectHost;
    private IZstdDict zstdDict;
    private IZstdCompress zstdService;

    private NetworkHelper() {
        this.callstackDepth = 0;
        this.lastChannelUrl = null;
    }

    public static NetworkHelper getInstance() {
        return InnerHolder.instance;
    }

    public void setCompressType(int i) {
        if (i == 2) {
            if (System.currentTimeMillis() - ApmBaseContext.getContext().getSharedPreferences(DICT_INTERVAL, 0).getLong(FORCE_ZSTD_TIMESTAMP, 0L) <= 3600000) {
                this.compressType = 1;
                return;
            }
        }
        this.compressType = i;
    }

    private byte[] appendSettingsParams(byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, SDKMonitor> entry : SDKMonitorUtils.sAidToMonitorCommon.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().retrieveSettingsParams());
            }
            jSONObject.put("settings_params", jSONObject2);
            return Tools.safeGetBytes(jSONObject.toString());
        } catch (JSONException e) {
            EnsureManager.ensureNotReachHere(e, "NetworkHelper->appendSettingsParams");
            Logger.m1307e(Constants.TAG, "NetworkHelper appendSettingsParams failed", e);
            return bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sendLog(byte[] bArr) {
        boolean equals;
        boolean z;
        if (bArr != null && bArr.length != 0) {
            try {
                byte[] appendSettingsParams = appendSettingsParams(bArr);
                String reportUrl = getReportUrl();
                HttpResponse sendLog = sendLog(reportUrl, appendSettingsParams);
                if (SDKContext.isDebugMode()) {
                    Logger.m1305d(Constants.TAG, "http result:" + (sendLog == null ? -1 : sendLog.getStatusCode() + " header:" + sendLog.getHeaders()));
                }
                this.redirectHost = null;
                this.lastChannelUrl = null;
                if (sendLog != null && sendLog.getStatusCode() > 0) {
                    this.moreChannelSwitch = false;
                    if (500 <= sendLog.getStatusCode() && sendLog.getStatusCode() <= 600) {
                        Boolean bool = this.preNetworkError;
                        if (bool != null && bool.booleanValue()) {
                            LogReportController.getInstance().longBackOff();
                        }
                        this.preNetworkError = true;
                        return false;
                    }
                    JSONObject data = getData(sendLog);
                    dealWithSettingsInfoAndData(data);
                    if (data != null && sendLog.getStatusCode() == 200) {
                        String optString = data.optString("message");
                        String optString2 = data.optString(RESPONSE_REDIRECT);
                        long optLong = data.optLong(RESPONSE_DELAY);
                        if (data.optLong(RESPONSE_SERVER_CODE, 0L) == SERVER_CODE_ZSTD_DICT_FIND_FAILED && this.compressType == 2 && this.zstdService != null && this.callstackDepth == 0) {
                            this.compressType = 1;
                            ApmBaseContext.getContext().getSharedPreferences(DICT_INTERVAL, 0).edit().putLong(DICT_INTERVAL, 0L).putLong(FORCE_ZSTD_TIMESTAMP, System.currentTimeMillis()).commit();
                            this.callstackDepth++;
                            boolean sendLog2 = sendLog(appendSettingsParams);
                            this.callstackDepth--;
                            return sendLog2;
                        }
                        if ("success".equals(optString)) {
                            LogReportController.getInstance().restore();
                            this.lastChannelUrl = reportUrl;
                            this.preNetworkError = false;
                            z = true;
                            equals = false;
                        } else {
                            this.preNetworkError = true;
                            equals = RESPONSE_MESSAGE_DROP_DATA.equals(optString);
                            if (SDKContext.isDebugMode()) {
                                Logger.m1305d(Constants.TAG, "responseMessage:" + optString);
                            }
                            z = false;
                        }
                        JSONObject optJSONObject = data.optJSONObject(RESPONSE_DOWNGRADE_RULE);
                        if (optJSONObject != null) {
                            DowngradeController.getInstance().setDowngradeInfo(DowngradeInfo.parse(optJSONObject), true);
                        }
                        this.redirectHost = optString2;
                        if (optLong > 0) {
                            LogReportController.getInstance().delayReport(optLong);
                        }
                        if (equals) {
                            LogReportController.getInstance().dropData();
                        } else {
                            LogReportController.getInstance().recoveryFromDropData();
                        }
                        return z;
                    }
                    this.preNetworkError = true;
                    return false;
                }
                this.moreChannelSwitch = true;
                Boolean bool2 = this.preNetworkError;
                if (bool2 != null && bool2.booleanValue()) {
                    LogReportController.getInstance().shortBackOff();
                }
                this.preNetworkError = true;
                return false;
            } catch (Throwable th) {
                Logger.m1307e(Constants.TAG, "sendLog failed.", th);
            }
        }
        return false;
    }

    private void dealWithSettingsInfoAndData(JSONObject jSONObject) {
        SDKMonitor sDKMonitorUtils;
        JSONObject optJSONObject = jSONObject.optJSONObject("settings_info");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                if (optJSONObject2 != null && (sDKMonitorUtils = SDKMonitorUtils.getInstance(next)) != null) {
                    sDKMonitorUtils.updateWithSpecificAidResult(optJSONObject2);
                }
            }
        }
    }

    private JSONObject getData(HttpResponse httpResponse) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject(new String(httpResponse.getResponseBytes()));
            Map headers = httpResponse.getHeaders();
            if (headers == null || headers.isEmpty()) {
                str = null;
            } else {
                str = (String) headers.get(KEY_DECODE);
                if (TextUtils.isEmpty(str)) {
                    str = (String) headers.get(KEY_DECODE_RAN);
                }
            }
            try {
                String optString = jSONObject.optString(Constants.KEY_DATA);
                boolean z = true;
                if (!optString.isEmpty()) {
                    if (!TextUtils.isEmpty(str)) {
                        String decodeData = decodeData(optString.getBytes(), str);
                        jSONObject = new JSONObject(decodeData);
                        z = true ^ TextUtils.isEmpty(decodeData);
                    } else {
                        jSONObject = new JSONObject(new String(optString.getBytes()));
                    }
                }
                if (z) {
                    return jSONObject;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", "success");
                return jSONObject2;
            } catch (Throwable unused) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("message", "success");
                return jSONObject3;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private String decodeData(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.decode(bArr, 0))).replaceAll("\\$+$", "");
        } catch (Throwable th) {
            EnsureManager.ensureNotReachHere(th, "NetworkHelper->decodeData method error");
            return "";
        }
    }

    private String getReportUrl() {
        List<String> reportList = LogReportController.getInstance().getReportList();
        if (!TextUtils.isEmpty(this.redirectHost)) {
            if (reportList != null && reportList.size() > 0) {
                try {
                    return "https://" + this.redirectHost + new URL(reportList.get(0)).getPath();
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        if (!TextUtils.isEmpty(this.lastChannelUrl)) {
            return this.lastChannelUrl;
        }
        if (this.moreChannelSwitch) {
            this.channelPosition++;
        }
        if (reportList == null) {
            return null;
        }
        int size = reportList.size();
        int i = this.channelPosition;
        if (size > i && i >= 0) {
            return reportList.get(i);
        }
        this.channelPosition = 0;
        return reportList.get(0);
    }

    private HttpResponse sendLog(String str, byte[] bArr) throws Exception {
        String addParamsToURL;
        String str2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap(SDKContext.getCommonParams());
        hashMap.put(KEY_ACCEPT_ENCODING, GZIP);
        byte[] bArr2 = null;
        if (bArr.length > 128) {
            if (this.zstdService == null) {
                this.zstdService = (IZstdCompress) ServiceManager.getService(IZstdCompress.class);
            }
            IZstdCompress iZstdCompress = this.zstdService;
            if (iZstdCompress != null) {
                int i = this.compressType;
                if (i == 1) {
                    byte[] compress = iZstdCompress.compress(bArr, 15);
                    if (compress != null) {
                        hashMap.put("Content-Encoding", "zstd");
                        hashMap.put(HEADER_LEVEL, String.valueOf(15));
                    }
                    bArr2 = compress;
                } else if (i == 2) {
                    if (this.zstdDict == null) {
                        this.zstdDict = (IZstdDict) ServiceManager.getService(IZstdDict.class);
                    }
                    IZstdDict iZstdDict = this.zstdDict;
                    if (iZstdDict != null) {
                        Pair dictAndDictVersion = iZstdDict.getDictAndDictVersion();
                        byte[] bArr3 = (byte[]) dictAndDictVersion.first;
                        str2 = (String) dictAndDictVersion.second;
                        if (bArr3 != null) {
                            bArr2 = this.zstdService.compress(bArr, bArr3, 15);
                        }
                    } else {
                        str2 = null;
                    }
                    if (bArr2 != null) {
                        hashMap.put("Content-Encoding", "zstd/dict_monitor");
                        hashMap.put(HEADER_LEVEL, String.valueOf(15));
                        if (!TextUtils.isEmpty(str2)) {
                            hashMap.put(DICT_VERSION_HEADER_KEY, str2);
                            hashMap2.put(DICT_VERSION_HEADER_KEY, str2);
                        }
                    }
                }
            }
            if (bArr2 == null) {
                try {
                    bArr2 = MonitorNetUtil.compress(bArr, hashMap);
                    if (bArr2 != null) {
                        hashMap.put("Content-Encoding", GZIP);
                    }
                } catch (Exception unused) {
                }
            }
        }
        if (bArr2 != null) {
            bArr = bArr2;
        }
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        if (LogReportController.getInstance().isEncrypt()) {
            byte[] encrypt = TTEncryptUtils.encrypt(bArr, bArr.length);
            if (encrypt != null) {
                hashMap2.put("tt_data", "a");
                String addParamsToURL2 = UrlUtils.addParamsToURL(str, hashMap2);
                hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
                if (SDKContext.isDebugMode()) {
                    Logger.m1305d(Constants.TAG, "before encrypt url:" + addParamsToURL2);
                }
                LinkedList linkedList = new LinkedList();
                addParamsToURL = RequestEncryptUtils.tryEncryptRequest(addParamsToURL2, linkedList);
                if (SDKContext.isDebugMode()) {
                    Logger.m1305d(Constants.TAG, "after encrypt url:" + addParamsToURL);
                }
                hashMap.putAll(ListUtils.listToMap(linkedList));
                bArr = encrypt;
            } else {
                addParamsToURL = UrlUtils.addParamsToURL(str, hashMap2);
            }
        } else {
            addParamsToURL = UrlUtils.addParamsToURL(str, hashMap2);
        }
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "http request:url:" + addParamsToURL + " headers:" + hashMap);
        }
        return SDKContext.doPost(addParamsToURL, hashMap, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class InnerHolder {
        private static NetworkHelper instance = new NetworkHelper();

        private InnerHolder() {
        }
    }
}
