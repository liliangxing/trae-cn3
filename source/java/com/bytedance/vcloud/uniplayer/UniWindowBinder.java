package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniVideoView.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniWindowBinder;", "Ljava/lang/AutoCloseable;", "ptr", "", "closer", "Lkotlin/Function1;", "", "(JLkotlin/jvm/functions/Function1;)V", "mNativePtr", "close", "getPtr", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UniWindowBinder implements AutoCloseable {
    private final Function1<Long, Unit> closer;
    private final long mNativePtr;

    /* JADX WARN: Multi-variable type inference failed */
    public UniWindowBinder(long j, Function1<? super Long, Unit> closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        this.closer = closer;
        this.mNativePtr = j;
    }

    /* renamed from: getPtr, reason: from getter */
    public final long getMNativePtr() {
        return this.mNativePtr;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.closer.invoke(Long.valueOf(this.mNativePtr));
    }
}
