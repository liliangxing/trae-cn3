package com.larus.business.markdown.api.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/api/model/ListConfig;", "", "orderedListItemColor", "", "bulletListItemColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBulletListItemColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOrderedListItemColor", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/ListConfig;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class ListConfig {
    private final Integer bulletListItemColor;
    private final Integer orderedListItemColor;

    /* JADX WARN: Multi-variable type inference failed */
    public ListConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ListConfig copy$default(ListConfig listConfig, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = listConfig.orderedListItemColor;
        }
        if ((i & 2) != 0) {
            num2 = listConfig.bulletListItemColor;
        }
        return listConfig.copy(num, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getOrderedListItemColor() {
        return this.orderedListItemColor;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getBulletListItemColor() {
        return this.bulletListItemColor;
    }

    public final ListConfig copy(Integer orderedListItemColor, Integer bulletListItemColor) {
        return new ListConfig(orderedListItemColor, bulletListItemColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListConfig)) {
            return false;
        }
        ListConfig listConfig = (ListConfig) other;
        return Intrinsics.areEqual(this.orderedListItemColor, listConfig.orderedListItemColor) && Intrinsics.areEqual(this.bulletListItemColor, listConfig.bulletListItemColor);
    }

    public int hashCode() {
        Integer num = this.orderedListItemColor;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.bulletListItemColor;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "ListConfig(orderedListItemColor=" + this.orderedListItemColor + ", bulletListItemColor=" + this.bulletListItemColor + ')';
    }

    public ListConfig(Integer num, Integer num2) {
        this.orderedListItemColor = num;
        this.bulletListItemColor = num2;
    }

    public /* synthetic */ ListConfig(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public final Integer getOrderedListItemColor() {
        return this.orderedListItemColor;
    }

    public final Integer getBulletListItemColor() {
        return this.bulletListItemColor;
    }
}
