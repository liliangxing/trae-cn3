package com.bytedance.android.anniex.scene.core;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BehaviorModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\tJ$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0006J\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\t0\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/BehaviorModel;", "", "()V", "sceneFrequency", "", "", "", "transitionMatrix", "getSceneFrequency", "", "getTopTransitions", "from", "limit", "getTransitions", "recordScene", "", "scene", "Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "recordTransition", "to", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class BehaviorModel {
    private final Map<String, Integer> sceneFrequency = new LinkedHashMap();
    private final Map<String, Map<String, Integer>> transitionMatrix = new LinkedHashMap();

    public final void recordScene(SceneFingerprint scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        String sceneId = scene.getSceneId();
        Map<String, Integer> map = this.sceneFrequency;
        map.put(sceneId, Integer.valueOf(map.getOrDefault(sceneId, 0).intValue() + 1));
        System.out.println((Object) ("📊 行为模型记录场景：" + sceneId + " 次数=" + this.sceneFrequency.get(sceneId)));
    }

    public final void recordTransition(String from, String to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Map<String, Map<String, Integer>> map = this.transitionMatrix;
        LinkedHashMap linkedHashMap = map.get(from);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            map.put(from, linkedHashMap);
        }
        Map<String, Integer> map2 = linkedHashMap;
        map2.put(to, Integer.valueOf(map2.getOrDefault(to, 0).intValue() + 1));
        System.out.println((Object) ("🔁 行为模型记录跳转：" + from + " → " + to + " 次数=" + map2.get(to)));
    }

    public static /* synthetic */ Map getTopTransitions$default(BehaviorModel behaviorModel, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 5;
        }
        return behaviorModel.getTopTransitions(str, i);
    }

    public final Map<String, Integer> getTopTransitions(String from, int limit) {
        List list;
        List sortedWith;
        List take;
        Map<String, Integer> map;
        Intrinsics.checkNotNullParameter(from, "from");
        Map<String, Integer> map2 = this.transitionMatrix.get(from);
        return (map2 == null || (list = MapsKt.toList(map2)) == null || (sortedWith = CollectionsKt.sortedWith(list, new Comparator<T>() { // from class: com.bytedance.android.anniex.scene.core.BehaviorModel$getTopTransitions$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) ((Pair) t2).getSecond(), (Integer) ((Pair) t).getSecond());
            }
        })) == null || (take = CollectionsKt.take(sortedWith, limit)) == null || (map = MapsKt.toMap(take)) == null) ? MapsKt.emptyMap() : map;
    }

    public final Map<String, Integer> getSceneFrequency() {
        return this.sceneFrequency;
    }

    public final Map<String, Map<String, Integer>> getTransitions() {
        return this.transitionMatrix;
    }
}
