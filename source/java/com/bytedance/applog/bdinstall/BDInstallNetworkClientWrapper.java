package com.bytedance.applog.bdinstall;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.RangersHttpException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BDInstallNetworkClientWrapper implements INetworkClient {
    private final AppLogInstance mAppLogInstance;

    private Map<String, String> wrapIsolateHeaders(String str, Map<String, String> map) {
        return map;
    }

    public BDInstallNetworkClientWrapper(AppLogInstance appLogInstance) {
        this.mAppLogInstance = appLogInstance;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String str, Map<String, String> map) throws Exception {
        Map<String, String> wrapIsolateHeaders = wrapIsolateHeaders(str, map);
        String sendGetRequest2DevToolsWithJson = sendGetRequest2DevToolsWithJson(str, null, wrapIsolateHeaders);
        String str2 = this.mAppLogInstance.getNetClient().get(str, wrapIsolateHeaders);
        sendResponse2DevTools(sendGetRequest2DevToolsWithJson, str2);
        return str2;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, byte[] bArr, Map<String, String> map) throws Exception {
        Map<String, String> wrapIsolateHeaders = wrapIsolateHeaders(str, map);
        String sendPostRequest2DevToolsWithBytes = sendPostRequest2DevToolsWithBytes(str, bArr, wrapIsolateHeaders);
        String post = this.mAppLogInstance.getNetClient().post(str, bArr, wrapIsolateHeaders);
        sendResponse2DevTools(sendPostRequest2DevToolsWithBytes, post);
        return post;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, byte[] bArr, String str2) throws Exception {
        HashMap hashMap = new HashMap(2);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("Content-Type", str2);
        }
        String sendPostRequest2DevToolsWithBytes = sendPostRequest2DevToolsWithBytes(str, bArr, hashMap);
        String post = this.mAppLogInstance.getNetClient().post(str, bArr, str2);
        sendResponse2DevTools(sendPostRequest2DevToolsWithBytes, post);
        return post;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, List<Pair<String, String>> list) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            for (Pair<String, String> pair : list) {
                jSONObject.put((String) pair.first, pair.second);
            }
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        String sendGetRequest2DevToolsWithJson = sendGetRequest2DevToolsWithJson(str, jSONObject, hashMap);
        String post = this.mAppLogInstance.getNetClient().post(str, list);
        sendResponse2DevTools(sendGetRequest2DevToolsWithJson, post);
        return post;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
        Map<String, String> wrapIsolateHeaders = wrapIsolateHeaders(str, map);
        String sendPostRequest2DevToolsWithBytes = sendPostRequest2DevToolsWithBytes(str, bArr, wrapIsolateHeaders);
        byte[] postStream = this.mAppLogInstance.getNetClient().postStream(str, bArr, wrapIsolateHeaders);
        sendResponse2DevTools(sendPostRequest2DevToolsWithBytes, postStream != null ? new String(postStream) : "");
        return postStream;
    }

    private String sendGetRequest2DevToolsWithJson(String str, JSONObject jSONObject, Map<String, String> map) {
        if (LogUtils.isDisabled()) {
            return "";
        }
        String uuid = UUID.randomUUID().toString();
        this.mAppLogInstance.getApi().sendRequestStart2DevToolsWithJson(str, uuid, jSONObject, 0, map);
        return uuid;
    }

    private String sendPostRequest2DevToolsWithBytes(String str, byte[] bArr, Map<String, String> map) {
        if (LogUtils.isDisabled()) {
            return "";
        }
        String uuid = UUID.randomUUID().toString();
        this.mAppLogInstance.getApi().sendRequestStart2DevToolsWithBytes(str, uuid, bArr, 1, map);
        return uuid;
    }

    private void sendResponse2DevTools(String str, String str2) {
        if (LogUtils.isDisabled()) {
            return;
        }
        if (Utils.isNotEmpty(str2)) {
            try {
                this.mAppLogInstance.getApi().sendRequestEnd2DevTools(str, 200, str2.getBytes(UrlUtils.UTF_8), null);
            } catch (Throwable unused) {
            }
        } else {
            this.mAppLogInstance.getApi().sendRequestEnd2DevTools(str, -1, null, "BDInstall get response empty");
        }
    }
}
