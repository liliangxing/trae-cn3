package com.lynx.canvas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.lynx.canvas.KryptonLoaderService;
import com.lynx.canvas.loader.KryptonResourceUtils;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.image.ImageUrlRedirectUtils;
import com.lynx.tasm.core.ResManager;
import com.lynx.tasm.image.ImageContent;
import com.lynx.tasm.image.model.ImageInfo;
import com.lynx.tasm.image.model.ImageLoadListener;
import com.lynx.tasm.image.model.ImageRequestInfo;
import com.lynx.tasm.image.model.ImageRequestInfoBuilder;
import com.lynx.tasm.provider.LynxResCallback;
import com.lynx.tasm.provider.LynxResRequest;
import com.lynx.tasm.provider.LynxResResponse;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxResourceService;
import com.lynx.tasm.service.ILynxResourceServiceResponse;
import com.lynx.tasm.service.LynxResourceServiceCallback;
import com.lynx.tasm.service.LynxResourceServiceRequestParams;
import com.lynx.tasm.service.LynxServiceCenter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CanvasLoaderService extends KryptonLoaderService {
    private static final String ASSETS2_PREFIX = "assets://";
    private static final String ASSETS_PREFIX = "assets:///";
    private static final String ASSET_PREFIX = "asset:///";
    private static final String TAG = "KryptonCanvasLoaderService";
    private final WeakReference<LynxContext> mLynxContext;
    private ILynxImageService mLynxImageService;
    private ILynxResourceService mLynxResourceService;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CanvasLoaderService(WeakReference<LynxContext> weakReference) {
        this.mLynxContext = weakReference;
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithDataResolver(String str, KryptonLoaderService.DataResolver dataResolver) {
        if (dataResolver == null) {
            KryptonLLog.m2560e(TAG, "Load url: " + KryptonResourceUtils.getTruncatePath(str) + " failed with null resolver");
            return;
        }
        LoaderResolver loaderResolver = new LoaderResolver(dataResolver, null);
        if (str == null) {
            KryptonLLog.m2560e(TAG, "Load data with invalid null url");
            dataResolver.reject("Failed with invalid null url");
        } else if (KryptonResourceUtils.isDataURI(str)) {
            KryptonLLog.m2561i(TAG, "Load resource with data url: " + KryptonResourceUtils.getTruncatePath(str));
            loadResWithDataUrl(str, loaderResolver);
        } else {
            loadNormalDataWithProperDownloaderAsync(getCompatiblePath(str), loaderResolver);
        }
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithImageResolver(String str, KryptonLoaderService.ImageResolver imageResolver) {
        if (imageResolver == null) {
            KryptonLLog.m2560e(TAG, "Load image: " + KryptonResourceUtils.getTruncatePath(str) + " failed with null resolver");
        } else if (str == null) {
            KryptonLLog.m2560e(TAG, "Load image with invalid null url");
            imageResolver.reject("Failed image invalid null url");
        } else {
            loadImageWithProperLoader(getCompatiblePath(str), imageResolver);
        }
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadImageWithOptions(String str, KryptonLoaderService.ImageLoadOptions imageLoadOptions, KryptonLoaderService.ImageResolver imageResolver) {
        if (imageResolver == null) {
            KryptonLLog.m2560e(TAG, "Load image: " + KryptonResourceUtils.getTruncatePath(str) + " failed with null resolver");
        } else if (str == null || str.isEmpty()) {
            KryptonLLog.m2560e(TAG, "Load image with invalid null url");
            imageResolver.reject("Failed image invalid null url");
        } else {
            loadImageWithProperLoader(getCompatiblePath(str), imageResolver, imageLoadOptions);
        }
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithStreamDelegate(String str, KryptonLoaderService.StreamDelegate streamDelegate) {
        if (streamDelegate == null) {
            KryptonLLog.m2560e(TAG, "loadUrlWithStreamDelegate delegate null with url: " + str);
            return;
        }
        LoaderResolver loaderResolver = new LoaderResolver(null, streamDelegate);
        if (str == null) {
            KryptonLLog.m2560e(TAG, "Load data with invalid null url");
            loaderResolver.reject("Failed with invalid null url");
        } else if (KryptonResourceUtils.isDataURI(str)) {
            loaderResolver.reject("Do not handle data url with stream loader! The url is: " + KryptonResourceUtils.getTruncatePath(str));
        } else {
            loadNormalDataWithProperDownloaderAsync(getCompatiblePath(str), loaderResolver);
        }
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public String redirectUrl(String str) {
        String truncatePath = KryptonResourceUtils.getTruncatePath(str);
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", truncatePath);
            TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL, hashMap);
        }
        String compatiblePath = getCompatiblePath(str);
        if (KryptonResourceUtils.isLocalPath(compatiblePath) || KryptonResourceUtils.isDataURI(compatiblePath)) {
            KryptonLLog.m2560e(TAG, "Local path and base64 path redirect with original url: " + truncatePath);
            TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
            return compatiblePath;
        }
        LynxContext lockLynxContext = lockLynxContext();
        if (lockLynxContext == null) {
            KryptonLLog.m2560e(TAG, "LynxContext null, redirect failed with url: " + truncatePath);
            TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
            return compatiblePath;
        }
        String redirectUrl = ImageUrlRedirectUtils.redirectUrl(lockLynxContext, compatiblePath);
        if (redirectUrl != null && !redirectUrl.equals(compatiblePath)) {
            KryptonLLog.m2561i(TAG, "Redirect the original url: " + compatiblePath + " to new path: " + redirectUrl);
            TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
            return redirectUrl;
        }
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return compatiblePath;
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public byte[] loadUrlSync(String str) {
        try {
            return KryptonResourceUtils.decodeDataURI(str);
        } catch (IllegalArgumentException e) {
            KryptonLLog.m2560e(TAG, "loadUrlSync with error message: " + e.getMessage() + " ,the url is: " + KryptonResourceUtils.getTruncatePath(str));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LoaderResolver {
        private final KryptonLoaderService.DataResolver dataResolver;
        private final KryptonLoaderService.StreamDelegate streamDelegate;

        public LoaderResolver(KryptonLoaderService.DataResolver dataResolver, KryptonLoaderService.StreamDelegate streamDelegate) {
            this.dataResolver = dataResolver;
            this.streamDelegate = streamDelegate;
        }

        public void reject(String str) {
            KryptonLoaderService.StreamDelegate streamDelegate = this.streamDelegate;
            if (streamDelegate != null) {
                streamDelegate.onError(str);
                return;
            }
            KryptonLoaderService.DataResolver dataResolver = this.dataResolver;
            if (dataResolver != null) {
                dataResolver.reject(str);
            }
        }

        public void resolve(byte[] bArr, int i, int i2) {
            KryptonLoaderService.StreamDelegate streamDelegate = this.streamDelegate;
            if (streamDelegate != null) {
                streamDelegate.onStart(bArr.length);
                this.streamDelegate.onData(bArr, 0, bArr.length);
                this.streamDelegate.onEnd();
            } else {
                KryptonLoaderService.DataResolver dataResolver = this.dataResolver;
                if (dataResolver != null) {
                    dataResolver.resolve(bArr, 0, bArr.length);
                }
            }
        }

        public boolean hasStreamDelegate() {
            return this.streamDelegate != null;
        }
    }

    private LynxContext lockLynxContext() {
        WeakReference<LynxContext> weakReference = this.mLynxContext;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNormalDataWithProperDownloader(String str, LoaderResolver loaderResolver) {
        ILynxResourceService lynxResourceService = getLynxResourceService();
        if (lynxResourceService != null && lynxResourceService.isReady()) {
            loadResWithLynxResourceService(str, loaderResolver);
        } else {
            loadResWithLynxResManager(str, loaderResolver);
        }
    }

    private void loadNormalDataWithProperDownloaderAsync(final String str, final LoaderResolver loaderResolver) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new Runnable() { // from class: com.lynx.canvas.CanvasLoaderService.1
            @Override // java.lang.Runnable
            public void run() {
                CanvasLoaderService.this.loadNormalDataWithProperDownloader(str, loaderResolver);
            }
        });
    }

    private void loadImageWithProperLoader(String str, KryptonLoaderService.ImageResolver imageResolver, KryptonLoaderService.ImageLoadOptions imageLoadOptions) {
        ILynxImageService lynxImageService = getLynxImageService();
        boolean z = imageLoadOptions.usingBuiltinImageDecoder;
        boolean z2 = imageLoadOptions.decodeImageInJs;
        if (!z && lynxImageService != null) {
            KryptonLLog.m2561i(TAG, "Handle image load with the LynxImageService.");
            handleImageWithLynxImageService(str, imageResolver);
        } else {
            KryptonLLog.m2561i(TAG, "LynxImageService is not ready, Load and decode image with BitmapFactory.");
            handleImageWithoutLynxImageService(str, imageResolver, z2);
        }
    }

    private void loadImageWithProperLoader(String str, KryptonLoaderService.ImageResolver imageResolver) {
        loadImageWithProperLoader(str, imageResolver, KryptonLoaderService.ImageLoadOptions.defaults());
    }

    private void loadResWithLynxResManager(final String str, final LoaderResolver loaderResolver) {
        KryptonLLog.m2561i(TAG, "Load url : " + str + " with ResManager.");
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RES_MANAGER, hashMap);
        }
        LynxContext lockLynxContext = lockLynxContext();
        ResManager.inst().requestResource(new LynxResRequest(str, lockLynxContext == null ? null : lockLynxContext.getLynxExtraData()), new LynxResCallback() { // from class: com.lynx.canvas.CanvasLoaderService.2
            public void onSuccess(LynxResResponse lynxResResponse) {
                InputStream inputStream = lynxResResponse.getInputStream();
                int totalLengthForLynxResResponse = CanvasLoaderService.this.getTotalLengthForLynxResResponse(lynxResResponse);
                KryptonLLog.m2561i(CanvasLoaderService.TAG, "ResManager load success with url : " + str + " ,the total content length of the file is: " + totalLengthForLynxResResponse);
                if (loaderResolver.hasStreamDelegate()) {
                    CanvasLoaderService.this.handleStreamWithDelegate(str, inputStream, totalLengthForLynxResResponse, loaderResolver);
                } else {
                    CanvasLoaderService.this.HandleStreamWithResolver(str, inputStream, totalLengthForLynxResResponse, loaderResolver);
                }
            }

            public void onFailed(LynxResResponse lynxResResponse) {
                String reasonPhrase = lynxResResponse.getReasonPhrase();
                KryptonLLog.m2560e(CanvasLoaderService.TAG, "ResManager load url: " + str + " ,failed with error " + reasonPhrase);
                loaderResolver.reject(reasonPhrase);
            }
        });
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RES_MANAGER);
    }

    private void loadResWithLynxResourceService(final String str, final LoaderResolver loaderResolver) {
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RESOURCE_SERVICE, hashMap);
        }
        KryptonLLog.m2561i(TAG, "Load url : " + str + " with LynxResourceService.");
        final String redirectUrl = redirectUrl(str);
        if (KryptonResourceUtils.isLocalPath(redirectUrl)) {
            KryptonLLog.m2561i(TAG, "The redirected url is a local path: ," + redirectUrl + " handle local path.");
            handleLocalPathResource(redirectUrl, loaderResolver);
            TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RESOURCE_SERVICE);
            return;
        }
        KryptonLLog.m2561i(TAG, "Load from remote by LynxResourceService with url: " + redirectUrl);
        LynxResourceServiceRequestParams lynxResourceServiceRequestParams = new LynxResourceServiceRequestParams();
        lynxResourceServiceRequestParams.setEnableMemoryCache(true);
        ILynxResourceService lynxResourceService = getLynxResourceService();
        if (lynxResourceService != null && lynxResourceService.isReady()) {
            lynxResourceService.fetchResourceAsync(redirectUrl, lynxResourceServiceRequestParams, new LynxResourceServiceCallback() { // from class: com.lynx.canvas.CanvasLoaderService.3
                public void onResponse(ILynxResourceServiceResponse iLynxResourceServiceResponse) {
                    KryptonLLog.m2561i(CanvasLoaderService.TAG, "LynxResourceService request success with url: " + redirectUrl);
                    InputStream provideInputStream = iLynxResourceServiceResponse.provideInputStream();
                    if (iLynxResourceServiceResponse.isSucceed().booleanValue() && provideInputStream != null) {
                        try {
                            KryptonLLog.m2561i(CanvasLoaderService.TAG, "Load response's stream from LynxResourceService with url: " + redirectUrl);
                            if (loaderResolver.hasStreamDelegate()) {
                                CanvasLoaderService.this.handleStreamWithDelegate(str, provideInputStream, provideInputStream.available(), loaderResolver);
                            } else {
                                CanvasLoaderService.this.HandleStreamWithResolver(str, provideInputStream, provideInputStream.available(), loaderResolver);
                            }
                            return;
                        } catch (Exception e) {
                            String str2 = "load from remote exception: " + e.toString() + " url: " + redirectUrl;
                            KryptonLLog.m2560e(CanvasLoaderService.TAG, str2);
                            loaderResolver.reject(str2);
                            return;
                        }
                    }
                    String str3 = "request by LynxResourceService failed. " + iLynxResourceServiceResponse.getErrorInfoString() + " url: " + redirectUrl;
                    KryptonLLog.m2560e(CanvasLoaderService.TAG, str3);
                    loaderResolver.reject(str3);
                }
            });
        } else {
            KryptonLLog.m2560e(TAG, "No LynxResourceService existed, LynxResourceService request failed with url: " + redirectUrl);
            loaderResolver.reject("No LynxResourceService existed");
        }
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_RESOURCE_SERVICE);
    }

    private ILynxResourceService getLynxResourceService() {
        if (this.mLynxResourceService == null) {
            this.mLynxResourceService = LynxServiceCenter.inst().getService(ILynxResourceService.class);
        }
        return this.mLynxResourceService;
    }

    private ILynxImageService getLynxImageService() {
        if (this.mLynxImageService == null) {
            this.mLynxImageService = LynxServiceCenter.inst().getService(ILynxImageService.class);
        }
        return this.mLynxImageService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStreamWithDelegate(String str, InputStream inputStream, int i, LoaderResolver loaderResolver) {
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_HANDLE_STREAM_WITH_DELEGATE, hashMap);
        }
        try {
            loaderResolver.streamDelegate.onStart(i);
            byte[] bArr = new byte[KryptonResourceUtils.getPreferredBufferSize(i)];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (read > 0) {
                    loaderResolver.streamDelegate.onData(bArr, 0, read);
                }
            }
            loaderResolver.streamDelegate.onEnd();
            inputStream.close();
        } catch (IOException unused) {
            loaderResolver.streamDelegate.onError("Read stream error");
        }
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_HANDLE_STREAM_WITH_DELEGATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HandleStreamWithResolver(String str, InputStream inputStream, int i, LoaderResolver loaderResolver) {
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_HANDLE_STREAM_WITH_RESOLVER, hashMap);
        }
        byte[] byteArrayFromInputStream = KryptonResourceUtils.getByteArrayFromInputStream(inputStream, i);
        if (byteArrayFromInputStream != null) {
            KryptonLLog.m2561i(TAG, "Load from stream success with content length: " + byteArrayFromInputStream.length + " from url: " + str);
            loaderResolver.resolve(byteArrayFromInputStream, 0, i);
        } else {
            KryptonLLog.m2560e(TAG, "Load stream failed from url: " + str);
            loaderResolver.reject("Load stream failed from url!");
        }
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_HANDLE_STREAM_WITH_RESOLVER);
    }

    private void handleImageWithLynxImageService(final String str, final KryptonLoaderService.ImageResolver imageResolver) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new Runnable() { // from class: com.lynx.canvas.CanvasLoaderService.4
            @Override // java.lang.Runnable
            public void run() {
                String redirectUrl = CanvasLoaderService.this.redirectUrl(str);
                KryptonLLog.m2561i(CanvasLoaderService.TAG, "Load Image with LynxImageService, url is: " + KryptonResourceUtils.getTruncatePath(redirectUrl));
                CanvasLoaderService.this.loadImageWithLynxImageServiceImpl(redirectUrl, imageResolver);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImageWithLynxImageServiceImpl(String str, final KryptonLoaderService.ImageResolver imageResolver) {
        final String truncatePath = KryptonResourceUtils.getTruncatePath(str);
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", truncatePath);
            TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_IMAGE_SERVICE, hashMap);
        }
        ILynxImageService lynxImageService = getLynxImageService();
        if (lynxImageService != null) {
            lynxImageService.decodeImage(ImageRequestInfoBuilder.newBuilderWithSource(str).setBitmapConfig(Bitmap.Config.ARGB_8888).setForceStaticImage(true).setEnablePremultiplied(false).build(), new ImageLoadListener() { // from class: com.lynx.canvas.CanvasLoaderService.5
                public void onImageMonitorInfo(JSONObject jSONObject) {
                }

                public void onRequestSubmit(ImageRequestInfo imageRequestInfo) {
                }

                public void onSuccess(ImageContent imageContent, ImageRequestInfo imageRequestInfo, ImageInfo imageInfo) {
                    KryptonLLog.m2561i(CanvasLoaderService.TAG, "load image success callback triggered with url: " + truncatePath);
                    Bitmap bitmap = imageContent != null ? imageContent.getBitmap() : null;
                    if (bitmap != null) {
                        int width = bitmap.getWidth() * 4 * bitmap.getHeight();
                        if (width != bitmap.getByteCount()) {
                            KryptonLLog.m2560e(CanvasLoaderService.TAG, "The expected size of image is not correct, need convert the bitmap to RGBA8888, the url is : " + truncatePath);
                            boolean z = false;
                            Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
                            if (copy != null && width == copy.getByteCount()) {
                                z = true;
                            }
                            if (copy != null) {
                                if (z) {
                                    KryptonLLog.m2561i(CanvasLoaderService.TAG, "load image success after converted to RGBA888 with url: " + truncatePath);
                                    imageResolver.resolve(copy);
                                }
                                copy.recycle();
                            }
                            if (z) {
                                return;
                            }
                            imageResolver.reject("Decode type of bitmap may not correct !!!, the url is: " + truncatePath);
                            return;
                        }
                        KryptonLLog.m2561i(CanvasLoaderService.TAG, "load image success with url: " + truncatePath);
                        imageResolver.resolve(bitmap);
                        return;
                    }
                    KryptonLLog.m2560e(CanvasLoaderService.TAG, "load null image with url: " + truncatePath);
                    imageResolver.reject("Empty bitmap !!!");
                }

                public void onFailure(int i, Throwable th) {
                    String message = th.getMessage();
                    KryptonLLog.m2560e(CanvasLoaderService.TAG, "load image failed with url: " + truncatePath + " error message: " + message);
                    imageResolver.reject(message);
                }
            });
        } else {
            String str2 = "load image failed with because LynxImageService is not existed, the url is :" + truncatePath;
            KryptonLLog.m2560e(TAG, str2);
            imageResolver.reject(str2);
        }
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_IMAGE_SERVICE);
    }

    private void handleImageWithoutLynxImageService(String str, KryptonLoaderService.ImageResolver imageResolver, boolean z) {
        if (KryptonResourceUtils.isDataURI(str)) {
            KryptonLLog.m2561i(TAG, "Handle base64 type image with url: " + KryptonResourceUtils.getTruncatePath(str));
            if (!z) {
                handleBase64ImageAsync(str, imageResolver);
                return;
            } else {
                handleBase64Image(str, imageResolver);
                return;
            }
        }
        loadImageRawDataAndDecodeWithBitmapFactory(str, imageResolver, z);
    }

    private void handleBase64ImageAsync(final String str, final KryptonLoaderService.ImageResolver imageResolver) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new Runnable() { // from class: com.lynx.canvas.CanvasLoaderService.6
            @Override // java.lang.Runnable
            public void run() {
                CanvasLoaderService.this.handleBase64Image(str, imageResolver);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBase64Image(String str, KryptonLoaderService.ImageResolver imageResolver) {
        String truncatePath = KryptonResourceUtils.getTruncatePath(str);
        try {
            Bitmap decodeBase64Image = KryptonResourceUtils.decodeBase64Image(str);
            if (decodeBase64Image != null) {
                KryptonLLog.m2561i(TAG, "Decode base64 image success with image: " + truncatePath);
                imageResolver.resolve(decodeBase64Image);
            } else {
                String str2 = "Empty base64 image: " + truncatePath;
                KryptonLLog.m2561i(TAG, str2);
                imageResolver.reject(str2);
            }
        } catch (Exception e) {
            imageResolver.reject("Decode base64 image: " + truncatePath + " with error: " + e.getMessage());
        }
    }

    private void loadImageRawDataAndDecodeWithBitmapFactory(final String str, final KryptonLoaderService.ImageResolver imageResolver, boolean z) {
        KryptonLoaderService.DataResolver dataResolver = new KryptonLoaderService.DataResolver() { // from class: com.lynx.canvas.CanvasLoaderService.7
            @Override // com.lynx.canvas.KryptonLoaderService.DataResolver
            public void resolve(byte[] bArr, int i, int i2) {
                if (KryptonResourceUtils.isHeif(bArr)) {
                    String str2 = "Cannot handle heif file type image, the url is: " + str;
                    KryptonLLog.m2560e(CanvasLoaderService.TAG, str2);
                    imageResolver.reject(str2);
                    return;
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2);
                if (decodeByteArray != null) {
                    KryptonLLog.m2561i(CanvasLoaderService.TAG, "Load image raw data and decode it with BitmapFactory success: " + str);
                    imageResolver.resolve(decodeByteArray);
                } else {
                    String str3 = "Load image success but decode bitmap with BitmapFactory failed: " + str;
                    KryptonLLog.m2560e(CanvasLoaderService.TAG, str3);
                    imageResolver.reject(str3);
                }
            }

            @Override // com.lynx.canvas.KryptonLoaderService.DataResolver
            public void reject(String str2) {
                KryptonLLog.m2560e(CanvasLoaderService.TAG, "Load image data failed with url: " + str + " ,the error message: " + str2);
                imageResolver.reject(str2);
            }
        };
        KryptonLLog.m2561i(TAG, "Load raw data of image and decode it with BitmapFactory, the url: " + str);
        if (z) {
            loadNormalDataWithProperDownloader(str, new LoaderResolver(dataResolver, null));
        } else {
            loadNormalDataWithProperDownloaderAsync(str, new LoaderResolver(dataResolver, null));
        }
    }

    private void loadResWithDataUrl(final String str, final LoaderResolver loaderResolver) {
        final String truncatePath = KryptonResourceUtils.getTruncatePath(str);
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", truncatePath);
            TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_DATA_URI, hashMap);
        }
        KryptonResourceUtils.getKryptonIOExecutor().execute(new Runnable() { // from class: com.lynx.canvas.CanvasLoaderService.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    KryptonLLog.m2561i(CanvasLoaderService.TAG, "Load resource start decode the data url, the url: " + truncatePath);
                    byte[] decodeDataURI = KryptonResourceUtils.decodeDataURI(str);
                    if (decodeDataURI != null) {
                        KryptonLLog.m2561i(CanvasLoaderService.TAG, "Load resource with data url success, the url: " + truncatePath);
                        loaderResolver.resolve(decodeDataURI, 0, decodeDataURI.length);
                    } else {
                        KryptonLLog.m2560e(CanvasLoaderService.TAG, "Load resource with data url failed, the url: " + truncatePath);
                        loaderResolver.reject("Decoder return null data with url: " + truncatePath);
                    }
                } catch (IllegalArgumentException e) {
                    KryptonLLog.m2560e(CanvasLoaderService.TAG, "Load resource with data url with exception, the url: " + truncatePath);
                    loaderResolver.reject(e.toString());
                }
            }
        });
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_DATA_URI);
    }

    private String getCompatiblePath(String str) {
        if (str.startsWith(ASSETS_PREFIX)) {
            return str.replace(ASSETS_PREFIX, ASSET_PREFIX);
        }
        return str.startsWith(ASSETS2_PREFIX) ? str.replace(ASSETS2_PREFIX, ASSET_PREFIX) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTotalLengthForLynxResResponse(LynxResResponse lynxResResponse) {
        InputStream inputStream = lynxResResponse.getInputStream();
        int i = 0;
        if (inputStream == null) {
            return 0;
        }
        try {
            i = inputStream.available();
        } catch (IOException unused) {
        }
        int lynxResponseContentLength = getLynxResponseContentLength(lynxResResponse);
        if (i > 0) {
            return i;
        }
        KryptonLLog.m2561i(TAG, "no length from stream, responseContentLength = " + lynxResponseContentLength);
        return lynxResponseContentLength > 0 ? lynxResponseContentLength : i;
    }

    private int getLynxResponseContentLength(LynxResResponse lynxResResponse) {
        List list;
        Map responseHeaders = lynxResResponse.getResponseHeaders();
        if (responseHeaders == null || (list = (List) responseHeaders.get("content-length")) == null || list.isEmpty()) {
            return 0;
        }
        return Integer.parseInt((String) list.get(0));
    }

    private void handleLocalPathResource(String str, LoaderResolver loaderResolver) {
        KryptonLLog.m2561i(TAG, "Handle local path resource: " + str);
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("path", str);
            TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_LOCAL_PATH_RESOURCE, hashMap);
        }
        InputStream loadResourceFromLocalPath = KryptonResourceUtils.loadResourceFromLocalPath(str);
        if (loadResourceFromLocalPath != null) {
            KryptonLLog.m2561i(TAG, "Handle local path resource success, the resource path : " + str);
            try {
                if (loaderResolver.hasStreamDelegate()) {
                    handleStreamWithDelegate(str, loadResourceFromLocalPath, loadResourceFromLocalPath.available(), loaderResolver);
                } else {
                    HandleStreamWithResolver(str, loadResourceFromLocalPath, loadResourceFromLocalPath.available(), loaderResolver);
                }
            } catch (Exception e) {
                String str2 = "Handle local path resource with exception: " + e.toString() + " url: " + str;
                KryptonLLog.m2560e(TAG, str2);
                loaderResolver.reject(str2);
            }
        } else {
            String str3 = "Handle local path resource failed.  path: " + str;
            KryptonLLog.m2560e(TAG, str3);
            loaderResolver.reject(str3);
        }
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_LOCAL_PATH_RESOURCE);
    }
}
