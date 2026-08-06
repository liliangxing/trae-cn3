package com.bytedance.sdk.xbridge.cn.auth.loader;

import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: BasePermissionConfigLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/loader/BasePermissionConfigLoader;", "", "()V", "loaderName", "", "getLoaderName", "()Ljava/lang/String;", "permissionConfigProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "getPermissionConfigProvider", "()Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "setPermissionConfigProvider", "(Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;)V", "load", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BasePermissionConfigLoader {
    private IPermissionConfigProvider permissionConfigProvider;

    public abstract String getLoaderName();

    public abstract JSONObject load();

    public IPermissionConfigProvider getPermissionConfigProvider() {
        return this.permissionConfigProvider;
    }

    public void setPermissionConfigProvider(IPermissionConfigProvider iPermissionConfigProvider) {
        this.permissionConfigProvider = iPermissionConfigProvider;
    }
}
