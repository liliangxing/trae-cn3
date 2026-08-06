package com.bytedance.android.monitorV2.hybridSetting.entity;

import com.bytedance.android.monitorV2.hybridSetting.Switches;

@Deprecated
/* loaded from: classes3.dex */
public class SwitchConfig {
    public long mConfig = 0;

    public boolean isEnableMonitor() {
        return Switches.monitor.isEnabled();
    }

    public boolean isWebEnableMonitor() {
        return Switches.webMonitor.isEnabled();
    }

    public boolean isWebEnableBlank() {
        return Switches.webBlank.isEnabled();
    }

    public boolean isWebEnableFetch() {
        return Switches.webFetch.isEnabled();
    }

    public boolean isWebEnableJSB() {
        return Switches.webJSB.isEnabled();
    }

    public boolean isWebEnableInject() {
        return Switches.webInject.isEnabled();
    }

    public boolean isLynxEnableMonitor() {
        return Switches.lynxMonitor.isEnabled();
    }

    public boolean isLynxEnablePerf() {
        return Switches.lynxPerf.isEnabled();
    }

    public boolean isLynxEnableBlank() {
        return Switches.lynxBlank.isEnabled();
    }

    public boolean isLynxEnableFetch() {
        return Switches.lynxFetch.isEnabled();
    }

    public boolean isLynxEnableJsb() {
        return Switches.lynxJsb.isEnabled();
    }

    public boolean isWebEnableAutoReport() {
        return Switches.webAutoReport.isEnabled();
    }

    public boolean isWebEnableUpdatePageData() {
        return Switches.webUpdatePageData.isEnabled();
    }

    public boolean isWebEnableTTWebDelegate() {
        return Switches.webTTWebDelegate.isEnabled();
    }

    public boolean isEnableTeaReport() {
        return Switches.teaReport.isEnabled();
    }

    public boolean isWebEnableResourceLoader() {
        return Switches.webResourceLoader.isEnabled();
    }

    public boolean isLynxEnableResourceLoader() {
        return Switches.lynxResourceLoader.isEnabled();
    }

    public boolean isEnableCheckSelf() {
        return Switches.checkSelf.isEnabled();
    }

    public boolean isEnableEventStream() {
        return Switches.eventStream.isEnabled();
    }

    public boolean isEnableBlankBitmap() {
        return Switches.blankBitmap.isEnabled();
    }

    public boolean setWebEnableDomainWhiteList() {
        return Switches.webDomainWhiteList.isEnabled();
    }
}
