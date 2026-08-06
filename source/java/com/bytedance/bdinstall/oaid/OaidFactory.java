package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.util.RomUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class OaidFactory {
    OaidFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OaidApi createOaidImpl(Context context) {
        if (Build.BRAND.equals("Pico")) {
            return new PicoOaidImpl();
        }
        if (RomUtils.isColorOS()) {
            return new OnePlusOaidImpl(new XiaomiOppoImpl());
        }
        if ((RomUtils.isXiaomi() && XiaomiOppoImpl.isSupport()) || RomUtils.isBlackShark()) {
            return new XiaomiOppoImpl();
        }
        if (OaidVivoImpl.isSupport()) {
            return new OaidVivoImpl(context);
        }
        if (RomUtils.isHonorDevice() && RomUtils.hasHWVersion()) {
            DrLog.m139d("honor# old honor oaid");
            return new HWOaidImpl();
        }
        if (RomUtils.isHonorDevice() && !RomUtils.hasHWVersion()) {
            DrLog.m139d("honor# new honor oaid");
            return new HonorOaidImpl();
        }
        if (RomUtils.isHuawei()) {
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
        if (RomUtils.isMiui() || !HWOaidImpl.isSupport(context)) {
            return null;
        }
        return new HWOaidImpl();
    }
}
