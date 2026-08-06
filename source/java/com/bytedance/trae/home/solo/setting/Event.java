package com.bytedance.trae.home.solo.setting;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/Event;", ExifInterface.GPS_DIRECTION_TRUE, "", "content", "<init>", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "hasBeenHandled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getContentIfNotHandled", "()Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public class Event<T> {
    public static final int $stable = 8;
    private final T content;
    private final AtomicBoolean hasBeenHandled = new AtomicBoolean(false);

    public Event(T t) {
        this.content = t;
    }

    public final T getContentIfNotHandled() {
        if (this.hasBeenHandled.compareAndSet(false, true)) {
            return this.content;
        }
        return null;
    }
}
