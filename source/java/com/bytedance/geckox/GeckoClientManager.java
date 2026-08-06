package com.bytedance.geckox;

import com.bytedance.geckox.GeckoConfig;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoClientManager.kt */
@Deprecated(message = "废弃，请求更新使用GeckoKit.updateResource代替")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/geckox/GeckoClientManager;", "", "()V", "geckoClientRegister", "", "", "Lcom/bytedance/geckox/GeckoClient;", "getGeckoClientFromRegister", "accessKey", "registerGeckoClient", "", "client", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoClientManager {
    public static final GeckoClientManager INSTANCE = new GeckoClientManager();
    private static final Map<String, GeckoClient> geckoClientRegister = new ConcurrentHashMap();

    private GeckoClientManager() {
    }

    public final void registerGeckoClient(String accessKey, GeckoClient client) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(client, "client");
        Map<String, GeckoClient> map = geckoClientRegister;
        if (map.get(accessKey) == null) {
            map.put(accessKey, client);
        }
    }

    public final GeckoClient getGeckoClientFromRegister(String accessKey) {
        Object obj;
        if (accessKey == null) {
            return null;
        }
        Map<String, GeckoClient> map = geckoClientRegister;
        if (map.get(accessKey) != null) {
            return map.get(accessKey);
        }
        try {
            Result.Companion companion = Result.Companion;
            GeckoGlobalManager inst = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
            Map<String, String> accessKeyDirs = inst.getAccessKeyDirs();
            GeckoGlobalManager inst2 = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst2, "GeckoGlobalManager.inst()");
            GeckoGlobalConfig globalConfig = inst2.getGlobalConfig();
            obj = Result.constructor-impl((globalConfig == null || !accessKeyDirs.containsKey(accessKey)) ? null : GeckoClient.create(new GeckoConfig.Builder(globalConfig.getContext()).appId(globalConfig.getAppId()).deviceId(globalConfig.getDeviceId()).host(globalConfig.getHost()).accessKey(accessKey).resRootDir(new File(accessKeyDirs.get(accessKey))).build()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (GeckoClient) (Result.isFailure-impl(obj) ? null : obj);
    }
}
