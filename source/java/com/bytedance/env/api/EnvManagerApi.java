package com.bytedance.env.api;

import android.app.Activity;
import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnvManagerApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH&J\b\u0010\u0014\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0015H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0015H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0015H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0015H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH&¨\u0006%"}, d2 = {"Lcom/bytedance/env/api/EnvManagerApi;", "", "addOnEnvConfigChangeListener", "", "listener", "Lcom/bytedance/env/api/OnEnvConfigChangeListener;", "getEnvConfig", "Lcom/bytedance/env/api/EnvConfig;", "getEnvLane", "", "getEnvType", "", "getGeckoConfig", "Lcom/bytedance/env/api/GeckoConfig;", "init", "context", "Landroid/content/Context;", "initEnvConfig", "config", "initGeckoConfig", "isFloatingWindowVisible", "", "openDialog", "activity", "Landroid/app/Activity;", "reboot", "removeOnEnvConfigChangeListener", "setAutoRebootEnable", "enable", "setEnvConfig", "envType", "lane", "setEnvWindowEnable", "setFloatingWindowRemovable", "setFloatingWindowVisible", "visible", "setGeckoConfig", "env_platform_api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface EnvManagerApi {
    void addOnEnvConfigChangeListener(OnEnvConfigChangeListener listener);

    EnvConfig getEnvConfig();

    String getEnvLane();

    int getEnvType();

    GeckoConfig getGeckoConfig();

    void init(Context context);

    void initEnvConfig(EnvConfig config);

    void initGeckoConfig(GeckoConfig config);

    boolean isFloatingWindowVisible();

    void openDialog(Activity activity);

    void reboot();

    void removeOnEnvConfigChangeListener(OnEnvConfigChangeListener listener);

    void setAutoRebootEnable(boolean enable);

    void setEnvConfig(int envType, String lane);

    void setEnvConfig(EnvConfig config);

    void setEnvWindowEnable(boolean enable);

    void setFloatingWindowRemovable(boolean enable);

    void setFloatingWindowVisible(boolean visible);

    void setGeckoConfig(GeckoConfig config);

    /* compiled from: EnvManagerApi.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class DefaultImpls {
        public static void setEnvConfig(EnvManagerApi envManagerApi, int i, String str) {
            Intrinsics.checkParameterIsNotNull(str, "lane");
            EnvType envType = EnvManagerApiKt.getEnvTypeMap().get(Integer.valueOf(i));
            if (envType != null) {
                envManagerApi.setEnvConfig(new EnvConfig(envType, str, false, null, 12, null));
            }
        }

        public static int getEnvType(EnvManagerApi envManagerApi) {
            EnvType env = envManagerApi.getEnvConfig().getEnv();
            for (Map.Entry<Integer, EnvType> entry : EnvManagerApiKt.getEnvTypeMap().entrySet()) {
                int intValue = entry.getKey().intValue();
                if (entry.getValue() == env) {
                    return intValue;
                }
            }
            return 0;
        }

        public static String getEnvLane(EnvManagerApi envManagerApi) {
            return envManagerApi.getEnvConfig().getLane();
        }
    }
}
