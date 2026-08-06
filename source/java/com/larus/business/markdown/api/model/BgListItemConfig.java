package com.larus.business.markdown.api.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomMarkDownInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/api/model/BgListItemConfig;", "", "bgColor", "", "bgMargin", "bgRadius", "", "leading", "(IILjava/lang/Float;Ljava/lang/Integer;)V", "getBgColor", "()I", "getBgMargin", "getBgRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLeading", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Float;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/BgListItemConfig;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class BgListItemConfig {
    private final int bgColor;
    private final int bgMargin;
    private final Float bgRadius;
    private final Integer leading;

    public static /* synthetic */ BgListItemConfig copy$default(BgListItemConfig bgListItemConfig, int i, int i2, Float f, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bgListItemConfig.bgColor;
        }
        if ((i3 & 2) != 0) {
            i2 = bgListItemConfig.bgMargin;
        }
        if ((i3 & 4) != 0) {
            f = bgListItemConfig.bgRadius;
        }
        if ((i3 & 8) != 0) {
            num = bgListItemConfig.leading;
        }
        return bgListItemConfig.copy(i, i2, f, num);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBgColor() {
        return this.bgColor;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBgMargin() {
        return this.bgMargin;
    }

    /* renamed from: component3, reason: from getter */
    public final Float getBgRadius() {
        return this.bgRadius;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getLeading() {
        return this.leading;
    }

    public final BgListItemConfig copy(int bgColor, int bgMargin, Float bgRadius, Integer leading) {
        return new BgListItemConfig(bgColor, bgMargin, bgRadius, leading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BgListItemConfig)) {
            return false;
        }
        BgListItemConfig bgListItemConfig = (BgListItemConfig) other;
        return this.bgColor == bgListItemConfig.bgColor && this.bgMargin == bgListItemConfig.bgMargin && Intrinsics.areEqual((Object) this.bgRadius, (Object) bgListItemConfig.bgRadius) && Intrinsics.areEqual(this.leading, bgListItemConfig.leading);
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.bgColor) * 31) + Integer.hashCode(this.bgMargin)) * 31;
        Float f = this.bgRadius;
        int hashCode2 = (hashCode + (f == null ? 0 : f.hashCode())) * 31;
        Integer num = this.leading;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "BgListItemConfig(bgColor=" + this.bgColor + ", bgMargin=" + this.bgMargin + ", bgRadius=" + this.bgRadius + ", leading=" + this.leading + ')';
    }

    public BgListItemConfig(int i, int i2, Float f, Integer num) {
        this.bgColor = i;
        this.bgMargin = i2;
        this.bgRadius = f;
        this.leading = num;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getBgMargin() {
        return this.bgMargin;
    }

    public /* synthetic */ BgListItemConfig(int i, int i2, Float f, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? Float.valueOf(0.0f) : f, (i3 & 8) != 0 ? 0 : num);
    }

    public final Float getBgRadius() {
        return this.bgRadius;
    }

    public final Integer getLeading() {
        return this.leading;
    }
}
