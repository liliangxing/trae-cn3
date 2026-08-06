package com.bytedance.kmp.image.options;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.bytedance.kmp.image.options.ImagePlaceholder;
import com.bytedance.kmp.image.options.Priority;
import com.bytedance.lynx.service.image.LynxImageService;
import com.bytedance.notification.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;

/* compiled from: ImageOptions.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010m\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010n\u001a\u00020\u00002\u0006\u0010o\u001a\u00020pJ.\u0010q\u001a\u00020\u00002\b\b\u0002\u0010r\u001a\u00020s2\b\b\u0002\u0010o\u001a\u00020s2\b\b\u0002\u0010t\u001a\u00020uø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\u0010\u0010q\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010x\u001a\u00020\u0000J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aJ\u001e\u0010!\u001a\u00020\u00002\u0016\u0010y\u001a\u0012\u0012\b\u0012\u00060#j\u0002`$\u0012\u0004\u0012\u00020%0\"J\u0019\u0010z\u001a\u00020%2\n\u0010{\u001a\u00060#j\u0002`$H\u0000¢\u0006\u0002\b|J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*J\u000e\u00102\u001a\u00020\u00002\u0006\u00102\u001a\u000201J\u000e\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\u007fJ\u000e\u00109\u001a\u00020\u00002\u0006\u00109\u001a\u000208J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010C\u001a\u000201J\u000f\u0010\u0080\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\u007fJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010M\u001a\u00020LJ\u000e\u0010T\u001a\u00020\u00002\u0006\u0010T\u001a\u00020SJ\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020*J\u000e\u0010_\u001a\u00020\u00002\u0006\u0010_\u001a\u00020^J\u000e\u0010e\u001a\u00020\u00002\u0006\u0010e\u001a\u00020*J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010i\u001a\u00020*R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR/\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001a8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR,\u0010!\u001a\u0014\u0012\b\u0012\u00060#j\u0002`$\u0012\u0004\u0012\u00020%\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R+\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020*8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u000b\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R/\u00102\u001a\u0004\u0018\u0001012\b\u0010\u0003\u001a\u0004\u0018\u0001018@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010\u000b\u001a\u0004\b3\u00104\"\u0004\b5\u00106R/\u00109\u001a\u0004\u0018\u0001082\b\u0010\u0003\u001a\u0004\u0018\u0001088@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\u000b\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R/\u0010?\u001a\u0004\u0018\u0001012\b\u0010\u0003\u001a\u0004\u0018\u0001018@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010\u000b\u001a\u0004\b@\u00104\"\u0004\bA\u00106R/\u0010C\u001a\u0004\u0018\u0001012\b\u0010\u0003\u001a\u0004\u0018\u0001018@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010\u000b\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\u001e\u0010G\u001a\u00060#j\u0002`$X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR+\u0010M\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020L8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010\u000b\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR+\u0010T\u001a\u00020S2\u0006\u0010\u0003\u001a\u00020S8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010\u000b\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR+\u0010Z\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020*8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010\u000b\u001a\u0004\b[\u0010-\"\u0004\b\\\u0010/R/\u0010_\u001a\u0004\u0018\u00010^2\b\u0010\u0003\u001a\u0004\u0018\u00010^8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010\u000b\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR+\u0010e\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020*8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bh\u0010\u000b\u001a\u0004\bf\u0010-\"\u0004\bg\u0010/R+\u0010i\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020*8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bl\u0010\u000b\u001a\u0004\bj\u0010-\"\u0004\bk\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0082\u0001"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageOptions;", "", "()V", "<set-?>", "Lcom/bytedance/kmp/image/options/AnimatedImageOptions;", "animatedImageOptions", "getAnimatedImageOptions$kmpimage_release", "()Lcom/bytedance/kmp/image/options/AnimatedImageOptions;", "setAnimatedImageOptions$kmpimage_release", "(Lcom/bytedance/kmp/image/options/AnimatedImageOptions;)V", "animatedImageOptions$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/bytedance/kmp/image/options/ImageBlurOption;", "blurOption", "getBlurOption$kmpimage_release", "()Lcom/bytedance/kmp/image/options/ImageBlurOption;", "setBlurOption$kmpimage_release", "(Lcom/bytedance/kmp/image/options/ImageBlurOption;)V", "blurOption$delegate", "Lcom/bytedance/kmp/image/options/ImageBorderOption;", "borderOption", "getBorderOption$kmpimage_release", "()Lcom/bytedance/kmp/image/options/ImageBorderOption;", "setBorderOption$kmpimage_release", "(Lcom/bytedance/kmp/image/options/ImageBorderOption;)V", "borderOption$delegate", "Lcom/bytedance/kmp/image/options/ImageColorFilter;", "colorFilter", "getColorFilter$kmpimage_release", "()Lcom/bytedance/kmp/image/options/ImageColorFilter;", "setColorFilter$kmpimage_release", "(Lcom/bytedance/kmp/image/options/ImageColorFilter;)V", "colorFilter$delegate", "configurePlatformImage", "Lkotlin/Function1;", "Lcom/bytedance/kmp/image/options/AndroidFrescoImageConfigurator;", "Lcom/bytedance/kmp/image/options/PlatformImageConfigurator;", "", "getConfigurePlatformImage$kmpimage_release", "()Lkotlin/jvm/functions/Function1;", "setConfigurePlatformImage$kmpimage_release", "(Lkotlin/jvm/functions/Function1;)V", "", "earlyAttachOptimization", "getEarlyAttachOptimization$kmpimage_release", "()Z", "setEarlyAttachOptimization$kmpimage_release", "(Z)V", "earlyAttachOptimization$delegate", "Lcom/bytedance/kmp/image/options/ImagePlaceholder;", "errorPlaceHolder", "getErrorPlaceHolder$kmpimage_release", "()Lcom/bytedance/kmp/image/options/ImagePlaceholder;", "setErrorPlaceHolder$kmpimage_release", "(Lcom/bytedance/kmp/image/options/ImagePlaceholder;)V", "errorPlaceHolder$delegate", "Lcom/bytedance/kmp/image/options/ImageLoadListener;", "imageLoadListener", "getImageLoadListener$kmpimage_release", "()Lcom/bytedance/kmp/image/options/ImageLoadListener;", "setImageLoadListener$kmpimage_release", "(Lcom/bytedance/kmp/image/options/ImageLoadListener;)V", "imageLoadListener$delegate", "initPlaceHolder", "getInitPlaceHolder$kmpimage_release", "setInitPlaceHolder$kmpimage_release", "initPlaceHolder$delegate", "loadingPlaceHolder", "getLoadingPlaceHolder$kmpimage_release", "setLoadingPlaceHolder$kmpimage_release", "loadingPlaceHolder$delegate", "platformImageConfigurator", "getPlatformImageConfigurator$kmpimage_release", "()Lcom/bytedance/kmp/image/options/AndroidFrescoImageConfigurator;", "setPlatformImageConfigurator$kmpimage_release", "(Lcom/bytedance/kmp/image/options/AndroidFrescoImageConfigurator;)V", "Lcom/bytedance/kmp/image/options/Priority;", LynxImageService.PRIORITY_KEY, "getPriority$kmpimage_release", "()Lcom/bytedance/kmp/image/options/Priority;", "setPriority$kmpimage_release", "(Lcom/bytedance/kmp/image/options/Priority;)V", "priority$delegate", "Lcom/bytedance/kmp/image/options/ImageScaleType;", "scaleType", "getScaleType$kmpimage_release", "()Lcom/bytedance/kmp/image/options/ImageScaleType;", "setScaleType$kmpimage_release", "(Lcom/bytedance/kmp/image/options/ImageScaleType;)V", "scaleType$delegate", "smartCrop", "getSmartCrop$kmpimage_release", "setSmartCrop$kmpimage_release", "smartCrop$delegate", "", Constants.NOTIFICATION_TAG, "getTag$kmpimage_release", "()Ljava/lang/String;", "setTag$kmpimage_release", "(Ljava/lang/String;)V", "tag$delegate", "useAnimationOptimization", "getUseAnimationOptimization$kmpimage_release", "setUseAnimationOptimization$kmpimage_release", "useAnimationOptimization$delegate", "useOptimization", "getUseOptimization$kmpimage_release", "setUseOptimization$kmpimage_release", "useOptimization$delegate", "animateImageOptions", "blur", "radius", "", "border", "width", "Landroidx/compose/ui/unit/Dp;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "border-y62ob04", "(FFJ)Lcom/bytedance/kmp/image/options/ImageOptions;", "borderAsCircle", "block", "doPlatformImageConfig", "image", "doPlatformImageConfig$kmpimage_release", "errorRes", "res", "Lorg/jetbrains/compose/resources/DrawableResource;", "loadingRes", "Companion", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ImageOptions {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final float DEFAULT_ALPHA = 1.0f;

    /* renamed from: animatedImageOptions$delegate, reason: from kotlin metadata */
    private final MutableState animatedImageOptions;

    /* renamed from: blurOption$delegate, reason: from kotlin metadata */
    private final MutableState blurOption;

    /* renamed from: borderOption$delegate, reason: from kotlin metadata */
    private final MutableState borderOption;

    /* renamed from: colorFilter$delegate, reason: from kotlin metadata */
    private final MutableState colorFilter;
    private Function1<? super AndroidFrescoImageConfigurator, Unit> configurePlatformImage;

    /* renamed from: earlyAttachOptimization$delegate, reason: from kotlin metadata */
    private final MutableState earlyAttachOptimization;

    /* renamed from: errorPlaceHolder$delegate, reason: from kotlin metadata */
    private final MutableState errorPlaceHolder;

    /* renamed from: imageLoadListener$delegate, reason: from kotlin metadata */
    private final MutableState imageLoadListener;

    /* renamed from: initPlaceHolder$delegate, reason: from kotlin metadata */
    private final MutableState initPlaceHolder;

    /* renamed from: loadingPlaceHolder$delegate, reason: from kotlin metadata */
    private final MutableState loadingPlaceHolder;
    public AndroidFrescoImageConfigurator platformImageConfigurator;

    /* renamed from: priority$delegate, reason: from kotlin metadata */
    private final MutableState priority;

    /* renamed from: scaleType$delegate, reason: from kotlin metadata */
    private final MutableState scaleType;

    /* renamed from: smartCrop$delegate, reason: from kotlin metadata */
    private final MutableState smartCrop;

    /* renamed from: tag$delegate, reason: from kotlin metadata */
    private final MutableState tag;

    /* renamed from: useAnimationOptimization$delegate, reason: from kotlin metadata */
    private final MutableState useAnimationOptimization;

    /* renamed from: useOptimization$delegate, reason: from kotlin metadata */
    private final MutableState useOptimization;

    public /* synthetic */ ImageOptions(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ImageOptions() {
        this.scaleType = SnapshotStateKt.mutableStateOf$default(ImageScaleType.INSTANCE.getFIT_CENTER(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.smartCrop = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.priority = SnapshotStateKt.mutableStateOf$default(Priority.Normal.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.borderOption = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.blurOption = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.colorFilter = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.loadingPlaceHolder = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.errorPlaceHolder = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.initPlaceHolder = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.tag = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.imageLoadListener = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animatedImageOptions = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.useOptimization = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.useAnimationOptimization = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.earlyAttachOptimization = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final ImageScaleType getScaleType$kmpimage_release() {
        return (ImageScaleType) this.scaleType.getValue();
    }

    public final void setScaleType$kmpimage_release(ImageScaleType imageScaleType) {
        Intrinsics.checkNotNullParameter(imageScaleType, "<set-?>");
        this.scaleType.setValue(imageScaleType);
    }

    public final boolean getSmartCrop$kmpimage_release() {
        return ((Boolean) this.smartCrop.getValue()).booleanValue();
    }

    public final void setSmartCrop$kmpimage_release(boolean z) {
        this.smartCrop.setValue(Boolean.valueOf(z));
    }

    public final Priority getPriority$kmpimage_release() {
        return (Priority) this.priority.getValue();
    }

    public final void setPriority$kmpimage_release(Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "<set-?>");
        this.priority.setValue(priority);
    }

    public final ImageBorderOption getBorderOption$kmpimage_release() {
        return (ImageBorderOption) this.borderOption.getValue();
    }

    public final void setBorderOption$kmpimage_release(ImageBorderOption imageBorderOption) {
        this.borderOption.setValue(imageBorderOption);
    }

    public final ImageBlurOption getBlurOption$kmpimage_release() {
        return (ImageBlurOption) this.blurOption.getValue();
    }

    public final void setBlurOption$kmpimage_release(ImageBlurOption imageBlurOption) {
        this.blurOption.setValue(imageBlurOption);
    }

    public final ImageColorFilter getColorFilter$kmpimage_release() {
        return (ImageColorFilter) this.colorFilter.getValue();
    }

    public final void setColorFilter$kmpimage_release(ImageColorFilter imageColorFilter) {
        this.colorFilter.setValue(imageColorFilter);
    }

    public final ImagePlaceholder getLoadingPlaceHolder$kmpimage_release() {
        return (ImagePlaceholder) this.loadingPlaceHolder.getValue();
    }

    public final void setLoadingPlaceHolder$kmpimage_release(ImagePlaceholder imagePlaceholder) {
        this.loadingPlaceHolder.setValue(imagePlaceholder);
    }

    public final ImagePlaceholder getErrorPlaceHolder$kmpimage_release() {
        return (ImagePlaceholder) this.errorPlaceHolder.getValue();
    }

    public final void setErrorPlaceHolder$kmpimage_release(ImagePlaceholder imagePlaceholder) {
        this.errorPlaceHolder.setValue(imagePlaceholder);
    }

    public final ImagePlaceholder getInitPlaceHolder$kmpimage_release() {
        return (ImagePlaceholder) this.initPlaceHolder.getValue();
    }

    public final void setInitPlaceHolder$kmpimage_release(ImagePlaceholder imagePlaceholder) {
        this.initPlaceHolder.setValue(imagePlaceholder);
    }

    public final String getTag$kmpimage_release() {
        return (String) this.tag.getValue();
    }

    public final void setTag$kmpimage_release(String str) {
        this.tag.setValue(str);
    }

    public final ImageLoadListener getImageLoadListener$kmpimage_release() {
        return (ImageLoadListener) this.imageLoadListener.getValue();
    }

    public final void setImageLoadListener$kmpimage_release(ImageLoadListener imageLoadListener) {
        this.imageLoadListener.setValue(imageLoadListener);
    }

    public final AnimatedImageOptions getAnimatedImageOptions$kmpimage_release() {
        return (AnimatedImageOptions) this.animatedImageOptions.getValue();
    }

    public final void setAnimatedImageOptions$kmpimage_release(AnimatedImageOptions animatedImageOptions) {
        this.animatedImageOptions.setValue(animatedImageOptions);
    }

    public final Function1<AndroidFrescoImageConfigurator, Unit> getConfigurePlatformImage$kmpimage_release() {
        return this.configurePlatformImage;
    }

    public final void setConfigurePlatformImage$kmpimage_release(Function1<? super AndroidFrescoImageConfigurator, Unit> function1) {
        this.configurePlatformImage = function1;
    }

    public final AndroidFrescoImageConfigurator getPlatformImageConfigurator$kmpimage_release() {
        AndroidFrescoImageConfigurator androidFrescoImageConfigurator = this.platformImageConfigurator;
        if (androidFrescoImageConfigurator != null) {
            return androidFrescoImageConfigurator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("platformImageConfigurator");
        return null;
    }

    public final void setPlatformImageConfigurator$kmpimage_release(AndroidFrescoImageConfigurator androidFrescoImageConfigurator) {
        Intrinsics.checkNotNullParameter(androidFrescoImageConfigurator, "<set-?>");
        this.platformImageConfigurator = androidFrescoImageConfigurator;
    }

    public final boolean getUseOptimization$kmpimage_release() {
        return ((Boolean) this.useOptimization.getValue()).booleanValue();
    }

    public final void setUseOptimization$kmpimage_release(boolean z) {
        this.useOptimization.setValue(Boolean.valueOf(z));
    }

    public final boolean getUseAnimationOptimization$kmpimage_release() {
        return ((Boolean) this.useAnimationOptimization.getValue()).booleanValue();
    }

    public final void setUseAnimationOptimization$kmpimage_release(boolean z) {
        this.useAnimationOptimization.setValue(Boolean.valueOf(z));
    }

    public final boolean getEarlyAttachOptimization$kmpimage_release() {
        return ((Boolean) this.earlyAttachOptimization.getValue()).booleanValue();
    }

    public final void setEarlyAttachOptimization$kmpimage_release(boolean z) {
        this.earlyAttachOptimization.setValue(Boolean.valueOf(z));
    }

    public final ImageOptions useOptimization(boolean useOptimization) {
        setUseOptimization$kmpimage_release(useOptimization);
        return this;
    }

    public final ImageOptions useAnimationOptimization(boolean useAnimationOptimization) {
        setUseAnimationOptimization$kmpimage_release(useAnimationOptimization);
        return this;
    }

    public final ImageOptions earlyAttachOptimization(boolean earlyAttachOptimization) {
        setEarlyAttachOptimization$kmpimage_release(earlyAttachOptimization);
        return this;
    }

    public final ImageOptions smartCrop(boolean smartCrop) {
        setSmartCrop$kmpimage_release(smartCrop);
        return this;
    }

    public final ImageOptions scaleType(ImageScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        setScaleType$kmpimage_release(scaleType);
        return this;
    }

    public final ImageOptions colorFilter(ImageColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(colorFilter, "colorFilter");
        setColorFilter$kmpimage_release(colorFilter);
        return this;
    }

    public final ImageOptions loadingPlaceHolder(ImagePlaceholder loadingPlaceHolder) {
        Intrinsics.checkNotNullParameter(loadingPlaceHolder, "loadingPlaceHolder");
        setLoadingPlaceHolder$kmpimage_release(loadingPlaceHolder);
        return this;
    }

    public final ImageOptions loadingRes(DrawableResource res) {
        Intrinsics.checkNotNullParameter(res, "res");
        return loadingPlaceHolder(ImagePlaceholder.Companion.ofResource$default(ImagePlaceholder.INSTANCE, res, null, 2, null));
    }

    public final ImageOptions errorPlaceHolder(ImagePlaceholder errorPlaceHolder) {
        Intrinsics.checkNotNullParameter(errorPlaceHolder, "errorPlaceHolder");
        setErrorPlaceHolder$kmpimage_release(errorPlaceHolder);
        return this;
    }

    public final ImageOptions errorRes(DrawableResource res) {
        Intrinsics.checkNotNullParameter(res, "res");
        return errorPlaceHolder(ImagePlaceholder.Companion.ofResource$default(ImagePlaceholder.INSTANCE, res, null, 2, null));
    }

    public final ImageOptions imageLoadListener(ImageLoadListener imageLoadListener) {
        Intrinsics.checkNotNullParameter(imageLoadListener, "imageLoadListener");
        setImageLoadListener$kmpimage_release(imageLoadListener);
        return this;
    }

    public final ImageOptions blur(int radius) {
        setBlurOption$kmpimage_release(new ImageBlurOption(radius));
        return this;
    }

    public final ImageOptions borderAsCircle() {
        setBorderOption$kmpimage_release(new ImageBorderOption(0.0f, 0.0f, 0L, true, 7, null));
        return this;
    }

    /* renamed from: border-y62ob04, reason: not valid java name */
    public final ImageOptions m666bordery62ob04(float width, float radius, long borderColor) {
        setBorderOption$kmpimage_release(new ImageBorderOption(width, radius, borderColor, false, null));
        return this;
    }

    public final ImageOptions border(ImageBorderOption borderOption) {
        setBorderOption$kmpimage_release(borderOption);
        return this;
    }

    public final ImageOptions priority(Priority priority) {
        Intrinsics.checkNotNullParameter(priority, LynxImageService.PRIORITY_KEY);
        setPriority$kmpimage_release(priority);
        return this;
    }

    public final ImageOptions tag(String tag) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        setTag$kmpimage_release(tag);
        return this;
    }

    public final ImageOptions animateImageOptions(AnimatedImageOptions animatedImageOptions) {
        Intrinsics.checkNotNullParameter(animatedImageOptions, "animatedImageOptions");
        setAnimatedImageOptions$kmpimage_release(animatedImageOptions);
        return this;
    }

    public final ImageOptions configurePlatformImage(Function1<? super AndroidFrescoImageConfigurator, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.configurePlatformImage = block;
        return this;
    }

    public final void doPlatformImageConfig$kmpimage_release(AndroidFrescoImageConfigurator image) {
        Intrinsics.checkNotNullParameter(image, "image");
        setPlatformImageConfigurator$kmpimage_release(image);
        Function1<? super AndroidFrescoImageConfigurator, Unit> function1 = this.configurePlatformImage;
        if (function1 != null) {
            function1.invoke(image);
        }
    }

    /* compiled from: ImageOptions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageOptions$Companion;", "", "()V", "DEFAULT_ALPHA", "", "newInstance", "Lcom/bytedance/kmp/image/options/ImageOptions;", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageOptions newInstance() {
            return new ImageOptions(null);
        }
    }

    /* renamed from: border-y62ob04$default, reason: not valid java name */
    public static /* synthetic */ ImageOptions m665bordery62ob04$default(ImageOptions imageOptions, float f, float f2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        if ((i & 4) != 0) {
            j = Color.Companion.getTransparent-0d7_KjU();
        }
        return imageOptions.m666bordery62ob04(f, f2, j);
    }
}
