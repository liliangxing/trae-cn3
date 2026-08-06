package com.bytedance.sync;

import com.bytedance.sync.interfaze.IMonitor;
import com.bytedance.sync.util.JSONUtils;
import com.bytedance.timonbase.scene.PageDataManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SDKMonitor implements IMonitor {
    private static final Singleton<IMonitor> sInst = new Singleton<IMonitor>() { // from class: com.bytedance.sync.SDKMonitor.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sync.Singleton
        public IMonitor create(Object... objArr) {
            return new SDKMonitor();
        }
    };

    public static IMonitor inst() {
        return sInst.get(new Object[0]);
    }

    private void monitor(String str, JSONObject jSONObject) {
        SyncMonitor.monitor(str, jSONObject, null, null);
    }

    @Override // com.bytedance.sync.interfaze.IMonitor
    public void sendErrorAck(long j, int i, long j2, long j3, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONUtils.safePutParam(jSONObject, "sync_id", j);
        JSONUtils.safePutParam(jSONObject, PageDataManager.EXTRA_STATUS, i);
        JSONUtils.safePutParam(jSONObject, "cursor_service", j2);
        JSONUtils.safePutParam(jSONObject, "cursor_client", j3);
        JSONUtils.safePutParam(jSONObject, "message", str);
        monitor("sync_inset_log", jSONObject);
    }

    @Override // com.bytedance.sync.interfaze.IMonitor
    public void monitorAccountChanged(boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONUtils.safePutParam(jSONObject, "login", z ? 1 : 0);
        monitor("sync_account_status", jSONObject);
    }

    @Override // com.bytedance.sync.interfaze.IMonitor
    public void monitorSettingError(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONUtils.safePutParam(jSONObject, "config", str);
        JSONUtils.safePutParam(jSONObject, "error", str2);
        monitor("sync_config", jSONObject);
    }

    @Override // com.bytedance.sync.interfaze.IMonitor
    public void ensureNotReachHere(Throwable th, String str) {
        SyncMonitor.monitorException(th, str);
    }
}
