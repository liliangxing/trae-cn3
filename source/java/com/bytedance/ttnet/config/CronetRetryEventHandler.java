package com.bytedance.ttnet.config;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.GetDomainContext;
import com.bytedance.ttnet.http.HttpURLConnClient;
import com.bytedance.ttnet.tnc.TNCManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CronetRetryEventHandler {
    private static final String TAG = "CronetRetryEventHandler";
    private static final String TNC_ABTEST = "x-tt-tnc-abtest";
    private static final String TNC_CANARY = "x-ss-canary";
    private static final String TNC_CONFIG = "x-tt-tnc-config";
    private static final String TNC_CONTROL = "x-tt-tnc-control";
    private static final String TNC_ETAG = "x-ss-etag";
    private static final String TNC_SUMMARY = "x-tt-tnc-summary";
    private static volatile CronetRetryEventHandler sInstance;

    public static CronetRetryEventHandler inst() {
        if (sInstance == null) {
            synchronized (CronetRetryEventHandler.class) {
                if (sInstance == null) {
                    sInstance = new CronetRetryEventHandler();
                }
            }
        }
        return sInstance;
    }

    private CronetRetryEventHandler() {
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0191 A[Catch: all -> 0x0209, TRY_LEAVE, TryCatch #2 {all -> 0x0209, blocks: (B:92:0x0169, B:94:0x0175, B:58:0x018b, B:60:0x0191), top: B:91:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c0 A[Catch: all -> 0x0207, TryCatch #1 {all -> 0x0207, blocks: (B:63:0x019a, B:65:0x01a6, B:66:0x01ba, B:68:0x01c0, B:69:0x01f5), top: B:62:0x019a }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateConfigOnCronetFailed(ArrayList<String> arrayList, String str) {
        Context context;
        String str2;
        String str3;
        String str4;
        GetDomainContext getDomainContext;
        String urlBuilder;
        HashMap hashMap;
        HashMap hashMap2;
        String str5;
        String str6;
        String str7;
        String str8 = "GET";
        String str9 = TNC_ABTEST;
        String str10 = TNC_CONFIG;
        if (arrayList == null || arrayList.isEmpty() || (context = TTNetInit.getTTNetDepend().getContext()) == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "start get-domain request.");
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                getDomainContext = new GetDomainContext();
                getDomainContext.useHttps = true;
                getDomainContext.addCommonParam = false;
                UrlBuilder urlBuilder2 = new UrlBuilder(next);
                urlBuilder2.addParam("tnc_src", "7");
                urlBuilder = urlBuilder2.toString();
                hashMap = new HashMap();
                hashMap2 = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        hashMap2.put(TNC_SUMMARY, str);
                    } catch (Throwable th) {
                        th = th;
                        str2 = str8;
                        str3 = str9;
                        str4 = str10;
                        th.printStackTrace();
                        str8 = str2;
                        str10 = str4;
                        str9 = str3;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (!TNCManager.getInstance().isTncRequestProceed(str8, urlBuilder, hashMap2, "")) {
                return;
            }
            String executeGet = HttpURLConnClient.executeGet(urlBuilder, hashMap2, hashMap, getDomainContext);
            if (Logger.debug()) {
                Logger.d(TAG, "response: " + executeGet);
            }
            if (!TNCManager.getInstance().isTncResponseProceed(str8, urlBuilder, hashMap, executeGet)) {
                return;
            }
            if (!StringUtils.isEmpty(executeGet) && "success".equals(new JSONObject(executeGet).getString("message"))) {
                try {
                    String str11 = (hashMap.get(TNC_ETAG) == null || TextUtils.isEmpty((CharSequence) ((List) hashMap.get(TNC_ETAG)).get(0))) ? "" : (String) ((List) hashMap.get(TNC_ETAG)).get(0);
                    String str12 = (hashMap.get(TNC_CANARY) == null || TextUtils.isEmpty((CharSequence) ((List) hashMap.get(TNC_CANARY)).get(0))) ? "" : (String) ((List) hashMap.get(TNC_CANARY)).get(0);
                    if (hashMap.get(str10) != null) {
                        str2 = str8;
                        try {
                            if (!TextUtils.isEmpty((CharSequence) ((List) hashMap.get(str10)).get(0))) {
                                str5 = (String) ((List) hashMap.get(str10)).get(0);
                                if (hashMap.get(str9) == null) {
                                    try {
                                        str4 = str10;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str4 = str10;
                                        str3 = str9;
                                        try {
                                            th.printStackTrace();
                                            return;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            th.printStackTrace();
                                            str8 = str2;
                                            str10 = str4;
                                            str9 = str3;
                                        }
                                    }
                                    try {
                                        if (!TextUtils.isEmpty((CharSequence) ((List) hashMap.get(str9)).get(0))) {
                                            str6 = (String) ((List) hashMap.get(str9)).get(0);
                                            if (hashMap.get(TNC_CONTROL) != null) {
                                                str3 = str9;
                                                try {
                                                    if (!TextUtils.isEmpty((CharSequence) ((List) hashMap.get(TNC_CONTROL)).get(0))) {
                                                        str7 = (String) ((List) hashMap.get(TNC_CONTROL)).get(0);
                                                        if (Logger.debug()) {
                                                            Logger.d(TAG, "tnc verion: " + str11 + " canary: " + str12 + " configid: " + str5 + " abtest: " + str6);
                                                        }
                                                        SsCronetHttpClient.inst(context).notifyTNCConfigUpdated(str11, str12, str5, str6, str7, executeGet);
                                                        return;
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    th.printStackTrace();
                                                    return;
                                                }
                                            } else {
                                                str3 = str9;
                                            }
                                            str7 = "";
                                            if (Logger.debug()) {
                                            }
                                            SsCronetHttpClient.inst(context).notifyTNCConfigUpdated(str11, str12, str5, str6, str7, executeGet);
                                            return;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        str3 = str9;
                                        th.printStackTrace();
                                        return;
                                    }
                                } else {
                                    str4 = str10;
                                }
                                str6 = "";
                                if (hashMap.get(TNC_CONTROL) != null) {
                                }
                                str7 = "";
                                if (Logger.debug()) {
                                }
                                SsCronetHttpClient.inst(context).notifyTNCConfigUpdated(str11, str12, str5, str6, str7, executeGet);
                                return;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            str3 = str9;
                            str4 = str10;
                            th.printStackTrace();
                            return;
                        }
                    } else {
                        str2 = str8;
                    }
                    str5 = "";
                    if (hashMap.get(str9) == null) {
                    }
                    str6 = "";
                    if (hashMap.get(TNC_CONTROL) != null) {
                    }
                    str7 = "";
                    if (Logger.debug()) {
                    }
                    SsCronetHttpClient.inst(context).notifyTNCConfigUpdated(str11, str12, str5, str6, str7, executeGet);
                    return;
                } catch (Throwable th8) {
                    th = th8;
                    str2 = str8;
                }
            }
        }
    }
}
