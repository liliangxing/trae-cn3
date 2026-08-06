package com.bytedance.kmp.image.painter;

import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import com.bytedance.kmp.image.options.ImageAnimationController;
import com.bytedance.kmp.image.options.ImageAnimationListener;
import com.bytedance.kmp.image.options.ImageLoadListener;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.BaseFrescoControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ComposeFrescoControllerListener.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0010\u0010\n\u001a\f\u0012\u0006\b\u0000\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u001a\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016JJ\u0010\u001c\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0018\u0010!\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\"H\u0016J\u001c\u0010#\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010$\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010%\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010&\u001a\u0004\u0018\u00010\u001eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\b\u0000\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/kmp/image/painter/ComposeFrescoControllerListener;", "Lcom/facebook/drawee/controller/BaseFrescoControllerListener;", "imageLoadListener", "Lcom/bytedance/kmp/image/options/ImageLoadListener;", "animatedImageLoadListener", "Lcom/bytedance/kmp/image/options/ImageAnimationListener;", "onAnimatedImageControllerRdy", "Lkotlin/Function1;", "Lcom/bytedance/kmp/image/options/ImageAnimationController;", "", "controllerListener", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "(Lcom/bytedance/kmp/image/options/ImageLoadListener;Lcom/bytedance/kmp/image/options/ImageAnimationListener;Lkotlin/jvm/functions/Function1;Lcom/facebook/drawee/controller/ControllerListener;)V", "firstDrawReported", "", "loopIndex", "", "onControllerStart", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "startTime", "", "onFailure", "id", "", "throwable", "", "onFinalImageSet", "image", "", "animatable", "Landroid/graphics/drawable/Animatable;", "extra", "", "onIntermediateImageFailed", "onRelease", "onSubmit", "callerContext", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ComposeFrescoControllerListener extends BaseFrescoControllerListener {
    public static final int $stable = 8;
    private ImageAnimationListener animatedImageLoadListener;
    private ControllerListener<? super ImageInfo> controllerListener;
    private boolean firstDrawReported;
    private ImageLoadListener imageLoadListener;
    private int loopIndex;
    private Function1<? super ImageAnimationController, Unit> onAnimatedImageControllerRdy;

    public ComposeFrescoControllerListener(ImageLoadListener imageLoadListener, ImageAnimationListener imageAnimationListener, Function1<? super ImageAnimationController, Unit> function1, ControllerListener<? super ImageInfo> controllerListener) {
        this.imageLoadListener = imageLoadListener;
        this.animatedImageLoadListener = imageAnimationListener;
        this.onAnimatedImageControllerRdy = function1;
        this.controllerListener = controllerListener;
    }

    public void onSubmit(String id, Object callerContext) {
        super.onSubmit(id, callerContext);
        ControllerListener<? super ImageInfo> controllerListener = this.controllerListener;
        if (controllerListener != null) {
            controllerListener.onSubmit(id, callerContext);
        }
        ImageLoadListener imageLoadListener = this.imageLoadListener;
        if (imageLoadListener != null) {
            imageLoadListener.onLoadStart();
        }
    }

    public void onFinalImageSet(String id, Object image, Animatable animatable, ImageRequest imageRequest, Map<Object, Object> extra) {
        ImageLoadListener.Rect rect;
        Rect smartCrop;
        super.onFinalImageSet(id, image, animatable, imageRequest, extra);
        ImageInfo imageInfo = image instanceof ImageInfo ? (ImageInfo) image : null;
        BaseControllerListener baseControllerListener = this.controllerListener;
        BaseControllerListener baseControllerListener2 = baseControllerListener instanceof BaseControllerListener ? baseControllerListener : null;
        if (baseControllerListener2 != null) {
            baseControllerListener2.onFinalImageSet(id, imageInfo, animatable, imageRequest, extra);
        }
        if (imageInfo != null && (smartCrop = imageInfo.getSmartCrop()) != null) {
            rect = new ImageLoadListener.Rect(smartCrop.left, smartCrop.top, smartCrop.right, smartCrop.bottom);
        } else {
            rect = new ImageLoadListener.Rect(0, 0, 0, 0, 15, null);
        }
        ImageLoadListener imageLoadListener = this.imageLoadListener;
        if (imageLoadListener != null) {
            imageLoadListener.onSuccess(new ImageLoadListener.SuccessResult(imageInfo != null ? imageInfo.getWidth() : 0, imageInfo != null ? imageInfo.getHeight() : 0, rect));
        }
        if (animatable != null) {
            AnimatedDrawable2 animatedDrawable2 = animatable instanceof AnimatedDrawable2 ? (AnimatedDrawable2) animatable : null;
            if (animatedDrawable2 != null) {
                animatedDrawable2.setAnimationListener(new AnimationListener() { // from class: com.bytedance.kmp.image.painter.ComposeFrescoControllerListener$onFinalImageSet$1$1
                    public void onAnimationReset(AnimatedDrawable2 drawable) {
                    }

                    public void onAnimationStop(AnimatedDrawable2 drawable) {
                    }

                    public void onAnimationStart(AnimatedDrawable2 drawable) {
                        ImageAnimationListener imageAnimationListener;
                        imageAnimationListener = ComposeFrescoControllerListener.this.animatedImageLoadListener;
                        if (imageAnimationListener != null) {
                            imageAnimationListener.onImageAnimateStart();
                        }
                    }

                    public void onAnimationRepeat(AnimatedDrawable2 drawable) {
                        int i;
                        int i2;
                        ImageAnimationListener imageAnimationListener;
                        if (drawable != null) {
                            ComposeFrescoControllerListener composeFrescoControllerListener = ComposeFrescoControllerListener.this;
                            if (drawable.getLoopCount() != 0) {
                                i = composeFrescoControllerListener.loopIndex;
                                composeFrescoControllerListener.loopIndex = i + 1;
                                i2 = composeFrescoControllerListener.loopIndex;
                                if (i2 >= drawable.getLoopCount()) {
                                    drawable.stop();
                                    composeFrescoControllerListener.loopIndex = 0;
                                    imageAnimationListener = composeFrescoControllerListener.animatedImageLoadListener;
                                    if (imageAnimationListener != null) {
                                        imageAnimationListener.onImageAnimateEnd();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            composeFrescoControllerListener.loopIndex = 0;
                        }
                    }

                    public void onAnimationFrame(AnimatedDrawable2 drawable, int frameNumber) {
                        boolean z;
                        ImageAnimationListener imageAnimationListener;
                        z = ComposeFrescoControllerListener.this.firstDrawReported;
                        if (z) {
                            return;
                        }
                        imageAnimationListener = ComposeFrescoControllerListener.this.animatedImageLoadListener;
                        if (imageAnimationListener != null) {
                            imageAnimationListener.onAnimateImageLoad();
                        }
                        ComposeFrescoControllerListener.this.firstDrawReported = true;
                    }
                });
                Function1<? super ImageAnimationController, Unit> function1 = this.onAnimatedImageControllerRdy;
                if (function1 != null) {
                    function1.invoke(new AndroidDrawableImageAnimationController(animatedDrawable2));
                }
            }
        }
    }

    public void onIntermediateImageFailed(String id, Throwable throwable) {
        super.onIntermediateImageFailed(id, throwable);
    }

    public void onFailure(String id, Throwable throwable) {
        super.onFailure(id, throwable);
        ControllerListener<? super ImageInfo> controllerListener = this.controllerListener;
        if (controllerListener != null) {
            controllerListener.onFailure(id, throwable);
        }
        ImageLoadListener imageLoadListener = this.imageLoadListener;
        if (imageLoadListener != null) {
            if (throwable == null) {
                throwable = new Exception("unknown Error");
            }
            imageLoadListener.onFail(throwable);
        }
    }

    public void onFailure(String id, ImageRequest imageRequest, Throwable throwable) {
        super.onFailure(id, imageRequest, throwable);
    }

    public void onRelease(String id) {
        super.onRelease(id);
        ControllerListener<? super ImageInfo> controllerListener = this.controllerListener;
        if (controllerListener != null) {
            controllerListener.onRelease(id);
        }
        this.controllerListener = null;
        this.imageLoadListener = null;
        this.animatedImageLoadListener = null;
        this.onAnimatedImageControllerRdy = null;
    }

    public void onRelease(String id, ImageRequest imageRequest) {
        super.onRelease(id, imageRequest);
    }

    public void onControllerStart(ImageRequest imageRequest, long startTime) {
        super.onControllerStart(imageRequest, startTime);
    }
}
