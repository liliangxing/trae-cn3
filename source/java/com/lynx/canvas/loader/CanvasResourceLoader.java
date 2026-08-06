package com.lynx.canvas.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonLoaderService;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CanvasResourceLoader {
    private static final String TAG = "KryptonCanvasResourceLoader";
    WeakReference<KryptonApp> mWeakKryptonApp;

    public CanvasResourceLoader(KryptonApp kryptonApp) {
        this.mWeakKryptonApp = new WeakReference<>(kryptonApp);
    }

    public void loadImage(String str, long j) {
        final CanvasResourceResolver canvasResourceResolver = new CanvasResourceResolver(j, str);
        if (str == null) {
            rejectWithErrorMessage("url empty", canvasResourceResolver, false);
            return;
        }
        KryptonLoaderService loaderService = getLoaderService();
        if (loaderService == null) {
            rejectWithErrorMessage("loaderService not found", canvasResourceResolver, false);
        } else {
            loaderService.loadUrlWithImageResolver(str, new KryptonLoaderService.ImageResolver() { // from class: com.lynx.canvas.loader.CanvasResourceLoader.1
                @Override // com.lynx.canvas.KryptonLoaderService.ImageResolver
                public void resolve(Bitmap bitmap) {
                    canvasResourceResolver.resolve(bitmap);
                }

                @Override // com.lynx.canvas.KryptonLoaderService.ImageResolver
                public void reject(String str2) {
                    CanvasResourceLoader.this.rejectWithErrorMessage(str2, canvasResourceResolver, false);
                }
            });
        }
    }

    public void loadImageWithOptions(String str, boolean z, boolean z2, long j) {
        final CanvasResourceResolver canvasResourceResolver = new CanvasResourceResolver(j, str);
        if (str == null || str.isEmpty()) {
            rejectWithErrorMessage("url empty", canvasResourceResolver, false);
            return;
        }
        KryptonLoaderService loaderService = getLoaderService();
        if (loaderService == null) {
            rejectWithErrorMessage("loaderService not found", canvasResourceResolver, false);
            return;
        }
        KryptonLoaderService.ImageResolver imageResolver = new KryptonLoaderService.ImageResolver() { // from class: com.lynx.canvas.loader.CanvasResourceLoader.2
            @Override // com.lynx.canvas.KryptonLoaderService.ImageResolver
            public void resolve(Bitmap bitmap) {
                canvasResourceResolver.resolve(bitmap);
            }

            @Override // com.lynx.canvas.KryptonLoaderService.ImageResolver
            public void reject(String str2) {
                CanvasResourceLoader.this.rejectWithErrorMessage(str2, canvasResourceResolver, false);
            }
        };
        KryptonLoaderService.ImageLoadOptions imageLoadOptions = new KryptonLoaderService.ImageLoadOptions(z, z2);
        try {
            KryptonLLog.m2561i(TAG, "loadImageWithOptions " + str + " " + imageLoadOptions);
            loaderService.loadImageWithOptions(str, imageLoadOptions, imageResolver);
        } catch (UnsupportedOperationException unused) {
            KryptonLLog.m2560e(TAG, "loadImageWithOptions not supported, fallback to loadUrlWithImageResolver " + str);
            loaderService.loadUrlWithImageResolver(str, imageResolver);
        }
    }

    public Bitmap loadImageSync(String str) {
        if (str == null) {
            KryptonLLog.m2560e(TAG, "url empty");
            return null;
        }
        KryptonLoaderService loaderService = getLoaderService();
        if (loaderService == null) {
            KryptonLLog.m2560e(TAG, "loaderService not found");
            return null;
        }
        byte[] loadUrlSync = loaderService.loadUrlSync(str);
        if (loadUrlSync == null) {
            KryptonLLog.m2560e(TAG, "loadUrlSync return null");
            return null;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(loadUrlSync, 0, loadUrlSync.length);
        if (decodeByteArray != null) {
            return decodeByteArray;
        }
        KryptonLLog.m2560e(TAG, "loadImageSync failed, bitmap = null ");
        return null;
    }

    public Bitmap decodeDataURLSync(String str) {
        Bitmap bitmap;
        if (!str.startsWith("data:") || str.indexOf("base64,") == -1) {
            KryptonLLog.m2560e(TAG, "decode DataURL failed, not data url");
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.substring(str.indexOf("base64,") + 7), 0);
            bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            KryptonLLog.m2560e(TAG, "decode data url failed, throw exception " + e);
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        KryptonLLog.m2560e(TAG, "decode data url failed, bitmap = null ");
        return null;
    }

    public void loadAssets(String str, long j, final boolean z) {
        final CanvasResourceResolver canvasResourceResolver = new CanvasResourceResolver(j, str);
        if (str == null) {
            KryptonLLog.m2560e(TAG, "Url is required!");
            rejectWithErrorMessage("url empty", canvasResourceResolver, z);
            return;
        }
        KryptonLoaderService loaderService = getLoaderService();
        if (loaderService == null) {
            KryptonLLog.m2560e(TAG, "Loader service not founded!");
            rejectWithErrorMessage("loaderService not found", canvasResourceResolver, z);
            return;
        }
        if (z) {
            try {
                KryptonLLog.m2561i(TAG, "Load stream assets.");
                streamLoadAssets(str, canvasResourceResolver, loaderService);
                return;
            } catch (UnsupportedOperationException unused) {
                KryptonLLog.m2561i(TAG, "do not support stream load");
            }
        }
        loaderService.loadUrlWithDataResolver(str, new KryptonLoaderService.DataResolver() { // from class: com.lynx.canvas.loader.CanvasResourceLoader.3
            @Override // com.lynx.canvas.KryptonLoaderService.DataResolver
            public void resolve(byte[] bArr, int i, int i2) {
                KryptonLLog.m2561i(CanvasResourceLoader.TAG, "Resolver resolve with current status: " + canvasResourceResolver.getStatus().toString());
                if (z) {
                    canvasResourceResolver.resolveStreamLoadStart(i2);
                    canvasResourceResolver.resolveStreamLoadData(bArr, i, i2);
                    canvasResourceResolver.resolveStreamLoadEnd(true, null);
                    return;
                }
                canvasResourceResolver.resolve(bArr, i, i2);
            }

            @Override // com.lynx.canvas.KryptonLoaderService.DataResolver
            public void reject(String str2) {
                KryptonLLog.m2561i(CanvasResourceLoader.TAG, "Resolver reject with current status: " + canvasResourceResolver.getStatus().toString());
                CanvasResourceLoader.this.rejectWithErrorMessage(str2, canvasResourceResolver, z);
            }
        });
    }

    public byte[] encodeBitmap(ByteBuffer byteBuffer, int i, int i2, int i3, float f) {
        Bitmap.CompressFormat compressFormat;
        if (i != 0) {
            if (i == 1) {
                compressFormat = Bitmap.CompressFormat.JPEG;
            }
            return null;
        }
        compressFormat = Bitmap.CompressFormat.PNG;
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((i2 * i3) / 4) + 256);
        if (createBitmap.compress(compressFormat, Math.round(f * 100.0f), byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public String redirectUrl(String str) {
        String redirectUrl;
        if (str == null) {
            return null;
        }
        KryptonLoaderService loaderService = getLoaderService();
        return (loaderService == null || (redirectUrl = loaderService.redirectUrl(str)) == null) ? str : redirectUrl;
    }

    private KryptonLoaderService getLoaderService() {
        KryptonApp kryptonApp = this.mWeakKryptonApp.get();
        if (kryptonApp != null) {
            return (KryptonLoaderService) kryptonApp.getService(KryptonLoaderService.class);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rejectWithErrorMessage(String str, CanvasResourceResolver canvasResourceResolver, boolean z) {
        KryptonLLog.m2560e(TAG, str);
        if (z) {
            canvasResourceResolver.resolveStreamLoadEnd(false, str);
        } else {
            canvasResourceResolver.reject(str);
        }
    }

    private void streamLoadAssets(String str, final CanvasResourceResolver canvasResourceResolver, KryptonLoaderService kryptonLoaderService) {
        kryptonLoaderService.loadUrlWithStreamDelegate(str, new KryptonLoaderService.StreamDelegate() { // from class: com.lynx.canvas.loader.CanvasResourceLoader.4
            @Override // com.lynx.canvas.KryptonLoaderService.StreamDelegate
            public void onStart(int i) {
                canvasResourceResolver.resolveStreamLoadStart(i);
            }

            @Override // com.lynx.canvas.KryptonLoaderService.StreamDelegate
            public void onData(byte[] bArr, int i, int i2) {
                canvasResourceResolver.resolveStreamLoadData(bArr, i, i2);
            }

            @Override // com.lynx.canvas.KryptonLoaderService.StreamDelegate
            public void onEnd() {
                canvasResourceResolver.resolveStreamLoadEnd(true, null);
            }

            @Override // com.lynx.canvas.KryptonLoaderService.StreamDelegate
            public void onError(String str2) {
                canvasResourceResolver.resolveStreamLoadEnd(false, str2);
            }
        });
    }
}
