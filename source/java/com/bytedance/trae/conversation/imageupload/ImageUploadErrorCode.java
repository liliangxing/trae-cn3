package com.bytedance.trae.conversation.imageupload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_FORMAT", "FILE_TOO_LARGE", "DIMENSION_TOO_SMALL", "PIXEL_COUNT_INVALID", "ASPECT_RATIO_INVALID", "TOO_MANY_IMAGES", "TOKEN_FETCH_FAILED", "UPLOAD_FAILED", "COMPRESSION_FAILED", "CONTENT_CHECK_FAILED", "NETWORK_ERROR", "TIMEOUT", "UNKNOWN", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageUploadErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ImageUploadErrorCode[] $VALUES;
    public static final ImageUploadErrorCode INVALID_FORMAT = new ImageUploadErrorCode("INVALID_FORMAT", 0);
    public static final ImageUploadErrorCode FILE_TOO_LARGE = new ImageUploadErrorCode("FILE_TOO_LARGE", 1);
    public static final ImageUploadErrorCode DIMENSION_TOO_SMALL = new ImageUploadErrorCode("DIMENSION_TOO_SMALL", 2);
    public static final ImageUploadErrorCode PIXEL_COUNT_INVALID = new ImageUploadErrorCode("PIXEL_COUNT_INVALID", 3);
    public static final ImageUploadErrorCode ASPECT_RATIO_INVALID = new ImageUploadErrorCode("ASPECT_RATIO_INVALID", 4);
    public static final ImageUploadErrorCode TOO_MANY_IMAGES = new ImageUploadErrorCode("TOO_MANY_IMAGES", 5);
    public static final ImageUploadErrorCode TOKEN_FETCH_FAILED = new ImageUploadErrorCode("TOKEN_FETCH_FAILED", 6);
    public static final ImageUploadErrorCode UPLOAD_FAILED = new ImageUploadErrorCode("UPLOAD_FAILED", 7);
    public static final ImageUploadErrorCode COMPRESSION_FAILED = new ImageUploadErrorCode("COMPRESSION_FAILED", 8);
    public static final ImageUploadErrorCode CONTENT_CHECK_FAILED = new ImageUploadErrorCode("CONTENT_CHECK_FAILED", 9);
    public static final ImageUploadErrorCode NETWORK_ERROR = new ImageUploadErrorCode("NETWORK_ERROR", 10);
    public static final ImageUploadErrorCode TIMEOUT = new ImageUploadErrorCode("TIMEOUT", 11);
    public static final ImageUploadErrorCode UNKNOWN = new ImageUploadErrorCode("UNKNOWN", 12);

    private static final /* synthetic */ ImageUploadErrorCode[] $values() {
        return new ImageUploadErrorCode[]{INVALID_FORMAT, FILE_TOO_LARGE, DIMENSION_TOO_SMALL, PIXEL_COUNT_INVALID, ASPECT_RATIO_INVALID, TOO_MANY_IMAGES, TOKEN_FETCH_FAILED, UPLOAD_FAILED, COMPRESSION_FAILED, CONTENT_CHECK_FAILED, NETWORK_ERROR, TIMEOUT, UNKNOWN};
    }

    public static EnumEntries<ImageUploadErrorCode> getEntries() {
        return $ENTRIES;
    }

    private ImageUploadErrorCode(String str, int i) {
    }

    static {
        ImageUploadErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ImageUploadErrorCode valueOf(String str) {
        return (ImageUploadErrorCode) Enum.valueOf(ImageUploadErrorCode.class, str);
    }

    public static ImageUploadErrorCode[] values() {
        return (ImageUploadErrorCode[]) $VALUES.clone();
    }
}
