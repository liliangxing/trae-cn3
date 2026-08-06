package com.bytedance.trae.home.zlink;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timon.clipboard.suite.TimonClipboardSuite;
import com.bytedance.timon.clipboard.suite.cert.EmptyCert;
import com.bytedance.ug.sdk.deeplink.interfaces.IClipboard;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimonClipboardImpl.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/home/zlink/TimonClipboardImpl;", "Lcom/bytedance/ug/sdk/deeplink/interfaces/IClipboard;", "<init>", "()V", "cert", "Lcom/bytedance/bpea/basics/Cert;", "getCert", "()Lcom/bytedance/bpea/basics/Cert;", "cert$delegate", "Lkotlin/Lazy;", "getClipBoardContent", "Landroid/content/ClipData;", "context", "Landroid/content/Context;", "clearClipBoard", "", "label", "", "clipData", "appendTextToClipboard", "text", "", "writeClipBoard", ReportConstant.COMMON_CONTENT, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TimonClipboardImpl implements IClipboard {
    private static final String TAG = "TimonClipboardImpl";

    /* renamed from: cert$delegate, reason: from kotlin metadata */
    private final Lazy cert = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.home.zlink.TimonClipboardImpl$$ExternalSyntheticLambda0
        public final Object invoke() {
            Cert cert_delegate$lambda$0;
            cert_delegate$lambda$0 = TimonClipboardImpl.cert_delegate$lambda$0();
            return cert_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    public ClipData getClipBoardContent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cert cert_delegate$lambda$0() {
        return EmptyCert.INSTANCE.genEmptyCert();
    }

    private final Cert getCert() {
        return (Cert) this.cert.getValue();
    }

    public void clearClipBoard(Context context, String label, ClipData clipData) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            TimonClipboardSuite.INSTANCE.clearPrimaryClip(getCert(), null);
        } catch (Exception e) {
            Log.w(TAG, "clearClipBoard failed", e);
        }
    }

    public void clearClipBoard(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            TimonClipboardSuite.INSTANCE.clearPrimaryClip(getCert(), null);
        } catch (Exception e) {
            Log.w(TAG, "clearClipBoard failed", e);
        }
    }

    public void appendTextToClipboard(Context context, CharSequence text) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (text == null) {
            return;
        }
        try {
            TimonClipboardSuite.INSTANCE.setText(getCert(), text, null);
        } catch (Exception e) {
            Log.w(TAG, "appendTextToClipboard failed", e);
        }
    }

    public void writeClipBoard(Context context, CharSequence label, CharSequence content) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (content == null) {
            return;
        }
        try {
            TimonClipboardSuite.INSTANCE.setText(getCert(), content, null);
        } catch (Exception e) {
            Log.w(TAG, "writeClipBoard failed", e);
        }
    }
}
