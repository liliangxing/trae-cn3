package com.bytedance.apm.battery;

import android.app.Activity;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.thread.AsyncEventManager;
import com.ss.thor.ThorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryEnergyTimerCollector extends AbstractPerfCollector {
    private static int MIN_VALID_CURRENT = 10;
    private boolean mEnabled;

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return 300000L;
    }

    public BatteryEnergyTimerCollector() {
        this.mCollectorSettingKey = "battery";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject jSONObject) {
        this.mEnabled = jSONObject.optInt(SlardarSettingsConsts.PERF_BATTERY_ENERGY_ENABLE_UPLOAD, 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        super.onStart();
        if (!this.mEnabled || isBackground() || BatteryUtils.isCharging(ApmContext.getContext())) {
            return;
        }
        float galvanicNow = ThorUtils.getGalvanicNow(ApmContext.getContext());
        if (galvanicNow < MIN_VALID_CURRENT) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PerfConsts.KEY_TIMING_CURRENT, galvanicNow);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
            sendPerfLog(new PerfData("battery", "", jSONObject, jSONObject2, null));
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onBackground(Activity activity) {
        super.onBackground(activity);
        AsyncEventManager.getInstance().removeTimeTask(this);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onFront(Activity activity) {
        super.onFront(activity);
        if (this.mEnabled) {
            AsyncEventManager.getInstance().addTimeTask(this);
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return this.mEnabled;
    }
}
