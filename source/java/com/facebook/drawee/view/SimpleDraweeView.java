package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.Lazy;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.C0202R;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.IAbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.BlurHashBitmapDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweePlaceHolderConfig;
import com.facebook.imagepipeline.blurhash.BlurDecodeProducer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer;
import com.facebook.imagepipeline.blurhash2.PreviewHashConfig;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.fackbook.drawee.DefaultDraweeConfig;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SimpleDraweeView extends GenericDraweeView {
    private static DraweePlaceHolderConfig sDefaultDraweePlaceHolderConfig;
    private static boolean sEnableLazySize;
    private static IAbstractDraweeControllerBuilder sIDraweecontrollerbuildersupplier;
    private Lazy<AbstractDraweeControllerBuilder> mControllerBuilder;
    private static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier = getDefaultControllerBuilder(!FrescoCacheMonitorUtil.isControllerBuilderByLazyInit());
    private static boolean sEnableVisibleOpt = true;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface PreviewBlurHashCallBack {
        void blurhashFailed(String str, String str2);

        void blurhashResult(long j, Bitmap bitmap);
    }

    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> supplier) {
        sDraweecontrollerbuildersupplier = supplier;
        sDefaultDraweePlaceHolderConfig = supplier.get().getDraweePlaceHolderConfig();
    }

    public static void enableLazySize(boolean z) {
        sEnableLazySize = z;
    }

    public static void enableVisibleOpt(boolean z) {
        sEnableVisibleOpt = z;
    }

    public static void initialize(IAbstractDraweeControllerBuilder iAbstractDraweeControllerBuilder) {
        sIDraweecontrollerbuildersupplier = iAbstractDraweeControllerBuilder;
        sDefaultDraweePlaceHolderConfig = iAbstractDraweeControllerBuilder.getDraweePlaceHolderConfig();
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Supplier<? extends AbstractDraweeControllerBuilder> getDefaultControllerBuilder(boolean z) {
        if (z) {
            return DefaultDraweeConfig.INSTANCE.getDraweeControllerBuilder();
        }
        return null;
    }

    public SimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        this.mControllerBuilder = new Lazy<AbstractDraweeControllerBuilder>() { // from class: com.facebook.drawee.view.SimpleDraweeView.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.util.Lazy
            public AbstractDraweeControllerBuilder initialValue() {
                if (SimpleDraweeView.this.isInEditMode()) {
                    return null;
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null && FrescoCacheMonitorUtil.isControllerBuilderByLazyInit()) {
                    Supplier unused = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.getDefaultControllerBuilder(true);
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null) {
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder(), "SimpleDraweeView was not initialized!");
                    Supplier unused2 = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder();
                }
                return (AbstractDraweeControllerBuilder) SimpleDraweeView.sDraweecontrollerbuildersupplier.get();
            }
        };
        init(context, null);
    }

    public SimpleDraweeView(Context context) {
        super(context);
        this.mControllerBuilder = new Lazy<AbstractDraweeControllerBuilder>() { // from class: com.facebook.drawee.view.SimpleDraweeView.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.util.Lazy
            public AbstractDraweeControllerBuilder initialValue() {
                if (SimpleDraweeView.this.isInEditMode()) {
                    return null;
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null && FrescoCacheMonitorUtil.isControllerBuilderByLazyInit()) {
                    Supplier unused = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.getDefaultControllerBuilder(true);
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null) {
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder(), "SimpleDraweeView was not initialized!");
                    Supplier unused2 = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder();
                }
                return (AbstractDraweeControllerBuilder) SimpleDraweeView.sDraweecontrollerbuildersupplier.get();
            }
        };
        init(context, null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mControllerBuilder = new Lazy<AbstractDraweeControllerBuilder>() { // from class: com.facebook.drawee.view.SimpleDraweeView.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.util.Lazy
            public AbstractDraweeControllerBuilder initialValue() {
                if (SimpleDraweeView.this.isInEditMode()) {
                    return null;
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null && FrescoCacheMonitorUtil.isControllerBuilderByLazyInit()) {
                    Supplier unused = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.getDefaultControllerBuilder(true);
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null) {
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder(), "SimpleDraweeView was not initialized!");
                    Supplier unused2 = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder();
                }
                return (AbstractDraweeControllerBuilder) SimpleDraweeView.sDraweecontrollerbuildersupplier.get();
            }
        };
        init(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mControllerBuilder = new Lazy<AbstractDraweeControllerBuilder>() { // from class: com.facebook.drawee.view.SimpleDraweeView.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.util.Lazy
            public AbstractDraweeControllerBuilder initialValue() {
                if (SimpleDraweeView.this.isInEditMode()) {
                    return null;
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null && FrescoCacheMonitorUtil.isControllerBuilderByLazyInit()) {
                    Supplier unused = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.getDefaultControllerBuilder(true);
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null) {
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder(), "SimpleDraweeView was not initialized!");
                    Supplier unused2 = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder();
                }
                return (AbstractDraweeControllerBuilder) SimpleDraweeView.sDraweecontrollerbuildersupplier.get();
            }
        };
        init(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mControllerBuilder = new Lazy<AbstractDraweeControllerBuilder>() { // from class: com.facebook.drawee.view.SimpleDraweeView.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.util.Lazy
            public AbstractDraweeControllerBuilder initialValue() {
                if (SimpleDraweeView.this.isInEditMode()) {
                    return null;
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null && FrescoCacheMonitorUtil.isControllerBuilderByLazyInit()) {
                    Supplier unused = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.getDefaultControllerBuilder(true);
                }
                if (SimpleDraweeView.sDraweecontrollerbuildersupplier == null) {
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                    Preconditions.checkNotNull(SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder(), "SimpleDraweeView was not initialized!");
                    Supplier unused2 = SimpleDraweeView.sDraweecontrollerbuildersupplier = SimpleDraweeView.sIDraweecontrollerbuildersupplier.getAbstractDraweeControllerBuilder();
                }
                return (AbstractDraweeControllerBuilder) SimpleDraweeView.sDraweecontrollerbuildersupplier.get();
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet) {
        int resourceId;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("SimpleDraweeView#init");
            }
            if (isInEditMode()) {
                getHierarchy().setRoundingParams(null);
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            }
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0202R.styleable.SimpleDraweeView);
                try {
                    if (obtainStyledAttributes.hasValue(C0202R.styleable.SimpleDraweeView_actualImageUri)) {
                        setImageURI(Uri.parse(obtainStyledAttributes.getString(C0202R.styleable.SimpleDraweeView_actualImageUri)), (Object) null);
                    } else if (obtainStyledAttributes.hasValue(C0202R.styleable.SimpleDraweeView_actualImageResource) && (resourceId = obtainStyledAttributes.getResourceId(C0202R.styleable.SimpleDraweeView_actualImageResource, -1)) != -1) {
                        if (isInEditMode()) {
                            setImageResource(resourceId);
                        } else {
                            setActualImageResource(resourceId);
                        }
                    }
                    setDefaultPlaceHolder(obtainStyledAttributes);
                    obtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                    throw th;
                }
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    protected AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder.get();
    }

    public void setImageRequest(ImageRequest imageRequest) {
        setController(this.mControllerBuilder.get().setImageRequest(imageRequest).setOldController(getController()).build());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageURI(uri, (Object) null);
    }

    public void setImageURI(@Nullable String str) {
        setImageURI(str, (Object) null);
    }

    public void setImageURIWithBlur(Uri uri, String str, PreviewHashConfig previewHashConfig) {
        setImageURI(uri, (Object) null, false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setPreviewHashImage(str, previewHashConfig, (PreviewBlurHashCallBack) null);
    }

    public void setPreviewHashImage(String str, PreviewHashConfig previewHashConfig) {
        setPreviewHashImage(str, previewHashConfig, (PreviewBlurHashCallBack) null);
    }

    public void setPreviewHashImage(final String str, final PreviewHashConfig previewHashConfig, final PreviewBlurHashCallBack previewBlurHashCallBack) {
        if (TextUtils.isEmpty(str)) {
            FLog.m430d("SimpleDraweeView", "setPreviewHashImage, base64data is null!");
            return;
        }
        DraweeController controller = getController();
        ImageRequest imageRequest = null;
        if (controller instanceof AbstractDraweeController) {
            ImageRequest imageRequest2 = ((AbstractDraweeController) controller).getImageRequest();
            if (imageRequest2 instanceof ImageRequest) {
                imageRequest = imageRequest2;
            }
        }
        final ImageRequest imageRequest3 = imageRequest;
        if (imageRequest3 != null) {
            imageRequest3.setPreviewUsed(true);
            if (previewHashConfig != null && previewHashConfig.isOptVvic()) {
                imageRequest3.setPreviewAlgo(3);
            } else {
                imageRequest3.setPreviewAlgo(2);
            }
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        new PreviewBlurHashProducer(str, previewHashConfig, new PreviewBlurHashProducer.PreviewBlurDecodeCallBack() { // from class: com.facebook.drawee.view.SimpleDraweeView.2
            @Override // com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer.PreviewBlurDecodeCallBack
            public void decodeResult(Bitmap bitmap) {
                if (bitmap != null) {
                    PreviewBlurHashCallBack previewBlurHashCallBack2 = previewBlurHashCallBack;
                    if (previewBlurHashCallBack2 != null) {
                        previewBlurHashCallBack2.blurhashResult(SystemClock.uptimeMillis() - uptimeMillis, bitmap);
                    }
                    final BlurHashBitmapDrawable blurHashBitmapDrawable = new BlurHashBitmapDrawable(bitmap, previewHashConfig.getWidth(), previewHashConfig.getHeight(), SimpleDraweeView.this.getHierarchy() != null ? SimpleDraweeView.this.getHierarchy().getActualImageScaleType() : ScalingUtils.ScaleType.FIT_CENTER);
                    if (SimpleDraweeView.this.getRootView() != null) {
                        SimpleDraweeView.this.post(new Runnable() { // from class: com.facebook.drawee.view.SimpleDraweeView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                if (imageRequest3 != null) {
                                    imageRequest3.setPreviewDecodeTime(uptimeMillis2);
                                    imageRequest3.setPreviewDecodeEnd(SystemClock.uptimeMillis());
                                }
                                SimpleDraweeView.this.getHierarchy().setPlaceholderImage(blurHashBitmapDrawable, ScalingUtils.ScaleType.FIT_XY);
                            }
                        });
                        return;
                    }
                    return;
                }
                ImageRequest imageRequest4 = imageRequest3;
                if (imageRequest4 != null) {
                    imageRequest4.setPreviewError(str);
                }
            }
        }, new PreviewBlurHashProducer.PreviewDealFailCallBack() { // from class: com.facebook.drawee.view.SimpleDraweeView.3
            @Override // com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer.PreviewDealFailCallBack
            public void decodeFailed(String str2) {
                PreviewBlurHashCallBack previewBlurHashCallBack2 = previewBlurHashCallBack;
                if (previewBlurHashCallBack2 != null) {
                    previewBlurHashCallBack2.blurhashFailed(str, str2);
                }
            }
        });
    }

    public void setPreviewHashImage(String str, String str2, PreviewHashConfig previewHashConfig) {
        setPreviewHashImage(str, str2, previewHashConfig, null);
    }

    public void setPreviewHashImage(String str, final String str2, final PreviewHashConfig previewHashConfig, final PreviewBlurHashCallBack previewBlurHashCallBack) {
        if (TextUtils.isEmpty(str2)) {
            FLog.m430d("SimpleDraweeView", "setPreviewHashImage, base64data is null!");
            return;
        }
        DraweeController controller = getController();
        ImageRequest imageRequest = null;
        if (controller instanceof AbstractDraweeController) {
            ImageRequest imageRequest2 = ((AbstractDraweeController) controller).getImageRequest();
            if (imageRequest2 instanceof ImageRequest) {
                imageRequest = imageRequest2;
            }
        }
        final ImageRequest imageRequest3 = imageRequest;
        if (imageRequest3 != null) {
            imageRequest3.setPreviewUsed(true);
            if (previewHashConfig != null && previewHashConfig.isOptVvic()) {
                imageRequest3.setPreviewAlgo(3);
            } else {
                imageRequest3.setPreviewAlgo(2);
            }
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        new PreviewBlurHashProducer(str2, str, previewHashConfig, new PreviewBlurHashProducer.PreviewBlurDecodeCallBack() { // from class: com.facebook.drawee.view.SimpleDraweeView.4
            @Override // com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer.PreviewBlurDecodeCallBack
            public void decodeResult(Bitmap bitmap) {
                if (bitmap != null) {
                    PreviewBlurHashCallBack previewBlurHashCallBack2 = previewBlurHashCallBack;
                    if (previewBlurHashCallBack2 != null) {
                        previewBlurHashCallBack2.blurhashResult(SystemClock.uptimeMillis() - uptimeMillis, bitmap);
                    }
                    final BlurHashBitmapDrawable blurHashBitmapDrawable = new BlurHashBitmapDrawable(bitmap, previewHashConfig.getWidth(), previewHashConfig.getHeight(), SimpleDraweeView.this.getHierarchy() != null ? SimpleDraweeView.this.getHierarchy().getActualImageScaleType() : ScalingUtils.ScaleType.FIT_CENTER);
                    if (SimpleDraweeView.this.getRootView() != null) {
                        SimpleDraweeView.this.post(new Runnable() { // from class: com.facebook.drawee.view.SimpleDraweeView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                if (imageRequest3 != null) {
                                    imageRequest3.setPreviewDecodeTime(uptimeMillis2);
                                    imageRequest3.setPreviewDecodeEnd(SystemClock.uptimeMillis());
                                }
                                SimpleDraweeView.this.getHierarchy().setPlaceholderImage(blurHashBitmapDrawable, ScalingUtils.ScaleType.FIT_XY);
                            }
                        });
                        return;
                    }
                    return;
                }
                ImageRequest imageRequest4 = imageRequest3;
                if (imageRequest4 != null) {
                    imageRequest4.setPreviewError(str2);
                }
            }
        }, new PreviewBlurHashProducer.PreviewDealFailCallBack() { // from class: com.facebook.drawee.view.SimpleDraweeView.5
            @Override // com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer.PreviewDealFailCallBack
            public void decodeFailed(String str3) {
                PreviewBlurHashCallBack previewBlurHashCallBack2 = previewBlurHashCallBack;
                if (previewBlurHashCallBack2 != null) {
                    previewBlurHashCallBack2.blurhashFailed(str2, str3);
                }
            }
        });
    }

    public void setImageURI(@Nullable String str, String str2, BlurHashConfig blurHashConfig) {
        setImageURI(str, (Object) null);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        setBlurHashImage(str2, blurHashConfig);
    }

    public void setImageURI(Uri uri, String str, BlurHashConfig blurHashConfig) {
        setImageURI(uri, (Object) null, false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setBlurHashImage(str, blurHashConfig);
    }

    public void setController(@Nullable DraweeController draweeController, String str, BlurHashConfig blurHashConfig) {
        setController(draweeController);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setBlurHashImage(str, blurHashConfig);
        if (draweeController instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController).setEnableHeaderBlurhash(false);
        }
    }

    public void setImageURI(Uri uri, @Nullable Object obj, boolean z) {
        if (sEnableLazySize && uri != null) {
            setLazySizeAttach(new LazySizeAttach(ImageRequestBuilder.newBuilderWithSource(uri), this.mControllerBuilder.get().setCallerContext(obj).setOldController(getController()).setEnableHeaderBlurhash(z), this));
        } else {
            setController(this.mControllerBuilder.get().setCallerContext(obj).setEnableHeaderBlurhash(z).setUri(uri).setOldController(getController()).build());
        }
    }

    public void setImageURI(Uri uri, @Nullable Object obj) {
        if (sEnableLazySize && uri != null) {
            setLazySizeAttach(new LazySizeAttach(ImageRequestBuilder.newBuilderWithSource(uri), this.mControllerBuilder.get().setCallerContext(obj).setOldController(getController()), this));
        } else {
            setController(this.mControllerBuilder.get().setCallerContext(obj).setUri(uri).setOldController(getController()).build());
        }
    }

    public void setImageURI(@Nullable String str, @Nullable Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }

    public void setImageURI(@Nullable String str, String str2, String str3) {
        setImageURI(str != null ? Uri.parse(str) : null, str2, str3, null);
    }

    public void setImageURI(Uri uri, String str, String str2) {
        setImageURI(uri, str, str2, null);
    }

    public void setImageURI(Uri uri, String str, String str2, @Nullable Object obj) {
        if (sEnableLazySize && uri != null) {
            setLazySizeAttach(new LazySizeAttach(ImageRequestBuilder.newBuilderWithSource(uri).setPublicKey(str).setUrlKey(str2), this.mControllerBuilder.get().setCallerContext(obj).setOldController(getController()), this));
        } else {
            setController(this.mControllerBuilder.get().setCallerContext(obj).setUri(uri, str, str2).setOldController(getController()).build());
        }
    }

    public void setActualImageResource(int i) {
        setActualImageResource(i, null);
    }

    public void setActualImageResource(int i, @Nullable Object obj) {
        setImageURI(UriUtil.getUriForResourceId(i), obj);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onVisibilityAggregated(final boolean z) {
        UiThreadImmediateExecutorService.getInstance().execute(new Runnable() { // from class: com.facebook.drawee.view.SimpleDraweeView.6
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable;
                SimpleDraweeView.super.onVisibilityAggregated(z);
                if (SimpleDraweeView.sEnableVisibleOpt) {
                    if ((z || !FrescoCacheMonitorUtil.isOptSimpleDraweeViewAnr()) && (drawable = SimpleDraweeView.this.getDrawable()) != null) {
                        drawable.setVisible(true, false);
                    }
                }
            }
        });
    }

    public Uri getImageUri() {
        DraweeController controller = getController();
        if (!(controller instanceof AbstractDraweeController)) {
            return null;
        }
        ImageRequest imageRequest = ((AbstractDraweeController) controller).getImageRequest();
        if (imageRequest instanceof ImageRequest) {
            return imageRequest.getSourceUri();
        }
        return null;
    }

    private void setDefaultPlaceHolder(TypedArray typedArray) {
        DraweePlaceHolderConfig draweePlaceHolderConfig = sDefaultDraweePlaceHolderConfig;
        if (draweePlaceHolderConfig == null) {
            return;
        }
        setDefaultPlaceHolderImage(typedArray, draweePlaceHolderConfig);
        setDefaultFailureImage(typedArray, sDefaultDraweePlaceHolderConfig);
    }

    public void setBlurHashImage(final String str, final BlurHashConfig blurHashConfig) {
        if (TextUtils.isEmpty(str)) {
            FLog.m430d("SimpleDraweeView", "setBlurHashImage, blurHash is null!");
            return;
        }
        DraweeController controller = getController();
        ImageRequest imageRequest = null;
        if (controller instanceof AbstractDraweeController) {
            ImageRequest imageRequest2 = ((AbstractDraweeController) controller).getImageRequest();
            if (imageRequest2 instanceof ImageRequest) {
                imageRequest = imageRequest2;
            }
        }
        final ImageRequest imageRequest3 = imageRequest;
        if (imageRequest3 != null) {
            imageRequest3.setPreviewUsed(true);
            imageRequest3.setPreviewAlgo(1);
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        new BlurDecodeProducer(str, blurHashConfig, new BlurDecodeProducer.BlurDecodeCallBack() { // from class: com.facebook.drawee.view.SimpleDraweeView.7
            @Override // com.facebook.imagepipeline.blurhash.BlurDecodeProducer.BlurDecodeCallBack
            public void decodeResult(Bitmap bitmap) {
                if (bitmap != null) {
                    final BlurHashBitmapDrawable blurHashBitmapDrawable = new BlurHashBitmapDrawable(bitmap, blurHashConfig.getTargetWidth(), blurHashConfig.getTargetHeight(), SimpleDraweeView.this.getHierarchy() != null ? SimpleDraweeView.this.getHierarchy().getActualImageScaleType() : ScalingUtils.ScaleType.FIT_CENTER);
                    if (SimpleDraweeView.this.getRootView() != null) {
                        SimpleDraweeView.this.post(new Runnable() { // from class: com.facebook.drawee.view.SimpleDraweeView.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                if (imageRequest3 != null) {
                                    imageRequest3.setPreviewDecodeTime(uptimeMillis2);
                                    imageRequest3.setPreviewDecodeEnd(SystemClock.uptimeMillis());
                                }
                                SimpleDraweeView.this.getHierarchy().setPlaceholderImage(blurHashBitmapDrawable, ScalingUtils.ScaleType.FIT_XY);
                            }
                        });
                        return;
                    }
                    ImageRequest imageRequest4 = imageRequest3;
                    if (imageRequest4 != null) {
                        imageRequest4.setPreviewError(str);
                    }
                }
            }
        });
    }

    private void setDefaultPlaceHolderImage(TypedArray typedArray, DraweePlaceHolderConfig draweePlaceHolderConfig) {
        if (typedArray.hasValue(C0202R.styleable.SimpleDraweeView_placeholderImage)) {
            return;
        }
        ScalingUtils.ScaleType placeHolderScaleType = draweePlaceHolderConfig.getPlaceHolderScaleType() == null ? ScalingUtils.ScaleType.FIT_XY : draweePlaceHolderConfig.getPlaceHolderScaleType();
        Drawable placeHolderDrawable = draweePlaceHolderConfig.getPlaceHolderDrawable();
        if (placeHolderDrawable != null) {
            getHierarchy().setPlaceholderImage(placeHolderDrawable, placeHolderScaleType);
        } else if (draweePlaceHolderConfig.getPlaceHolderImageDrawableRes() != 0) {
            getHierarchy().setPlaceholderImage(draweePlaceHolderConfig.getPlaceHolderImageDrawableRes(), placeHolderScaleType);
        } else if (draweePlaceHolderConfig.getPlaceHolderImageColorRes() != 0) {
            getHierarchy().setPlaceholderImage(draweePlaceHolderConfig.getPlaceHolderImageColorRes(), placeHolderScaleType);
        }
    }

    private void setDefaultFailureImage(TypedArray typedArray, DraweePlaceHolderConfig draweePlaceHolderConfig) {
        if (typedArray.hasValue(C0202R.styleable.SimpleDraweeView_failureImage)) {
            return;
        }
        ScalingUtils.ScaleType failureScaleType = draweePlaceHolderConfig.getFailureScaleType() == null ? ScalingUtils.ScaleType.FIT_XY : draweePlaceHolderConfig.getFailureScaleType();
        Drawable placeHolderDrawable = draweePlaceHolderConfig.getPlaceHolderDrawable();
        if (placeHolderDrawable != null) {
            getHierarchy().setFailureImage(placeHolderDrawable, failureScaleType);
        } else if (draweePlaceHolderConfig.getFailureImageDrawableRes() != 0) {
            getHierarchy().setFailureImage(draweePlaceHolderConfig.getFailureImageDrawableRes(), failureScaleType);
        } else if (draweePlaceHolderConfig.getFailureImageColorRes() != 0) {
            getHierarchy().setFailureImage(draweePlaceHolderConfig.getFailureImageColorRes(), failureScaleType);
        }
    }
}
