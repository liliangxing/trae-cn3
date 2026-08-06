package com.bytedance.applog.server;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.store.Pack;
import com.bytedance.applog.util.BDNetworkTagManagerHelper;
import com.bytedance.applog.util.EncryptUtils;
import com.bytedance.applog.util.JsonUtils;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Api {
    private static final String BLOCK_LIST_KEY = "blocklist";
    private static final String BLOCK_LIST_V1 = "v1";
    private static final String BLOCK_LIST_V3 = "v3";
    private static final int CODE_HTTP_RESP_404 = 404;
    public static final String COL_CAT = "category";
    public static final String COL_EXT_VALUE = "ext_value";
    public static final String COL_FORWARD = "forward";
    public static final String COL_LABEL = "label";
    public static final String COL_PARAM = "params";
    public static final String COL_PRIORITY = "priority";
    public static final String COL_TAG = "tag";
    public static final String COL_VALUE = "value";
    public static final String CONTENT_TYPE = "application/json; charset=utf-8";
    public static final String FORBID_REPORT_PHONE_DETAIL_INFO = "forbid_report_phone_detail_info";
    public static final int HTTP_INIT = 10;
    public static final int HTTP_RESP_EXCEPTION_OTHER_CODE = 14;
    public static final int HTTP_RESP_LATE_PROPERTY_NOT_INIT = 15;
    public static final int HTTP_RESP_MAGIC_TAG_ERROR = 12;
    public static final int HTTP_RESP_MESSAGE_ERROR = 13;
    public static final int HTTP_RESP_NULL = 11;
    public static final String KEY_AB_SDK_VERSION = "ab_sdk_version";
    public static final String KEY_ACTIVITES = "activites";
    public static final String KEY_AID = "aid";
    public static final String KEY_APPLOG_PRIORITY_GROUP_ID = "app_log_priority";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_BG_SESSION = "bg_session";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_C_UDID = "clientudid";
    public static final String KEY_DATETIME = "datetime";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_DISABLE_PERSONALIZATION = "disable_personalization";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_ENCRYPT_RESP_IV = "iv";
    public static final String KEY_ENCRYPT_RESP_KEY = "key";
    public static final String KEY_EVENT_INDEX = "tea_event_index";
    public static final String KEY_EVENT_UID_ENABLE = "uid_enable";
    public static final String KEY_EXPECTED_BATCH_INTERVAL = "expected_batch_interval";
    public static final String KEY_FROM_SESSION = "from_session";
    public static final String KEY_GEN_TIME = "_gen_time";
    public static final String KEY_HEADER = "header";
    public static final String KEY_HEADER_CUSTOM_ALLOW_ENABLE = "header_custom_allow_enable";
    public static final String KEY_IMPRESSION = "item_impression";
    public static final String KEY_INSTALL_ID = "install_id";
    public static final String KEY_LAUNCH = "launch";
    public static final String KEY_LAUNCH_FROM = "launch_from";
    public static final String KEY_LOCAL_TIME = "local_time";
    public static final String KEY_LOCAL_TIME_MS = "local_time_ms";
    public static final String KEY_LOG_BACK = "log_back";
    public static final String KEY_MAGIC = "magic_tag";
    public static final String KEY_MISC = "log_data";
    private static final String KEY_MSG = "message";
    public static final String KEY_OPEN_UDID = "openudid";
    public static final String KEY_OPTIONS = "options";
    public static final String KEY_PARAMS_BLOCK_ENABLE = "params_block_enable";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SDK_VERSION_CODE = "sdk_version_code";
    public static final String KEY_SDK_VERSION_NAME = "sdk_version_name";
    private static final String KEY_SERVER_TIME = "server_time";
    public static final String KEY_SESSION_ID = "session_id";
    public static final String KEY_SESSION_TYPE = "session_type";
    public static final String KEY_SET_COOKIE = "Set-Cookie";
    public static final String KEY_SIG_HASH = "sig_hash";
    public static final String KEY_SSID = "ssid";
    public static final String KEY_TERMINATE = "terminate";
    public static final String KEY_TIME_SYNC = "time_sync";
    public static final String KEY_TOUCH_POINT = "touch_point";
    public static final String KEY_TO_SESSION = "to_session";
    public static final String KEY_UID = "uid";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_IS_AUTH = "user_is_auth";
    public static final String KEY_USER_IS_LOGIN = "user_is_login";
    public static final String KEY_USER_TYPE = "user_type";
    public static final String KEY_USER_UNIQUE_ID = "user_unique_id";
    public static final String KEY_V1 = "event";
    public static final String KEY_V3 = "event_v3";
    public static final String KEY_VERSION_CODE = "version_code";
    private static final int LENGTH_MAX = 10240;
    public static final int METHOD_GET = 0;
    public static final int METHOD_POST = 1;
    public static final String MSG_MAGIC = "ss_app_log";
    private static final String MSG_OK = "success";
    protected final AppLogInstance appLogInstance;
    protected final EncryptUtils encryptUtils;
    public JSONObject mTimeSync;
    private static final List<String> logTags = Collections.singletonList("Api");
    private static final String[] HTTP_METHOD = {"GET", "POST"};

    public static boolean checkIfJamMsg(int i) {
        return i >= 500 && i < 600;
    }

    public static boolean checkIfResp404(int i) {
        return 404 == i;
    }

    public Api(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
        this.encryptUtils = new EncryptUtils(appLogInstance);
    }

    public EncryptUtils getEncryptUtils() {
        return this.encryptUtils;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class HttpResp {
        byte[] mRespByteArray;
        String mRespStr;
        int mType;

        HttpResp(int i) {
            this.mType = i;
        }
    }

    public static String filterQuery(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x022e A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x023b A[Catch: all -> 0x023e, TRY_ENTER, TryCatch #4 {all -> 0x023e, blocks: (B:77:0x0212, B:80:0x023b, B:81:0x023d), top: B:76:0x0212 }] */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpResp httpRequestInner(int i, String str, HashMap<String, String> hashMap, byte[] bArr, int i2) throws RangersHttpException {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3;
        ByteArrayOutputStream byteArrayOutputStream4;
        int responseCode;
        ByteArrayOutputStream byteArrayOutputStream5;
        DataOutputStream dataOutputStream2;
        ?? r3;
        this.appLogInstance.getLogger().debug(11, "Start request http url: {}", str);
        if (this.appLogInstance.isLogEnabled() && hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    this.appLogInstance.getLogger().debug(11, "http headers key: {}, value: {}", entry.getKey(), entry.getValue());
                }
            }
        }
        HttpResp httpResp = new HttpResp(i2);
        DataOutputStream dataOutputStream3 = null;
        try {
            URL url = new URL(str);
            if (this.appLogInstance.getDefaultHttpClientProxy() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(this.appLogInstance.getDefaultHttpClientProxy());
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if (i == 0) {
                httpURLConnection.setDoOutput(false);
            } else if (i == 1) {
                httpURLConnection.setDoOutput(true);
            } else {
                this.appLogInstance.getLogger().warn(11, logTags, "unknown method", new Object[0]);
            }
            httpURLConnection.setRequestMethod(HTTP_METHOD[i]);
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry2 : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                        httpURLConnection.addRequestProperty(entry2.getKey(), entry2.getValue());
                    } else {
                        this.appLogInstance.getLogger().warn(11, logTags, "header key value invalid", new Object[0]);
                    }
                }
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream = null;
            } else {
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                    byteArrayOutputStream3 = null;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                    byteArrayOutputStream4 = byteArrayOutputStream3;
                    dataOutputStream3 = dataOutputStream;
                    byteArrayOutputStream = byteArrayOutputStream4;
                    try {
                        this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
                        this.appLogInstance.getLogger().error(11, "Send request failed", th, new Object[0]);
                        if (th instanceof RangersHttpException) {
                        }
                    } finally {
                        Utils.closeSafely(dataOutputStream3);
                        Utils.closeSafely(byteArrayOutputStream);
                        Utils.closeSafely(inputStream);
                        Utils.closeSafely(byteArrayOutputStream2);
                    }
                }
            }
            responseCode = httpURLConnection.getResponseCode();
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
        }
        if (responseCode != 200) {
            throw new RangersHttpException(responseCode, httpURLConnection.getResponseMessage());
        }
        if (i2 == 0) {
            if (httpURLConnection.getContentLength() < LENGTH_MAX) {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    r3 = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream2)));
                } else {
                    r3 = new BufferedReader(new InputStreamReader(inputStream2));
                }
                try {
                    StringBuilder sb = new StringBuilder(inputStream2.available());
                    while (true) {
                        String readLine = r3.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine).append("\n");
                    }
                    httpResp.mRespStr = sb.toString();
                    JSONObject jSONObject = new JSONObject(httpResp.mRespStr);
                    jSONObject.put("Set-Cookie", httpURLConnection.getHeaderField("Set-Cookie"));
                    httpResp.mRespStr = jSONObject.toString();
                    dataOutputStream2 = r3;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    byteArrayOutputStream2 = null;
                    byteArrayOutputStream4 = r3;
                    dataOutputStream3 = dataOutputStream;
                    byteArrayOutputStream = byteArrayOutputStream4;
                    this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
                    this.appLogInstance.getLogger().error(11, "Send request failed", th, new Object[0]);
                    if (th instanceof RangersHttpException) {
                    }
                }
            } else {
                this.appLogInstance.getLogger().error(11, logTags, "respType is {}", Integer.valueOf(i2));
                dataOutputStream2 = null;
            }
            inputStream = null;
            dataOutputStream3 = dataOutputStream2;
            byteArrayOutputStream5 = null;
        } else {
            InputStream inputStream3 = httpURLConnection.getInputStream();
            inputStream = "gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding()) ? new GZIPInputStream(inputStream3) : inputStream3;
            try {
                byteArrayOutputStream5 = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream5.write(bArr2, 0, read);
                    }
                    httpResp.mRespByteArray = byteArrayOutputStream5.toByteArray();
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream2 = byteArrayOutputStream5;
                    byteArrayOutputStream4 = null;
                    dataOutputStream3 = dataOutputStream;
                    byteArrayOutputStream = byteArrayOutputStream4;
                    this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
                    this.appLogInstance.getLogger().error(11, "Send request failed", th, new Object[0]);
                    if (th instanceof RangersHttpException) {
                        return httpResp;
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream3 = null;
                byteArrayOutputStream2 = byteArrayOutputStream3;
                byteArrayOutputStream4 = byteArrayOutputStream3;
                dataOutputStream3 = dataOutputStream;
                byteArrayOutputStream = byteArrayOutputStream4;
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
                this.appLogInstance.getLogger().error(11, "Send request failed", th, new Object[0]);
                if (th instanceof RangersHttpException) {
                }
            }
        }
        return httpResp;
    }

    public String http(int i, String str, HashMap<String, String> hashMap, byte[] bArr) throws RangersHttpException {
        return httpRequestInner(i, str, hashMap, bArr, 0).mRespStr;
    }

    public byte[] httpStream(int i, String str, HashMap<String, String> hashMap, byte[] bArr) throws RangersHttpException {
        return httpRequestInner(i, str, hashMap, bArr, 1).mRespByteArray;
    }

    public JSONObject eventVerify(String str, JSONObject jSONObject) {
        String str2;
        JSONObject jSONObject2;
        HashMap<String, String> headers = getHeaders(false, false, -1, null);
        String uuid = UUID.randomUUID().toString();
        sendRequestStart2DevToolsWithJson(str, uuid, jSONObject, 1, headers);
        try {
            str2 = this.appLogInstance.getNetClient().post(this.encryptUtils.encryptUrl(str), this.encryptUtils.transformStrToByte(jSONObject.toString()), headers);
        } catch (Throwable th) {
            this.appLogInstance.getLogger().error(11, "Send event to et failed", th, new Object[0]);
            str2 = null;
        }
        if (str2 != null) {
            try {
                jSONObject2 = new JSONObject(str2);
                try {
                    updateTimeDiff(jSONObject2);
                    sendRequestEnd2DevTools(uuid, 200, null, str2);
                } catch (Throwable th2) {
                    th = th2;
                    this.appLogInstance.getLogger().error(11, "Parse et response failed", th, new Object[0]);
                    this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                    sendRequestEnd2DevTools(uuid, -1, null, "Parse et response failed");
                    return jSONObject2;
                }
            } catch (Throwable th3) {
                th = th3;
                jSONObject2 = null;
            }
            return jSONObject2;
        }
        this.appLogInstance.getLogger().error(11, "Et response invalid", new Object[0]);
        sendRequestEnd2DevTools(uuid, -1, null, "Empty et response");
        return null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public int send(java.lang.String[] r30, byte[] r31, com.bytedance.applog.engine.Engine r32, java.lang.String[] r33, int r34, java.lang.String r35, java.util.Map<java.lang.String, java.lang.String> r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.server.Api.send(java.lang.String[], byte[], com.bytedance.applog.engine.Engine, java.lang.String[], int, java.lang.String, java.util.Map, boolean):int");
    }

    public boolean trySendForward(String str, Pack pack, Map<String, String> map) {
        if (pack == null || TextUtils.isEmpty(str)) {
            return true;
        }
        HashMap<String, String> headers = getHeaders(false, true, pack.encodeType, pack.encodeHeaders);
        if (map != null && !map.isEmpty()) {
            headers.putAll(map);
        }
        String uuid = UUID.randomUUID().toString();
        sendRequestStart2DevToolsWithBytes(str, uuid, pack.data, 1, headers);
        this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.REPORT_REQUEST_COUNT);
        try {
            String post = this.appLogInstance.getNetClient().post(str, pack.data, headers);
            this.appLogInstance.getLogger().debug(11, logTags, "trySendForward resp:{} ", post);
            sendRequestEnd2DevTools(uuid, TextUtils.isEmpty(post) ? -1 : 200, TextUtils.isEmpty(post) ? null : post.getBytes(UrlUtils.UTF_8), null);
            return true;
        } catch (Throwable th) {
            this.appLogInstance.getLogger().error(11, logTags, "trySendForward failed ", th, new Object[0]);
            this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
            this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
            this.appLogInstance.getMonitorHelper().sendError("api send forward log failed", th);
            sendRequestEnd2DevTools(uuid, -1, null, "Send forward log error");
            return false;
        }
    }

    private void updateTimeDiff(JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(KEY_SERVER_TIME);
            if (optLong > 0) {
                final JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(KEY_SERVER_TIME, optLong);
                jSONObject2.put(KEY_LOCAL_TIME, System.currentTimeMillis() / 1000);
                this.mTimeSync = jSONObject2;
                if (LogUtils.isDisabled()) {
                    return;
                }
                LogUtils.sendJsonFetcher("server_time_sync", new EventBus.DataFetcher() { // from class: com.bytedance.applog.server.Api.1
                    @Override // com.bytedance.applog.log.EventBus.DataFetcher
                    public Object fetch() {
                        JSONObject jSONObject3 = new JSONObject();
                        JsonUtils.mergeJsonObject(jSONObject2, jSONObject3);
                        try {
                            jSONObject3.put("appId", Api.this.appLogInstance.getAppId());
                        } catch (Throwable unused) {
                        }
                        return jSONObject3;
                    }
                });
            }
        } catch (Exception unused) {
            this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
        }
    }

    private HashMap<String, String> getHeaders(boolean z, boolean z2, int i, String str) {
        HashMap<String, String> hashMap = new HashMap<>(2);
        if (this.appLogInstance.getEncryptAndCompress()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            } catch (Throwable unused) {
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                if (i == 0) {
                    hashMap.put("log-encode-type", "gzip");
                } else if (i == 1 || i == 2) {
                    hashMap.put("log-encode-type", NetConst.TYPE_ZSTD);
                    hashMap.put("log-encode-token", String.valueOf(0));
                }
            }
        }
        if (!z2) {
            BDNetworkTagManagerHelper.addHeader(hashMap, z);
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject config(String str, JSONObject jSONObject) {
        String str2;
        Throwable th;
        JSONObject jSONObject2;
        boolean z = false;
        HashMap<String, String> headers = getHeaders(false, false, -1, null);
        String uuid = UUID.randomUUID().toString();
        sendRequestStart2DevToolsWithJson(str, uuid, jSONObject, 1, headers);
        this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.CONFIG_REQUEST_COUNT);
        try {
            byte[] transformStrToByte = this.encryptUtils.transformStrToByte(jSONObject.toString());
            String optString = jSONObject.optString(KEY_ENCRYPT_RESP_KEY);
            String optString2 = jSONObject.optString(KEY_ENCRYPT_RESP_IV);
            if ((TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) ? false : true) {
                byte[] postStream = this.appLogInstance.getNetClient().postStream(str, transformStrToByte, headers);
                byte[] decryptAesCbc = EncryptUtils.decryptAesCbc(postStream, optString, optString2);
                if (decryptAesCbc == null) {
                    str2 = new String(postStream);
                } else {
                    str2 = new String(EncryptUtils.gzipUncompress(decryptAesCbc));
                }
            } else {
                str2 = this.appLogInstance.getNetClient().post(str, transformStrToByte, headers);
            }
        } catch (Throwable th2) {
            this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
            this.appLogInstance.getLogger().error(11, logTags, "config request failed", th2, new Object[0]);
            this.appLogInstance.getMonitorHelper().sendError("api send config failed", th2);
            str2 = null;
        }
        if (str2 != null) {
            try {
                jSONObject2 = new JSONObject(str2);
                try {
                    updateTimeDiff(jSONObject2);
                    sendRequestEnd2DevTools(uuid, 200, null, str2);
                } catch (Throwable th3) {
                    th = th3;
                    this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                    this.appLogInstance.getLogger().error(11, logTags, "Parse config response failed", th, new Object[0]);
                    sendRequestEnd2DevTools(uuid, -1, null, "Parse config response failed");
                    if (jSONObject2 != null) {
                        z = true;
                    }
                    if (!z) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                jSONObject2 = null;
            }
        } else {
            sendRequestEnd2DevTools(uuid, -1, null, "Config response empty");
            jSONObject2 = null;
        }
        if (jSONObject2 != null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
            z = true;
        }
        if (!z) {
            return jSONObject2.optJSONObject("config");
        }
        this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.CONFIG_REQUEST_FAILED_COUNT);
        return null;
    }

    public void fillKeyIvForEncryptResp(JSONObject jSONObject, boolean z) {
        boolean z2;
        try {
            if (z) {
                if (this.appLogInstance.getEnableEventUserId()) {
                    jSONObject.put(KEY_EVENT_UID_ENABLE, 1);
                    z2 = true;
                }
                z2 = false;
            } else {
                if (this.appLogInstance.getInitConfig() != null && this.appLogInstance.getInitConfig().isEventFilterEnable()) {
                    jSONObject.put(EncryptUtils.KEY_EVENT_FILTER, 1);
                    z2 = true;
                }
                z2 = false;
            }
            if (z2 && this.appLogInstance.getEncryptAndCompress()) {
                String[] genRandomKeyAndIv = EncryptUtils.genRandomKeyAndIv();
                if (EncryptUtils.isValidKeyIv(genRandomKeyAndIv)) {
                    jSONObject.put(KEY_ENCRYPT_RESP_KEY, genRandomKeyAndIv[0]);
                    jSONObject.put(KEY_ENCRYPT_RESP_IV, genRandomKeyAndIv[1]);
                }
            }
        } catch (JSONException e) {
            this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
            this.appLogInstance.getLogger().error(11, logTags, "fillKeyIvForEncryptResp error", e, new Object[0]);
        }
    }

    public void sendRequestStart2DevToolsWithJson(final String str, final String str2, final JSONObject jSONObject, final int i, final Map<String, String> map) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        LogUtils.sendJsonFetcher("do_request_begin", new EventBus.DataFetcher() { // from class: com.bytedance.applog.server.Api.2
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                Map map2 = map;
                if (map2 != null) {
                    try {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject3.put((String) entry.getKey(), entry.getValue());
                        }
                    } catch (Throwable unused) {
                        Api.this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                    }
                }
                try {
                    jSONObject2.put("appId", Api.this.appLogInstance.getAppId());
                    jSONObject2.put("nid", str2);
                    jSONObject2.put("url", str);
                    jSONObject2.put("data", jSONObject);
                    jSONObject2.put("header", jSONObject3);
                    jSONObject2.put("method", i);
                    jSONObject2.put(OaidModel.KEY_TIME, currentTimeMillis);
                } catch (Throwable unused2) {
                    Api.this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                }
                return jSONObject2;
            }
        });
    }

    public void sendRequestStart2DevToolsWithBytes(final String str, final String str2, final byte[] bArr, final int i, final Map<String, String> map) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        LogUtils.sendJsonFetcher("do_request_begin", new EventBus.DataFetcher() { // from class: com.bytedance.applog.server.Api.3
            /* JADX WARN: Can't wrap try/catch for region: R(8:1|(4:20|21|(2:24|22)|25)|3|(2:7|(5:9|10|12|13|14))|19|12|13|14) */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x008e, code lost:
            
                r5.this$0.appLogInstance.getMonitorHelper().increaseStats(com.bytedance.applog.monitor.p006v3.StatsCountKeys.JSON_ERROR_COUNT);
             */
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Object fetch() {
                JSONObject jSONObject;
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                Map map2 = map;
                if (map2 != null) {
                    try {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject3.put((String) entry.getKey(), entry.getValue());
                        }
                    } catch (Throwable unused) {
                    }
                }
                byte[] bArr2 = bArr;
                if (bArr2 != null && bArr2.length > 0) {
                    String str3 = new String(bArr);
                    if (JsonUtils.isJsonObjectLike(str3)) {
                        try {
                            jSONObject = new JSONObject(str3);
                        } catch (Throwable unused2) {
                            Api.this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                        }
                        jSONObject2.put("appId", Api.this.appLogInstance.getAppId());
                        jSONObject2.put("nid", str2);
                        jSONObject2.put("url", str);
                        jSONObject2.put("data", jSONObject);
                        jSONObject2.put("header", jSONObject3);
                        jSONObject2.put("method", i);
                        jSONObject2.put(OaidModel.KEY_TIME, currentTimeMillis);
                        return jSONObject2;
                    }
                }
                jSONObject = null;
                jSONObject2.put("appId", Api.this.appLogInstance.getAppId());
                jSONObject2.put("nid", str2);
                jSONObject2.put("url", str);
                jSONObject2.put("data", jSONObject);
                jSONObject2.put("header", jSONObject3);
                jSONObject2.put("method", i);
                jSONObject2.put(OaidModel.KEY_TIME, currentTimeMillis);
                return jSONObject2;
            }
        });
    }

    public void sendRequestEnd2DevTools(final String str, final int i, final byte[] bArr, final String str2) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        LogUtils.sendJsonFetcher("do_request_end", new EventBus.DataFetcher() { // from class: com.bytedance.applog.server.Api.4
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appId", Api.this.appLogInstance.getAppId());
                    jSONObject.put("nid", str);
                    jSONObject.put("statusCode", i);
                    jSONObject.put("responseByte", bArr);
                    jSONObject.put("responseString", str2);
                    jSONObject.put(OaidModel.KEY_TIME, currentTimeMillis);
                } catch (Throwable unused) {
                    Api.this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                }
                return jSONObject;
            }
        });
    }
}
