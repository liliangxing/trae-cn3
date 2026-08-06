package com.bytedance.sdk.xbridge.cn.media.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import coil3.util.Utils_commonKt;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MediaUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nJ(\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/utils/MediaUtils;", "", "()V", "copyFileToGallery", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "path", "", "isImage", "", DBDefinition.MIME_TYPE, "inputUri", "copyFileToGalleryV2", "fixBridgeStorageAboveAndroidQ", "getImageMimeType", "url", "defaultType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaUtils {
    public static final MediaUtils INSTANCE = new MediaUtils();

    private MediaUtils() {
    }

    public final boolean fixBridgeStorageAboveAndroidQ() {
        return IConditionCallKt.fixBridgeStorage() && Build.VERSION.SDK_INT >= 29;
    }

    public final Uri copyFileToGallery(Context context, String path, boolean isImage) {
        Uri createVideoUri;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        if (isImage) {
            if (fixBridgeStorageAboveAndroidQ()) {
                createVideoUri = BDMediaFileUtils.createImageUriAboveAndroidQ(context, file.getName());
            } else {
                createVideoUri = BDMediaFileUtils.createImageUri(context, file.getName());
            }
        } else if (fixBridgeStorageAboveAndroidQ()) {
            createVideoUri = BDMediaFileUtils.createVideoUriAboveAndroidQ(context, file.getName());
        } else {
            createVideoUri = BDMediaFileUtils.createVideoUri(context, file.getName());
        }
        if (createVideoUri == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BDMediaFileUtils.copyFile(new FileInputStream(path), context.getContentResolver().openOutputStream(createVideoUri));
            Result.m10253constructorimpl(Boolean.valueOf(BDMediaFileUtils.removeFile(path)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (BDMediaFileUtils.isUriExists(context, createVideoUri)) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", createVideoUri));
        }
        return createVideoUri;
    }

    public final Uri copyFileToGallery(Context context, Uri inputUri, boolean isImage) {
        Uri createVideoUri;
        if (context == null || inputUri == null) {
            return null;
        }
        String valueOf = String.valueOf(new Date().getTime());
        if (isImage) {
            if (fixBridgeStorageAboveAndroidQ()) {
                createVideoUri = BDMediaFileUtils.createImageUriAboveAndroidQ(context, valueOf);
            } else {
                createVideoUri = BDMediaFileUtils.createImageUri(context, valueOf);
            }
        } else if (fixBridgeStorageAboveAndroidQ()) {
            createVideoUri = BDMediaFileUtils.createVideoUriAboveAndroidQ(context, valueOf);
        } else {
            createVideoUri = BDMediaFileUtils.createVideoUri(context, valueOf);
        }
        if (createVideoUri == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BDMediaFileUtils.copyFile(context.getContentResolver().openInputStream(inputUri), context.getContentResolver().openOutputStream(createVideoUri));
            Result.m10253constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (BDMediaFileUtils.isUriExists(context, createVideoUri)) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", createVideoUri));
        }
        return createVideoUri;
    }

    public final Uri copyFileToGallery(Context context, String path, boolean isImage, String mimeType) {
        Uri createVideoUri;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        File file = new File(path);
        if (isImage) {
            if (fixBridgeStorageAboveAndroidQ()) {
                createVideoUri = BDMediaFileUtils.createImageUriAboveAndroidQ(context, file.getName(), mimeType);
            } else {
                createVideoUri = BDMediaFileUtils.createImageUri(context, file.getName(), mimeType);
            }
        } else if (fixBridgeStorageAboveAndroidQ()) {
            createVideoUri = BDMediaFileUtils.createVideoUriAboveAndroidQ(context, file.getName(), mimeType);
        } else {
            createVideoUri = BDMediaFileUtils.createVideoUri(context, file.getName(), mimeType);
        }
        if (createVideoUri == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BDMediaFileUtils.copyFile(new FileInputStream(path), context.getContentResolver().openOutputStream(createVideoUri));
            Result.m10253constructorimpl(Boolean.valueOf(BDMediaFileUtils.removeFile(path)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (BDMediaFileUtils.isUriExists(context, createVideoUri)) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", createVideoUri));
        }
        return createVideoUri;
    }

    public final Uri copyFileToGalleryV2(Context context, String path, boolean isImage, String mimeType) {
        Uri createVideoUri;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        File file = new File(path);
        String str = BDMediaFileUtils.GALLEY_FOLDER_PATH + '/' + file.getName();
        if (isImage) {
            if (fixBridgeStorageAboveAndroidQ()) {
                createVideoUri = BDMediaFileUtils.createImageUriAboveAndroidQ(context, file.getName(), mimeType);
            } else {
                createVideoUri = BDMediaFileUtils.createImageUri(context, file.getName(), mimeType);
            }
        } else if (fixBridgeStorageAboveAndroidQ()) {
            createVideoUri = BDMediaFileUtils.createVideoUriAboveAndroidQ(context, file.getName(), mimeType);
        } else {
            createVideoUri = BDMediaFileUtils.createVideoUri(context, file.getName(), mimeType);
        }
        if (createVideoUri == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BDMediaFileUtils.copyFile(new FileInputStream(path), context.getContentResolver().openOutputStream(createVideoUri));
            Result.m10253constructorimpl(Boolean.valueOf(BDMediaFileUtils.removeFile(path)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (BDMediaFileUtils.isUriExists(context, createVideoUri)) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str))));
        }
        return createVideoUri;
    }

    public final String getImageMimeType(String url, String defaultType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(defaultType, "defaultType");
        return (StringsKt.endsWith$default(url, ".jpeg", false, 2, (Object) null) || StringsKt.endsWith$default(url, ".jpg", false, 2, (Object) null)) ? Utils_commonKt.MIME_TYPE_JPEG : StringsKt.endsWith$default(url, ".png", false, 2, (Object) null) ? "image/png" : StringsKt.endsWith$default(url, ".gif", false, 2, (Object) null) ? "image/gif" : StringsKt.endsWith$default(url, ".webp", false, 2, (Object) null) ? Utils_commonKt.MIME_TYPE_WEBP : StringsKt.endsWith$default(url, ".bmp", false, 2, (Object) null) ? "image/bmp" : StringsKt.endsWith$default(url, ".jpg2", false, 2, (Object) null) ? "image/jp2" : (StringsKt.endsWith$default(url, ".tif", false, 2, (Object) null) || StringsKt.endsWith$default(url, ".tiff", false, 2, (Object) null)) ? "image/tiff" : defaultType;
    }
}
