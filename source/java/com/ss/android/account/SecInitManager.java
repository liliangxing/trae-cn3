package com.ss.android.account;

import com.ss.android.account.sec.IAccountSec;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SecInitManager {
    private static volatile SecInitManager sInst;
    private IAccountSec accountSec;

    private SecInitManager() {
    }

    public static SecInitManager getInst() {
        if (sInst == null) {
            synchronized (SecInitManager.class) {
                if (sInst == null) {
                    sInst = new SecInitManager();
                }
            }
        }
        return sInst;
    }

    public IAccountSec getAccountSec() {
        return this.accountSec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAccountSec(IAccountSec iAccountSec) {
        this.accountSec = iAccountSec;
    }

    public boolean init() {
        return this.accountSec.init(TTAccountInit.getConfig().getApplicationContext());
    }
}
