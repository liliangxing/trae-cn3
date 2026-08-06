package com.bytedance.timonbase.scene;

import android.os.SystemClock;
import com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee;
import com.bytedance.timonbase.scene.silenceimpl.InputEventHappenRecordHolder;
import com.bytedance.timonbase.scene.silenceimpl.WindowManagerGlobalInfiltrator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: AppSilenceReferee.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/timonbase/scene/AppSilenceReferee;", "", "threshold", "", "(J)V", "appEnterSilenceTime", "getAppEnterSilenceTime", "()J", "appSilentStage", "", "getAppSilentStage", "()I", "isAppSilence", "", "()Z", "timeInterval", "", "updateThreshold", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppSilenceReferee {
    private long threshold;
    private final List<Long> timeInterval;

    public AppSilenceReferee(long j) {
        this.threshold = j;
        WindowManagerGlobalInfiltrator.INSTANCE.infiltrate();
        TimonBackgroundReferee appBackgroundReferee = ScenesDetector.INSTANCE.getAppBackgroundReferee();
        if (appBackgroundReferee != null) {
            appBackgroundReferee.addStatusChangeListener(new Function1<Boolean, Unit>() { // from class: com.bytedance.timonbase.scene.AppSilenceReferee.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    InputEventHappenRecordHolder.INSTANCE.touchEventHappen();
                }
            });
        }
        this.timeInterval = CollectionsKt.listOf(new Long[]{0L, 30000L, 600000L, 1200000L});
    }

    public final boolean isAppSilence() {
        return getAppEnterSilenceTime() - this.threshold >= 0;
    }

    public final long getAppEnterSilenceTime() {
        return SystemClock.elapsedRealtime() - InputEventHappenRecordHolder.INSTANCE.getEventHappenFlagChangeTime();
    }

    public final int getAppSilentStage() {
        if (getAppEnterSilenceTime() >= this.timeInterval.get(3).longValue()) {
            return 3;
        }
        if (getAppEnterSilenceTime() >= this.timeInterval.get(2).longValue()) {
            return 2;
        }
        return getAppEnterSilenceTime() >= this.timeInterval.get(1).longValue() ? 1 : 0;
    }

    public final void updateThreshold(long threshold) {
        this.threshold = threshold;
    }
}
