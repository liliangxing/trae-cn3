package com.bytedance.upc;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigatorConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ0\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/upc/NavigatorConfiguration;", "", "visible", "", "backResId", "backgroundColor", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "getBackResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackgroundColor", "getVisible", "()I", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/upc/NavigatorConfiguration;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final /* data */ class NavigatorConfiguration {
    private final Integer backResId;
    private final Integer backgroundColor;
    private final int visible;

    public static /* synthetic */ NavigatorConfiguration copy$default(NavigatorConfiguration navigatorConfiguration, int i, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = navigatorConfiguration.visible;
        }
        if ((i2 & 2) != 0) {
            num = navigatorConfiguration.backResId;
        }
        if ((i2 & 4) != 0) {
            num2 = navigatorConfiguration.backgroundColor;
        }
        return navigatorConfiguration.copy(i, num, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVisible() {
        return this.visible;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getBackResId() {
        return this.backResId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final NavigatorConfiguration copy(int visible, Integer backResId, Integer backgroundColor) {
        return new NavigatorConfiguration(visible, backResId, backgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavigatorConfiguration)) {
            return false;
        }
        NavigatorConfiguration navigatorConfiguration = (NavigatorConfiguration) other;
        return this.visible == navigatorConfiguration.visible && Intrinsics.areEqual(this.backResId, navigatorConfiguration.backResId) && Intrinsics.areEqual(this.backgroundColor, navigatorConfiguration.backgroundColor);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.visible) * 31;
        Integer num = this.backResId;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.backgroundColor;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "NavigatorConfiguration(visible=" + this.visible + ", backResId=" + this.backResId + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public NavigatorConfiguration(int i, Integer num, Integer num2) {
        this.visible = i;
        this.backResId = num;
        this.backgroundColor = num2;
    }

    public final int getVisible() {
        return this.visible;
    }

    public final Integer getBackResId() {
        return this.backResId;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }
}
