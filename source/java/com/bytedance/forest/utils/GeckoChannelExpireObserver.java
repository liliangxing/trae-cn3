package com.bytedance.forest.utils;

import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.model.GeckoModel;
import com.bytedance.iesgurd.IESGurdObserver;
import com.bytedance.iesgurd.IESGurdObserverAccessInfo;
import com.bytedance.iesgurd.IESGurdObserverCleanInfo;
import com.bytedance.iesgurd.IESGurdObserverUpdateInfo;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/forest/utils/GeckoChannelExpireObserver;", "Lcom/bytedance/iesgurd/IESGurdObserver;", "Ljava/io/Closeable;", "cacheItem", "Lcom/bytedance/forest/utils/MemoryCacheItem;", "(Lcom/bytedance/forest/utils/MemoryCacheItem;)V", "cacheItemRef", "Ljava/lang/ref/WeakReference;", "observeKey", "", "getObserveKey$forest_release", "()Ljava/lang/String;", EventReport.DIALOG_CLOSE, "", "onResClean", "info", "Lcom/bytedance/iesgurd/IESGurdObserverCleanInfo;", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoChannelExpireObserver implements IESGurdObserver, Closeable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WeakReference<MemoryCacheItem> cacheItemRef;
    private final String observeKey;

    /* compiled from: MemoryManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/forest/utils/GeckoChannelExpireObserver$Companion;", "", "()V", "buildObserveKey", "", "ak", "channel", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String buildObserveKey(String ak, String channel) {
            Intrinsics.checkParameterIsNotNull(ak, "ak");
            Intrinsics.checkParameterIsNotNull(channel, "channel");
            return ak + '/' + channel;
        }
    }

    public GeckoChannelExpireObserver(MemoryCacheItem memoryCacheItem) {
        Intrinsics.checkParameterIsNotNull(memoryCacheItem, "cacheItem");
        this.cacheItemRef = new WeakReference<>(memoryCacheItem);
        GeckoModel geckoModel = memoryCacheItem.getResponse().getRequest().getGeckoModel();
        this.observeKey = INSTANCE.buildObserveKey(geckoModel.getAccessKey(), geckoModel.getChannel());
    }

    public void onResAccess(IESGurdObserverAccessInfo iESGurdObserverAccessInfo) {
        Intrinsics.checkParameterIsNotNull(iESGurdObserverAccessInfo, "info");
        IESGurdObserver.DefaultImpls.onResAccess(this, iESGurdObserverAccessInfo);
    }

    public void onResUpdate(IESGurdObserverUpdateInfo iESGurdObserverUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(iESGurdObserverUpdateInfo, "info");
        IESGurdObserver.DefaultImpls.onResUpdate(this, iESGurdObserverUpdateInfo);
    }

    /* renamed from: getObserveKey$forest_release, reason: from getter */
    public final String getObserveKey() {
        return this.observeKey;
    }

    public void onResClean(IESGurdObserverCleanInfo info) {
        Intrinsics.checkParameterIsNotNull(info, "info");
        MemoryCacheItem memoryCacheItem = this.cacheItemRef.get();
        if (memoryCacheItem == null) {
            close();
            return;
        }
        GeckoModel geckoModel = memoryCacheItem.getResponse().getRequest().getGeckoModel();
        if ((!Intrinsics.areEqual(info.getAccessKey(), geckoModel.getAccessKey())) || (!Intrinsics.areEqual(info.getChannel(), geckoModel.getChannel()))) {
            return;
        }
        LogUtils.i$default(LogUtils.INSTANCE, MemoryManager.TAG, "remove [" + memoryCacheItem.getResponse().getRequest().getForest().getMemoryManager().removeCache(memoryCacheItem.getResponse().getRequest().getCacheKey$forest_release()) + "] cause by gecko clean " + info.getAccessKey() + '/' + info.getChannel(), false, null, null, null, 60, null);
        close();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MemoryManager.INSTANCE.unRegisterGeckoExpireObserver$forest_release(this);
    }
}
