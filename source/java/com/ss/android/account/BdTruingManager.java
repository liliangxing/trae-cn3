package com.ss.android.account;

import com.ss.android.account.dbtring.IBdTruing;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BdTruingManager {
    private static volatile BdTruingManager sInst;
    private IBdTruing bdTruing;

    private BdTruingManager() {
    }

    public static BdTruingManager getInst() {
        if (sInst == null) {
            synchronized (BdTruingManager.class) {
                if (sInst == null) {
                    sInst = new BdTruingManager();
                }
            }
        }
        return sInst;
    }

    public IBdTruing getBdTruing() {
        return this.bdTruing;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBdTruing(IBdTruing iBdTruing) {
        this.bdTruing = iBdTruing;
    }

    public boolean init() {
        IBdTruing iBdTruing = this.bdTruing;
        if (iBdTruing != null) {
            return iBdTruing.init(TTAccountInit.getConfig().getApplicationContext());
        }
        return false;
    }
}
