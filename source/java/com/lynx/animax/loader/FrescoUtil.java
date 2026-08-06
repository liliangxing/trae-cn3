package com.lynx.animax.loader;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.datasource.BaseBitmapReferenceDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.animax.loader.IAnimaXLoaderRequest;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.DeviceUtil;
import com.lynx.animax.util.UriUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class FrescoUtil {
    private static final int RGBA8888_PIXEL_BYTES = 4;
    private static final String TAG = "FrescoUtil";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface FrescoBitmapCompletionHandler {
        void onComplete(IAnimaXCloseableBitmapReference iAnimaXCloseableBitmapReference, String str);
    }

    public static boolean tryHandleLoaderRequestWithFresco(IAnimaXLoaderRequest iAnimaXLoaderRequest, final IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler) {
        IAnimaXLoaderRequest.IImageInfo imageInfo = iAnimaXLoaderRequest.getImageInfo();
        if (imageInfo == null) {
            return false;
        }
        fetchBitmapUriWithFresco(UriUtil.safeParse(iAnimaXLoaderRequest.getUri()), imageInfo.getWidth(), imageInfo.getHeight(), new FrescoBitmapCompletionHandler() { // from class: com.lynx.animax.loader.FrescoUtil$$ExternalSyntheticLambda0
            @Override // com.lynx.animax.loader.FrescoUtil.FrescoBitmapCompletionHandler
            public final void onComplete(IAnimaXCloseableBitmapReference iAnimaXCloseableBitmapReference, String str) {
                FrescoUtil.lambda$tryHandleLoaderRequestWithFresco$0(IAnimaXLoaderCompletionHandler.this, iAnimaXCloseableBitmapReference, str);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$tryHandleLoaderRequestWithFresco$0(IAnimaXLoaderCompletionHandler iAnimaXLoaderCompletionHandler, IAnimaXCloseableBitmapReference iAnimaXCloseableBitmapReference, String str) {
        AnimaXLoaderResponse<?> createErrorResponse;
        if (iAnimaXCloseableBitmapReference == null || !str.isEmpty()) {
            createErrorResponse = AnimaXLoaderResponse.createErrorResponse(new Throwable(str));
        } else {
            createErrorResponse = AnimaXLoaderResponse.createBitmapResponse(iAnimaXCloseableBitmapReference);
        }
        iAnimaXLoaderCompletionHandler.onComplete(createErrorResponse);
    }

    public static void fetchBitmapUriWithFresco(Uri uri, int i, int i2, final FrescoBitmapCompletionHandler frescoBitmapCompletionHandler) {
        ImageRequestBuilder requestPriority = ImageRequestBuilder.newBuilderWithSource(uri).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.ARGB_8888).setForceStaticImage(true).build()).setRequestPriority(Priority.HIGH);
        if (DeviceUtil.needSampleImage(i, i2)) {
            requestPriority.setResizeOptions(new ResizeOptions(i / 2, i2 / 2));
        }
        final DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(requestPriority.build(), TAG);
        fetchDecodedImage.subscribe(new BaseBitmapReferenceDataSubscriber() { // from class: com.lynx.animax.loader.FrescoUtil.1
            @Override // com.facebook.imagepipeline.datasource.BaseBitmapReferenceDataSubscriber
            protected void onNewResultImpl(CloseableReference<Bitmap> closeableReference) {
                Bitmap bitmap = closeableReference != null ? closeableReference.get() : null;
                if (bitmap != null) {
                    if (FrescoUtil.checkBitmapRGBA8888(bitmap)) {
                        FrescoBitmapCompletionHandler.this.onComplete(new FrescoCloseableBitmapReference(closeableReference), "");
                    } else {
                        AnimaXLog.m2541i(FrescoUtil.TAG, "Fresco returned a bitmap with an invalid format. Attempting to convert it to ARGB_8888.");
                        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
                        if (FrescoUtil.checkBitmapRGBA8888(copy)) {
                            FrescoBitmapCompletionHandler.this.onComplete(new SimpleCloseableBitmapReference(copy), "");
                        } else {
                            FrescoBitmapCompletionHandler.this.onComplete(null, "Fresco returned unknown bitmap format which cannot be converted to RGBA8888.");
                        }
                    }
                } else {
                    FrescoBitmapCompletionHandler.this.onComplete(null, "Fresco returned a null bitmap on success.");
                }
                fetchDecodedImage.close();
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                FrescoBitmapCompletionHandler.this.onComplete(null, dataSource.getFailureCause() != null ? "Fresco failed to load bitmap.reason: " + dataSource.getFailureCause().getMessage() : "Fresco failed to load bitmap.");
                dataSource.close();
            }
        }, CallerThreadExecutor.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkBitmapRGBA8888(Bitmap bitmap) {
        return bitmap != null && (bitmap.getWidth() * bitmap.getHeight()) * 4 == bitmap.getByteCount();
    }
}
