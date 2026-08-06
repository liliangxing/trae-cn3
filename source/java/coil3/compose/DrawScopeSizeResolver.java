package coil3.compose;

import androidx.compose.ui.geometry.Size;
import coil3.size.SizeResolver;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DrawScopeSizeResolver.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcoil3/compose/DrawScopeSizeResolver;", "Lcoil3/size/SizeResolver;", "connect", "", "sizes", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/ui/geometry/Size;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DrawScopeSizeResolver extends SizeResolver {
    void connect(Flow<Size> sizes);
}
