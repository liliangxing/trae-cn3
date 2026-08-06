package com.bytedance.trae.common.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.common_ui.R;
import com.ss.ttm.player.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionRationaleDialog.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "config", "Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;", "<init>", "(Landroid/content/Context;Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Config", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionRationaleDialog extends Dialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Config config;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionRationaleDialog(Context context, Config config) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    /* compiled from: PermissionRationaleDialog.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003Jy\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001a¨\u0006,"}, d2 = {"Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;", "", "iconResId", "", "title", "", "message", "allowText", "denyText", "denyPermanentText", "onAllow", "Lkotlin/Function0;", "", "onDeny", "onDenyPermanent", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getIconResId", "()I", "getTitle", "()Ljava/lang/String;", "getMessage", "getAllowText", "getDenyText", "getDenyPermanentText", "getOnAllow", "()Lkotlin/jvm/functions/Function0;", "getOnDeny", "getOnDenyPermanent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Config {
        private final String allowText;
        private final String denyPermanentText;
        private final String denyText;
        private final int iconResId;
        private final String message;
        private final Function0<Unit> onAllow;
        private final Function0<Unit> onDeny;
        private final Function0<Unit> onDenyPermanent;
        private final String title;

        /* renamed from: component1, reason: from getter */
        public final int getIconResId() {
            return this.iconResId;
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
        public final String getAllowText() {
            return this.allowText;
        }

        /* renamed from: component5, reason: from getter */
        public final String getDenyText() {
            return this.denyText;
        }

        /* renamed from: component6, reason: from getter */
        public final String getDenyPermanentText() {
            return this.denyPermanentText;
        }

        public final Function0<Unit> component7() {
            return this.onAllow;
        }

        public final Function0<Unit> component8() {
            return this.onDeny;
        }

        public final Function0<Unit> component9() {
            return this.onDenyPermanent;
        }

        public final Config copy(int iconResId, String title, String message, String allowText, String denyText, String denyPermanentText, Function0<Unit> onAllow, Function0<Unit> onDeny, Function0<Unit> onDenyPermanent) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(allowText, "allowText");
            Intrinsics.checkNotNullParameter(denyText, "denyText");
            Intrinsics.checkNotNullParameter(onAllow, "onAllow");
            Intrinsics.checkNotNullParameter(onDeny, "onDeny");
            return new Config(iconResId, title, message, allowText, denyText, denyPermanentText, onAllow, onDeny, onDenyPermanent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.iconResId == config.iconResId && Intrinsics.areEqual(this.title, config.title) && Intrinsics.areEqual(this.message, config.message) && Intrinsics.areEqual(this.allowText, config.allowText) && Intrinsics.areEqual(this.denyText, config.denyText) && Intrinsics.areEqual(this.denyPermanentText, config.denyPermanentText) && Intrinsics.areEqual(this.onAllow, config.onAllow) && Intrinsics.areEqual(this.onDeny, config.onDeny) && Intrinsics.areEqual(this.onDenyPermanent, config.onDenyPermanent);
        }

        public int hashCode() {
            int hashCode = ((((((((Integer.hashCode(this.iconResId) * 31) + this.title.hashCode()) * 31) + this.message.hashCode()) * 31) + this.allowText.hashCode()) * 31) + this.denyText.hashCode()) * 31;
            String str = this.denyPermanentText;
            int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.onAllow.hashCode()) * 31) + this.onDeny.hashCode()) * 31;
            Function0<Unit> function0 = this.onDenyPermanent;
            return hashCode2 + (function0 != null ? function0.hashCode() : 0);
        }

        public String toString() {
            return "Config(iconResId=" + this.iconResId + ", title=" + this.title + ", message=" + this.message + ", allowText=" + this.allowText + ", denyText=" + this.denyText + ", denyPermanentText=" + this.denyPermanentText + ", onAllow=" + this.onAllow + ", onDeny=" + this.onDeny + ", onDenyPermanent=" + this.onDenyPermanent + ')';
        }

        public Config(int i, String title, String message, String allowText, String denyText, String str, Function0<Unit> onAllow, Function0<Unit> onDeny, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(allowText, "allowText");
            Intrinsics.checkNotNullParameter(denyText, "denyText");
            Intrinsics.checkNotNullParameter(onAllow, "onAllow");
            Intrinsics.checkNotNullParameter(onDeny, "onDeny");
            this.iconResId = i;
            this.title = title;
            this.message = message;
            this.allowText = allowText;
            this.denyText = denyText;
            this.denyPermanentText = str;
            this.onAllow = onAllow;
            this.onDeny = onDeny;
            this.onDenyPermanent = function0;
        }

        public final int getIconResId() {
            return this.iconResId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getAllowText() {
            return this.allowText;
        }

        public final String getDenyText() {
            return this.denyText;
        }

        public final String getDenyPermanentText() {
            return this.denyPermanentText;
        }

        public /* synthetic */ Config(int i, String str, String str2, String str3, String str4, String str5, Function0 function0, Function0 function02, Function0 function03, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, str, str2, str3, str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$Config$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : function0, (i2 & 128) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$Config$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            } : function02, (i2 & 256) != 0 ? null : function03);
        }

        public final Function0<Unit> getOnAllow() {
            return this.onAllow;
        }

        public final Function0<Unit> getOnDeny() {
            return this.onDeny;
        }

        public final Function0<Unit> getOnDenyPermanent() {
            return this.onDenyPermanent;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trae_dialog_permission_rationale);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout((int) (window.getContext().getResources().getDisplayMetrics().widthPixels * 0.8d), -2);
            window.setGravity(17);
            window.setDimAmount(0.4f);
        }
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        ImageView imageView = (ImageView) findViewById(R.id.iv_icon);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        TextView textView2 = (TextView) findViewById(R.id.tv_message);
        TextView textView3 = (TextView) findViewById(R.id.btn_allow);
        TextView textView4 = (TextView) findViewById(R.id.btn_deny);
        TextView textView5 = (TextView) findViewById(R.id.btn_deny_permanent);
        if (this.config.getIconResId() != 0) {
            imageView.setImageResource(this.config.getIconResId());
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(this.config.getTitle());
        textView2.setText(this.config.getMessage());
        textView3.setText(this.config.getAllowText());
        textView4.setText(this.config.getDenyText());
        if (this.config.getDenyPermanentText() != null) {
            textView5.setVisibility(0);
            textView5.setText(this.config.getDenyPermanentText());
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PermissionRationaleDialog.onCreate$lambda$1(PermissionRationaleDialog.this, view);
                }
            });
        } else {
            textView5.setVisibility(8);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionRationaleDialog.onCreate$lambda$2(PermissionRationaleDialog.this, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.common.widget.PermissionRationaleDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionRationaleDialog.onCreate$lambda$3(PermissionRationaleDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(PermissionRationaleDialog permissionRationaleDialog, View view) {
        permissionRationaleDialog.dismiss();
        Function0<Unit> onDenyPermanent = permissionRationaleDialog.config.getOnDenyPermanent();
        if (onDenyPermanent != null) {
            onDenyPermanent.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(PermissionRationaleDialog permissionRationaleDialog, View view) {
        permissionRationaleDialog.dismiss();
        permissionRationaleDialog.config.getOnAllow().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(PermissionRationaleDialog permissionRationaleDialog, View view) {
        permissionRationaleDialog.dismiss();
        permissionRationaleDialog.config.getOnDeny().invoke();
    }

    /* compiled from: PermissionRationaleDialog.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJl\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJV\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;", "", "<init>", "()V", "showForPermission", "Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;", "context", "Landroid/content/Context;", "iconResId", "", "titleResId", "messageResId", "allowTextResId", "denyTextResId", "onAllow", "Lkotlin/Function0;", "", "onDeny", "showForNotification", "denyPermanentTextResId", "onDenyPermanent", "showDeniedGoSettings", "goSettingsTextResId", "laterTextResId", "onGoSettings", "onLater", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PermissionRationaleDialog showForPermission(Context context, int iconResId, int titleResId, int messageResId, int allowTextResId, int denyTextResId, Function0<Unit> onAllow, Function0<Unit> onDeny) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onAllow, "onAllow");
            Intrinsics.checkNotNullParameter(onDeny, "onDeny");
            String string = context.getString(titleResId);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = context.getString(messageResId);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = context.getString(allowTextResId);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = context.getString(denyTextResId);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            PermissionRationaleDialog permissionRationaleDialog = new PermissionRationaleDialog(context, new Config(iconResId, string, string2, string3, string4, null, onAllow, onDeny, null, 288, null));
            permissionRationaleDialog.show();
            return permissionRationaleDialog;
        }

        public final PermissionRationaleDialog showForNotification(Context context, int iconResId, int titleResId, int messageResId, int allowTextResId, int denyTextResId, int denyPermanentTextResId, Function0<Unit> onAllow, Function0<Unit> onDeny, Function0<Unit> onDenyPermanent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onAllow, "onAllow");
            Intrinsics.checkNotNullParameter(onDeny, "onDeny");
            Intrinsics.checkNotNullParameter(onDenyPermanent, "onDenyPermanent");
            String string = context.getString(titleResId);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = context.getString(messageResId);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = context.getString(allowTextResId);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = context.getString(denyTextResId);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            PermissionRationaleDialog permissionRationaleDialog = new PermissionRationaleDialog(context, new Config(iconResId, string, string2, string3, string4, context.getString(denyPermanentTextResId), onAllow, onDeny, onDenyPermanent));
            permissionRationaleDialog.show();
            return permissionRationaleDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit showDeniedGoSettings$lambda$4(Context context) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }

        public final PermissionRationaleDialog showDeniedGoSettings(Context context, int iconResId, int titleResId, int messageResId, int goSettingsTextResId, int laterTextResId, Function0<Unit> onGoSettings, Function0<Unit> onLater) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onGoSettings, "onGoSettings");
            Intrinsics.checkNotNullParameter(onLater, "onLater");
            String string = context.getString(titleResId);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = context.getString(messageResId);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = context.getString(goSettingsTextResId);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = context.getString(laterTextResId);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            PermissionRationaleDialog permissionRationaleDialog = new PermissionRationaleDialog(context, new Config(iconResId, string, string2, string3, string4, null, onGoSettings, onLater, null, 288, null));
            permissionRationaleDialog.show();
            return permissionRationaleDialog;
        }
    }
}
