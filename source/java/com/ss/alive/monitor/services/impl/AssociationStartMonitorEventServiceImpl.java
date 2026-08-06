package com.ss.alive.monitor.services.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.process.cross.IMethodObserver;
import com.bytedance.common.push.BaseJson;
import com.bytedance.push.utils.Logger;
import com.ss.alive.monitor.model.StartRecord;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AssociationStartMonitorEventServiceImpl extends BaseJson implements IAssociationStartMonitorEventService, IMethodObserver {
    private boolean mIsActive;
    private ProcessEnum mProcessEnum;
    private final String TAG = "AssociationStartMonitor";
    private final String ALOG_TAG = "ALOG_ASSOCIATION_START_MONITOR";
    private final String ASSOCIATION_START_METHOD_NAME = "onAssociationStartEvent";
    private boolean mEnableReport = false;

    public String getMethodName() {
        return "onAssociationStartEvent";
    }

    public AssociationStartMonitorEventServiceImpl(Context context) {
        ProcessEnum curProcess = ToolUtils.getCurProcess(context);
        this.mProcessEnum = curProcess;
        if (curProcess == ProcessEnum.MAIN) {
            CrossProcessHelper.getInstance().registerMethodObserver(this);
            this.mIsActive = ToolUtils.isActiveUser(context);
        }
    }

    @Override // com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService
    public void onUserActive() {
        this.mIsActive = true;
    }

    @Override // com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService
    public void enableReport(boolean z) {
        this.mEnableReport = z;
    }

    @Override // com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService
    public void onHookResult(String str, boolean z, String str2, long j) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, IAssociationStartMonitorEventService.KEY_HOOK_NAME, str);
        add(jSONObject, IAssociationStartMonitorEventService.KEY_RESULT, z);
        add(jSONObject, IAssociationStartMonitorEventService.KEY_MSG, str2);
        add(jSONObject, IAssociationStartMonitorEventService.KEY_PROCESS, this.mProcessEnum.processSuffix);
        add(jSONObject, "client_time", ToolUtils.currentTimeMillis());
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, "duration", j);
        monitorEvent(IAssociationStartMonitorEventService.SERVICE_NAME_PUSH_HOOK_RESULT, jSONObject, jSONObject2, null);
    }

    @Override // com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService
    public void onAssociationStartEvent(StartRecord startRecord) {
        monitorEvent(IAssociationStartMonitorEventService.SERVICE_NAME_ASSOCIATION_START_EVENT, startRecord.toJson(), null, null);
    }

    @Override // com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService
    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (this.mEnableReport) {
            if (this.mProcessEnum == ProcessEnum.MAIN) {
                monitorEventInternal(str, jSONObject, jSONObject2, jSONObject3);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(jSONObject == null ? "" : jSONObject.toString());
            arrayList.add(jSONObject2 == null ? "" : jSONObject2.toString());
            arrayList.add(jSONObject3 != null ? jSONObject3.toString() : "");
            CrossProcessHelper.getInstance().callMethod(ProcessEnum.MAIN, "onAssociationStartEvent", arrayList, true);
        }
    }

    private void monitorEventInternal(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (this.mProcessEnum != ProcessEnum.MAIN) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        add(jSONObject, RegistrationHeaderHelper.KEY_SDK_VERSION, "1.0");
        add(jSONObject, "is_active", this.mIsActive ? 1L : 0L);
        Logger.d("AssociationStartMonitor", "[monitorEventInternal] serviceName is " + str);
        PushServiceManager.get().getPushExternalService().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
    }

    public String onMethodCall(ProcessEnum processEnum, List list) {
        try {
            if (this.mProcessEnum == ProcessEnum.MAIN && list.size() == 4) {
                Logger.e("AssociationStartMonitor", "recv  rom the chain-start record of " + processEnum);
                String str = (String) list.get(1);
                String str2 = (String) list.get(2);
                String str3 = (String) list.get(3);
                monitorEventInternal((String) list.get(0), TextUtils.isEmpty(str) ? null : new JSONObject(str), TextUtils.isEmpty(str2) ? null : new JSONObject(str2), TextUtils.isEmpty(str3) ? null : new JSONObject(str3));
            }
        } catch (Throwable th) {
            Logger.e("AssociationStartMonitor", "onMethodCall error : origin processName is " + processEnum);
            th.printStackTrace();
        }
        return null;
    }
}
