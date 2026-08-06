package com.bytedance.sdk.xbridge.cn.media.utils;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AppFileUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u001c\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J#\u0010\u001b\u001a\u0004\u0018\u00010\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u001c\u0010\u001e\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\b\u001a\u00020\tJ\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u001f\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006J\u001f\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/utils/AppFileUtils;", "", "()V", "checkFileExists", "", "path", "", "copyFileToPrivateCacheDir", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "createFile", "Ljava/io/File;", "isFile", "getAbsoluteFilePath", "filePath", "getAbsoluteFilePaths", "Ljava/util/ArrayList;", "filePaths", "", "getOrCopiedFilePath", "getOrCopiedFilePaths", "hasAllReadPermission", "hasReadPermission", "hasReadPermissionForAbsolute", "hasReadPermissionOrExistsForContentUri", "isAllExternalOtherAppFile", "(Ljava/util/ArrayList;Landroid/content/Context;)Ljava/lang/Boolean;", "isAllFileExists", "isAllPrivateFile", "isAndroidQOrLater", "isExternalOtherAppFile", "(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/Boolean;", "isFileExists", "isPrivateFile", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppFileUtils {
    public static final AppFileUtils INSTANCE = new AppFileUtils();

    private AppFileUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019d A[Catch: IOException -> 0x01af, TRY_ENTER, TryCatch #5 {IOException -> 0x01af, blocks: (B:50:0x015a, B:51:0x015d, B:53:0x0162, B:55:0x0167, B:61:0x019d, B:63:0x01a2, B:65:0x01a7, B:67:0x01ac), top: B:35:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a2 A[Catch: IOException -> 0x01af, TryCatch #5 {IOException -> 0x01af, blocks: (B:50:0x015a, B:51:0x015d, B:53:0x0162, B:55:0x0167, B:61:0x019d, B:63:0x01a2, B:65:0x01a7, B:67:0x01ac), top: B:35:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a7 A[Catch: IOException -> 0x01af, TryCatch #5 {IOException -> 0x01af, blocks: (B:50:0x015a, B:51:0x015d, B:53:0x0162, B:55:0x0167, B:61:0x019d, B:63:0x01a2, B:65:0x01a7, B:67:0x01ac), top: B:35:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ac A[Catch: IOException -> 0x01af, TRY_LEAVE, TryCatch #5 {IOException -> 0x01af, blocks: (B:50:0x015a, B:51:0x015d, B:53:0x0162, B:55:0x0167, B:61:0x019d, B:63:0x01a2, B:65:0x01a7, B:67:0x01ac), top: B:35:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018a A[Catch: IOException -> 0x0197, TryCatch #1 {IOException -> 0x0197, blocks: (B:86:0x0185, B:75:0x018a, B:77:0x018f, B:79:0x0194), top: B:85:0x0185 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018f A[Catch: IOException -> 0x0197, TryCatch #1 {IOException -> 0x0197, blocks: (B:86:0x0185, B:75:0x018a, B:77:0x018f, B:79:0x0194), top: B:85:0x0185 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0194 A[Catch: IOException -> 0x0197, TRY_LEAVE, TryCatch #1 {IOException -> 0x0197, blocks: (B:86:0x0185, B:75:0x018a, B:77:0x018f, B:79:0x0194), top: B:85:0x0185 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getOrCopiedFilePath(Context context, String filePath) {
        Uri uri;
        Throwable th;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel2;
        FileChannel fileChannel3;
        Uri uri2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Uri parse = Uri.parse(filePath);
        FileInputStream fileInputStream = null;
        r4 = null;
        FileChannel fileChannel4 = null;
        FileInputStream fileInputStream2 = null;
        if (parse == null) {
            return null;
        }
        String scheme = parse.getScheme();
        String str = scheme;
        if ((str == null || str.length() == 0) != false || Intrinsics.areEqual(scheme, MessagePart.TYPE_FILE)) {
            return parse.getPath();
        }
        if (DocumentsContract.isDocumentUri(context, parse) && Intrinsics.areEqual(FConstants.MEDIA_DOCUMENTS, parse.getAuthority())) {
            String documentId = DocumentsContract.getDocumentId(parse);
            Intrinsics.checkNotNullExpressionValue(documentId, "getDocumentId(uri)");
            List split$default = StringsKt.split$default(documentId, new String[]{":"}, false, 0, 6, (Object) null);
            String str2 = (String) split$default.get(0);
            if (TextUtils.equals("image", str2)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                if (isAndroidQOrLater()) {
                    uri2 = MediaStore.Images.Media.getContentUri("external_primary");
                }
            } else if (TextUtils.equals("video", str2)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                if (isAndroidQOrLater()) {
                    uri2 = MediaStore.Video.Media.getContentUri("external_primary");
                }
            } else if (TextUtils.equals(FConstants.URI_AUDIO, str2)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                if (isAndroidQOrLater()) {
                    uri2 = MediaStore.Audio.Media.getContentUri("external_primary");
                }
            } else {
                uri2 = null;
            }
            if (TextUtils.isEmpty((CharSequence) split$default.get(1))) {
                return null;
            }
            Intrinsics.checkNotNull(uri2);
            uri = ContentUris.withAppendedId(uri2, Long.parseLong((String) split$default.get(1)));
        } else {
            uri = null;
        }
        if (Intrinsics.areEqual(scheme, ReportConstant.COMMON_CONTENT) && Intrinsics.areEqual("media", parse.getAuthority())) {
            uri = parse;
        }
        if (uri != null) {
            String str3 = context.getCacheDir().getAbsolutePath() + "/tools/temMedia/" + System.currentTimeMillis();
            if (!checkFileExists(str3)) {
                createFile(str3, true);
            }
            try {
                try {
                    AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r", null);
                    FileInputStream createInputStream = openAssetFileDescriptor != null ? openAssetFileDescriptor.createInputStream() : null;
                    try {
                        fileOutputStream = new FileOutputStream(str3);
                        if (createInputStream != null) {
                            try {
                                fileChannel2 = createInputStream.getChannel();
                            } catch (Exception unused) {
                                fileChannel3 = null;
                                fileChannel2 = null;
                                fileInputStream2 = createInputStream;
                                if (fileInputStream2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (fileChannel2 != null) {
                                }
                                if (fileChannel3 != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileChannel = null;
                                fileChannel2 = null;
                                fileInputStream = createInputStream;
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (fileChannel2 != null) {
                                }
                                if (fileChannel == null) {
                                }
                            }
                        } else {
                            fileChannel2 = null;
                        }
                        try {
                            fileChannel4 = fileOutputStream.getChannel();
                            if (fileChannel2 != null) {
                                fileChannel2.transferTo(0L, fileChannel2.size(), fileChannel4);
                            }
                            if (createInputStream != null) {
                                createInputStream.close();
                            }
                            fileOutputStream.close();
                            if (fileChannel2 != null) {
                                fileChannel2.close();
                            }
                            if (fileChannel4 != null) {
                                fileChannel4.close();
                            }
                            return str3;
                        } catch (Exception unused2) {
                            fileChannel3 = fileChannel4;
                            fileInputStream2 = createInputStream;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileChannel2 != null) {
                                fileChannel2.close();
                            }
                            if (fileChannel3 != null) {
                                return "";
                            }
                            fileChannel3.close();
                            return "";
                        } catch (Throwable th3) {
                            th = th3;
                            fileChannel = fileChannel4;
                            fileInputStream = createInputStream;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused3) {
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (fileChannel2 != null) {
                                fileChannel2.close();
                            }
                            if (fileChannel == null) {
                                fileChannel.close();
                                throw th;
                            }
                            throw th;
                        }
                    } catch (Exception unused4) {
                        fileChannel3 = null;
                        fileOutputStream = null;
                        fileChannel2 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileChannel = null;
                        fileOutputStream = null;
                        fileChannel2 = null;
                    }
                } catch (IOException unused5) {
                    return "";
                }
            } catch (Exception unused6) {
                fileChannel3 = null;
                fileOutputStream = null;
                fileChannel2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileChannel = null;
                fileOutputStream = null;
                fileChannel2 = null;
            }
        } else {
            return BdFileUtils.convertUriToPath(context, parse);
        }
    }

    public final ArrayList<String> getOrCopiedFilePaths(Context context, List<String> filePaths) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePaths, "filePaths");
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<T> it = filePaths.iterator();
        while (it.hasNext()) {
            String orCopiedFilePath = INSTANCE.getOrCopiedFilePath(context, (String) it.next());
            if (orCopiedFilePath != null) {
                arrayList.add(orCopiedFilePath);
            }
        }
        return arrayList;
    }

    public final Boolean isPrivateFile(String filePath, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean bool = false;
        String str = filePath;
        if (str == null || str.length() == 0) {
            return null;
        }
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        String parent = context.getCacheDir().getParent();
        File externalCacheDir = context.getExternalCacheDir();
        String parent2 = externalCacheDir != null ? externalCacheDir.getParent() : null;
        Intrinsics.checkNotNullExpressionValue(parent, "dataPrivateFilePath");
        ArrayList<String> arrayListOf = CollectionsKt.arrayListOf(new String[]{parent});
        arrayListOf.add("/data/data/" + context.getPackageName());
        arrayListOf.add("/sdcard/Android/data/" + context.getPackageName());
        if (parent2 != null) {
            if (parent2.length() > 0) {
                arrayListOf.add(parent2);
            }
        }
        for (String str2 : arrayListOf) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "fileTarget.absolutePath");
            if (StringsKt.startsWith$default(absolutePath, str2, false, 2, (Object) null)) {
                bool = true;
            }
        }
        return bool;
    }

    public final boolean isAllPrivateFile(ArrayList<String> filePaths, Context context) {
        Intrinsics.checkNotNullParameter(filePaths, "filePaths");
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<T> it = filePaths.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(INSTANCE.isPrivateFile((String) it.next(), context), true)) {
                z = false;
            }
        }
        return z;
    }

    public final Boolean isExternalOtherAppFile(String filePath, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = filePath;
        if (str == null || str.length() == 0) {
            return null;
        }
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "fileTarget.absolutePath");
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        if (!StringsKt.contains$default(absolutePath, packageName, false, 2, (Object) null)) {
            String absolutePath2 = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "fileTarget.absolutePath");
            if (StringsKt.startsWith$default(absolutePath2, "/storage/emulated", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public final Boolean isAllExternalOtherAppFile(ArrayList<String> filePaths, Context context) {
        Intrinsics.checkNotNullParameter(filePaths, "filePaths");
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<T> it = filePaths.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(INSTANCE.isExternalOtherAppFile((String) it.next(), context), true)) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }

    private final boolean checkFileExists(String path) {
        if (path.length() == 0) {
            return false;
        }
        return new File(path).exists();
    }

    private final File createFile(String path, boolean isFile) {
        if (!(path.length() > 0)) {
            return null;
        }
        File file = new File(path);
        if (!file.exists()) {
            if (!isFile) {
                file.mkdirs();
            } else {
                try {
                    Result.Companion companion = Result.Companion;
                    AppFileUtils appFileUtils = this;
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    Result.constructor-impl(Boolean.valueOf(file.createNewFile()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
            }
        }
        return file;
    }

    private final boolean isAndroidQOrLater() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public final boolean hasAllReadPermission(Context context, List<String> filePaths) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePaths, "filePaths");
        Iterator<T> it = filePaths.iterator();
        while (it.hasNext()) {
            if (!INSTANCE.hasReadPermission(context, (String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean hasReadPermission(Context context, String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Uri parse = Uri.parse(filePath);
        String scheme = parse.getScheme();
        String str = scheme;
        if ((str == null || str.length() == 0) || Intrinsics.areEqual(scheme, MessagePart.TYPE_FILE)) {
            return hasReadPermissionForAbsolute(parse.getPath());
        }
        if (!Intrinsics.areEqual(scheme, ReportConstant.COMMON_CONTENT)) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(parse, "uri");
        return hasReadPermissionOrExistsForContentUri(context, parse);
    }

    private final boolean hasReadPermissionForAbsolute(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return false;
        }
        File file = new File(filePath);
        return file.exists() && file.canRead();
    }

    private final boolean hasReadPermissionOrExistsForContentUri(Context context, Uri uri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return false;
            }
            openInputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final ArrayList<String> getAbsoluteFilePaths(Context context, List<String> filePaths) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePaths, "filePaths");
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<T> it = filePaths.iterator();
        while (it.hasNext()) {
            String absoluteFilePath = INSTANCE.getAbsoluteFilePath(context, (String) it.next());
            if (absoluteFilePath != null) {
                arrayList.add(absoluteFilePath);
            }
        }
        return arrayList;
    }

    public final String getAbsoluteFilePath(Context context, String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Uri parse = Uri.parse(filePath);
        String scheme = parse.getScheme();
        String str = scheme;
        if ((str == null || str.length() == 0) || Intrinsics.areEqual(scheme, MessagePart.TYPE_FILE)) {
            return parse.getPath();
        }
        if (!Intrinsics.areEqual(scheme, ReportConstant.COMMON_CONTENT)) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(parse, "uri");
        return copyFileToPrivateCacheDir(context, parse);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1 A[Catch: IOException -> 0x00be, TryCatch #11 {IOException -> 0x00be, blocks: (B:36:0x00ac, B:25:0x00b1, B:27:0x00b6, B:29:0x00bb), top: B:35:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6 A[Catch: IOException -> 0x00be, TryCatch #11 {IOException -> 0x00be, blocks: (B:36:0x00ac, B:25:0x00b1, B:27:0x00b6, B:29:0x00bb), top: B:35:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb A[Catch: IOException -> 0x00be, TRY_LEAVE, TryCatch #11 {IOException -> 0x00be, blocks: (B:36:0x00ac, B:25:0x00b1, B:27:0x00b6, B:29:0x00bb), top: B:35:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098 A[Catch: IOException -> 0x00a5, TryCatch #8 {IOException -> 0x00a5, blocks: (B:50:0x0093, B:41:0x0098, B:43:0x009d, B:45:0x00a2), top: B:49:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009d A[Catch: IOException -> 0x00a5, TryCatch #8 {IOException -> 0x00a5, blocks: (B:50:0x0093, B:41:0x0098, B:43:0x009d, B:45:0x00a2), top: B:49:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2 A[Catch: IOException -> 0x00a5, TRY_LEAVE, TryCatch #8 {IOException -> 0x00a5, blocks: (B:50:0x0093, B:41:0x0098, B:43:0x009d, B:45:0x00a2), top: B:49:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String copyFileToPrivateCacheDir(Context context, Uri uri) {
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileInputStream fileInputStream;
        FileChannel fileChannel3;
        ?? r12;
        String str = context.getCacheDir().getAbsolutePath() + "/tools/temMedia/" + System.currentTimeMillis();
        if (!checkFileExists(str)) {
            createFile(str, true);
        }
        FileInputStream fileInputStream2 = null;
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r", null);
            if (openAssetFileDescriptor == null) {
                return null;
            }
            fileInputStream = openAssetFileDescriptor.createInputStream();
            try {
                r12 = new FileOutputStream(str);
                if (fileInputStream != null) {
                    try {
                        fileChannel = fileInputStream.getChannel();
                    } catch (Exception unused) {
                        fileChannel = null;
                        r12 = r12;
                        fileChannel2 = fileChannel;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                                return null;
                            }
                        }
                        if (r12 != 0) {
                            r12.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (fileChannel2 == null) {
                            return null;
                        }
                        fileChannel2.close();
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileChannel = null;
                        r12 = r12;
                        fileChannel2 = fileChannel;
                        fileInputStream2 = fileInputStream;
                        fileOutputStream = r12;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused3) {
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        throw th;
                    }
                } else {
                    fileChannel = null;
                }
                try {
                    fileChannel2 = r12.getChannel();
                    if (fileChannel != null) {
                        try {
                            fileChannel.transferTo(0L, fileChannel.size(), fileChannel2);
                        } catch (Exception unused4) {
                            if (fileInputStream != null) {
                            }
                            if (r12 != 0) {
                            }
                            if (fileChannel != null) {
                            }
                            if (fileChannel2 == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream2 = fileInputStream;
                            fileOutputStream = r12;
                            if (fileInputStream2 != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (fileChannel != null) {
                            }
                            if (fileChannel2 != null) {
                            }
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                            str = null;
                        }
                    }
                    r12.close();
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    return str;
                } catch (Exception unused6) {
                    fileChannel2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel2 = null;
                }
            } catch (Exception unused7) {
                fileChannel3 = null;
                fileChannel = fileChannel3;
                r12 = fileChannel3;
                fileChannel2 = fileChannel;
                if (fileInputStream != null) {
                }
                if (r12 != 0) {
                }
                if (fileChannel != null) {
                }
                if (fileChannel2 == null) {
                }
            } catch (Throwable th4) {
                th = th4;
                r12 = 0;
                fileChannel = null;
            }
        } catch (Exception unused8) {
            fileInputStream = null;
            fileChannel3 = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            fileChannel = null;
            fileChannel2 = null;
        }
    }

    public final boolean isFileExists(Context context, String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Uri parse = Uri.parse(filePath);
        String scheme = parse.getScheme();
        String str = scheme;
        boolean z = true;
        if ((str == null || str.length() == 0) || Intrinsics.areEqual(scheme, MessagePart.TYPE_FILE)) {
            String path = parse.getPath();
            String str2 = path;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (z) {
                return false;
            }
            return new File(path).exists();
        }
        if (!Intrinsics.areEqual(scheme, ReportConstant.COMMON_CONTENT)) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(parse, "uri");
        return hasReadPermissionOrExistsForContentUri(context, parse);
    }

    public final boolean isAllFileExists(Context context, List<String> filePaths) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePaths, "filePaths");
        Iterator<T> it = filePaths.iterator();
        while (it.hasNext()) {
            if (!INSTANCE.isFileExists(context, (String) it.next())) {
                return false;
            }
        }
        return true;
    }
}
