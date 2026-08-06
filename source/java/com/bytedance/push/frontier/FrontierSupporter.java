package com.bytedance.push.frontier;

import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import com.bytedance.push.frontier.interfaze.IFrontierSupport;
import com.bytedance.push.frontier.interfaze.ISettingService;
import com.bytedance.push.frontier.setting.SettingService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FrontierSupporter implements IFrontierSupport {
    private static volatile FrontierSupporter supporter;
    private volatile IFrontierMonitor mIFrontierMonitor;
    private volatile ISettingService mSettingService;

    private FrontierSupporter() {
    }

    public static FrontierSupporter get() {
        if (supporter == null) {
            synchronized (FrontierSupporter.class) {
                if (supporter == null) {
                    supporter = new FrontierSupporter();
                }
            }
        }
        return supporter;
    }

    @Override // com.bytedance.push.frontier.interfaze.IFrontierSupport
    public ISettingService getSettingService() {
        if (this.mSettingService == null) {
            synchronized (this) {
                if (this.mSettingService == null) {
                    this.mSettingService = new SettingService();
                }
            }
        }
        return this.mSettingService;
    }

    @Override // com.bytedance.push.frontier.interfaze.IFrontierSupport
    public IFrontierMonitor getFrontierMonitor() {
        if (this.mIFrontierMonitor == null) {
            synchronized (this) {
                if (this.mIFrontierMonitor == null) {
                    this.mIFrontierMonitor = new FrontierMonitor();
                }
            }
        }
        return this.mIFrontierMonitor;
    }
}
