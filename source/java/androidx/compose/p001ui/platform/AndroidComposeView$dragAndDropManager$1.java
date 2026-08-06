package androidx.compose.p001ui.platform;

import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidComposeView.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public /* synthetic */ class AndroidComposeView$dragAndDropManager$1 extends FunctionReferenceImpl implements Function3<DragAndDropTransferData, Size, Function1<? super DrawScope, ? extends Unit>, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidComposeView$dragAndDropManager$1(Object obj) {
        super(3, obj, AndroidComposeView.class, "startDrag", "startDrag-12SF9DM(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m1689invoke12SF9DM((DragAndDropTransferData) obj, ((Size) obj2).unbox-impl(), (Function1) obj3);
    }

    /* renamed from: invoke-12SF9DM, reason: not valid java name */
    public final Boolean m1689invoke12SF9DM(DragAndDropTransferData dragAndDropTransferData, long j, Function1<? super DrawScope, Unit> function1) {
        boolean m1676startDrag12SF9DM;
        m1676startDrag12SF9DM = ((AndroidComposeView) this.receiver).m1676startDrag12SF9DM(dragAndDropTransferData, j, function1);
        return Boolean.valueOf(m1676startDrag12SF9DM);
    }
}
