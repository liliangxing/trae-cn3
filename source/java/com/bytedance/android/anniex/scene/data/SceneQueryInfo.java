package com.bytedance.android.anniex.scene.data;

import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SceneDbManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J!\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032 \b\u0002\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/anniex/scene/data/SceneQueryInfo;", "", "currentCount", "", SceneDbContract.Transitions.TABLE_NAME, "", "", "Lkotlin/Pair;", "", "(ILjava/util/Map;)V", "getCurrentCount", "()I", "getTransitions", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SceneQueryInfo {
    private final int currentCount;
    private final Map<String, Pair<Integer, Double>> transitions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SceneQueryInfo copy$default(SceneQueryInfo sceneQueryInfo, int i, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sceneQueryInfo.currentCount;
        }
        if ((i2 & 2) != 0) {
            map = sceneQueryInfo.transitions;
        }
        return sceneQueryInfo.copy(i, map);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCurrentCount() {
        return this.currentCount;
    }

    public final Map<String, Pair<Integer, Double>> component2() {
        return this.transitions;
    }

    public final SceneQueryInfo copy(int currentCount, Map<String, Pair<Integer, Double>> transitions) {
        Intrinsics.checkNotNullParameter(transitions, "transitions");
        return new SceneQueryInfo(currentCount, transitions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SceneQueryInfo)) {
            return false;
        }
        SceneQueryInfo sceneQueryInfo = (SceneQueryInfo) other;
        return this.currentCount == sceneQueryInfo.currentCount && Intrinsics.areEqual(this.transitions, sceneQueryInfo.transitions);
    }

    public int hashCode() {
        return (Integer.hashCode(this.currentCount) * 31) + this.transitions.hashCode();
    }

    public String toString() {
        return "SceneQueryInfo(currentCount=" + this.currentCount + ", transitions=" + this.transitions + ')';
    }

    public SceneQueryInfo(int i, Map<String, Pair<Integer, Double>> transitions) {
        Intrinsics.checkNotNullParameter(transitions, "transitions");
        this.currentCount = i;
        this.transitions = transitions;
    }

    public final int getCurrentCount() {
        return this.currentCount;
    }

    public final Map<String, Pair<Integer, Double>> getTransitions() {
        return this.transitions;
    }
}
