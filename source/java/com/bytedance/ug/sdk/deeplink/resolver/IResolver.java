package com.bytedance.ug.sdk.deeplink.resolver;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ug.sdk.deeplink.utils.UGLogger;

/* loaded from: classes4.dex */
public interface IResolver {
    void consume(Context context, Uri uri, boolean z, UGLogger.LogContext logContext);

    boolean isSelf(Uri uri);

    String tag();
}
