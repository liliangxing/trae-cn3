package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.p002ui.graphics.Matrix;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
/* synthetic */ class C0451x8f2ae8f3 extends FunctionReferenceImpl implements Function1<Matrix, Unit> {
    final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0451x8f2ae8f3(LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode) {
        super(1, Intrinsics.Kotlin.class, "localToScreen", "startInput$localToScreen(Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;[F)V", 0);
        this.$node = legacyPlatformTextInputNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1764invoke58bKbWc(((Matrix) obj).m5105unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-58bKbWc, reason: not valid java name */
    public final void m1764invoke58bKbWc(float[] fArr) {
        AndroidLegacyPlatformTextInputServiceAdapter.startInput$localToScreen(this.$node, fArr);
    }
}
