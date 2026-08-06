package coil3.compose.internal;

import coil3.ExtrasKt;
import coil3.request.ImageRequest;
import kotlin.Metadata;

/* compiled from: ImageOptionsUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"useOptimization", "", "Lcoil3/request/ImageRequest;", "getUseOptimization", "(Lcoil3/request/ImageRequest;)Z", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ImageOptionsUtilsKt {
    public static final boolean getUseOptimization(ImageRequest imageRequest) {
        Boolean bool = (Boolean) imageRequest.getExtras().get(ExtrasKt.getUseOptimizationKey());
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
