package com.bytedance.ug.sdk.share.channel.wechat.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.callback.GetImageCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.utils.HttpUtils;
import com.bytedance.ug.sdk.share.impl.utils.ImageUtils;
import com.bytedance.ug.sdk.share.impl.utils.LoadingUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WXImageUtils {
    private static final int COMPRESS_IMAGE_SIZE = 32;
    public static final int IMAGE_QUALITY = 85;
    private static final int MINIAPP_COMPRESS_IMAGE_SIZE = 128;
    public static final int THUMB_MAX_WIDTH = 114;

    public static void getImageBytes(ShareContent shareContent, OnImageLoadListener onImageLoadListener) {
        getImageBytes(shareContent, onImageLoadListener, (shareContent.getShareStrategy() == ShareStrategy.SHARE_WITH_COMPONENT || shareContent.getShareStrategy() == ShareStrategy.SHARE_WITH_COMPONET_OPTIMIZE) ? false : true, false);
    }

    public static void getImageBytes(ShareContent shareContent, final OnImageLoadListener onImageLoadListener, final boolean z, final boolean z2) {
        Bitmap bitmap;
        ByteArrayOutputStream byteArrayOutputStream;
        if (onImageLoadListener == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (shareContent == null) {
            onImageLoadListener.onLoaded(null);
            return;
        }
        String imageUrl = shareContent.getImageUrl();
        if (TextUtils.isEmpty(imageUrl)) {
            if (shareContent.getImage() != null) {
                onImageLoadListener.onLoaded(weChatBitmapToByteArray(shareContent.getImage(), z2));
                return;
            } else {
                onImageLoadListener.onLoaded(null);
                return;
            }
        }
        if (HttpUtils.isUrl(imageUrl)) {
            LoadingUtils.showProgressDialog(shareContent);
            ShareConfigManager.getInstance().getImageBitmap(imageUrl, new GetImageCallback() { // from class: com.bytedance.ug.sdk.share.channel.wechat.utils.WXImageUtils.1
                @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
                public void onSuccess(Bitmap bitmap2) {
                    LoadingUtils.dismissProgressDialog();
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        OnImageLoadListener onImageLoadListener2 = OnImageLoadListener.this;
                        if (onImageLoadListener2 != null) {
                            onImageLoadListener2.onLoaded(null);
                            return;
                        }
                        return;
                    }
                    OnImageLoadListener onImageLoadListener3 = OnImageLoadListener.this;
                    if (onImageLoadListener3 != null) {
                        if (!z) {
                            onImageLoadListener3.onLoaded(WXImageUtils.convertBitmap(bitmap2));
                        } else {
                            onImageLoadListener3.onLoaded(WXImageUtils.weChatBitmapToByteArray(bitmap2, z2));
                        }
                    }
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
                public void onFailed() {
                    LoadingUtils.dismissProgressDialog();
                    OnImageLoadListener onImageLoadListener2 = OnImageLoadListener.this;
                    if (onImageLoadListener2 != null) {
                        onImageLoadListener2.onLoaded(null);
                    }
                }
            });
            return;
        }
        File file = new File(imageUrl);
        if (!file.exists()) {
            bitmap = null;
        } else if (!z) {
            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        } else {
            if (z2 && onImageLoadListener != null) {
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                onImageLoadListener.onLoaded(weChatBitmapToByteArray(decodeFile, true));
                if (decodeFile != null) {
                    decodeFile.recycle();
                    return;
                }
                return;
            }
            bitmap = getCompressedSquareBitmap(file.getAbsolutePath(), 114.0f, 114.0f, true);
        }
        if (bitmap != null) {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                onImageLoadListener.onLoaded(byteArrayOutputStream.toByteArray());
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    Logger.m465e(e2.toString());
                }
                if (bitmap == null) {
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                Logger.throwException(e);
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        Logger.m465e(e4.toString());
                    }
                }
                if (bitmap == null) {
                    return;
                }
                bitmap.recycle();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e5) {
                        Logger.m465e(e5.toString());
                    }
                }
                if (bitmap == null) {
                    throw th;
                }
                bitmap.recycle();
                throw th;
            }
            bitmap.recycle();
        }
    }

    public static Bitmap getCompressedSquareBitmap(String str, float f, float f2, boolean z) {
        Bitmap compressImage = compressImage(str, f, f2, false, z);
        if (compressImage == null) {
            return null;
        }
        int width = compressImage.getHeight() > compressImage.getWidth() ? compressImage.getWidth() : compressImage.getHeight();
        try {
            return Bitmap.createBitmap(compressImage, (compressImage.getWidth() - width) / 2, (compressImage.getHeight() - width) / 2, width, width);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0038, code lost:
    
        if (r10 > r11) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x004f, code lost:
    
        if (r10 > r11) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap compressImage(String str, float f, float f2, boolean z, boolean z2) {
        float f3 = f2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i = options.outHeight;
        int i2 = options.outWidth;
        if (i > 0 && i2 > 0) {
            float f4 = i2;
            float f5 = i;
            float f6 = f4 / f5;
            float f7 = f / f3;
            if (z) {
                if (f5 > f3 || f4 > f) {
                    if (f6 >= f7) {
                    }
                    i2 = (int) ((f3 / f5) * f4);
                    i = (int) f3;
                }
            } else if (f5 > f3 || f4 > f) {
                if (f6 >= f7) {
                }
                f3 = (f / f4) * f5;
                i = (int) f3;
                i2 = (int) f;
            }
            if (i > 0 && i2 > 0) {
                options.inSampleSize = calculateInSampleSize(options, i2, i);
                options.inJustDecodeBounds = false;
                options.inPurgeable = true;
                options.inInputShareable = true;
                options.inTempStorage = new byte[16384];
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                    float f8 = i2;
                    float f9 = f8 / options.outWidth;
                    float f10 = i;
                    float f11 = f10 / options.outHeight;
                    float f12 = f8 / 2.0f;
                    float f13 = f10 / 2.0f;
                    Matrix matrix = new Matrix();
                    if (z2) {
                        f11 = (f10 + 0.5f) / options.outHeight;
                        f9 = (f8 + 0.5f) / options.outWidth;
                    }
                    matrix.setScale(f9, f11, f12, f13);
                    Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.setMatrix(matrix);
                    canvas.drawBitmap(decodeFile, f12 - (decodeFile.getWidth() / 2), f13 - (decodeFile.getHeight() / 2), new Paint(2));
                    decodeFile.recycle();
                    try {
                        int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
                        Matrix matrix2 = new Matrix();
                        if (attributeInt == 6) {
                            matrix2.postRotate(90.0f);
                        } else if (attributeInt == 3) {
                            matrix2.postRotate(180.0f);
                        } else if (attributeInt == 8) {
                            matrix2.postRotate(270.0f);
                        }
                        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix2, true);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return createBitmap;
                    }
                } catch (OutOfMemoryError unused) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] convertBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            Logger.m465e(e.toString());
                        }
                        return byteArray;
                    } catch (Exception e2) {
                        e = e2;
                        Logger.throwException(e);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                Logger.m465e(e3.toString());
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e4) {
                            Logger.m465e(e4.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream2 != null) {
                }
                throw th;
            }
        }
        return null;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int round;
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 > i2 || i4 > i) {
            round = Math.round(i3 / i2);
            int round2 = Math.round(i4 / i);
            if (round >= round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        while ((i4 * i3) / (round * round) > i * i2 * 2) {
            round++;
        }
        return round;
    }

    public static byte[] weChatBitmapToByteArray(Bitmap bitmap, boolean z) {
        if (z) {
            return ImageUtils.compressBitmapToByteArray(bitmap, 128);
        }
        return ImageUtils.compressBitmapToByteArray(bitmap, 32);
    }
}
