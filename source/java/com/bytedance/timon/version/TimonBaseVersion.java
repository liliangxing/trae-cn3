package com.bytedance.timon.version;

import com.bytedance.timonbase.version.ITimonVersion;
import kotlin.Metadata;

/* compiled from: TimonBaseVersion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018¨\u0006!"}, d2 = {"Lcom/bytedance/timon/version/TimonBaseVersion;", "Lcom/bytedance/timonbase/version/ITimonVersion;", "()V", "mxv_api0keeper_c_03090100", "", "getMxv_api0keeper_c_03090100", "()I", "mxv_bpea_c_03090100", "getMxv_bpea_c_03090100", "mxv_clipboard_c_03090100", "getMxv_clipboard_c_03090100", "mxv_inspector_c_03090100", "getMxv_inspector_c_03090100", "mxv_permission_c_03090100", "getMxv_permission_c_03090100", "mxv_process0killer_c_03090100", "getMxv_process0killer_c_03090100", "mxv_teenmode_c_03090100", "getMxv_teenmode_c_03090100", "mxv_upc_c_03090100", "getMxv_upc_c_03090100", "tc_kitname", "", "getTc_kitname", "()Ljava/lang/String;", "tc_mxvc", "", "getTc_mxvc", "()J", "tc_name", "getTc_name", "tc_version", "getTc_version", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class TimonBaseVersion implements ITimonVersion {
    private final int mxv_api0keeper_c_03090100 = 100;
    private final int mxv_permission_c_03090100 = 100;
    private final int mxv_clipboard_c_03090100 = 100;
    private final int mxv_teenmode_c_03090100 = 100;
    private final int mxv_upc_c_03090100 = 100;
    private final int mxv_process0killer_c_03090100 = 100;
    private final int mxv_bpea_c_03090100 = 100;
    private final int mxv_inspector_c_03090100 = 100;
    private final long tc_mxvc = 99;
    private final String tc_name = "timonbase";
    private final String tc_version = "4.0.0";
    private final String tc_kitname = "timonbase";

    public final int getMxv_api0keeper_c_03090100() {
        return this.mxv_api0keeper_c_03090100;
    }

    public final int getMxv_permission_c_03090100() {
        return this.mxv_permission_c_03090100;
    }

    public final int getMxv_clipboard_c_03090100() {
        return this.mxv_clipboard_c_03090100;
    }

    public final int getMxv_teenmode_c_03090100() {
        return this.mxv_teenmode_c_03090100;
    }

    public final int getMxv_upc_c_03090100() {
        return this.mxv_upc_c_03090100;
    }

    public final int getMxv_process0killer_c_03090100() {
        return this.mxv_process0killer_c_03090100;
    }

    public final int getMxv_bpea_c_03090100() {
        return this.mxv_bpea_c_03090100;
    }

    public final int getMxv_inspector_c_03090100() {
        return this.mxv_inspector_c_03090100;
    }

    @Override // com.bytedance.timonbase.version.ITimonVersion
    public long getTc_mxvc() {
        return this.tc_mxvc;
    }

    @Override // com.bytedance.timonbase.version.ITimonVersion
    public String getTc_name() {
        return this.tc_name;
    }

    @Override // com.bytedance.timonbase.version.ITimonVersion
    public String getTc_version() {
        return this.tc_version;
    }

    @Override // com.bytedance.timonbase.version.ITimonVersion
    public String getTc_kitname() {
        return this.tc_kitname;
    }
}
