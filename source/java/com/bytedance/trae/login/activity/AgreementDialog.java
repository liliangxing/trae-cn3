package com.bytedance.trae.login.activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.AgreementUrlOpener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AgreementDialog.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/login/activity/AgreementDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "onAgreeClick", "Lkotlin/Function0;", "", "onDisagreeClick", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupMessageWithLinks", "setupLegalNotice", "openUrl", "url", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AgreementDialog extends Dialog {
    private final Function0<Unit> onAgreeClick;
    private final Function0<Unit> onDisagreeClick;

    public /* synthetic */ AgreementDialog(Context context, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new Function0() { // from class: com.bytedance.trae.login.activity.AgreementDialog$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function0, (i & 4) != 0 ? new Function0() { // from class: com.bytedance.trae.login.activity.AgreementDialog$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function02);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreementDialog(Context context, Function0<Unit> function0, Function0<Unit> function02) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onAgreeClick");
        Intrinsics.checkNotNullParameter(function02, "onDisagreeClick");
        this.onAgreeClick = function0;
        this.onDisagreeClick = function02;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0820R.layout.trae_dialog_agreement);
        final Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-2, -2);
            final int i = (int) (window.getContext().getResources().getDisplayMetrics().heightPixels * 0.7d);
            window.getDecorView().post(new Runnable() { // from class: com.bytedance.trae.login.activity.AgreementDialog$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AgreementDialog.onCreate$lambda$3$lambda$2(window, i);
                }
            });
            window.setGravity(17);
            window.setDimAmount(0.4f);
        }
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setupMessageWithLinks();
        setupLegalNotice();
        findViewById(C0820R.id.btn_agree).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.AgreementDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgreementDialog.onCreate$lambda$4(AgreementDialog.this, view);
            }
        });
        findViewById(C0820R.id.btn_disagree).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.AgreementDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgreementDialog.onCreate$lambda$5(AgreementDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$2(Window window, int i) {
        if (window.getDecorView().getHeight() > i) {
            window.setLayout(-2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(AgreementDialog agreementDialog, View view) {
        agreementDialog.dismiss();
        agreementDialog.onAgreeClick.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(AgreementDialog agreementDialog, View view) {
        agreementDialog.dismiss();
        agreementDialog.onDisagreeClick.invoke();
    }

    private final void setupMessageWithLinks() {
        TextView textView = (TextView) findViewById(C0820R.id.tv_message);
        String string = getContext().getString(C0882R.string.trae_agreement_dialog_message);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getContext().getString(C0882R.string.trae_agreement_dialog_terms);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getContext().getString(C0882R.string.trae_agreement_dialog_privacy);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String str = string;
        SpannableString spannableString = new SpannableString(str);
        int indexOf$default = StringsKt.indexOf$default(str, string2, 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.trae.login.activity.AgreementDialog$setupMessageWithLinks$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    AgreementDialog.this.openUrl("https://www.trae.cn/terms-of-service");
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    ds.setColor(-13667073);
                    ds.setUnderlineText(false);
                }
            }, indexOf$default, string2.length() + indexOf$default, 33);
        }
        int indexOf$default2 = StringsKt.indexOf$default(str, string3, 0, false, 6, (Object) null);
        if (indexOf$default2 >= 0) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.trae.login.activity.AgreementDialog$setupMessageWithLinks$2
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    AgreementDialog.this.openUrl("https://www.trae.cn/privacy-policy");
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    ds.setColor(-13667073);
                    ds.setUnderlineText(false);
                }
            }, indexOf$default2, string3.length() + indexOf$default2, 33);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
    }

    private final void setupLegalNotice() {
        TextView textView = (TextView) findViewById(C0820R.id.tv_legal_notice);
        if (textView == null) {
            return;
        }
        textView.setText(getContext().getString(C0882R.string.trae_agreement_dialog_legal_notice));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(String url) {
        try {
            AgreementUrlOpener agreementUrlOpener = AgreementUrlOpener.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            agreementUrlOpener.open(context, url);
        } catch (Exception unused) {
        }
    }
}
