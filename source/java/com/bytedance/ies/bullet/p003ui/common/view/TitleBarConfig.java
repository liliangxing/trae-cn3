package com.bytedance.ies.bullet.p003ui.common.view;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ITitleBarConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/view/TitleBarConfig;", "", SchemaConstants.QUERY_KEY_TITLE, "", "titleColor", "navBarColor", "navBtnType", "Lcom/bytedance/ies/bullet/ui/common/view/TitleBarRightBtn;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/bullet/ui/common/view/TitleBarRightBtn;)V", "getNavBarColor", "()Ljava/lang/String;", "getNavBtnType", "()Lcom/bytedance/ies/bullet/ui/common/view/TitleBarRightBtn;", "getTitle", "getTitleColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class TitleBarConfig {
    private final String navBarColor;
    private final TitleBarRightBtn navBtnType;
    private final String title;
    private final String titleColor;

    public static /* synthetic */ TitleBarConfig copy$default(TitleBarConfig titleBarConfig, String str, String str2, String str3, TitleBarRightBtn titleBarRightBtn, int i, Object obj) {
        if ((i & 1) != 0) {
            str = titleBarConfig.title;
        }
        if ((i & 2) != 0) {
            str2 = titleBarConfig.titleColor;
        }
        if ((i & 4) != 0) {
            str3 = titleBarConfig.navBarColor;
        }
        if ((i & 8) != 0) {
            titleBarRightBtn = titleBarConfig.navBtnType;
        }
        return titleBarConfig.copy(str, str2, str3, titleBarRightBtn);
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
    public final TitleBarRightBtn getNavBtnType() {
        return this.navBtnType;
    }

    public final TitleBarConfig copy(String title, String titleColor, String navBarColor, TitleBarRightBtn navBtnType) {
        return new TitleBarConfig(title, titleColor, navBarColor, navBtnType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleBarConfig)) {
            return false;
        }
        TitleBarConfig titleBarConfig = (TitleBarConfig) other;
        return Intrinsics.areEqual(this.title, titleBarConfig.title) && Intrinsics.areEqual(this.titleColor, titleBarConfig.titleColor) && Intrinsics.areEqual(this.navBarColor, titleBarConfig.navBarColor) && this.navBtnType == titleBarConfig.navBtnType;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.titleColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.navBarColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        TitleBarRightBtn titleBarRightBtn = this.navBtnType;
        return hashCode3 + (titleBarRightBtn != null ? titleBarRightBtn.hashCode() : 0);
    }

    public String toString() {
        return "TitleBarConfig(title=" + this.title + ", titleColor=" + this.titleColor + ", navBarColor=" + this.navBarColor + ", navBtnType=" + this.navBtnType + ')';
    }

    public TitleBarConfig(String str, String str2, String str3, TitleBarRightBtn titleBarRightBtn) {
        this.title = str;
        this.titleColor = str2;
        this.navBarColor = str3;
        this.navBtnType = titleBarRightBtn;
    }

    public final String getNavBarColor() {
        return this.navBarColor;
    }

    public final TitleBarRightBtn getNavBtnType() {
        return this.navBtnType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleColor() {
        return this.titleColor;
    }
}
