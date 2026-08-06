package com.bytedance.trae.conversation.imageupload;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* compiled from: ImageUploadConstants.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;", "", "<init>", "()V", "ACCEPTED_EXTENSIONS", "", "", "getACCEPTED_EXTENSIONS", "()Ljava/util/Set;", "MAX_FILE_SIZE_MB", "", "MAX_FILE_SIZE_BYTES", "", "MIN_IMAGE_DIMENSION", "MIN_PIXEL_COUNT", "MAX_PIXEL_COUNT", "ASPECT_RATIO_LIMIT", "MIN_ASPECT_RATIO", "", "MAX_ASPECT_RATIO", "MAX_IMAGE_COUNT", "UPLOAD_TIMEOUT_MS", "TOKEN_SAFETY_THRESHOLD_MS", "TOKEN_EXPIRY_THRESHOLD_MS", "COMPRESSION_SIZE_THRESHOLD_BYTES", "COMPRESSION_DIMENSION_THRESHOLD", "COMPRESSION_TARGET_SIZE_BYTES", "UPLOAD_MAX_RETRIES", "UPLOAD_RETRY_DELAY_BASE_MS", "UPLOAD_CONCURRENCY", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageUploadConstants {
    private static final int ASPECT_RATIO_LIMIT = 150;
    public static final int COMPRESSION_DIMENSION_THRESHOLD = 2048;
    public static final long COMPRESSION_SIZE_THRESHOLD_BYTES = 1048576;
    public static final long COMPRESSION_TARGET_SIZE_BYTES = 1048576;
    public static final double MAX_ASPECT_RATIO = 150.0d;
    public static final long MAX_FILE_SIZE_BYTES = 20971520;
    public static final int MAX_FILE_SIZE_MB = 20;
    public static final int MAX_IMAGE_COUNT = 5;
    public static final long MAX_PIXEL_COUNT = 36000000;
    public static final double MIN_ASPECT_RATIO = 0.006666666666666667d;
    public static final int MIN_IMAGE_DIMENSION = 14;
    public static final long MIN_PIXEL_COUNT = 196;
    public static final long TOKEN_EXPIRY_THRESHOLD_MS = 60000;
    public static final long TOKEN_SAFETY_THRESHOLD_MS = 300000;
    public static final int UPLOAD_CONCURRENCY = 3;
    public static final int UPLOAD_MAX_RETRIES = 0;
    public static final long UPLOAD_RETRY_DELAY_BASE_MS = 1000;
    public static final long UPLOAD_TIMEOUT_MS = 60000;
    public static final ImageUploadConstants INSTANCE = new ImageUploadConstants();
    private static final Set<String> ACCEPTED_EXTENSIONS = SetsKt.setOf((Object[]) new String[]{".jpg", ".jpeg", ".png", ".gif", ".webp"});

    private ImageUploadConstants() {
    }

    public final Set<String> getACCEPTED_EXTENSIONS() {
        return ACCEPTED_EXTENSIONS;
    }
}
