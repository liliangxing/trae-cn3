package com.bytedance.forest.utils;

import android.text.TextUtils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* compiled from: LoaderUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J9\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0016H\u0086\bJ9\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00130\u0016H\u0086\bJ\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0006J\f\u0010\u001d\u001a\u00020\u0004*\u0004\u0018\u00010\u0006J\n\u0010\u001e\u001a\u00020\u0013*\u00020\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/forest/utils/LoaderUtils;", "", "()V", "checkFileExists", "", "path", "", "createFile", "Ljava/io/File;", "isFile", "getFileSize", "", "f", "loadInputStreamAsByteArray", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "loadInputStreamAsByteArray$forest_release", "readFile", "", "file", "resolve", "Lkotlin/Function1;", "reject", "", "readStream", "inputStream", "Ljava/io/InputStream;", "getUrlWithoutParams", "isNotNullOrEmpty", "saveClose", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LoaderUtils {
    public static final LoaderUtils INSTANCE = new LoaderUtils();

    private LoaderUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] loadInputStreamAsByteArray$forest_release(Response response) {
        byte[] bArr;
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        if (!response.getIsSucceed()) {
            return null;
        }
        if (response.getFrom() == ResourceFrom.MEMORY) {
            LogUtils.e$default(LogUtils.INSTANCE, null, "resource from memory but call loadAsBytes", null, true, null, null, null, 112, null);
            response.getErrorInfo().setError(ErrorInfo.Type.Memory, 2, "resource from memory but call loadAsBytes");
            response.setFrom(response.getOriginFrom());
        }
        Forest forest = response.getRequest().getForest();
        InputStream provideInputStream = response.provideInputStream();
        if (provideInputStream != null) {
            InputStream inputStream = provideInputStream;
            try {
                try {
                    bArr = ByteStreamsKt.readBytes(inputStream);
                    try {
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        Integer.valueOf(LogUtils.e$default(LogUtils.INSTANCE, null, "error occurs when read data", th, true, null, null, null, 112, null));
                        CloseableKt.closeFinally(inputStream, (Throwable) null);
                        if (bArr == null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bArr = null;
                }
                CloseableKt.closeFinally(inputStream, (Throwable) null);
            } finally {
            }
        } else {
            bArr = null;
        }
        if (bArr == null) {
            return bArr;
        }
        forest.getMemoryManager().removeCache(response.getRequest().getCacheKey$forest_release());
        return null;
    }

    public final File createFile(String path, boolean isFile) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        if (path == null) {
            path = "";
        }
        File file = new File(path);
        if (!file.exists()) {
            if (!isFile) {
                file.mkdirs();
            } else {
                try {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    public final boolean checkFileExists(String path) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return new File(path).exists();
    }

    public final boolean isNotNullOrEmpty(String str) {
        return str != null && str.length() > 0;
    }

    public final String getUrlWithoutParams(String str) {
        List split$default;
        if (str == null || (split$default = StringsKt.split$default(str, new String[]{"?"}, false, 0, 6, (Object) null)) == null || !(!split$default.isEmpty())) {
            return null;
        }
        return (String) split$default.get(0);
    }

    public final double getFileSize(File f) {
        int i;
        FileInputStream fileInputStream;
        Intrinsics.checkParameterIsNotNull(f, "f");
        if (f.exists() && !f.isDirectory()) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(f);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                i = fileInputStream.available();
                saveClose(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    saveClose(fileInputStream2);
                }
                i = 0;
                return MathKt.roundToInt((i / 1024.0d) * 100) / 100.0d;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    saveClose(fileInputStream2);
                }
                throw th;
            }
            return MathKt.roundToInt((i / 1024.0d) * 100) / 100.0d;
        }
        i = 0;
        return MathKt.roundToInt((i / 1024.0d) * 100) / 100.0d;
    }

    public final void saveClose(InputStream inputStream) {
        Intrinsics.checkParameterIsNotNull(inputStream, "$this$saveClose");
        try {
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void readFile(File file, Function1<? super byte[], Unit> resolve, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        Intrinsics.checkParameterIsNotNull(resolve, "resolve");
        Intrinsics.checkParameterIsNotNull(reject, "reject");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = fileInputStream;
            try {
                FileInputStream fileInputStream2 = byteArrayOutputStream;
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    ByteStreamsKt.copyTo$default(fileInputStream2, byteArrayOutputStream2, 0, 2, (Object) null);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    InlineMarker.finallyStart(1);
                    CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                    CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                    InlineMarker.finallyEnd(1);
                    bArr = byteArray;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            reject.invoke(new RuntimeException("Script decode error!", e));
        }
        if (bArr != null) {
            resolve.invoke(bArr);
        }
    }

    public final void readStream(InputStream inputStream, Function1<? super byte[], Unit> resolve, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        Intrinsics.checkParameterIsNotNull(resolve, "resolve");
        Intrinsics.checkParameterIsNotNull(reject, "reject");
        byte[] bArr = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = inputStream;
            try {
                InputStream inputStream2 = byteArrayOutputStream;
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    ByteStreamsKt.copyTo$default(inputStream2, byteArrayOutputStream2, 0, 2, (Object) null);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    InlineMarker.finallyStart(1);
                    CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                    CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                    InlineMarker.finallyEnd(1);
                    bArr = byteArray;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            reject.invoke(new RuntimeException("Script decode error!", e));
        }
        if (bArr != null) {
            resolve.invoke(bArr);
        }
    }
}
