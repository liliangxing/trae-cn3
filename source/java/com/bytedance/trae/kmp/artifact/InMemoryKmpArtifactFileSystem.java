package com.bytedance.trae.kmp.artifact;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: KmpArtifactIo.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\bH\u0016J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0011\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#H\u0096@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010!J\u0016\u0010&\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010!J\u001e\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010*J\u001e\u0010+\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;", "Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;", "<init>", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "entries", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;", "Lkotlin/collections/LinkedHashMap;", "nextTemporaryId", "", "createTemporaryFile", "Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", SchemaConstants.QUERY_KEY_PREFIX, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "file", "relativePath", "write", "", "bytes", "", "append", "", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;[BZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "offset", "length", "", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "metadata", "Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "list", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exists", "delete", "atomicReplace", EventConstants.PARAM_SOURCE, "destination", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;Lcom/bytedance/trae/kmp/artifact/KmpFileReference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touch", "modifiedAtMillis", "(Lcom/bytedance/trae/kmp/artifact/KmpFileReference;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localUri", "Entry", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InMemoryKmpArtifactFileSystem implements KmpArtifactFileSystem {
    public static final int $stable = 8;
    private long nextTemporaryId;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private final LinkedHashMap<String, Entry> entries = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KmpArtifactIo.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;", "", "bytes", "", "modifiedAtMillis", "", "<init>", "([BJ)V", "getBytes", "()[B", "setBytes", "([B)V", "getModifiedAtMillis", "()J", "setModifiedAtMillis", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Entry {
        private byte[] bytes;
        private long modifiedAtMillis;

        public static /* synthetic */ Entry copy$default(Entry entry, byte[] bArr, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = entry.bytes;
            }
            if ((i & 2) != 0) {
                j = entry.modifiedAtMillis;
            }
            return entry.copy(bArr, j);
        }

        /* renamed from: component1, reason: from getter */
        public final byte[] getBytes() {
            return this.bytes;
        }

        /* renamed from: component2, reason: from getter */
        public final long getModifiedAtMillis() {
            return this.modifiedAtMillis;
        }

        public final Entry copy(byte[] bytes, long modifiedAtMillis) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return new Entry(bytes, modifiedAtMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return Intrinsics.areEqual(this.bytes, entry.bytes) && this.modifiedAtMillis == entry.modifiedAtMillis;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.bytes) * 31) + Long.hashCode(this.modifiedAtMillis);
        }

        public String toString() {
            return "Entry(bytes=" + Arrays.toString(this.bytes) + ", modifiedAtMillis=" + this.modifiedAtMillis + ')';
        }

        public Entry(byte[] bArr, long j) {
            Intrinsics.checkNotNullParameter(bArr, "bytes");
            this.bytes = bArr;
            this.modifiedAtMillis = j;
        }

        public final byte[] getBytes() {
            return this.bytes;
        }

        public final void setBytes(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.bytes = bArr;
        }

        public final long getModifiedAtMillis() {
            return this.modifiedAtMillis;
        }

        public final void setModifiedAtMillis(long j) {
            this.modifiedAtMillis = j;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object createTemporaryFile(String str, Continuation<? super KmpFileReference> continuation) {
        InMemoryKmpArtifactFileSystem$createTemporaryFile$1 inMemoryKmpArtifactFileSystem$createTemporaryFile$1;
        int i;
        Mutex mutex;
        InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem;
        try {
            if (continuation instanceof InMemoryKmpArtifactFileSystem$createTemporaryFile$1) {
                inMemoryKmpArtifactFileSystem$createTemporaryFile$1 = (InMemoryKmpArtifactFileSystem$createTemporaryFile$1) continuation;
                if ((inMemoryKmpArtifactFileSystem$createTemporaryFile$1.label & Integer.MIN_VALUE) != 0) {
                    inMemoryKmpArtifactFileSystem$createTemporaryFile$1.label -= Integer.MIN_VALUE;
                    Object obj = inMemoryKmpArtifactFileSystem$createTemporaryFile$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = inMemoryKmpArtifactFileSystem$createTemporaryFile$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        inMemoryKmpArtifactFileSystem$createTemporaryFile$1.L$0 = this;
                        inMemoryKmpArtifactFileSystem$createTemporaryFile$1.L$1 = str;
                        inMemoryKmpArtifactFileSystem$createTemporaryFile$1.L$2 = mutex;
                        inMemoryKmpArtifactFileSystem$createTemporaryFile$1.label = 1;
                        if (mutex.lock((Object) null, inMemoryKmpArtifactFileSystem$createTemporaryFile$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inMemoryKmpArtifactFileSystem = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) inMemoryKmpArtifactFileSystem$createTemporaryFile$1.L$2;
                        String str2 = (String) inMemoryKmpArtifactFileSystem$createTemporaryFile$1.L$1;
                        inMemoryKmpArtifactFileSystem = (InMemoryKmpArtifactFileSystem) inMemoryKmpArtifactFileSystem$createTemporaryFile$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        str = str2;
                    }
                    inMemoryKmpArtifactFileSystem.nextTemporaryId++;
                    KmpFileReference kmpFileReference = new KmpFileReference("/cache/" + str + '-' + inMemoryKmpArtifactFileSystem.nextTemporaryId + ".tmp");
                    inMemoryKmpArtifactFileSystem.entries.put(kmpFileReference.getPath(), new Entry(new byte[0], 0L));
                    return kmpFileReference;
                }
            }
            inMemoryKmpArtifactFileSystem.nextTemporaryId++;
            KmpFileReference kmpFileReference2 = new KmpFileReference("/cache/" + str + '-' + inMemoryKmpArtifactFileSystem.nextTemporaryId + ".tmp");
            inMemoryKmpArtifactFileSystem.entries.put(kmpFileReference2.getPath(), new Entry(new byte[0], 0L));
            return kmpFileReference2;
        } finally {
            mutex.unlock((Object) null);
        }
        inMemoryKmpArtifactFileSystem$createTemporaryFile$1 = new InMemoryKmpArtifactFileSystem$createTemporaryFile$1(this, continuation);
        Object obj2 = inMemoryKmpArtifactFileSystem$createTemporaryFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inMemoryKmpArtifactFileSystem$createTemporaryFile$1.label;
        if (i != 0) {
        }
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public KmpFileReference file(String relativePath) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return new KmpFileReference("/" + StringsKt.trimStart(relativePath, new char[]{'/'}));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008f A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:11:0x0060, B:14:0x0070, B:15:0x0083, B:17:0x008f, B:18:0x0096, B:24:0x0079), top: B:10:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object write(KmpFileReference kmpFileReference, byte[] bArr, boolean z, Continuation<? super Unit> continuation) {
        InMemoryKmpArtifactFileSystem$write$1 inMemoryKmpArtifactFileSystem$write$1;
        int i;
        Mutex mutex;
        InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem;
        byte[] copyOf;
        try {
            if (continuation instanceof InMemoryKmpArtifactFileSystem$write$1) {
                inMemoryKmpArtifactFileSystem$write$1 = (InMemoryKmpArtifactFileSystem$write$1) continuation;
                if ((inMemoryKmpArtifactFileSystem$write$1.label & Integer.MIN_VALUE) != 0) {
                    inMemoryKmpArtifactFileSystem$write$1.label -= Integer.MIN_VALUE;
                    Object obj = inMemoryKmpArtifactFileSystem$write$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = inMemoryKmpArtifactFileSystem$write$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        inMemoryKmpArtifactFileSystem$write$1.L$0 = this;
                        inMemoryKmpArtifactFileSystem$write$1.L$1 = kmpFileReference;
                        inMemoryKmpArtifactFileSystem$write$1.L$2 = bArr;
                        inMemoryKmpArtifactFileSystem$write$1.L$3 = mutex;
                        inMemoryKmpArtifactFileSystem$write$1.Z$0 = z;
                        inMemoryKmpArtifactFileSystem$write$1.label = 1;
                        if (mutex.lock((Object) null, inMemoryKmpArtifactFileSystem$write$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inMemoryKmpArtifactFileSystem = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z = inMemoryKmpArtifactFileSystem$write$1.Z$0;
                        Mutex mutex2 = (Mutex) inMemoryKmpArtifactFileSystem$write$1.L$3;
                        bArr = (byte[]) inMemoryKmpArtifactFileSystem$write$1.L$2;
                        KmpFileReference kmpFileReference2 = (KmpFileReference) inMemoryKmpArtifactFileSystem$write$1.L$1;
                        inMemoryKmpArtifactFileSystem = (InMemoryKmpArtifactFileSystem) inMemoryKmpArtifactFileSystem$write$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        kmpFileReference = kmpFileReference2;
                    }
                    Entry entry = inMemoryKmpArtifactFileSystem.entries.get(kmpFileReference.getPath());
                    if (!z && entry != null) {
                        copyOf = ArraysKt.plus(entry.getBytes(), bArr);
                    } else {
                        copyOf = Arrays.copyOf(bArr, bArr.length);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                    }
                    inMemoryKmpArtifactFileSystem.entries.put(kmpFileReference.getPath(), new Entry(copyOf, entry == null ? entry.getModifiedAtMillis() : 0L));
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            Entry entry2 = inMemoryKmpArtifactFileSystem.entries.get(kmpFileReference.getPath());
            if (!z) {
            }
            copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            inMemoryKmpArtifactFileSystem.entries.put(kmpFileReference.getPath(), new Entry(copyOf, entry2 == null ? entry2.getModifiedAtMillis() : 0L));
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        inMemoryKmpArtifactFileSystem$write$1 = new InMemoryKmpArtifactFileSystem$write$1(this, continuation);
        Object obj2 = inMemoryKmpArtifactFileSystem$write$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inMemoryKmpArtifactFileSystem$write$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(KmpFileReference kmpFileReference, long j, int i, Continuation<? super byte[]> continuation) {
        InMemoryKmpArtifactFileSystem$read$1 inMemoryKmpArtifactFileSystem$read$1;
        int i2;
        Mutex mutex;
        InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem;
        Entry entry;
        byte[] bArr;
        byte[] bytes;
        try {
            if (continuation instanceof InMemoryKmpArtifactFileSystem$read$1) {
                inMemoryKmpArtifactFileSystem$read$1 = (InMemoryKmpArtifactFileSystem$read$1) continuation;
                if ((inMemoryKmpArtifactFileSystem$read$1.label & Integer.MIN_VALUE) != 0) {
                    inMemoryKmpArtifactFileSystem$read$1.label -= Integer.MIN_VALUE;
                    Object obj = inMemoryKmpArtifactFileSystem$read$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = inMemoryKmpArtifactFileSystem$read$1.label;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        inMemoryKmpArtifactFileSystem$read$1.L$0 = this;
                        inMemoryKmpArtifactFileSystem$read$1.L$1 = kmpFileReference;
                        inMemoryKmpArtifactFileSystem$read$1.L$2 = mutex;
                        inMemoryKmpArtifactFileSystem$read$1.J$0 = j;
                        inMemoryKmpArtifactFileSystem$read$1.I$0 = i;
                        inMemoryKmpArtifactFileSystem$read$1.label = 1;
                        if (mutex.lock((Object) null, inMemoryKmpArtifactFileSystem$read$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inMemoryKmpArtifactFileSystem = this;
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i = inMemoryKmpArtifactFileSystem$read$1.I$0;
                        j = inMemoryKmpArtifactFileSystem$read$1.J$0;
                        Mutex mutex2 = (Mutex) inMemoryKmpArtifactFileSystem$read$1.L$2;
                        KmpFileReference kmpFileReference2 = (KmpFileReference) inMemoryKmpArtifactFileSystem$read$1.L$1;
                        inMemoryKmpArtifactFileSystem = (InMemoryKmpArtifactFileSystem) inMemoryKmpArtifactFileSystem$read$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        kmpFileReference = kmpFileReference2;
                    }
                    entry = inMemoryKmpArtifactFileSystem.entries.get(kmpFileReference.getPath());
                    if (entry != null && (bytes = entry.getBytes()) != null) {
                        int coerceAtMost = (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(j, 0L), bytes.length);
                        bArr = ArraysKt.copyOfRange(bytes, coerceAtMost, RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i, 0) + coerceAtMost, bytes.length));
                        return bArr;
                    }
                    bArr = new byte[0];
                    return bArr;
                }
            }
            entry = inMemoryKmpArtifactFileSystem.entries.get(kmpFileReference.getPath());
            if (entry != null) {
                int coerceAtMost2 = (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(j, 0L), bytes.length);
                bArr = ArraysKt.copyOfRange(bytes, coerceAtMost2, RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i, 0) + coerceAtMost2, bytes.length));
                return bArr;
            }
            bArr = new byte[0];
            return bArr;
        } finally {
            mutex.unlock((Object) null);
        }
        inMemoryKmpArtifactFileSystem$read$1 = new InMemoryKmpArtifactFileSystem$read$1(this, continuation);
        Object obj2 = inMemoryKmpArtifactFileSystem$read$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = inMemoryKmpArtifactFileSystem$read$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064 A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #0 {all -> 0x0079, blocks: (B:11:0x0056, B:13:0x0064), top: B:10:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object metadata(KmpFileReference kmpFileReference, Continuation<? super KmpFileMetadata> continuation) {
        InMemoryKmpArtifactFileSystem$metadata$1 inMemoryKmpArtifactFileSystem$metadata$1;
        int i;
        Mutex mutex;
        InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem;
        try {
            if (continuation instanceof InMemoryKmpArtifactFileSystem$metadata$1) {
                inMemoryKmpArtifactFileSystem$metadata$1 = (InMemoryKmpArtifactFileSystem$metadata$1) continuation;
                if ((inMemoryKmpArtifactFileSystem$metadata$1.label & Integer.MIN_VALUE) != 0) {
                    inMemoryKmpArtifactFileSystem$metadata$1.label -= Integer.MIN_VALUE;
                    Object obj = inMemoryKmpArtifactFileSystem$metadata$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = inMemoryKmpArtifactFileSystem$metadata$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        inMemoryKmpArtifactFileSystem$metadata$1.L$0 = this;
                        inMemoryKmpArtifactFileSystem$metadata$1.L$1 = kmpFileReference;
                        inMemoryKmpArtifactFileSystem$metadata$1.L$2 = mutex;
                        inMemoryKmpArtifactFileSystem$metadata$1.label = 1;
                        if (mutex.lock((Object) null, inMemoryKmpArtifactFileSystem$metadata$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inMemoryKmpArtifactFileSystem = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) inMemoryKmpArtifactFileSystem$metadata$1.L$2;
                        KmpFileReference kmpFileReference2 = (KmpFileReference) inMemoryKmpArtifactFileSystem$metadata$1.L$1;
                        inMemoryKmpArtifactFileSystem = (InMemoryKmpArtifactFileSystem) inMemoryKmpArtifactFileSystem$metadata$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        kmpFileReference = kmpFileReference2;
                    }
                    Entry entry = inMemoryKmpArtifactFileSystem.entries.get(kmpFileReference.getPath());
                    return entry == null ? new KmpFileMetadata(entry.getBytes().length, entry.getModifiedAtMillis()) : null;
                }
            }
            Entry entry2 = inMemoryKmpArtifactFileSystem.entries.get(kmpFileReference.getPath());
            return entry2 == null ? new KmpFileMetadata(entry2.getBytes().length, entry2.getModifiedAtMillis()) : null;
        } finally {
            mutex.unlock((Object) null);
        }
        inMemoryKmpArtifactFileSystem$metadata$1 = new InMemoryKmpArtifactFileSystem$metadata$1(this, continuation);
        Object obj2 = inMemoryKmpArtifactFileSystem$metadata$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inMemoryKmpArtifactFileSystem$metadata$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073 A[Catch: all -> 0x0088, LOOP:0: B:12:0x006d->B:14:0x0073, LOOP_END, TryCatch #0 {all -> 0x0088, blocks: (B:11:0x004f, B:12:0x006d, B:14:0x0073, B:16:0x0082), top: B:10:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object list(Continuation<? super List<KmpFileReference>> continuation) {
        InMemoryKmpArtifactFileSystem$list$1 inMemoryKmpArtifactFileSystem$list$1;
        int i;
        InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem;
        Mutex mutex;
        Iterator<T> it;
        try {
            if (continuation instanceof InMemoryKmpArtifactFileSystem$list$1) {
                inMemoryKmpArtifactFileSystem$list$1 = (InMemoryKmpArtifactFileSystem$list$1) continuation;
                if ((inMemoryKmpArtifactFileSystem$list$1.label & Integer.MIN_VALUE) != 0) {
                    inMemoryKmpArtifactFileSystem$list$1.label -= Integer.MIN_VALUE;
                    Object obj = inMemoryKmpArtifactFileSystem$list$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = inMemoryKmpArtifactFileSystem$list$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex2 = this.mutex;
                        inMemoryKmpArtifactFileSystem$list$1.L$0 = this;
                        inMemoryKmpArtifactFileSystem$list$1.L$1 = mutex2;
                        inMemoryKmpArtifactFileSystem$list$1.label = 1;
                        if (mutex2.lock((Object) null, inMemoryKmpArtifactFileSystem$list$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inMemoryKmpArtifactFileSystem = this;
                        mutex = mutex2;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex = (Mutex) inMemoryKmpArtifactFileSystem$list$1.L$1;
                        inMemoryKmpArtifactFileSystem = (InMemoryKmpArtifactFileSystem) inMemoryKmpArtifactFileSystem$list$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Set<String> keySet = inMemoryKmpArtifactFileSystem.entries.keySet();
                    Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
                    Set<String> set = keySet;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                    it = set.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new KmpFileReference((String) it.next()));
                    }
                    return arrayList;
                }
            }
            Set<String> keySet2 = inMemoryKmpArtifactFileSystem.entries.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet2, "<get-keys>(...)");
            Set<String> set2 = keySet2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
            it = set2.iterator();
            while (it.hasNext()) {
            }
            return arrayList2;
        } finally {
            mutex.unlock((Object) null);
        }
        inMemoryKmpArtifactFileSystem$list$1 = new InMemoryKmpArtifactFileSystem$list$1(this, continuation);
        Object obj2 = inMemoryKmpArtifactFileSystem$list$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inMemoryKmpArtifactFileSystem$list$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object exists(KmpFileReference kmpFileReference, Continuation<? super Boolean> continuation) {
        InMemoryKmpArtifactFileSystem$exists$1 inMemoryKmpArtifactFileSystem$exists$1;
        int i;
        Mutex mutex;
        InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem;
        try {
            if (continuation instanceof InMemoryKmpArtifactFileSystem$exists$1) {
                inMemoryKmpArtifactFileSystem$exists$1 = (InMemoryKmpArtifactFileSystem$exists$1) continuation;
                if ((inMemoryKmpArtifactFileSystem$exists$1.label & Integer.MIN_VALUE) != 0) {
                    inMemoryKmpArtifactFileSystem$exists$1.label -= Integer.MIN_VALUE;
                    Object obj = inMemoryKmpArtifactFileSystem$exists$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = inMemoryKmpArtifactFileSystem$exists$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        inMemoryKmpArtifactFileSystem$exists$1.L$0 = this;
                        inMemoryKmpArtifactFileSystem$exists$1.L$1 = kmpFileReference;
                        inMemoryKmpArtifactFileSystem$exists$1.L$2 = mutex;
                        inMemoryKmpArtifactFileSystem$exists$1.label = 1;
                        if (mutex.lock((Object) null, inMemoryKmpArtifactFileSystem$exists$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inMemoryKmpArtifactFileSystem = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) inMemoryKmpArtifactFileSystem$exists$1.L$2;
                        KmpFileReference kmpFileReference2 = (KmpFileReference) inMemoryKmpArtifactFileSystem$exists$1.L$1;
                        inMemoryKmpArtifactFileSystem = (InMemoryKmpArtifactFileSystem) inMemoryKmpArtifactFileSystem$exists$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        kmpFileReference = kmpFileReference2;
                    }
                    return Boxing.boxBoolean(inMemoryKmpArtifactFileSystem.entries.containsKey(kmpFileReference.getPath()));
                }
            }
            return Boxing.boxBoolean(inMemoryKmpArtifactFileSystem.entries.containsKey(kmpFileReference.getPath()));
        } finally {
            mutex.unlock((Object) null);
        }
        inMemoryKmpArtifactFileSystem$exists$1 = new InMemoryKmpArtifactFileSystem$exists$1(this, continuation);
        Object obj2 = inMemoryKmpArtifactFileSystem$exists$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inMemoryKmpArtifactFileSystem$exists$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object delete(KmpFileReference kmpFileReference, Continuation<? super Boolean> continuation) {
        InMemoryKmpArtifactFileSystem$delete$1 inMemoryKmpArtifactFileSystem$delete$1;
        int i;
        Mutex mutex;
        InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem;
        try {
            if (continuation instanceof InMemoryKmpArtifactFileSystem$delete$1) {
                inMemoryKmpArtifactFileSystem$delete$1 = (InMemoryKmpArtifactFileSystem$delete$1) continuation;
                if ((inMemoryKmpArtifactFileSystem$delete$1.label & Integer.MIN_VALUE) != 0) {
                    inMemoryKmpArtifactFileSystem$delete$1.label -= Integer.MIN_VALUE;
                    Object obj = inMemoryKmpArtifactFileSystem$delete$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = inMemoryKmpArtifactFileSystem$delete$1.label;
                    boolean z = true;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        inMemoryKmpArtifactFileSystem$delete$1.L$0 = this;
                        inMemoryKmpArtifactFileSystem$delete$1.L$1 = kmpFileReference;
                        inMemoryKmpArtifactFileSystem$delete$1.L$2 = mutex;
                        inMemoryKmpArtifactFileSystem$delete$1.label = 1;
                        if (mutex.lock((Object) null, inMemoryKmpArtifactFileSystem$delete$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inMemoryKmpArtifactFileSystem = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) inMemoryKmpArtifactFileSystem$delete$1.L$2;
                        KmpFileReference kmpFileReference2 = (KmpFileReference) inMemoryKmpArtifactFileSystem$delete$1.L$1;
                        inMemoryKmpArtifactFileSystem = (InMemoryKmpArtifactFileSystem) inMemoryKmpArtifactFileSystem$delete$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        kmpFileReference = kmpFileReference2;
                    }
                    if (inMemoryKmpArtifactFileSystem.entries.remove(kmpFileReference.getPath()) != null) {
                        z = false;
                    }
                    return Boxing.boxBoolean(z);
                }
            }
            if (inMemoryKmpArtifactFileSystem.entries.remove(kmpFileReference.getPath()) != null) {
            }
            return Boxing.boxBoolean(z);
        } finally {
            mutex.unlock((Object) null);
        }
        inMemoryKmpArtifactFileSystem$delete$1 = new InMemoryKmpArtifactFileSystem$delete$1(this, continuation);
        Object obj2 = inMemoryKmpArtifactFileSystem$delete$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inMemoryKmpArtifactFileSystem$delete$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006a A[Catch: all -> 0x009a, TRY_LEAVE, TryCatch #0 {all -> 0x009a, blocks: (B:11:0x005e, B:13:0x006a, B:17:0x007f, B:18:0x0099), top: B:10:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f A[Catch: all -> 0x009a, TRY_ENTER, TryCatch #0 {all -> 0x009a, blocks: (B:11:0x005e, B:13:0x006a, B:17:0x007f, B:18:0x0099), top: B:10:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object atomicReplace(KmpFileReference kmpFileReference, KmpFileReference kmpFileReference2, Continuation<? super Unit> continuation) {
        InMemoryKmpArtifactFileSystem$atomicReplace$1 inMemoryKmpArtifactFileSystem$atomicReplace$1;
        int i;
        Mutex mutex;
        InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem;
        Entry remove;
        try {
            if (continuation instanceof InMemoryKmpArtifactFileSystem$atomicReplace$1) {
                inMemoryKmpArtifactFileSystem$atomicReplace$1 = (InMemoryKmpArtifactFileSystem$atomicReplace$1) continuation;
                if ((inMemoryKmpArtifactFileSystem$atomicReplace$1.label & Integer.MIN_VALUE) != 0) {
                    inMemoryKmpArtifactFileSystem$atomicReplace$1.label -= Integer.MIN_VALUE;
                    Object obj = inMemoryKmpArtifactFileSystem$atomicReplace$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = inMemoryKmpArtifactFileSystem$atomicReplace$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        inMemoryKmpArtifactFileSystem$atomicReplace$1.L$0 = this;
                        inMemoryKmpArtifactFileSystem$atomicReplace$1.L$1 = kmpFileReference;
                        inMemoryKmpArtifactFileSystem$atomicReplace$1.L$2 = kmpFileReference2;
                        inMemoryKmpArtifactFileSystem$atomicReplace$1.L$3 = mutex;
                        inMemoryKmpArtifactFileSystem$atomicReplace$1.label = 1;
                        if (mutex.lock((Object) null, inMemoryKmpArtifactFileSystem$atomicReplace$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inMemoryKmpArtifactFileSystem = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) inMemoryKmpArtifactFileSystem$atomicReplace$1.L$3;
                        kmpFileReference2 = (KmpFileReference) inMemoryKmpArtifactFileSystem$atomicReplace$1.L$2;
                        KmpFileReference kmpFileReference3 = (KmpFileReference) inMemoryKmpArtifactFileSystem$atomicReplace$1.L$1;
                        inMemoryKmpArtifactFileSystem = (InMemoryKmpArtifactFileSystem) inMemoryKmpArtifactFileSystem$atomicReplace$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        kmpFileReference = kmpFileReference3;
                    }
                    remove = inMemoryKmpArtifactFileSystem.entries.remove(kmpFileReference.getPath());
                    if (remove != null) {
                        throw new IllegalStateException(("Missing source file " + kmpFileReference.getPath()).toString());
                    }
                    inMemoryKmpArtifactFileSystem.entries.put(kmpFileReference2.getPath(), remove);
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            remove = inMemoryKmpArtifactFileSystem.entries.remove(kmpFileReference.getPath());
            if (remove != null) {
            }
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        inMemoryKmpArtifactFileSystem$atomicReplace$1 = new InMemoryKmpArtifactFileSystem$atomicReplace$1(this, continuation);
        Object obj2 = inMemoryKmpArtifactFileSystem$atomicReplace$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inMemoryKmpArtifactFileSystem$atomicReplace$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:11:0x005a, B:13:0x0068, B:14:0x006b), top: B:10:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object touch(KmpFileReference kmpFileReference, long j, Continuation<? super Unit> continuation) {
        InMemoryKmpArtifactFileSystem$touch$1 inMemoryKmpArtifactFileSystem$touch$1;
        int i;
        Mutex mutex;
        InMemoryKmpArtifactFileSystem inMemoryKmpArtifactFileSystem;
        Entry entry;
        try {
            if (continuation instanceof InMemoryKmpArtifactFileSystem$touch$1) {
                inMemoryKmpArtifactFileSystem$touch$1 = (InMemoryKmpArtifactFileSystem$touch$1) continuation;
                if ((inMemoryKmpArtifactFileSystem$touch$1.label & Integer.MIN_VALUE) != 0) {
                    inMemoryKmpArtifactFileSystem$touch$1.label -= Integer.MIN_VALUE;
                    Object obj = inMemoryKmpArtifactFileSystem$touch$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = inMemoryKmpArtifactFileSystem$touch$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        inMemoryKmpArtifactFileSystem$touch$1.L$0 = this;
                        inMemoryKmpArtifactFileSystem$touch$1.L$1 = kmpFileReference;
                        inMemoryKmpArtifactFileSystem$touch$1.L$2 = mutex;
                        inMemoryKmpArtifactFileSystem$touch$1.J$0 = j;
                        inMemoryKmpArtifactFileSystem$touch$1.label = 1;
                        if (mutex.lock((Object) null, inMemoryKmpArtifactFileSystem$touch$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        inMemoryKmpArtifactFileSystem = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j = inMemoryKmpArtifactFileSystem$touch$1.J$0;
                        Mutex mutex2 = (Mutex) inMemoryKmpArtifactFileSystem$touch$1.L$2;
                        KmpFileReference kmpFileReference2 = (KmpFileReference) inMemoryKmpArtifactFileSystem$touch$1.L$1;
                        inMemoryKmpArtifactFileSystem = (InMemoryKmpArtifactFileSystem) inMemoryKmpArtifactFileSystem$touch$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        kmpFileReference = kmpFileReference2;
                    }
                    entry = inMemoryKmpArtifactFileSystem.entries.get(kmpFileReference.getPath());
                    if (entry != null) {
                        entry.setModifiedAtMillis(j);
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            entry = inMemoryKmpArtifactFileSystem.entries.get(kmpFileReference.getPath());
            if (entry != null) {
            }
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        inMemoryKmpArtifactFileSystem$touch$1 = new InMemoryKmpArtifactFileSystem$touch$1(this, continuation);
        Object obj2 = inMemoryKmpArtifactFileSystem$touch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = inMemoryKmpArtifactFileSystem$touch$1.label;
        if (i != 0) {
        }
    }

    @Override // com.bytedance.trae.kmp.artifact.KmpArtifactFileSystem
    public String localUri(KmpFileReference file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return "file://" + file.getPath();
    }
}
