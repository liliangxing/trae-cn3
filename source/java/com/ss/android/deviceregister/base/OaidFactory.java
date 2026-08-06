package com.ss.android.deviceregister.base;

import android.content.Context;
import android.os.Build;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.deviceregister.LogUtils;
import com.ss.android.deviceregister.base.honor.HonorKeys;
import com.ss.android.deviceregister.utils.RomUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class OaidFactory {
    OaidFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OaidApi createOaidImpl(Context context) {
        if (RomUtils.isColorOS()) {
            return new OnePlusOaidImpl(new XiaomiOppoImpl());
        }
        if (XiaomiOppoImpl.isSupport()) {
            return new XiaomiOppoImpl();
        }
        if (OaidVivoImpl.isSupport()) {
            return new OaidVivoImpl();
        }
        if (RomUtils.isHonorDevice() && RomUtils.hasHWVersion()) {
            LogUtils.m88d(HonorKeys.TAG, "old honor oaid");
            return new HWOaidImpl();
        }
        if (RomUtils.isHonorDevice() && !RomUtils.hasHWVersion()) {
            LogUtils.m88d(HonorKeys.TAG, "new honor oaid");
            return new HonorOaidImpl();
        }
        if (RomUtils.isHuaweiDevice()) {
            return new HWOaidImpl();
        }
        if (RomUtils.isOnePlus()) {
            return new OnePlusOaidImpl();
        }
        if (RomUtils.isMeizu()) {
            return new MeizuOaidImpl();
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (RomUtils.isSamsung()) {
                return new SamsungOaidImpl();
            }
            if (RomUtils.isNubia()) {
                return new NubiaOaidImpl();
            }
            if (RomUtils.isLenovo()) {
                return new LenovoOaidImpl();
            }
            if (RomUtils.isASUS()) {
                return new ASUSOaidImpl();
            }
            CoolpadOaidImpl coolpadOaidImpl = new CoolpadOaidImpl(context);
            return coolpadOaidImpl.support(context) ? coolpadOaidImpl : new CommonOaidImpl();
        }
        if (ToolUtils.isMiui() || !HWOaidImpl.isSupport(context)) {
            return null;
        }
        return new HWOaidImpl();
    }
}
