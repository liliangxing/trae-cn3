package com.bytedance.ies.xbridge.base.runtime.depend;

import android.content.Context;
import com.bytedance.forest.model.PreloadConfig;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostStyleUIDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003JT\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;", "", "context", "Landroid/content/Context;", "message", "", "type", "duration", "", RemoteMessageConst.Notification.ICON, "customIcon", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getCustomIcon", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "getMessage", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ToastBuilder {
    private final Context context;
    private final String customIcon;
    private final Integer duration;
    private final String icon;
    private final String message;
    private final String type;

    public static /* synthetic */ ToastBuilder copy$default(ToastBuilder toastBuilder, Context context, String str, String str2, Integer num, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            context = toastBuilder.context;
        }
        if ((i & 2) != 0) {
            str = toastBuilder.message;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = toastBuilder.type;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            num = toastBuilder.duration;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            str3 = toastBuilder.icon;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = toastBuilder.customIcon;
        }
        return toastBuilder.copy(context, str5, str6, num2, str7, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCustomIcon() {
        return this.customIcon;
    }

    public final ToastBuilder copy(Context context, String message, String type, Integer duration, String icon, String customIcon) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ToastBuilder(context, message, type, duration, icon, customIcon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToastBuilder)) {
            return false;
        }
        ToastBuilder toastBuilder = (ToastBuilder) other;
        return Intrinsics.areEqual(this.context, toastBuilder.context) && Intrinsics.areEqual(this.message, toastBuilder.message) && Intrinsics.areEqual(this.type, toastBuilder.type) && Intrinsics.areEqual(this.duration, toastBuilder.duration) && Intrinsics.areEqual(this.icon, toastBuilder.icon) && Intrinsics.areEqual(this.customIcon, toastBuilder.customIcon);
    }

    public int hashCode() {
        int hashCode = this.context.hashCode() * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.type;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.duration;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.icon;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.customIcon;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ToastBuilder(context=" + this.context + ", message=" + this.message + ", type=" + this.type + ", duration=" + this.duration + ", icon=" + this.icon + ", customIcon=" + this.customIcon + ')';
    }

    public ToastBuilder(Context context, String str, String str2, Integer num, String str3, String str4) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.message = str;
        this.type = str2;
        this.duration = num;
        this.icon = str3;
        this.customIcon = str4;
    }

    public /* synthetic */ ToastBuilder(Context context, String str, String str2, Integer num, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "success" : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) == 0 ? str4 : null);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getCustomIcon() {
        return this.customIcon;
    }
}
