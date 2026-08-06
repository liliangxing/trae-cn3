package com.bytedance.trae.conversation.chat.block.renderer.ref;

import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: TraeRefModels.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000eHÖ\u0001J\t\u0010\u001b\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;", "", "sources", "", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;", "<init>", "(Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "primaryHost", "", "getPrimaryHost", "()Ljava/lang/String;", "extraCount", "", "getExtraCount", "()I", "displayText", "getDisplayText", "isSingle", "", "()Z", "component1", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TraeRefGroup {
    private final List<TraeRefSource> sources;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TraeRefGroup copy$default(TraeRefGroup traeRefGroup, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = traeRefGroup.sources;
        }
        return traeRefGroup.copy(list);
    }

    public final List<TraeRefSource> component1() {
        return this.sources;
    }

    public final TraeRefGroup copy(List<TraeRefSource> sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        return new TraeRefGroup(sources);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TraeRefGroup) && Intrinsics.areEqual(this.sources, ((TraeRefGroup) other).sources);
    }

    public int hashCode() {
        return this.sources.hashCode();
    }

    public String toString() {
        return "TraeRefGroup(sources=" + this.sources + ')';
    }

    public TraeRefGroup(List<TraeRefSource> sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        this.sources = sources;
    }

    public final List<TraeRefSource> getSources() {
        return this.sources;
    }

    public final String getPrimaryHost() {
        TraeRefSource traeRefSource = (TraeRefSource) CollectionsKt.firstOrNull((List) this.sources);
        String host = traeRefSource != null ? traeRefSource.getHost() : null;
        return host == null ? "" : host;
    }

    public final int getExtraCount() {
        return RangesKt.coerceAtLeast(this.sources.size() - 1, 0);
    }

    public final String getDisplayText() {
        return getExtraCount() > 0 ? getPrimaryHost() + '+' + getExtraCount() : getPrimaryHost();
    }

    public final boolean isSingle() {
        return this.sources.size() == 1;
    }
}
