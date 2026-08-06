package com.bytedance.bdturing.livedetect.camera;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CameraFrameDataReader implements ImageReader.OnImageAvailableListener {
    public static final int COLOR_FormatI420 = 2;
    public static final int COLOR_FormatNV21 = 1;
    private CameraFrameDataCallBack mCallBack;
    private CameraImageHandleTask mImgHandleTask;
    private OrientationHelper mOrationInfo;
    private boolean onImageAvailable = false;

    public CameraFrameDataReader(CameraFrameDataCallBack cameraFrameDataCallBack, OrientationHelper orientationHelper) {
        this.mCallBack = cameraFrameDataCallBack;
        this.mOrationInfo = orientationHelper;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        Image image = null;
        try {
            try {
                image = imageReader.acquireNextImage();
                if (!this.onImageAvailable) {
                    StringBuilder sb = new StringBuilder("image_width:");
                    sb.append(image != null ? Integer.valueOf(image.getWidth()) : "0");
                    sb.append(";image_height:").append(image != null ? Integer.valueOf(image.getHeight()) : "0");
                    sb.append(";image_format:").append(image != null ? Integer.valueOf(image.getFormat()) : "0");
                    CameraStateMonitor.getInstance().recordCameraState("onImageAvailable", sb.toString());
                    this.onImageAvailable = true;
                }
                int width = image.getWidth();
                int height = image.getHeight();
                byte[] dataFromImage = getDataFromImage(image, 2);
                if (dataFromImage != null && dataFromImage.length > 0) {
                    handleImage(new ImageRawData(width, height, dataFromImage, 2, this.mOrationInfo.getRotateDegree()));
                }
                if (image == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                noticeException(e);
                if (image == null) {
                    return;
                }
            }
            image.close();
        } catch (Throwable th) {
            if (image != null) {
                image.close();
            }
            throw th;
        }
    }

    private void noticeException(Exception exc) {
        CameraFrameDataCallBack cameraFrameDataCallBack = this.mCallBack;
        if (cameraFrameDataCallBack != null) {
            cameraFrameDataCallBack.onCameraException(CameraErrorCode.ERROR_CODE_CAMERA_READ_IMAGE_ERROR, exc);
        }
    }

    private void handleImage(ImageRawData imageRawData) {
        CameraImageHandleTask cameraImageHandleTask = this.mImgHandleTask;
        if (cameraImageHandleTask == null) {
            CameraImageHandleTask cameraImageHandleTask2 = new CameraImageHandleTask(this.mCallBack);
            this.mImgHandleTask = cameraImageHandleTask2;
            cameraImageHandleTask2.putImage(imageRawData);
            this.mImgHandleTask.start();
            return;
        }
        cameraImageHandleTask.putImage(imageRawData);
    }

    private static boolean isImageFormatSupported(Image image) {
        int format = image.getFormat();
        return format == 17 || format == 35 || format == 842094169;
    }

    public static byte[] getDataFromImage(Image image, int i) {
        Rect rect;
        int i2;
        int i3 = i;
        int i4 = 1;
        int i5 = 2;
        if (i3 != 2 && i3 != 1) {
            throw new IllegalArgumentException("only support COLOR_FormatI420 and COLOR_FormatNV21");
        }
        if (!isImageFormatSupported(image)) {
            throw new RuntimeException("can't convert Image to byte array, format " + image.getFormat());
        }
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i6 = width * height;
        byte[] bArr = new byte[(ImageFormat.getBitsPerPixel(format) * i6) / 8];
        int i7 = 0;
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        while (i9 < planes.length) {
            if (i9 == 0) {
                i8 = i4;
                i10 = i7;
            } else if (i9 != i4) {
                if (i9 == i5) {
                    if (i3 == i5) {
                        i10 = (int) (i6 * 1.25d);
                        i8 = i4;
                    } else if (i3 == i4) {
                        i8 = i5;
                        i10 = i6;
                    }
                }
            } else if (i3 == i5) {
                i8 = i4;
                i10 = i6;
            } else if (i3 == i4) {
                i10 = i6 + 1;
                i8 = i5;
            }
            ByteBuffer buffer = planes[i9].getBuffer();
            int rowStride = planes[i9].getRowStride();
            int pixelStride = planes[i9].getPixelStride();
            int i11 = i9 == 0 ? i7 : i4;
            int i12 = width >> i11;
            int i13 = height >> i11;
            int i14 = width;
            buffer.position(((cropRect.top >> i11) * rowStride) + ((cropRect.left >> i11) * pixelStride));
            int i15 = 0;
            while (i15 < i13) {
                if (pixelStride == 1 && i8 == 1) {
                    buffer.get(bArr, i10, i12);
                    i10 += i12;
                    rect = cropRect;
                    i2 = i12;
                } else {
                    rect = cropRect;
                    i2 = ((i12 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i2);
                    for (int i16 = 0; i16 < i12; i16++) {
                        bArr[i10] = bArr2[i16 * pixelStride];
                        i10 += i8;
                    }
                }
                if (i15 < i13 - 1) {
                    buffer.position((buffer.position() + rowStride) - i2);
                }
                i15++;
                cropRect = rect;
            }
            i9++;
            i3 = i;
            width = i14;
            i4 = 1;
            i5 = 2;
            i7 = 0;
        }
        return bArr;
    }

    public void release() {
        CameraImageHandleTask cameraImageHandleTask = this.mImgHandleTask;
        if (cameraImageHandleTask != null) {
            cameraImageHandleTask.release();
            this.mImgHandleTask = null;
        }
        this.mCallBack = null;
    }
}
