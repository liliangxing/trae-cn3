package com.bytedance.salamander.adapter;

import com.bytedance.push.event.sync.ISignalReportConstants;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* compiled from: FoundationLockImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/adapter/RecurisveLockImpl;", "Lcom/bytedance/salamander/adapter/Lockable;", "()V", "l", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "tryLock", "", ISignalReportConstants.KEY_SCREEN_STATUS_UNLOCK, "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class RecurisveLockImpl implements Lockable {
    private ReentrantLock l = new ReentrantLock();

    @Override // com.bytedance.salamander.adapter.Lockable
    public void lock() {
        this.l.lock();
    }

    @Override // com.bytedance.salamander.adapter.Lockable
    public void unlock() {
        this.l.unlock();
    }

    @Override // com.bytedance.salamander.adapter.Lockable
    public boolean tryLock() {
        return this.l.tryLock();
    }
}
