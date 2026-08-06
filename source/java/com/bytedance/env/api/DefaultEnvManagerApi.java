package com.bytedance.env.api;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.bytedance.env.api.EnvManagerApi;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultEnvManagerApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/env/api/DefaultEnvManagerApi;", "Lcom/bytedance/env/api/EnvManagerApi;", "()V", "addOnEnvConfigChangeListener", "", "listener", "Lcom/bytedance/env/api/OnEnvConfigChangeListener;", "getEnvConfig", "Lcom/bytedance/env/api/EnvConfig;", "getGeckoConfig", "Lcom/bytedance/env/api/GeckoConfig;", "init", "context", "Landroid/content/Context;", "initEnvConfig", "config", "initGeckoConfig", "isFloatingWindowVisible", "", "openDialog", "activity", "Landroid/app/Activity;", "reboot", "removeOnEnvConfigChangeListener", "setAutoRebootEnable", "enable", "setEnvConfig", "setEnvWindowEnable", "setFloatingWindowRemovable", "setFloatingWindowVisible", "visible", "setGeckoConfig", "env_platform_api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DefaultEnvManagerApi implements EnvManagerApi {
    @Override // com.bytedance.env.api.EnvManagerApi
    public void addOnEnvConfigChangeListener(OnEnvConfigChangeListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void initEnvConfig(EnvConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void initGeckoConfig(GeckoConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public boolean isFloatingWindowVisible() {
        return true;
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void reboot() {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void removeOnEnvConfigChangeListener(OnEnvConfigChangeListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void setAutoRebootEnable(boolean enable) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void setEnvConfig(EnvConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void setEnvWindowEnable(boolean enable) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void setFloatingWindowRemovable(boolean enable) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void setFloatingWindowVisible(boolean visible) {
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void setGeckoConfig(GeckoConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public String getEnvLane() {
        return EnvManagerApi.DefaultImpls.getEnvLane(this);
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public int getEnvType() {
        return EnvManagerApi.DefaultImpls.getEnvType(this);
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void setEnvConfig(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "lane");
        EnvManagerApi.DefaultImpls.setEnvConfig(this, i, str);
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void init(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Log.d(EnvManagerApiKt.LOG_TAG, "DefaultEnvManagerApi init");
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public EnvConfig getEnvConfig() {
        return new EnvConfig(null, null, false, null, 15, null);
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public GeckoConfig getGeckoConfig() {
        return new GeckoConfig(null, null, 3, null);
    }

    @Override // com.bytedance.env.api.EnvManagerApi
    public void openDialog(Activity activity) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
