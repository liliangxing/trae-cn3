package com.bytedance.timonbase.sensitive.detect.cacher;

import android.app.Application;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMSensitiveContentCacheManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0005J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/timonbase/sensitive/detect/cacher/TMSensitiveContentCacheManager;", "", "()V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "cacheTable", "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache;", "getCacheTable", "()Ljava/util/concurrent/ConcurrentHashMap;", "cacheTable$delegate", "Lkotlin/Lazy;", "defaultCacheNum", "getCacheNum", DBData.FIELD_TYPE, "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache$Type;", "getSensitiveContentCacheByType", "injectCacheNum", "", "num", "registerSensitiveContentCacheByType", "cache", "replace", "", "AppListDataCache", "ClipboardContentCache", "LocationDataCache", "StorageDataCache", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMSensitiveContentCacheManager {
    public static final TMSensitiveContentCacheManager INSTANCE = new TMSensitiveContentCacheManager();

    /* renamed from: cacheTable$delegate, reason: from kotlin metadata */
    private static final Lazy cacheTable = LazyKt.lazy(new Function0<ConcurrentHashMap<String, ISensitiveContentCache>>() { // from class: com.bytedance.timonbase.sensitive.detect.cacher.TMSensitiveContentCacheManager$cacheTable$2
        public final ConcurrentHashMap<String, ISensitiveContentCache> invoke() {
            return new ConcurrentHashMap<>();
        }
    });
    private static int defaultCacheNum = 5;
    private static final ConcurrentHashMap<String, Integer> cacheMap = new ConcurrentHashMap<>();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ISensitiveContentCache.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ISensitiveContentCache.Type.CLIPBOARD.ordinal()] = 1;
            iArr[ISensitiveContentCache.Type.LOCATION.ordinal()] = 2;
            iArr[ISensitiveContentCache.Type.STORAGE_B.ordinal()] = 3;
            iArr[ISensitiveContentCache.Type.STORAGE_KB.ordinal()] = 4;
            iArr[ISensitiveContentCache.Type.STORAGE_MB.ordinal()] = 5;
            iArr[ISensitiveContentCache.Type.STORAGE_FREE_B.ordinal()] = 6;
            iArr[ISensitiveContentCache.Type.STORAGE_FREE_KB.ordinal()] = 7;
            iArr[ISensitiveContentCache.Type.STORAGE_FREE_MB.ordinal()] = 8;
            iArr[ISensitiveContentCache.Type.APPLIST.ordinal()] = 9;
            iArr[ISensitiveContentCache.Type.FIRST_INSTALL_TIME.ordinal()] = 10;
            iArr[ISensitiveContentCache.Type.LAST_UPDATE_TIME.ordinal()] = 11;
        }
    }

    private final ConcurrentHashMap<String, ISensitiveContentCache> getCacheTable() {
        return (ConcurrentHashMap) cacheTable.getValue();
    }

    private TMSensitiveContentCacheManager() {
    }

    @Deprecated(message = "using string")
    public final void injectCacheNum(ISensitiveContentCache.Type type, int num) {
        if (type != null) {
            cacheMap.put(type.name(), Integer.valueOf(num));
        } else {
            defaultCacheNum = num;
        }
    }

    public final void injectCacheNum(String type, int num) {
        if (type != null) {
            cacheMap.put(type, Integer.valueOf(num));
        } else {
            defaultCacheNum = num;
        }
    }

    @Deprecated(message = "using string")
    public final int getCacheNum(ISensitiveContentCache.Type type) {
        Intrinsics.checkParameterIsNotNull(type, DBData.FIELD_TYPE);
        Integer num = cacheMap.get(type.name());
        return num != null ? num.intValue() : defaultCacheNum;
    }

    public final int getCacheNum(String type) {
        Intrinsics.checkParameterIsNotNull(type, DBData.FIELD_TYPE);
        Integer num = cacheMap.get(type);
        return num != null ? num.intValue() : defaultCacheNum;
    }

    /* compiled from: TMSensitiveContentCacheManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/timonbase/sensitive/detect/cacher/TMSensitiveContentCacheManager$ClipboardContentCache;", "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache;", "cacheNum", "", "(I)V", "getCacheNum", "()I", "setCacheNum", "contentCacheList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/timonbase/sensitive/detect/cacher/SensitiveCachedContent;", "getContentCacheList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "contentCacheList$delegate", "Lkotlin/Lazy;", "cacheContent", "", ReportConstant.COMMON_CONTENT, "cacheOriginContent", "", "getCacheContent", "", "getOriginCacheContent", "hasCache", "", DBData.FIELD_TYPE, "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache$Type;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ClipboardContentCache implements ISensitiveContentCache {
        private int cacheNum;

        /* renamed from: contentCacheList$delegate, reason: from kotlin metadata */
        private final Lazy contentCacheList = LazyKt.lazy(new Function0<CopyOnWriteArrayList<SensitiveCachedContent>>() { // from class: com.bytedance.timonbase.sensitive.detect.cacher.TMSensitiveContentCacheManager$ClipboardContentCache$contentCacheList$2
            public final CopyOnWriteArrayList<SensitiveCachedContent> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });

        private final CopyOnWriteArrayList<SensitiveCachedContent> getContentCacheList() {
            return (CopyOnWriteArrayList) this.contentCacheList.getValue();
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public void cacheOriginContent(Object content) {
            Intrinsics.checkParameterIsNotNull(content, ReportConstant.COMMON_CONTENT);
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public List<Object> getOriginCacheContent() {
            return null;
        }

        public ClipboardContentCache(int i) {
            this.cacheNum = i;
        }

        public final int getCacheNum() {
            return this.cacheNum;
        }

        public final void setCacheNum(int i) {
            this.cacheNum = i;
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public ISensitiveContentCache.Type type() {
            return ISensitiveContentCache.Type.CLIPBOARD;
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public List<SensitiveCachedContent> getCacheContent() {
            return getContentCacheList();
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public void cacheContent(SensitiveCachedContent content) {
            Intrinsics.checkParameterIsNotNull(content, ReportConstant.COMMON_CONTENT);
            if (getContentCacheList().contains(content)) {
                getContentCacheList().remove(content);
            }
            while (getContentCacheList().size() >= this.cacheNum) {
                getContentCacheList().remove(0);
            }
            getContentCacheList().add(content);
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public boolean hasCache() {
            return !getContentCacheList().isEmpty();
        }
    }

    /* compiled from: TMSensitiveContentCacheManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR'\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/timonbase/sensitive/detect/cacher/TMSensitiveContentCacheManager$LocationDataCache;", "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache;", "cacheNum", "", "(I)V", "getCacheNum", "()I", "setCacheNum", "contentCacheList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/timonbase/sensitive/detect/cacher/SensitiveCachedContent;", "getContentCacheList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "contentCacheList$delegate", "Lkotlin/Lazy;", "contentCacheOriginList", "", "", "getContentCacheOriginList", "contentCacheOriginList$delegate", "cacheContent", "", ReportConstant.COMMON_CONTENT, "cacheOriginContent", "", "getCacheContent", "", "getOriginCacheContent", "hasCache", "", DBData.FIELD_TYPE, "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache$Type;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class LocationDataCache implements ISensitiveContentCache {
        private int cacheNum;

        /* renamed from: contentCacheList$delegate, reason: from kotlin metadata */
        private final Lazy contentCacheList = LazyKt.lazy(new Function0<CopyOnWriteArrayList<SensitiveCachedContent>>() { // from class: com.bytedance.timonbase.sensitive.detect.cacher.TMSensitiveContentCacheManager$LocationDataCache$contentCacheList$2
            public final CopyOnWriteArrayList<SensitiveCachedContent> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });

        /* renamed from: contentCacheOriginList$delegate, reason: from kotlin metadata */
        private final Lazy contentCacheOriginList = LazyKt.lazy(new Function0<CopyOnWriteArrayList<String[]>>() { // from class: com.bytedance.timonbase.sensitive.detect.cacher.TMSensitiveContentCacheManager$LocationDataCache$contentCacheOriginList$2
            public final CopyOnWriteArrayList<String[]> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });

        private final CopyOnWriteArrayList<SensitiveCachedContent> getContentCacheList() {
            return (CopyOnWriteArrayList) this.contentCacheList.getValue();
        }

        private final CopyOnWriteArrayList<String[]> getContentCacheOriginList() {
            return (CopyOnWriteArrayList) this.contentCacheOriginList.getValue();
        }

        public LocationDataCache(int i) {
            this.cacheNum = i;
        }

        public final int getCacheNum() {
            return this.cacheNum;
        }

        public final void setCacheNum(int i) {
            this.cacheNum = i;
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public ISensitiveContentCache.Type type() {
            return ISensitiveContentCache.Type.LOCATION;
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public List<SensitiveCachedContent> getCacheContent() {
            return getContentCacheList();
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public List<Object> getOriginCacheContent() {
            return getContentCacheOriginList();
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public void cacheContent(SensitiveCachedContent content) {
            Intrinsics.checkParameterIsNotNull(content, ReportConstant.COMMON_CONTENT);
            if (getContentCacheList().contains(content)) {
                getContentCacheList().remove(content);
            }
            while (getContentCacheList().size() >= this.cacheNum) {
                getContentCacheList().remove(0);
            }
            getContentCacheList().add(content);
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public void cacheOriginContent(Object content) {
            Intrinsics.checkParameterIsNotNull(content, ReportConstant.COMMON_CONTENT);
            String[] strArr = (String[]) content;
            Iterator<String[]> it = getContentCacheOriginList().iterator();
            Intrinsics.checkExpressionValueIsNotNull(it, "contentCacheOriginList.iterator()");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String[] next = it.next();
                if (Arrays.equals(next, strArr)) {
                    getContentCacheOriginList().remove(next);
                    break;
                }
            }
            while (getContentCacheOriginList().size() >= this.cacheNum) {
                getContentCacheOriginList().remove(0);
            }
            getContentCacheOriginList().add(strArr);
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public boolean hasCache() {
            return !getContentCacheList().isEmpty();
        }
    }

    /* compiled from: TMSensitiveContentCacheManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/timonbase/sensitive/detect/cacher/TMSensitiveContentCacheManager$StorageDataCache;", "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache;", "cacheNum", "", "(I)V", "getCacheNum", "()I", "setCacheNum", "contentCacheList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/timonbase/sensitive/detect/cacher/SensitiveCachedContent;", "getContentCacheList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "contentCacheList$delegate", "Lkotlin/Lazy;", "cacheContent", "", ReportConstant.COMMON_CONTENT, "cacheOriginContent", "", "getCacheContent", "", "getOriginCacheContent", "hasCache", "", DBData.FIELD_TYPE, "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache$Type;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class StorageDataCache implements ISensitiveContentCache {
        private int cacheNum;

        /* renamed from: contentCacheList$delegate, reason: from kotlin metadata */
        private final Lazy contentCacheList = LazyKt.lazy(new Function0<CopyOnWriteArrayList<SensitiveCachedContent>>() { // from class: com.bytedance.timonbase.sensitive.detect.cacher.TMSensitiveContentCacheManager$StorageDataCache$contentCacheList$2
            public final CopyOnWriteArrayList<SensitiveCachedContent> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });

        private final CopyOnWriteArrayList<SensitiveCachedContent> getContentCacheList() {
            return (CopyOnWriteArrayList) this.contentCacheList.getValue();
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public void cacheOriginContent(Object content) {
            Intrinsics.checkParameterIsNotNull(content, ReportConstant.COMMON_CONTENT);
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public List<Object> getOriginCacheContent() {
            return null;
        }

        public StorageDataCache(int i) {
            this.cacheNum = i;
        }

        public final int getCacheNum() {
            return this.cacheNum;
        }

        public final void setCacheNum(int i) {
            this.cacheNum = i;
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public ISensitiveContentCache.Type type() {
            return ISensitiveContentCache.Type.STORAGE;
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public List<SensitiveCachedContent> getCacheContent() {
            return getContentCacheList();
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public void cacheContent(SensitiveCachedContent content) {
            Intrinsics.checkParameterIsNotNull(content, ReportConstant.COMMON_CONTENT);
            if (getContentCacheList().contains(content)) {
                getContentCacheList().remove(content);
            }
            while (getContentCacheList().size() >= this.cacheNum) {
                getContentCacheList().remove(0);
            }
            getContentCacheList().add(content);
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public boolean hasCache() {
            return !getContentCacheList().isEmpty();
        }
    }

    /* compiled from: TMSensitiveContentCacheManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/timonbase/sensitive/detect/cacher/TMSensitiveContentCacheManager$AppListDataCache;", "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache;", "cacheNum", "", "(I)V", "getCacheNum", "()I", "setCacheNum", "contentCacheList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/timonbase/sensitive/detect/cacher/SensitiveCachedContent;", "getContentCacheList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "contentCacheList$delegate", "Lkotlin/Lazy;", "cacheContent", "", ReportConstant.COMMON_CONTENT, "cacheOriginContent", "", "getCacheContent", "", "getOriginCacheContent", "hasCache", "", DBData.FIELD_TYPE, "Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache$Type;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AppListDataCache implements ISensitiveContentCache {
        private int cacheNum;

        /* renamed from: contentCacheList$delegate, reason: from kotlin metadata */
        private final Lazy contentCacheList = LazyKt.lazy(new Function0<CopyOnWriteArrayList<SensitiveCachedContent>>() { // from class: com.bytedance.timonbase.sensitive.detect.cacher.TMSensitiveContentCacheManager$AppListDataCache$contentCacheList$2
            public final CopyOnWriteArrayList<SensitiveCachedContent> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });

        private final CopyOnWriteArrayList<SensitiveCachedContent> getContentCacheList() {
            return (CopyOnWriteArrayList) this.contentCacheList.getValue();
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public void cacheOriginContent(Object content) {
            Intrinsics.checkParameterIsNotNull(content, ReportConstant.COMMON_CONTENT);
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public List<Object> getOriginCacheContent() {
            return null;
        }

        public AppListDataCache(int i) {
            this.cacheNum = i;
        }

        public final int getCacheNum() {
            return this.cacheNum;
        }

        public final void setCacheNum(int i) {
            this.cacheNum = i;
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public ISensitiveContentCache.Type type() {
            return ISensitiveContentCache.Type.APPLIST;
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public List<SensitiveCachedContent> getCacheContent() {
            return getContentCacheList();
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public void cacheContent(SensitiveCachedContent content) {
            Intrinsics.checkParameterIsNotNull(content, ReportConstant.COMMON_CONTENT);
            ArrayList arrayListOf = CollectionsKt.arrayListOf(new String[]{"android", SiteMessageParams.platform, "ANDROID"});
            Object sensitiveContent = content.getSensitiveContent();
            Application application = TMEnv.INSTANCE.getApplication();
            if (sensitiveContent.equals(application != null ? application.getPackageName() : null) || CollectionsKt.contains(arrayListOf, content.getSensitiveContent())) {
                return;
            }
            if (getContentCacheList().contains(content)) {
                getContentCacheList().remove(content);
            }
            while (getContentCacheList().size() >= this.cacheNum) {
                getContentCacheList().remove(0);
            }
            getContentCacheList().add(content);
        }

        @Override // com.bytedance.timonbase.sensitive.detect.cacher.ISensitiveContentCache
        public boolean hasCache() {
            return !getContentCacheList().isEmpty();
        }
    }

    @Deprecated(message = "using string")
    public final ISensitiveContentCache getSensitiveContentCacheByType(ISensitiveContentCache.Type type) {
        Intrinsics.checkParameterIsNotNull(type, DBData.FIELD_TYPE);
        return getCacheTable().get(type.name());
    }

    public final ISensitiveContentCache getSensitiveContentCacheByType(String type) {
        Intrinsics.checkParameterIsNotNull(type, DBData.FIELD_TYPE);
        return getCacheTable().get(type);
    }

    public static /* synthetic */ void registerSensitiveContentCacheByType$default(TMSensitiveContentCacheManager tMSensitiveContentCacheManager, String str, ISensitiveContentCache iSensitiveContentCache, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        tMSensitiveContentCacheManager.registerSensitiveContentCacheByType(str, iSensitiveContentCache, z);
    }

    public final void registerSensitiveContentCacheByType(String type, ISensitiveContentCache cache, boolean replace) {
        Intrinsics.checkParameterIsNotNull(type, DBData.FIELD_TYPE);
        Intrinsics.checkParameterIsNotNull(cache, "cache");
        synchronized (getCacheTable()) {
            if (!replace) {
                TMSensitiveContentCacheManager tMSensitiveContentCacheManager = INSTANCE;
                if (!tMSensitiveContentCacheManager.getCacheTable().contains(type)) {
                    tMSensitiveContentCacheManager.getCacheTable().put(type, cache);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Deprecated(message = "using string")
    public final void registerSensitiveContentCacheByType(ISensitiveContentCache.Type type) {
        Intrinsics.checkParameterIsNotNull(type, DBData.FIELD_TYPE);
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                registerSensitiveContentCacheByType$default(this, type.name(), new ClipboardContentCache(getCacheNum(type)), false, 4, null);
                return;
            case 2:
                registerSensitiveContentCacheByType$default(this, type.name(), new LocationDataCache(getCacheNum(type)), false, 4, null);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                registerSensitiveContentCacheByType$default(this, type.name(), new StorageDataCache(getCacheNum(type)), false, 4, null);
                return;
            case 9:
            case 10:
            case 11:
                registerSensitiveContentCacheByType$default(this, type.name(), new AppListDataCache(getCacheNum(type)), false, 4, null);
                return;
            default:
                return;
        }
    }
}
