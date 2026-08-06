package com.bytedance.apm6.consumer.slardar.send;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.ZstdDictManager;
import com.bytedance.apm.doctor.DoctorConstants;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.apm6.service.http.HttpRequest;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import com.bytedance.services.slardar.config.IConfigManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NetworkSender {
    private static final String FORCE_ZSTD_TIMESTAMP = "force_zstd_timestamp";
    private static final String HEADER_LEVEL = "Content-Encoding-Level";
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
    private static final String TT_LOG_ID = "x-tt-logid";
    private static volatile int compressType;
    private static HashMap<UploadLogInfo, NetworkSender> map = new HashMap<>();
    private int channelPosition;
    private volatile boolean moreChannelSwitch;
    private Boolean preNetworkError;
    private String redirectHost;
    private List<String> urls;
    private IZstdDict zstdDict;
    private IZstdCompress zstdService;
    private String lastChannelUrl = null;
    private int callstackDepth = 0;

    private NetworkSender(UploadLogInfo uploadLogInfo) {
        this.urls = uploadLogInfo.getUrls();
    }

    public static NetworkSender getInstance(UploadLogInfo uploadLogInfo) {
        if (map.containsKey(uploadLogInfo)) {
            return map.get(uploadLogInfo);
        }
        map.put(uploadLogInfo, new NetworkSender(uploadLogInfo));
        return map.get(uploadLogInfo);
    }

    public static void setCompressType(int i) {
        if (i == 2) {
            if (System.currentTimeMillis() - ApmContext.getContext().getSharedPreferences(ZstdDictManager.DICT_INTERVAL, 0).getLong(FORCE_ZSTD_TIMESTAMP, 0L) <= 3600000) {
                compressType = 1;
                return;
            }
        }
        compressType = i;
    }

    private void updateZstdHost(String str) {
        if (this.zstdDict == null) {
            this.zstdDict = (IZstdDict) ServiceManager.getService(IZstdDict.class);
        }
        if (this.zstdDict != null) {
            try {
                this.zstdDict.setDomain(new URL(str).getHost());
            } catch (MalformedURLException unused) {
            }
        }
    }

    public static void restart() {
        map.clear();
    }

    byte[] appendSettingsParams(byte[] bArr) throws JSONException {
        JSONObject jSONObject = new JSONObject(new String(bArr));
        IConfigManager iConfigManager = (IConfigManager) com.bytedance.news.common.service.manager.ServiceManager.getService(IConfigManager.class);
        if (iConfigManager != null) {
            JSONObject retrieveSettingsParams = iConfigManager.retrieveSettingsParams();
            JSONObject jSONObject2 = new JSONObject();
            String valueOf = String.valueOf(ApmContext.getAid());
            if (!TextUtils.isEmpty(valueOf) && !valueOf.equals("0")) {
                jSONObject2.put(valueOf, retrieveSettingsParams);
                jSONObject.put("settings_params", jSONObject2);
            }
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sendLog(byte[] bArr) {
        byte[] bArr2;
        boolean equals;
        boolean z;
        IConfigManager iConfigManager;
        JSONObject optJSONObject;
        if (bArr == null || bArr.length == 0) {
            return true;
        }
        try {
            String reportUrl = getReportUrl();
            updateZstdHost(reportUrl);
            try {
                bArr2 = appendSettingsParams(bArr);
            } catch (JSONException e) {
                EnsureManager.ensureNotReachHere(e, "NetworkSender->sendLog(byte[] bytes)");
                Logger.m120e(Constants.TAG, " appendSettingsParams wrong ");
                bArr2 = bArr;
            }
            HttpRequest createRequest = createRequest(reportUrl, bArr2, false);
            if (ApmContext.isDebugMode()) {
                DoctorManager.getInstance().onEvent(DoctorConstants.APM_SEND_DATA, "url:" + createRequest.url + " header:" + createRequest.headerMap);
                Logger.m119d(Constants.TAG, "sendLog createRequest: origin Bytes=" + bArr2.length + " compressed Bytes=" + createRequest.data.length + " url=" + createRequest.url + " headers=" + createRequest.headerMap);
            }
            HttpResponse doPost = ApmContext.doPost(createRequest.url, createRequest.headerMap, createRequest.data);
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "http result:" + (doPost == null ? -1 : doPost.getStatusCode() + " header:" + doPost.getHeaders()));
            }
            this.redirectHost = null;
            this.lastChannelUrl = null;
            if (doPost != null && doPost.getStatusCode() > 0) {
                this.moreChannelSwitch = false;
                if (500 <= doPost.getStatusCode() && doPost.getStatusCode() <= 600) {
                    Boolean bool = this.preNetworkError;
                    if (bool != null && bool.booleanValue()) {
                        LogReportController.getInstance().longBackOff();
                    }
                    this.preNetworkError = true;
                    return false;
                }
                JSONObject data = getData(doPost);
                if (data != null && doPost.getStatusCode() == 200) {
                    String optString = data.optString("message");
                    String optString2 = data.optString("redirect");
                    long optLong = data.optLong("delay");
                    if (data.optLong(RESPONSE_SERVER_CODE, 0L) == SERVER_CODE_ZSTD_DICT_FIND_FAILED && compressType == 2 && this.zstdService != null && this.callstackDepth == 0) {
                        compressType = 1;
                        ApmContext.getContext().getSharedPreferences(ZstdDictManager.DICT_INTERVAL, 0).edit().putLong(ZstdDictManager.DICT_INTERVAL, 0L).putLong(FORCE_ZSTD_TIMESTAMP, System.currentTimeMillis()).commit();
                        this.callstackDepth++;
                        boolean sendLog = sendLog(bArr2);
                        this.callstackDepth--;
                        return sendLog;
                    }
                    JSONObject optJSONObject2 = data.optJSONObject("settings_info");
                    if (optJSONObject2 != null && (iConfigManager = (IConfigManager) com.bytedance.news.common.service.manager.ServiceManager.getService(IConfigManager.class)) != null && (optJSONObject = optJSONObject2.optJSONObject(String.valueOf(ApmContext.getAid()))) != null) {
                        iConfigManager.updateWithSpecificAidResult(optJSONObject);
                    }
                    if ("success".equals(optString)) {
                        LogReportController.getInstance().restore();
                        this.lastChannelUrl = reportUrl;
                        this.preNetworkError = false;
                        z = true;
                        equals = false;
                    } else {
                        this.preNetworkError = true;
                        equals = "drop data".equals(optString);
                        if (ApmContext.isDebugMode()) {
                            Logger.m119d(Constants.TAG, "responseMessage:" + optString);
                        }
                        z = false;
                    }
                    try {
                        if (ApmContext.isDebugMode()) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(DoctorConstants.RESPONSE_DATA_URL, createRequest.url);
                            if (doPost.getHeaders() != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                for (Map.Entry entry : doPost.getHeaders().entrySet()) {
                                    try {
                                        if (entry.getKey() != null) {
                                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                                        }
                                    } catch (Throwable unused) {
                                    }
                                }
                                jSONObject.put(DoctorConstants.RESPONSE_DATA_HEADERS, jSONObject2);
                            }
                            jSONObject.put(DoctorConstants.RESPONSE_DATA_BODY_TEXT, data);
                            DoctorDataUtil.sendResponseEvent(bArr2, jSONObject);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    JSONObject optJSONObject3 = data.optJSONObject(RESPONSE_DOWNGRADE_RULE);
                    if (optJSONObject3 != null) {
                        DowngradeController.getInstance().setDowngradeInfo(DowngradeInfo.parse(optJSONObject3), true);
                    }
                    this.redirectHost = optString2;
                    if (optLong > 0) {
                        LogReportController.getInstance().delayReport(optLong);
                    }
                    if (equals) {
                        LogReportController.getInstance().dropData();
                        if (doPost.getHeaders() != null) {
                            DropDataMonitor.getInstance().setServerLogId((String) doPost.getHeaders().get(TT_LOG_ID));
                        }
                        DropDataMonitor.getInstance().setServerTimeStamp(System.currentTimeMillis());
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
        } catch (Throwable th2) {
            Logger.m121e(Constants.TAG, "sendLog failed.", th2);
            return false;
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
                str = (String) headers.get("ran");
                if (TextUtils.isEmpty(str)) {
                    str = (String) headers.get(CommonConsts.KEY_DECODE_RAN);
                }
            }
            try {
                String optString = jSONObject.optString("data");
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
                handleResponse(jSONObject);
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

    private String getReportUrl() {
        List<String> list = this.urls;
        if (!TextUtils.isEmpty(this.redirectHost)) {
            if (list != null && list.size() > 0) {
                try {
                    return "https://" + this.redirectHost + new URL(list.get(0)).getPath();
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
        int size = list.size();
        int i = this.channelPosition;
        if (size > i && i >= 0) {
            return list.get(i);
        }
        this.channelPosition = 0;
        return list.get(0);
    }

    private HttpRequest createRequest(String str, byte[] bArr, boolean z) {
        String addParamsToURL;
        String str2;
        IZstdCompress iZstdCompress;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap(ApmContext.getUrlParams());
        hashMap.put("Accept-Encoding", "gzip");
        byte[] bArr2 = null;
        if (bArr.length > 128) {
            if (!z) {
                if (this.zstdService == null) {
                    this.zstdService = (IZstdCompress) ServiceManager.getService(IZstdCompress.class);
                }
                if (compressType == 1 && (iZstdCompress = this.zstdService) != null) {
                    byte[] compress = iZstdCompress.compress(bArr, 15);
                    if (compress != null) {
                        hashMap.put("Content-Encoding", NetConst.TYPE_ZSTD);
                        hashMap.put(HEADER_LEVEL, String.valueOf(15));
                    }
                    bArr2 = compress;
                } else if (compressType == 2 && this.zstdService != null) {
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
                        hashMap.put("Content-Encoding", NetConst.TYPE_ZSTD_DICT);
                        hashMap.put(HEADER_LEVEL, String.valueOf(15));
                        if (!TextUtils.isEmpty(str2)) {
                            hashMap.put(ZstdDictManager.DICT_VERSION_HEADER_KEY, str2);
                            hashMap2.put(ZstdDictManager.DICT_VERSION_HEADER_KEY, str2);
                        }
                    }
                }
            }
            if (bArr2 == null && (bArr2 = compress(bArr)) != null) {
                hashMap.put("Content-Encoding", "gzip");
            }
        }
        if (bArr2 != null) {
            bArr = bArr2;
        }
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        if (LogReportController.getInstance().isEncrypt()) {
            byte[] encrypt = encrypt(bArr);
            if (encrypt != null) {
                hashMap2.put("tt_data", "a");
                addParamsToURL = UrlUtils.addParamsToURL(str, hashMap2);
                hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "before encrypt url:" + addParamsToURL);
                }
                LinkedList linkedList = new LinkedList();
                String tryEncryptRequest = tryEncryptRequest(addParamsToURL, linkedList);
                if (!TextUtils.isEmpty(tryEncryptRequest)) {
                    addParamsToURL = tryEncryptRequest;
                }
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "after encrypt url:" + addParamsToURL);
                }
                hashMap.putAll(ListUtils.listToMap(linkedList));
                bArr = encrypt;
            } else {
                addParamsToURL = UrlUtils.addParamsToURL(str, hashMap2);
            }
        } else {
            addParamsToURL = UrlUtils.addParamsToURL(str, hashMap2);
        }
        hashMap.put("Version-Code", "1");
        return new HttpRequest(addParamsToURL, hashMap, bArr);
    }

    private byte[] compress(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                IOUtils.closeQuietly(gZIPOutputStream);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                IOUtils.closeQuietly(gZIPOutputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream2 = gZIPOutputStream;
                IOUtils.closeQuietly(gZIPOutputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            gZIPOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private byte[] encrypt(byte[] bArr) {
        IEncrypt iEncrypt = (IEncrypt) ServiceManager.getService(IEncrypt.class);
        if (iEncrypt != null) {
            return iEncrypt.encrypt(bArr);
        }
        return null;
    }

    private String tryEncryptRequest(String str, List<Pair<String, String>> list) {
        EncryptService encryptService = (EncryptService) ServiceManager.getService(EncryptService.class);
        if (encryptService != null) {
            return encryptService.tryEncryptRequest(str, list);
        }
        return null;
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
            if (ApmContext.isDebugMode()) {
                Logger.m121e(Constants.TAG, "decodeData", th);
            }
            return "";
        }
    }

    private void handleResponse(JSONObject jSONObject) {
        SlardarResponseService slardarResponseService;
        if (JsonUtils.isEmpty(jSONObject)) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("configs");
        if (JsonUtils.isEmpty(optJSONObject) || (slardarResponseService = (SlardarResponseService) ServiceManager.getService(SlardarResponseService.class)) == null) {
            return;
        }
        slardarResponseService.onResponse(optJSONObject);
    }
}
