package com.bytedance.ies.xbridge.base.runtime.depend;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostStyleUIDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003Jq\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u0006."}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/DialogBuilder;", "", "context", "Landroid/content/Context;", "title", "", "message", "positiveBtnText", "positiveClickListener", "Landroid/content/DialogInterface$OnClickListener;", "negativeBtnText", "negativeClickListener", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "cancelOnTouchOutside", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;Z)V", "getCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "getCancelOnTouchOutside", "()Z", "getContext", "()Landroid/content/Context;", "getMessage", "()Ljava/lang/String;", "getNegativeBtnText", "getNegativeClickListener", "()Landroid/content/DialogInterface$OnClickListener;", "getPositiveBtnText", "getPositiveClickListener", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DialogBuilder {
    private final DialogInterface.OnCancelListener cancelListener;
    private final boolean cancelOnTouchOutside;
    private final Context context;
    private final String message;
    private final String negativeBtnText;
    private final DialogInterface.OnClickListener negativeClickListener;
    private final String positiveBtnText;
    private final DialogInterface.OnClickListener positiveClickListener;
    private final String title;

    /* renamed from: component1, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPositiveBtnText() {
        return this.positiveBtnText;
    }

    /* renamed from: component5, reason: from getter */
    public final DialogInterface.OnClickListener getPositiveClickListener() {
        return this.positiveClickListener;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNegativeBtnText() {
        return this.negativeBtnText;
    }

    /* renamed from: component7, reason: from getter */
    public final DialogInterface.OnClickListener getNegativeClickListener() {
        return this.negativeClickListener;
    }

    /* renamed from: component8, reason: from getter */
    public final DialogInterface.OnCancelListener getCancelListener() {
        return this.cancelListener;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getCancelOnTouchOutside() {
        return this.cancelOnTouchOutside;
    }

    public final DialogBuilder copy(Context context, String title, String message, String positiveBtnText, DialogInterface.OnClickListener positiveClickListener, String negativeBtnText, DialogInterface.OnClickListener negativeClickListener, DialogInterface.OnCancelListener cancelListener, boolean cancelOnTouchOutside) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DialogBuilder(context, title, message, positiveBtnText, positiveClickListener, negativeBtnText, negativeClickListener, cancelListener, cancelOnTouchOutside);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DialogBuilder)) {
            return false;
        }
        DialogBuilder dialogBuilder = (DialogBuilder) other;
        return Intrinsics.areEqual(this.context, dialogBuilder.context) && Intrinsics.areEqual(this.title, dialogBuilder.title) && Intrinsics.areEqual(this.message, dialogBuilder.message) && Intrinsics.areEqual(this.positiveBtnText, dialogBuilder.positiveBtnText) && Intrinsics.areEqual(this.positiveClickListener, dialogBuilder.positiveClickListener) && Intrinsics.areEqual(this.negativeBtnText, dialogBuilder.negativeBtnText) && Intrinsics.areEqual(this.negativeClickListener, dialogBuilder.negativeClickListener) && Intrinsics.areEqual(this.cancelListener, dialogBuilder.cancelListener) && this.cancelOnTouchOutside == dialogBuilder.cancelOnTouchOutside;
    }

    public int hashCode() {
        int hashCode = this.context.hashCode() * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.positiveBtnText;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        DialogInterface.OnClickListener onClickListener = this.positiveClickListener;
        int hashCode5 = (hashCode4 + (onClickListener == null ? 0 : onClickListener.hashCode())) * 31;
        String str4 = this.negativeBtnText;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        DialogInterface.OnClickListener onClickListener2 = this.negativeClickListener;
        int hashCode7 = (hashCode6 + (onClickListener2 == null ? 0 : onClickListener2.hashCode())) * 31;
        DialogInterface.OnCancelListener onCancelListener = this.cancelListener;
        return ((hashCode7 + (onCancelListener != null ? onCancelListener.hashCode() : 0)) * 31) + Boolean.hashCode(this.cancelOnTouchOutside);
    }

    public String toString() {
        return "DialogBuilder(context=" + this.context + ", title=" + this.title + ", message=" + this.message + ", positiveBtnText=" + this.positiveBtnText + ", positiveClickListener=" + this.positiveClickListener + ", negativeBtnText=" + this.negativeBtnText + ", negativeClickListener=" + this.negativeClickListener + ", cancelListener=" + this.cancelListener + ", cancelOnTouchOutside=" + this.cancelOnTouchOutside + ')';
    }

    public DialogBuilder(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.title = str;
        this.message = str2;
        this.positiveBtnText = str3;
        this.positiveClickListener = onClickListener;
        this.negativeBtnText = str4;
        this.negativeClickListener = onClickListener2;
        this.cancelListener = onCancelListener;
        this.cancelOnTouchOutside = z;
    }

    public /* synthetic */ DialogBuilder(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : onClickListener, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : onClickListener2, (i & 128) == 0 ? onCancelListener : null, (i & 256) != 0 ? true : z);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getPositiveBtnText() {
        return this.positiveBtnText;
    }

    public final DialogInterface.OnClickListener getPositiveClickListener() {
        return this.positiveClickListener;
    }

    public final String getNegativeBtnText() {
        return this.negativeBtnText;
    }

    public final DialogInterface.OnClickListener getNegativeClickListener() {
        return this.negativeClickListener;
    }

    public final DialogInterface.OnCancelListener getCancelListener() {
        return this.cancelListener;
    }

    public final boolean getCancelOnTouchOutside() {
        return this.cancelOnTouchOutside;
    }
}
