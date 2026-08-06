package androidx.compose.foundation.text.input.internal;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt$inputMethodManagerFactory$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
/* synthetic */ class C0466xe9f87565 extends FunctionReferenceImpl implements Function1<View, InputMethodManagerImpl> {
    public static final C0466xe9f87565 INSTANCE = new C0466xe9f87565();

    C0466xe9f87565() {
        super(1, InputMethodManagerImpl.class, "<init>", "<init>(Landroid/view/View;)V", 0);
    }

    public final InputMethodManagerImpl invoke(View view) {
        return new InputMethodManagerImpl(view);
    }
}
