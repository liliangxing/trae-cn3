package com.bytedance.trae;

import android.os.SystemClock;
import com.bytedance.trae.common.apphost.time.AppClock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* compiled from: AppClockImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/AppClockImpl;", "Lcom/bytedance/trae/common/apphost/time/AppClock;", "<init>", "()V", "globalTime", "Lkotlin/Pair;", "", "updateTimestamp", "", "timestampMillis", "currentTimeMillis", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppClockImpl implements AppClock {
    private static final String TAG = "AppClockImpl";
    private Pair<Long, Long> globalTime;
    public static final int $stable = 8;

    @Override // com.bytedance.trae.common.apphost.time.AppClock
    public void updateTimestamp(long timestampMillis) {
        if (timestampMillis != 0 && this.globalTime == null) {
            this.globalTime = TuplesKt.to(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(timestampMillis));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.trae.common.apphost.time.AppClock
    public long currentTimeMillis() {
        Pair<Long, Long> pair = this.globalTime;
        if ((pair != null ? pair.getFirst().longValue() : 0L) < 10000) {
            return System.currentTimeMillis();
        }
        Pair<Long, Long> pair2 = this.globalTime;
        if (pair2 != null) {
            return (SystemClock.elapsedRealtime() - pair2.getFirst().longValue()) + pair2.getSecond().longValue();
        }
        return System.currentTimeMillis();
    }
}
