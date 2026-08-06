package com.larus.business.markdown.api.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThematicBreakConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "", "height", "", "bgColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBgColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class ThematicBreakConfig {
    private final Integer bgColor;
    private final Integer height;

    /* JADX WARN: Multi-variable type inference failed */
    public ThematicBreakConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ThematicBreakConfig copy$default(ThematicBreakConfig thematicBreakConfig, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = thematicBreakConfig.height;
        }
        if ((i & 2) != 0) {
            num2 = thematicBreakConfig.bgColor;
        }
        return thematicBreakConfig.copy(num, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getBgColor() {
        return this.bgColor;
    }

    public final ThematicBreakConfig copy(Integer height, Integer bgColor) {
        return new ThematicBreakConfig(height, bgColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThematicBreakConfig)) {
            return false;
        }
        ThematicBreakConfig thematicBreakConfig = (ThematicBreakConfig) other;
        return Intrinsics.areEqual(this.height, thematicBreakConfig.height) && Intrinsics.areEqual(this.bgColor, thematicBreakConfig.bgColor);
    }

    public int hashCode() {
        Integer num = this.height;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.bgColor;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "ThematicBreakConfig(height=" + this.height + ", bgColor=" + this.bgColor + ')';
    }

    public ThematicBreakConfig(Integer num, Integer num2) {
        this.height = num;
        this.bgColor = num2;
    }

    public /* synthetic */ ThematicBreakConfig(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getBgColor() {
        return this.bgColor;
    }
}
