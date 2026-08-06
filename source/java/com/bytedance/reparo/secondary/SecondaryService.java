package com.bytedance.reparo.secondary;

import android.app.Application;
import com.bytedance.reparo.IReparoConfig;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.common.utils.ProcessUtils;
import com.bytedance.reparo.core.load.JavaLoader;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SecondaryService {
    public static void init(final Application application, final IReparoConfig iReparoConfig, ScheduledExecutorService scheduledExecutorService) {
        Event.init(ProcessUtils.getCurrentProcessName(application), ProcessUtils.isMainProcess(application));
        Logger.init(application);
        EventReporter.init();
        MonitorConfig.init(application, scheduledExecutorService);
        MonitorService.initParam(application, iReparoConfig);
        JavaLoader.setDisableLoadProtectListener(new JavaLoader.DisableLoadProtect() { // from class: com.bytedance.reparo.secondary.SecondaryService.1
            @Override // com.bytedance.reparo.core.load.JavaLoader.DisableLoadProtect
            public boolean shouldDisable(String str) {
                return MonitorConfig.getInstance().logTypeSwitch(str);
            }
        });
        scheduledExecutorService.execute(new Runnable() { // from class: com.bytedance.reparo.secondary.SecondaryService.2
            @Override // java.lang.Runnable
            public void run() {
                MonitorService.init(application, iReparoConfig);
            }
        });
        NpthService.init(application, scheduledExecutorService);
    }
}
