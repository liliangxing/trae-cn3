package com.bytedance.push.depths;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes4.dex */
public class RiskDeviceFilterConfig {
    public static final int FILTER_ADB = 1;
    public static final int FILTER_DEBUG_OS = 4;
    public static final int FILTER_PROXY_NETWORK = 8;
    public static final int FILTER_SIM_CARD = 2;
    public static final int FILTER_USB_CHARGING = 16;

    @SerializedName("rs_list")
    public List<String> filterPkgList;

    @SerializedName("rs_value")
    public int filterValue;

    @SerializedName("min_install_time")
    public long minInstallTime = -1;

    @SerializedName("white_pkg_list")
    public List<String> whitePkgList;

    public boolean filterAdb() {
        return (this.filterValue & 1) == 1;
    }

    public boolean filterSimCard() {
        return (this.filterValue & 2) == 2;
    }

    public boolean filterDebugOS() {
        return (this.filterValue & 4) == 4;
    }

    public boolean filterProxyNetwork() {
        return (this.filterValue & 8) == 8;
    }

    public boolean filterUsbCharging() {
        return (this.filterValue & 16) == 16;
    }
}
