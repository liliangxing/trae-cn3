package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.ttm.player.MediaFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostStyleUIDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ActionSheetBuilderAction;", "", "title", "", MediaFormat.KEY_SUBTITLE, "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSubtitle", "()Ljava/lang/String;", "getTitle", "getType", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActionSheetBuilderAction {
    private final String subtitle;
    private final String title;
    private final String type;

    public static /* synthetic */ ActionSheetBuilderAction copy$default(ActionSheetBuilderAction actionSheetBuilderAction, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionSheetBuilderAction.title;
        }
        if ((i & 2) != 0) {
            str2 = actionSheetBuilderAction.subtitle;
        }
        if ((i & 4) != 0) {
            str3 = actionSheetBuilderAction.type;
        }
        return actionSheetBuilderAction.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ActionSheetBuilderAction copy(String title, String subtitle, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ActionSheetBuilderAction(title, subtitle, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionSheetBuilderAction)) {
            return false;
        }
        ActionSheetBuilderAction actionSheetBuilderAction = (ActionSheetBuilderAction) other;
        return Intrinsics.areEqual(this.title, actionSheetBuilderAction.title) && Intrinsics.areEqual(this.subtitle, actionSheetBuilderAction.subtitle) && Intrinsics.areEqual(this.type, actionSheetBuilderAction.type);
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ActionSheetBuilderAction(title=" + this.title + ", subtitle=" + this.subtitle + ", type=" + this.type + ')';
    }

    public ActionSheetBuilderAction(String str, String str2, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.title = str;
        this.subtitle = str2;
        this.type = type;
    }

    public /* synthetic */ ActionSheetBuilderAction(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, str3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getType() {
        return this.type;
    }
}
