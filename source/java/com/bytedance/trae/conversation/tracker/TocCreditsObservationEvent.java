package com.bytedance.trae.conversation.tracker;

import com.bytedance.security.android.aopcheck.reporter.Constant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TocCreditsObservation.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003JI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationEvent;", "", Constant.KEY_CHANNEL, "Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;", "name", "", "category", "", "metric", "", "<init>", "(Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getChannel", "()Lcom/bytedance/trae/conversation/tracker/TocCreditsObservationChannel;", "getName", "()Ljava/lang/String;", "getCategory", "()Ljava/util/Map;", "getMetric", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class TocCreditsObservationEvent {
    private final Map<String, Object> category;
    private final TocCreditsObservationChannel channel;
    private final Map<String, Number> metric;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TocCreditsObservationEvent copy$default(TocCreditsObservationEvent tocCreditsObservationEvent, TocCreditsObservationChannel tocCreditsObservationChannel, String str, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            tocCreditsObservationChannel = tocCreditsObservationEvent.channel;
        }
        if ((i & 2) != 0) {
            str = tocCreditsObservationEvent.name;
        }
        if ((i & 4) != 0) {
            map = tocCreditsObservationEvent.category;
        }
        if ((i & 8) != 0) {
            map2 = tocCreditsObservationEvent.metric;
        }
        return tocCreditsObservationEvent.copy(tocCreditsObservationChannel, str, map, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final TocCreditsObservationChannel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> component3() {
        return this.category;
    }

    public final Map<String, Number> component4() {
        return this.metric;
    }

    public final TocCreditsObservationEvent copy(TocCreditsObservationChannel channel, String name, Map<String, ? extends Object> category, Map<String, ? extends Number> metric) {
        Intrinsics.checkNotNullParameter(channel, Constant.KEY_CHANNEL);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(metric, "metric");
        return new TocCreditsObservationEvent(channel, name, category, metric);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TocCreditsObservationEvent)) {
            return false;
        }
        TocCreditsObservationEvent tocCreditsObservationEvent = (TocCreditsObservationEvent) other;
        return this.channel == tocCreditsObservationEvent.channel && Intrinsics.areEqual(this.name, tocCreditsObservationEvent.name) && Intrinsics.areEqual(this.category, tocCreditsObservationEvent.category) && Intrinsics.areEqual(this.metric, tocCreditsObservationEvent.metric);
    }

    public int hashCode() {
        return (((((this.channel.hashCode() * 31) + this.name.hashCode()) * 31) + this.category.hashCode()) * 31) + this.metric.hashCode();
    }

    public String toString() {
        return "TocCreditsObservationEvent(channel=" + this.channel + ", name=" + this.name + ", category=" + this.category + ", metric=" + this.metric + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TocCreditsObservationEvent(TocCreditsObservationChannel tocCreditsObservationChannel, String str, Map<String, ? extends Object> map, Map<String, ? extends Number> map2) {
        Intrinsics.checkNotNullParameter(tocCreditsObservationChannel, Constant.KEY_CHANNEL);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "category");
        Intrinsics.checkNotNullParameter(map2, "metric");
        this.channel = tocCreditsObservationChannel;
        this.name = str;
        this.category = map;
        this.metric = map2;
    }

    public final TocCreditsObservationChannel getChannel() {
        return this.channel;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getCategory() {
        return this.category;
    }

    public /* synthetic */ TocCreditsObservationEvent(TocCreditsObservationChannel tocCreditsObservationChannel, String str, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(tocCreditsObservationChannel, str, map, (i & 8) != 0 ? MapsKt.emptyMap() : map2);
    }

    public final Map<String, Number> getMetric() {
        return this.metric;
    }
}
