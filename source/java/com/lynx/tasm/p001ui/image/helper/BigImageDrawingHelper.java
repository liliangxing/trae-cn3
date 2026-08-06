package com.lynx.tasm.p001ui.image.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.p001ui.image.ImageRequestJobScheduler;
import com.lynx.tasm.p001ui.image.fresco.BaseRoundedCornerPostprocessor;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BigImageDrawingHelper {
    private static final String TAG = "LynxImageHelper";
    private ImageLoaderCallback mCallback;
    private int mDisplayCnt;
    private boolean mIsNoSubSampleMode = false;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private Tile mTile;
    private static int maxTileWidth = Math.min(3379, 3379);
    private static int maxTileHeight = Math.min(3379, 3379);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ImageLoaderCallback {
        void onImageLoadFailed(String str);

        void onImageLoadSuccess(Tile tile);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ImageBaseData {
        private String mCapInsets;
        private String mCapInsetsScale;
        public int mCnt;
        public float mHeight;
        Point mMax;
        public boolean mRepeat;
        public ScalingUtils.ScaleType mType;
        String mUrl;
        public float mWidth;

        public ImageBaseData(int i, float f, float f2, boolean z, ScalingUtils.ScaleType scaleType, String str, Point point, String str2, String str3) {
            this.mCnt = i;
            this.mWidth = f;
            this.mHeight = f2;
            this.mRepeat = z;
            this.mType = scaleType;
            this.mUrl = str;
            this.mMax = new Point(point.x, point.y);
            this.mCapInsets = str2;
            this.mCapInsetsScale = str3;
        }

        public static ImageBaseData clone(ImageBaseData imageBaseData) {
            if (imageBaseData == null) {
                return null;
            }
            return new ImageBaseData(imageBaseData.mCnt, imageBaseData.mWidth, imageBaseData.mHeight, imageBaseData.mRepeat, imageBaseData.mType, TextUtils.isEmpty(imageBaseData.mUrl) ? null : String.copyValueOf(imageBaseData.mUrl.toCharArray()), imageBaseData.mMax, imageBaseData.mCapInsets, imageBaseData.mCapInsetsScale);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Tile {
        public ImageBaseData mData;
        public int mSampleSize = 1;
        public Rect mSourceRect = null;
        public Rect mTargetRect = null;
        public Bitmap mMap = null;
        public boolean mIsLoadFromMemory = true;
        public CloseableReference<CloseableImage> mRef = null;

        public Tile(ImageBaseData imageBaseData) {
            this.mData = imageBaseData;
        }

        public void destroy() {
            Bitmap bitmap = this.mMap;
            if (bitmap != null && !bitmap.isRecycled() && !this.mIsLoadFromMemory) {
                this.mMap.recycle();
                this.mMap = null;
            }
            CloseableReference<CloseableImage> closeableReference = this.mRef;
            if (closeableReference != null) {
                closeableReference.close();
            }
        }
    }

    public BigImageDrawingHelper(ImageLoaderCallback imageLoaderCallback, int i) {
        this.mCallback = imageLoaderCallback;
        this.mDisplayCnt = i;
    }

    public static Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), maxTileHeight));
    }

    public void setCnt(int i) {
        this.mDisplayCnt = i;
        destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveTile(final Tile tile) {
        this.mMainHandler.post(new Runnable() { // from class: com.lynx.tasm.ui.image.helper.BigImageDrawingHelper.1
            @Override // java.lang.Runnable
            public void run() {
                BigImageDrawingHelper.this.saveTileSync(tile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveTileSync(Tile tile) {
        if (tile == null || tile.mMap == null || tile.mMap.isRecycled()) {
            return;
        }
        if (tile.mData.mCnt != this.mDisplayCnt) {
            tile.destroy();
            return;
        }
        Tile tile2 = this.mTile;
        if (tile2 == null || tile2.mMap == null || (this.mTile.mMap.getWidth() < tile.mMap.getWidth() && this.mTile.mMap.getHeight() < tile.mMap.getHeight())) {
            destroy();
            this.mTile = tile;
            ImageLoaderCallback imageLoaderCallback = this.mCallback;
            if (imageLoaderCallback != null) {
                imageLoaderCallback.onImageLoadSuccess(tile);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Tile getTile(ImageBaseData imageBaseData, float f, float f2) {
        if (f == 0.0f || f2 == 0.0f || imageBaseData.mWidth == 0.0f || imageBaseData.mHeight == 0.0f) {
            return null;
        }
        Tile tile = new Tile(imageBaseData);
        if (imageBaseData.mType == ScalingUtils.ScaleType.CENTER) {
            tile.mSourceRect = new Rect();
            tile.mTargetRect = new Rect();
            if (f <= imageBaseData.mWidth) {
                tile.mSourceRect.left = 0;
                tile.mSourceRect.right = (int) f;
                tile.mTargetRect.left = (int) ((imageBaseData.mWidth - f) / 2.0f);
                tile.mTargetRect.right = (int) ((imageBaseData.mWidth + f) / 2.0f);
            } else {
                float f3 = (f - imageBaseData.mWidth) / 2.0f;
                tile.mSourceRect.left = (int) f3;
                tile.mSourceRect.right = (int) (f - f3);
                tile.mTargetRect.left = 0;
                tile.mTargetRect.right = (int) imageBaseData.mWidth;
            }
            if (f2 <= imageBaseData.mHeight) {
                tile.mSourceRect.top = 0;
                tile.mSourceRect.bottom = (int) f2;
                tile.mTargetRect.top = (int) ((imageBaseData.mHeight - f2) / 2.0f);
                tile.mTargetRect.bottom = (int) ((imageBaseData.mHeight + f2) / 2.0f);
            } else {
                float f4 = (f2 - imageBaseData.mHeight) / 2.0f;
                tile.mSourceRect.top = (int) f4;
                tile.mSourceRect.bottom = (int) (f2 - f4);
                tile.mTargetRect.top = 0;
                tile.mTargetRect.bottom = (int) imageBaseData.mHeight;
            }
            float f5 = tile.mSourceRect.right - tile.mSourceRect.left;
            float f6 = tile.mSourceRect.bottom - tile.mSourceRect.top;
            tile.mSampleSize = calculateInSampleSize(imageBaseData.mMax, f5, f6, f5, f6);
        } else if (imageBaseData.mType == ScalingUtils.ScaleType.FIT_CENTER) {
            float f7 = imageBaseData.mWidth / f;
            float f8 = imageBaseData.mHeight / f2;
            tile.mSourceRect = new Rect();
            tile.mSourceRect.top = 0;
            tile.mSourceRect.bottom = (int) f2;
            tile.mSourceRect.left = 0;
            tile.mSourceRect.right = (int) f;
            tile.mTargetRect = new Rect();
            if (f7 <= f8) {
                float f9 = f7 * f2;
                tile.mTargetRect.left = 0;
                tile.mTargetRect.right = (int) imageBaseData.mWidth;
                tile.mTargetRect.top = (int) ((imageBaseData.mHeight - f9) / 2.0f);
                tile.mTargetRect.bottom = (int) ((imageBaseData.mHeight + f9) / 2.0f);
            } else {
                float f10 = f8 * f;
                tile.mTargetRect.top = 0;
                tile.mTargetRect.bottom = (int) imageBaseData.mHeight;
                tile.mTargetRect.left = (int) ((imageBaseData.mWidth - f10) / 2.0f);
                tile.mTargetRect.right = (int) ((imageBaseData.mWidth + f10) / 2.0f);
            }
            tile.mSampleSize = calculateInSampleSize(imageBaseData.mMax, tile.mTargetRect.right - tile.mTargetRect.left, tile.mTargetRect.bottom - tile.mTargetRect.top, f, f2);
        } else if (imageBaseData.mType == ScalingUtils.ScaleType.CENTER_CROP) {
            float f11 = imageBaseData.mWidth / f;
            float f12 = imageBaseData.mHeight / f2;
            tile.mTargetRect = new Rect();
            tile.mTargetRect.top = 0;
            tile.mTargetRect.bottom = (int) imageBaseData.mHeight;
            tile.mTargetRect.left = 0;
            tile.mTargetRect.right = (int) imageBaseData.mWidth;
            tile.mSourceRect = new Rect();
            if (f11 >= f12) {
                float f13 = imageBaseData.mHeight / f11;
                tile.mSourceRect.left = 0;
                tile.mSourceRect.right = (int) f;
                tile.mSourceRect.top = (int) ((f2 - f13) / 2.0f);
                tile.mSourceRect.bottom = (int) ((f2 + f13) / 2.0f);
            } else {
                float f14 = imageBaseData.mWidth / f12;
                tile.mSourceRect.left = (int) ((f - f14) / 2.0f);
                tile.mSourceRect.right = (int) ((f + f14) / 2.0f);
                tile.mSourceRect.top = 0;
                tile.mSourceRect.bottom = (int) f2;
            }
            tile.mSampleSize = calculateInSampleSize(imageBaseData.mMax, imageBaseData.mWidth, imageBaseData.mHeight, tile.mSourceRect.right - tile.mSourceRect.left, tile.mSourceRect.bottom - tile.mSourceRect.top);
        } else {
            tile.mSourceRect = new Rect(0, 0, (int) f, (int) f2);
            tile.mTargetRect = new Rect(0, 0, (int) imageBaseData.mWidth, (int) imageBaseData.mHeight);
            tile.mSampleSize = calculateInSampleSize(imageBaseData.mMax, imageBaseData.mWidth, imageBaseData.mHeight, f, f2);
        }
        if (this.mIsNoSubSampleMode) {
            tile.mSampleSize = 1;
        }
        return tile;
    }

    private int calculateInSampleSize(Point point, float f, float f2, float f3, float f4) {
        int round;
        if (f4 != 0.0f && f3 != 0.0f) {
            float min = Math.min(Math.min(f / f3, f2 / f4), Math.min(point.x / f3, point.y / f4));
            int i = (int) (f3 * min);
            int i2 = (int) (min * f4);
            if (i != 0 && i2 != 0) {
                float f5 = i2;
                int i3 = 1;
                if (f4 > f5 || f3 > i) {
                    round = Math.round(f4 / f5);
                    int round2 = Math.round(f3 / i);
                    if (round >= round2) {
                        round = round2;
                    }
                } else {
                    round = 1;
                }
                while (true) {
                    int i4 = i3 * 2;
                    if (i4 > round) {
                        return i3;
                    }
                    i3 = i4;
                }
            }
        }
        return 32;
    }

    private void cacheBitmap(final Bitmap bitmap, final ImageRequest imageRequest) {
        if (imageRequest == null || bitmap == null) {
            return;
        }
        LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ui.image.helper.BigImageDrawingHelper.2
            @Override // java.lang.Runnable
            public void run() {
                Fresco.getImagePipeline().getBitmapMemoryCache().cache(Fresco.getImagePipeline().getCacheKeyFactory().getBitmapCacheKey(imageRequest, (Object) null), CloseableReference.of(new CloseableStaticBitmap(bitmap.copy(Bitmap.Config.ARGB_8888, false), SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0)));
            }
        });
    }

    private void loadBitmap(Context context, ImageRequest imageRequest, ImageBaseData imageBaseData) {
        loadOriginBitmap(context, imageRequest, imageBaseData);
        loadBitmapFromMemory(imageRequest, imageBaseData);
    }

    private void loadBitmapFromMemory(ImageRequest imageRequest, ImageBaseData imageBaseData) {
        CloseableReference<CloseableImage> clone;
        if (imageRequest == null) {
            return;
        }
        try {
            CacheKey bitmapCacheKey = Fresco.getImagePipeline().getCacheKeyFactory().getBitmapCacheKey(imageRequest, (Object) null);
            if (Fresco.getImagePipeline().getBitmapMemoryCache().get(bitmapCacheKey) == null || (clone = Fresco.getImagePipeline().getBitmapMemoryCache().get(bitmapCacheKey).clone()) == null || clone.get() == null || !(clone.get() instanceof CloseableStaticBitmap)) {
                return;
            }
            Bitmap underlyingBitmap = ((CloseableStaticBitmap) clone.get()).getUnderlyingBitmap();
            Tile tile = getTile(imageBaseData, underlyingBitmap.getWidth(), underlyingBitmap.getHeight());
            if (tile != null) {
                tile.mRef = clone;
                tile.mMap = underlyingBitmap;
                saveTileSync(tile);
            }
        } catch (Throwable th) {
            LLog.e("BigImageDrawingHelper", "loadBitmapFromMemory failed: " + th.toString());
        }
    }

    private void loadOriginBitmap(final Context context, final ImageRequest imageRequest, final ImageBaseData imageBaseData) {
        if (imageBaseData == null || TextUtils.isEmpty(imageBaseData.mUrl)) {
            return;
        }
        final ImageBaseData clone = ImageBaseData.clone(imageBaseData);
        ImageRequestJobScheduler.instance().scheduleAsync(new Runnable() { // from class: com.lynx.tasm.ui.image.helper.BigImageDrawingHelper.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (clone.mUrl == null || !clone.mUrl.startsWith("asset")) {
                        Tile loadBitmapFromDiskSync = BigImageDrawingHelper.this.loadBitmapFromDiskSync(imageRequest, clone);
                        if (loadBitmapFromDiskSync != null) {
                            BigImageDrawingHelper.this.saveTile(loadBitmapFromDiskSync);
                            return;
                        } else {
                            BigImageDrawingHelper.this.loadBitmapFromRemote(context, imageRequest, imageBaseData);
                            return;
                        }
                    }
                    Tile loadBitmapFromAssetSync = BigImageDrawingHelper.this.loadBitmapFromAssetSync(context, clone);
                    if (loadBitmapFromAssetSync != null) {
                        BigImageDrawingHelper.this.saveTile(loadBitmapFromAssetSync);
                    }
                } catch (Throwable th) {
                    LLog.e("BigImageDrawingHelper", "loadOriginBitmap failed: " + th.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Tile loadBitmapFromAssetSync(Context context, ImageBaseData imageBaseData) {
        try {
            InputStream open = context.getAssets().open(imageBaseData.mUrl.substring(9));
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(open, false);
            BitmapFactory.Options options = new BitmapFactory.Options();
            Tile tile = getTile(imageBaseData, newInstance.getWidth(), newInstance.getHeight());
            if (tile != null) {
                options.inSampleSize = tile.mSampleSize;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                tile.mMap = newInstance.decodeRegion(tile.mSourceRect, options);
                tile.mIsLoadFromMemory = false;
            }
            newInstance.recycle();
            open.close();
            return tile;
        } catch (Throwable th) {
            LLog.e(TAG, "loadBitmapFromAssetSync error: " + th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Tile loadBitmapFromDiskSync(ImageRequest imageRequest, ImageBaseData imageBaseData) {
        String substring;
        if (imageBaseData != null && !TextUtils.isEmpty(imageBaseData.mUrl)) {
            FileBinaryResource resource = Fresco.getImagePipelineFactory().getMainFileCache().getResource(new SimpleCacheKey(imageBaseData.mUrl));
            if (resource != null && resource.getFile() != null) {
                substring = null;
            } else if (this.mIsNoSubSampleMode) {
                int indexOf = imageBaseData.mUrl.indexOf("://");
                substring = imageBaseData.mUrl.substring(indexOf > 0 ? indexOf + 3 : 0);
            }
            if (substring == null) {
                try {
                    substring = resource.getFile().getPath();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(substring, false);
            BitmapFactory.Options options = new BitmapFactory.Options();
            Tile tile = getTile(imageBaseData, newInstance.getWidth(), newInstance.getHeight());
            if (tile != null) {
                options.inSampleSize = tile.mSampleSize;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                tile.mMap = newInstance.decodeRegion(tile.mSourceRect, options);
                tile.mIsLoadFromMemory = false;
            }
            newInstance.recycle();
            return tile;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBitmapFromRemote(Context context, ImageRequest imageRequest, final ImageBaseData imageBaseData) {
        if (imageBaseData == null || TextUtils.isEmpty(imageBaseData.mUrl)) {
            return;
        }
        LLog.d(TAG, "loadBitmapFromRemote");
        Uri parse = Uri.parse(imageBaseData.mUrl);
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(parse);
        ByteDanceFrescoUtils.fixAnimationBug(newBuilderWithSource);
        imagePipeline.fetchEncodedImage(newBuilderWithSource.build(), context).subscribe(new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>() { // from class: com.lynx.tasm.ui.image.helper.BigImageDrawingHelper.4
            public void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                CloseableReference closeableReference;
                PooledByteBufferInputStream pooledByteBufferInputStream;
                Throwable th;
                String th2;
                if (dataSource.isFinished() && (closeableReference = (CloseableReference) dataSource.getResult()) != null) {
                    CloseableReference clone = closeableReference.clone();
                    try {
                        pooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer) clone.get());
                        try {
                            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance((InputStream) pooledByteBufferInputStream, false);
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            Tile tile = BigImageDrawingHelper.this.getTile(imageBaseData, newInstance.getWidth(), newInstance.getHeight());
                            if (tile != null) {
                                options.inSampleSize = tile.mSampleSize;
                                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                                tile.mMap = newInstance.decodeRegion(tile.mSourceRect, options);
                                tile.mIsLoadFromMemory = false;
                                BigImageDrawingHelper.this.saveTile(tile);
                            }
                            newInstance.recycle();
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                th.printStackTrace();
                                if (BigImageDrawingHelper.this.mCallback != null) {
                                    if (BigImageDrawingHelper.this.mTile != null && BigImageDrawingHelper.this.mTile.mData != null && BigImageDrawingHelper.this.mTile.mData.mUrl != null) {
                                        th2 = "Android BigImageDrawingHelper loading image from remote onNewResultImpl failed, and the url is " + BigImageDrawingHelper.this.mTile.mData.mUrl + ". The Fresco throw error msg is " + th.toString();
                                    } else {
                                        th2 = th.toString();
                                    }
                                    BigImageDrawingHelper.this.mCallback.onImageLoadFailed(th2);
                                }
                            } finally {
                                BigImageDrawingHelper.closeQuietly(pooledByteBufferInputStream);
                                closeableReference.close();
                                clone.close();
                            }
                        }
                    } catch (Throwable th4) {
                        pooledByteBufferInputStream = null;
                        th = th4;
                    }
                }
            }

            public void onFailureImpl(DataSource dataSource) {
                String th;
                Throwable failureCause = dataSource.getFailureCause();
                if (failureCause != null) {
                    LLog.e(BigImageDrawingHelper.TAG, "loadBitmapFromRemote failed: " + failureCause.toString());
                }
                if (BigImageDrawingHelper.this.mCallback != null) {
                    if (BigImageDrawingHelper.this.mTile != null && BigImageDrawingHelper.this.mTile.mData != null && BigImageDrawingHelper.this.mTile.mData.mUrl != null) {
                        th = "Android BigImageDrawingHelper loading image from remote failed, and the url is " + BigImageDrawingHelper.this.mTile.mData.mUrl + ". The Fresco throw error msg is " + failureCause.toString();
                    } else {
                        th = failureCause != null ? failureCause.toString() : "";
                    }
                    BigImageDrawingHelper.this.mCallback.onImageLoadFailed(th);
                }
            }
        }, Executors.newSingleThreadExecutor());
    }

    @Deprecated
    public boolean drawBigImage(Context context, Canvas canvas, ImageRequest imageRequest, ImageBaseData imageBaseData) {
        return drawBigImage(context, canvas, imageRequest, imageBaseData, DisplayMetricsHolder.getRealScreenDisplayMetrics(context));
    }

    public boolean drawBigImage(Context context, Canvas canvas, ImageRequest imageRequest, ImageBaseData imageBaseData, DisplayMetrics displayMetrics) {
        if (displayMetrics == null || imageBaseData == null || (imageBaseData.mWidth <= displayMetrics.widthPixels * 3 && imageBaseData.mHeight <= displayMetrics.heightPixels && !imageBaseData.mRepeat)) {
            return false;
        }
        this.mIsNoSubSampleMode = false;
        LLog.d(TAG, "drawBigImage: w:" + imageBaseData.mWidth + ", h:" + imageBaseData.mHeight);
        Tile tile = this.mTile;
        if (tile == null || tile.mMap == null || this.mTile.mData.mCnt != imageBaseData.mCnt) {
            destroy();
            loadBitmap(context, imageRequest, imageBaseData);
            drawScaleImage(canvas, this.mTile);
            return true;
        }
        drawScaleImage(canvas, this.mTile);
        return true;
    }

    public boolean drawImageWithoutSubSample(Context context, Canvas canvas, ImageRequest imageRequest, ImageBaseData imageBaseData) {
        this.mIsNoSubSampleMode = true;
        Tile tile = this.mTile;
        if (tile == null || tile.mMap == null || this.mTile.mData.mCnt != imageBaseData.mCnt) {
            destroy();
            loadBitmap(context, imageRequest, imageBaseData);
            drawScaleImage(canvas, this.mTile);
        } else {
            drawScaleImage(canvas, this.mTile);
        }
        return true;
    }

    public boolean drawImageWithCapInsets(Context context, Canvas canvas, ImageRequest imageRequest, ImageBaseData imageBaseData) {
        this.mIsNoSubSampleMode = true;
        Tile tile = this.mTile;
        if (tile == null || tile.mMap == null || this.mTile.mData.mCnt != imageBaseData.mCnt) {
            destroy();
            loadBitmap(context, imageRequest, imageBaseData);
        }
        Tile tile2 = this.mTile;
        if (tile2 == null || tile2.mMap == null) {
            return false;
        }
        BaseRoundedCornerPostprocessor.customDraw((int) imageBaseData.mWidth, (int) imageBaseData.mHeight, this.mTile.mMap.getWidth(), this.mTile.mMap.getHeight(), imageBaseData.mType, imageBaseData.mCapInsets, imageBaseData.mCapInsetsScale, canvas, this.mTile.mMap);
        return true;
    }

    private void drawScaleImage(Canvas canvas, Tile tile) {
        if (tile == null || tile.mMap == null || tile.mMap.isRecycled()) {
            return;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        if (tile.mData.mType == ScalingUtils.ScaleType.FIT_CENTER && tile.mData.mRepeat) {
            BitmapShader bitmapShader = new BitmapShader(this.mTile.mMap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            Matrix matrix = new Matrix();
            float min = Math.min((canvas.getWidth() * 1.0f) / this.mTile.mMap.getWidth(), (canvas.getHeight() * 1.0f) / this.mTile.mMap.getHeight());
            matrix.postScale(min, min);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            canvas.drawRect(new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), paint);
            return;
        }
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(this.mTile.mTargetRect.left, this.mTile.mTargetRect.top);
        if (this.mTile.mIsLoadFromMemory) {
            matrix2.postScale(((this.mTile.mTargetRect.right - this.mTile.mTargetRect.left) * 1.0f) / (this.mTile.mSourceRect.right - this.mTile.mSourceRect.left), ((this.mTile.mTargetRect.bottom - this.mTile.mTargetRect.top) * 1.0f) / (this.mTile.mSourceRect.bottom - this.mTile.mSourceRect.top));
            canvas.drawBitmap(this.mTile.mMap, matrix2, paint);
        } else {
            matrix2.postScale(((this.mTile.mTargetRect.right - this.mTile.mTargetRect.left) * 1.0f) / this.mTile.mMap.getWidth(), ((this.mTile.mTargetRect.bottom - this.mTile.mTargetRect.top) * 1.0f) / this.mTile.mMap.getHeight());
            canvas.drawBitmap(this.mTile.mMap, matrix2, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
        Tile tile = this.mTile;
        if (tile != null) {
            tile.destroy();
        }
        this.mTile = null;
    }
}
