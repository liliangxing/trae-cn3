package com.bytedance.sdk.xbridge.cn.auth.loader;

import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.ILocalStorage;
import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import com.bytedance.sdk.xbridge.cn.utils.BDXInitOpt;
import com.bytedance.sdk.xbridge.cn.utils.JsonOptConfig;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RemotePermissionConfigLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/loader/RemotePermissionConfigLoader;", "Lcom/bytedance/sdk/xbridge/cn/auth/loader/BasePermissionConfigLoader;", "()V", "loaderName", "", "getLoaderName", "()Ljava/lang/String;", "createFetchParamsBody", "Lorg/json/JSONObject;", "load", "mergeData", "", "data", "mergeDataNew", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RemotePermissionConfigLoader extends BasePermissionConfigLoader {
    private final String loaderName = "RemotePermissionConfigLoader";

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public String getLoaderName() {
        return this.loaderName;
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public JSONObject load() {
        String provideRemoteConfigUrl;
        String str;
        JSONObject jSONObject;
        IPermissionConfigProvider permissionConfigProvider = getPermissionConfigProvider();
        if (permissionConfigProvider != null && (provideRemoteConfigUrl = permissionConfigProvider.provideRemoteConfigUrl()) != null) {
            String jSONObject2 = createFetchParamsBody().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "createFetchParamsBody().toString()");
            IPermissionConfigProvider permissionConfigProvider2 = getPermissionConfigProvider();
            if (permissionConfigProvider2 != null) {
                Charset charset = Charsets.UTF_8;
                if (jSONObject2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = jSONObject2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                str = permissionConfigProvider2.doPost(provideRemoteConfigUrl, null, VoiceChatApiPaths.HeaderValue.CONTENT_TYPE_JSON, bytes);
            } else {
                str = null;
            }
            if (str != null) {
                try {
                    JSONObject jSONObject3 = new JSONObject(str);
                    int optInt = jSONObject3.optInt(PageDataManager.EXTRA_STATUS);
                    if (optInt == 0) {
                        jSONObject = jSONObject3.optJSONObject("data");
                    } else {
                        XBridge.log(getLoaderName() + ": load failed, status=" + optInt);
                        jSONObject = null;
                    }
                    if (BDXInitOpt.isBDXOptEnable()) {
                        mergeDataNew(jSONObject);
                    } else {
                        mergeData(jSONObject);
                    }
                    return jSONObject3;
                } catch (Exception e) {
                    StringBuilder append = new StringBuilder().append(getLoaderName()).append(": load failed, e=");
                    String message = e.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    XBridge.log(append.append(message).toString());
                    e.printStackTrace();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return null;
    }

    private final JSONObject createFetchParamsBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            IPermissionConfigProvider permissionConfigProvider = getPermissionConfigProvider();
            if (permissionConfigProvider != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(Constant.KEY_AID, permissionConfigProvider.provideAppId());
                jSONObject2.put(Constant.KEY_APP_VERSION, permissionConfigProvider.provideAppVersion());
                jSONObject2.put("os", 0);
                jSONObject2.put("device_id", permissionConfigProvider.provideDeviceId());
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(Constant.KEY_CHANNEL, "_jsb_auth");
                jSONObject3.put("local_version", 0);
                jSONArray.put(jSONObject3);
                for (String str : permissionConfigProvider.provideNamespaces()) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(Constant.KEY_CHANNEL, "_jsb_auth." + str);
                    jSONObject4.put("local_version", 0);
                    jSONArray.put(jSONObject4);
                }
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(permissionConfigProvider.provideGeckoAccessKey(), jSONArray);
                jSONObject.put("common", jSONObject2);
                jSONObject.put("deployment", jSONObject5);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private final void mergeData(JSONObject data) {
        ILocalStorage provideLocalStorage;
        ILocalStorage provideLocalStorage2;
        ILocalStorage provideLocalStorage3;
        if (data != null) {
            IPermissionConfigProvider permissionConfigProvider = getPermissionConfigProvider();
            Object localConfig = (permissionConfigProvider == null || (provideLocalStorage3 = permissionConfigProvider.provideLocalStorage()) == null) ? null : JsonOptConfig.localConfig(provideLocalStorage3, LocalPermissionConfigLoader.KEY_PERMISSION_CONFIG_RESPONSE);
            if (!JsonOptConfig.isInvalid(localConfig)) {
                Intrinsics.checkNotNull(localConfig);
                JSONObject jsonObject = JsonOptConfig.jsonObject(localConfig);
                JSONObject optJSONObject = jsonObject.optJSONObject("packages");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = data.optJSONObject("packages");
                    Iterator<String> keys = optJSONObject2 != null ? optJSONObject2.keys() : null;
                    while (true) {
                        boolean z = false;
                        if (keys != null && keys.hasNext()) {
                            z = true;
                        }
                        if (!z) {
                            break;
                        }
                        String next = keys.next();
                        optJSONObject.put(next, optJSONObject2.getJSONArray(next));
                    }
                    data = jsonObject;
                }
            }
            if (JsonOptConfig.isJsonOptEnable()) {
                IPermissionConfigProvider permissionConfigProvider2 = getPermissionConfigProvider();
                if (permissionConfigProvider2 == null || (provideLocalStorage2 = permissionConfigProvider2.provideLocalStorage()) == null) {
                    return;
                }
                provideLocalStorage2.writeObject(LocalPermissionConfigLoader.KEY_PERMISSION_CONFIG_RESPONSE, data);
                return;
            }
            IPermissionConfigProvider permissionConfigProvider3 = getPermissionConfigProvider();
            if (permissionConfigProvider3 == null || (provideLocalStorage = permissionConfigProvider3.provideLocalStorage()) == null) {
                return;
            }
            String jSONObject = data.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "needSaveConfig.toString()");
            provideLocalStorage.write(LocalPermissionConfigLoader.KEY_PERMISSION_CONFIG_RESPONSE, jSONObject);
        }
    }

    private final void mergeDataNew(JSONObject data) {
        ILocalStorage provideLocalStorage;
        ILocalStorage provideLocalStorage2;
        ILocalStorage provideLocalStorage3;
        if (data != null) {
            JSONObject localData = BDXInitOpt.getLocalData();
            if (localData == null) {
                IPermissionConfigProvider permissionConfigProvider = getPermissionConfigProvider();
                Object localConfig = (permissionConfigProvider == null || (provideLocalStorage3 = permissionConfigProvider.provideLocalStorage()) == null) ? null : JsonOptConfig.localConfig(provideLocalStorage3, LocalPermissionConfigLoader.KEY_PERMISSION_CONFIG_RESPONSE);
                if (!JsonOptConfig.isInvalid(localConfig)) {
                    Intrinsics.checkNotNull(localConfig);
                    localData = JsonOptConfig.jsonObject(localConfig);
                }
            }
            boolean z = true;
            if (!JsonOptConfig.isInvalid(localData)) {
                JSONObject optJSONObject = localData != null ? localData.optJSONObject("packages") : null;
                JSONObject optJSONObject2 = data.optJSONObject("packages");
                Iterator<String> keys = optJSONObject2 != null ? optJSONObject2.keys() : null;
                boolean z2 = false;
                while (true) {
                    if (!(keys != null && keys.hasNext())) {
                        break;
                    }
                    String next = keys.next();
                    JSONArray jSONArray = optJSONObject2.getJSONArray(next);
                    JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray(next) : null;
                    if (z2 || !BDXInitOpt.isEquals(jSONArray, optJSONArray)) {
                        if (optJSONObject != null) {
                            optJSONObject.put(next, jSONArray);
                        }
                        z2 = true;
                    }
                }
                data = localData;
                z = z2;
            }
            if (z) {
                if (JsonOptConfig.isJsonOptEnable()) {
                    IPermissionConfigProvider permissionConfigProvider2 = getPermissionConfigProvider();
                    if (permissionConfigProvider2 == null || (provideLocalStorage2 = permissionConfigProvider2.provideLocalStorage()) == null) {
                        return;
                    }
                    Intrinsics.checkNotNull(data);
                    provideLocalStorage2.writeObject(LocalPermissionConfigLoader.KEY_PERMISSION_CONFIG_RESPONSE, data);
                    return;
                }
                IPermissionConfigProvider permissionConfigProvider3 = getPermissionConfigProvider();
                if (permissionConfigProvider3 == null || (provideLocalStorage = permissionConfigProvider3.provideLocalStorage()) == null) {
                    return;
                }
                provideLocalStorage.write(LocalPermissionConfigLoader.KEY_PERMISSION_CONFIG_RESPONSE, String.valueOf(data));
            }
        }
    }
}
