package com.ss.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.AVMDLNetClient;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HTTPDNSHosts {
    private static final String TAG = "BatchParseHTTPDNSHosts";
    private static String mTTDNSServer = "/q?host=";
    protected boolean mCancelled = false;
    protected Handler mHandler;
    public String[] mHostnames;
    private int mHttpDNSType;
    public String mId;
    protected AVMDLNetClient mNetClient;

    public HTTPDNSHosts(String[] strArr, AVMDLNetClient aVMDLNetClient, int i, Handler handler) throws Exception {
        this.mHttpDNSType = 2;
        this.mNetClient = null;
        if (i != 2) {
            AVMDLLog.m226d(TAG, "create fail type is not own");
            throw new Exception("type is not own");
        }
        if (strArr == null || strArr.length == 0) {
            AVMDLLog.m226d(TAG, "host array is valid");
            throw new Exception("host array is valid");
        }
        this.mHttpDNSType = i;
        this.mHostnames = strArr;
        this.mNetClient = aVMDLNetClient;
        if (aVMDLNetClient == null) {
            this.mNetClient = new AVMDLHTTPNetwork();
        }
        this.mHttpDNSType = i;
        this.mHandler = handler;
    }

    public void start() {
        String _getURL = _getURL();
        AVMDLLog.m226d(TAG, "batch http dns  url:" + _getURL);
        Method[] declaredMethods = this.mNetClient.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Method method = declaredMethods[i];
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            this.mNetClient.startTask(_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.ss.mediakit.net.HTTPDNSHosts.1
                @Override // com.ss.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNSHosts.this._handleResponse(jSONObject, error);
                }
            });
        } else {
            this.mNetClient.startTask(_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.ss.mediakit.net.HTTPDNSHosts.2
                @Override // com.ss.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNSHosts.this._handleResponse(jSONObject, error);
                }
            });
        }
    }

    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.mHostnames;
            if (i < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i])) {
                    if (i2 == 0) {
                        sb.append(this.mHostnames[i]);
                    } else {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP + this.mHostnames[i]);
                    }
                    i2++;
                }
                i++;
            } else {
                return sb.toString();
            }
        }
    }

    private void parseResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dns");
            for (int i = 0; i < jSONArray.length(); i++) {
                AVMDLDNSInfo parserResultForSingleHost = parserResultForSingleHost(jSONArray.getJSONObject(i));
                if (parserResultForSingleHost != null) {
                    IPCache.getInstance().put(parserResultForSingleHost.mHost, parserResultForSingleHost);
                }
            }
        } catch (Exception e) {
            AVMDLLog.m226d(TAG, "parse json exception" + e);
        }
    }

    private AVMDLDNSInfo parserResultForSingleHost(JSONObject jSONObject) {
        final String str;
        final long j;
        final String str2;
        String str3;
        int i = this.mHttpDNSType;
        if (i == 2 || i == 1) {
            if (jSONObject != null && jSONObject.length() != 0) {
                int optInt = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
                String optString = jSONObject.has("host") ? jSONObject.optString("host") : null;
                long currentTimeMillis = System.currentTimeMillis() + (optInt * 1000);
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    String str4 = "";
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        try {
                            str3 = optJSONArray.getString(i2);
                        } catch (Exception e) {
                            e.printStackTrace();
                            str3 = null;
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            if (TextUtils.isEmpty(str4)) {
                                str4 = str4 + str3;
                            } else {
                                str4 = str4 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3;
                            }
                        }
                    }
                    str = optString;
                    j = currentTimeMillis;
                    str2 = str4;
                }
            }
            return null;
        }
        j = 0;
        str2 = "";
        str = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AVMDLLog.m226d(TAG, "parse result is null");
            return null;
        }
        if (AVMDLLog.isLogLevelEnabled(1)) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNSHosts$$ExternalSyntheticLambda5
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "parse result host:%s ips:%s expiredT:%d", str, str2, Long.valueOf(j));
                    return format;
                }
            });
        }
        return new AVMDLDNSInfo(this.mHttpDNSType, str, str2, j, this.mId, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, final Error error) {
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNSHosts$$ExternalSyntheticLambda0
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return HTTPDNSHosts.this.m4198lambda$_handleResponse$1$comssmediakitnetHTTPDNSHosts();
            }
        });
        if (error != null) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNSHosts$$ExternalSyntheticLambda1
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "handle response receive err:%s", Error.this.errStr);
                    return format;
                }
            });
            return;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNSHosts$$ExternalSyntheticLambda2
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "json null err", new Object[0]);
                    return format;
                }
            });
            return;
        }
        try {
            parseResult(jSONObject);
        } catch (Throwable th) {
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNSHosts$$ExternalSyntheticLambda3
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "handle response exception:%s", th.toString());
                    return format;
                }
            });
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNSHosts$$ExternalSyntheticLambda4
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                String format;
                format = String.format(Locale.US, "****parse end", new Object[0]);
                return format;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$_handleResponse$1$com-ss-mediakit-net-HTTPDNSHosts, reason: not valid java name */
    public /* synthetic */ String m4198lambda$_handleResponse$1$comssmediakitnetHTTPDNSHosts() {
        return String.format(Locale.US, "****http dns id:%s type:%d", this.mId, Integer.valueOf(this.mHttpDNSType));
    }
}
