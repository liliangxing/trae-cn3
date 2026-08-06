package com.ss.android;

import com.bytedance.sdk.account.INetWork;
import com.bytedance.sdk.account.utils.IMonitor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsTTAccountConfig implements TTAccountConfig {
    private IMonitor mMonitor;
    private INetWork mNetWork;

    @Override // com.ss.android.TTAccountConfig
    public boolean isSecureCaptchaEnabled() {
        return false;
    }

    @Override // com.ss.android.TTAccountConfig
    public INetWork getNetwork() {
        INetWork iNetWork = this.mNetWork;
        if (iNetWork != null) {
            return iNetWork;
        }
        LogHelper.m36d("AbsTTAccountConfig", "call getNetwork");
        try {
            INetWork iNetWork2 = (INetWork) Class.forName("com.ss.android.account.adapter.NetworkAdapter").newInstance();
            this.mNetWork = iNetWork2;
            return iNetWork2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.TTAccountConfig
    public IMonitor getMonitor() {
        IMonitor iMonitor = this.mMonitor;
        if (iMonitor != null) {
            return iMonitor;
        }
        LogHelper.m36d("AbsTTAccountConfig", "call getMonitor");
        try {
            IMonitor iMonitor2 = (IMonitor) Class.forName("com.ss.android.account.adapter.MonitorAdapter").newInstance();
            this.mMonitor = iMonitor2;
            return iMonitor2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
