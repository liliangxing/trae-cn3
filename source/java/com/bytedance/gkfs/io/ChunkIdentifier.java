package com.bytedance.gkfs.io;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.cdc.HexUtil;
import com.bytedance.gkfs.io.segmental.SegmentalByteArray;
import com.bytedance.gkfs.io.segmental.SegmentalByteArrayKt;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\r\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/gkfs/io/ChunkIdentifier;", "", "content", "Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "size", "", "(Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;I)V", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class ChunkIdentifier {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ChunkIdentifier NO_ID = new ChunkIdentifier(StringsKt.repeat("f", 40));
    public static final int VALID_LENGTH = 40;
    private final String value;

    /* compiled from: meta.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0003R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/gkfs/io/ChunkIdentifier$Companion;", "", "()V", "NO_ID", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "getNO_ID", "()Lcom/bytedance/gkfs/io/ChunkIdentifier;", "VALID_LENGTH", "", "computeHash", "", "content", "Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "size", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChunkIdentifier getNO_ID() {
            return ChunkIdentifier.NO_ID;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String computeHash(final SegmentalByteArray content, int size) {
            if (size != content.getSize()) {
                content = new SegmentalByteArray(size, new Function1<Integer, Byte>() { // from class: com.bytedance.gkfs.io.ChunkIdentifier$Companion$computeHash$bytes$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Byte invoke(Integer num) {
                        return Byte.valueOf(invoke(num.intValue()));
                    }

                    public final byte invoke(int i) {
                        return SegmentalByteArray.this.get(i);
                    }
                });
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            Iterator<byte[]> it = content.iterator();
            while (it.hasNext()) {
                messageDigest.update(it.next());
            }
            return HexUtil.INSTANCE.encode(messageDigest.digest());
        }
    }

    public ChunkIdentifier(String value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.value = value;
        if (value.length() != 40) {
            throw new IllegalArgumentException("Invalid identifier:" + value + ", except size is 40 but receive " + value.length());
        }
    }

    public final String getValue() {
        return this.value;
    }

    public /* synthetic */ ChunkIdentifier(SegmentalByteArray segmentalByteArray, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(segmentalByteArray, (i2 & 2) != 0 ? segmentalByteArray.getSize() : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChunkIdentifier(SegmentalByteArray content, int i) {
        this(INSTANCE.computeHash(content, i));
        Intrinsics.checkParameterIsNotNull(content, "content");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChunkIdentifier(File file) {
        this(r1.computeHash(r4, r0));
        Intrinsics.checkParameterIsNotNull(file, "file");
        int length = (int) file.length();
        Companion companion = INSTANCE;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            SegmentalByteArray segmentalByteArray = new SegmentalByteArray(length);
            SegmentalByteArrayKt.copyTo(fileInputStream, segmentalByteArray, 2048);
            CloseableKt.closeFinally(fileInputStream, null);
        } finally {
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ChunkIdentifier) && !(Intrinsics.areEqual(this.value, ((ChunkIdentifier) other).value) ^ true);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "ChunkIdentifier(" + this.value + ')';
    }
}
