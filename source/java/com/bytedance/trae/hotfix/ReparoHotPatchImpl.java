package com.bytedance.trae.hotfix;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.reparo.IReparoConfig;
import com.bytedance.reparo.Reparo;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReparoHotPatchImpl.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;", "", "<init>", "()V", "TAG", "", "KEY_HOTFIX_REALTIME_FETCH", "VALUE_TRUE", "VALUE_FALSE", "hotPatchConfig", "Lcom/bytedance/trae/hotfix/HotPatchConfig;", "settingListenerRegistered", "", "init", "", "config", "loadRemotePatch", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReparoHotPatchImpl {
    private static boolean settingListenerRegistered;
    public static final ReparoHotPatchImpl INSTANCE = new ReparoHotPatchImpl();
    private static final String TAG = "ReparoHotPatch";
    private static final String KEY_HOTFIX_REALTIME_FETCH = "hotfix_realtime_fetch";
    private static final String VALUE_TRUE = "1";
    private static final String VALUE_FALSE = "0";
    private static final HotPatchConfig hotPatchConfig = new HotPatchConfig(AppHost.INSTANCE.getApplication());
    public static final int $stable = 8;

    private ReparoHotPatchImpl() {
    }

    public final void init() {
        init(hotPatchConfig);
    }

    public final void init(final HotPatchConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Flipped.invokeHiddenApiRestrictions();
        Reparo.getInstance().init(new IReparoConfig() { // from class: com.bytedance.trae.hotfix.ReparoHotPatchImpl$init$1
            @Override // com.bytedance.reparo.IReparoConfig
            public boolean enable() {
                return HotPatchConfig.this.enable();
            }

            @Override // com.bytedance.reparo.IReparoConfig
            public Application getApplication() {
                return HotPatchConfig.this.getApplication();
            }

            @Override // com.bytedance.reparo.IReparoConfig
            public String getUpdateVersionCode() {
                return HotPatchConfig.this.getUpdateVersionCode();
            }

            @Override // com.bytedance.reparo.IReparoConfig
            public String getAppId() {
                return HotPatchConfig.this.getAppId();
            }

            @Override // com.bytedance.reparo.IReparoConfig
            public String getDeviceId() {
                return HotPatchConfig.this.getDeviceId();
            }

            @Override // com.bytedance.reparo.IReparoConfig
            public String getChannel() {
                return HotPatchConfig.this.getChannel();
            }

            @Override // com.bytedance.reparo.IReparoConfig
            public String executePatchRequest(int maxSize, String url, byte[] localPatchInfoBytes, String contentType) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(localPatchInfoBytes, "localPatchInfoBytes");
                Intrinsics.checkNotNullParameter(contentType, "contentType");
                return HotPatchConfig.this.executePatchRequest(maxSize, url, localPatchInfoBytes, contentType);
            }

            @Override // com.bytedance.reparo.IReparoConfig
            public boolean isMainProcess() {
                return HotPatchConfig.this.isMainProcess();
            }
        });
        FLogger.INSTANCE.i(TAG, "REPARO HOTFIX INITED!");
    }

    public final void loadRemotePatch() {
        Reparo reparo = Reparo.getInstance();
        HotPatchConfig hotPatchConfig2 = hotPatchConfig;
        reparo.setRequestInterval(hotPatchConfig2.getRequestInterval());
        Reparo.getInstance().loadRemotePatch();
        hotPatchConfig2.getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.trae.hotfix.ReparoHotPatchImpl$loadRemotePatch$1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Reparo.getInstance().loadRemotePatch();
            }
        });
        FLogger.INSTANCE.i(TAG, "REPARO HOTFIX trigger loadRemotePatch!");
    }
}
