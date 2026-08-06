package com.ss.bduploader.net;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.bduploader.BDUploadLog;
import com.ss.bduploader.net.BDVNetClient;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGlobalGoogleDNSParseHost = "";
    private static String mGlobalOwnDNSParseHost = "";
    private static String mGoogleDNSServerPath = "/resolve?name=";
    private static String mTTDNSServerPath = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    public HTTPDNS(String str, BDVNetClient bDVNetClient, int i, Handler handler) {
        super(str, bDVNetClient, handler);
        this.mHttpDNSType = i;
    }

    public static void setDNSServerHost(String str, String str2) {
        synchronized (HTTPDNS.class) {
            if (!TextUtils.isEmpty(str)) {
                mGlobalOwnDNSParseHost = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                mGlobalGoogleDNSParseHost = str2;
            }
        }
    }

    @Override // com.ss.bduploader.net.BaseDNS
    public void start() {
        String _getURL = _getURL();
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
            this.mNetClient.startTask(_getURL, null, null, 0, new BDVNetClient.CompletionListener() { // from class: com.ss.bduploader.net.HTTPDNS.1
                @Override // com.ss.bduploader.net.BDVNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        } else {
            this.mNetClient.startTask(_getURL, null, new BDVNetClient.CompletionListener() { // from class: com.ss.bduploader.net.HTTPDNS.2
                @Override // com.ss.bduploader.net.BDVNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        }
    }

    @Override // com.ss.bduploader.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        int i = this.mHttpDNSType;
        if (i == 2 || i == 1) {
            sb.append("https://" + mGlobalOwnDNSParseHost + mTTDNSServerPath);
        } else if (i == 3) {
            sb.append("https://" + mGlobalGoogleDNSParseHost + mGoogleDNSServerPath);
        }
        sb.append(this.mHostname);
        return sb.toString();
    }

    private BDUploadDNSInfo parserResult(JSONObject jSONObject) {
        long currentTimeMillis;
        String str;
        int i = this.mHttpDNSType;
        String str2 = "";
        if (i == 2 || i == 1) {
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                BDUploadLog.m161d(TAG, String.format("no ips in json, type:%d", Integer.valueOf(this.mHttpDNSType)));
                return null;
            }
            int optInt = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
            currentTimeMillis = System.currentTimeMillis() + (r12 * 1000);
            str = null;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    str = optJSONArray.getString(i2);
                } catch (Exception e) {
                    e.printStackTrace();
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = str2 + str;
                    } else {
                        str2 = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str;
                    }
                }
            }
            r12 = optInt;
        } else {
            currentTimeMillis = 0;
            str = null;
        }
        if (this.mHttpDNSType == 3) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Answer");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2.has(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE) && jSONObject2.getInt(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE) == 1) {
                        if (jSONObject2.has("TTL")) {
                            r12 = jSONObject2.optInt("TTL");
                        }
                        if (jSONObject2.has("data")) {
                            str = jSONObject2.optString("data");
                        }
                        if (!TextUtils.isEmpty(str)) {
                            if (TextUtils.isEmpty(str2)) {
                                str2 = str2 + str;
                            } else {
                                str2 = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str;
                            }
                        }
                    }
                }
                currentTimeMillis = System.currentTimeMillis() + (r12 * 1000);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return new BDUploadDNSInfo(this.mHttpDNSType, this.mHostname, str2, currentTimeMillis, this.mId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        BDUploadLog.m161d(TAG, String.format("****http dns id:%s", this.mId));
        BDUploadDNSInfo bDUploadDNSInfo = new BDUploadDNSInfo(this.mHttpDNSType, this.mHostname, null, 0L, this.mId);
        if (error != null) {
            bDUploadDNSInfo.mErrorStr = error.errStr;
        } else if (jSONObject == null || jSONObject.length() == 0) {
            BDUploadLog.m161d(TAG, String.format("http dns json is empty type:%d", Integer.valueOf(this.mHttpDNSType)));
        } else {
            BDUploadDNSInfo parserResult = parserResult(jSONObject);
            if (parserResult != null) {
                IPCache.getInstance().put(this.mHostname, parserResult);
                notifySuccess(parserResult);
                return;
            }
        }
        notifyError(bDUploadDNSInfo);
    }
}
