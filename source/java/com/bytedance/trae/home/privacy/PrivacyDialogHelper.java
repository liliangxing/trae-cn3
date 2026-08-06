package com.bytedance.trae.home.privacy;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.utils.AgreementUrlOpener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PrivacyDialogHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;", "", "<init>", "()V", "TAG", "", "baseDomain", "getBaseDomain", "()Ljava/lang/String;", "showDialog", "", "activity", "Landroidx/activity/ComponentActivity;", "onAgree", "Lkotlin/Function0;", "onDisagree", "setupMessageWithLinks", "view", "Landroid/view/View;", "setupLegalNotice", "openUrl", IWeixinService.ResponseConstants.URL, "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PrivacyDialogHelper {
    public static final int $stable = 0;
    public static final PrivacyDialogHelper INSTANCE = new PrivacyDialogHelper();
    private static final String TAG = "PrivacyDialogHelper";

    private PrivacyDialogHelper() {
    }

    private final String getBaseDomain() {
        return AppHost.INSTANCE.isOversea() ? "trae.ai" : "trae.cn";
    }

    public final void showDialog(final ComponentActivity activity, final Function0<Unit> onAgree, final Function0<Unit> onDisagree) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onAgree, "onAgree");
        Intrinsics.checkNotNullParameter(onDisagree, "onDisagree");
        Log.d(TAG, "showDialog curMills = " + System.currentTimeMillis());
        Context context = (Context) activity;
        final Dialog dialog = new Dialog(context);
        View inflate = LayoutInflater.from(context).inflate(C0820R.layout.dialog_privacy, (ViewGroup) null);
        dialog.setContentView(inflate);
        final Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            final int i = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.8d);
            window.setLayout((int) (activity.getResources().getDisplayMetrics().widthPixels * 0.85d), -2);
            window.getDecorView().post(new Runnable() { // from class: com.bytedance.trae.home.privacy.PrivacyDialogHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PrivacyDialogHelper.showDialog$lambda$1$lambda$0(window, i, activity);
                }
            });
            window.setGravity(17);
            window.setDimAmount(0.5f);
        }
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Intrinsics.checkNotNull(inflate);
        setupMessageWithLinks(activity, inflate);
        ((TextView) inflate.findViewById(C0820R.id.btn_agree)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.privacy.PrivacyDialogHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyDialogHelper.showDialog$lambda$2(dialog, onAgree, view);
            }
        });
        ((TextView) inflate.findViewById(C0820R.id.btn_disagree)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.privacy.PrivacyDialogHelper$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyDialogHelper.showDialog$lambda$3(dialog, onDisagree, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$1$lambda$0(Window window, int i, ComponentActivity componentActivity) {
        if (window.getDecorView().getHeight() > i) {
            window.setLayout((int) (componentActivity.getResources().getDisplayMetrics().widthPixels * 0.85d), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$2(Dialog dialog, Function0 function0, View view) {
        dialog.dismiss();
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$3(Dialog dialog, Function0 function0, View view) {
        dialog.dismiss();
        function0.invoke();
    }

    public final void setupMessageWithLinks(final ComponentActivity activity, View view) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        TextView textView = (TextView) view.findViewById(C0820R.id.tv_message);
        String string = activity.getString(C0820R.string.trae_privacy_dialog_message);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = activity.getString(C0820R.string.trae_privacy_dialog_terms);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = activity.getString(C0820R.string.trae_privacy_dialog_privacy);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String str = string;
        SpannableString spannableString = new SpannableString(str);
        int indexOf$default = StringsKt.indexOf$default(str, string2, 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            final String str2 = "https://www." + getBaseDomain() + "/terms-of-service";
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.trae.home.privacy.PrivacyDialogHelper$setupMessageWithLinks$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    PrivacyDialogHelper.INSTANCE.openUrl(activity, str2);
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
            final String str3 = "https://www." + getBaseDomain() + "/privacy-policy";
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.trae.home.privacy.PrivacyDialogHelper$setupMessageWithLinks$2
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    PrivacyDialogHelper.INSTANCE.openUrl(activity, str3);
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
        setupLegalNotice(activity, view);
    }

    private final void setupLegalNotice(ComponentActivity activity, View view) {
        TextView textView = (TextView) view.findViewById(C0820R.id.tv_legal_notice);
        if (textView == null) {
            return;
        }
        textView.setText(activity.getString(C0820R.string.trae_privacy_dialog_legal_notice));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(ComponentActivity activity, String url) {
        try {
            AgreementUrlOpener.INSTANCE.open((Context) activity, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
