package com.bytedance.platform.godzilla.anr;

import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.platform.godzilla.anr.monitor.ITaskCostTimeCallback;
import com.bytedance.platform.godzilla.anr.monitor.idletask.ArrayListWrapper;
import com.bytedance.platform.godzilla.anr.monitor.idletask.IdleHandlerCostTimeMonitor;
import com.bytedance.platform.godzilla.common.DoubleReflectHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IdleHandlerMonitorPlugin extends BasePlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "IdleHandlerMonitorPlugin";
    }

    public IdleHandlerMonitorPlugin(ITaskCostTimeCallback iTaskCostTimeCallback) {
        if (iTaskCostTimeCallback == null) {
            throw new IllegalArgumentException("Argument idleHandlerCostTimeCallback can not be null ");
        }
        IdleHandlerCostTimeMonitor.getInstance().setIdleHandlerCostTimeCallback(iTaskCostTimeCallback);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("Must start in UI thread!");
        }
        try {
            MessageQueue myQueue = Looper.myQueue();
            synchronized (myQueue) {
                Field field = DoubleReflectHelper.getField(MessageQueue.class, "mIdleHandlers");
                ArrayList arrayList = (ArrayList) field.get(myQueue);
                if (ArrayListWrapper.class.getName().equals(arrayList.getClass().getName())) {
                    Logger.m197e("IdleHandlerMonitorPlugin", "Already replaced,return.");
                } else {
                    field.set(myQueue, new ArrayListWrapper(arrayList));
                }
            }
        } catch (Throwable unused) {
        }
    }
}
