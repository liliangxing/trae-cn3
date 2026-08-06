package com.bytedance.ies.bullet.kit.resourceloader.memory;

import android.os.FileObserver;
import android.util.LruCache;
import bolts.Task;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0005\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u001c\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\fJ\u0012\u0010\u001d\u001a\u00020\f*\u00020\f2\u0006\u0010\u0018\u001a\u00020\fR\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/memory/MemoryManager;", "", "()V", "byteMemory", "Landroid/util/LruCache;", "", "", "highByteMemory", "observerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/os/FileObserver;", "resMap", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "clearAllCache", "", "clearCacheWithKey", "info", "getByteArrayCache", "getResourceInfoWithKey", "cacheKey", EventConstants.PARAM_SOURCE_INIT, "maxMem", "", "updateByteArrayCache", "origin", "", "", "updateResourceInfo", "resInfo", PraiseDialogConstant.FROM, "Companion", "SingletonHolder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MemoryManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private LruCache<String, byte[]> byteMemory;
    private LruCache<String, byte[]> highByteMemory;
    private final ConcurrentHashMap<String, FileObserver> observerMap;
    private final ConcurrentHashMap<String, ResourceInfo> resMap;

    public /* synthetic */ MemoryManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MemoryManager() {
        this.resMap = new ConcurrentHashMap<>();
        this.observerMap = new ConcurrentHashMap<>();
    }

    public final void init(final int maxMem) {
        if (maxMem < 1) {
            return;
        }
        LruCache<String, byte[]> lruCache = this.byteMemory;
        if (lruCache != null) {
            if ((lruCache != null ? lruCache.maxSize() : 0) <= maxMem) {
                return;
            }
        }
        clearAllCache();
        this.byteMemory = new LruCache<String, byte[]>(maxMem) { // from class: com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager$init$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, byte[] value) {
                if (value != null) {
                    return value.length;
                }
                return 0;
            }
        };
        this.highByteMemory = new LruCache<String, byte[]>(maxMem) { // from class: com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager$init$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, byte[] value) {
                if (value != null) {
                    return value.length;
                }
                return 0;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager$updateResourceInfo$obsrv$1, java.lang.Object] */
    public final void updateResourceInfo(String cacheKey, final ResourceInfo resInfo) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        boolean z = true;
        if (cacheKey.length() == 0) {
            return;
        }
        String filePath = resInfo.getFilePath();
        if (filePath != null && filePath.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        try {
            final String filePath2 = resInfo.getFilePath();
            final int i = 1536;
            ?? r1 = new FileObserver(i, filePath2) { // from class: com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager$updateResourceInfo$obsrv$1
                @Override // android.os.FileObserver
                public void onEvent(int event, String path) {
                    if (event == 512 || event == 1024) {
                        this.clearCacheWithKey(resInfo);
                    }
                }
            };
            this.resMap.put(cacheKey, resInfo);
            FileObserver fileObserver = this.observerMap.get(cacheKey);
            if (fileObserver != null) {
                fileObserver.stopWatching();
            }
            r1.startWatching();
            this.observerMap.put(cacheKey, r1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void updateByteArrayCache(final ResourceInfo info, final List<Byte> origin) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(origin, "origin");
        final String cacheKey = info.getCacheKey();
        if (cacheKey == null) {
            cacheKey = "";
        }
        if ((cacheKey.length() == 0) || origin.isEmpty()) {
            return;
        }
        Task.call(new Callable() { // from class: com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager$updateByteArrayCache$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                LruCache lruCache;
                LruCache lruCache2;
                try {
                    String filePath = ResourceInfo.this.getFilePath();
                    if (filePath == null) {
                        filePath = null;
                    }
                    FileInputStream fileInputStream = new FileInputStream(new File(filePath));
                    if ((!origin.isEmpty()) && fileInputStream.available() == origin.size()) {
                        if (!Intrinsics.areEqual(ResourceInfo.this.getMemoryCachePriority(), "high")) {
                            lruCache2 = this.byteMemory;
                            if (lruCache2 != null) {
                            }
                        } else {
                            lruCache = this.highByteMemory;
                            if (lruCache != null) {
                            }
                        }
                    }
                    fileInputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, Task.BACKGROUND_EXECUTOR);
    }

    public final void clearAllCache() {
        this.resMap.clear();
        LruCache<String, byte[]> lruCache = this.byteMemory;
        if (lruCache != null) {
            lruCache.evictAll();
        }
        LruCache<String, byte[]> lruCache2 = this.highByteMemory;
        if (lruCache2 != null) {
            lruCache2.evictAll();
        }
        this.observerMap.clear();
    }

    public final byte[] getByteArrayCache(ResourceInfo info) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(info, "info");
        String cacheKey = info.getCacheKey();
        String str = cacheKey;
        if (str == null || str.length() == 0) {
            return null;
        }
        LruCache<String, byte[]> lruCache = this.highByteMemory;
        if (lruCache != null && (bArr = lruCache.get(cacheKey)) != null) {
            return bArr;
        }
        LruCache<String, byte[]> lruCache2 = this.byteMemory;
        if (lruCache2 != null) {
            return lruCache2.get(cacheKey);
        }
        return null;
    }

    public final void clearCacheWithKey(ResourceInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        String cacheKey = info.getCacheKey();
        if (cacheKey == null) {
            cacheKey = "";
        }
        if (cacheKey.length() == 0) {
            return;
        }
        this.resMap.remove(cacheKey);
        LruCache<String, byte[]> lruCache = this.byteMemory;
        if (lruCache != null) {
            lruCache.remove(cacheKey);
        }
        LruCache<String, byte[]> lruCache2 = this.highByteMemory;
        if (lruCache2 != null) {
            lruCache2.remove(cacheKey);
        }
        this.observerMap.remove(cacheKey);
    }

    public final ResourceInfo getResourceInfoWithKey(String cacheKey) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        ResourceInfo resourceInfo = this.resMap.get(cacheKey);
        if (resourceInfo == null) {
            return null;
        }
        ResourceInfo from = from(new ResourceInfo(resourceInfo.getSrcUri(), null, null, null, false, 0L, false, null, null, null, 0L, null, 4094, null), resourceInfo);
        from.setCacheKey(cacheKey);
        LruCache<String, byte[]> lruCache = this.highByteMemory;
        if (lruCache == null || (bArr = lruCache.get(cacheKey)) == null) {
            LruCache<String, byte[]> lruCache2 = this.byteMemory;
            bArr = lruCache2 != null ? lruCache2.get(cacheKey) : null;
        }
        if (bArr != null) {
            from.setFileStream(new ByteArrayInputStream(bArr));
            from.setByteArray(bArr);
        }
        return from;
    }

    /* compiled from: MemoryManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/memory/MemoryManager$Companion;", "", "()V", "getInstance", "Lcom/bytedance/ies/bullet/kit/resourceloader/memory/MemoryManager;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MemoryManager getInstance() {
            return SingletonHolder.INSTANCE.getHolder();
        }
    }

    /* compiled from: MemoryManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/memory/MemoryManager$SingletonHolder;", "", "()V", "holder", "Lcom/bytedance/ies/bullet/kit/resourceloader/memory/MemoryManager;", "getHolder", "()Lcom/bytedance/ies/bullet/kit/resourceloader/memory/MemoryManager;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        private static final MemoryManager holder = new MemoryManager(null);

        private SingletonHolder() {
        }

        public final MemoryManager getHolder() {
            return holder;
        }
    }

    public final ResourceInfo from(ResourceInfo resourceInfo, ResourceInfo resourceInfo2) {
        Intrinsics.checkNotNullParameter(resourceInfo, "<this>");
        Intrinsics.checkNotNullParameter(resourceInfo2, "origin");
        resourceInfo.setFilePath(resourceInfo2.getFilePath());
        resourceInfo.setType(resourceInfo2.getType());
        resourceInfo.setFrom(resourceInfo2.getFrom());
        resourceInfo.setCache(resourceInfo2.getIsCache());
        resourceInfo.setVersion(resourceInfo2.getVersion());
        resourceInfo.setStatisic(resourceInfo2.getStatisic());
        resourceInfo.setFileStream(resourceInfo2.getFileStream());
        resourceInfo.setModel(resourceInfo2.getModel());
        resourceInfo.setCacheKey(resourceInfo2.getCacheKey());
        resourceInfo.setFromMemory(resourceInfo2.getIsFromMemory());
        resourceInfo.setResTag(resourceInfo2.getResTag());
        resourceInfo.setChannel(resourceInfo2.getChannel());
        resourceInfo.setBundle(resourceInfo2.getBundle());
        resourceInfo.setAccessKey(resourceInfo2.getAccessKey());
        resourceInfo.setEnableMemory(resourceInfo2.getEnableMemory());
        resourceInfo.setMemoryCachePriority(resourceInfo2.getMemoryCachePriority());
        resourceInfo.setSuccessLoader(resourceInfo2.getSuccessLoader());
        resourceInfo.setStartLoadTime(resourceInfo2.getStartLoadTime());
        resourceInfo.setSdkVersion(resourceInfo2.getSdkVersion());
        resourceInfo.setPerformanceInfo(resourceInfo2.getPerformanceInfo());
        resourceInfo.setCommonReportInfo(resourceInfo2.getCommonReportInfo());
        resourceInfo.setWebResourceResponse(resourceInfo2.getWebResourceResponse());
        resourceInfo.setCdnSafeUrl(resourceInfo2.getCdnSafeUrl());
        return resourceInfo;
    }
}
