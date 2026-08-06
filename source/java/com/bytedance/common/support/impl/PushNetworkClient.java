package com.bytedance.common.support.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.network.DefaultNetWorkClient;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PushNetworkClient extends NetworkClient {
    private static volatile PushNetworkClient networkClient;
    private final String TAG = "PushNetworkClient";
    private final NetworkClient mDefaultNetworkClient = new DefaultNetWorkClient();

    public static PushNetworkClient getDefault() {
        if (networkClient == null) {
            synchronized (PushNetworkClient.class) {
                if (networkClient == null) {
                    networkClient = new PushNetworkClient();
                }
            }
        }
        return networkClient;
    }

    private PushNetworkClient() {
    }

    private NetworkClient getNetworkClient() {
        NetworkClient networkClient2 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.getNetworkClient();
        if (networkClient2 != null) {
            return networkClient2;
        }
        NetworkClient networkClient3 = NetworkClient.getDefault();
        if (!networkClient3.getClass().getName().contains("DummyNetworkClient")) {
            return networkClient3;
        }
        Logger.w("PushNetworkClient", "use DefaultNetWorkClient as backup networkClient because NetworkClient.getDefault() is DummyNetworkClient");
        return this.mDefaultNetworkClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bytedance.common.utility.NetworkClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String get(String str, Map<String, String> map, NetworkClient.ReqContext reqContext) throws Exception {
        String str2;
        String str3;
        String str4;
        NetworkClient networkClient2 = getNetworkClient();
        String str5 = "";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String str6 = networkClient2.get(str, map, reqContext);
            if (TextUtils.isEmpty("")) {
                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "GET", "", currentTimeMillis);
            } else {
                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "GET", "", "", currentTimeMillis);
            }
            return str6;
        } catch (Throwable th) {
            try {
                str5 = th.getLocalizedMessage();
                if (ToolUtils.isSmpProcess(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication) && !(networkClient2 instanceof DefaultNetWorkClient)) {
                    str2 = networkClient2.getClass().getCanonicalName() + " -> " + this.mDefaultNetworkClient.getClass().getCanonicalName();
                    try {
                        Logger.w("PushNetworkClient", "use DefaultNetWorkClient as backup networkClient because cur is smp and NetworkClient.getDefault() is failed");
                        try {
                            String str7 = this.mDefaultNetworkClient.get(str, map, reqContext);
                            if (TextUtils.isEmpty("")) {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "GET", str2, currentTimeMillis);
                            } else {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "GET", "", str2, currentTimeMillis);
                            }
                            return str7;
                        } catch (Throwable th2) {
                            str4 = th.getLocalizedMessage() + " -> " + th2.getLocalizedMessage();
                            if (TextUtils.isEmpty(str4)) {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "GET", str4, str2, currentTimeMillis);
                                return "";
                            }
                            PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "GET", str2, currentTimeMillis);
                            return "";
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = "";
                        if (TextUtils.isEmpty(str3)) {
                            PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "GET", str2, currentTimeMillis);
                        } else {
                            PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "GET", str3, str2, currentTimeMillis);
                        }
                        throw th;
                    }
                }
                str2 = "";
                str4 = str5;
                if (TextUtils.isEmpty(str4)) {
                }
            } catch (Throwable th4) {
                th = th4;
                str2 = "";
                str3 = str5;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.common.utility.NetworkClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String post(String str, List<Pair<String, String>> list, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        String str2;
        String str3;
        String str4;
        String str5;
        NetworkClient networkClient2 = getNetworkClient();
        String str6 = "";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String post = networkClient2.post(str, list, map, reqContext);
            if (TextUtils.isEmpty("")) {
                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", "", currentTimeMillis);
            } else {
                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", "", "", currentTimeMillis);
            }
            return post;
        } catch (Throwable th) {
            try {
                str6 = th.getLocalizedMessage();
                if (ToolUtils.isSmpProcess(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication) && !(networkClient2 instanceof DefaultNetWorkClient)) {
                    String str7 = networkClient2.getClass().getCanonicalName() + " -> " + this.mDefaultNetworkClient.getClass().getCanonicalName();
                    try {
                        Logger.w("PushNetworkClient", "use DefaultNetWorkClient as backup networkClient because cur is smp and NetworkClient.getDefault() is failed");
                        try {
                            String post2 = this.mDefaultNetworkClient.post(str, list, map, reqContext);
                            if (TextUtils.isEmpty("")) {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str7, currentTimeMillis);
                            } else {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", "", str7, currentTimeMillis);
                            }
                            return post2;
                        } catch (Throwable th2) {
                            str5 = th.getLocalizedMessage() + " -> " + th2.getLocalizedMessage();
                            str4 = str7;
                            if (TextUtils.isEmpty(str5)) {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", str5, str4, currentTimeMillis);
                                return "";
                            }
                            PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str4, currentTimeMillis);
                            return "";
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = str7;
                        str3 = "";
                        if (TextUtils.isEmpty(str3)) {
                            PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str2, currentTimeMillis);
                        } else {
                            PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", str3, str2, currentTimeMillis);
                        }
                        throw th;
                    }
                }
                str4 = "";
                str5 = str6;
                if (TextUtils.isEmpty(str5)) {
                }
            } catch (Throwable th4) {
                th = th4;
                str2 = "";
                str3 = str6;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    @Override // com.bytedance.common.utility.NetworkClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String post(String str, byte[] bArr, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        String str2;
        String localizedMessage;
        String str3;
        NetworkClient networkClient2 = getNetworkClient();
        long currentTimeMillis = System.currentTimeMillis();
        String str4 = "";
        try {
            str2 = networkClient2.getClass().getCanonicalName();
            try {
                String post = networkClient2.post(str, bArr, map, reqContext);
                if (TextUtils.isEmpty("")) {
                    PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str2, currentTimeMillis, (JSONObject) null);
                } else {
                    PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", "", str2, currentTimeMillis, (JSONObject) null);
                }
                return post;
            } catch (Throwable th) {
                th = th;
                try {
                    localizedMessage = th.getLocalizedMessage();
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    if (ToolUtils.isSmpProcess(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication) && !(networkClient2 instanceof DefaultNetWorkClient)) {
                        str2 = networkClient2.getClass().getCanonicalName() + " -> " + this.mDefaultNetworkClient.getClass().getCanonicalName();
                        str4 = "";
                        Logger.w("PushNetworkClient", "use DefaultNetWorkClient as backup networkClient because cur is smp and NetworkClient.getDefault() is failed");
                        try {
                            String post2 = this.mDefaultNetworkClient.post(str, bArr, map, reqContext);
                            if (TextUtils.isEmpty("")) {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str2, currentTimeMillis, (JSONObject) null);
                            } else {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", "", str2, currentTimeMillis, (JSONObject) null);
                            }
                            return post2;
                        } catch (Throwable th3) {
                            str3 = th.getLocalizedMessage() + " -> " + th3.getLocalizedMessage();
                            if (TextUtils.isEmpty(str3)) {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", str3, str2, currentTimeMillis, (JSONObject) null);
                            } else {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str2, currentTimeMillis, (JSONObject) null);
                            }
                            return "";
                        }
                    }
                    str3 = localizedMessage;
                    if (TextUtils.isEmpty(str3)) {
                    }
                    return "";
                } catch (Throwable th4) {
                    th = th4;
                    str4 = localizedMessage;
                    if (TextUtils.isEmpty(str4)) {
                        PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str2, currentTimeMillis, (JSONObject) null);
                    } else {
                        PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", str4, str2, currentTimeMillis, (JSONObject) null);
                    }
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            str2 = "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010b  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String post(String str, List<Pair<String, String>> list, Map<String, String> map, NetworkClient.ReqContext reqContext, JSONObject jSONObject) {
        String str2;
        String str3;
        String str4;
        String str5;
        NetworkClient networkClient2 = getNetworkClient();
        String str6 = "";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String post = networkClient2.post(str, list, map, reqContext);
            if (TextUtils.isEmpty("")) {
                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", "", currentTimeMillis, jSONObject);
            } else {
                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", "", "", currentTimeMillis, jSONObject);
            }
            return post;
        } catch (Throwable th) {
            try {
                str6 = th.getLocalizedMessage();
                if (!ToolUtils.isSmpProcess(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication) || (networkClient2 instanceof DefaultNetWorkClient)) {
                    str4 = "";
                    str5 = str6;
                } else {
                    String str7 = networkClient2.getClass().getCanonicalName() + " -> " + this.mDefaultNetworkClient.getClass().getCanonicalName();
                    try {
                        Logger.w("PushNetworkClient", "use DefaultNetWorkClient as backup networkClient because cur is smp and NetworkClient.getDefault() is failed");
                        try {
                            String post2 = this.mDefaultNetworkClient.post(str, list, map, reqContext);
                            if (TextUtils.isEmpty("")) {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str7, currentTimeMillis, jSONObject);
                            } else {
                                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", "", str7, currentTimeMillis, jSONObject);
                            }
                            return post2;
                        } catch (Throwable th2) {
                            str5 = th.getLocalizedMessage() + " -> " + th2.getLocalizedMessage();
                            str4 = str7;
                            if (TextUtils.isEmpty(str5)) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = str7;
                        str3 = "";
                        if (TextUtils.isEmpty(str3)) {
                            PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str2, currentTimeMillis, jSONObject);
                        } else {
                            PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", str3, str2, currentTimeMillis, jSONObject);
                        }
                        throw th;
                    }
                }
                if (TextUtils.isEmpty(str5)) {
                    PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestFailed(str, "POST", str5, str4, currentTimeMillis, jSONObject);
                    return "";
                }
                PushCommonSupport.getInstance().getICommonPushSdkMonitorService().onRequestSuccess(str, "POST", str4, currentTimeMillis, jSONObject);
                return "";
            } catch (Throwable th4) {
                th = th4;
                str2 = "";
                str3 = str6;
            }
        }
    }
}
