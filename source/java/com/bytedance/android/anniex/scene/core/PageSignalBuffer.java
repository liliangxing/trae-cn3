package com.bytedance.android.anniex.scene.core;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PageSignalBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/PageSignalBuffer;", "", "()V", "pageAttachEventBuffer", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/bytedance/android/anniex/scene/core/PageAttachEvent;", "windowDurationMs", "", "windowStartTime", "clear", "", "collectLatestPage", "isEmpty", "", "receive", NotificationCompat.CATEGORY_EVENT, "shouldCollectNow", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PageSignalBuffer {
    private final ConcurrentLinkedQueue<PageAttachEvent> pageAttachEventBuffer = new ConcurrentLinkedQueue<>();
    private final long windowDurationMs = SwitchCenter.INSTANCE.getPageStackWindowDurationMs();
    private long windowStartTime;

    public final void receive(PageAttachEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (this.windowStartTime == 0) {
            this.windowStartTime = event.getTimestamp();
        }
        this.pageAttachEventBuffer.add(event);
    }

    public final void clear() {
        this.pageAttachEventBuffer.clear();
        this.windowStartTime = 0L;
    }

    public final boolean shouldCollectNow() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.windowStartTime;
        return j > 0 && currentTimeMillis - j >= this.windowDurationMs;
    }

    public final PageAttachEvent collectLatestPage() {
        if (isEmpty()) {
            this.pageAttachEventBuffer.clear();
            this.windowStartTime = 0L;
            return null;
        }
        PageAttachEvent pageAttachEvent = (PageAttachEvent) CollectionsKt.lastOrNull(this.pageAttachEventBuffer);
        this.pageAttachEventBuffer.clear();
        this.windowStartTime = 0L;
        return pageAttachEvent;
    }

    public final boolean isEmpty() {
        return this.pageAttachEventBuffer.isEmpty();
    }
}
