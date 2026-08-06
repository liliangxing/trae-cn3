package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeBlockSpanInfo.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jp\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u00061"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;", "", "codeBlockStartIndex", "", "codeBlockEndIndex", "titleBgColor", "cornerRadius", "", "borderWidth", "borderColor", "enableBackground", "", "scrollableInfo", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;", "numberInfo", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockLineNumberInfo;", "(Ljava/lang/Integer;Ljava/lang/Integer;IFFIZLcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockLineNumberInfo;)V", "getBorderColor", "()I", "getBorderWidth", "()F", "getCodeBlockEndIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCodeBlockStartIndex", "getCornerRadius", "getEnableBackground", "()Z", "getNumberInfo", "()Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockLineNumberInfo;", "getScrollableInfo", "()Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;", "getTitleBgColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;IFFIZLcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockLineNumberInfo;)Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class CodeBlockSpan2Info {
    private final int borderColor;
    private final float borderWidth;
    private final Integer codeBlockEndIndex;
    private final Integer codeBlockStartIndex;
    private final float cornerRadius;
    private final boolean enableBackground;
    private final CodeBlockLineNumberInfo numberInfo;
    private final CodeBlockScrollableInfo scrollableInfo;
    private final int titleBgColor;

    /* renamed from: component1, reason: from getter */
    public final Integer getCodeBlockStartIndex() {
        return this.codeBlockStartIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getCodeBlockEndIndex() {
        return this.codeBlockEndIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTitleBgColor() {
        return this.titleBgColor;
    }

    /* renamed from: component4, reason: from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* renamed from: component5, reason: from getter */
    public final float getBorderWidth() {
        return this.borderWidth;
    }

    /* renamed from: component6, reason: from getter */
    public final int getBorderColor() {
        return this.borderColor;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getEnableBackground() {
        return this.enableBackground;
    }

    /* renamed from: component8, reason: from getter */
    public final CodeBlockScrollableInfo getScrollableInfo() {
        return this.scrollableInfo;
    }

    /* renamed from: component9, reason: from getter */
    public final CodeBlockLineNumberInfo getNumberInfo() {
        return this.numberInfo;
    }

    public final CodeBlockSpan2Info copy(Integer codeBlockStartIndex, Integer codeBlockEndIndex, int titleBgColor, float cornerRadius, float borderWidth, int borderColor, boolean enableBackground, CodeBlockScrollableInfo scrollableInfo, CodeBlockLineNumberInfo numberInfo) {
        return new CodeBlockSpan2Info(codeBlockStartIndex, codeBlockEndIndex, titleBgColor, cornerRadius, borderWidth, borderColor, enableBackground, scrollableInfo, numberInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeBlockSpan2Info)) {
            return false;
        }
        CodeBlockSpan2Info codeBlockSpan2Info = (CodeBlockSpan2Info) other;
        return Intrinsics.areEqual(this.codeBlockStartIndex, codeBlockSpan2Info.codeBlockStartIndex) && Intrinsics.areEqual(this.codeBlockEndIndex, codeBlockSpan2Info.codeBlockEndIndex) && this.titleBgColor == codeBlockSpan2Info.titleBgColor && Float.compare(this.cornerRadius, codeBlockSpan2Info.cornerRadius) == 0 && Float.compare(this.borderWidth, codeBlockSpan2Info.borderWidth) == 0 && this.borderColor == codeBlockSpan2Info.borderColor && this.enableBackground == codeBlockSpan2Info.enableBackground && Intrinsics.areEqual(this.scrollableInfo, codeBlockSpan2Info.scrollableInfo) && Intrinsics.areEqual(this.numberInfo, codeBlockSpan2Info.numberInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.codeBlockStartIndex;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.codeBlockEndIndex;
        int hashCode2 = (((((((((hashCode + (num2 == null ? 0 : num2.hashCode())) * 31) + Integer.hashCode(this.titleBgColor)) * 31) + Float.hashCode(this.cornerRadius)) * 31) + Float.hashCode(this.borderWidth)) * 31) + Integer.hashCode(this.borderColor)) * 31;
        boolean z = this.enableBackground;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        CodeBlockScrollableInfo codeBlockScrollableInfo = this.scrollableInfo;
        int hashCode3 = (i2 + (codeBlockScrollableInfo == null ? 0 : codeBlockScrollableInfo.hashCode())) * 31;
        CodeBlockLineNumberInfo codeBlockLineNumberInfo = this.numberInfo;
        return hashCode3 + (codeBlockLineNumberInfo != null ? codeBlockLineNumberInfo.hashCode() : 0);
    }

    public String toString() {
        return "CodeBlockSpan2Info(codeBlockStartIndex=" + this.codeBlockStartIndex + ", codeBlockEndIndex=" + this.codeBlockEndIndex + ", titleBgColor=" + this.titleBgColor + ", cornerRadius=" + this.cornerRadius + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", enableBackground=" + this.enableBackground + ", scrollableInfo=" + this.scrollableInfo + ", numberInfo=" + this.numberInfo + ')';
    }

    public CodeBlockSpan2Info(Integer num, Integer num2, int i, float f, float f2, int i2, boolean z, CodeBlockScrollableInfo codeBlockScrollableInfo, CodeBlockLineNumberInfo codeBlockLineNumberInfo) {
        this.codeBlockStartIndex = num;
        this.codeBlockEndIndex = num2;
        this.titleBgColor = i;
        this.cornerRadius = f;
        this.borderWidth = f2;
        this.borderColor = i2;
        this.enableBackground = z;
        this.scrollableInfo = codeBlockScrollableInfo;
        this.numberInfo = codeBlockLineNumberInfo;
    }

    public /* synthetic */ CodeBlockSpan2Info(Integer num, Integer num2, int i, float f, float f2, int i2, boolean z, CodeBlockScrollableInfo codeBlockScrollableInfo, CodeBlockLineNumberInfo codeBlockLineNumberInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2, i, f, f2, i2, z, (i3 & 128) != 0 ? null : codeBlockScrollableInfo, (i3 & 256) != 0 ? null : codeBlockLineNumberInfo);
    }

    public final Integer getCodeBlockStartIndex() {
        return this.codeBlockStartIndex;
    }

    public final Integer getCodeBlockEndIndex() {
        return this.codeBlockEndIndex;
    }

    public final int getTitleBgColor() {
        return this.titleBgColor;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final boolean getEnableBackground() {
        return this.enableBackground;
    }

    public final CodeBlockScrollableInfo getScrollableInfo() {
        return this.scrollableInfo;
    }

    public final CodeBlockLineNumberInfo getNumberInfo() {
        return this.numberInfo;
    }
}
