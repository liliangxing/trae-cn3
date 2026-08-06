package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.scene.data.SceneQueryInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SceneManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/SceneInfoCollection;", "", "sceneFingerprint", "Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "queryInfo", "Lcom/bytedance/android/anniex/scene/data/SceneQueryInfo;", "(Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;Lcom/bytedance/android/anniex/scene/data/SceneQueryInfo;)V", "getQueryInfo", "()Lcom/bytedance/android/anniex/scene/data/SceneQueryInfo;", "getSceneFingerprint", "()Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final /* data */ class SceneInfoCollection {
    private final SceneQueryInfo queryInfo;
    private final SceneFingerprint sceneFingerprint;

    public static /* synthetic */ SceneInfoCollection copy$default(SceneInfoCollection sceneInfoCollection, SceneFingerprint sceneFingerprint, SceneQueryInfo sceneQueryInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            sceneFingerprint = sceneInfoCollection.sceneFingerprint;
        }
        if ((i & 2) != 0) {
            sceneQueryInfo = sceneInfoCollection.queryInfo;
        }
        return sceneInfoCollection.copy(sceneFingerprint, sceneQueryInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final SceneFingerprint getSceneFingerprint() {
        return this.sceneFingerprint;
    }

    /* renamed from: component2, reason: from getter */
    public final SceneQueryInfo getQueryInfo() {
        return this.queryInfo;
    }

    public final SceneInfoCollection copy(SceneFingerprint sceneFingerprint, SceneQueryInfo queryInfo) {
        Intrinsics.checkNotNullParameter(sceneFingerprint, "sceneFingerprint");
        Intrinsics.checkNotNullParameter(queryInfo, "queryInfo");
        return new SceneInfoCollection(sceneFingerprint, queryInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SceneInfoCollection)) {
            return false;
        }
        SceneInfoCollection sceneInfoCollection = (SceneInfoCollection) other;
        return Intrinsics.areEqual(this.sceneFingerprint, sceneInfoCollection.sceneFingerprint) && Intrinsics.areEqual(this.queryInfo, sceneInfoCollection.queryInfo);
    }

    public int hashCode() {
        return (this.sceneFingerprint.hashCode() * 31) + this.queryInfo.hashCode();
    }

    public String toString() {
        return "SceneInfoCollection(sceneFingerprint=" + this.sceneFingerprint + ", queryInfo=" + this.queryInfo + ')';
    }

    public SceneInfoCollection(SceneFingerprint sceneFingerprint, SceneQueryInfo sceneQueryInfo) {
        Intrinsics.checkNotNullParameter(sceneFingerprint, "sceneFingerprint");
        Intrinsics.checkNotNullParameter(sceneQueryInfo, "queryInfo");
        this.sceneFingerprint = sceneFingerprint;
        this.queryInfo = sceneQueryInfo;
    }

    public final SceneQueryInfo getQueryInfo() {
        return this.queryInfo;
    }

    public final SceneFingerprint getSceneFingerprint() {
        return this.sceneFingerprint;
    }
}
