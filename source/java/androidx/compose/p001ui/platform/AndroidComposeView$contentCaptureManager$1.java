package androidx.compose.p001ui.platform;

import android.view.View;
import androidx.compose.p001ui.platform.coreshims.ContentCaptureSessionCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidComposeView.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public /* synthetic */ class AndroidComposeView$contentCaptureManager$1 extends FunctionReferenceImpl implements Function0<ContentCaptureSessionCompat> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidComposeView$contentCaptureManager$1(Object obj) {
        super(0, obj, AndroidComposeView_androidKt.class, "getContentCaptureSessionCompat", "getContentCaptureSessionCompat(Landroid/view/View;)Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", 1);
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ContentCaptureSessionCompat m1686invoke() {
        ContentCaptureSessionCompat contentCaptureSessionCompat;
        contentCaptureSessionCompat = AndroidComposeView_androidKt.getContentCaptureSessionCompat((View) this.receiver);
        return contentCaptureSessionCompat;
    }
}
