package com.bytedance.security.android.aopcheck;

import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.nio.charset.Charset;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PolarisZipFileWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u0017\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u0017\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eB\u001f\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisZipFileWrapper;", "Ljava/util/zip/ZipFile;", "name", "", "(Ljava/lang/String;)V", "charset", "Ljava/nio/charset/Charset;", "(Ljava/lang/String;Ljava/nio/charset/Charset;)V", MessagePart.TYPE_FILE, "Ljava/io/File;", "(Ljava/io/File;)V", "mode", "", "(Ljava/io/File;I)V", "(Ljava/io/File;Ljava/nio/charset/Charset;)V", "(Ljava/io/File;ILjava/nio/charset/Charset;)V", "Companion", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class PolarisZipFileWrapper extends ZipFile {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisZipFileWrapper(String str) {
        super(INSTANCE.sanitizeFileName(str));
        Intrinsics.checkParameterIsNotNull(str, "name");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisZipFileWrapper(String str, Charset charset) {
        super(INSTANCE.sanitizeFileName(str), charset);
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisZipFileWrapper(File file) {
        super(INSTANCE.sanitizeFile(file));
        Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisZipFileWrapper(File file, int i) {
        super(INSTANCE.sanitizeFile(file), i);
        Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisZipFileWrapper(File file, Charset charset) {
        super(INSTANCE.sanitizeFile(file), charset);
        Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
        Intrinsics.checkParameterIsNotNull(charset, "charset");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisZipFileWrapper(File file, int i, Charset charset) {
        super(INSTANCE.sanitizeFile(file), i, charset);
        Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
        Intrinsics.checkParameterIsNotNull(charset, "charset");
    }

    /* compiled from: PolarisZipFileWrapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisZipFileWrapper$Companion;", "", "()V", "sanitizeFile", "Ljava/io/File;", MessagePart.TYPE_FILE, "sanitizeFileName", "", "name", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String sanitizeFileName(String name) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            return (PathTraversalChecker.check(name) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableZipFileIntercept()) ? StringsKt.replace$default(name, "../", "", false, 4, (Object) null) : name;
        }

        public final File sanitizeFile(File file) {
            Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
            if (!PathTraversalChecker.check(file.getAbsolutePath()) || !PathTraversalChecker.INSTANCE.getEnableIntercept() || !PathTraversalChecker.INSTANCE.getEnableZipFileIntercept()) {
                return file;
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
            return new File(StringsKt.replace$default(absolutePath, "../", "", false, 4, (Object) null));
        }
    }
}
