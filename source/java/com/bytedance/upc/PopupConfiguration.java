package com.bytedance.upc;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0088\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016¨\u00061"}, d2 = {"Lcom/bytedance/upc/PopupConfiguration;", "", "marginTop", "", "marginHorizontal", "background", "title", "", "titleColor", "titleFontType", "titleSize", "desc", "descColor", "descFontType", "descSize", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBackground", "()I", "getDesc", "()Ljava/lang/String;", "getDescColor", "getDescFontType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescSize", "getMarginHorizontal", "getMarginTop", "getTitle", "getTitleColor", "getTitleFontType", "getTitleSize", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/upc/PopupConfiguration;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final /* data */ class PopupConfiguration {
    private final int background;
    private final String desc;
    private final String descColor;
    private final Integer descFontType;
    private final Integer descSize;
    private final int marginHorizontal;
    private final int marginTop;
    private final String title;
    private final String titleColor;
    private final Integer titleFontType;
    private final Integer titleSize;

    /* renamed from: component1, reason: from getter */
    public final int getMarginTop() {
        return this.marginTop;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getDescFontType() {
        return this.descFontType;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getDescSize() {
        return this.descSize;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMarginHorizontal() {
        return this.marginHorizontal;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBackground() {
        return this.background;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitleColor() {
        return this.titleColor;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getTitleFontType() {
        return this.titleFontType;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getTitleSize() {
        return this.titleSize;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDescColor() {
        return this.descColor;
    }

    public final PopupConfiguration copy(int marginTop, int marginHorizontal, int background, String title, String titleColor, Integer titleFontType, Integer titleSize, String desc, String descColor, Integer descFontType, Integer descSize) {
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        return new PopupConfiguration(marginTop, marginHorizontal, background, title, titleColor, titleFontType, titleSize, desc, descColor, descFontType, descSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PopupConfiguration)) {
            return false;
        }
        PopupConfiguration popupConfiguration = (PopupConfiguration) other;
        return this.marginTop == popupConfiguration.marginTop && this.marginHorizontal == popupConfiguration.marginHorizontal && this.background == popupConfiguration.background && Intrinsics.areEqual(this.title, popupConfiguration.title) && Intrinsics.areEqual(this.titleColor, popupConfiguration.titleColor) && Intrinsics.areEqual(this.titleFontType, popupConfiguration.titleFontType) && Intrinsics.areEqual(this.titleSize, popupConfiguration.titleSize) && Intrinsics.areEqual(this.desc, popupConfiguration.desc) && Intrinsics.areEqual(this.descColor, popupConfiguration.descColor) && Intrinsics.areEqual(this.descFontType, popupConfiguration.descFontType) && Intrinsics.areEqual(this.descSize, popupConfiguration.descSize);
    }

    public int hashCode() {
        int hashCode = ((((Integer.hashCode(this.marginTop) * 31) + Integer.hashCode(this.marginHorizontal)) * 31) + Integer.hashCode(this.background)) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.titleColor;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.titleFontType;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.titleSize;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str3 = this.desc;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.descColor;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num3 = this.descFontType;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.descSize;
        return hashCode8 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        return "PopupConfiguration(marginTop=" + this.marginTop + ", marginHorizontal=" + this.marginHorizontal + ", background=" + this.background + ", title=" + this.title + ", titleColor=" + this.titleColor + ", titleFontType=" + this.titleFontType + ", titleSize=" + this.titleSize + ", desc=" + this.desc + ", descColor=" + this.descColor + ", descFontType=" + this.descFontType + ", descSize=" + this.descSize + ")";
    }

    public PopupConfiguration(int i, int i2, int i3, String title, String str, Integer num, Integer num2, String desc, String str2, Integer num3, Integer num4) {
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        this.marginTop = i;
        this.marginHorizontal = i2;
        this.background = i3;
        this.title = title;
        this.titleColor = str;
        this.titleFontType = num;
        this.titleSize = num2;
        this.desc = desc;
        this.descColor = str2;
        this.descFontType = num3;
        this.descSize = num4;
    }

    public final int getMarginTop() {
        return this.marginTop;
    }

    public final int getMarginHorizontal() {
        return this.marginHorizontal;
    }

    public final int getBackground() {
        return this.background;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleColor() {
        return this.titleColor;
    }

    public final Integer getTitleFontType() {
        return this.titleFontType;
    }

    public final Integer getTitleSize() {
        return this.titleSize;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDescColor() {
        return this.descColor;
    }

    public final Integer getDescFontType() {
        return this.descFontType;
    }

    public final Integer getDescSize() {
        return this.descSize;
    }
}
