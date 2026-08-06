package com.bytedance.timonbase.scene.silenceimpl;

import android.os.SystemClock;
import kotlin.Metadata;

/* compiled from: InputEventHappenRecordHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/timonbase/scene/silenceimpl/InputEventHappenRecordHolder;", "", "()V", "_eventHappenFlagChangeTime", "", "eventHappenFlagChangeTime", "getEventHappenFlagChangeTime", "()J", "checkEventHappen", "", "keyEventHappen", "shortKeyShortCutEventHappen", "touchEventHappen", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class InputEventHappenRecordHolder {
    public static final InputEventHappenRecordHolder INSTANCE = new InputEventHappenRecordHolder();
    private static long _eventHappenFlagChangeTime = SystemClock.elapsedRealtime();

    private InputEventHappenRecordHolder() {
    }

    public final long getEventHappenFlagChangeTime() {
        return _eventHappenFlagChangeTime;
    }

    public final void touchEventHappen() {
        checkEventHappen();
    }

    public final void shortKeyShortCutEventHappen() {
        checkEventHappen();
    }

    public final void keyEventHappen() {
        checkEventHappen();
    }

    private final void checkEventHappen() {
        _eventHappenFlagChangeTime = SystemClock.elapsedRealtime();
    }
}
