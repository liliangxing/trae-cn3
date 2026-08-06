package coil3.compose;

import coil3.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EqualityDelegate.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"DefaultModelEqualityDelegate", "Lcoil3/compose/EqualityDelegate;", "getDefaultModelEqualityDelegate", "()Lcoil3/compose/EqualityDelegate;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EqualityDelegateKt {
    private static final EqualityDelegate DefaultModelEqualityDelegate = new EqualityDelegate() { // from class: coil3.compose.EqualityDelegateKt$DefaultModelEqualityDelegate$1
        @Override // coil3.compose.EqualityDelegate
        public boolean equals(Object self, Object other) {
            if (!(self instanceof ImageRequest) || !(other instanceof ImageRequest)) {
                return Intrinsics.areEqual(self, other);
            }
            ImageRequest imageRequest = (ImageRequest) self;
            ImageRequest imageRequest2 = (ImageRequest) other;
            return Intrinsics.areEqual(imageRequest.getContext(), imageRequest2.getContext()) && Intrinsics.areEqual(imageRequest.getData(), imageRequest2.getData()) && Intrinsics.areEqual(imageRequest.getMemoryCacheKey(), imageRequest2.getMemoryCacheKey()) && Intrinsics.areEqual(imageRequest.getMemoryCacheKeyExtras(), imageRequest2.getMemoryCacheKeyExtras()) && Intrinsics.areEqual(imageRequest.getDiskCacheKey(), imageRequest2.getDiskCacheKey()) && Intrinsics.areEqual(imageRequest.getFileSystem(), imageRequest2.getFileSystem()) && Intrinsics.areEqual(imageRequest.getSizeResolver(), imageRequest2.getSizeResolver()) && imageRequest.getScale() == imageRequest2.getScale() && imageRequest.getPrecision() == imageRequest2.getPrecision();
        }

        @Override // coil3.compose.EqualityDelegate
        public int hashCode(Object self) {
            if (!(self instanceof ImageRequest)) {
                if (self != null) {
                    return self.hashCode();
                }
                return 0;
            }
            ImageRequest imageRequest = (ImageRequest) self;
            int hashCode = ((imageRequest.getContext().hashCode() * 31) + imageRequest.getData().hashCode()) * 31;
            String memoryCacheKey = imageRequest.getMemoryCacheKey();
            int hashCode2 = (((hashCode + (memoryCacheKey != null ? memoryCacheKey.hashCode() : 0)) * 31) + imageRequest.getMemoryCacheKeyExtras().hashCode()) * 31;
            String diskCacheKey = imageRequest.getDiskCacheKey();
            return ((((((((hashCode2 + (diskCacheKey != null ? diskCacheKey.hashCode() : 0)) * 31) + imageRequest.getFileSystem().hashCode()) * 31) + imageRequest.getSizeResolver().hashCode()) * 31) + imageRequest.getScale().hashCode()) * 31) + imageRequest.getPrecision().hashCode();
        }
    };

    public static final EqualityDelegate getDefaultModelEqualityDelegate() {
        return DefaultModelEqualityDelegate;
    }
}
