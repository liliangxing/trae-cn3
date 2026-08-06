package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.android.anniex.scene.utils.SceneLoggerUtils;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AViewSignalBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0006\u0010\u0012\u001a\u00020\u0007RP\u0010\u0003\u001aB\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007 \u0006* \u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00040\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/AViewSignalBuffer;", "", "()V", "viewAttachEventBuffer", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Lcom/bytedance/android/anniex/scene/core/ViewAttachEvent;", "kotlin.jvm.PlatformType", "", "viewCount", "", "windowDurationMs", "", "windowStartTime", "collectCurrentUrls", "Lcom/bytedance/android/anniex/scene/core/AViewSignalBuffer$RowViewAttachInfo;", "receive", "", "viewAttachEvent", "shouldCollectNow", "RowViewAttachInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AViewSignalBuffer {
    private volatile int viewCount;
    private long windowStartTime;
    private final long windowDurationMs = SwitchCenter.INSTANCE.getHybridViewWindowDurationMs();
    private final ConcurrentHashMap.KeySetView<ViewAttachEvent, Boolean> viewAttachEventBuffer = ConcurrentHashMap.newKeySet();

    public final void receive(final ViewAttachEvent viewAttachEvent) {
        Intrinsics.checkNotNullParameter(viewAttachEvent, "viewAttachEvent");
        SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.core.AViewSignalBuffer$receive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                return "【AViewSignalBuffer】收到加载信号：" + ViewAttachEvent.this.getUrl();
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        if (this.windowStartTime == 0) {
            this.windowStartTime = currentTimeMillis;
        }
        this.viewCount++;
        this.viewAttachEventBuffer.add(viewAttachEvent);
    }

    public final boolean shouldCollectNow() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.windowStartTime;
        return j > 0 && currentTimeMillis - j >= this.windowDurationMs;
    }

    public final RowViewAttachInfo collectCurrentUrls() {
        ConcurrentHashMap.KeySetView<ViewAttachEvent, Boolean> keySetView = this.viewAttachEventBuffer;
        Intrinsics.checkNotNullExpressionValue(keySetView, "viewAttachEventBuffer");
        Set set = CollectionsKt.toSet(keySetView);
        int i = this.viewCount;
        this.viewAttachEventBuffer.clear();
        this.viewCount = 0;
        this.windowStartTime = 0L;
        return new RowViewAttachInfo(set, i);
    }

    /* compiled from: AViewSignalBuffer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/AViewSignalBuffer$RowViewAttachInfo;", "", "attachEvent", "", "Lcom/bytedance/android/anniex/scene/core/ViewAttachEvent;", "viewCount", "", "(Ljava/util/Set;I)V", "getAttachEvent", "()Ljava/util/Set;", "getViewCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class RowViewAttachInfo {
        private final Set<ViewAttachEvent> attachEvent;
        private final int viewCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RowViewAttachInfo copy$default(RowViewAttachInfo rowViewAttachInfo, Set set, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                set = rowViewAttachInfo.attachEvent;
            }
            if ((i2 & 2) != 0) {
                i = rowViewAttachInfo.viewCount;
            }
            return rowViewAttachInfo.copy(set, i);
        }

        public final Set<ViewAttachEvent> component1() {
            return this.attachEvent;
        }

        /* renamed from: component2, reason: from getter */
        public final int getViewCount() {
            return this.viewCount;
        }

        public final RowViewAttachInfo copy(Set<ViewAttachEvent> attachEvent, int viewCount) {
            Intrinsics.checkNotNullParameter(attachEvent, "attachEvent");
            return new RowViewAttachInfo(attachEvent, viewCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RowViewAttachInfo)) {
                return false;
            }
            RowViewAttachInfo rowViewAttachInfo = (RowViewAttachInfo) other;
            return Intrinsics.areEqual(this.attachEvent, rowViewAttachInfo.attachEvent) && this.viewCount == rowViewAttachInfo.viewCount;
        }

        public int hashCode() {
            return (this.attachEvent.hashCode() * 31) + Integer.hashCode(this.viewCount);
        }

        public String toString() {
            return "RowViewAttachInfo(attachEvent=" + this.attachEvent + ", viewCount=" + this.viewCount + ')';
        }

        public RowViewAttachInfo(Set<ViewAttachEvent> set, int i) {
            Intrinsics.checkNotNullParameter(set, "attachEvent");
            this.attachEvent = set;
            this.viewCount = i;
        }

        public final Set<ViewAttachEvent> getAttachEvent() {
            return this.attachEvent;
        }

        public final int getViewCount() {
            return this.viewCount;
        }
    }
}
