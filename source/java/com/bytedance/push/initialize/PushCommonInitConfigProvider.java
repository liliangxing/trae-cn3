package com.bytedance.push.initialize;

import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.process.cross.IMethodObserver;
import com.bytedance.common.push.interfaze.IPushCommonInitConfigProvider;
import com.bytedance.push.Configuration;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushCommonInitConfigProvider implements IPushCommonInitConfigProvider {
    public PushCommonConfiguration getConfiguration() {
        return Configuration.get().getPushCommonConfiguration();
    }

    public List<IMethodObserver> getMethodObservers() {
        ArrayList arrayList = new ArrayList();
        if (ToolUtils.isMainProcess(Configuration.get().mApplication)) {
            arrayList.add(PushServiceManager.get().getPushExternalService().getIMultiProcessMonitor());
        }
        arrayList.add(AppStatusObserverForChildProcess.getIns());
        return arrayList;
    }
}
