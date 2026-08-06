package com.bytedance.applog.util;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.server.Api;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.RangersHttpException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultClient implements INetworkClient {
    public static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private final Api api;
    private final AppLogInstance appLogInstance;

    public DefaultClient(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
        this.api = appLogInstance.getApi();
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String str, Map<String, String> map) throws RangersHttpException {
        return this.api.http(0, str, (HashMap) map, null);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
        return this.api.http(1, str, (HashMap) map, bArr);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, byte[] bArr, String str2) throws RangersHttpException {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("Content-Type", str2);
        }
        return post(str, bArr, hashMap);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, List<Pair<String, String>> list) throws RangersHttpException {
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            try {
                for (Pair<String, String> pair : list) {
                    jSONObject.put((String) pair.first, pair.second);
                }
            } catch (Throwable th) {
                this.appLogInstance.getLogger().error(11, "post parse params to json failed", th, new Object[0]);
            }
        }
        return post(str, jSONObject.toString().getBytes(), "application/json; charset=utf-8");
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
        return this.api.httpStream(1, str, (HashMap) map, bArr);
    }
}
