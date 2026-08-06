package com.ss.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.AVMDLNetClient;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGoogleDNSServer = "/resolve?name=";
    private static String mHttpDNSServer = "/resolve?domain=";
    private static String mTTDNSServer = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    public HTTPDNS(String str, AVMDLNetClient aVMDLNetClient, int i, Handler handler, int i2) {
        super(str, aVMDLNetClient, handler, i2);
        this.mHttpDNSType = i;
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public void start() {
        String _getURL;
        HashMap hashMap;
        int i;
        if (AVMDLDNSParser.mGlobalEnableAuthentication == 1 && ((i = this.mHttpDNSType) == 2 || i == 5)) {
            _getURL = _getURLWithAuth();
        } else {
            _getURL = _getURL();
        }
        String str = _getURL;
        AVMDLLog.m226d(TAG, "http dns url:" + str);
        Method[] declaredMethods = this.mNetClient.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            Method method = declaredMethods[i2];
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                z = true;
                break;
            }
            i2++;
        }
        if (AVMDLDNSParser.mGlobalHTTPDNSNewCache == 1) {
            hashMap = new HashMap();
            hashMap.put("Use-L1-Cache", "true");
            AVMDLLog.m226d(TAG, "add header :headers.size():" + hashMap.size());
        } else {
            hashMap = null;
        }
        HashMap hashMap2 = hashMap;
        AVMDLNetClient.CompletionListener completionListener = new AVMDLNetClient.CompletionListener() { // from class: com.ss.mediakit.net.HTTPDNS.1
            @Override // com.ss.mediakit.net.AVMDLNetClient.CompletionListener
            public void onCompletion(JSONObject jSONObject, Error error) {
                HTTPDNS.this._handleResponse(jSONObject, error);
            }
        };
        if (z) {
            this.mNetClient.startTask(str, hashMap2, null, 0, completionListener);
        } else {
            this.mNetClient.startTask(str, hashMap2, completionListener);
        }
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        boolean isIPv4Reachable = AVMDLMultiNetwork.isIPv4Reachable();
        boolean isIPv4Reachable2 = AVMDLMultiNetwork.isIPv4Reachable();
        int i = this.mHttpDNSType;
        if (i == 2 || i == 1 || i == 5) {
            sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        } else if (i == 3) {
            sb.append("https://" + AVMDLDNSParser.mGlobalGoogleDNSParseHost + mGoogleDNSServer);
        }
        sb.append(this.mHostname);
        int i2 = this.mHttpDNSType;
        if (i2 == 2 || i2 == 1 || i2 == 5) {
            sb.append("&source=vod");
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            if (config != null) {
                if (config.mAppID >= 0) {
                    sb.append("&aid=").append(config.mAppID);
                }
                if (config.mEnableNetworkChangeNotify == 1) {
                    if (isIPv4Reachable && isIPv4Reachable2) {
                        sb.append("&f=0");
                    } else if (isIPv4Reachable) {
                        sb.append("&f=1");
                    } else if (isIPv4Reachable2) {
                        sb.append("&f=2");
                    }
                }
            }
        }
        if (this.mHttpDNSType == 5) {
            sb.append("&needweight=true");
        }
        if (AVMDLDNSParser.mGlobalHTTPDNSNeedRank == 1) {
            sb.append("&needrank=true");
        }
        if (AVMDLDNSParser.mGlobalHttpDNSAccountId != null && !AVMDLDNSParser.mGlobalHttpDNSAccountId.isEmpty()) {
            sb.append("&account_id=").append(AVMDLDNSParser.mGlobalHttpDNSAccountId);
        }
        return sb.toString();
    }

    private String _getURLWithAuth() {
        StringBuilder sb = new StringBuilder();
        AVMDLMultiNetwork.isIPv4Reachable();
        AVMDLMultiNetwork.isIPv4Reachable();
        String sign = getSign("0");
        if (AVMDLDNSParser.mGlobalDisableAuthentication == 1) {
            return _getURL();
        }
        sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mHttpDNSServer);
        sb.append(this.mHostname);
        sb.append("&source=vod&timestamp=");
        sb.append(AVMDLDNSParser.mGlobalHttpDNSTimeStamp);
        sb.append("&account_id=").append(AVMDLDNSParser.mGlobalHttpDNSAccountId);
        sb.append("&type=0&sign=");
        sb.append(sign);
        if (this.mHttpDNSType == 5) {
            sb.append("&needweight=true");
        }
        if (AVMDLDNSParser.mGlobalHTTPDNSNeedRank == 1) {
            sb.append("&needrank=true");
        }
        return sb.toString();
    }

    private String getSign(String str) {
        String str2 = this.mHostname;
        String str3 = AVMDLDNSParser.mGlobalHttpDNSTimeStamp;
        String str4 = AVMDLDNSParser.mGlobalHttpDNSAccountId;
        String str5 = AVMDLDNSParser.mGlobalHttpDNSSecretKey;
        String[] strArr = {AVMDLDNSParser.mGlobalHttpDNSSecretKey, str3, str4, str2, "", str};
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(strArr[i]);
            if (i < 5) {
                sb.append(RomUtils.SEPARATOR);
            }
        }
        return md5(sb.toString());
    }

    private String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AVMDLDNSInfo parserResult(JSONObject jSONObject) {
        Boolean bool;
        Boolean bool2;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        final String str5;
        String str6;
        long j;
        String str7;
        JSONArray jSONArray;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        JSONArray jSONArray2;
        String str13;
        String str14;
        String str15;
        String str16;
        String sb;
        int i2;
        long currentTimeMillis;
        String str17;
        String str18;
        String str19;
        String str20 = DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE;
        int i3 = this.mHttpDNSType;
        String str21 = "cl";
        String str22 = "";
        if (i3 == 2 || i3 == 1 || i3 == 5) {
            if (jSONObject != null && jSONObject.length() != 0) {
                final int optInt = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda0
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(optInt), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                        return format;
                    }
                });
                if (AVMDLDNSParser.mGlobalForceExpiredTime > 0) {
                    optInt = AVMDLDNSParser.mGlobalForceExpiredTime;
                }
                int i4 = optInt;
                long currentTimeMillis2 = System.currentTimeMillis();
                String str23 = Constants.ACCEPT_TIME_SEPARATOR_SP;
                long j2 = currentTimeMillis2 + (i4 * 1000);
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("weight");
                    if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                        bool = false;
                    } else {
                        bool = false;
                        if (optJSONArray.length() == optJSONArray2.length()) {
                            bool2 = true;
                            JSONArray optJSONArray3 = jSONObject.optJSONArray("cl");
                            String jSONArray3 = (optJSONArray3 != null || optJSONArray3.length() <= 0) ? "" : optJSONArray3.toString();
                            String str24 = "";
                            String str25 = str24;
                            String str26 = null;
                            i = 0;
                            int i5 = 0;
                            int i6 = 0;
                            while (i < optJSONArray.length()) {
                                try {
                                    str7 = optJSONArray.getString(i);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    str7 = null;
                                }
                                if (TextUtils.isEmpty(str7)) {
                                    jSONArray = optJSONArray;
                                    str8 = str24;
                                    str9 = str21;
                                    str10 = str23;
                                    str11 = str7;
                                } else {
                                    if (TextUtils.isEmpty(str24)) {
                                        jSONArray = optJSONArray;
                                        String str27 = str7;
                                        sb = str24 + str27;
                                        str9 = str21;
                                        str15 = str27;
                                        str16 = str23;
                                    } else {
                                        jSONArray = optJSONArray;
                                        String str28 = str24;
                                        str9 = str21;
                                        str15 = str7;
                                        StringBuilder append = new StringBuilder().append(str28);
                                        str16 = str23;
                                        sb = append.append(str16).append(str15).toString();
                                    }
                                    i5++;
                                    str11 = str15;
                                    str10 = str16;
                                    str8 = sb;
                                }
                                if (bool2.booleanValue()) {
                                    try {
                                        str12 = optJSONArray2.getString(i);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        str12 = null;
                                    }
                                    if (!TextUtils.isEmpty(str12)) {
                                        if (TextUtils.isEmpty(str25)) {
                                            jSONArray2 = optJSONArray2;
                                            str13 = str8;
                                            str14 = str25 + str12;
                                        } else {
                                            jSONArray2 = optJSONArray2;
                                            str13 = str8;
                                            str14 = str25 + str10 + str12;
                                        }
                                        str25 = str14;
                                        i6++;
                                        i++;
                                        optJSONArray = jSONArray;
                                        optJSONArray2 = jSONArray2;
                                        String str29 = str11;
                                        str23 = str10;
                                        str21 = str9;
                                        str24 = str13;
                                        str26 = str29;
                                    }
                                }
                                jSONArray2 = optJSONArray2;
                                str13 = str8;
                                str25 = str25;
                                i++;
                                optJSONArray = jSONArray;
                                optJSONArray2 = jSONArray2;
                                String str292 = str11;
                                str23 = str10;
                                str21 = str9;
                                str24 = str13;
                                str26 = str292;
                            }
                            String str30 = str24;
                            String str31 = str25;
                            str = str21;
                            str2 = str23;
                            if (bool2.booleanValue() || i5 == i6) {
                                str3 = str31;
                            } else {
                                bool2 = bool;
                                str3 = "";
                            }
                            if (!bool2.booleanValue() && this.mHttpDNSType == 5) {
                                this.mHttpDNSType = 2;
                            }
                            str4 = str3;
                            r17 = i4;
                            str5 = jSONArray3;
                            str6 = str26;
                            str22 = str30;
                            j = j2;
                        }
                    }
                    bool2 = bool;
                    JSONArray optJSONArray32 = jSONObject.optJSONArray("cl");
                    if (optJSONArray32 != null) {
                    }
                    String str242 = "";
                    String str252 = str242;
                    String str262 = null;
                    i = 0;
                    int i52 = 0;
                    int i62 = 0;
                    while (i < optJSONArray.length()) {
                    }
                    String str302 = str242;
                    String str312 = str252;
                    str = str21;
                    str2 = str23;
                    if (bool2.booleanValue()) {
                    }
                    str3 = str312;
                    if (!bool2.booleanValue()) {
                        this.mHttpDNSType = 2;
                    }
                    str4 = str3;
                    r17 = i4;
                    str5 = jSONArray3;
                    str6 = str262;
                    str22 = str302;
                    j = j2;
                }
            }
            return null;
        }
        j = 0;
        str = "cl";
        str2 = Constants.ACCEPT_TIME_SEPARATOR_SP;
        str4 = "";
        str5 = str4;
        str6 = null;
        String str32 = str6;
        if (this.mHttpDNSType == 3) {
            try {
                JSONArray jSONArray4 = jSONObject.getJSONArray("Answer");
                final int i7 = r17;
                int i8 = 0;
                while (i8 < jSONArray4.length()) {
                    JSONObject jSONObject2 = jSONArray4.getJSONObject(i8);
                    if (jSONObject2.has(str20)) {
                        str18 = str20;
                        if (jSONObject2.getInt(str20) == 1) {
                            if (jSONObject2.has("TTL")) {
                                i7 = jSONObject2.optInt("TTL");
                            }
                            if (jSONObject2.has("data")) {
                                str32 = jSONObject2.optString("data");
                            }
                            String str33 = str32;
                            if (TextUtils.isEmpty(str33)) {
                                str32 = str33;
                            } else {
                                if (TextUtils.isEmpty(str22)) {
                                    str19 = str22 + str33;
                                } else {
                                    str19 = str22 + str2 + str33;
                                }
                                str32 = str33;
                                str22 = str19;
                            }
                        }
                    } else {
                        str18 = str20;
                    }
                    i8++;
                    str20 = str18;
                }
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda1
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(i7), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                        return format;
                    }
                });
                i2 = AVMDLDNSParser.mGlobalForceExpiredTime > 0 ? AVMDLDNSParser.mGlobalForceExpiredTime : i7;
                currentTimeMillis = System.currentTimeMillis() + (i2 * 1000);
                str17 = str22;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } else {
            currentTimeMillis = j;
            str17 = str22;
            i2 = r17;
        }
        AVMDLDNSInfo aVMDLDNSInfo = new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, str17, currentTimeMillis, this.mId, this.mTaskType);
        if (!TextUtils.isEmpty(str4)) {
            aVMDLDNSInfo.setDnsExtInfo("weight", str4);
        }
        aVMDLDNSInfo.setDnsExtInfo("ttl", i2);
        if (str5 != null && !str5.isEmpty()) {
            aVMDLDNSInfo.setDnsExtInfo(str, str5);
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda2
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    return HTTPDNS.this.m4197lambda$parserResult$2$comssmediakitnetHTTPDNS(str5);
                }
            });
        }
        return aVMDLDNSInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$parserResult$2$com-ss-mediakit-net-HTTPDNS, reason: not valid java name */
    public /* synthetic */ String m4197lambda$parserResult$2$comssmediakitnetHTTPDNS(String str) {
        return String.format(Locale.US, "parserResult host:%s cl:%s", this.mHostname, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        AVMDLDNSInfo aVMDLDNSInfo;
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda3
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return HTTPDNS.this.m4194lambda$_handleResponse$3$comssmediakitnetHTTPDNS();
            }
        });
        AVMDLDNSInfo aVMDLDNSInfo2 = new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, (String) null, 0L, this.mId, this.mTaskType);
        if (error != null) {
            aVMDLDNSInfo2.mErrorStr = error.errStr;
            if (AVMDLLog.isLogLevelEnabled(1)) {
                final String str = error.errStr;
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda4
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "handle response receive err:%s", str);
                        return format;
                    }
                });
            }
        } else if (jSONObject == null || jSONObject.length() == 0) {
            new Error(this.mHttpDNSType, this.mHostname, this.mId, String.format(Locale.US, "HTTP dns empty, type:%d", Integer.valueOf(this.mHttpDNSType)));
            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda5
                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                public final String get() {
                    String format;
                    format = String.format(Locale.US, "json null err", new Object[0]);
                    return format;
                }
            });
        } else {
            try {
                aVMDLDNSInfo = parserResult(jSONObject);
            } catch (Throwable th) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda6
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "handle response exception:%s", th.toString());
                        return format;
                    }
                });
                aVMDLDNSInfo = null;
            }
            if (aVMDLDNSInfo == null) {
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda7
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        String format;
                        format = String.format(Locale.US, "info null err", new Object[0]);
                        return format;
                    }
                });
            } else {
                final String str2 = aVMDLDNSInfo.mIpList;
                AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda8
                    @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                    public final String get() {
                        return HTTPDNS.this.m4195lambda$_handleResponse$8$comssmediakitnetHTTPDNS(str2);
                    }
                });
                IPCache.getInstance().put(this.mHostname, aVMDLDNSInfo);
                notifySuccess(aVMDLDNSInfo);
                return;
            }
        }
        AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.net.HTTPDNS$$ExternalSyntheticLambda9
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return HTTPDNS.this.m4196lambda$_handleResponse$9$comssmediakitnetHTTPDNS();
            }
        });
        notifyError(aVMDLDNSInfo2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$_handleResponse$3$com-ss-mediakit-net-HTTPDNS, reason: not valid java name */
    public /* synthetic */ String m4194lambda$_handleResponse$3$comssmediakitnetHTTPDNS() {
        return String.format(Locale.US, "****http dns id:%s type:%d host:%s", this.mId, Integer.valueOf(this.mHttpDNSType), this.mHostname);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$_handleResponse$8$com-ss-mediakit-net-HTTPDNS, reason: not valid java name */
    public /* synthetic */ String m4195lambda$_handleResponse$8$comssmediakitnetHTTPDNS(String str) {
        return String.format(Locale.US, "****parse suc for host:%s iplist:%s", this.mHostname, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$_handleResponse$9$com-ss-mediakit-net-HTTPDNS, reason: not valid java name */
    public /* synthetic */ String m4196lambda$_handleResponse$9$comssmediakitnetHTTPDNS() {
        return String.format(Locale.US, "****parse failed for host:%s", this.mHostname);
    }
}
