package com.lynx.canvas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.lynx.canvas.KryptonLoaderService;
import com.lynx.canvas.loader.KryptonResourceUtils;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.image.ImageContent;
import com.lynx.tasm.image.model.ImageInfo;
import com.lynx.tasm.image.model.ImageLoadListener;
import com.lynx.tasm.image.model.ImageRequestInfo;
import com.lynx.tasm.image.model.ImageRequestInfoBuilder;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import com.lynx.tasm.resourceprovider.media.LynxMediaResourceFetcher;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxKryptonLoaderServiceImpl extends KryptonLoaderService {
    private static final String ASSETS2_PREFIX = "assets://";
    private static final String ASSETS_PREFIX = "assets:///";
    private static final String ASSET_PREFIX = "asset:///";
    private static final String TAG = "LynxKryptonLoaderServiceImpl";
    private final WeakReference<LynxContext> mLynxContextWeak;
    private ILynxImageService mLynxImageService;

    @Override // com.lynx.canvas.KryptonService
    public void onBootstrap(KryptonApp kryptonApp) {
    }

    @Override // com.lynx.canvas.KryptonService
    public void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxKryptonLoaderServiceImpl(WeakReference<LynxContext> weakReference) {
        this.mLynxContextWeak = weakReference;
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
        LynxMediaResourceFetcher lynxMediaResourceFetcher = getLynxMediaResourceFetcher();
        if (lynxMediaResourceFetcher != null) {
            String shouldRedirectUrl = lynxMediaResourceFetcher.shouldRedirectUrl(new LynxResourceRequest(compatiblePath, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage));
            if (shouldRedirectUrl != null) {
                KryptonLLog.m2561i(TAG, "Redirect URL with LynxMediaResourceFetcher, the original url: " + compatiblePath + " redirected url: " + shouldRedirectUrl);
                TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
                return shouldRedirectUrl;
            }
            KryptonLLog.m2560e(TAG, "Redirect URL with LynxMediaResourceFetcher return null url,  redirected url: " + shouldRedirectUrl);
            TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
            return compatiblePath;
        }
        KryptonLLog.m2560e(TAG, "Redirect URL: " + compatiblePath + " failed because there is no LynxMediaResourceFetcher existed.");
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOADER_REDIRECT_URL);
        return compatiblePath;
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithDataResolver(String str, KryptonLoaderService.DataResolver dataResolver) {
        String truncatePath = KryptonResourceUtils.getTruncatePath(str);
        if (dataResolver == null) {
            KryptonLLog.m2560e(TAG, "loadUrlWithDataResolver resolver null, the url is :" + truncatePath);
            return;
        }
        LoaderResolver loaderResolver = new LoaderResolver(dataResolver, null);
        if (KryptonResourceUtils.isDataURI(str)) {
            KryptonLLog.m2561i(TAG, "Load base64 type data url: " + truncatePath);
            loadResWithDataUrl(str, loaderResolver);
        } else {
            handleNormalDataLoader(getCompatiblePath(str), loaderResolver);
        }
    }

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithImageResolver(String str, KryptonLoaderService.ImageResolver imageResolver) {
        String compatiblePath = getCompatiblePath(str);
        if (getLynxImageService() != null) {
            handleImageWithLynxImageService(compatiblePath, imageResolver);
        } else {
            loadImageRawDataAndDecodeWithBitmapFactory(compatiblePath, imageResolver);
        }
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

    @Override // com.lynx.canvas.KryptonLoaderService
    public void loadUrlWithStreamDelegate(String str, KryptonLoaderService.StreamDelegate streamDelegate) {
        if (streamDelegate == null) {
            KryptonLLog.m2560e(TAG, "loadUrlWithStreamDelegate delegate null");
        } else {
            final LoaderResolver loaderResolver = new LoaderResolver(null, streamDelegate);
            loadUrlWithDataResolver(str, new KryptonLoaderService.DataResolver() { // from class: com.lynx.canvas.LynxKryptonLoaderServiceImpl.1
                @Override // com.lynx.canvas.KryptonLoaderService.DataResolver
                public void resolve(byte[] bArr, int i, int i2) {
                    loaderResolver.resolve(bArr, i, i2);
                }

                @Override // com.lynx.canvas.KryptonLoaderService.DataResolver
                public void reject(String str2) {
                    loaderResolver.reject(str2);
                }
            });
        }
    }

    private void loadImageRawDataAndDecodeWithBitmapFactory(final String str, final KryptonLoaderService.ImageResolver imageResolver) {
        if (KryptonResourceUtils.isDataURI(str)) {
            KryptonLLog.m2561i(TAG, "Handle base64 type image with url: " + KryptonResourceUtils.getTruncatePath(str));
            handleBase64Image(str, imageResolver);
        } else {
            KryptonLoaderService.DataResolver dataResolver = new KryptonLoaderService.DataResolver() { // from class: com.lynx.canvas.LynxKryptonLoaderServiceImpl.2
                @Override // com.lynx.canvas.KryptonLoaderService.DataResolver
                public void resolve(byte[] bArr, int i, int i2) {
                    if (KryptonResourceUtils.isHeif(bArr)) {
                        String str2 = "Cannot handle heif file type image, the url is: " + str;
                        KryptonLLog.m2560e(LynxKryptonLoaderServiceImpl.TAG, str2);
                        imageResolver.reject(str2);
                        return;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2);
                    if (decodeByteArray != null) {
                        KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "Load image raw data and decode it with BitmapFactory success: " + str);
                        imageResolver.resolve(decodeByteArray);
                    } else {
                        String str3 = "Load image success but decode bitmap with BitmapFactory failed: " + str;
                        KryptonLLog.m2560e(LynxKryptonLoaderServiceImpl.TAG, str3);
                        imageResolver.reject(str3);
                    }
                }

                @Override // com.lynx.canvas.KryptonLoaderService.DataResolver
                public void reject(String str2) {
                    KryptonLLog.m2560e(LynxKryptonLoaderServiceImpl.TAG, "Load image data failed with url: " + str + " ,the error message: " + str2);
                    imageResolver.reject(str2);
                }
            };
            KryptonLLog.m2561i(TAG, "Load raw data of image and decode it with BitmapFactory, the url: " + str);
            handleNormalDataLoader(str, new LoaderResolver(dataResolver, null));
        }
    }

    private void handleBase64Image(final String str, final KryptonLoaderService.ImageResolver imageResolver) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new Runnable() { // from class: com.lynx.canvas.LynxKryptonLoaderServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                String truncatePath = KryptonResourceUtils.getTruncatePath(str);
                try {
                    Bitmap decodeBase64Image = KryptonResourceUtils.decodeBase64Image(str);
                    if (decodeBase64Image != null) {
                        KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "Decode base64 image success with image: " + truncatePath);
                        imageResolver.resolve(decodeBase64Image);
                    } else {
                        String str2 = "Empty base64 image: " + truncatePath;
                        KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, str2);
                        imageResolver.reject(str2);
                    }
                } catch (Exception e) {
                    imageResolver.reject("Decode base64 image: " + truncatePath + " with error: " + e.getMessage());
                }
            }
        });
    }

    private ILynxImageService getLynxImageService() {
        if (this.mLynxImageService == null) {
            this.mLynxImageService = LynxServiceCenter.inst().getService(ILynxImageService.class);
        }
        return this.mLynxImageService;
    }

    private LynxGenericResourceFetcher getLynxGenericResourceFetcher() {
        LynxContext lynxContext = this.mLynxContextWeak.get();
        if (lynxContext != null) {
            return lynxContext.getGenericResourceFetcher();
        }
        return null;
    }

    private LynxMediaResourceFetcher getLynxMediaResourceFetcher() {
        LynxContext lynxContext = this.mLynxContextWeak.get();
        if (lynxContext != null) {
            return lynxContext.getMediaResourceFetcher();
        }
        return null;
    }

    private String getCompatiblePath(String str) {
        if (str.startsWith(ASSETS_PREFIX)) {
            return str.replace(ASSETS_PREFIX, ASSET_PREFIX);
        }
        return str.startsWith(ASSETS2_PREFIX) ? str.replace(ASSETS2_PREFIX, ASSET_PREFIX) : str;
    }

    private void loadResWithDataUrl(final String str, final LoaderResolver loaderResolver) {
        final String truncatePath = KryptonResourceUtils.getTruncatePath(str);
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", truncatePath);
            TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_DATA_URI, hashMap);
        }
        KryptonResourceUtils.getKryptonIOExecutor().execute(new Runnable() { // from class: com.lynx.canvas.LynxKryptonLoaderServiceImpl.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "Load resource start decode the data url, the url: " + truncatePath);
                    byte[] decodeDataURI = KryptonResourceUtils.decodeDataURI(str);
                    if (decodeDataURI != null) {
                        KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "Load resource with data url success, the url: " + truncatePath);
                        loaderResolver.resolve(decodeDataURI, 0, decodeDataURI.length);
                    } else {
                        KryptonLLog.m2560e(LynxKryptonLoaderServiceImpl.TAG, "Load resource with data url failed, the url: " + truncatePath);
                        loaderResolver.reject("Decoder return null data with url: " + truncatePath);
                    }
                } catch (IllegalArgumentException e) {
                    KryptonLLog.m2560e(LynxKryptonLoaderServiceImpl.TAG, "Load resource with data url with exception, the url: " + truncatePath);
                    loaderResolver.reject(e.toString());
                }
            }
        });
        TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_DATA_URI);
    }

    private void handleNormalDataLoader(final String str, final LoaderResolver loaderResolver) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new Runnable() { // from class: com.lynx.canvas.LynxKryptonLoaderServiceImpl.5
            @Override // java.lang.Runnable
            public void run() {
                if (TraceEvent.isTracingStarted()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", str);
                    TraceEvent.beginSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_GENERIC_FETCHER, hashMap);
                }
                KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "Load url : " + str + " with LynxGenericFetcher.");
                if (!KryptonResourceUtils.isLocalPath(str)) {
                    LynxKryptonLoaderServiceImpl.this.loadWitLynxGenericFetcher(str, loaderResolver);
                    TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_GENERIC_FETCHER);
                } else {
                    KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "The request url is a local path: ," + str + " handle local path.");
                    LynxKryptonLoaderServiceImpl.this.handleLocalPathResource(str, loaderResolver);
                    TraceEvent.endSection(LynxKryptonTraceEventDef.LYNX_KRYPTON_LOAD_WITH_GENERIC_FETCHER);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLocalPathResource(String str, LoaderResolver loaderResolver) {
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

    private void handleStreamWithDelegate(String str, InputStream inputStream, int i, LoaderResolver loaderResolver) {
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

    private void HandleStreamWithResolver(String str, InputStream inputStream, int i, LoaderResolver loaderResolver) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void loadWitLynxGenericFetcher(final String str, final LoaderResolver loaderResolver) {
        KryptonLLog.m2561i(TAG, "Load remote resource with LynxGenericFetcher, url: " + str);
        LynxGenericResourceFetcher lynxGenericResourceFetcher = getLynxGenericResourceFetcher();
        if (lynxGenericResourceFetcher != null) {
            lynxGenericResourceFetcher.fetchResource(new LynxResourceRequest(str, LynxResourceRequest.LynxResourceType.LynxResourceTypeGeneric), new LynxResourceCallback<byte[]>() { // from class: com.lynx.canvas.LynxKryptonLoaderServiceImpl.6
                public void onResponse(LynxResourceResponse<byte[]> lynxResourceResponse) {
                    if (lynxResourceResponse.getState() == LynxResourceResponse.ResponseState.SUCCESS) {
                        KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "Load with LynxGenericFetcher success with the url is: " + str);
                        byte[] bArr = (byte[]) lynxResourceResponse.getData();
                        loaderResolver.resolve(bArr, 0, bArr.length);
                    } else {
                        Throwable error = lynxResourceResponse.getError();
                        String message = error != null ? error.getMessage() : "";
                        KryptonLLog.m2560e(LynxKryptonLoaderServiceImpl.TAG, "Load with LynxGenericFetcher error: " + message + " ,the url of resource is: " + str);
                        loaderResolver.reject(message);
                    }
                }
            });
        } else {
            loaderResolver.reject("No LynxGenericResourceFetcher existed. Load failed with url: " + str);
        }
    }

    private void handleImageWithLynxImageService(final String str, final KryptonLoaderService.ImageResolver imageResolver) {
        KryptonResourceUtils.getKryptonIOExecutor().execute(new Runnable() { // from class: com.lynx.canvas.LynxKryptonLoaderServiceImpl.7
            @Override // java.lang.Runnable
            public void run() {
                String redirectUrl = LynxKryptonLoaderServiceImpl.this.redirectUrl(str);
                KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "Load Image with LynxImageService, url is: " + KryptonResourceUtils.getTruncatePath(redirectUrl));
                LynxKryptonLoaderServiceImpl.this.loadImageWithLynxImageServiceImpl(redirectUrl, imageResolver);
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
            lynxImageService.decodeImage(ImageRequestInfoBuilder.newBuilderWithSource(str).setBitmapConfig(Bitmap.Config.ARGB_8888).setForceStaticImage(true).setEnablePremultiplied(false).build(), new ImageLoadListener() { // from class: com.lynx.canvas.LynxKryptonLoaderServiceImpl.8
                public void onImageMonitorInfo(JSONObject jSONObject) {
                }

                public void onRequestSubmit(ImageRequestInfo imageRequestInfo) {
                }

                public void onSuccess(ImageContent imageContent, ImageRequestInfo imageRequestInfo, ImageInfo imageInfo) {
                    KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "load image success callback triggered with url: " + truncatePath);
                    Bitmap bitmap = imageContent != null ? imageContent.getBitmap() : null;
                    if (bitmap != null) {
                        int width = bitmap.getWidth() * 4 * bitmap.getHeight();
                        if (width != bitmap.getByteCount()) {
                            KryptonLLog.m2560e(LynxKryptonLoaderServiceImpl.TAG, "The expected size of image is not correct, need convert the bitmap to RGBA8888, the url is : " + truncatePath);
                            boolean z = false;
                            Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
                            if (copy != null && width == copy.getByteCount()) {
                                z = true;
                            }
                            if (copy != null) {
                                if (z) {
                                    KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "load image success after converted to RGBA888 with url: " + truncatePath);
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
                        KryptonLLog.m2561i(LynxKryptonLoaderServiceImpl.TAG, "load image success with url: " + truncatePath);
                        imageResolver.resolve(bitmap);
                        return;
                    }
                    KryptonLLog.m2560e(LynxKryptonLoaderServiceImpl.TAG, "load null image with url: " + truncatePath);
                    imageResolver.reject("Empty bitmap !!!");
                }

                public void onFailure(int i, Throwable th) {
                    String message = th.getMessage();
                    KryptonLLog.m2560e(LynxKryptonLoaderServiceImpl.TAG, "load image failed with url: " + truncatePath + " error message: " + message);
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
}
