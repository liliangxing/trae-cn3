package com.bytedance.trae.kmp.artifact;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: AndroidKmpArtifactIo.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0016J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000b\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001cJ\u0016\u0010!\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;", "Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;", "root", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "createTemporaryFile", "Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", SchemaConstants.QUERY_KEY_PREFIX, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "file", "relativePath", "write", "", "bytes", "", "append", "", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;[BZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "offset", "", "length", "", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "metadata", "Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "list", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exists", "delete", "atomicReplace", EventConstants.PARAM_SOURCE, "destination", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;Lcom/bytedance/trae/kmp/artifact/KmpFileReference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touch", "modifiedAtMillis", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localUri", "reference", "resolve", "sanitize", "value", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpArtifactFileSystem implements KmpArtifactFileSystem {

    @Deprecated
    public static final String ROOT_DIRECTORY_NAME = "kmp-artifacts";
    private final File root;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AndroidKmpArtifactFileSystem(File file) {
        Intrinsics.checkNotNullParameter(file, "root");
        if (!(file.isDirectory() || file.mkdirs())) {
            throw new IllegalStateException("Check failed.");
        }
        this.root = file;
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public Object createTemporaryFile(String str, Continuation<? super KmpFileReference> continuation) {
        File createTempFile = File.createTempFile(sanitize(str), ".tmp", this.root);
        Intrinsics.checkNotNullExpressionValue(createTempFile, "createTempFile(...)");
        return reference(createTempFile);
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public KmpFileReference file(String relativePath) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return reference(resolve(relativePath));
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public Object write(KmpFileReference kmpFileReference, byte[] bArr, boolean z, Continuation<? super Unit> continuation) {
        File resolve = resolve(kmpFileReference);
        File parentFile = resolve.getParentFile();
        if (parentFile != null) {
            Boxing.boxBoolean(parentFile.mkdirs());
        }
        OutputStream fileOutputStream = new FileOutputStream(resolve, z);
        BufferedOutputStream bufferedOutputStream = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192);
        try {
            bufferedOutputStream.write(bArr);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedOutputStream, (Throwable) null);
            return Unit.INSTANCE;
        } finally {
        }
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public Object read(KmpFileReference kmpFileReference, long j, int i, Continuation<? super byte[]> continuation) {
        File resolve = resolve(kmpFileReference);
        if (!resolve.isFile() || i <= 0) {
            return new byte[0];
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(resolve, "r");
        try {
            RandomAccessFile randomAccessFile2 = randomAccessFile;
            long coerceIn = RangesKt.coerceIn(j, 0L, randomAccessFile2.length());
            randomAccessFile2.seek(coerceIn);
            byte[] bArr = new byte[(int) Math.min(i, randomAccessFile2.length() - coerceIn)];
            randomAccessFile2.readFully(bArr);
            CloseableKt.closeFinally(randomAccessFile, (Throwable) null);
            return bArr;
        } finally {
        }
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public Object metadata(KmpFileReference kmpFileReference, Continuation<? super KmpFileMetadata> continuation) {
        File resolve = resolve(kmpFileReference);
        if (resolve.isFile()) {
            return new KmpFileMetadata(resolve.length(), resolve.lastModified());
        }
        return null;
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public Object list(Continuation<? super List<KmpFileReference>> continuation) {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(FilesKt.walkTopDown(this.root), AndroidKmpArtifactFileSystem$list$2.INSTANCE), new AndroidKmpArtifactFileSystem$list$3(this)));
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public Object exists(KmpFileReference kmpFileReference, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(resolve(kmpFileReference).isFile());
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public Object delete(KmpFileReference kmpFileReference, Continuation<? super Boolean> continuation) {
        File resolve = resolve(kmpFileReference);
        return Boxing.boxBoolean(!resolve.exists() || resolve.delete());
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public Object atomicReplace(KmpFileReference kmpFileReference, KmpFileReference kmpFileReference2, Continuation<? super Unit> continuation) {
        File resolve = resolve(kmpFileReference);
        File resolve2 = resolve(kmpFileReference2);
        File parentFile = resolve2.getParentFile();
        if (parentFile != null) {
            Boxing.boxBoolean(parentFile.mkdirs());
        }
        if (resolve2.exists() && !resolve2.delete()) {
            throw new IllegalStateException(("Failed to replace " + resolve2.getAbsolutePath()).toString());
        }
        if (!resolve.renameTo(resolve2)) {
            FilesKt.copyTo$default(resolve, resolve2, true, 0, 4, (Object) null);
            if (!resolve.delete()) {
                throw new IllegalStateException(("Failed to delete " + resolve.getAbsolutePath()).toString());
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public Object touch(KmpFileReference kmpFileReference, long j, Continuation<? super Unit> continuation) {
        resolve(kmpFileReference).setLastModified(j);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public String localUri(KmpFileReference file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String uri = resolve(file).toURI().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x003f, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r1, r0.getPath() + java.io.File.separator, false, 2, (java.lang.Object) null) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final KmpFileReference reference(File file) {
        boolean z;
        File canonicalFile = this.root.getCanonicalFile();
        File canonicalFile2 = file.getCanonicalFile();
        if (!Intrinsics.areEqual(canonicalFile2.getPath(), canonicalFile.getPath())) {
            String path = canonicalFile2.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            z = false;
        }
        z = true;
        if (!z) {
            throw new IllegalStateException("File reference escaped managed root".toString());
        }
        Intrinsics.checkNotNull(canonicalFile2);
        Intrinsics.checkNotNull(canonicalFile);
        return new KmpFileReference(FilesKt.getInvariantSeparatorsPath(FilesKt.relativeTo(canonicalFile2, canonicalFile)));
    }

    private final File resolve(KmpFileReference file) {
        return resolve(file.getPath());
    }

    private final File resolve(String relativePath) {
        boolean z = true;
        File canonicalFile = new File(this.root, StringsKt.trimStart(relativePath, new char[]{'/'})).getCanonicalFile();
        File canonicalFile2 = this.root.getCanonicalFile();
        if (!Intrinsics.areEqual(canonicalFile.getPath(), canonicalFile2.getPath())) {
            String path = canonicalFile.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            if (!StringsKt.startsWith$default(path, canonicalFile2.getPath() + File.separator, false, 2, (Object) null)) {
                z = false;
            }
        }
        if (!z) {
            throw new IllegalStateException("File reference escaped managed root".toString());
        }
        Intrinsics.checkNotNull(canonicalFile);
        return canonicalFile;
    }

    /* compiled from: AndroidKmpArtifactIo.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$Companion;", "", "<init>", "()V", "ROOT_DIRECTORY_NAME", "", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String sanitize(String value) {
        String str = value;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isLetterOrDigit(charAt) || charAt == '-' || charAt == '_') {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        if (StringsKt.isBlank(sb2)) {
            sb2 = "artifact";
        }
        return sb2;
    }
}
