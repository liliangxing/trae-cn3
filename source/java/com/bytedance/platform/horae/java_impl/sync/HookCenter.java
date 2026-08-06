package com.bytedance.platform.horae.java_impl.sync;

import android.app.Application;
import android.util.Log;
import com.bytedance.platform.horae.java_impl.sync.hook.OnHookPointTrigger;
import com.bytedance.platform.horae.java_impl.sync.hook.PerformTraversalsHookPointer;
import com.bytedance.platform.horae.java_impl.sync.hook.TimerInMessageQueue;
import com.bytedance.platform.horae.java_impl.sync.hook.TriggerFromLooperPrinter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HookCenter implements OnHookPointTrigger {
    public void onHook(Application application) {
        new TimerInMessageQueue(this).onHook();
        new TriggerFromLooperPrinter(this).onHook();
        new PerformTraversalsHookPointer(application, this).onHook();
    }

    @Override // com.bytedance.platform.horae.java_impl.sync.hook.OnHookPointTrigger
    public void onHookPointTrigger(String str) {
        if (!"main".equals(Thread.currentThread().getName())) {
            Log.e("HookCenter", "chanel is " + str + Log.getStackTraceString(new RuntimeException()));
        } else {
            Log.d("HookCenter", str + " trigger is coming!");
            SyncServiceScheduleManager.getInstance().handlePendingMessage();
        }
    }
}
