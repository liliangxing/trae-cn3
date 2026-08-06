package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.android.anniex.scene.utils.CompressionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SceneFingerprint.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u00011BU\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000e0\r¢\u0006\u0002\u0010\u000fJ$\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020-\u0018\u00010\u000eJ\u000e\u00100\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u001dR)\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00062"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "", "sceneId", "", "aViewUrls", "", "Lcom/bytedance/android/anniex/scene/core/ViewAttachEvent;", SceneDbContract.Scenes.COLUMN_TIMESTAMP, "", SceneDbContract.Scenes.COLUMN_ORIGIN, "Lcom/bytedance/android/anniex/scene/core/SceneOrigin;", "attachScene", "features", "", "", "(Ljava/lang/String;Ljava/util/Set;JLcom/bytedance/android/anniex/scene/core/SceneOrigin;Ljava/lang/String;Ljava/util/Map;)V", "getAViewUrls", "()Ljava/util/Set;", "getAttachScene", "()Ljava/lang/String;", "bcmChain", "Lorg/json/JSONObject;", "getBcmChain", "()Lorg/json/JSONObject;", "setBcmChain", "(Lorg/json/JSONObject;)V", "clientComponent", "getClientComponent", "setClientComponent", "(Ljava/lang/String;)V", "getFeatures", "()Ljava/util/Map;", "getOrigin", "()Lcom/bytedance/android/anniex/scene/core/SceneOrigin;", "getSceneId", "getTimestamp", "()J", "viewCount", "", "getViewCount", "()Ljava/lang/Integer;", "setViewCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cosine", "", "other", "weights", "jaccard", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SceneFingerprint {
    private final Set<ViewAttachEvent> aViewUrls;
    private final String attachScene;
    private JSONObject bcmChain;
    private String clientComponent;
    private final Map<String, Map<String, Object>> features;
    private final SceneOrigin origin;
    private final String sceneId;
    private final long timestamp;
    private Integer viewCount;

    public /* synthetic */ SceneFingerprint(String str, Set set, long j, SceneOrigin sceneOrigin, String str2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, set, j, sceneOrigin, str2, map);
    }

    private SceneFingerprint(String str, Set<ViewAttachEvent> set, long j, SceneOrigin sceneOrigin, String str2, Map<String, Map<String, Object>> map) {
        this.sceneId = str;
        this.aViewUrls = set;
        this.timestamp = j;
        this.origin = sceneOrigin;
        this.attachScene = str2;
        this.features = map;
        this.viewCount = 0;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final Set<ViewAttachEvent> getAViewUrls() {
        return this.aViewUrls;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final SceneOrigin getOrigin() {
        return this.origin;
    }

    public final String getAttachScene() {
        return this.attachScene;
    }

    public final Map<String, Map<String, Object>> getFeatures() {
        return this.features;
    }

    public final String getClientComponent() {
        return this.clientComponent;
    }

    public final void setClientComponent(String str) {
        this.clientComponent = str;
    }

    public final Integer getViewCount() {
        return this.viewCount;
    }

    public final void setViewCount(Integer num) {
        this.viewCount = num;
    }

    public final JSONObject getBcmChain() {
        return this.bcmChain;
    }

    public final void setBcmChain(JSONObject jSONObject) {
        this.bcmChain = jSONObject;
    }

    /* compiled from: SceneFingerprint.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\"\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0010J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\nH\u0007J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/SceneFingerprint$Builder;", "", "aViewUrls", "", "Lcom/bytedance/android/anniex/scene/core/ViewAttachEvent;", SceneDbContract.Scenes.COLUMN_TIMESTAMP, "", SceneDbContract.Scenes.COLUMN_ORIGIN, "Lcom/bytedance/android/anniex/scene/core/SceneOrigin;", "attachScene", "", "(Ljava/util/Set;JLcom/bytedance/android/anniex/scene/core/SceneOrigin;Ljava/lang/String;)V", "bcmChain", "Lorg/json/JSONObject;", "bizFeatures", "", "", "clientComponent", "sceneId", "viewCount", "", "addFeature", "key", StrategyConstants.VALUE, "build", "Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "encodeUrls", "eventName", "setBcmChain", "setClientComponent", "setViewCount", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Builder {
        private final Set<ViewAttachEvent> aViewUrls;
        private final String attachScene;
        private JSONObject bcmChain;
        private Map<String, Map<String, Object>> bizFeatures;
        private String clientComponent;
        private final SceneOrigin origin;
        private String sceneId;
        private final long timestamp;
        private int viewCount;

        public Builder(Set<ViewAttachEvent> set, long j, SceneOrigin sceneOrigin, String str) {
            Intrinsics.checkNotNullParameter(set, "aViewUrls");
            Intrinsics.checkNotNullParameter(sceneOrigin, SceneDbContract.Scenes.COLUMN_ORIGIN);
            Intrinsics.checkNotNullParameter(str, "attachScene");
            this.aViewUrls = set;
            this.timestamp = j;
            this.origin = sceneOrigin;
            this.attachScene = str;
            this.bizFeatures = new LinkedHashMap();
            this.clientComponent = "";
        }

        public final Builder addFeature(String key, Map<String, ? extends Object> value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, StrategyConstants.VALUE);
            this.bizFeatures.put(key, value);
            return this;
        }

        public final Builder setClientComponent(String clientComponent) {
            Intrinsics.checkNotNullParameter(clientComponent, "clientComponent");
            this.clientComponent = clientComponent;
            return this;
        }

        public final Builder setBcmChain(JSONObject bcmChain) {
            Intrinsics.checkNotNullParameter(bcmChain, "bcmChain");
            this.bcmChain = bcmChain;
            return this;
        }

        public final Builder setViewCount(int viewCount) {
            this.viewCount = viewCount;
            return this;
        }

        public final Builder sceneId(String eventName) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            this.sceneId = CompressionUtils.INSTANCE.compressSceneId(eventName);
            return this;
        }

        public final String encodeUrls() {
            return CompressionUtils.INSTANCE.compressSceneId(CollectionsKt.joinToString$default(this.aViewUrls, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<ViewAttachEvent, CharSequence>() { // from class: com.bytedance.android.anniex.scene.core.SceneFingerprint$Builder$encodeUrls$1
                public final CharSequence invoke(ViewAttachEvent viewAttachEvent) {
                    Intrinsics.checkNotNullParameter(viewAttachEvent, "it");
                    return viewAttachEvent.getUrl();
                }
            }, 30, (Object) null));
        }

        public final SceneFingerprint build() {
            String str = this.sceneId;
            if (str == null) {
                str = encodeUrls();
            }
            SceneFingerprint sceneFingerprint = new SceneFingerprint(str, this.aViewUrls, this.timestamp, this.origin, this.attachScene, this.bizFeatures, null);
            sceneFingerprint.setClientComponent(this.clientComponent);
            sceneFingerprint.setViewCount(Integer.valueOf(this.viewCount));
            sceneFingerprint.setBcmChain(this.bcmChain);
            return sceneFingerprint;
        }
    }

    public final double jaccard(SceneFingerprint other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Set<ViewAttachEvent> set = this.aViewUrls;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((ViewAttachEvent) it.next()).getUrl());
        }
        Set set2 = CollectionsKt.toSet(arrayList);
        Set<ViewAttachEvent> set3 = other.aViewUrls;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set3, 10));
        Iterator<T> it2 = set3.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((ViewAttachEvent) it2.next()).getUrl());
        }
        Set set4 = set2;
        Set set5 = CollectionsKt.toSet(arrayList2);
        Set intersect = CollectionsKt.intersect(set4, set5);
        if (CollectionsKt.union(set4, set5).isEmpty()) {
            return 0.0d;
        }
        return intersect.size() / r5.size();
    }

    public final double cosine(SceneFingerprint other, Map<String, Double> weights) {
        Double d;
        Double d2;
        Intrinsics.checkNotNullParameter(other, "other");
        final Set<ViewAttachEvent> set = this.aViewUrls;
        Map eachCount = GroupingKt.eachCount(new Grouping<ViewAttachEvent, String>() { // from class: com.bytedance.android.anniex.scene.core.SceneFingerprint$cosine$$inlined$groupingBy$1
            public Iterator<ViewAttachEvent> sourceIterator() {
                return set.iterator();
            }

            public String keyOf(ViewAttachEvent element) {
                return element.getUrl();
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(eachCount.size()));
        Iterator it = eachCount.entrySet().iterator();
        while (true) {
            double d3 = 1.0d;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            String str = (String) entry.getKey();
            int intValue = ((Number) entry.getValue()).intValue();
            if (weights != null && (d2 = weights.get(str)) != null) {
                d3 = d2.doubleValue();
            }
            linkedHashMap.put(key, Double.valueOf(d3 * intValue));
        }
        final Set<ViewAttachEvent> set2 = other.aViewUrls;
        Map eachCount2 = GroupingKt.eachCount(new Grouping<ViewAttachEvent, String>() { // from class: com.bytedance.android.anniex.scene.core.SceneFingerprint$cosine$$inlined$groupingBy$2
            public Iterator<ViewAttachEvent> sourceIterator() {
                return set2.iterator();
            }

            public String keyOf(ViewAttachEvent element) {
                return element.getUrl();
            }
        });
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(eachCount2.size()));
        for (Map.Entry entry2 : eachCount2.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), Double.valueOf(((weights == null || (d = weights.get((String) entry2.getKey())) == null) ? 1.0d : d.doubleValue()) * ((Number) entry2.getValue()).intValue()));
        }
        double d4 = 0.0d;
        double d5 = 0.0d;
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            String str2 = (String) entry3.getKey();
            double doubleValue = ((Number) entry3.getValue()).doubleValue();
            Double d6 = (Double) linkedHashMap2.get(str2);
            d5 += (d6 != null ? d6.doubleValue() : 0.0d) * doubleValue;
            d4 += doubleValue * doubleValue;
        }
        Iterator it2 = linkedHashMap2.values().iterator();
        double d7 = 0.0d;
        while (it2.hasNext()) {
            double doubleValue2 = ((Number) it2.next()).doubleValue();
            d7 += doubleValue2 * doubleValue2;
        }
        if (d4 == 0.0d) {
            return 0.0d;
        }
        if (d7 == 0.0d) {
            return 0.0d;
        }
        return d5 / (Math.sqrt(d4) * Math.sqrt(d7));
    }
}
