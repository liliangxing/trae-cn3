package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {
    private static final int NO_THUMBNAIL = 0;
    public static final String PRODUCER_NAME = "LocalContentUriThumbnailFetchProducer";
    private final ContentResolver mContentResolver;
    private static final Class<?> TAG = LocalContentUriThumbnailFetchProducer.class;
    private static final String[] PROJECTION = {"_id", "_data"};
    private static final String[] THUMBNAIL_PROJECTION = {"_data"};
    private static final Rect MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
    private static final Rect MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        Rect rect = MINI_THUMBNAIL_DIMENSIONS;
        return ThumbnailSizeChecker.isImageBigEnough(rect.width(), rect.height(), resizeOptions);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        Uri sourceUri = imageRequest.getSourceUri();
        if (!UriUtil.isLocalCameraUri(sourceUri)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return getThumbnailAndroidQ(sourceUri, imageRequest.getResizeOptions());
        }
        EncodedImage cameraImage = getCameraImage(sourceUri, imageRequest.getResizeOptions());
        if (cameraImage != null) {
            return cameraImage;
        }
        return null;
    }

    @Nullable
    private EncodedImage getCameraImage(Uri uri, ResizeOptions resizeOptions) throws IOException {
        EncodedImage thumbnail;
        Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.getCount() == 0) {
                return null;
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            if (resizeOptions == null || (thumbnail = getThumbnail(resizeOptions, query.getInt(query.getColumnIndex("_id")))) == null) {
                return null;
            }
            thumbnail.setRotationAngle(getRotationAngle(string));
            return thumbnail;
        } finally {
            query.close();
        }
    }

    private EncodedImage getThumbnail(ResizeOptions resizeOptions, int i) throws IOException {
        int thumbnailKind = getThumbnailKind(resizeOptions);
        Cursor cursor = null;
        if (thumbnailKind == 0) {
            return null;
        }
        try {
            Cursor queryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, i, thumbnailKind, THUMBNAIL_PROJECTION);
            if (queryMiniThumbnail == null) {
                if (queryMiniThumbnail != null) {
                    queryMiniThumbnail.close();
                }
                return null;
            }
            try {
                queryMiniThumbnail.moveToFirst();
                if (queryMiniThumbnail.getCount() > 0) {
                    String string = queryMiniThumbnail.getString(queryMiniThumbnail.getColumnIndex("_data"));
                    if (new File(string).exists()) {
                        EncodedImage encodedImage = getEncodedImage(new FileInputStream(string), getLength(string));
                        if (queryMiniThumbnail != null) {
                            queryMiniThumbnail.close();
                        }
                        return encodedImage;
                    }
                }
                if (queryMiniThumbnail != null) {
                    queryMiniThumbnail.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                cursor = queryMiniThumbnail;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer] */
    private EncodedImage getThumbnailAndroidQ(Uri uri, ResizeOptions resizeOptions) {
        FileInputStream fileInputStream;
        ?? r1 = 0;
        try {
            try {
                if (getThumbnailKind(resizeOptions) == 0) {
                    return null;
                }
                try {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("android.content.extra.SIZE", new Point(resizeOptions.width, resizeOptions.height));
                    fileInputStream = new FileInputStream(this.mContentResolver.openTypedAssetFile(uri, "image/*", bundle, null).getFileDescriptor());
                    try {
                        int available = fileInputStream.available();
                        if (available <= 0) {
                            fileInputStream.close();
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                FLog.m438e(TAG, e.getMessage());
                            }
                            return null;
                        }
                        EncodedImage encodedImage = getEncodedImage(fileInputStream, available);
                        fileInputStream.close();
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            FLog.m438e(TAG, e2.getMessage());
                        }
                        return encodedImage;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        FLog.m438e(TAG, e.getMessage());
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (IOException e4) {
                        e = e4;
                        FLog.m438e(TAG, e.getMessage());
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (Exception e5) {
                        e = e5;
                        FLog.m438e(TAG, e.getMessage());
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    fileInputStream = null;
                } catch (IOException e7) {
                    e = e7;
                    fileInputStream = null;
                } catch (Exception e8) {
                    e = e8;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e9) {
                            FLog.m438e(TAG, e9.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = resizeOptions;
            }
        } catch (IOException e10) {
            FLog.m438e(TAG, e10.getMessage());
        }
    }

    private static int getThumbnailKind(ResizeOptions resizeOptions) {
        Rect rect = MICRO_THUMBNAIL_DIMENSIONS;
        if (ThumbnailSizeChecker.isImageBigEnough(rect.width(), rect.height(), resizeOptions)) {
            return 3;
        }
        Rect rect2 = MINI_THUMBNAIL_DIMENSIONS;
        return ThumbnailSizeChecker.isImageBigEnough(rect2.width(), rect2.height(), resizeOptions) ? 1 : 0;
    }

    private static int getLength(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    private static int getRotationAngle(String str) {
        if (str != null) {
            try {
                return JfifUtil.getAutoRotateAngleFromOrientation(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (IOException e) {
                FLog.m441e(TAG, e, "Unable to retrieve thumbnail rotation for %s", str);
            }
        }
        return 0;
    }
}
