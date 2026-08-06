package com.bytedance.timonbase.cache;

import com.bytedance.timon.foundation.TimonFoundation;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMInjection;
import com.bytedance.timonbase.network.Settings;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMCacheService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u001fJ\u001a\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u001aJ\u0016\u0010&\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001cJ\u0016\u0010'\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0006J\u0016\u0010(\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001fJ\u0016\u0010)\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lcom/bytedance/timonbase/cache/TMCacheService;", "", "()V", "ITEM_KEY_CONFIG", "", "MODE_MULTI_PROCESS", "", "MODE_SINGLE_PROCESS", "REPO_NAME", "TAG", "repo", "Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", "getRepo", "()Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", "repo$delegate", "Lkotlin/Lazy;", "validMark", "getValidMark", "()Ljava/lang/String;", "setValidMark", "(Ljava/lang/String;)V", "getBoolean", "", "key", "defaultValue", "getConfig", "Lcom/bytedance/timonbase/network/Settings;", "getFloat", "", "getInt", "getLong", "", "getString", "putBoolean", "", "value", "putConfig", "config", "putFloat", "putInt", "putLong", "putString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMCacheService {
    private static final String ITEM_KEY_CONFIG = "item_config";
    public static final int MODE_MULTI_PROCESS = 1;
    public static final int MODE_SINGLE_PROCESS = 0;
    private static final String REPO_NAME = "timon_cache_repo";
    private static final String TAG = "TMCacheService";
    private static String validMark;
    public static final TMCacheService INSTANCE = new TMCacheService();

    /* renamed from: repo$delegate, reason: from kotlin metadata */
    private static final Lazy repo = LazyKt.lazy(new Function0<IStoreRepo>() { // from class: com.bytedance.timonbase.cache.TMCacheService$repo$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IStoreRepo m1048invoke() {
            return TimonFoundation.INSTANCE.getKvStore().getRepo(TMEnv.INSTANCE.getApplication(), "timon_cache_repo", 1);
        }
    });

    private final IStoreRepo getRepo() {
        return (IStoreRepo) repo.getValue();
    }

    private TMCacheService() {
    }

    public final String getValidMark() {
        return validMark;
    }

    public final void setValidMark(String str) {
        validMark = str;
    }

    public final void putBoolean(String key, boolean value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        getRepo().putBoolean(key, value);
    }

    public final void putInt(String key, int value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        getRepo().putInt(key, value);
    }

    public final void putFloat(String key, float value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        getRepo().putFloat(key, value);
    }

    public final void putString(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        getRepo().putString(key, value);
    }

    public final void putLong(String key, long value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        getRepo().putLong(key, value);
    }

    public final int getInt(String key, int defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return getRepo().getInt(key, defaultValue);
    }

    public final boolean getBoolean(String key, boolean defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return getRepo().getBoolean(key, defaultValue);
    }

    public final long getLong(String key, long defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return getRepo().getLong(key, defaultValue);
    }

    public final String getString(String key, String defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return getRepo().getString(key, defaultValue);
    }

    public final float getFloat(String key, float defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return getRepo().getFloat(key, defaultValue);
    }

    public final Settings getConfig() {
        String string = getRepo().getString(ITEM_KEY_CONFIG, null);
        if (string == null) {
            return null;
        }
        Settings settings = (Settings) TMInjection.INSTANCE.getGson().fromJson(string, Settings.class);
        if (validMark == null || !(!Intrinsics.areEqual(settings.getValidMark(), validMark))) {
            return settings;
        }
        return null;
    }

    public final void putConfig(Settings config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        IStoreRepo repo2 = getRepo();
        String json = TMInjection.INSTANCE.getGson().toJson(Settings.copy$default(config, null, validMark, 1, null));
        Intrinsics.checkExpressionValueIsNotNull(json, "TMInjection.gson.toJson(…y(validMark = validMark))");
        repo2.putString(ITEM_KEY_CONFIG, json);
    }
}
