package coil3.request;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import coil3.BitmapImage;
import coil3.Extras;
import coil3.Image;
import coil3.ImageLoader;
import coil3.memory.MemoryCache;
import coil3.size.Dimension;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.size.ViewSizeResolver;
import coil3.size.ViewSizeResolverKt;
import coil3.target.Target;
import coil3.target.ViewTarget;
import coil3.util.BitmapsKt;
import coil3.util.ContextsKt;
import coil3.util.HardwareBitmapService;
import coil3.util.HardwareBitmapsKt;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import coil3.util.Utils_androidKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: RequestService.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0014\u0010\u001c\u001a\u00020\u001d*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u001e\u001a\u00020\u001f*\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'H\u0002J\u0016\u0010(\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010)\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcoil3/request/AndroidRequestService;", "Lcoil3/request/RequestService;", "imageLoader", "Lcoil3/ImageLoader;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "logger", "Lcoil3/util/Logger;", "<init>", "(Lcoil3/ImageLoader;Lcoil3/util/SystemCallbacks;Lcoil3/util/Logger;)V", "hardwareBitmapService", "Lcoil3/util/HardwareBitmapService;", "requestDelegate", "Lcoil3/request/RequestDelegate;", "request", "Lcoil3/request/ImageRequest;", "job", "Lkotlinx/coroutines/Job;", "findLifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil3/size/SizeResolver;", "options", "Lcoil3/request/Options;", "size", "Lcoil3/size/Size;", "resolveScale", "Lcoil3/size/Scale;", "resolvePrecision", "Lcoil3/size/Precision;", "resolveExtras", "Lcoil3/Extras;", "updateOptionsOnWorkerThread", "isCacheValueValidForHardware", "", "cacheValue", "Lcoil3/memory/MemoryCache$Value;", "isConfigValidForHardware", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isBitmapConfigValidMainThread", "isBitmapConfigValidWorkerThread", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AndroidRequestService implements RequestService {
    private final HardwareBitmapService hardwareBitmapService;
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final SystemCallbacks systemCallbacks;

    public AndroidRequestService(ImageLoader imageLoader, SystemCallbacks systemCallbacks, Logger logger) {
        this.imageLoader = imageLoader;
        this.systemCallbacks = systemCallbacks;
        this.logger = logger;
        this.hardwareBitmapService = HardwareBitmapsKt.HardwareBitmapService(logger);
    }

    @Override // coil3.request.RequestService
    public RequestDelegate requestDelegate(ImageRequest request, Job job) {
        Lifecycle lifecycle = ImageRequestsKt.getLifecycle(request);
        if (lifecycle == null) {
            lifecycle = findLifecycle(request);
        }
        Lifecycle lifecycle2 = lifecycle;
        Target target = request.getTarget();
        if (target instanceof ViewTarget) {
            return new ViewTargetRequestDelegate(this.imageLoader, request, (ViewTarget) target, lifecycle2, job);
        }
        if (!Intrinsics.areEqual(lifecycle2, GlobalLifecycle.INSTANCE)) {
            return new LifecycleRequestDelegate(lifecycle2, job);
        }
        return new BaseRequestDelegate(job);
    }

    private final Lifecycle findLifecycle(ImageRequest imageRequest) {
        Target target = imageRequest.getTarget();
        Lifecycle lifecycle = ContextsKt.getLifecycle(target instanceof ViewTarget ? ((ViewTarget) target).getView().getContext() : imageRequest.getContext());
        return lifecycle == null ? GlobalLifecycle.INSTANCE : lifecycle;
    }

    @Override // coil3.request.RequestService
    public SizeResolver sizeResolver(ImageRequest request) {
        if (request.getDefined().getSizeResolver() != null) {
            return request.getDefined().getSizeResolver();
        }
        Target target = request.getTarget();
        if (target instanceof ViewTarget) {
            View view = ((ViewTarget) target).getView();
            if (view instanceof ImageView) {
                ImageView.ScaleType scaleType = ((ImageView) view).getScaleType();
                if (scaleType == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX) {
                    return SizeResolver.ORIGINAL;
                }
            }
            return ViewSizeResolverKt.ViewSizeResolver$default(view, false, 2, null);
        }
        return SizeResolver.ORIGINAL;
    }

    @Override // coil3.request.RequestService
    public Options options(ImageRequest request, SizeResolver sizeResolver, Size size) {
        return new Options(request.getContext(), size, resolveScale(request, size), resolvePrecision(request, sizeResolver), request.getDiskCacheKey(), request.getFileSystem(), request.getMemoryCachePolicy(), request.getDiskCachePolicy(), request.getNetworkCachePolicy(), resolveExtras(request, size));
    }

    private final Scale resolveScale(ImageRequest imageRequest, Size size) {
        if (Intrinsics.areEqual(size.getWidth(), Dimension.Undefined.INSTANCE) || Intrinsics.areEqual(size.getHeight(), Dimension.Undefined.INSTANCE)) {
            return Scale.FIT;
        }
        return imageRequest.getScale();
    }

    private final Precision resolvePrecision(ImageRequest imageRequest, SizeResolver sizeResolver) {
        if (imageRequest.getDefined().getPrecision() != null) {
            return imageRequest.getDefined().getPrecision();
        }
        if (imageRequest.getDefined().getSizeResolver() == null && Intrinsics.areEqual(sizeResolver, SizeResolver.ORIGINAL)) {
            return Precision.INEXACT;
        }
        if ((imageRequest.getTarget() instanceof ViewTarget) && (sizeResolver instanceof ViewSizeResolver) && (((ViewTarget) imageRequest.getTarget()).getView() instanceof ImageView) && ((ViewTarget) imageRequest.getTarget()).getView() == ((ViewSizeResolver) sizeResolver).getView()) {
            return Precision.INEXACT;
        }
        return Precision.EXACT;
    }

    private final Extras resolveExtras(ImageRequest imageRequest, Size size) {
        Bitmap.Config bitmapConfig = ImageRequestsKt.getBitmapConfig(imageRequest);
        boolean allowRgb565 = ImageRequestsKt.getAllowRgb565(imageRequest);
        if (!isBitmapConfigValidMainThread(imageRequest, size)) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        boolean z = allowRgb565 && ImageRequestsKt.getTransformations(imageRequest).isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8;
        Extras.Builder builder = new Extras.Builder((Map<Extras.Key<?>, ? extends Object>) MapsKt.plus(imageRequest.getDefaults().getExtras().asMap(), imageRequest.getExtras().asMap()));
        if (bitmapConfig != ImageRequestsKt.getBitmapConfig(imageRequest)) {
            builder = builder.set(ImageRequestsKt.getBitmapConfig(Extras.Key.INSTANCE), bitmapConfig);
        }
        if (z != ImageRequestsKt.getAllowRgb565(imageRequest)) {
            builder = builder.set(ImageRequestsKt.getAllowRgb565(Extras.Key.INSTANCE), Boolean.valueOf(z));
        }
        return builder.build();
    }

    @Override // coil3.request.RequestService
    public Options updateOptionsOnWorkerThread(Options options) {
        boolean z;
        Options copy;
        Extras extras = options.getExtras();
        if (isBitmapConfigValidWorkerThread(options)) {
            z = false;
        } else {
            extras = extras.newBuilder().set(ImageRequestsKt.getBitmapConfig(Extras.Key.INSTANCE), Bitmap.Config.ARGB_8888).build();
            z = true;
        }
        Extras extras2 = extras;
        if (!z) {
            return options;
        }
        copy = options.copy((r22 & 1) != 0 ? options.context : null, (r22 & 2) != 0 ? options.size : null, (r22 & 4) != 0 ? options.scale : null, (r22 & 8) != 0 ? options.precision : null, (r22 & 16) != 0 ? options.diskCacheKey : null, (r22 & 32) != 0 ? options.fileSystem : null, (r22 & 64) != 0 ? options.memoryCachePolicy : null, (r22 & 128) != 0 ? options.diskCachePolicy : null, (r22 & 256) != 0 ? options.networkCachePolicy : null, (r22 & 512) != 0 ? options.extras : extras2);
        return copy;
    }

    @Override // coil3.request.RequestService
    public boolean isCacheValueValidForHardware(ImageRequest request, MemoryCache.Value cacheValue) {
        Image image = cacheValue.getImage();
        BitmapImage bitmapImage = image instanceof BitmapImage ? (BitmapImage) image : null;
        if (bitmapImage == null) {
            return true;
        }
        return isConfigValidForHardware(request, BitmapsKt.getSafeConfig(bitmapImage.getBitmap()));
    }

    private final boolean isConfigValidForHardware(ImageRequest request, Bitmap.Config requestedConfig) {
        if (!BitmapsKt.isHardware(requestedConfig)) {
            return true;
        }
        if (!ImageRequestsKt.getAllowHardware(request)) {
            return false;
        }
        Target target = request.getTarget();
        if (target instanceof ViewTarget) {
            View view = ((ViewTarget) target).getView();
            if (view.isAttachedToWindow() && !view.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    public final boolean isBitmapConfigValidMainThread(ImageRequest request, Size size) {
        return (ImageRequestsKt.getTransformations(request).isEmpty() || ArraysKt.contains(Utils_androidKt.getVALID_TRANSFORMATION_CONFIGS(), ImageRequestsKt.getBitmapConfig(request))) && (!BitmapsKt.isHardware(ImageRequestsKt.getBitmapConfig(request)) || (isConfigValidForHardware(request, ImageRequestsKt.getBitmapConfig(request)) && this.hardwareBitmapService.allowHardwareMainThread(size)));
    }

    public final boolean isBitmapConfigValidWorkerThread(Options options) {
        return !BitmapsKt.isHardware(ImageRequestsKt.getBitmapConfig(options)) || this.hardwareBitmapService.getAllowHardware();
    }
}
