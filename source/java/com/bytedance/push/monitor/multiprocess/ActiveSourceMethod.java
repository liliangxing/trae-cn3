package com.bytedance.push.monitor.multiprocess;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.process.cross.IMethodObserver;
import com.ss.android.message.util.ToolUtils;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ActiveSourceMethod implements IMethodObserver {
    public static final String METHOD_NAME_ACTIVE_SOURCE_METHOD = "active_source_method";
    public static final String SUB_METHOD_NAME_DAU = "dau";
    public static final String SUB_METHOD_NAME_TRANSMIT = "transmit";
    private static volatile ActiveSourceMethod sActiveSourceMethod;

    public String getMethodName() {
        return METHOD_NAME_ACTIVE_SOURCE_METHOD;
    }

    public static ActiveSourceMethod getInstance() {
        if (sActiveSourceMethod == null) {
            synchronized (ActiveSourceMethod.class) {
                if (sActiveSourceMethod == null) {
                    sActiveSourceMethod = new ActiveSourceMethod();
                }
            }
        }
        return sActiveSourceMethod;
    }

    private ActiveSourceMethod() {
    }

    public void init(Context context) {
        if (ToolUtils.isMainProcess(context) || ToolUtils.isSmpProcess(context)) {
            CrossProcessHelper.getInstance().registerMethodObserver(this);
        }
    }

    public String onMethodCall(ProcessEnum processEnum, List list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        String str = (String) list.get(0);
        if (TextUtils.equals(SUB_METHOD_NAME_DAU, str)) {
            return String.valueOf(PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().curIsDau());
        }
        if (TextUtils.equals(SUB_METHOD_NAME_TRANSMIT, str)) {
            return String.valueOf(PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().curIsTransmit());
        }
        return null;
    }
}
