package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorSettingsSwitches.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/salamander/anniex/Switch;", "", "defaultEnabled", "", "index", "", "(ZI)V", "enabled", "manualSwitchState", "Lcom/bytedance/salamander/anniex/ManualState;", "isEnabled", "setEnableManually", "", "state", "setEnabled", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class Switch {
    private boolean enabled;
    private int index;
    private ManualState manualSwitchState = ManualState.DEFAULT;

    public Switch(boolean z, int i) {
        this.enabled = z;
        this.index = i;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setEnableManually(ManualState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.manualSwitchState = state;
    }

    public boolean isEnabled() {
        return this.manualSwitchState != ManualState.DEFAULT ? this.manualSwitchState == ManualState.ON : this.enabled;
    }
}
