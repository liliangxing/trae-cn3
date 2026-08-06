package com.bytedance.ies.bullet.prefetchv2;

import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NamedThreadFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/NamedThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "name", "", "(Ljava/lang/String;)V", "cnt", "Ljava/util/concurrent/atomic/AtomicInteger;", "getName", "()Ljava/lang/String;", "newThread", "Ljava/lang/Thread;", DownloadFileUtils.MODE_READ, "Ljava/lang/Runnable;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class NamedThreadFactory implements ThreadFactory {
    private final AtomicInteger cnt;
    private final String name;

    public NamedThreadFactory(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.cnt = new AtomicInteger();
    }

    public final String getName() {
        return this.name;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r) {
        return new Thread(r, this.name + '-' + this.cnt.incrementAndGet());
    }
}
