package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostStyleUIDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PageTitleBar;", "", "title", "", "titleColor", "navBarColor", "navBtnType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNavBarColor", "()Ljava/lang/String;", "getNavBtnType", "getTitle", "getTitleColor", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PageTitleBar {
    private final String navBarColor;
    private final String navBtnType;
    private final String title;
    private final String titleColor;

    public PageTitleBar() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PageTitleBar copy$default(PageTitleBar pageTitleBar, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pageTitleBar.title;
        }
        if ((i & 2) != 0) {
            str2 = pageTitleBar.titleColor;
        }
        if ((i & 4) != 0) {
            str3 = pageTitleBar.navBarColor;
        }
        if ((i & 8) != 0) {
            str4 = pageTitleBar.navBtnType;
        }
        return pageTitleBar.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitleColor() {
        return this.titleColor;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNavBarColor() {
        return this.navBarColor;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNavBtnType() {
        return this.navBtnType;
    }

    public final PageTitleBar copy(String title, String titleColor, String navBarColor, String navBtnType) {
        return new PageTitleBar(title, titleColor, navBarColor, navBtnType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageTitleBar)) {
            return false;
        }
        PageTitleBar pageTitleBar = (PageTitleBar) other;
        return Intrinsics.areEqual(this.title, pageTitleBar.title) && Intrinsics.areEqual(this.titleColor, pageTitleBar.titleColor) && Intrinsics.areEqual(this.navBarColor, pageTitleBar.navBarColor) && Intrinsics.areEqual(this.navBtnType, pageTitleBar.navBtnType);
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.titleColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.navBarColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.navBtnType;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "PageTitleBar(title=" + this.title + ", titleColor=" + this.titleColor + ", navBarColor=" + this.navBarColor + ", navBtnType=" + this.navBtnType + ')';
    }

    public PageTitleBar(String str, String str2, String str3, String str4) {
        this.title = str;
        this.titleColor = str2;
        this.navBarColor = str3;
        this.navBtnType = str4;
    }

    public /* synthetic */ PageTitleBar(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getNavBarColor() {
        return this.navBarColor;
    }

    public final String getNavBtnType() {
        return this.navBtnType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleColor() {
        return this.titleColor;
    }
}
