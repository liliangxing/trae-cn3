package coil3.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil3.BitmapImage;
import coil3.EventListener;
import coil3.Image;
import coil3.Image_androidKt;
import coil3.intercept.EngineInterceptor;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.size.Size;
import coil3.transform.Transformation;
import coil3.util.BitmapsKt;
import coil3.util.DrawableUtils;
import coil3.util.Logger;
import coil3.util.Utils_androidKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.JobKt;

/* compiled from: EngineInterceptor.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0080@¢\u0006\u0002\u0010\u000b\u001a0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¨\u0006\u0017"}, d2 = {"transform", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", StrategyConstants.RESULT, "request", "Lcoil3/request/ImageRequest;", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "logger", "Lcoil3/util/Logger;", "(Lcoil3/intercept/EngineInterceptor$ExecuteResult;Lcoil3/request/ImageRequest;Lcoil3/request/Options;Lcoil3/EventListener;Lcoil3/util/Logger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "transformations", "", "Lcoil3/transform/Transformation;", "prepareToDraw", "", "image", "Lcoil3/Image;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class EngineInterceptorKt {
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00f9 -> B:10:0x00fe). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object transform(EngineInterceptor.ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Logger logger, Continuation<? super EngineInterceptor.ExecuteResult> continuation) {
        EngineInterceptorKt$transform$1 engineInterceptorKt$transform$1;
        int i;
        Options options2;
        ImageRequest imageRequest2;
        EventListener eventListener2;
        int i2;
        EngineInterceptor.ExecuteResult executeResult2;
        Bitmap bitmap;
        int i3;
        List<Transformation> list;
        if (continuation instanceof EngineInterceptorKt$transform$1) {
            engineInterceptorKt$transform$1 = (EngineInterceptorKt$transform$1) continuation;
            if ((engineInterceptorKt$transform$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptorKt$transform$1.label -= Integer.MIN_VALUE;
                Object obj = engineInterceptorKt$transform$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptorKt$transform$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<Transformation> transformations = ImageRequestsKt.getTransformations(imageRequest);
                    if (transformations.isEmpty()) {
                        return executeResult;
                    }
                    Drawable asDrawable = Image_androidKt.asDrawable(executeResult.getImage(), imageRequest.getContext().getResources());
                    if (!(asDrawable instanceof BitmapDrawable) && !ImageRequestsKt.getAllowConversionToBitmap(imageRequest)) {
                        if (logger != null) {
                            Logger.Level level = Logger.Level.Info;
                            if (logger.getMinLevel().compareTo(level) <= 0) {
                                logger.log(EngineInterceptor.TAG, level, "allowConversionToBitmap=false, skipping transformations for type " + Reflection.getOrCreateKotlinClass(executeResult.getImage().getClass()).getQualifiedName() + '.', null);
                            }
                        }
                        return executeResult;
                    }
                    options2 = options;
                    Bitmap convertDrawableToBitmap = convertDrawableToBitmap(asDrawable, options2, transformations, logger);
                    imageRequest2 = imageRequest;
                    eventListener2 = eventListener;
                    eventListener2.transformStart(imageRequest2, convertDrawableToBitmap);
                    int size = transformations.size();
                    i2 = 0;
                    executeResult2 = executeResult;
                    bitmap = convertDrawableToBitmap;
                    i3 = size;
                    list = transformations;
                    if (i2 < i3) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i3 = engineInterceptorKt$transform$1.I$1;
                    int i4 = engineInterceptorKt$transform$1.I$0;
                    List<Transformation> list2 = (List) engineInterceptorKt$transform$1.L$4;
                    eventListener2 = (EventListener) engineInterceptorKt$transform$1.L$3;
                    Options options3 = (Options) engineInterceptorKt$transform$1.L$2;
                    ImageRequest imageRequest3 = (ImageRequest) engineInterceptorKt$transform$1.L$1;
                    executeResult2 = (EngineInterceptor.ExecuteResult) engineInterceptorKt$transform$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    list = list2;
                    options2 = options3;
                    bitmap = (Bitmap) obj;
                    JobKt.ensureActive(engineInterceptorKt$transform$1.getContext());
                    ImageRequest imageRequest4 = imageRequest3;
                    i2 = i4 + 1;
                    imageRequest2 = imageRequest4;
                    if (i2 < i3) {
                        Transformation transformation = list.get(i2);
                        Size size2 = options2.getSize();
                        engineInterceptorKt$transform$1.L$0 = executeResult2;
                        engineInterceptorKt$transform$1.L$1 = imageRequest2;
                        engineInterceptorKt$transform$1.L$2 = options2;
                        engineInterceptorKt$transform$1.L$3 = eventListener2;
                        engineInterceptorKt$transform$1.L$4 = list;
                        engineInterceptorKt$transform$1.I$0 = i2;
                        engineInterceptorKt$transform$1.I$1 = i3;
                        engineInterceptorKt$transform$1.label = 1;
                        obj = transformation.transform(bitmap, size2, engineInterceptorKt$transform$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i5 = i2;
                        imageRequest3 = imageRequest2;
                        i4 = i5;
                        bitmap = (Bitmap) obj;
                        JobKt.ensureActive(engineInterceptorKt$transform$1.getContext());
                        ImageRequest imageRequest42 = imageRequest3;
                        i2 = i4 + 1;
                        imageRequest2 = imageRequest42;
                        if (i2 < i3) {
                            eventListener2.transformEnd(imageRequest2, bitmap);
                            return EngineInterceptor.ExecuteResult.copy$default(executeResult2, Image_androidKt.asImage(new BitmapDrawable(imageRequest2.getContext().getResources(), bitmap)), false, null, null, 14, null);
                        }
                    }
                }
            }
        }
        engineInterceptorKt$transform$1 = new EngineInterceptorKt$transform$1(continuation);
        Object obj2 = engineInterceptorKt$transform$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptorKt$transform$1.label;
        if (i != 0) {
        }
    }

    private static final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> list, Logger logger) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = BitmapsKt.getSafeConfig(bitmap);
            if (ArraysKt.contains(Utils_androidKt.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            if (logger != null) {
                Logger.Level level = Logger.Level.Info;
                if (logger.getMinLevel().compareTo(level) <= 0) {
                    logger.log(EngineInterceptor.TAG, level, "Converting bitmap with config " + safeConfig + " to apply transformations: " + list + '.', null);
                }
            }
        } else if (logger != null) {
            Logger.Level level2 = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level2) <= 0) {
                logger.log(EngineInterceptor.TAG, level2, "Converting drawable of type " + Reflection.getOrCreateKotlinClass(drawable.getClass()).getQualifiedName() + " to apply transformations: " + list + '.', null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, ImageRequestsKt.getBitmapConfig(options), options.getSize(), options.getScale(), options.getPrecision() == Precision.INEXACT);
    }

    public static final void prepareToDraw(Image image) {
        Bitmap bitmap;
        BitmapImage bitmapImage = image instanceof BitmapImage ? (BitmapImage) image : null;
        if (bitmapImage == null || (bitmap = bitmapImage.getBitmap()) == null) {
            return;
        }
        bitmap.prepareToDraw();
    }
}
