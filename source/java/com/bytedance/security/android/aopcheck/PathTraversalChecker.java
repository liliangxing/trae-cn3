package com.bytedance.security.android.aopcheck;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.reporter.InfoMon;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* compiled from: PathTraversalChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010+H\u0007J\u0012\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010,H\u0007J\u0012\u0010)\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010.\u001a\u00020/2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00103\u001a\u00020/2\b\u0010*\u001a\u0004\u0018\u00010,H\u0007J\u0012\u00104\u001a\u00020/2\b\u0010*\u001a\u0004\u0018\u00010+H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001a\u0010&\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010¨\u00065"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PathTraversalChecker;", "", "()V", "PathTraversalActionTypeArg1", "", "getPathTraversalActionTypeArg1", "()Ljava/lang/String;", "PathTraversalActionTypeArg2", "getPathTraversalActionTypeArg2", "PathTraversalActionTypeUri", "getPathTraversalActionTypeUri", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableContentResolverIntercept", "getEnableContentResolverIntercept", "setEnableContentResolverIntercept", "enableFileInputStreamIntercept", "getEnableFileInputStreamIntercept", "setEnableFileInputStreamIntercept", "enableFileIntercept", "getEnableFileIntercept", "setEnableFileIntercept", "enableFileOutputStreamIntercept", "getEnableFileOutputStreamIntercept", "setEnableFileOutputStreamIntercept", "enableFileReaderIntercept", "getEnableFileReaderIntercept", "setEnableFileReaderIntercept", "enableFileWriterIntercept", "getEnableFileWriterIntercept", "setEnableFileWriterIntercept", "enableIntercept", "getEnableIntercept", "setEnableIntercept", "enableZipFileIntercept", "getEnableZipFileIntercept", "setEnableZipFileIntercept", "check", "uri", "Landroid/net/Uri;", "Ljava/net/URI;", "path", "check1", "", "check2", "parent", "child", "checkURI", "checkUri", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class PathTraversalChecker {
    private static boolean enableContentResolverIntercept;
    private static boolean enableFileInputStreamIntercept;
    private static boolean enableFileIntercept;
    private static boolean enableFileOutputStreamIntercept;
    private static boolean enableFileReaderIntercept;
    private static boolean enableFileWriterIntercept;
    private static boolean enableIntercept;
    private static boolean enableZipFileIntercept;
    public static final PathTraversalChecker INSTANCE = new PathTraversalChecker();
    private static final String PathTraversalActionTypeArg1 = PathTraversalActionTypeArg1;
    private static final String PathTraversalActionTypeArg1 = PathTraversalActionTypeArg1;
    private static final String PathTraversalActionTypeArg2 = PathTraversalActionTypeArg2;
    private static final String PathTraversalActionTypeArg2 = PathTraversalActionTypeArg2;
    private static final String PathTraversalActionTypeUri = PathTraversalActionTypeUri;
    private static final String PathTraversalActionTypeUri = PathTraversalActionTypeUri;
    private static boolean enable = true;

    @JvmStatic
    public static final void check1(String path) {
    }

    @JvmStatic
    public static final void check2(String parent, String child) {
    }

    @JvmStatic
    public static final void checkURI(URI uri) {
    }

    @JvmStatic
    public static final void checkUri(Uri uri) {
    }

    private PathTraversalChecker() {
    }

    public final String getPathTraversalActionTypeArg1() {
        return PathTraversalActionTypeArg1;
    }

    public final String getPathTraversalActionTypeArg2() {
        return PathTraversalActionTypeArg2;
    }

    public final String getPathTraversalActionTypeUri() {
        return PathTraversalActionTypeUri;
    }

    public final boolean getEnableIntercept() {
        return enableIntercept;
    }

    public final void setEnableIntercept(boolean z) {
        enableIntercept = z;
    }

    public final boolean getEnableFileIntercept() {
        return enableFileIntercept;
    }

    public final void setEnableFileIntercept(boolean z) {
        enableFileIntercept = z;
    }

    public final boolean getEnableFileInputStreamIntercept() {
        return enableFileInputStreamIntercept;
    }

    public final void setEnableFileInputStreamIntercept(boolean z) {
        enableFileInputStreamIntercept = z;
    }

    public final boolean getEnableFileOutputStreamIntercept() {
        return enableFileOutputStreamIntercept;
    }

    public final void setEnableFileOutputStreamIntercept(boolean z) {
        enableFileOutputStreamIntercept = z;
    }

    public final boolean getEnableFileReaderIntercept() {
        return enableFileReaderIntercept;
    }

    public final void setEnableFileReaderIntercept(boolean z) {
        enableFileReaderIntercept = z;
    }

    public final boolean getEnableFileWriterIntercept() {
        return enableFileWriterIntercept;
    }

    public final void setEnableFileWriterIntercept(boolean z) {
        enableFileWriterIntercept = z;
    }

    public final boolean getEnableZipFileIntercept() {
        return enableZipFileIntercept;
    }

    public final void setEnableZipFileIntercept(boolean z) {
        enableZipFileIntercept = z;
    }

    public final boolean getEnableContentResolverIntercept() {
        return enableContentResolverIntercept;
    }

    public final void setEnableContentResolverIntercept(boolean z) {
        enableContentResolverIntercept = z;
    }

    public final boolean getEnable() {
        return enable;
    }

    public final void setEnable(boolean z) {
        enable = z;
    }

    @JvmStatic
    public static final boolean check(String path) {
        if (path == null || !enable) {
            return false;
        }
        if (!StringsKt.startsWith$default(path, "../", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) path, (CharSequence) "/../", false, 2, (Object) null)) {
            return false;
        }
        InfoMon.doPathTraversalReport(path, "", PathTraversalActionTypeArg1);
        return true;
    }

    @JvmStatic
    public static final boolean check(URI uri) {
        if (uri == null) {
            return false;
        }
        return check(uri.getPath());
    }

    @JvmStatic
    public static final boolean check(Uri uri) {
        String path;
        if (uri == null || (path = uri.getPath()) == null) {
            return false;
        }
        return check(path);
    }
}
