package com.bytedance.security.android.aopcheck;

import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PolarisFileOutputStreamWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u0017\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bB\u000f\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileOutputStreamWrapper;", "Ljava/io/FileOutputStream;", "name", "", "(Ljava/lang/String;)V", "append", "", "(Ljava/lang/String;Z)V", MessagePart.TYPE_FILE, "Ljava/io/File;", "(Ljava/io/File;)V", "(Ljava/io/File;Z)V", "fd", "Ljava/io/FileDescriptor;", "(Ljava/io/FileDescriptor;)V", "Companion", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class PolarisFileOutputStreamWrapper extends FileOutputStream {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisFileOutputStreamWrapper(String str) {
        super(INSTANCE.sanitizeFileName(str));
        Intrinsics.checkParameterIsNotNull(str, "name");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisFileOutputStreamWrapper(String str, boolean z) {
        super(INSTANCE.sanitizeFileName(str), z);
        Intrinsics.checkParameterIsNotNull(str, "name");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisFileOutputStreamWrapper(File file) {
        super(INSTANCE.sanitizeFile(file));
        Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisFileOutputStreamWrapper(File file, boolean z) {
        super(INSTANCE.sanitizeFile(file), z);
        Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolarisFileOutputStreamWrapper(FileDescriptor fileDescriptor) {
        super(fileDescriptor);
        Intrinsics.checkParameterIsNotNull(fileDescriptor, "fd");
    }

    /* compiled from: PolarisFileOutputStreamWrapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/security/android/aopcheck/PolarisFileOutputStreamWrapper$Companion;", "", "()V", "sanitizeFile", "Ljava/io/File;", MessagePart.TYPE_FILE, "sanitizeFileName", "", "name", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String sanitizeFileName(String name) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            return (PathTraversalChecker.check(name) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableFileOutputStreamIntercept()) ? StringsKt.replace$default(name, "../", "", false, 4, (Object) null) : name;
        }

        public final File sanitizeFile(File file) {
            Intrinsics.checkParameterIsNotNull(file, MessagePart.TYPE_FILE);
            if (!PathTraversalChecker.check(file.getAbsolutePath()) || !PathTraversalChecker.INSTANCE.getEnableIntercept() || !PathTraversalChecker.INSTANCE.getEnableFileOutputStreamIntercept()) {
                return file;
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
            return new File(StringsKt.replace$default(absolutePath, "../", "", false, 4, (Object) null));
        }
    }
}
