package com.bytedance.push.process.manager;

import android.text.TextUtils;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.process.cross.IMethodObserver;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ProcessManagerMethodObserver implements IMethodObserver {
    public static final String METHOD_NAME = "processManagerMethod";
    public static final String METHOD_NAME_ALLOW_START_NON_MAIN_PROCESS = "allowStartNonMainProcess";
    public static final String METHOD_NAME_ALLOW_START_NON_MAIN_PROCESS_CALL_BACK = "allowStartNonMainProcessCallback";
    private final String TAG = "ProcessManagerMethodObserver";

    public String getMethodName() {
        return METHOD_NAME;
    }

    public String onMethodCall(ProcessEnum processEnum, List list) {
        String str = (String) list.get(0);
        Logger.m268d("ProcessManagerMethodObserver", "onMethodCall:" + str + " " + list);
        if (TextUtils.equals(str, METHOD_NAME_ALLOW_START_NON_MAIN_PROCESS)) {
            if (!ToolUtils.isMainProcess(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication)) {
                return null;
            }
            boolean allowStartNonMainProcess = PushSupporter.get().getProcessManagerService().allowStartNonMainProcess();
            ArrayList arrayList = new ArrayList();
            arrayList.add(METHOD_NAME_ALLOW_START_NON_MAIN_PROCESS_CALL_BACK);
            arrayList.add(allowStartNonMainProcess ? "1" : ViewVisibleBridge.INVISIBLE);
            arrayList.add(String.valueOf(PushCommonSupport.getInstance().getPushConfigurationService().getCurProcessStartTimeStamp()));
            CrossProcessHelper.getInstance().callMethod(processEnum, METHOD_NAME, arrayList, true);
            return null;
        }
        if (!TextUtils.equals(str, METHOD_NAME_ALLOW_START_NON_MAIN_PROCESS_CALL_BACK)) {
            return null;
        }
        PushSupporter.get().getProcessManagerService().allowStartNonMainProcessCallback(TextUtils.equals((String) list.get(1), "1"), Long.parseLong((String) list.get(2)));
        return null;
    }
}
