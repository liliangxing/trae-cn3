package com.bytedance.android.live.core.setting.v2.vo;

import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheSettingVo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0001HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/vo/CacheSettingVo;", "", "scene", "Lcom/bytedance/android/live/core/setting/v2/update/SettingIncStrategy$IncScene;", "key", "", "value", "(Lcom/bytedance/android/live/core/setting/v2/update/SettingIncStrategy$IncScene;Ljava/lang/String;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/String;", "getScene", "()Lcom/bytedance/android/live/core/setting/v2/update/SettingIncStrategy$IncScene;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final /* data */ class CacheSettingVo {
    private final String key;
    private final SettingIncStrategy.IncScene scene;
    private final Object value;

    public static /* synthetic */ CacheSettingVo copy$default(CacheSettingVo cacheSettingVo, SettingIncStrategy.IncScene incScene, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            incScene = cacheSettingVo.scene;
        }
        if ((i & 2) != 0) {
            str = cacheSettingVo.key;
        }
        if ((i & 4) != 0) {
            obj = cacheSettingVo.value;
        }
        return cacheSettingVo.copy(incScene, str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final SettingIncStrategy.IncScene getScene() {
        return this.scene;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component3, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    public final CacheSettingVo copy(SettingIncStrategy.IncScene scene, String key, Object value) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return new CacheSettingVo(scene, key, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheSettingVo)) {
            return false;
        }
        CacheSettingVo cacheSettingVo = (CacheSettingVo) other;
        return Intrinsics.areEqual(this.scene, cacheSettingVo.scene) && Intrinsics.areEqual(this.key, cacheSettingVo.key) && Intrinsics.areEqual(this.value, cacheSettingVo.value);
    }

    public int hashCode() {
        SettingIncStrategy.IncScene incScene = this.scene;
        int hashCode = (incScene != null ? incScene.hashCode() : 0) * 31;
        String str = this.key;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Object obj = this.value;
        return hashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "CacheSettingVo(scene=" + this.scene + ", key=" + this.key + ", value=" + this.value + ")";
    }

    public CacheSettingVo(SettingIncStrategy.IncScene scene, String key, Object value) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.scene = scene;
        this.key = key;
        this.value = value;
    }

    public final SettingIncStrategy.IncScene getScene() {
        return this.scene;
    }

    public final String getKey() {
        return this.key;
    }

    public final Object getValue() {
        return this.value;
    }
}
