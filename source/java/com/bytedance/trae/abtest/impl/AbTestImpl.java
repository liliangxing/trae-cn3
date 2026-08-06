package com.bytedance.trae.abtest.impl;

import com.bytedance.dataplatform.ExperimentManager;
import com.larus.abtest.api.IAbTest;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: AbTestImpl.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J1\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00142\u0006\u0010\u0015\u001a\u0002H\u0012H\u0016¢\u0006\u0002\u0010\u0016J9\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00142\u0006\u0010\u0015\u001a\u0002H\u00122\u0006\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0018JA\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00142\u0006\u0010\u0015\u001a\u0002H\u00122\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0007H\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/abtest/impl/AbTestImpl;", "Lcom/larus/abtest/api/IAbTest;", "<init>", "()V", "isInit", "", "refresh", "", "getUserVids", "", "uid", "updateUserId", "userId", "getLibraExperimentCache", "Lorg/json/JSONObject;", "getExposureInfo", "key", "getExperimentValue", "T", "tClass", "Ljava/lang/Class;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "withExposure", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;Z)Ljava/lang/Object;", "isSticky", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;ZZ)Ljava/lang/Object;", "testABTestExperimentFetch", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AbTestImpl implements IAbTest {
    private static final String TAG = "AbTestImpl";

    public String getUserVids() {
        return "";
    }

    public void testABTestExperimentFetch() {
    }

    public boolean isInit() {
        return ExperimentManager.isInit();
    }

    public void refresh() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AbTestImpl$refresh$1(null), 3, (Object) null);
    }

    public String getUserVids(String uid) {
        String str = uid;
        return str == null || str.length() == 0 ? "" : ExperimentManager.getUserVids(uid);
    }

    public void updateUserId(String userId) {
        String str = userId;
        if (str == null || str.length() == 0) {
            return;
        }
        ExperimentManager.updateUserId(userId);
    }

    public JSONObject getLibraExperimentCache() {
        return ExperimentManager.getLibraExperimentCache();
    }

    public String getExposureInfo(String key) {
        if (key != null) {
            return ExperimentManager.getExposureInfo(key);
        }
        return null;
    }

    public <T> T getExperimentValue(String key, Class<T> tClass, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        return (T) getExperimentValue(key, tClass, defaultValue, true);
    }

    public <T> T getExperimentValue(String key, Class<T> tClass, T defaultValue, boolean withExposure) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        return (T) getExperimentValue(key, tClass, defaultValue, false, withExposure);
    }

    public <T> T getExperimentValue(String key, Class<T> tClass, T defaultValue, boolean isSticky, boolean withExposure) {
        T t;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(tClass, "tClass");
        return (ExperimentManager.isInit() && (t = (T) ExperimentManager.getExperimentValue(key, tClass, defaultValue, isSticky, withExposure)) != null) ? t : defaultValue;
    }
}
