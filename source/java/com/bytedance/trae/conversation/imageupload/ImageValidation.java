package com.bytedance.trae.conversation.imageupload;

import android.graphics.BitmapFactory;
import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ImageValidation.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00052\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageValidation;", "", "<init>", "()V", "validateImageCount", "Lkotlin/Pair;", "Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;", "", "currentCount", "addCount", "validateFileFormat", MessagePart.TYPE_FILE, "Ljava/io/File;", "validateFileSize", "readImageDimension", "Lcom/bytedance/trae/conversation/imageupload/ImageDimension;", "validateDimension", "width", "height", "validateFile", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ImageValidation {
    public static final ImageValidation INSTANCE = new ImageValidation();

    private ImageValidation() {
    }

    public final Pair<FileValidationResult, Integer> validateImageCount(int currentCount, int addCount) {
        int i = 5 - currentCount;
        if (i <= 0) {
            return TuplesKt.to(new FileValidationResult(false, "Maximum 5 images allowed", ImageUploadErrorCode.TOO_MANY_IMAGES), 0);
        }
        if (addCount > i) {
            return TuplesKt.to(new FileValidationResult(true, "Only " + i + " more images allowed", null, 4, null), Integer.valueOf(i));
        }
        return TuplesKt.to(new FileValidationResult(true, null, null, 6, null), Integer.valueOf(addCount));
    }

    public final FileValidationResult validateFileFormat(File file) {
        String str;
        Intrinsics.checkNotNullParameter(file, MessagePart.TYPE_FILE);
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int lastIndexOf$default = StringsKt.lastIndexOf$default(lowerCase, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default >= 0) {
            str = lowerCase.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        } else {
            str = "";
        }
        if (!ImageUploadConstants.INSTANCE.getACCEPTED_EXTENSIONS().contains(str)) {
            return new FileValidationResult(false, "Unsupported image format", ImageUploadErrorCode.INVALID_FORMAT);
        }
        return new FileValidationResult(true, null, null, 6, null);
    }

    public final FileValidationResult validateFileSize(File file) {
        Intrinsics.checkNotNullParameter(file, MessagePart.TYPE_FILE);
        if (file.length() > ImageUploadConstants.MAX_FILE_SIZE_BYTES) {
            return new FileValidationResult(false, "Image size exceeds limit (max 20MB)", ImageUploadErrorCode.FILE_TOO_LARGE);
        }
        return new FileValidationResult(true, null, null, 6, null);
    }

    public final ImageDimension readImageDimension(File file) {
        Intrinsics.checkNotNullParameter(file, MessagePart.TYPE_FILE);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i <= 0 || i2 <= 0) {
            throw new ImageUploadException(ImageUploadErrorCode.INVALID_FORMAT, "Cannot decode image bounds", null, 4, null);
        }
        return new ImageDimension(i, i2);
    }

    public final FileValidationResult validateDimension(int width, int height) {
        if (width <= 14 || height <= 14) {
            return new FileValidationResult(false, "Image dimensions too small", ImageUploadErrorCode.DIMENSION_TOO_SMALL);
        }
        long j = width * height;
        if (j < 196 || j > ImageUploadConstants.MAX_PIXEL_COUNT) {
            return new FileValidationResult(false, "Image pixel count out of range", ImageUploadErrorCode.PIXEL_COUNT_INVALID);
        }
        double d = width / height;
        if (d < 0.006666666666666667d || d > 150.0d) {
            return new FileValidationResult(false, "Image aspect ratio out of range", ImageUploadErrorCode.ASPECT_RATIO_INVALID);
        }
        return new FileValidationResult(true, null, null, 6, null);
    }

    public final Pair<FileValidationResult, ImageDimension> validateFile(File file) {
        Intrinsics.checkNotNullParameter(file, MessagePart.TYPE_FILE);
        FileValidationResult validateFileFormat = validateFileFormat(file);
        if (!validateFileFormat.getValid()) {
            return TuplesKt.to(validateFileFormat, (Object) null);
        }
        FileValidationResult validateFileSize = validateFileSize(file);
        if (!validateFileSize.getValid()) {
            return TuplesKt.to(validateFileSize, (Object) null);
        }
        try {
            ImageDimension readImageDimension = readImageDimension(file);
            FileValidationResult validateDimension = validateDimension(readImageDimension.getWidth(), readImageDimension.getHeight());
            return !validateDimension.getValid() ? TuplesKt.to(validateDimension, readImageDimension) : TuplesKt.to(new FileValidationResult(true, null, null, 6, null), readImageDimension);
        } catch (Throwable unused) {
            return TuplesKt.to(new FileValidationResult(false, "Cannot read image dimension", ImageUploadErrorCode.INVALID_FORMAT), (Object) null);
        }
    }
}
