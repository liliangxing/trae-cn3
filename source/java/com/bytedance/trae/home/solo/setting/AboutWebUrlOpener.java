package com.bytedance.trae.home.solo.setting;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.common.activity.SimpleWebViewActivity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.im.model.MessagePart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AboutWebUrlOpener.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/AboutWebUrlOpener;", "", "<init>", "()V", "open", "", "context", "Landroid/content/Context;", IWeixinService.ResponseConstants.URL, "", "buildAnnieXWebUri", "Landroid/net/Uri;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AboutWebUrlOpener {
    public static final int $stable = 0;
    public static final AboutWebUrlOpener INSTANCE = new AboutWebUrlOpener();

    private AboutWebUrlOpener() {
    }

    public final void open(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        if (AppHost.INSTANCE.isOversea()) {
            SimpleWebViewActivity.Companion.start$default(SimpleWebViewActivity.INSTANCE, context, url, false, 4, null);
        } else {
            AnnieX.open$default(AnnieX.INSTANCE, context, buildAnnieXWebUri(url), (Function1) null, 4, (Object) null);
        }
    }

    private final Uri buildAnnieXWebUri(String url) {
        Uri build = new Uri.Builder().scheme("sslocal").authority(MessagePart.TYPE_WEBVIEW).appendQueryParameter("hide_nav_bar", "1").appendQueryParameter(IWeixinService.ResponseConstants.URL, url).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}
