package com.bytedance.bdturing.livedetect.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.text.TextUtils;
import com.bytedance.bdturing.livedetect.yuv.TuringYuv;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ImageUtil {
    public static final int SCALE_TYPE_H = 1;
    public static final int SCALE_TYPE_V = 0;

    public static ImageDataWrapper buildBitmap(ImageRawData imageRawData) {
        int colorFormat = imageRawData.getColorFormat();
        if (colorFormat == 1) {
            return nv21ToBitmap(imageRawData);
        }
        if (colorFormat != 2) {
            return null;
        }
        return i420ToBitmap(imageRawData);
    }

    private static ImageDataWrapper i420ToBitmap(ImageRawData imageRawData) {
        try {
            return TuringYuv.I420ToBitmap(imageRawData.getYuvData(), new byte[imageRawData.getWidth() * imageRawData.getHeight() * 4], imageRawData.getWidth(), imageRawData.getHeight(), imageRawData.getRotateDegree());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ImageDataWrapper nv21ToBitmap(ImageRawData imageRawData) {
        ByteArrayOutputStream byteArrayOutputStream;
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        new YuvImage(imageRawData.getYuvData(), 17, imageRawData.getWidth(), imageRawData.getHeight(), null).compressToJpeg(new Rect(0, 0, imageRawData.getWidth(), imageRawData.getHeight()), 95, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        byteArrayOutputStream.close();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (bitmap != null) {
                            if (imageRawData.getRotateDegree() > 0) {
                            }
                            bitmap = scaleBitmap(bitmap, 0);
                        }
                        ImageDataWrapper imageDataWrapper = new ImageDataWrapper();
                        imageDataWrapper.bitmap = bitmap;
                        return imageDataWrapper;
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayOutputStream2 != null) {
            }
            throw th;
        }
        if (bitmap != null && imageRawData != null) {
            if (imageRawData.getRotateDegree() > 0) {
                bitmap = rotateBitmap(bitmap, imageRawData.getRotateDegree());
            }
            bitmap = scaleBitmap(bitmap, 0);
        }
        ImageDataWrapper imageDataWrapper2 = new ImageDataWrapper();
        imageDataWrapper2.bitmap = bitmap;
        return imageDataWrapper2;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap RGBAToBitmap(byte[] bArr, int i, int i2) {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:43:0x002b */
    public static byte[] bitmapToRgbBytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 95, byteArrayOutputStream2);
                        byteArray = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream3 = byteArrayOutputStream2;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 == null) {
                            return null;
                        }
                        try {
                            byteArrayOutputStream2.close();
                            return null;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                byteArray = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }

    public static byte[] convertBitmapToRgbBytes(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        byte[] bArr = new byte[i * 3];
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            bArr[i3] = (byte) ((i4 >> 16) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i4 >> 8) & 255);
            bArr[i6] = (byte) (i4 & 255);
            i2++;
            i3 = i6 + 1;
        }
        return bArr;
    }

    public static Bitmap rgbBytesToBitmap(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            if (bArr.length > 0) {
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        if (i == 0) {
            matrix.setScale(-1.0f, 1.0f);
        } else if (1 == i) {
            matrix.setScale(1.0f, -1.0f);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void saveBitmap(Bitmap bitmap, String str) {
        File file = new File(str);
        try {
            if (!file.exists() && bitmap != null && !TextUtils.isEmpty(str)) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap scaleBitmapCropCenter(Bitmap bitmap, int i, int i2) {
        float f = i;
        float width = bitmap.getWidth();
        float f2 = i2;
        float height = bitmap.getHeight();
        float max = Math.max(f / width, f2 / height);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postTranslate((f - (width * max)) / 2.0f, (f2 - (height * max)) / 2.0f);
        matrix.preScale(max, max);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, matrix, paint);
        return createBitmap;
    }
}
