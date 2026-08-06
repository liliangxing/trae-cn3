package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import com.bytedance.forest.model.PreloadConfig;
import com.ss.ttm.player.MediaFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostStyleUIDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ActionSheetBuilder;", "", "context", "Landroid/content/Context;", "title", "", MediaFormat.KEY_SUBTITLE, "actions", "", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/ActionSheetBuilderAction;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "getContext", "()Landroid/content/Context;", "getSubtitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActionSheetBuilder {
    private final List<ActionSheetBuilderAction> actions;
    private final Context context;
    private final String subtitle;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionSheetBuilder copy$default(ActionSheetBuilder actionSheetBuilder, Context context, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            context = actionSheetBuilder.context;
        }
        if ((i & 2) != 0) {
            str = actionSheetBuilder.title;
        }
        if ((i & 4) != 0) {
            str2 = actionSheetBuilder.subtitle;
        }
        if ((i & 8) != 0) {
            list = actionSheetBuilder.actions;
        }
        return actionSheetBuilder.copy(context, str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<ActionSheetBuilderAction> component4() {
        return this.actions;
    }

    public final ActionSheetBuilder copy(Context context, String title, String subtitle, List<ActionSheetBuilderAction> actions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actions, "actions");
        return new ActionSheetBuilder(context, title, subtitle, actions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionSheetBuilder)) {
            return false;
        }
        ActionSheetBuilder actionSheetBuilder = (ActionSheetBuilder) other;
        return Intrinsics.areEqual(this.context, actionSheetBuilder.context) && Intrinsics.areEqual(this.title, actionSheetBuilder.title) && Intrinsics.areEqual(this.subtitle, actionSheetBuilder.subtitle) && Intrinsics.areEqual(this.actions, actionSheetBuilder.actions);
    }

    public int hashCode() {
        int hashCode = this.context.hashCode() * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subtitle;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.actions.hashCode();
    }

    public String toString() {
        return "ActionSheetBuilder(context=" + this.context + ", title=" + this.title + ", subtitle=" + this.subtitle + ", actions=" + this.actions + ')';
    }

    public ActionSheetBuilder(Context context, String str, String str2, List<ActionSheetBuilderAction> actions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.context = context;
        this.title = str;
        this.subtitle = str2;
        this.actions = actions;
    }

    public /* synthetic */ ActionSheetBuilder(Context context, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, list);
    }

    public final List<ActionSheetBuilderAction> getActions() {
        return this.actions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }
}
