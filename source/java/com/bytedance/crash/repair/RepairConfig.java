package com.bytedance.crash.repair;

import com.bytedance.crash.npth_repair.utils.RepairPortrait;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class RepairConfig {
    private static final int DEFAULT_FIX_DUMP_STACK_DELAYED_TIME = 60000;
    private final boolean mDebuggable;
    private int mDelayedTime;
    private final RepairPortrait mRepairPortrait;
    private final int mRepairType;

    public RepairConfig(int i, int i2, boolean z, JSONArray jSONArray) {
        this.mDelayedTime = 60000;
        this.mRepairType = i;
        if (i2 > 0) {
            this.mDelayedTime = i2;
        }
        this.mDebuggable = z;
        this.mRepairPortrait = RepairPortrait.createRepairPortrait(jSONArray);
    }

    public int getDelayedTime() {
        return this.mDelayedTime;
    }

    public int getRepairType() {
        return this.mRepairType;
    }

    public boolean getDebuggable() {
        return this.mDebuggable;
    }

    public RepairPortrait getRepairPortrait() {
        return this.mRepairPortrait;
    }
}
