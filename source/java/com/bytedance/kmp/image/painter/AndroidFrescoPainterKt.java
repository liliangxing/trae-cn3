package com.bytedance.kmp.image.painter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bytedance.kmp.image.options.AndroidFrescoImageConfigurator;
import com.bytedance.kmp.image.options.AnimatedImageOptions;
import com.bytedance.kmp.image.options.AssetSource;
import com.bytedance.kmp.image.options.ColorSource;
import com.bytedance.kmp.image.options.ImageAnimationController;
import com.bytedance.kmp.image.options.ImageAnimationListener;
import com.bytedance.kmp.image.options.ImageBlurOption;
import com.bytedance.kmp.image.options.ImageBorderOption;
import com.bytedance.kmp.image.options.ImageColorFilter;
import com.bytedance.kmp.image.options.ImageLoadListener;
import com.bytedance.kmp.image.options.ImageOptions;
import com.bytedance.kmp.image.options.ImagePlaceholder;
import com.bytedance.kmp.image.options.ImageScaleType;
import com.bytedance.kmp.image.options.KImageSource;
import com.bytedance.kmp.image.options.LocalResourceSource;
import com.bytedance.kmp.image.options.None;
import com.bytedance.kmp.image.options.PlatformImageConfiguratorKt;
import com.bytedance.kmp.image.options.Priority;
import com.bytedance.kmp.image.options.UrlSource;
import com.bytedance.kmp.image.utils.ImageUtilsKt;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.postprocessors.BlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidFrescoPainter.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0005H\u0086\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"DEFAULT_ITERATIONS", "", "rememberPlatformPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "imageSource", "Lcom/bytedance/kmp/image/options/KImageSource;", "imageOptions", "Lcom/bytedance/kmp/image/options/ImageOptions;", "(Lcom/bytedance/kmp/image/options/KImageSource;Lcom/bytedance/kmp/image/options/ImageOptions;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "getSource", "", "kmpimage_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidFrescoPainterKt {
    public static final int DEFAULT_ITERATIONS = 3;

    public static final Object getSource(KImageSource kImageSource) {
        Intrinsics.checkNotNullParameter(kImageSource, "<this>");
        if (kImageSource instanceof LocalResourceSource) {
            return Integer.valueOf(((LocalResourceSource) kImageSource).getResource().getId());
        }
        if (kImageSource instanceof AssetSource) {
            return ((AssetSource) kImageSource).getFileUri();
        }
        if (kImageSource instanceof UrlSource) {
            return ((UrlSource) kImageSource).getUrls().toString();
        }
        if (kImageSource instanceof ColorSource) {
            return Long.valueOf(((ColorSource) kImageSource).getColor());
        }
        if (kImageSource instanceof None) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Painter rememberPlatformPainter(KImageSource kImageSource, ImageOptions imageOptions, Composer composer, int i) {
        Object obj;
        Object obj2;
        Priority priority;
        ImageScaleType imageScaleType;
        Function1<ImageAnimationController, Unit> function1;
        Object obj3;
        Object obj4;
        ImageRequestBuilder newBuilderWithResourceId;
        KImageSource imageSource;
        KImageSource imageSource2;
        Intrinsics.checkNotNullParameter(kImageSource, "imageSource");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOptions");
        composer.startReplaceGroup(-267260436);
        ComposerKt.sourceInformation(composer, "C(rememberPlatformPainter)P(1)69@2493L7,74@2762L18,80@2987L2594,143@5859L142,148@6040L2248,269@11457L120:AndroidFrescoPainter.kt#fqqyg8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-267260436, i, -1, "com.bytedance.kmp.image.painter.rememberPlatformPainter (AndroidFrescoPainter.kt:67)");
        }
        imageOptions.doPlatformImageConfig$kmpimage_release(new AndroidFrescoImageConfigurator());
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        ImagePlaceholder loadingPlaceHolder$kmpimage_release = imageOptions.getLoadingPlaceHolder$kmpimage_release();
        ImagePlaceholder errorPlaceHolder$kmpimage_release = imageOptions.getErrorPlaceHolder$kmpimage_release();
        AndroidFrescoImageConfigurator platformImageConfigurator$kmpimage_release = imageOptions.getPlatformImageConfigurator$kmpimage_release();
        ImageScaleType scaleType$kmpimage_release = imageOptions.getScaleType$kmpimage_release();
        RoundingParams roundingParams = ImageUtilsKt.toRoundingParams(imageOptions.getBorderOption$kmpimage_release(), composer, 0);
        ImageBlurOption blurOption$kmpimage_release = imageOptions.getBlurOption$kmpimage_release();
        Priority priority$kmpimage_release = imageOptions.getPriority$kmpimage_release();
        ImageColorFilter colorFilter$kmpimage_release = imageOptions.getColorFilter$kmpimage_release();
        boolean smartCrop$kmpimage_release = imageOptions.getSmartCrop$kmpimage_release();
        if (loadingPlaceHolder$kmpimage_release == null || (imageSource2 = loadingPlaceHolder$kmpimage_release.getImageSource()) == null) {
            obj = null;
        } else if (imageSource2 instanceof LocalResourceSource) {
            obj = Integer.valueOf(((LocalResourceSource) imageSource2).getResource().getId());
        } else if (imageSource2 instanceof AssetSource) {
            obj = ((AssetSource) imageSource2).getFileUri();
        } else if (imageSource2 instanceof UrlSource) {
            obj = ((UrlSource) imageSource2).getUrls().toString();
        } else if (imageSource2 instanceof ColorSource) {
            obj = Long.valueOf(((ColorSource) imageSource2).getColor());
        } else {
            if (!(imageSource2 instanceof None)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = 0;
        }
        ImageScaleType scaleType = loadingPlaceHolder$kmpimage_release != null ? loadingPlaceHolder$kmpimage_release.getScaleType() : null;
        if (errorPlaceHolder$kmpimage_release == null || (imageSource = errorPlaceHolder$kmpimage_release.getImageSource()) == null) {
            obj2 = null;
        } else if (imageSource instanceof LocalResourceSource) {
            obj2 = Integer.valueOf(((LocalResourceSource) imageSource).getResource().getId());
        } else if (imageSource instanceof AssetSource) {
            obj2 = ((AssetSource) imageSource).getFileUri();
        } else if (imageSource instanceof UrlSource) {
            obj2 = ((UrlSource) imageSource).getUrls().toString();
        } else if (imageSource instanceof ColorSource) {
            obj2 = Long.valueOf(((ColorSource) imageSource).getColor());
        } else {
            if (!(imageSource instanceof None)) {
                throw new NoWhenBranchMatchedException();
            }
            obj2 = 0;
        }
        if (errorPlaceHolder$kmpimage_release != null) {
            imageScaleType = errorPlaceHolder$kmpimage_release.getScaleType();
            priority = priority$kmpimage_release;
        } else {
            priority = priority$kmpimage_release;
            imageScaleType = null;
        }
        ImageBorderOption borderOption$kmpimage_release = imageOptions.getBorderOption$kmpimage_release();
        composer.startReplaceGroup(1763099184);
        ComposerKt.sourceInformation(composer, "CC(remember):AndroidFrescoPainter.kt#9igjgp");
        boolean changed = composer.changed(obj2) | composer.changed(obj) | composer.changed(scaleType) | composer.changed(imageScaleType) | composer.changed(borderOption$kmpimage_release) | composer.changed(scaleType$kmpimage_release) | composer.changed(colorFilter$kmpimage_release) | composer.changed(smartCrop$kmpimage_release);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            function1 = null;
            GenericDraweeHierarchy build = GenericDraweeHierarchyInflater.inflateBuilder(context, (AttributeSet) null).build();
            if (loadingPlaceHolder$kmpimage_release != null) {
                ImageScaleType scaleType2 = loadingPlaceHolder$kmpimage_release.getScaleType();
                KImageSource imageSource3 = loadingPlaceHolder$kmpimage_release.getImageSource();
                if (imageSource3.isLocalSource()) {
                    int resourceId = ImageUtilsKt.getResourceId(imageSource3);
                    if (resourceId != 0) {
                        if (scaleType2 == null || ImageUtilsKt.toFrescoScaleType(scaleType2) == null) {
                            build.setProgressBarImage(resourceId);
                        } else {
                            build.setProgressBarImage(resourceId, ImageUtilsKt.toFrescoScaleType(scaleType2));
                        }
                    }
                } else if (imageSource3.getType() == 4) {
                    build.setProgressBarImage(ImageUtilsKt.toDrawable(imageSource3, context));
                }
            }
            if (errorPlaceHolder$kmpimage_release != null) {
                ImageScaleType scaleType3 = errorPlaceHolder$kmpimage_release.getScaleType();
                KImageSource imageSource4 = errorPlaceHolder$kmpimage_release.getImageSource();
                if (imageSource4.isLocalSource()) {
                    int resourceId2 = ImageUtilsKt.getResourceId(imageSource4);
                    if (resourceId2 != 0) {
                        if (scaleType3 == null || ImageUtilsKt.toFrescoScaleType(scaleType3) == null) {
                            build.setFailureImage(resourceId2);
                        } else {
                            build.setFailureImage(resourceId2, ImageUtilsKt.toFrescoScaleType(scaleType3));
                        }
                    }
                } else if (imageSource4.getType() == 4) {
                    build.setFailureImage(ImageUtilsKt.toDrawable(imageSource4, context));
                }
            }
            if (ImageUtilsKt.toFrescoScaleType(scaleType$kmpimage_release) != null) {
                build.setActualImageScaleType(ImageUtilsKt.toFrescoScaleType(scaleType$kmpimage_release));
            }
            if ((colorFilter$kmpimage_release != null ? colorFilter$kmpimage_release.getPlatformColorFilter() : null) != null) {
                build.setActualImageColorFilter(colorFilter$kmpimage_release.getPlatformColorFilter());
            }
            build.setRoundingParams(roundingParams);
            Function1<GenericDraweeHierarchy, Unit> onHierarchyBuild$kmpimage_release = platformImageConfigurator$kmpimage_release.getOnHierarchyBuild$kmpimage_release();
            Intrinsics.checkNotNullExpressionValue(build, "hierarchy");
            onHierarchyBuild$kmpimage_release.invoke(build);
            composer.updateRememberedValue(build);
            obj3 = build;
        } else {
            function1 = null;
            obj3 = rememberedValue;
        }
        DraweeHierarchy draweeHierarchy = (GenericDraweeHierarchy) obj3;
        composer.endReplaceGroup();
        ImageLoadListener imageLoadListener$kmpimage_release = imageOptions.getImageLoadListener$kmpimage_release();
        AnimatedImageOptions animatedImageOptions$kmpimage_release = imageOptions.getAnimatedImageOptions$kmpimage_release();
        ImageAnimationListener animationListener = animatedImageOptions$kmpimage_release != null ? animatedImageOptions$kmpimage_release.getAnimationListener() : function1;
        AnimatedImageOptions animatedImageOptions$kmpimage_release2 = imageOptions.getAnimatedImageOptions$kmpimage_release();
        Function1<ImageAnimationController, Unit> onControllerReady$kmpimage_release = animatedImageOptions$kmpimage_release2 != null ? animatedImageOptions$kmpimage_release2.getOnControllerReady$kmpimage_release() : function1;
        composer.startReplaceGroup(-1878998491);
        ComposerKt.sourceInformation(composer, "CC(remember):AndroidFrescoPainter.kt#9igjgp");
        boolean changed2 = composer.changed(draweeHierarchy) | composer.changed(context);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = DraweeHolder.create(draweeHierarchy, context);
            composer.updateRememberedValue(rememberedValue2);
        }
        final DraweeHolder draweeHolder = (DraweeHolder) rememberedValue2;
        composer.endReplaceGroup();
        Intrinsics.checkNotNullExpressionValue(draweeHolder, "remember(draweeHierarchy…Hierarchy, context)\n    }");
        boolean z = kImageSource instanceof LocalResourceSource;
        if (z) {
            obj4 = Integer.valueOf(((LocalResourceSource) kImageSource).getResource().getId());
        } else if (kImageSource instanceof AssetSource) {
            obj4 = ((AssetSource) kImageSource).getFileUri();
        } else if (kImageSource instanceof UrlSource) {
            obj4 = ((UrlSource) kImageSource).getUrls().toString();
        } else if (kImageSource instanceof ColorSource) {
            obj4 = Long.valueOf(((ColorSource) kImageSource).getColor());
        } else if (kImageSource instanceof None) {
            obj4 = 0;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        boolean z2 = imageLoadListener$kmpimage_release == null;
        if (blurOption$kmpimage_release != null) {
            function1 = Integer.valueOf(blurOption$kmpimage_release.getRadius());
        }
        composer.startReplaceGroup(1763099184);
        ComposerKt.sourceInformation(composer, "CC(remember):AndroidFrescoPainter.kt#9igjgp");
        boolean changed3 = composer.changed(function1) | composer.changed(obj4) | composer.changed(z2);
        Priority priority2 = priority;
        boolean changed4 = changed3 | composer.changed(priority2) | composer.changed(smartCrop$kmpimage_release);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed4 || rememberedValue3 == Composer.Companion.getEmpty()) {
            if (kImageSource instanceof UrlSource) {
                List mutableList = CollectionsKt.toMutableList(((UrlSource) kImageSource).getUrls());
                String str = (String) CollectionsKt.firstOrNull(mutableList);
                if (str == null) {
                    str = "";
                }
                newBuilderWithResourceId = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str));
                if (mutableList.size() > 1) {
                    List subList = mutableList.subList(1, mutableList.size());
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
                    Iterator it = subList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Uri.parse((String) it.next()));
                    }
                    newBuilderWithResourceId.setBackup(arrayList);
                }
                newBuilderWithResourceId.setRequestPriority(ImageUtilsKt.toFrescoPriority(priority2));
                if (blurOption$kmpimage_release != null) {
                    blurOption$kmpimage_release.getRadius();
                    newBuilderWithResourceId.setPostprocessor(new BlurPostProcessor(blurOption$kmpimage_release.getRadius(), context, 3));
                }
                Function1<ImageRequestBuilder, Unit> onRequestBuild$kmpimage_release = platformImageConfigurator$kmpimage_release.getOnRequestBuild$kmpimage_release();
                Intrinsics.checkNotNullExpressionValue(newBuilderWithResourceId, "requestBuilder");
                onRequestBuild$kmpimage_release.invoke(newBuilderWithResourceId);
                HashMap customParam = newBuilderWithResourceId.getCustomParam();
                if (customParam == null) {
                    customParam = new HashMap();
                } else {
                    Intrinsics.checkNotNullExpressionValue(customParam, "requestBuilder.customParam ?: HashMap()");
                }
                customParam.put(PlatformImageConfiguratorKt.REQUEST_KMP_TAG, "1");
                newBuilderWithResourceId.setCustomParam(customParam);
            } else {
                if (z ? true : kImageSource instanceof ColorSource) {
                    newBuilderWithResourceId = ImageRequestBuilder.newBuilderWithResourceId(ImageUtilsKt.getResourceId(kImageSource));
                    newBuilderWithResourceId.setRequestPriority(ImageUtilsKt.toFrescoPriority(priority2));
                    newBuilderWithResourceId.setBlurHashOptions(ImageUtilsKt.toBlurHashConfig(blurOption$kmpimage_release));
                    Function1<ImageRequestBuilder, Unit> onRequestBuild$kmpimage_release2 = platformImageConfigurator$kmpimage_release.getOnRequestBuild$kmpimage_release();
                    Intrinsics.checkNotNullExpressionValue(newBuilderWithResourceId, "builder");
                    onRequestBuild$kmpimage_release2.invoke(newBuilderWithResourceId);
                } else if (kImageSource instanceof AssetSource) {
                    newBuilderWithResourceId = ImageRequestBuilder.newBuilderWithSource(Uri.parse(((AssetSource) kImageSource).getFileUri()));
                    newBuilderWithResourceId.setRequestPriority(ImageUtilsKt.toFrescoPriority(priority2));
                    newBuilderWithResourceId.setBlurHashOptions(ImageUtilsKt.toBlurHashConfig(blurOption$kmpimage_release));
                    Function1<ImageRequestBuilder, Unit> onRequestBuild$kmpimage_release3 = platformImageConfigurator$kmpimage_release.getOnRequestBuild$kmpimage_release();
                    Intrinsics.checkNotNullExpressionValue(newBuilderWithResourceId, "builder");
                    onRequestBuild$kmpimage_release3.invoke(newBuilderWithResourceId);
                } else if (Intrinsics.areEqual(kImageSource, None.INSTANCE)) {
                    newBuilderWithResourceId = ImageRequestBuilder.newBuilderWithResourceId(0);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            if (smartCrop$kmpimage_release) {
                newBuilderWithResourceId.setImageDecodeOptions(new ImageDecodeOptionsBuilder().setUseSmartCrop(true).build());
            }
            rememberedValue3 = newBuilderWithResourceId.build();
            composer.updateRememberedValue(rememberedValue3);
        }
        ImageRequest imageRequest = (ImageRequest) rememberedValue3;
        composer.endReplaceGroup();
        Intrinsics.checkNotNullExpressionValue(imageRequest, "remember(imageSource.get…uestBuilder.build()\n    }");
        boolean earlyAttachOptimization$kmpimage_release = imageOptions.getEarlyAttachOptimization$kmpimage_release();
        if (earlyAttachOptimization$kmpimage_release) {
            composer.startReplaceGroup(860956317);
            ComposerKt.sourceInformation(composer, "199@8436L993");
            boolean z3 = imageLoadListener$kmpimage_release == null;
            boolean z4 = animationListener == null;
            boolean z5 = onControllerReady$kmpimage_release == null;
            composer.startReplaceGroup(1763099184);
            ComposerKt.sourceInformation(composer, "CC(remember):AndroidFrescoPainter.kt#9igjgp");
            boolean changed5 = composer.changed(z3) | composer.changed(draweeHolder) | composer.changed(imageRequest) | composer.changed(z4) | composer.changed(z5);
            Object rememberedValue4 = composer.rememberedValue();
            if (changed5 || rememberedValue4 == Composer.Companion.getEmpty()) {
                PipelineDraweeControllerBuilder oldController = Fresco.newDraweeControllerBuilder().setImageRequest(imageRequest).setAutoPlayAnimations(true).setOldController(draweeHolder.getController());
                Function1<PipelineDraweeControllerBuilder, Unit> onControllerBuild$kmpimage_release = platformImageConfigurator$kmpimage_release.getOnControllerBuild$kmpimage_release();
                Intrinsics.checkNotNullExpressionValue(oldController, "newControllerBuilder");
                onControllerBuild$kmpimage_release.invoke(oldController);
                oldController.setControllerListener(new ComposeFrescoControllerListener(imageLoadListener$kmpimage_release, animationListener, onControllerReady$kmpimage_release, oldController.getControllerListener()));
                rememberedValue4 = oldController.build();
                draweeHolder.setController((DraweeController) rememberedValue4);
                composer.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceGroup();
            Intrinsics.checkNotNullExpressionValue((AbstractDraweeController) rememberedValue4, "{\n        remember(holde…ontroller\n        }\n    }");
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(860988816);
            ComposerKt.sourceInformation(composer, "217@9451L1012");
            boolean z6 = imageLoadListener$kmpimage_release == null;
            boolean z7 = animationListener == null;
            boolean z8 = onControllerReady$kmpimage_release == null;
            boolean isAttached = draweeHolder.isAttached();
            composer.startReplaceGroup(1763099184);
            ComposerKt.sourceInformation(composer, "CC(remember):AndroidFrescoPainter.kt#9igjgp");
            boolean changed6 = composer.changed(z6) | composer.changed(draweeHolder) | composer.changed(imageRequest) | composer.changed(z7) | composer.changed(z8) | composer.changed(isAttached);
            Object rememberedValue5 = composer.rememberedValue();
            if (changed6 || rememberedValue5 == Composer.Companion.getEmpty()) {
                PipelineDraweeControllerBuilder oldController2 = Fresco.newDraweeControllerBuilder().setImageRequest(imageRequest).setAutoPlayAnimations(true).setOldController(draweeHolder.getController());
                Function1<PipelineDraweeControllerBuilder, Unit> onControllerBuild$kmpimage_release2 = platformImageConfigurator$kmpimage_release.getOnControllerBuild$kmpimage_release();
                Intrinsics.checkNotNullExpressionValue(oldController2, "newControllerBuilder");
                onControllerBuild$kmpimage_release2.invoke(oldController2);
                oldController2.setControllerListener(new ComposeFrescoControllerListener(imageLoadListener$kmpimage_release, animationListener, onControllerReady$kmpimage_release, oldController2.getControllerListener()));
                rememberedValue5 = oldController2.build();
                draweeHolder.setController((DraweeController) rememberedValue5);
                composer.updateRememberedValue(rememberedValue5);
            }
            composer.endReplaceGroup();
            Intrinsics.checkNotNullExpressionValue((AbstractDraweeController) rememberedValue5, "{\n        remember(holde…ontroller\n        }\n    }");
            composer.endReplaceGroup();
        }
        if (earlyAttachOptimization$kmpimage_release) {
            composer.startReplaceGroup(921922277);
            ComposerKt.sourceInformation(composer, "240@10644L665");
            composer.startReplaceGroup(655565057);
            ComposerKt.sourceInformation(composer, "CC(remember):AndroidFrescoPainter.kt#9igjgp");
            boolean changed7 = composer.changed(draweeHolder);
            Object rememberedValue6 = composer.rememberedValue();
            if (changed7 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new RememberObserver(draweeHolder) { // from class: com.bytedance.kmp.image.painter.AndroidFrescoPainterKt$rememberPlatformPainter$1$1
                    final /* synthetic */ DraweeHolder<GenericDraweeHierarchy> $holder;

                    public void onRemembered() {
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$holder = draweeHolder;
                        draweeHolder.onAttach();
                    }

                    public void onAbandoned() {
                        this.$holder.onDetach();
                    }

                    public void onForgotten() {
                        this.$holder.onDetach();
                    }
                };
                composer.updateRememberedValue(rememberedValue6);
            }
            composer.endReplaceGroup();
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(922686458);
            ComposerKt.sourceInformation(composer, "263@11356L83,263@11331L108");
            composer.startReplaceGroup(655565057);
            ComposerKt.sourceInformation(composer, "CC(remember):AndroidFrescoPainter.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(draweeHolder);
            Object rememberedValue7 = composer.rememberedValue();
            if (changedInstance || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.bytedance.kmp.image.painter.AndroidFrescoPainterKt$rememberPlatformPainter$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                        final DraweeHolder<GenericDraweeHierarchy> draweeHolder2 = draweeHolder;
                        return new DisposableEffectResult() { // from class: com.bytedance.kmp.image.painter.AndroidFrescoPainterKt$rememberPlatformPainter$2$1$invoke$$inlined$onDispose$1
                            public void dispose() {
                                draweeHolder2.onDetach();
                            }
                        };
                    }
                };
                composer.updateRememberedValue(rememberedValue7);
            }
            composer.endReplaceGroup();
            EffectsKt.DisposableEffect(draweeHolder, (Function1) rememberedValue7, composer, 0);
            composer.endReplaceGroup();
        }
        composer.startReplaceGroup(655565057);
        ComposerKt.sourceInformation(composer, "CC(remember):AndroidFrescoPainter.kt#9igjgp");
        boolean changed8 = composer.changed(draweeHolder);
        Object rememberedValue8 = composer.rememberedValue();
        if (changed8 || rememberedValue8 == Composer.Companion.getEmpty()) {
            Drawable topLevelDrawable = draweeHolder.getTopLevelDrawable();
            Intrinsics.checkNotNullExpressionValue(topLevelDrawable, "holder.topLevelDrawable");
            rememberedValue8 = new DrawablePainter(topLevelDrawable);
            composer.updateRememberedValue(rememberedValue8);
        }
        DrawablePainter drawablePainter = (DrawablePainter) rememberedValue8;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return drawablePainter;
    }
}
