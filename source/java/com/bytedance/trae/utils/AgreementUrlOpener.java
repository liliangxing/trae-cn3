package com.bytedance.trae.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.ttm.player.C;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgreementUrlOpener.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/utils/AgreementUrlOpener;", "", "<init>", "()V", "PRIVACY_AGREED_FLAG", "", "SIMPLE_WEBVIEW_ACTIVITY", PushCommonConstants.VALUE_OPEN, "", "context", "Landroid/content/Context;", "url", "isPrivacyAgreed", "", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AgreementUrlOpener {
    public static final AgreementUrlOpener INSTANCE = new AgreementUrlOpener();
    private static final String PRIVACY_AGREED_FLAG = "privacy_agreed";
    private static final String SIMPLE_WEBVIEW_ACTIVITY = "com.bytedance.trae.common.activity.SimpleWebViewActivity";

    private AgreementUrlOpener() {
    }

    public final void open(Context context, String url) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (isPrivacyAgreed(context)) {
            intent = new Intent();
            intent.setClassName(context.getPackageName(), SIMPLE_WEBVIEW_ACTIVITY);
            intent.putExtra("extra_url", url);
        } else {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        context.startActivity(intent);
    }

    private final boolean isPrivacyAgreed(Context context) {
        return new File(context.getFilesDir(), PRIVACY_AGREED_FLAG).exists();
    }
}
