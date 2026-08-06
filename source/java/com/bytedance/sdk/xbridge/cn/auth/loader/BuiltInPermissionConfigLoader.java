package com.bytedance.sdk.xbridge.cn.auth.loader;

import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* compiled from: BuiltInPermissionConfigLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/loader/BuiltInPermissionConfigLoader;", "Lcom/bytedance/sdk/xbridge/cn/auth/loader/BasePermissionConfigLoader;", "()V", "loaderName", "", "getLoaderName", "()Ljava/lang/String;", "load", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BuiltInPermissionConfigLoader extends BasePermissionConfigLoader {
    private final String loaderName = "BuiltInPermissionConfigLoader";

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public String getLoaderName() {
        return this.loaderName;
    }

    @Override // com.bytedance.sdk.xbridge.cn.auth.loader.BasePermissionConfigLoader
    public JSONObject load() {
        IPermissionConfigProvider permissionConfigProvider = getPermissionConfigProvider();
        String provideBuiltInPermissionConfig = permissionConfigProvider != null ? permissionConfigProvider.provideBuiltInPermissionConfig() : null;
        if (provideBuiltInPermissionConfig != null) {
            try {
                Result.Companion companion = Result.Companion;
                return new JSONObject(provideBuiltInPermissionConfig);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.box-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            }
        }
        return null;
    }
}
