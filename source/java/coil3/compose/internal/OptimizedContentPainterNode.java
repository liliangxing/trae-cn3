package coil3.compose.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import coil3.compose.AsyncImagePainter;
import kotlin.Metadata;

/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcoil3/compose/internal/OptimizedContentPainterNode;", "Lcoil3/compose/internal/OptimizedAbstractContentPainterNode;", "painter", "Lcoil3/compose/AsyncImagePainter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clipToBounds", "", "contentDescription", "", "constraintSizeResolver", "Lcoil3/compose/internal/ConstraintsSizeResolver;", "<init>", "(Lcoil3/compose/AsyncImagePainter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLjava/lang/String;Lcoil3/compose/internal/ConstraintsSizeResolver;)V", "getPainter", "()Lcoil3/compose/AsyncImagePainter;", "onAttach", "", "onDetach", "onReset", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class OptimizedContentPainterNode extends OptimizedAbstractContentPainterNode {
    public static final int $stable = 0;
    private final AsyncImagePainter painter;

    @Override // coil3.compose.internal.OptimizedAbstractContentPainterNode
    public AsyncImagePainter getPainter() {
        return this.painter;
    }

    public OptimizedContentPainterNode(AsyncImagePainter asyncImagePainter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str, ConstraintsSizeResolver constraintsSizeResolver) {
        super(alignment, contentScale, f, colorFilter, z, str, constraintsSizeResolver);
        this.painter = asyncImagePainter;
    }

    public void onAttach() {
        getPainter().setScope$coil_compose_core_release(getCoroutineScope());
        getPainter().onRemembered();
    }

    public void onDetach() {
        getPainter().onForgotten();
    }

    public void onReset() {
        getPainter().set_input$coil_compose_core_release(null);
    }
}
