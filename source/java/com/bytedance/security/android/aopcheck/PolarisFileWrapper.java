package com.bytedance.security.android.aopcheck;

import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PolarisFileWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileWrapper;", "Ljava/io/File;", "pathname", "", "(Ljava/lang/String;)V", "parent", "child", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/io/File;Ljava/lang/String;)V", "uri", "Ljava/net/URI;", "(Ljava/net/URI;)V", "Companion", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class PolarisFileWrapper extends File {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisFileWrapper(String str) {
        super(INSTANCE.sanitize(str));
        Intrinsics.checkParameterIsNotNull(str, "pathname");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PolarisFileWrapper(String str, String str2) {
        super(r0.sanitizeNull(str), r0.sanitize(str2));
        Intrinsics.checkParameterIsNotNull(str2, "child");
        Companion companion = INSTANCE;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PolarisFileWrapper(File file, String str) {
        super(r0.sanitizeFile(file), r0.sanitize(str));
        Intrinsics.checkParameterIsNotNull(str, "child");
        Companion companion = INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisFileWrapper(URI uri) {
        super(INSTANCE.sanitzeURI(uri));
        Intrinsics.checkParameterIsNotNull(uri, "uri");
    }

    /* compiled from: PolarisFileWrapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileWrapper$Companion;", "", "()V", "sanitize", "", "path", "sanitizeFile", "Ljava/io/File;", "parent", "sanitizeNull", "sanitzeURI", "Ljava/net/URI;", "uri", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String sanitize(String path) {
            Intrinsics.checkParameterIsNotNull(path, "path");
            return (PathTraversalChecker.check(path) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableFileIntercept()) ? StringsKt.replace$default(path, "../", "", false, 4, (Object) null) : path;
        }

        public final File sanitizeFile(File parent) {
            if (parent == null || !PathTraversalChecker.check(parent.getAbsolutePath()) || !PathTraversalChecker.INSTANCE.getEnableIntercept() || !PathTraversalChecker.INSTANCE.getEnableFileIntercept()) {
                return parent;
            }
            String absolutePath = parent.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "parent.absolutePath");
            return new File(StringsKt.replace$default(absolutePath, "../", "", false, 4, (Object) null));
        }

        public final String sanitizeNull(String path) {
            if (path == null) {
                return null;
            }
            return sanitize(path);
        }

        public final URI sanitzeURI(URI uri) {
            String path;
            Intrinsics.checkParameterIsNotNull(uri, "uri");
            if (!PathTraversalChecker.check(uri) || !PathTraversalChecker.INSTANCE.getEnable() || !PathTraversalChecker.INSTANCE.getEnableIntercept() || !PathTraversalChecker.INSTANCE.getEnableFileIntercept()) {
                return uri;
            }
            String path2 = uri.getPath();
            if (path2 == null || (path = StringsKt.replace$default(path2, "../", "", false, 4, (Object) null)) == null) {
                path = uri.getPath();
            }
            return new URI(uri.getScheme(), uri.getHost(), path, uri.getFragment());
        }
    }
}
