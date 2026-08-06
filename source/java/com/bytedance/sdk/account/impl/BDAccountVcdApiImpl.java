package com.bytedance.sdk.account.impl;

import android.content.Context;
import com.bytedance.sdk.account.api.IBDAccountVcdApi;
import com.bytedance.sdk.account.api.callback.vcd.GetVcdAccountCallback;
import com.bytedance.sdk.account.api.callback.vcd.GetVcdAuthAccountCallback;
import com.bytedance.sdk.account.api.callback.vcd.GetVcdLoginTicketCallback;
import com.bytedance.sdk.account.api.callback.vcd.SwitchVcdAccountCallback;
import com.bytedance.sdk.account.api.callback.vcd.VcdAuthorizeCallback;
import com.bytedance.sdk.account.api.callback.vcd.VcdLoginByTicketCallback;
import com.bytedance.sdk.account.job.vcd.GetVcdAccountByTicketJob;
import com.bytedance.sdk.account.job.vcd.GetVcdAuthAccountJob;
import com.bytedance.sdk.account.job.vcd.GetVcdLoginTicketJob;
import com.bytedance.sdk.account.job.vcd.SwitchVcdAccountJob;
import com.bytedance.sdk.account.job.vcd.VcdAuthorizeJob;
import com.bytedance.sdk.account.job.vcd.VcdLoginByTicketJob;
import com.ss.android.account.TTAccountInit;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountVcdApiImpl implements IBDAccountVcdApi {
    private static volatile BDAccountVcdApiImpl sInstance;
    private Context mContext = TTAccountInit.getConfig().getApplicationContext();

    private BDAccountVcdApiImpl() {
    }

    public static BDAccountVcdApiImpl instance() {
        if (sInstance == null) {
            synchronized (BDAccountVcdApiImpl.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountVcdApiImpl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountVcdApi
    public void getVcdAuthAccount(GetVcdAuthAccountCallback getVcdAuthAccountCallback) {
        GetVcdAuthAccountJob.getVcdAuthAccount(this.mContext, getVcdAuthAccountCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountVcdApi
    public void switchVcdAccount(long j, Map map, SwitchVcdAccountCallback switchVcdAccountCallback) {
        SwitchVcdAccountJob.switchVcdAccountJob(this.mContext, j, map, switchVcdAccountCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountVcdApi
    public void getVcdLoginTicket(GetVcdLoginTicketCallback getVcdLoginTicketCallback) {
        GetVcdLoginTicketJob.getVcdLoginTicket(this.mContext, getVcdLoginTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountVcdApi
    public void getVcdUserInfoByTicket(String str, Map map, GetVcdAccountCallback getVcdAccountCallback) {
        GetVcdAccountByTicketJob.getVcdAccountByTicket(this.mContext, str, map, getVcdAccountCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountVcdApi
    public void vcdLoginByTicket(String str, Map map, VcdLoginByTicketCallback vcdLoginByTicketCallback) {
        VcdLoginByTicketJob.loginByTicket(this.mContext, str, map, vcdLoginByTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountVcdApi
    public void vcdAuthorize(Long l, Boolean bool, String str, VcdAuthorizeCallback vcdAuthorizeCallback) {
        VcdAuthorizeJob.vcdAuthorize(this.mContext, l, bool, str, vcdAuthorizeCallback).start();
    }
}
