package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.facebook.common.internal.Closeables;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeBitmapConfigStrategy;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import com.facebook.imageutils.HeifFormatUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DefaultImageDecoder implements ImageDecoder {
    private static final String TAG = "DefaultImageDecoder";
    private static boolean enableOOMHeif = true;
    private final ImageDecoder mAnimatedGifDecoder;
    private final ImageDecoder mAnimatedHeifDecoder;
    private final ImageDecoder mAnimatedWebPDecoder;

    @Nullable
    private final Map<ImageFormat, ImageDecoder> mCustomDecoders;
    private final ImageDecoder mDefaultDecoder;
    private final ImageDecoder mHeifDecoder;
    private final PlatformDecoder mPlatformDecoder;

    public static void setEnableOOMHeif(boolean z) {
        enableOOMHeif = z;
    }

    public static final String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append('0');
            }
            sb.append(hexString.toLowerCase());
        }
        return sb.toString();
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, ImageDecoder imageDecoder3, ImageDecoder imageDecoder4, PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, imageDecoder3, imageDecoder4, platformDecoder, null);
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, ImageDecoder imageDecoder3, ImageDecoder imageDecoder4, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map) {
        this.mDefaultDecoder = new ImageDecoder() { // from class: com.facebook.imagepipeline.decoder.DefaultImageDecoder.1
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                ImageDecodeOptions newDecodeOptionForStrategy = DefaultImageDecoder.newDecodeOptionForStrategy(imageDecodeOptions, encodedImage);
                ImageFormat imageFormat = encodedImage.getImageFormat();
                if (imageFormat == DefaultImageFormats.JPEG) {
                    return DefaultImageDecoder.this.decodeJpeg(encodedImage, i, qualityInfo, newDecodeOptionForStrategy);
                }
                if (imageFormat == DefaultImageFormats.GIF) {
                    return DefaultImageDecoder.this.decodeGif(encodedImage, i, qualityInfo, newDecodeOptionForStrategy);
                }
                if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                    return DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i, qualityInfo, newDecodeOptionForStrategy);
                }
                if (imageFormat == HeifFormatUtil.getHeifFormatAnimated()) {
                    return DefaultImageDecoder.this.decodeAnimatedHeif(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == ImageFormat.UNKNOWN) {
                    throw new DecodeException("unknown image format" + DefaultImageDecoder.parseEncodedImageInfo(encodedImage), encodedImage);
                }
                return DefaultImageDecoder.this.decodeStaticImage(encodedImage, newDecodeOptionForStrategy);
            }
        };
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mAnimatedHeifDecoder = imageDecoder3;
        this.mHeifDecoder = imageDecoder4;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        if (imageDecodeOptions.customImageDecoder != null) {
            return imageDecodeOptions.customImageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        ImageFormat imageFormat = encodedImage.getImageFormat();
        if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            encodedImage.setImageFormat(imageFormat);
        }
        Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
        if (map != null && (imageDecoder = map.get(imageFormat)) != null) {
            if (enableOOMHeif) {
                return imageDecoder.decode(encodedImage, i, qualityInfo, newDecodeOptionForStrategy(imageDecodeOptions, encodedImage));
            }
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        if (!imageDecodeOptions.forceStaticImage && (imageDecoder = this.mAnimatedGifDecoder) != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return decodeStaticImage(encodedImage, imageDecodeOptions);
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        Rect regionToDecode = getRegionToDecode(encodedImage, imageDecodeOptions);
        CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, regionToDecode, imageDecodeOptions.transformToSRGB);
        try {
            maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeFromEncodedImageWithColorSpace);
            return new CloseableStaticBitmap(decodeFromEncodedImageWithColorSpace, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation(), regionToDecode, encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
        } finally {
            decodeFromEncodedImageWithColorSpace.close();
        }
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        Rect regionToDecode = getRegionToDecode(encodedImage, imageDecodeOptions);
        CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, regionToDecode, i, imageDecodeOptions.transformToSRGB);
        try {
            maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeJPEGFromEncodedImageWithColorSpace);
            return new CloseableStaticBitmap(decodeJPEGFromEncodedImageWithColorSpace, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation(), regionToDecode, encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
        } finally {
            decodeJPEGFromEncodedImageWithColorSpace.close();
        }
    }

    public CloseableStaticBitmap decodeHeic(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        ImageFormat imageFormat = encodedImage.getImageFormat();
        if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            encodedImage.setImageFormat(imageFormat);
        }
        Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
        CloseableImage decode = (map == null || (imageDecoder = map.get(imageFormat)) == null) ? null : imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        if (decode == null) {
            decode = this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        if (decode instanceof CloseableStaticBitmap) {
            return (CloseableStaticBitmap) decode;
        }
        return null;
    }

    public CloseableImage decodeAnimatedWebp(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        return this.mAnimatedWebPDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeAnimatedHeif(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        return this.mAnimatedHeifDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeHeif(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        return this.mHeifDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    private void maybeApplyTransformation(@Nullable BitmapTransformation bitmapTransformation, CloseableReference<Bitmap> closeableReference) {
        if (bitmapTransformation == null) {
            return;
        }
        Bitmap bitmap = closeableReference.get();
        if (bitmapTransformation.modifiesTransparency()) {
            bitmap.setHasAlpha(true);
        }
        bitmapTransformation.transform(bitmap);
    }

    private Rect getRegionToDecode(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        Rect regionToDecode = encodedImage.getRegionToDecode();
        if (regionToDecode != null) {
            return imageDecodeOptions.useSmartCrop ? regionToDecode : imageDecodeOptions.regionToDecode;
        }
        return imageDecodeOptions.regionToDecode;
    }

    private static Bitmap.Config getBitmapConfigForStrategy(ImageDecodeOptions imageDecodeOptions, EncodedImage encodedImage) {
        return getBitmapConfigForStrategy(imageDecodeOptions, encodedImage.getUri(), encodedImage.getViewWidth(), encodedImage.getViewHeight(), encodedImage.getWidth(), encodedImage.getHeight(), encodedImage.hasAlpha() || encodedImage.is10Bit(), encodedImage.getImageFormat());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap.Config getBitmapConfigForStrategy(ImageDecodeOptions imageDecodeOptions, String str, int i, int i2, int i3, int i4, boolean z, ImageFormat imageFormat) {
        SimplayerImageStrategy strategy = SimplayerImageStrategy.getStrategy();
        int i5 = 1;
        Bitmap.Config config = null;
        if (strategy != null && i > 0 && i2 > 0 && str != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("viewWidth", i);
                jSONObject.put("viewHeight", i2);
                jSONObject.put("imageFormat", imageFormat);
                if (SimplayerImageStrategy.isOpenLog()) {
                    Log.d(SimplayerImageStrategy.TAG, "getBitmapConfigForStrategy, params:" + jSONObject + ", uri:" + str);
                }
                JSONObject result = strategy.getResult(1, str, jSONObject);
                if (SimplayerImageStrategy.isOpenLog()) {
                    Log.d(SimplayerImageStrategy.TAG, "getBitmapConfigForStrategy, results:" + result);
                }
                if (result != null) {
                    int optInt = result.optInt("priority", 1);
                    try {
                        String optString = result.optString(SimplayerImageStrategy.RESULT_BITMAP);
                        if (optString.isEmpty()) {
                            i5 = optInt;
                        } else {
                            i5 = optInt;
                            config = Bitmap.Config.valueOf(optString);
                        }
                    } catch (JSONException e) {
                        i5 = optInt;
                        e = e;
                        e.printStackTrace();
                        if (config == null) {
                        }
                        if (!imageDecodeOptions.isSelectBitmapConfig) {
                        }
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        if (config == null && (i5 == 3 || (i5 == 2 && !imageDecodeOptions.isSelectBitmapConfig))) {
            return config;
        }
        if (!imageDecodeOptions.isSelectBitmapConfig) {
            return imageDecodeOptions.bitmapConfig;
        }
        return ImageDecodeBitmapConfigStrategy.getStrategy().getBitmapConfig(str, i, i2, i3, i4, z, imageFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImageDecodeOptions newDecodeOptionForStrategy(ImageDecodeOptions imageDecodeOptions, EncodedImage encodedImage) {
        ImageDecodeOptionsBuilder imageDecodeOptionsBuilder = new ImageDecodeOptionsBuilder();
        imageDecodeOptionsBuilder.setFrom(imageDecodeOptions);
        imageDecodeOptionsBuilder.setBitmapConfig(getBitmapConfigForStrategy(imageDecodeOptions, encodedImage));
        return imageDecodeOptionsBuilder.build();
    }

    public static String parseEncodedImageInfo(EncodedImage encodedImage) {
        InputStream inputStream = encodedImage.getInputStream();
        byte[] bArr = new byte[64];
        try {
            try {
                inputStream.read(bArr);
            } catch (Throwable th) {
                try {
                    Closeables.close(inputStream, true);
                } catch (IOException unused) {
                }
                throw th;
            }
        } catch (IOException e) {
            FLog.m485w(TAG, e, "read encode Image 64 byte", new Object[0]);
        }
        try {
            Closeables.close(inputStream, true);
        } catch (IOException unused2) {
            return "ImageFormat:" + encodedImage.getImageFormat().getName() + ":" + Arrays.toString(bArr);
        }
    }
}
