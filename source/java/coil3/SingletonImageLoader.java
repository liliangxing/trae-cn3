package coil3;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingletonImageLoader.common.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\nj\u0002`\tH\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0012\u001a\u00020\rH\u0007J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0019\u0010\u0014\u001a\u00020\u00072\n\u0010\b\u001a\u00060\nj\u0002`\tH\u0002¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¨\u0006\u0016"}, d2 = {"Lcoil3/SingletonImageLoader;", "", "<init>", "()V", "reference", "Lkotlinx/atomicfu/AtomicRef;", "get", "Lcoil3/ImageLoader;", "context", "Lcoil3/PlatformContext;", "Landroid/content/Context;", "(Landroid/content/Context;)Lcoil3/ImageLoader;", "setSafe", "", "factory", "Lcoil3/SingletonImageLoader$Factory;", "setUnsafe", "imageLoader", "reset", "set", "newImageLoader", "Factory", "coil_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SingletonImageLoader {
    public static final SingletonImageLoader INSTANCE = new SingletonImageLoader();
    private static final /* synthetic */ SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private singletonImageLoader$VolatileWrapper$atomicfu$private = new SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private(null);

    /* compiled from: SingletonImageLoader.common.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0006j\u0002`\u0005H&¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcoil3/SingletonImageLoader$Factory;", "", "newImageLoader", "Lcoil3/ImageLoader;", "context", "Lcoil3/PlatformContext;", "Landroid/content/Context;", "(Landroid/content/Context;)Lcoil3/ImageLoader;", "coil_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface Factory {
        ImageLoader newImageLoader(Context context);
    }

    private final /* synthetic */ Object updateAndGet$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        Object obj2;
        Object invoke;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
            invoke = function1.invoke(obj2);
        } while (!UByte$$ExternalSyntheticBackport0.m(atomicReferenceFieldUpdater, obj, obj2, invoke));
        return invoke;
    }

    private SingletonImageLoader() {
    }

    @JvmStatic
    public static final ImageLoader get(Context context) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        atomicReferenceFieldUpdater = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU;
        Object obj = atomicReferenceFieldUpdater.get(singletonImageLoader$VolatileWrapper$atomicfu$private);
        ImageLoader imageLoader = obj instanceof ImageLoader ? (ImageLoader) obj : null;
        return imageLoader == null ? INSTANCE.newImageLoader(context) : imageLoader;
    }

    @JvmStatic
    public static final void setSafe(Factory factory) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        boolean isDefault;
        atomicReferenceFieldUpdater = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU;
        Object obj = atomicReferenceFieldUpdater.get(singletonImageLoader$VolatileWrapper$atomicfu$private);
        if (obj instanceof ImageLoader) {
            isDefault = SingletonImageLoader_commonKt.isDefault((ImageLoader) obj);
            if (isDefault) {
                throw new IllegalStateException("The default image loader has already been created. This indicates that\n                    'setSafe' is being called after the first 'get' call. Ensure that 'setSafe' is\n                    called before any Coil API usages (e.g. `load`, `AsyncImage`,\n                    `rememberAsyncImagePainter`, etc.).".toString());
            }
        } else {
            atomicReferenceFieldUpdater2 = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU;
            UByte$$ExternalSyntheticBackport0.m(atomicReferenceFieldUpdater2, singletonImageLoader$VolatileWrapper$atomicfu$private, obj, factory);
        }
    }

    @JvmStatic
    public static final void setUnsafe(ImageLoader imageLoader) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        atomicReferenceFieldUpdater = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU;
        atomicReferenceFieldUpdater.set(singletonImageLoader$VolatileWrapper$atomicfu$private, imageLoader);
    }

    @JvmStatic
    public static final void setUnsafe(Factory factory) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        atomicReferenceFieldUpdater = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU;
        atomicReferenceFieldUpdater.set(singletonImageLoader$VolatileWrapper$atomicfu$private, factory);
    }

    @JvmStatic
    public static final void reset() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        atomicReferenceFieldUpdater = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU;
        atomicReferenceFieldUpdater.set(singletonImageLoader$VolatileWrapper$atomicfu$private, null);
    }

    @Deprecated(message = "'set' has been renamed to 'setUnsafe'.", replaceWith = @ReplaceWith(expression = "setUnsafe(imageLoader)", imports = {}))
    @JvmStatic
    public static final void set(ImageLoader imageLoader) {
        setUnsafe(imageLoader);
    }

    @Deprecated(message = "'set' has been renamed to 'setUnsafe'.", replaceWith = @ReplaceWith(expression = "setUnsafe(factory)", imports = {}))
    @JvmStatic
    public static final void set(Factory factory) {
        setUnsafe(factory);
    }

    private final ImageLoader newImageLoader(Context context) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ImageLoader imageLoader;
        Factory factory;
        SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private = singletonImageLoader$VolatileWrapper$atomicfu$private;
        atomicReferenceFieldUpdater = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.reference$volatile$FU;
        ImageLoader imageLoader2 = null;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private);
            if (obj instanceof ImageLoader) {
                imageLoader = imageLoader2;
                imageLoader2 = (ImageLoader) obj;
            } else {
                if (imageLoader2 == null) {
                    Factory factory2 = obj instanceof Factory ? (Factory) obj : null;
                    if (factory2 == null || (imageLoader2 = factory2.newImageLoader(context)) == null) {
                        Factory applicationImageLoaderFactory = SingletonImageLoaderKt.applicationImageLoaderFactory(context);
                        if (applicationImageLoaderFactory != null) {
                            imageLoader2 = applicationImageLoaderFactory.newImageLoader(context);
                        } else {
                            factory = SingletonImageLoader_commonKt.DefaultSingletonImageLoaderFactory;
                            imageLoader2 = factory.newImageLoader(context);
                        }
                    }
                }
                imageLoader = imageLoader2;
            }
            if (UByte$$ExternalSyntheticBackport0.m(atomicReferenceFieldUpdater, singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private, obj, imageLoader2)) {
                Intrinsics.checkNotNull(imageLoader2, "null cannot be cast to non-null type coil3.ImageLoader");
                return imageLoader2;
            }
            imageLoader2 = imageLoader;
        }
    }
}
