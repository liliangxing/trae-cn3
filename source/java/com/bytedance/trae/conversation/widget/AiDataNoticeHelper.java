package com.bytedance.trae.conversation.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.trae.common.activity.SimpleWebViewActivity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.C0637R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AiDataNoticeHelper.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_ACCEPTED", "isAccepted", "", "context", "Landroid/content/Context;", "showIfNeeded", "", "activity", "Landroidx/activity/ComponentActivity;", "onAccepted", "Lkotlin/Function0;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AiDataNoticeHelper {
    public static final AiDataNoticeHelper INSTANCE = new AiDataNoticeHelper();
    private static final String KEY_ACCEPTED = "accepted";
    private static final String PREFS_NAME = "ai_data_notice";

    private AiDataNoticeHelper() {
    }

    public final boolean isAccepted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREFS_NAME, 0).getBoolean(KEY_ACCEPTED, false);
    }

    public final void showIfNeeded(final ComponentActivity activity, final Function0<Unit> onAccepted) {
        int i;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onAccepted, "onAccepted");
        Context context = (Context) activity;
        if (isAccepted(context)) {
            onAccepted.invoke();
            return;
        }
        final Dialog dialog = new Dialog(context);
        View inflate = LayoutInflater.from(context).inflate(C0637R.layout.dialog_ai_data_notice, (ViewGroup) null);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout((int) (activity.getResources().getDisplayMetrics().widthPixels * 0.85d), -2);
            window.setGravity(17);
            window.setDimAmount(0.5f);
        }
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        TextView textView = (TextView) inflate.findViewById(C0637R.id.tv_message);
        if (AppHost.INSTANCE.isOversea()) {
            i = C0637R.string.trae_ai_data_notice_message;
        } else {
            i = C0637R.string.trae_ai_data_notice_message_cn;
        }
        textView.setText(activity.getString(i));
        String obj = textView.getText().toString();
        String string = activity.getString(AppHost.INSTANCE.isOversea() ? C0637R.string.trae_ai_data_notice_privacy_policy : C0637R.string.trae_ai_data_notice_privacy_policy_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = obj;
        int indexOf$default = StringsKt.indexOf$default(str, string, 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            SpannableString spannableString = new SpannableString(str);
            final String str2 = AppHost.INSTANCE.isOversea() ? "https://www.trae.ai/privacy-policy?platform=h5" : "https://www.trae.cn/privacy-policy?platform=h5";
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.trae.conversation.widget.AiDataNoticeHelper$showIfNeeded$2
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    try {
                        if (AppHost.INSTANCE.isOversea()) {
                            SimpleWebViewActivity.Companion.start$default(SimpleWebViewActivity.Companion, activity, str2, false, 4, null);
                        } else {
                            String str3 = "sslocal://webview?hide_nav_bar=1&url=" + Uri.encode(str2, ":/?=&#");
                            AnnieX annieX = AnnieX.INSTANCE;
                            Context context2 = activity;
                            Uri parse = Uri.parse(str3);
                            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                            AnnieX.open$default(annieX, context2, parse, (Function1) null, 4, (Object) null);
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    ds.setColor(-13667073);
                    ds.setUnderlineText(false);
                }
            }, indexOf$default, string.length() + indexOf$default, 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        ((TextView) inflate.findViewById(C0637R.id.btn_ok)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.AiDataNoticeHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AiDataNoticeHelper.showIfNeeded$lambda$1(activity, dialog, onAccepted, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showIfNeeded$lambda$1(ComponentActivity componentActivity, Dialog dialog, Function0 function0, View view) {
        componentActivity.getSharedPreferences(PREFS_NAME, 0).edit().putBoolean(KEY_ACCEPTED, true).apply();
        dialog.dismiss();
        function0.invoke();
    }
}
