package com.bytedance.trae.home.zlink;

import android.content.Context;
import android.util.Log;
import com.bytedance.timon.clipboard.suite.TimonClipboardSuite;
import com.bytedance.timon.clipboard.suite.cert.EmptyCert;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ZlinkClipboardUtil.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/home/zlink/ZlinkClipboardUtil;", "", "<init>", "()V", "TAG", "", "clearClipboard", "", "context", "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ZlinkClipboardUtil {
    public static final int $stable = 0;
    public static final ZlinkClipboardUtil INSTANCE = new ZlinkClipboardUtil();
    private static final String TAG = "ZlinkClipboardUtil";

    private ZlinkClipboardUtil() {
    }

    public final void clearClipboard(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            TimonClipboardSuite.INSTANCE.clearPrimaryClip(EmptyCert.INSTANCE.genEmptyCert(), null);
        } catch (Exception e) {
            Log.w(TAG, "clearClipboard via Timon failed", e);
        }
        Log.d(TAG, "clearClipboard done");
    }
}
