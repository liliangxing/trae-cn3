package coil3.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeAsyncImage.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\"\u001a\u00020#*\u00020#2\u0006\u0010\b\u001a\u00020\tH\u0097\u0001J\r\u0010$\u001a\u00020#*\u00020#H\u0097\u0001R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcoil3/compose/RealSubcomposeAsyncImageScope;", "Lcoil3/compose/SubcomposeAsyncImageScope;", "Landroidx/compose/foundation/layout/BoxScope;", "parentScope", "painter", "Lcoil3/compose/AsyncImagePainter;", "contentDescription", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clipToBounds", "", "<init>", "(Landroidx/compose/foundation/layout/BoxScope;Lcoil3/compose/AsyncImagePainter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Z)V", "getPainter", "()Lcoil3/compose/AsyncImagePainter;", "getContentDescription", "()Ljava/lang/String;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getClipToBounds", "()Z", "align", "Landroidx/compose/ui/Modifier;", "matchParentSize", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class RealSubcomposeAsyncImageScope implements SubcomposeAsyncImageScope, BoxScope {
    private final Alignment alignment;
    private final float alpha;
    private final boolean clipToBounds;
    private final ColorFilter colorFilter;
    private final String contentDescription;
    private final ContentScale contentScale;
    private final AsyncImagePainter painter;
    private final BoxScope parentScope;

    public Modifier align(Modifier modifier, Alignment alignment) {
        return this.parentScope.align(modifier, alignment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealSubcomposeAsyncImageScope)) {
            return false;
        }
        RealSubcomposeAsyncImageScope realSubcomposeAsyncImageScope = (RealSubcomposeAsyncImageScope) obj;
        return Intrinsics.areEqual(this.parentScope, realSubcomposeAsyncImageScope.parentScope) && Intrinsics.areEqual(this.painter, realSubcomposeAsyncImageScope.painter) && Intrinsics.areEqual(this.contentDescription, realSubcomposeAsyncImageScope.contentDescription) && Intrinsics.areEqual(this.alignment, realSubcomposeAsyncImageScope.alignment) && Intrinsics.areEqual(this.contentScale, realSubcomposeAsyncImageScope.contentScale) && Float.compare(this.alpha, realSubcomposeAsyncImageScope.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, realSubcomposeAsyncImageScope.colorFilter) && this.clipToBounds == realSubcomposeAsyncImageScope.clipToBounds;
    }

    public int hashCode() {
        int hashCode = ((this.parentScope.hashCode() * 31) + this.painter.hashCode()) * 31;
        String str = this.contentDescription;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return ((hashCode2 + (colorFilter != null ? colorFilter.hashCode() : 0)) * 31) + Boolean.hashCode(this.clipToBounds);
    }

    public Modifier matchParentSize(Modifier modifier) {
        return this.parentScope.matchParentSize(modifier);
    }

    public String toString() {
        return "RealSubcomposeAsyncImageScope(parentScope=" + this.parentScope + ", painter=" + this.painter + ", contentDescription=" + this.contentDescription + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ", clipToBounds=" + this.clipToBounds + ')';
    }

    public RealSubcomposeAsyncImageScope(BoxScope boxScope, AsyncImagePainter asyncImagePainter, String str, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z) {
        this.parentScope = boxScope;
        this.painter = asyncImagePainter;
        this.contentDescription = str;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
        this.clipToBounds = z;
    }

    @Override // coil3.compose.SubcomposeAsyncImageScope
    public AsyncImagePainter getPainter() {
        return this.painter;
    }

    @Override // coil3.compose.SubcomposeAsyncImageScope
    public String getContentDescription() {
        return this.contentDescription;
    }

    @Override // coil3.compose.SubcomposeAsyncImageScope
    public Alignment getAlignment() {
        return this.alignment;
    }

    @Override // coil3.compose.SubcomposeAsyncImageScope
    public ContentScale getContentScale() {
        return this.contentScale;
    }

    @Override // coil3.compose.SubcomposeAsyncImageScope
    public float getAlpha() {
        return this.alpha;
    }

    @Override // coil3.compose.SubcomposeAsyncImageScope
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // coil3.compose.SubcomposeAsyncImageScope
    public boolean getClipToBounds() {
        return this.clipToBounds;
    }
}
