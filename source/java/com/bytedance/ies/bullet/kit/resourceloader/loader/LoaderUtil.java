package com.bytedance.ies.bullet.kit.resourceloader.loader;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
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

/* compiled from: LoaderUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ<\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140\u0017H\u0086\bø\u0001\u0000J<\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00140\u0017H\u0086\bø\u0001\u0000J\u0012\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\u0004J\n\u0010\"\u001a\u00020\u0004*\u00020#J\u000e\u0010$\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0004J\f\u0010%\u001a\u00020\u000b*\u0004\u0018\u00010\u0004J\n\u0010&\u001a\u00020\u0014*\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/loader/LoaderUtil;", "", "()V", "AUTHORITY_ABSOLUTE", "", "SCHEMA_HTTP", "SCHEMA_HTTPS", "buildRawUri", "channel", SchemaConstants.QUERY_KEY_BUNDLE, "checkFileExists", "", "path", "createFile", "Ljava/io/File;", "isFile", "getFileSize", "", "f", "readFile", "", "file", "resolve", "Lkotlin/Function1;", "", "reject", "", "readStream", "inputStream", "Ljava/io/InputStream;", "getGeckoConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "ak", "getUriWithoutQuery", "Landroid/net/Uri;", "getUrlWithoutParams", "isNotNullOrEmpty", "saveClose", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LoaderUtil {
    public static final String AUTHORITY_ABSOLUTE = "absolute";
    public static final LoaderUtil INSTANCE = new LoaderUtil();
    private static final String SCHEMA_HTTP = "http";
    private static final String SCHEMA_HTTPS = "https";

    private LoaderUtil() {
    }

    public final GeckoConfig getGeckoConfig(ResourceLoaderConfig resourceLoaderConfig, String str) {
        Intrinsics.checkNotNullParameter(resourceLoaderConfig, "<this>");
        Intrinsics.checkNotNullParameter(str, "ak");
        GeckoConfig geckoConfig = resourceLoaderConfig.getGeckoConfigs().get(str);
        return geckoConfig == null ? resourceLoaderConfig.getDftGeckoCfg() : geckoConfig;
    }

    public final String getUriWithoutQuery(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (!uri.isHierarchical()) {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "toString()");
            return uri2;
        }
        try {
            String builder = uri.buildUpon().clearQuery().toString();
            Intrinsics.checkNotNullExpressionValue(builder, "{\n           buildUpon()…ry().toString()\n        }");
            return builder;
        } catch (Throwable unused) {
            String uri3 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri3, "{\n            toString()\n        }");
            return uri3;
        }
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
        Intrinsics.checkNotNullParameter(path, "path");
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

    public final String buildRawUri(String channel, String bundle) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(bundle, SchemaConstants.QUERY_KEY_BUNDLE);
        return bundle.length() == 0 ? channel : channel + '/' + StringsKt.removePrefix(bundle, "/");
    }

    public final double getFileSize(File f) {
        int i;
        FileInputStream fileInputStream;
        Intrinsics.checkNotNullParameter(f, "f");
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
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        try {
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void readFile(File file, Function1<? super byte[], Unit> resolve, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
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
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
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
