package com.bytedance.bdinstall;

/* loaded from: classes3.dex */
public class BDInstallConfig {
    private int egdiRetryInterval;
    private INetworkClientWrapper networkClientWrapper;
    private int timeoutForTicketGuard;
    private boolean enableGetEgdi = false;
    private boolean enableMediaID = false;
    private boolean enableDidGuard = false;

    public INetworkClientWrapper getNetworkClientWrapper() {
        return this.networkClientWrapper;
    }

    public void setNetworkClientWrapper(INetworkClientWrapper iNetworkClientWrapper) {
        this.networkClientWrapper = iNetworkClientWrapper;
    }

    public boolean isEnableMediaID() {
        return this.enableMediaID;
    }

    public void setEnableMediaID(boolean z) {
        this.enableMediaID = z;
    }

    public boolean isEnableDidGuard() {
        return this.enableDidGuard;
    }

    public void setEnableDidGuard(boolean z) {
        this.enableDidGuard = z;
    }

    public int getTimeoutForTicketGuard() {
        return this.timeoutForTicketGuard;
    }

    public void setTimeoutForTicketGuard(int i) {
        this.timeoutForTicketGuard = i;
    }

    public int getEgdiRetryInterval() {
        int i = this.egdiRetryInterval;
        if (i > 0) {
            return i;
        }
        return 10000;
    }

    public void setEgdiRetryInterval(int i) {
        this.egdiRetryInterval = i;
    }

    public boolean isEnableGetEgdi() {
        return this.enableGetEgdi;
    }

    public void setEnableGetEgdi(boolean z) {
        this.enableGetEgdi = z;
    }
}
