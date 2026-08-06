package com.bytedance.lottie.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.bytedance.lottie.ImageAssetDelegate;
import com.bytedance.lottie.LottieImageAsset;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class ImageAssetManager {
    private static final int ACTION_CLEAR = 1;
    private static final Object bitmapHashLock = new Object();
    private final Set<String> blockCacheImages = new HashSet();
    private final Context context;
    private ImageAssetDelegate delegate;
    private final Map<String, LottieImageAsset> imageAssets;
    private String imagesFolder;
    private Handler mHandler;

    /* loaded from: classes4.dex */
    private static class MyHandler extends Handler {
        private WeakReference<ImageAssetManager> mManagerRef;

        MyHandler(ImageAssetManager imageAssetManager, Looper looper) {
            super(looper);
            this.mManagerRef = new WeakReference<>(imageAssetManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ImageAssetManager imageAssetManager;
            super.handleMessage(message);
            if (message.what != 1 || (imageAssetManager = this.mManagerRef.get()) == null) {
                return;
            }
            imageAssetManager.recycleBitmaps();
        }
    }

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        this.imagesFolder = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.imagesFolder.charAt(r4.length() - 1) != '/') {
                this.imagesFolder += '/';
            }
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.imageAssets = new HashMap();
            this.context = null;
        } else {
            this.context = ((View) callback).getContext();
            this.imageAssets = map;
            setDelegate(imageAssetDelegate);
            this.mHandler = new MyHandler(this, Looper.getMainLooper());
        }
    }

    public void setBlockCacheImage(Set<String> set) {
        this.blockCacheImages.clear();
        if (set != null) {
            this.blockCacheImages.addAll(set);
        }
    }

    public void setDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.delegate = imageAssetDelegate;
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        if (bitmap == null) {
            LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
            Bitmap bitmap2 = lottieImageAsset.getBitmap();
            lottieImageAsset.setBitmap(null);
            return bitmap2;
        }
        return putBitmap(str, bitmap);
    }

    public Bitmap bitmapForId(String str) {
        LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap bitmap = lottieImageAsset.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        ImageAssetDelegate imageAssetDelegate = this.delegate;
        if (imageAssetDelegate != null) {
            Bitmap fetchBitmap = imageAssetDelegate.fetchBitmap(lottieImageAsset);
            if (fetchBitmap != null) {
                putBitmap(str, fetchBitmap);
            }
            return fetchBitmap;
        }
        String fileName = lottieImageAsset.getFileName();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                return putBitmap(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.imagesFolder)) {
                Log.e("LOTTIE", "You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder. Id: " + str);
                return null;
            }
            return putBitmap(str, BitmapFactory.decodeStream(this.context.getAssets().open(this.imagesFolder + fileName), null, options));
        } catch (IOException e2) {
            Log.w("LOTTIE", "Unable to open asset.", e2);
            return null;
        }
    }

    public void recycleBitmaps() {
        this.mHandler.removeMessages(1);
        synchronized (bitmapHashLock) {
            Iterator<Map.Entry<String, LottieImageAsset>> it = this.imageAssets.entrySet().iterator();
            while (it.hasNext()) {
                LottieImageAsset value = it.next().getValue();
                Bitmap bitmap = value.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    value.setBitmap(null);
                }
            }
            ImageAssetDelegate imageAssetDelegate = this.delegate;
            if (imageAssetDelegate != null) {
                imageAssetDelegate.onBitmapExpired();
            }
        }
    }

    public boolean hasSameContext(Context context) {
        return (context == null && this.context == null) || this.context.equals(context);
    }

    private Bitmap putBitmap(String str, Bitmap bitmap) {
        synchronized (bitmapHashLock) {
            if (!this.blockCacheImages.contains(str)) {
                this.imageAssets.get(str).setBitmap(bitmap);
            }
        }
        return bitmap;
    }
}
