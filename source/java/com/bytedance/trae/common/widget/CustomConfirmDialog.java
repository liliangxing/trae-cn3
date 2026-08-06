package com.bytedance.trae.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common_ui.C0591R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CustomConfirmDialog.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0003\f\r\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/common/widget/CustomConfirmDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "config", "Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;", "<init>", "(Landroid/content/Context;Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Config", "Mode", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CustomConfirmDialog extends Dialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Config config;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomConfirmDialog(Context context, Config config) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    /* compiled from: CustomConfirmDialog.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\b\b\u0003\u0010\u0011\u001a\u00020\n\u0012\b\b\u0003\u0010\u0012\u001a\u00020\n\u0012\b\b\u0003\u0010\u0013\u001a\u00020\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010D\u001a\u00020\fHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010G\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010H\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010I\u001a\u00020\nHÆ\u0003J\t\u0010J\u001a\u00020\nHÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010M\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010N\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010O\u001a\u00020\u0018HÆ\u0003J\u0017\u0010P\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dHÆ\u0003J\u008a\u0002\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u0011\u001a\u00020\n2\b\b\u0003\u0010\u0012\u001a\u00020\n2\b\b\u0003\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dHÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u00182\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\nHÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010)\u001a\u0004\b,\u0010(R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010)\u001a\u0004\b-\u0010(R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010)\u001a\u0004\b.\u0010(R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010)\u001a\u0004\b/\u0010(R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010)\u001a\u0004\b4\u0010(R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010)\u001a\u0004\b5\u0010(R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010)\u001a\u0004\b6\u0010(R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001f\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006X"}, d2 = {"Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;", "", "title", "", "message", "inputText", "inputHint", "cancelText", "confirmText", "dialogWidthPx", "", "dimAmount", "", "titleGravity", "titleHorizontalPaddingPx", "cancelTextColor", "confirmTextColor", "dialogBgRes", "cancelBgRes", "confirmBgRes", "messageGravity", "messageHorizontalPaddingPx", "buttonTopMarginPx", "singleButton", "", "onConfirm", "Lkotlin/Function1;", "", "onCancel", "Lkotlin/Function0;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;FLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getTitle", "()Ljava/lang/String;", "getMessage", "getInputText", "getInputHint", "getCancelText", "getConfirmText", "getDialogWidthPx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDimAmount", "()F", "getTitleGravity", "getTitleHorizontalPaddingPx", "getCancelTextColor", "getConfirmTextColor", "getDialogBgRes", "()I", "getCancelBgRes", "getConfirmBgRes", "getMessageGravity", "getMessageHorizontalPaddingPx", "getButtonTopMarginPx", "getSingleButton", "()Z", "getOnConfirm", "()Lkotlin/jvm/functions/Function1;", "getOnCancel", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;FLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;", "equals", "other", "hashCode", "toString", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Config {
        private final Integer buttonTopMarginPx;
        private final int cancelBgRes;
        private final String cancelText;
        private final Integer cancelTextColor;
        private final int confirmBgRes;
        private final String confirmText;
        private final Integer confirmTextColor;
        private final int dialogBgRes;
        private final Integer dialogWidthPx;
        private final float dimAmount;
        private final String inputHint;
        private final String inputText;
        private final String message;
        private final Integer messageGravity;
        private final Integer messageHorizontalPaddingPx;
        private final Function0<Unit> onCancel;
        private final Function1<String, Unit> onConfirm;
        private final boolean singleButton;
        private final String title;
        private final Integer titleGravity;
        private final Integer titleHorizontalPaddingPx;

        public Config() {
            this(null, null, null, null, null, null, null, 0.0f, null, null, null, null, 0, 0, 0, null, null, null, false, null, null, 2097151, null);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component10, reason: from getter */
        public final Integer getTitleHorizontalPaddingPx() {
            return this.titleHorizontalPaddingPx;
        }

        /* renamed from: component11, reason: from getter */
        public final Integer getCancelTextColor() {
            return this.cancelTextColor;
        }

        /* renamed from: component12, reason: from getter */
        public final Integer getConfirmTextColor() {
            return this.confirmTextColor;
        }

        /* renamed from: component13, reason: from getter */
        public final int getDialogBgRes() {
            return this.dialogBgRes;
        }

        /* renamed from: component14, reason: from getter */
        public final int getCancelBgRes() {
            return this.cancelBgRes;
        }

        /* renamed from: component15, reason: from getter */
        public final int getConfirmBgRes() {
            return this.confirmBgRes;
        }

        /* renamed from: component16, reason: from getter */
        public final Integer getMessageGravity() {
            return this.messageGravity;
        }

        /* renamed from: component17, reason: from getter */
        public final Integer getMessageHorizontalPaddingPx() {
            return this.messageHorizontalPaddingPx;
        }

        /* renamed from: component18, reason: from getter */
        public final Integer getButtonTopMarginPx() {
            return this.buttonTopMarginPx;
        }

        /* renamed from: component19, reason: from getter */
        public final boolean getSingleButton() {
            return this.singleButton;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Function1<String, Unit> component20() {
            return this.onConfirm;
        }

        public final Function0<Unit> component21() {
            return this.onCancel;
        }

        /* renamed from: component3, reason: from getter */
        public final String getInputText() {
            return this.inputText;
        }

        /* renamed from: component4, reason: from getter */
        public final String getInputHint() {
            return this.inputHint;
        }

        /* renamed from: component5, reason: from getter */
        public final String getCancelText() {
            return this.cancelText;
        }

        /* renamed from: component6, reason: from getter */
        public final String getConfirmText() {
            return this.confirmText;
        }

        /* renamed from: component7, reason: from getter */
        public final Integer getDialogWidthPx() {
            return this.dialogWidthPx;
        }

        /* renamed from: component8, reason: from getter */
        public final float getDimAmount() {
            return this.dimAmount;
        }

        /* renamed from: component9, reason: from getter */
        public final Integer getTitleGravity() {
            return this.titleGravity;
        }

        public final Config copy(String title, String message, String inputText, String inputHint, String cancelText, String confirmText, Integer dialogWidthPx, float dimAmount, Integer titleGravity, Integer titleHorizontalPaddingPx, Integer cancelTextColor, Integer confirmTextColor, int dialogBgRes, int cancelBgRes, int confirmBgRes, Integer messageGravity, Integer messageHorizontalPaddingPx, Integer buttonTopMarginPx, boolean singleButton, Function1<? super String, Unit> onConfirm, Function0<Unit> onCancel) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(cancelText, "cancelText");
            Intrinsics.checkNotNullParameter(confirmText, "confirmText");
            Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
            Intrinsics.checkNotNullParameter(onCancel, "onCancel");
            return new Config(title, message, inputText, inputHint, cancelText, confirmText, dialogWidthPx, dimAmount, titleGravity, titleHorizontalPaddingPx, cancelTextColor, confirmTextColor, dialogBgRes, cancelBgRes, confirmBgRes, messageGravity, messageHorizontalPaddingPx, buttonTopMarginPx, singleButton, onConfirm, onCancel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.title, config.title) && Intrinsics.areEqual(this.message, config.message) && Intrinsics.areEqual(this.inputText, config.inputText) && Intrinsics.areEqual(this.inputHint, config.inputHint) && Intrinsics.areEqual(this.cancelText, config.cancelText) && Intrinsics.areEqual(this.confirmText, config.confirmText) && Intrinsics.areEqual(this.dialogWidthPx, config.dialogWidthPx) && Float.compare(this.dimAmount, config.dimAmount) == 0 && Intrinsics.areEqual(this.titleGravity, config.titleGravity) && Intrinsics.areEqual(this.titleHorizontalPaddingPx, config.titleHorizontalPaddingPx) && Intrinsics.areEqual(this.cancelTextColor, config.cancelTextColor) && Intrinsics.areEqual(this.confirmTextColor, config.confirmTextColor) && this.dialogBgRes == config.dialogBgRes && this.cancelBgRes == config.cancelBgRes && this.confirmBgRes == config.confirmBgRes && Intrinsics.areEqual(this.messageGravity, config.messageGravity) && Intrinsics.areEqual(this.messageHorizontalPaddingPx, config.messageHorizontalPaddingPx) && Intrinsics.areEqual(this.buttonTopMarginPx, config.buttonTopMarginPx) && this.singleButton == config.singleButton && Intrinsics.areEqual(this.onConfirm, config.onConfirm) && Intrinsics.areEqual(this.onCancel, config.onCancel);
        }

        public int hashCode() {
            int hashCode = this.title.hashCode() * 31;
            String str = this.message;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.inputText;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.inputHint;
            int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.cancelText.hashCode()) * 31) + this.confirmText.hashCode()) * 31;
            Integer num = this.dialogWidthPx;
            int hashCode5 = (((hashCode4 + (num == null ? 0 : num.hashCode())) * 31) + Float.hashCode(this.dimAmount)) * 31;
            Integer num2 = this.titleGravity;
            int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.titleHorizontalPaddingPx;
            int hashCode7 = (hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.cancelTextColor;
            int hashCode8 = (hashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.confirmTextColor;
            int hashCode9 = (((((((hashCode8 + (num5 == null ? 0 : num5.hashCode())) * 31) + Integer.hashCode(this.dialogBgRes)) * 31) + Integer.hashCode(this.cancelBgRes)) * 31) + Integer.hashCode(this.confirmBgRes)) * 31;
            Integer num6 = this.messageGravity;
            int hashCode10 = (hashCode9 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Integer num7 = this.messageHorizontalPaddingPx;
            int hashCode11 = (hashCode10 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Integer num8 = this.buttonTopMarginPx;
            return ((((((hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 31) + Boolean.hashCode(this.singleButton)) * 31) + this.onConfirm.hashCode()) * 31) + this.onCancel.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Config(title=");
            sb.append(this.title).append(", message=").append(this.message).append(", inputText=").append(this.inputText).append(", inputHint=").append(this.inputHint).append(", cancelText=").append(this.cancelText).append(", confirmText=").append(this.confirmText).append(", dialogWidthPx=").append(this.dialogWidthPx).append(", dimAmount=").append(this.dimAmount).append(", titleGravity=").append(this.titleGravity).append(", titleHorizontalPaddingPx=").append(this.titleHorizontalPaddingPx).append(", cancelTextColor=").append(this.cancelTextColor).append(", confirmTextColor=");
            sb.append(this.confirmTextColor).append(", dialogBgRes=").append(this.dialogBgRes).append(", cancelBgRes=").append(this.cancelBgRes).append(", confirmBgRes=").append(this.confirmBgRes).append(", messageGravity=").append(this.messageGravity).append(", messageHorizontalPaddingPx=").append(this.messageHorizontalPaddingPx).append(", buttonTopMarginPx=").append(this.buttonTopMarginPx).append(", singleButton=").append(this.singleButton).append(", onConfirm=").append(this.onConfirm).append(", onCancel=").append(this.onCancel).append(')');
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Config(String str, String str2, String str3, String str4, String str5, String str6, Integer num, float f, Integer num2, Integer num3, Integer num4, Integer num5, int i, int i2, int i3, Integer num6, Integer num7, Integer num8, boolean z, Function1<? super String, Unit> function1, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str5, "cancelText");
            Intrinsics.checkNotNullParameter(str6, "confirmText");
            Intrinsics.checkNotNullParameter(function1, "onConfirm");
            Intrinsics.checkNotNullParameter(function0, "onCancel");
            this.title = str;
            this.message = str2;
            this.inputText = str3;
            this.inputHint = str4;
            this.cancelText = str5;
            this.confirmText = str6;
            this.dialogWidthPx = num;
            this.dimAmount = f;
            this.titleGravity = num2;
            this.titleHorizontalPaddingPx = num3;
            this.cancelTextColor = num4;
            this.confirmTextColor = num5;
            this.dialogBgRes = i;
            this.cancelBgRes = i2;
            this.confirmBgRes = i3;
            this.messageGravity = num6;
            this.messageHorizontalPaddingPx = num7;
            this.buttonTopMarginPx = num8;
            this.singleButton = z;
            this.onConfirm = function1;
            this.onCancel = function0;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getInputText() {
            return this.inputText;
        }

        public final String getInputHint() {
            return this.inputHint;
        }

        public final String getCancelText() {
            return this.cancelText;
        }

        public final String getConfirmText() {
            return this.confirmText;
        }

        public final Integer getDialogWidthPx() {
            return this.dialogWidthPx;
        }

        public final float getDimAmount() {
            return this.dimAmount;
        }

        public final Integer getTitleGravity() {
            return this.titleGravity;
        }

        public final Integer getTitleHorizontalPaddingPx() {
            return this.titleHorizontalPaddingPx;
        }

        public final Integer getCancelTextColor() {
            return this.cancelTextColor;
        }

        public final Integer getConfirmTextColor() {
            return this.confirmTextColor;
        }

        public /* synthetic */ Config(String str, String str2, String str3, String str4, String str5, String str6, Integer num, float f, Integer num2, Integer num3, Integer num4, Integer num5, int i, int i2, int i3, Integer num6, Integer num7, Integer num8, boolean z, Function1 function1, Function0 function0, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? "" : str5, (i4 & 32) == 0 ? str6 : "", (i4 & 64) != 0 ? null : num, (i4 & 128) != 0 ? 0.5f : f, (i4 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : num2, (i4 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : num3, (i4 & 1024) != 0 ? null : num4, (i4 & 2048) != 0 ? null : num5, (i4 & 4096) != 0 ? C0591R.drawable.trae_bg_custom_dialog : i, (i4 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? 0 : i2, (i4 & 16384) != 0 ? C0591R.drawable.trae_bg_custom_dialog_btn_primary : i3, (i4 & 32768) != 0 ? null : num6, (i4 & 65536) != 0 ? null : num7, (i4 & 131072) != 0 ? null : num8, (i4 & 262144) == 0 ? z : false, (i4 & FConstants.SLICE_SIZE) != 0 ? new Function1() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Config$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit _init_$lambda$0;
                    _init_$lambda$0 = CustomConfirmDialog.Config._init_$lambda$0((String) obj);
                    return _init_$lambda$0;
                }
            } : function1, (i4 & 1048576) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Config$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : function0);
        }

        public final int getDialogBgRes() {
            return this.dialogBgRes;
        }

        public final int getCancelBgRes() {
            return this.cancelBgRes;
        }

        public final int getConfirmBgRes() {
            return this.confirmBgRes;
        }

        public final Integer getMessageGravity() {
            return this.messageGravity;
        }

        public final Integer getMessageHorizontalPaddingPx() {
            return this.messageHorizontalPaddingPx;
        }

        public final Integer getButtonTopMarginPx() {
            return this.buttonTopMarginPx;
        }

        public final boolean getSingleButton() {
            return this.singleButton;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _init_$lambda$0(String str) {
            return Unit.INSTANCE;
        }

        public final Function1<String, Unit> getOnConfirm() {
            return this.onConfirm;
        }

        public final Function0<Unit> getOnCancel() {
            return this.onCancel;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: CustomConfirmDialog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "RENAME", OpenNetMethod.DELETE, "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode RENAME = new Mode("RENAME", 0);
        public static final Mode DELETE = new Mode(OpenNetMethod.DELETE, 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{RENAME, DELETE};
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Mode(String str, int i) {
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0591R.layout.trae_dialog_custom_confirm);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            Integer dialogWidthPx = this.config.getDialogWidthPx();
            window.setLayout(dialogWidthPx != null ? dialogWidthPx.intValue() : (int) (window.getContext().getResources().getDisplayMetrics().widthPixels * 0.8d), -2);
            window.setGravity(17);
            window.setDimAmount(this.config.getDimAmount());
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        TextView textView = (TextView) findViewById(C0591R.id.tv_dialog_title);
        final EditText editText = (EditText) findViewById(C0591R.id.et_input);
        TextView textView2 = (TextView) findViewById(C0591R.id.tv_message);
        TextView textView3 = (TextView) findViewById(C0591R.id.btn_cancel);
        final TextView textView4 = (TextView) findViewById(C0591R.id.btn_confirm);
        findViewById(C0591R.id.v_button_spacer);
        View findViewById = findViewById(C0591R.id.custom_confirm_dialog_root);
        View findViewById2 = findViewById(C0591R.id.ll_buttons);
        int paddingLeft = findViewById.getPaddingLeft();
        int paddingTop = findViewById.getPaddingTop();
        int paddingRight = findViewById.getPaddingRight();
        int paddingBottom = findViewById.getPaddingBottom();
        findViewById.setBackgroundResource(this.config.getDialogBgRes());
        findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        textView.setText(this.config.getTitle());
        Integer titleGravity = this.config.getTitleGravity();
        if (titleGravity != null) {
            textView.setGravity(titleGravity.intValue());
        }
        Integer titleHorizontalPaddingPx = this.config.getTitleHorizontalPaddingPx();
        if (titleHorizontalPaddingPx != null) {
            int intValue = titleHorizontalPaddingPx.intValue();
            textView.setPadding(intValue, textView.getPaddingTop(), intValue, textView.getPaddingBottom());
        }
        Integer buttonTopMarginPx = this.config.getButtonTopMarginPx();
        if (buttonTopMarginPx != null) {
            int intValue2 = buttonTopMarginPx.intValue();
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = intValue2;
                findViewById2.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.config.getInputText() != null) {
            editText.setVisibility(0);
            textView2.setVisibility(8);
            editText.setText(this.config.getInputText());
            String inputHint = this.config.getInputHint();
            if (inputHint != null) {
                editText.setHint(inputHint);
            }
            editText.setSelection(editText.getText().length());
            editText.requestFocus();
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setSoftInputMode(5);
            }
            onCreate$updateConfirmState(textView4, this.config.getInputText());
            editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$onCreate$6
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    TextView textView5 = textView4;
                    String obj = s != null ? s.toString() : null;
                    if (obj == null) {
                        obj = "";
                    }
                    CustomConfirmDialog.onCreate$updateConfirmState(textView5, obj);
                }
            });
        } else if (this.config.getMessage() != null) {
            editText.setVisibility(8);
            textView2.setVisibility(0);
            textView2.setText(this.config.getMessage());
            Integer messageGravity = this.config.getMessageGravity();
            if (messageGravity != null) {
                textView2.setGravity(messageGravity.intValue());
            }
            Integer messageHorizontalPaddingPx = this.config.getMessageHorizontalPaddingPx();
            if (messageHorizontalPaddingPx != null) {
                int intValue3 = messageHorizontalPaddingPx.intValue();
                textView2.setPadding(intValue3, textView2.getPaddingTop(), intValue3, textView2.getPaddingBottom());
            }
        } else {
            editText.setVisibility(8);
            textView2.setVisibility(8);
        }
        if (this.config.getSingleButton()) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(this.config.getCancelText());
            Integer cancelTextColor = this.config.getCancelTextColor();
            if (cancelTextColor != null) {
                textView3.setTextColor(cancelTextColor.intValue());
            }
            if (this.config.getCancelBgRes() != 0) {
                textView3.setBackgroundResource(this.config.getCancelBgRes());
            }
        }
        textView4.setText(this.config.getConfirmText());
        Integer confirmTextColor = this.config.getConfirmTextColor();
        if (confirmTextColor != null) {
            textView4.setTextColor(confirmTextColor.intValue());
        }
        if (this.config.getConfirmBgRes() != 0) {
            textView4.setBackgroundResource(this.config.getConfirmBgRes());
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomConfirmDialog.onCreate$lambda$10(CustomConfirmDialog.this, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomConfirmDialog.onCreate$lambda$11(CustomConfirmDialog.this, editText, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$updateConfirmState(TextView textView, String str) {
        boolean z = StringsKt.trim(str).toString().length() > 0;
        textView.setEnabled(z);
        textView.setAlpha(z ? 1.0f : 0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$10(CustomConfirmDialog customConfirmDialog, View view) {
        customConfirmDialog.config.getOnCancel().invoke();
        customConfirmDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$11(CustomConfirmDialog customConfirmDialog, EditText editText, View view) {
        if (customConfirmDialog.config.getInputText() != null) {
            customConfirmDialog.config.getOnConfirm().invoke(editText.getText().toString());
        } else {
            customConfirmDialog.config.getOnConfirm().invoke((Object) null);
        }
        customConfirmDialog.dismiss();
    }

    /* compiled from: CustomConfirmDialog.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012JÇ\u0001\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\b\u0003\u0010\u001e\u001a\u00020\u00162\b\b\u0003\u0010\u001f\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;", "", "<init>", "()V", "rename", "Lcom/bytedance/trae/common/widget/CustomConfirmDialog;", "context", "Landroid/content/Context;", "title", "", "currentTitle", "inputHint", "cancelText", "confirmText", "onConfirm", "Lkotlin/Function1;", "", "onCancel", "Lkotlin/Function0;", "delete", "message", "dialogWidthPx", "", "titleGravity", "titleHorizontalPaddingPx", "messageGravity", "messageHorizontalPaddingPx", "buttonTopMarginPx", "cancelTextColor", "confirmTextColor", "cancelBgRes", "confirmBgRes", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomConfirmDialog rename(Context context, String title, String currentTitle, String inputHint, String cancelText, String confirmText, Function1<? super String, Unit> onConfirm, Function0<Unit> onCancel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(currentTitle, "currentTitle");
            Intrinsics.checkNotNullParameter(cancelText, "cancelText");
            Intrinsics.checkNotNullParameter(confirmText, "confirmText");
            Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
            Intrinsics.checkNotNullParameter(onCancel, "onCancel");
            int i = 0;
            return new CustomConfirmDialog(context, new Config(title, null, currentTitle, inputHint, cancelText, confirmText, null, 0.0f, null, null, null, null, i, i, i, null, null, null, false, onConfirm, onCancel, 524226, null));
        }

        public final CustomConfirmDialog delete(Context context, String title, String message, String cancelText, String confirmText, Integer dialogWidthPx, Integer titleGravity, Integer titleHorizontalPaddingPx, Integer messageGravity, Integer messageHorizontalPaddingPx, Integer buttonTopMarginPx, Integer cancelTextColor, Integer confirmTextColor, int cancelBgRes, int confirmBgRes, final Function0<Unit> onConfirm, Function0<Unit> onCancel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(cancelText, "cancelText");
            Intrinsics.checkNotNullParameter(confirmText, "confirmText");
            Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
            Intrinsics.checkNotNullParameter(onCancel, "onCancel");
            return new CustomConfirmDialog(context, new Config(title, message, null, null, cancelText, confirmText, dialogWidthPx, 0.0f, titleGravity, titleHorizontalPaddingPx, cancelTextColor, confirmTextColor, 0, cancelBgRes, confirmBgRes, messageGravity, messageHorizontalPaddingPx, buttonTopMarginPx, cancelText.length() == 0, new Function1() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Companion$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit delete$lambda$2;
                    delete$lambda$2 = CustomConfirmDialog.Companion.delete$lambda$2(onConfirm, (String) obj);
                    return delete$lambda$2;
                }
            }, onCancel, 4236, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit delete$lambda$2(Function0 function0, String str) {
            function0.invoke();
            return Unit.INSTANCE;
        }
    }
}
