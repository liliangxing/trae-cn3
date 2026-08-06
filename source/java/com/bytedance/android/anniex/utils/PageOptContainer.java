package com.bytedance.android.anniex.utils;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXUrlExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\b\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0017\u0010\u0007\u001a\u00020\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\b\u0011J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/utils/PageOptContainer;", "", "pageOpt", "", "(Ljava/lang/String;)V", "getPageOpt", "()Ljava/lang/String;", "setPageOpt", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "getPageOpt$anniex_release", "hashCode", "", "", "setPageOpt$anniex_release", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PageOptContainer {
    private String pageOpt;

    public static /* synthetic */ PageOptContainer copy$default(PageOptContainer pageOptContainer, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pageOptContainer.pageOpt;
        }
        return pageOptContainer.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPageOpt() {
        return this.pageOpt;
    }

    public final PageOptContainer copy(String pageOpt) {
        return new PageOptContainer(pageOpt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PageOptContainer) && Intrinsics.areEqual(this.pageOpt, ((PageOptContainer) other).pageOpt);
    }

    public int hashCode() {
        String str = this.pageOpt;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "PageOptContainer(pageOpt=" + this.pageOpt + ')';
    }

    public PageOptContainer(String str) {
        this.pageOpt = str;
    }

    public final String getPageOpt() {
        return this.pageOpt;
    }

    public final void setPageOpt(String str) {
        this.pageOpt = str;
    }

    public final void setPageOpt$anniex_release(String pageOpt) {
        this.pageOpt = pageOpt;
    }

    public final String getPageOpt$anniex_release() {
        return this.pageOpt;
    }
}
