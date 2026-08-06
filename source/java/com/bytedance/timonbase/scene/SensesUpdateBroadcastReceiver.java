package com.bytedance.timonbase.scene;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.scene.lifecycle.ForegroundState;
import com.bytedance.timonbase.scene.synchronizer.AppForegroundStatusSynchronizer;
import com.bytedance.timonbase.scene.synchronizer.BasicModeSynchronizer;
import com.bytedance.timonbase.scene.synchronizer.ElderModeSynchronizer;
import com.bytedance.timonbase.scene.synchronizer.ISenseStatusSynchronizer;
import com.bytedance.timonbase.scene.synchronizer.PrivacyAgreedStatusSynchronizer;
import com.bytedance.timonbase.scene.synchronizer.TeenModeSynchronizer;
import com.bytedance.timonbase.utils.TMThreadUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SensesUpdateBroadcastReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/timonbase/scene/SensesUpdateBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApplication", "()Landroid/app/Application;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SensesUpdateBroadcastReceiver extends BroadcastReceiver {
    public static final String APP_SENSE_UPDATE_ACTION = "com.bytedance.timon.base.APP_SENSE_UPDATE_ACTION";
    private static final String SENSE_TYPE = "sense_type";
    private static final String SENSE_VALUE = "sense_value";
    private static final String TAG = "SensesUpdateBroadcastRe";
    private static Application ctx;
    private final Application application;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Integer, ISenseStatusSynchronizer<? extends Object>> senseTypeMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, PrivacyAgreedStatusSynchronizer.INSTANCE), TuplesKt.to(1, TeenModeSynchronizer.INSTANCE), TuplesKt.to(2, BasicModeSynchronizer.INSTANCE), TuplesKt.to(3, AppForegroundStatusSynchronizer.INSTANCE), TuplesKt.to(4, ElderModeSynchronizer.INSTANCE)});

    /* compiled from: SensesUpdateBroadcastReceiver.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0014J\n\u0010\u001e\u001a\u00020\f*\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/timonbase/scene/SensesUpdateBroadcastReceiver$Companion;", "", "()V", "APP_SENSE_UPDATE_ACTION", "", "SENSE_TYPE", "SENSE_VALUE", "TAG", "ctx", "Landroid/app/Application;", "senseTypeMap", "", "", "Lcom/bytedance/timonbase/scene/synchronizer/ISenseStatusSynchronizer;", "sendBroadcast", "", "senseType", "value", "updateBasicMode", "isBasicMode", "", "updateElderMode", "isElderMode", "updateForegroundMode", "isForeground", "Lcom/bytedance/timonbase/scene/lifecycle/ForegroundState;", "updatePrivacyAgreed", "privacyAgreed", "updateTeenMode", "isTeenMode", "toState", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public final int toState(boolean z) {
            return z ? 1 : 0;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void updatePrivacyAgreed(boolean privacyAgreed) {
            sendBroadcast(0, Boolean.valueOf(privacyAgreed));
        }

        public final void updateTeenMode(boolean isTeenMode) {
            sendBroadcast(1, Boolean.valueOf(isTeenMode));
        }

        public final void updateBasicMode(boolean isBasicMode) {
            sendBroadcast(2, Boolean.valueOf(isBasicMode));
        }

        public final void updateForegroundMode(ForegroundState isForeground) {
            Intrinsics.checkParameterIsNotNull(isForeground, "isForeground");
            sendBroadcast(3, isForeground);
        }

        public final void updateElderMode(boolean isElderMode) {
            sendBroadcast(4, Boolean.valueOf(isElderMode));
        }

        private final void sendBroadcast(int senseType, Object value) {
            Intent intent = new Intent(SensesUpdateBroadcastReceiver.APP_SENSE_UPDATE_ACTION);
            Bundle bundle = new Bundle();
            if (value instanceof Boolean) {
                Boolean bool = (Boolean) value;
                bool.booleanValue();
                bundle.putBoolean(SensesUpdateBroadcastReceiver.SENSE_VALUE, bool.booleanValue());
            }
            if (value instanceof ForegroundState) {
                ((ForegroundState) value).getForeground();
                bundle.putParcelable(SensesUpdateBroadcastReceiver.SENSE_VALUE, (Parcelable) value);
            }
            intent.putExtra(SensesUpdateBroadcastReceiver.SENSE_TYPE, senseType);
            intent.putExtras(bundle);
            Application application = SensesUpdateBroadcastReceiver.ctx;
            if (application != null) {
                application.sendBroadcast(intent);
            }
        }
    }

    public SensesUpdateBroadcastReceiver(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        this.application = application;
        ctx = application;
    }

    public final Application getApplication() {
        return this.application;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        final int intExtra;
        Class<?> cls;
        String str = null;
        if ((!Intrinsics.areEqual(intent != null ? intent.getAction() : null, APP_SENSE_UPDATE_ACTION)) || (intExtra = intent.getIntExtra(SENSE_TYPE, -1)) == -1) {
            return;
        }
        Bundle extras = intent.getExtras();
        final Object obj = extras != null ? extras.get(SENSE_VALUE) : null;
        TMLogger tMLogger = TMLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("onReceive: ");
        ISenseStatusSynchronizer<? extends Object> iSenseStatusSynchronizer = senseTypeMap.get(Integer.valueOf(intExtra));
        if (iSenseStatusSynchronizer != null && (cls = iSenseStatusSynchronizer.getClass()) != null) {
            str = cls.getSimpleName();
        }
        tMLogger.m219d(TAG, sb.append(str).append(':').append(obj).append(" pid:").append(Process.myPid()).toString());
        TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.scene.SensesUpdateBroadcastReceiver$onReceive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1075invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1075invoke() {
                Map map;
                map = SensesUpdateBroadcastReceiver.senseTypeMap;
                ISenseStatusSynchronizer iSenseStatusSynchronizer2 = (ISenseStatusSynchronizer) map.get(Integer.valueOf(intExtra));
                if (iSenseStatusSynchronizer2 != null) {
                    iSenseStatusSynchronizer2.updateSenseStatus(obj);
                }
            }
        });
    }
}
