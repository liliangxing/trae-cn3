package com.larus.business.markdown.api.extplugin.html;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlCssStyleTheme.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyleTheme;", "", "color", "", "backgroundColor", "fontStyle", "fontWeight", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getColor", "getFontStyle", "getFontWeight", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class HtmlCssStyleTheme {
    private final String backgroundColor;
    private final String color;
    private final String fontStyle;
    private final String fontWeight;

    public HtmlCssStyleTheme() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ HtmlCssStyleTheme copy$default(HtmlCssStyleTheme htmlCssStyleTheme, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = htmlCssStyleTheme.color;
        }
        if ((i & 2) != 0) {
            str2 = htmlCssStyleTheme.backgroundColor;
        }
        if ((i & 4) != 0) {
            str3 = htmlCssStyleTheme.fontStyle;
        }
        if ((i & 8) != 0) {
            str4 = htmlCssStyleTheme.fontWeight;
        }
        return htmlCssStyleTheme.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFontStyle() {
        return this.fontStyle;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFontWeight() {
        return this.fontWeight;
    }

    public final HtmlCssStyleTheme copy(String color, String backgroundColor, String fontStyle, String fontWeight) {
        return new HtmlCssStyleTheme(color, backgroundColor, fontStyle, fontWeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HtmlCssStyleTheme)) {
            return false;
        }
        HtmlCssStyleTheme htmlCssStyleTheme = (HtmlCssStyleTheme) other;
        return Intrinsics.areEqual(this.color, htmlCssStyleTheme.color) && Intrinsics.areEqual(this.backgroundColor, htmlCssStyleTheme.backgroundColor) && Intrinsics.areEqual(this.fontStyle, htmlCssStyleTheme.fontStyle) && Intrinsics.areEqual(this.fontWeight, htmlCssStyleTheme.fontWeight);
    }

    public int hashCode() {
        String str = this.color;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.backgroundColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fontStyle;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.fontWeight;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "HtmlCssStyleTheme(color=" + this.color + ", backgroundColor=" + this.backgroundColor + ", fontStyle=" + this.fontStyle + ", fontWeight=" + this.fontWeight + ')';
    }

    public HtmlCssStyleTheme(String str, String str2, String str3, String str4) {
        this.color = str;
        this.backgroundColor = str2;
        this.fontStyle = str3;
        this.fontWeight = str4;
    }

    public /* synthetic */ HtmlCssStyleTheme(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getColor() {
        return this.color;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getFontStyle() {
        return this.fontStyle;
    }

    public final String getFontWeight() {
        return this.fontWeight;
    }
}
