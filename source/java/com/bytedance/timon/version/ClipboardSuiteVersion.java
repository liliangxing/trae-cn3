package com.bytedance.timon.version;

import com.bytedance.timon.clipboard.impl.BuildConfig;
import com.bytedance.timonbase.version.ITimonVersion;
import kotlin.Metadata;

/* compiled from: ClipboardSuiteVersion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/timon/version/ClipboardSuiteVersion;", "Lcom/bytedance/timonbase/version/ITimonVersion;", "()V", "mxv_api0keeper_f_03090100", "", "getMxv_api0keeper_f_03090100", "()I", "mxv_timonbase_f_03090100", "getMxv_timonbase_f_03090100", "tc_kitname", "", "getTc_kitname", "()Ljava/lang/String;", "tc_mxvc", "", "getTc_mxvc", "()J", "tc_name", "getTc_name", "tc_version", "getTc_version", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class ClipboardSuiteVersion implements ITimonVersion {
    private final int mxv_timonbase_f_03090100 = 99;
    private final int mxv_api0keeper_f_03090100 = 100;
    private final long tc_mxvc = 100;
    private final String tc_name = BuildConfig.TIMON_COMPONENT_NAME;
    private final String tc_version = "4.0.2";
    private final String tc_kitname = "clipboard";

    public final int getMxv_timonbase_f_03090100() {
        return this.mxv_timonbase_f_03090100;
    }

    public final int getMxv_api0keeper_f_03090100() {
        return this.mxv_api0keeper_f_03090100;
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
