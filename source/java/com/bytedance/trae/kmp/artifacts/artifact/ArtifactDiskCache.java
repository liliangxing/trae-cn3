package com.bytedance.trae.kmp.artifacts.artifact;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: ArtifactDiskCache.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\fH\u0080@¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u00060#R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010!J\u000e\u0010$\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;", "", "fileSystem", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;", "maxBytes", "", "<init>", "(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFileSystem;J)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "entries", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;", "Lkotlin/collections/LinkedHashMap;", "leaseCounts", "", "", "restore", "", "restoredEntries", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startupCleanup", "access", "reference", "nowMillis", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commit", "entry", "(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discard", "discard$artifacts_mainlandRelease", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquire", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;", "trim", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trimLocked", "Lease", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactDiskCache {
    public static final int $stable = 8;
    private final LinkedHashMap<String, ArtifactCacheEntry> entries;
    private final ArtifactCacheFileSystem fileSystem;
    private final Map<String, Integer> leaseCounts;
    private final long maxBytes;
    private final Mutex mutex;

    public ArtifactDiskCache(ArtifactCacheFileSystem artifactCacheFileSystem, long j) {
        Intrinsics.checkNotNullParameter(artifactCacheFileSystem, "fileSystem");
        this.fileSystem = artifactCacheFileSystem;
        this.maxBytes = j;
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.entries = new LinkedHashMap<>();
        this.leaseCounts = new LinkedHashMap();
    }

    public /* synthetic */ ArtifactDiskCache(ArtifactCacheFileSystem artifactCacheFileSystem, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(artifactCacheFileSystem, (i & 2) != 0 ? ArtifactDiskCacheKt.ARTIFACT_CACHE_MAX_BYTES : j);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: all -> 0x0081, LOOP:0: B:12:0x0061->B:14:0x0067, LOOP_END, TryCatch #0 {all -> 0x0081, blocks: (B:11:0x0056, B:12:0x0061, B:14:0x0067, B:16:0x0079), top: B:10:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object restore(List<ArtifactCacheEntry> list, Continuation<? super Unit> continuation) {
        ArtifactDiskCache$restore$1 artifactDiskCache$restore$1;
        int i;
        Mutex mutex;
        ArtifactDiskCache artifactDiskCache;
        try {
            if (continuation instanceof ArtifactDiskCache$restore$1) {
                artifactDiskCache$restore$1 = (ArtifactDiskCache$restore$1) continuation;
                if ((artifactDiskCache$restore$1.label & Integer.MIN_VALUE) != 0) {
                    artifactDiskCache$restore$1.label -= Integer.MIN_VALUE;
                    Object obj = artifactDiskCache$restore$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = artifactDiskCache$restore$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        artifactDiskCache$restore$1.L$0 = this;
                        artifactDiskCache$restore$1.L$1 = list;
                        artifactDiskCache$restore$1.L$2 = mutex;
                        artifactDiskCache$restore$1.label = 1;
                        if (mutex.lock((Object) null, artifactDiskCache$restore$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        artifactDiskCache = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) artifactDiskCache$restore$1.L$2;
                        List<ArtifactCacheEntry> list2 = (List) artifactDiskCache$restore$1.L$1;
                        artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$restore$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        list = list2;
                    }
                    artifactDiskCache.entries.clear();
                    for (ArtifactCacheEntry artifactCacheEntry : list) {
                        artifactDiskCache.entries.put(artifactCacheEntry.getReference(), artifactCacheEntry);
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            artifactDiskCache.entries.clear();
            while (r6.hasNext()) {
            }
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        artifactDiskCache$restore$1 = new ArtifactDiskCache$restore$1(this, continuation);
        Object obj2 = artifactDiskCache$restore$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactDiskCache$restore$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0123 A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:20:0x0052, B:22:0x011d, B:24:0x0123, B:26:0x0135, B:28:0x013f, B:32:0x014c, B:44:0x0164, B:50:0x0064, B:51:0x0115, B:53:0x0099, B:54:0x00a6, B:56:0x00ac, B:58:0x00bd, B:62:0x00c8, B:68:0x00ce, B:69:0x00ee, B:71:0x00f4, B:73:0x0103), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:20:0x0052, B:22:0x011d, B:24:0x0123, B:26:0x0135, B:28:0x013f, B:32:0x014c, B:44:0x0164, B:50:0x0064, B:51:0x0115, B:53:0x0099, B:54:0x00a6, B:56:0x00ac, B:58:0x00bd, B:62:0x00c8, B:68:0x00ce, B:69:0x00ee, B:71:0x00f4, B:73:0x0103), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f4 A[Catch: all -> 0x0069, LOOP:2: B:69:0x00ee->B:71:0x00f4, LOOP_END, TryCatch #0 {all -> 0x0069, blocks: (B:20:0x0052, B:22:0x011d, B:24:0x0123, B:26:0x0135, B:28:0x013f, B:32:0x014c, B:44:0x0164, B:50:0x0064, B:51:0x0115, B:53:0x0099, B:54:0x00a6, B:56:0x00ac, B:58:0x00bd, B:62:0x00c8, B:68:0x00ce, B:69:0x00ee, B:71:0x00f4, B:73:0x0103), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0113 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startupCleanup(List<ArtifactCacheEntry> list, Continuation<? super Unit> continuation) {
        ArtifactDiskCache$startupCleanup$1 artifactDiskCache$startupCleanup$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        List<ArtifactCacheEntry> list2;
        Mutex mutex;
        ArtifactDiskCache artifactDiskCache;
        LinkedHashMap linkedHashMap;
        ArtifactDiskCache artifactDiskCache2;
        ArtifactDiskCache artifactDiskCache3;
        Iterator it;
        try {
            if (continuation instanceof ArtifactDiskCache$startupCleanup$1) {
                artifactDiskCache$startupCleanup$1 = (ArtifactDiskCache$startupCleanup$1) continuation;
                if ((artifactDiskCache$startupCleanup$1.label & Integer.MIN_VALUE) != 0) {
                    artifactDiskCache$startupCleanup$1.label -= Integer.MIN_VALUE;
                    obj = artifactDiskCache$startupCleanup$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = artifactDiskCache$startupCleanup$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex2 = this.mutex;
                        artifactDiskCache$startupCleanup$1.L$0 = this;
                        list2 = list;
                        artifactDiskCache$startupCleanup$1.L$1 = list2;
                        artifactDiskCache$startupCleanup$1.L$2 = mutex2;
                        artifactDiskCache$startupCleanup$1.label = 1;
                        if (mutex2.lock((Object) null, artifactDiskCache$startupCleanup$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex = mutex2;
                        artifactDiskCache = this;
                    } else {
                        if (i != 1) {
                            if (i == 2) {
                                linkedHashMap = (Map) artifactDiskCache$startupCleanup$1.L$2;
                                mutex = (Mutex) artifactDiskCache$startupCleanup$1.L$1;
                                artifactDiskCache2 = (ArtifactDiskCache) artifactDiskCache$startupCleanup$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                artifactDiskCache3 = artifactDiskCache2;
                                it = ((Iterable) obj).iterator();
                                while (it.hasNext()) {
                                }
                                artifactDiskCache3.entries.clear();
                                artifactDiskCache3.entries.putAll(linkedHashMap);
                                Unit unit = Unit.INSTANCE;
                                mutex.unlock((Object) null);
                                artifactDiskCache$startupCleanup$1.L$0 = null;
                                artifactDiskCache$startupCleanup$1.L$1 = null;
                                artifactDiskCache$startupCleanup$1.L$2 = null;
                                artifactDiskCache$startupCleanup$1.L$3 = null;
                                artifactDiskCache$startupCleanup$1.label = 4;
                                if (artifactDiskCache3.trim(artifactDiskCache$startupCleanup$1) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                            if (i != 3) {
                                if (i != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            linkedHashMap = (Map) artifactDiskCache$startupCleanup$1.L$3;
                            it = (Iterator) artifactDiskCache$startupCleanup$1.L$2;
                            mutex = (Mutex) artifactDiskCache$startupCleanup$1.L$1;
                            artifactDiskCache3 = (ArtifactDiskCache) artifactDiskCache$startupCleanup$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            while (it.hasNext()) {
                                ArtifactCacheFile artifactCacheFile = (ArtifactCacheFile) it.next();
                                if (!StringsKt.endsWith$default(artifactCacheFile.getReference(), ".tmp", false, 2, (Object) null) && artifactCacheFile.getSize() <= artifactDiskCache3.maxBytes && linkedHashMap.containsKey(artifactCacheFile.getReference())) {
                                }
                                ArtifactCacheFileSystem artifactCacheFileSystem = artifactDiskCache3.fileSystem;
                                String reference = artifactCacheFile.getReference();
                                artifactDiskCache$startupCleanup$1.L$0 = artifactDiskCache3;
                                artifactDiskCache$startupCleanup$1.L$1 = mutex;
                                artifactDiskCache$startupCleanup$1.L$2 = it;
                                artifactDiskCache$startupCleanup$1.L$3 = linkedHashMap;
                                artifactDiskCache$startupCleanup$1.label = 3;
                                if (artifactCacheFileSystem.delete(reference, artifactDiskCache$startupCleanup$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            artifactDiskCache3.entries.clear();
                            artifactDiskCache3.entries.putAll(linkedHashMap);
                            Unit unit2 = Unit.INSTANCE;
                            mutex.unlock((Object) null);
                            artifactDiskCache$startupCleanup$1.L$0 = null;
                            artifactDiskCache$startupCleanup$1.L$1 = null;
                            artifactDiskCache$startupCleanup$1.L$2 = null;
                            artifactDiskCache$startupCleanup$1.L$3 = null;
                            artifactDiskCache$startupCleanup$1.label = 4;
                            if (artifactDiskCache3.trim(artifactDiskCache$startupCleanup$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        Mutex mutex3 = (Mutex) artifactDiskCache$startupCleanup$1.L$2;
                        List<ArtifactCacheEntry> list3 = (List) artifactDiskCache$startupCleanup$1.L$1;
                        artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$startupCleanup$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex3;
                        list2 = list3;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list2) {
                        ArtifactCacheEntry artifactCacheEntry = (ArtifactCacheEntry) obj2;
                        if (artifactCacheEntry.getSize() <= artifactDiskCache.maxBytes && !artifactCacheEntry.getTemporaryOversized()) {
                            arrayList.add(obj2);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
                    for (Object obj3 : arrayList2) {
                        linkedHashMap.put(((ArtifactCacheEntry) obj3).getReference(), obj3);
                    }
                    ArtifactCacheFileSystem artifactCacheFileSystem2 = artifactDiskCache.fileSystem;
                    artifactDiskCache$startupCleanup$1.L$0 = artifactDiskCache;
                    artifactDiskCache$startupCleanup$1.L$1 = mutex;
                    artifactDiskCache$startupCleanup$1.L$2 = linkedHashMap;
                    artifactDiskCache$startupCleanup$1.label = 2;
                    obj = artifactCacheFileSystem2.list(artifactDiskCache$startupCleanup$1);
                    if (obj != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    artifactDiskCache2 = artifactDiskCache;
                    artifactDiskCache3 = artifactDiskCache2;
                    it = ((Iterable) obj).iterator();
                    while (it.hasNext()) {
                    }
                    artifactDiskCache3.entries.clear();
                    artifactDiskCache3.entries.putAll(linkedHashMap);
                    Unit unit22 = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    artifactDiskCache$startupCleanup$1.L$0 = null;
                    artifactDiskCache$startupCleanup$1.L$1 = null;
                    artifactDiskCache$startupCleanup$1.L$2 = null;
                    artifactDiskCache$startupCleanup$1.L$3 = null;
                    artifactDiskCache$startupCleanup$1.label = 4;
                    if (artifactDiskCache3.trim(artifactDiskCache$startupCleanup$1) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            ArrayList arrayList3 = new ArrayList();
            while (r4.hasNext()) {
            }
            ArrayList arrayList22 = arrayList3;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList22, 10)), 16));
            while (r0.hasNext()) {
            }
            ArtifactCacheFileSystem artifactCacheFileSystem22 = artifactDiskCache.fileSystem;
            artifactDiskCache$startupCleanup$1.L$0 = artifactDiskCache;
            artifactDiskCache$startupCleanup$1.L$1 = mutex;
            artifactDiskCache$startupCleanup$1.L$2 = linkedHashMap;
            artifactDiskCache$startupCleanup$1.label = 2;
            obj = artifactCacheFileSystem22.list(artifactDiskCache$startupCleanup$1);
            if (obj != coroutine_suspended) {
            }
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        artifactDiskCache$startupCleanup$1 = new ArtifactDiskCache$startupCleanup$1(this, continuation);
        obj = artifactDiskCache$startupCleanup$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactDiskCache$startupCleanup$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006f A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #0 {all -> 0x0089, blocks: (B:11:0x0064, B:13:0x006f), top: B:10:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object access(String str, long j, Continuation<? super Unit> continuation) {
        ArtifactDiskCache$access$1 artifactDiskCache$access$1;
        int i;
        String str2;
        Mutex mutex;
        ArtifactDiskCache artifactDiskCache;
        long j2;
        ArtifactCacheEntry artifactCacheEntry;
        try {
            if (continuation instanceof ArtifactDiskCache$access$1) {
                artifactDiskCache$access$1 = (ArtifactDiskCache$access$1) continuation;
                if ((artifactDiskCache$access$1.label & Integer.MIN_VALUE) != 0) {
                    artifactDiskCache$access$1.label -= Integer.MIN_VALUE;
                    Object obj = artifactDiskCache$access$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = artifactDiskCache$access$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex2 = this.mutex;
                        artifactDiskCache$access$1.L$0 = this;
                        str2 = str;
                        artifactDiskCache$access$1.L$1 = str2;
                        artifactDiskCache$access$1.L$2 = mutex2;
                        artifactDiskCache$access$1.J$0 = j;
                        artifactDiskCache$access$1.label = 1;
                        if (mutex2.lock((Object) null, artifactDiskCache$access$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mutex = mutex2;
                        artifactDiskCache = this;
                        j2 = j;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        long j3 = artifactDiskCache$access$1.J$0;
                        Mutex mutex3 = (Mutex) artifactDiskCache$access$1.L$2;
                        String str3 = (String) artifactDiskCache$access$1.L$1;
                        artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$access$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        j2 = j3;
                        mutex = mutex3;
                        str2 = str3;
                    }
                    artifactCacheEntry = artifactDiskCache.entries.get(str2);
                    if (artifactCacheEntry != null) {
                        artifactDiskCache.entries.put(str2, ArtifactCacheEntry.copy$default(artifactCacheEntry, null, 0L, j2, false, 11, null));
                        Unit unit = Unit.INSTANCE;
                    }
                    mutex.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            artifactCacheEntry = artifactDiskCache.entries.get(str2);
            if (artifactCacheEntry != null) {
            }
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        artifactDiskCache$access$1 = new ArtifactDiskCache$access$1(this, continuation);
        Object obj2 = artifactDiskCache$access$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactDiskCache$access$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082 A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #0 {all -> 0x00c8, blocks: (B:30:0x0078, B:32:0x0082, B:36:0x00a5), top: B:29:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5 A[Catch: all -> 0x00c8, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c8, blocks: (B:30:0x0078, B:32:0x0082, B:36:0x00a5), top: B:29:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object commit(ArtifactCacheEntry artifactCacheEntry, Continuation<? super Unit> continuation) {
        ArtifactDiskCache$commit$1 artifactDiskCache$commit$1;
        int i;
        ArtifactCacheEntry artifactCacheEntry2;
        ArtifactDiskCache artifactDiskCache;
        ArtifactCacheEntry artifactCacheEntry3;
        ArtifactDiskCache artifactDiskCache2;
        try {
            try {
                if (continuation instanceof ArtifactDiskCache$commit$1) {
                    artifactDiskCache$commit$1 = (ArtifactDiskCache$commit$1) continuation;
                    if ((artifactDiskCache$commit$1.label & Integer.MIN_VALUE) != 0) {
                        artifactDiskCache$commit$1.label -= Integer.MIN_VALUE;
                        Object obj = artifactDiskCache$commit$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = artifactDiskCache$commit$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            artifactCacheEntry2 = this.mutex;
                            artifactDiskCache$commit$1.L$0 = this;
                            artifactDiskCache$commit$1.L$1 = artifactCacheEntry;
                            artifactDiskCache$commit$1.L$2 = artifactCacheEntry2;
                            artifactDiskCache$commit$1.label = 1;
                            if (artifactCacheEntry2.lock((Object) null, artifactDiskCache$commit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            artifactDiskCache = this;
                        } else {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    artifactCacheEntry = (Mutex) artifactDiskCache$commit$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    Unit unit = Unit.INSTANCE;
                                    artifactCacheEntry.unlock((Object) null);
                                    return Unit.INSTANCE;
                                }
                                artifactCacheEntry = (Mutex) artifactDiskCache$commit$1.L$2;
                                artifactCacheEntry3 = (ArtifactCacheEntry) artifactDiskCache$commit$1.L$1;
                                artifactDiskCache2 = (ArtifactDiskCache) artifactDiskCache$commit$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                artifactDiskCache2.entries.remove(artifactCacheEntry3.getReference());
                                artifactDiskCache = artifactDiskCache2;
                                artifactDiskCache$commit$1.L$0 = artifactCacheEntry;
                                artifactDiskCache$commit$1.L$1 = null;
                                artifactDiskCache$commit$1.L$2 = null;
                                artifactDiskCache$commit$1.label = 3;
                                if (artifactDiskCache.trimLocked(artifactDiskCache$commit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Unit unit2 = Unit.INSTANCE;
                                artifactCacheEntry.unlock((Object) null);
                                return Unit.INSTANCE;
                            }
                            ArtifactCacheEntry artifactCacheEntry4 = (Mutex) artifactDiskCache$commit$1.L$2;
                            ArtifactCacheEntry artifactCacheEntry5 = (ArtifactCacheEntry) artifactDiskCache$commit$1.L$1;
                            artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$commit$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            artifactCacheEntry2 = artifactCacheEntry4;
                            artifactCacheEntry = artifactCacheEntry5;
                        }
                        if (artifactCacheEntry.getSize() <= artifactDiskCache.maxBytes) {
                            ArtifactCacheFileSystem artifactCacheFileSystem = artifactDiskCache.fileSystem;
                            String reference = artifactCacheEntry.getReference();
                            artifactDiskCache$commit$1.L$0 = artifactDiskCache;
                            artifactDiskCache$commit$1.L$1 = artifactCacheEntry;
                            artifactDiskCache$commit$1.L$2 = artifactCacheEntry2;
                            artifactDiskCache$commit$1.label = 2;
                            if (artifactCacheFileSystem.delete(reference, artifactDiskCache$commit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            artifactCacheEntry3 = artifactCacheEntry;
                            artifactCacheEntry = artifactCacheEntry2;
                            artifactDiskCache2 = artifactDiskCache;
                            artifactDiskCache2.entries.remove(artifactCacheEntry3.getReference());
                            artifactDiskCache = artifactDiskCache2;
                            artifactDiskCache$commit$1.L$0 = artifactCacheEntry;
                            artifactDiskCache$commit$1.L$1 = null;
                            artifactDiskCache$commit$1.L$2 = null;
                            artifactDiskCache$commit$1.label = 3;
                            if (artifactDiskCache.trimLocked(artifactDiskCache$commit$1) == coroutine_suspended) {
                            }
                            Unit unit22 = Unit.INSTANCE;
                            artifactCacheEntry.unlock((Object) null);
                            return Unit.INSTANCE;
                        }
                        artifactDiskCache.entries.put(artifactCacheEntry.getReference(), artifactCacheEntry);
                        artifactCacheEntry = artifactCacheEntry2;
                        artifactDiskCache$commit$1.L$0 = artifactCacheEntry;
                        artifactDiskCache$commit$1.L$1 = null;
                        artifactDiskCache$commit$1.L$2 = null;
                        artifactDiskCache$commit$1.label = 3;
                        if (artifactDiskCache.trimLocked(artifactDiskCache$commit$1) == coroutine_suspended) {
                        }
                        Unit unit222 = Unit.INSTANCE;
                        artifactCacheEntry.unlock((Object) null);
                        return Unit.INSTANCE;
                    }
                }
                if (artifactCacheEntry.getSize() <= artifactDiskCache.maxBytes) {
                }
            } catch (Throwable th) {
                ArtifactCacheEntry artifactCacheEntry6 = artifactCacheEntry2;
                th = th;
                artifactCacheEntry = artifactCacheEntry6;
                artifactCacheEntry.unlock((Object) null);
                throw th;
            }
            if (i != 0) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        artifactDiskCache$commit$1 = new ArtifactDiskCache$commit$1(this, continuation);
        Object obj2 = artifactDiskCache$commit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactDiskCache$commit$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object discard$artifacts_mainlandRelease(String str, Continuation<? super Unit> continuation) {
        ArtifactDiskCache$discard$1 artifactDiskCache$discard$1;
        int i;
        Mutex mutex;
        ArtifactDiskCache artifactDiskCache;
        try {
            if (continuation instanceof ArtifactDiskCache$discard$1) {
                artifactDiskCache$discard$1 = (ArtifactDiskCache$discard$1) continuation;
                if ((artifactDiskCache$discard$1.label & Integer.MIN_VALUE) != 0) {
                    artifactDiskCache$discard$1.label -= Integer.MIN_VALUE;
                    Object obj = artifactDiskCache$discard$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = artifactDiskCache$discard$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        artifactDiskCache$discard$1.L$0 = this;
                        artifactDiskCache$discard$1.L$1 = str;
                        artifactDiskCache$discard$1.L$2 = mutex;
                        artifactDiskCache$discard$1.label = 1;
                        if (mutex.lock((Object) null, artifactDiskCache$discard$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        artifactDiskCache = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) artifactDiskCache$discard$1.L$2;
                        String str2 = (String) artifactDiskCache$discard$1.L$1;
                        artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$discard$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        str = str2;
                    }
                    artifactDiskCache.entries.remove(str);
                    artifactDiskCache.leaseCounts.remove(str);
                    mutex.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            artifactDiskCache.entries.remove(str);
            artifactDiskCache.leaseCounts.remove(str);
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        artifactDiskCache$discard$1 = new ArtifactDiskCache$discard$1(this, continuation);
        Object obj2 = artifactDiskCache$discard$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactDiskCache$discard$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062 A[Catch: all -> 0x009c, TryCatch #0 {all -> 0x009c, blocks: (B:11:0x0058, B:13:0x0062, B:15:0x006c, B:16:0x0072, B:21:0x0085, B:22:0x009b), top: B:10:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085 A[Catch: all -> 0x009c, TRY_ENTER, TryCatch #0 {all -> 0x009c, blocks: (B:11:0x0058, B:13:0x0062, B:15:0x006c, B:16:0x0072, B:21:0x0085, B:22:0x009b), top: B:10:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object acquire(String str, Continuation<? super Lease> continuation) {
        ArtifactDiskCache$acquire$1 artifactDiskCache$acquire$1;
        int i;
        Mutex mutex;
        ArtifactDiskCache artifactDiskCache;
        try {
            if (continuation instanceof ArtifactDiskCache$acquire$1) {
                artifactDiskCache$acquire$1 = (ArtifactDiskCache$acquire$1) continuation;
                if ((artifactDiskCache$acquire$1.label & Integer.MIN_VALUE) != 0) {
                    artifactDiskCache$acquire$1.label -= Integer.MIN_VALUE;
                    Object obj = artifactDiskCache$acquire$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = artifactDiskCache$acquire$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        artifactDiskCache$acquire$1.L$0 = this;
                        artifactDiskCache$acquire$1.L$1 = str;
                        artifactDiskCache$acquire$1.L$2 = mutex;
                        artifactDiskCache$acquire$1.label = 1;
                        if (mutex.lock((Object) null, artifactDiskCache$acquire$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        artifactDiskCache = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Mutex mutex2 = (Mutex) artifactDiskCache$acquire$1.L$2;
                        String str2 = (String) artifactDiskCache$acquire$1.L$1;
                        artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$acquire$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex2;
                        str = str2;
                    }
                    if (artifactDiskCache.entries.containsKey(str)) {
                        throw new IllegalStateException(("Missing cache entry " + str).toString());
                    }
                    Map<String, Integer> map = artifactDiskCache.leaseCounts;
                    Integer num = map.get(str);
                    map.put(str, Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    return new Lease(artifactDiskCache, str);
                }
            }
            if (artifactDiskCache.entries.containsKey(str)) {
            }
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
        artifactDiskCache$acquire$1 = new ArtifactDiskCache$acquire$1(this, continuation);
        Object obj2 = artifactDiskCache$acquire$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactDiskCache$acquire$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object trim(Continuation<? super Unit> continuation) {
        ArtifactDiskCache$trim$1 artifactDiskCache$trim$1;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        ArtifactDiskCache artifactDiskCache;
        Mutex mutex2;
        Throwable th;
        try {
            if (continuation instanceof ArtifactDiskCache$trim$1) {
                artifactDiskCache$trim$1 = (ArtifactDiskCache$trim$1) continuation;
                if ((artifactDiskCache$trim$1.label & Integer.MIN_VALUE) != 0) {
                    artifactDiskCache$trim$1.label -= Integer.MIN_VALUE;
                    Object obj = artifactDiskCache$trim$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = artifactDiskCache$trim$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.mutex;
                        artifactDiskCache$trim$1.L$0 = this;
                        artifactDiskCache$trim$1.L$1 = mutex;
                        artifactDiskCache$trim$1.label = 1;
                        if (mutex.lock((Object) null, artifactDiskCache$trim$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        artifactDiskCache = this;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) artifactDiskCache$trim$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock((Object) null);
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2.unlock((Object) null);
                                throw th;
                            }
                        }
                        Mutex mutex3 = (Mutex) artifactDiskCache$trim$1.L$1;
                        artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$trim$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex3;
                    }
                    artifactDiskCache$trim$1.L$0 = mutex;
                    artifactDiskCache$trim$1.L$1 = null;
                    artifactDiskCache$trim$1.label = 2;
                    if (artifactDiskCache.trimLocked(artifactDiskCache$trim$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            }
            artifactDiskCache$trim$1.L$0 = mutex;
            artifactDiskCache$trim$1.L$1 = null;
            artifactDiskCache$trim$1.label = 2;
            if (artifactDiskCache.trimLocked(artifactDiskCache$trim$1) != coroutine_suspended) {
            }
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock((Object) null);
            throw th;
        }
        artifactDiskCache$trim$1 = new ArtifactDiskCache$trim$1(this, continuation);
        Object obj2 = artifactDiskCache$trim$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactDiskCache$trim$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00ef -> B:10:0x00f2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object trimLocked(Continuation<? super Unit> continuation) {
        ArtifactDiskCache$trimLocked$1 artifactDiskCache$trimLocked$1;
        int i;
        long j;
        ArtifactDiskCache artifactDiskCache;
        Iterator it;
        if (continuation instanceof ArtifactDiskCache$trimLocked$1) {
            artifactDiskCache$trimLocked$1 = (ArtifactDiskCache$trimLocked$1) continuation;
            if ((artifactDiskCache$trimLocked$1.label & Integer.MIN_VALUE) != 0) {
                artifactDiskCache$trimLocked$1.label -= Integer.MIN_VALUE;
                Object obj = artifactDiskCache$trimLocked$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = artifactDiskCache$trimLocked$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Collection<ArtifactCacheEntry> values = this.entries.values();
                    Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
                    Iterator<T> it2 = values.iterator();
                    j = 0;
                    while (it2.hasNext()) {
                        j += ((ArtifactCacheEntry) it2.next()).getSize();
                    }
                    if (j <= this.maxBytes) {
                        return Unit.INSTANCE;
                    }
                    Collection<ArtifactCacheEntry> values2 = this.entries.values();
                    Intrinsics.checkNotNullExpressionValue(values2, "<get-values>(...)");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : values2) {
                        Integer num = this.leaseCounts.get(((ArtifactCacheEntry) obj2).getReference());
                        if ((num != null ? num.intValue() : 0) == 0) {
                            arrayList.add(obj2);
                        }
                    }
                    artifactDiskCache = this;
                    it = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache$trimLocked$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Long.valueOf(((ArtifactCacheEntry) t).getLastAccessMillis()), Long.valueOf(((ArtifactCacheEntry) t2).getLastAccessMillis()));
                        }
                    }).iterator();
                    if (it.hasNext()) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = artifactDiskCache$trimLocked$1.J$0;
                ArtifactCacheEntry artifactCacheEntry = (ArtifactCacheEntry) artifactDiskCache$trimLocked$1.L$2;
                it = (Iterator) artifactDiskCache$trimLocked$1.L$1;
                artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$trimLocked$1.L$0;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    artifactDiskCache.entries.remove(artifactCacheEntry.getReference());
                    j -= artifactCacheEntry.getSize();
                }
                if (it.hasNext()) {
                    artifactCacheEntry = (ArtifactCacheEntry) it.next();
                    if (j > artifactDiskCache.maxBytes) {
                        ArtifactCacheFileSystem artifactCacheFileSystem = artifactDiskCache.fileSystem;
                        String reference = artifactCacheEntry.getReference();
                        artifactDiskCache$trimLocked$1.L$0 = artifactDiskCache;
                        artifactDiskCache$trimLocked$1.L$1 = it;
                        artifactDiskCache$trimLocked$1.L$2 = artifactCacheEntry;
                        artifactDiskCache$trimLocked$1.J$0 = j;
                        artifactDiskCache$trimLocked$1.label = 1;
                        obj = artifactCacheFileSystem.delete(reference, artifactDiskCache$trimLocked$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) obj).booleanValue()) {
                        }
                        if (it.hasNext()) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
        artifactDiskCache$trimLocked$1 = new ArtifactDiskCache$trimLocked$1(this, continuation);
        Object obj3 = artifactDiskCache$trimLocked$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactDiskCache$trimLocked$1.label;
        if (i != 0) {
        }
    }

    /* compiled from: ArtifactDiskCache.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;", "", "reference", "", "<init>", "(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache;Ljava/lang/String;)V", "closed", "", "close", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final class Lease {
        private boolean closed;
        private final String reference;
        final /* synthetic */ ArtifactDiskCache this$0;

        public Lease(ArtifactDiskCache artifactDiskCache, String str) {
            Intrinsics.checkNotNullParameter(str, "reference");
            this.this$0 = artifactDiskCache;
            this.reference = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00fd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0087 A[Catch: all -> 0x0107, TryCatch #2 {all -> 0x0107, blocks: (B:28:0x00e6, B:29:0x00ef, B:41:0x0083, B:43:0x0087, B:45:0x0097, B:46:0x009d, B:48:0x00a0, B:49:0x00b7, B:51:0x00c6, B:55:0x00d0, B:60:0x00aa), top: B:40:0x0083 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object close(Continuation<? super Unit> continuation) {
            ArtifactDiskCache$Lease$close$1 artifactDiskCache$Lease$close$1;
            int i;
            Mutex mutex;
            ArtifactDiskCache artifactDiskCache;
            Lease lease;
            Lease lease2;
            Mutex mutex2;
            Throwable th;
            try {
                if (continuation instanceof ArtifactDiskCache$Lease$close$1) {
                    artifactDiskCache$Lease$close$1 = (ArtifactDiskCache$Lease$close$1) continuation;
                    if ((artifactDiskCache$Lease$close$1.label & Integer.MIN_VALUE) != 0) {
                        artifactDiskCache$Lease$close$1.label -= Integer.MIN_VALUE;
                        Object obj = artifactDiskCache$Lease$close$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = artifactDiskCache$Lease$close$1.label;
                        boolean z = true;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            mutex = this.this$0.mutex;
                            artifactDiskCache = this.this$0;
                            artifactDiskCache$Lease$close$1.L$0 = this;
                            artifactDiskCache$Lease$close$1.L$1 = mutex;
                            artifactDiskCache$Lease$close$1.L$2 = artifactDiskCache;
                            artifactDiskCache$Lease$close$1.label = 1;
                            if (mutex.lock((Object) null, artifactDiskCache$Lease$close$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            lease = this;
                        } else {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    mutex2 = (Mutex) artifactDiskCache$Lease$close$1.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        Unit unit = Unit.INSTANCE;
                                        mutex2.unlock((Object) null);
                                        return Unit.INSTANCE;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        mutex2.unlock((Object) null);
                                        throw th;
                                    }
                                }
                                artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$Lease$close$1.L$2;
                                Mutex mutex3 = (Mutex) artifactDiskCache$Lease$close$1.L$1;
                                lease2 = (Lease) artifactDiskCache$Lease$close$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    mutex = mutex3;
                                    artifactDiskCache.entries.remove(lease2.reference);
                                    artifactDiskCache$Lease$close$1.L$0 = mutex;
                                    artifactDiskCache$Lease$close$1.L$1 = null;
                                    artifactDiskCache$Lease$close$1.L$2 = null;
                                    artifactDiskCache$Lease$close$1.label = 3;
                                    if (artifactDiskCache.trimLocked(artifactDiskCache$Lease$close$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    mutex2 = mutex;
                                    Unit unit2 = Unit.INSTANCE;
                                    mutex2.unlock((Object) null);
                                    return Unit.INSTANCE;
                                } catch (Throwable th3) {
                                    th = th3;
                                    mutex2 = mutex3;
                                    mutex2.unlock((Object) null);
                                    throw th;
                                }
                            }
                            artifactDiskCache = (ArtifactDiskCache) artifactDiskCache$Lease$close$1.L$2;
                            Mutex mutex4 = (Mutex) artifactDiskCache$Lease$close$1.L$1;
                            lease = (Lease) artifactDiskCache$Lease$close$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            mutex = mutex4;
                        }
                        if (!lease.closed) {
                            lease.closed = true;
                            Integer num = (Integer) artifactDiskCache.leaseCounts.get(lease.reference);
                            int intValue = (num != null ? num.intValue() : 1) - 1;
                            if (intValue <= 0) {
                                artifactDiskCache.leaseCounts.remove(lease.reference);
                            } else {
                                artifactDiskCache.leaseCounts.put(lease.reference, Boxing.boxInt(intValue));
                            }
                            ArtifactCacheEntry artifactCacheEntry = (ArtifactCacheEntry) artifactDiskCache.entries.get(lease.reference);
                            if (artifactCacheEntry == null || !artifactCacheEntry.getTemporaryOversized()) {
                                z = false;
                            }
                            if (z) {
                                ArtifactCacheFileSystem artifactCacheFileSystem = artifactDiskCache.fileSystem;
                                String str = lease.reference;
                                artifactDiskCache$Lease$close$1.L$0 = lease;
                                artifactDiskCache$Lease$close$1.L$1 = mutex;
                                artifactDiskCache$Lease$close$1.L$2 = artifactDiskCache;
                                artifactDiskCache$Lease$close$1.label = 2;
                                if (artifactCacheFileSystem.delete(str, artifactDiskCache$Lease$close$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                lease2 = lease;
                                artifactDiskCache.entries.remove(lease2.reference);
                            }
                            artifactDiskCache$Lease$close$1.L$0 = mutex;
                            artifactDiskCache$Lease$close$1.L$1 = null;
                            artifactDiskCache$Lease$close$1.L$2 = null;
                            artifactDiskCache$Lease$close$1.label = 3;
                            if (artifactDiskCache.trimLocked(artifactDiskCache$Lease$close$1) == coroutine_suspended) {
                            }
                        }
                        mutex2 = mutex;
                        Unit unit22 = Unit.INSTANCE;
                        mutex2.unlock((Object) null);
                        return Unit.INSTANCE;
                    }
                }
                if (!lease.closed) {
                }
                mutex2 = mutex;
                Unit unit222 = Unit.INSTANCE;
                mutex2.unlock((Object) null);
                return Unit.INSTANCE;
            } catch (Throwable th4) {
                mutex2 = mutex;
                th = th4;
                mutex2.unlock((Object) null);
                throw th;
            }
            artifactDiskCache$Lease$close$1 = new ArtifactDiskCache$Lease$close$1(this, continuation);
            Object obj2 = artifactDiskCache$Lease$close$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = artifactDiskCache$Lease$close$1.label;
            boolean z2 = true;
            if (i != 0) {
            }
        }
    }
}
