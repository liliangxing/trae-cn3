package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.RomUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LocaleDeviceManager extends DeviceManager {
    public LocaleDeviceManager(Context context, InstallOptions installOptions, Env env) {
        super(context, installOptions, env);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.DeviceManager
    public void migrate() {
        super.migrate();
        if (this.mOptions.isMainInstance() ? BDInstall.getAdIdConfig().enablePrefetchAdId() : BDInstall.getInstance(String.valueOf(this.mOptions.getAid())).getAdIdConfig().enablePrefetchAdId()) {
            Oaid.instance(this.mApp).init();
        }
    }

    @Override // com.bytedance.bdinstall.loader.DeviceManager
    public void start() {
        super.start();
        if (this.mOptions.isNeedSharedStorage() || !this.mOptions.deleteSharedStorage()) {
            return;
        }
        if (RomUtils.isAndroidROrHigher() && RomUtils.isTargetROrHigher(this.mApp)) {
            DrLog.m139d("target r, not clean");
        } else {
            ExecutorUtil.runOnIOExecutor(this.mOptions.getAidString(), new DeprecatedFileCleaner(this.mOptions));
        }
    }
}
