package com.ss.android.account;

import android.text.TextUtils;
import com.bytedance.sdk.account.api.BDAccountEvent;
import com.bytedance.sdk.account.api.BDAccountEventListener;
import com.bytedance.sdk.account.api.IBDAccount;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.save.SaveService;
import com.bytedance.sdk.account.save.callback.QueryListCallback;
import com.bytedance.sdk.account.save.entity.LoginInfo;
import com.ss.android.ug.bus.UgCallbackCenter;
import com.ss.android.ug.bus.account.IAccountService;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;
import com.ss.android.ug.bus.account.model.HistoryLoginInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AccountBusService implements IAccountService, BDAccountEventListener {
    private static volatile AccountBusService sIns;
    private boolean isLogin;
    private String lastSecUid;

    public static AccountBusService getIns() {
        if (sIns == null) {
            synchronized (AccountBusService.class) {
                if (sIns == null) {
                    sIns = new AccountBusService();
                }
            }
        }
        return sIns;
    }

    private AccountBusService() {
        this.isLogin = false;
        this.lastSecUid = "";
        BDAccountDelegateInner.instance(TTAccountInit.getConfig().getApplicationContext()).addListener(this);
        this.lastSecUid = getSecUid();
        this.isLogin = !TextUtils.isEmpty(r0);
    }

    public void onReceiveAccountEvent(BDAccountEvent bDAccountEvent) {
        if (bDAccountEvent.type == 1 || bDAccountEvent.type == 2) {
            onLogout();
        } else if (!this.isLogin) {
            onLogin(getSecUid());
        } else {
            onSwitchAccount(getSecUid());
        }
    }

    @Override // com.ss.android.ug.bus.account.IAccountService
    public String getSecUid() {
        return BDAccountDelegateInner.instance(TTAccountInit.getConfig().getApplicationContext()).getSecUserId();
    }

    @Override // com.ss.android.ug.bus.account.IAccountService
    public void getHistoryLoginInfo(final IAccountService.HistoryLoginInfoCallback historyLoginInfoCallback) {
        SaveService.queryAll(new QueryListCallback() { // from class: com.ss.android.account.AccountBusService.1
            public void onSuccess(List<LoginInfo> list) {
                ArrayList arrayList = new ArrayList();
                IBDAccount instance = BDAccountDelegateInner.instance(TTAccountInit.getConfig().getApplicationContext());
                boolean z = false;
                if (list != null) {
                    for (LoginInfo loginInfo : list) {
                        if (!z && !TextUtils.isEmpty(loginInfo.getSecUid()) && loginInfo.getSecUid().equals(instance.getSecUserId())) {
                            z = true;
                        }
                        arrayList.add(new HistoryLoginInfo(loginInfo.getUid(), loginInfo.getSecUid(), loginInfo.getAvatarUrl(), loginInfo.getScreenName()));
                    }
                }
                if (!z && AccountBusService.this.isLogin) {
                    arrayList.add(new HistoryLoginInfo(instance.getUserId(), instance.getSecUserId(), instance.getAvatarUrl(), instance.getScreenName()));
                }
                historyLoginInfoCallback.onSucc(arrayList);
            }

            public void onError(int i, String str) {
                IBDAccount instance = BDAccountDelegateInner.instance(TTAccountInit.getConfig().getApplicationContext());
                ArrayList arrayList = new ArrayList();
                if (AccountBusService.this.isLogin) {
                    arrayList.add(new HistoryLoginInfo(instance.getUserId(), instance.getSecUserId(), instance.getAvatarUrl(), instance.getScreenName()));
                }
                historyLoginInfoCallback.onSucc(arrayList);
            }
        });
    }

    public void onLogin(String str) {
        if (this.isLogin) {
            return;
        }
        UgCallbackCenter.postEvent(new OnLoginEvent(str));
        this.lastSecUid = str;
        this.isLogin = true;
    }

    public void onLogout() {
        this.isLogin = false;
        this.lastSecUid = "";
        UgCallbackCenter.postEvent(new OnLogoutEvent());
    }

    public void onSwitchAccount(String str) {
        if (this.lastSecUid.equals(str)) {
            return;
        }
        this.lastSecUid = str;
        UgCallbackCenter.postEvent(new OnSwitchEvent(str));
    }
}
