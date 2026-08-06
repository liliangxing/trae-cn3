package coil3;

import android.content.Context;
import coil3.SingletonImageLoader;
import kotlin.Metadata;

/* compiled from: SingletonImageLoader.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0003j\u0002`\u0002H\u0000¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"applicationImageLoaderFactory", "Lcoil3/SingletonImageLoader$Factory;", "Lcoil3/PlatformContext;", "Landroid/content/Context;", "(Landroid/content/Context;)Lcoil3/SingletonImageLoader$Factory;", "coil_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SingletonImageLoaderKt {
    public static final SingletonImageLoader.Factory applicationImageLoaderFactory(Context context) {
        Object applicationContext = context.getApplicationContext();
        if (applicationContext instanceof SingletonImageLoader.Factory) {
            return (SingletonImageLoader.Factory) applicationContext;
        }
        return null;
    }
}
