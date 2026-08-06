package com.bytedance.android.anniex.scene.core;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecentSceneLruCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/RecentSceneLruCache;", "Landroid/util/LruCache;", "", "Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "maxSize", "", "(I)V", "lastKey", "addSceneFingerprint", "", "sceneFingerprint", "getRecent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RecentSceneLruCache extends LruCache<String, SceneFingerprint> {
    private String lastKey;

    public RecentSceneLruCache(int i) {
        super(i);
    }

    public final void addSceneFingerprint(SceneFingerprint sceneFingerprint) {
        Intrinsics.checkNotNullParameter(sceneFingerprint, "sceneFingerprint");
        this.lastKey = sceneFingerprint.getSceneId();
        put(sceneFingerprint.getSceneId(), sceneFingerprint);
    }

    public final SceneFingerprint getRecent() {
        String str = this.lastKey;
        if (str != null) {
            return get(str);
        }
        return null;
    }
}
