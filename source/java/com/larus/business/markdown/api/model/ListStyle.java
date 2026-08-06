package com.larus.business.markdown.api.model;

import com.bytedance.forest.model.PreloadConfig;
import com.larus.business.markdown.api.model.ListSymbolStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListStyle.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/api/model/ListStyle;", "", "symbolStrategy", "Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "enableListInLooseListMargin", "", "(Lcom/larus/business/markdown/api/model/ListSymbolStrategy;Z)V", "getEnableListInLooseListMargin", "()Z", "getSymbolStrategy", "()Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "component1", "component2", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class ListStyle {
    private final boolean enableListInLooseListMargin;
    private final ListSymbolStrategy symbolStrategy;

    /* JADX WARN: Multi-variable type inference failed */
    public ListStyle() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ListStyle copy$default(ListStyle listStyle, ListSymbolStrategy listSymbolStrategy, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            listSymbolStrategy = listStyle.symbolStrategy;
        }
        if ((i & 2) != 0) {
            z = listStyle.enableListInLooseListMargin;
        }
        return listStyle.copy(listSymbolStrategy, z);
    }

    /* renamed from: component1, reason: from getter */
    public final ListSymbolStrategy getSymbolStrategy() {
        return this.symbolStrategy;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnableListInLooseListMargin() {
        return this.enableListInLooseListMargin;
    }

    public final ListStyle copy(ListSymbolStrategy symbolStrategy, boolean enableListInLooseListMargin) {
        Intrinsics.checkNotNullParameter(symbolStrategy, "symbolStrategy");
        return new ListStyle(symbolStrategy, enableListInLooseListMargin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListStyle)) {
            return false;
        }
        ListStyle listStyle = (ListStyle) other;
        return Intrinsics.areEqual(this.symbolStrategy, listStyle.symbolStrategy) && this.enableListInLooseListMargin == listStyle.enableListInLooseListMargin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.symbolStrategy.hashCode() * 31;
        boolean z = this.enableListInLooseListMargin;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "ListStyle(symbolStrategy=" + this.symbolStrategy + ", enableListInLooseListMargin=" + this.enableListInLooseListMargin + ')';
    }

    public ListStyle(ListSymbolStrategy symbolStrategy, boolean z) {
        Intrinsics.checkNotNullParameter(symbolStrategy, "symbolStrategy");
        this.symbolStrategy = symbolStrategy;
        this.enableListInLooseListMargin = z;
    }

    public /* synthetic */ ListStyle(ListSymbolStrategy.FlowSymbolStrategy flowSymbolStrategy, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ListSymbolStrategy.FlowSymbolStrategy() : flowSymbolStrategy, (i & 2) != 0 ? false : z);
    }

    public final ListSymbolStrategy getSymbolStrategy() {
        return this.symbolStrategy;
    }

    public final boolean getEnableListInLooseListMargin() {
        return this.enableListInLooseListMargin;
    }
}
