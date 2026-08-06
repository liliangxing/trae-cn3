package com.bytedance.apm.impl;

import com.bytedance.apm.data.ui.ActionRecord;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MonitorLogManagerImpl implements IMonitorLogManager {
    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String str, String str2) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long j, long j2, String str, IMonitorLogQueryCallback iMonitorLogQueryCallback) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return ActionRecord.getInstance().getRecords();
    }
}
