package com.bytedance.sdk.xbridge.cn.auth.loader;

import com.bytedance.sdk.xbridge.cn.auth.ILocalStorage;
import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import com.bytedance.sdk.xbridge.cn.utils.BDXInitOpt;
import com.bytedance.sdk.xbridge.cn.utils.JsonOptConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LocalPermissionConfigLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/loader/LocalPermissionConfigLoader;", "Lcom/bytedance/sdk/xbridge/cn/auth/loader/BasePermissionConfigLoader;", "()V", "loaderName", "", "getLoaderName", "()Ljava/lang/String;", "load", "Lorg/json/JSONObject;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LocalPermissionConfigLoader extends BasePermissionConfigLoader {
    private static final String KEY_PERMISSION_CONFIG_REPO_PREFIX = "com.bytedance.sdk.xbridge.cn.protocol.permission";
    public static final String KEY_PERMISSION_CONFIG_RESPONSE = "com.bytedance.sdk.xbridge.cn.protocol.permission.permission_config_response";
    private final String loaderName = "LocalPermissionLoader";

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public String getLoaderName() {
        return this.loaderName;
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public JSONObject load() {
        ILocalStorage provideLocalStorage;
        IPermissionConfigProvider permissionConfigProvider = getPermissionConfigProvider();
        Object localConfig = (permissionConfigProvider == null || (provideLocalStorage = permissionConfigProvider.provideLocalStorage()) == null) ? null : JsonOptConfig.localConfig(provideLocalStorage, KEY_PERMISSION_CONFIG_RESPONSE);
        if (JsonOptConfig.isInvalid(localConfig)) {
            return null;
        }
        Intrinsics.checkNotNull(localConfig);
        JSONObject jsonObject = JsonOptConfig.jsonObject(localConfig);
        if (BDXInitOpt.isBDXOptEnable()) {
            BDXInitOpt.setLocalData(jsonObject);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", jsonObject);
        return jSONObject;
    }
}
