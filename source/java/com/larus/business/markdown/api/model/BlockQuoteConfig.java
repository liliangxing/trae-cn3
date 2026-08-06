package com.larus.business.markdown.api.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlockQuoteConfig.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJl\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e¨\u0006'"}, d2 = {"Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "", "enableNewQuoteStyle", "", "blockQuoteWidth", "", "blockQuoteColor", "lineCornerRadius", "blockMargin", "textColorInQuote", "orderedListItemColorInQuote", "bulletListItemColorInQuote", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBlockMargin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBlockQuoteColor", "getBlockQuoteWidth", "getBulletListItemColorInQuote", "getEnableNewQuoteStyle", "()Z", "getLineCornerRadius", "getOrderedListItemColorInQuote", "getTextColorInQuote", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class BlockQuoteConfig {
    private final Integer blockMargin;
    private final Integer blockQuoteColor;
    private final Integer blockQuoteWidth;
    private final Integer bulletListItemColorInQuote;
    private final boolean enableNewQuoteStyle;
    private final Integer lineCornerRadius;
    private final Integer orderedListItemColorInQuote;
    private final Integer textColorInQuote;

    public BlockQuoteConfig() {
        this(false, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableNewQuoteStyle() {
        return this.enableNewQuoteStyle;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getBlockQuoteWidth() {
        return this.blockQuoteWidth;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getBlockQuoteColor() {
        return this.blockQuoteColor;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getLineCornerRadius() {
        return this.lineCornerRadius;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getBlockMargin() {
        return this.blockMargin;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getTextColorInQuote() {
        return this.textColorInQuote;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getOrderedListItemColorInQuote() {
        return this.orderedListItemColorInQuote;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getBulletListItemColorInQuote() {
        return this.bulletListItemColorInQuote;
    }

    public final BlockQuoteConfig copy(boolean enableNewQuoteStyle, Integer blockQuoteWidth, Integer blockQuoteColor, Integer lineCornerRadius, Integer blockMargin, Integer textColorInQuote, Integer orderedListItemColorInQuote, Integer bulletListItemColorInQuote) {
        return new BlockQuoteConfig(enableNewQuoteStyle, blockQuoteWidth, blockQuoteColor, lineCornerRadius, blockMargin, textColorInQuote, orderedListItemColorInQuote, bulletListItemColorInQuote);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockQuoteConfig)) {
            return false;
        }
        BlockQuoteConfig blockQuoteConfig = (BlockQuoteConfig) other;
        return this.enableNewQuoteStyle == blockQuoteConfig.enableNewQuoteStyle && Intrinsics.areEqual(this.blockQuoteWidth, blockQuoteConfig.blockQuoteWidth) && Intrinsics.areEqual(this.blockQuoteColor, blockQuoteConfig.blockQuoteColor) && Intrinsics.areEqual(this.lineCornerRadius, blockQuoteConfig.lineCornerRadius) && Intrinsics.areEqual(this.blockMargin, blockQuoteConfig.blockMargin) && Intrinsics.areEqual(this.textColorInQuote, blockQuoteConfig.textColorInQuote) && Intrinsics.areEqual(this.orderedListItemColorInQuote, blockQuoteConfig.orderedListItemColorInQuote) && Intrinsics.areEqual(this.bulletListItemColorInQuote, blockQuoteConfig.bulletListItemColorInQuote);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean z = this.enableNewQuoteStyle;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.blockQuoteWidth;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.blockQuoteColor;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.lineCornerRadius;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.blockMargin;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.textColorInQuote;
        int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.orderedListItemColorInQuote;
        int hashCode6 = (hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.bulletListItemColorInQuote;
        return hashCode6 + (num7 != null ? num7.hashCode() : 0);
    }

    public String toString() {
        return "BlockQuoteConfig(enableNewQuoteStyle=" + this.enableNewQuoteStyle + ", blockQuoteWidth=" + this.blockQuoteWidth + ", blockQuoteColor=" + this.blockQuoteColor + ", lineCornerRadius=" + this.lineCornerRadius + ", blockMargin=" + this.blockMargin + ", textColorInQuote=" + this.textColorInQuote + ", orderedListItemColorInQuote=" + this.orderedListItemColorInQuote + ", bulletListItemColorInQuote=" + this.bulletListItemColorInQuote + ')';
    }

    public BlockQuoteConfig(boolean z, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.enableNewQuoteStyle = z;
        this.blockQuoteWidth = num;
        this.blockQuoteColor = num2;
        this.lineCornerRadius = num3;
        this.blockMargin = num4;
        this.textColorInQuote = num5;
        this.orderedListItemColorInQuote = num6;
        this.bulletListItemColorInQuote = num7;
    }

    public /* synthetic */ BlockQuoteConfig(boolean z, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : num5, (i & 64) != 0 ? null : num6, (i & 128) == 0 ? num7 : null);
    }

    public final boolean getEnableNewQuoteStyle() {
        return this.enableNewQuoteStyle;
    }

    public final Integer getBlockQuoteWidth() {
        return this.blockQuoteWidth;
    }

    public final Integer getBlockQuoteColor() {
        return this.blockQuoteColor;
    }

    public final Integer getLineCornerRadius() {
        return this.lineCornerRadius;
    }

    public final Integer getBlockMargin() {
        return this.blockMargin;
    }

    public final Integer getTextColorInQuote() {
        return this.textColorInQuote;
    }

    public final Integer getOrderedListItemColorInQuote() {
        return this.orderedListItemColorInQuote;
    }

    public final Integer getBulletListItemColorInQuote() {
        return this.bulletListItemColorInQuote;
    }
}
