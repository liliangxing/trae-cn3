package com.bytedance.common.push.user;

import com.bytedance.common.push.interfaze.IAccountService;
import com.ss.android.ug.bus.UgBusFramework;
import com.ss.android.ug.bus.UgCallbackCenter;
import com.ss.android.ug.bus.account.IAccountService;
import com.ss.android.ug.bus.account.event.OnLoginEvent;
import com.ss.android.ug.bus.account.event.OnLogoutEvent;
import com.ss.android.ug.bus.account.event.OnSwitchEvent;
import com.ss.android.ug.bus.account.model.HistoryLoginInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public class AccountSDKImpl implements IAccountService {
    @Override // com.bytedance.common.push.interfaze.IAccountService
    public void registerOnLoginListener(UgCallbackCenter.Callback<OnLoginEvent> callback) {
        UgCallbackCenter.register(callback);
    }

    @Override // com.bytedance.common.push.interfaze.IAccountService
    public void registerOnLogoutListener(UgCallbackCenter.Callback<OnLogoutEvent> callback) {
        UgCallbackCenter.register(callback);
    }

    @Override // com.bytedance.common.push.interfaze.IAccountService
    public void registerOnAccountSwitchListener(UgCallbackCenter.Callback<OnSwitchEvent> callback) {
        UgCallbackCenter.register(callback);
    }

    @Override // com.bytedance.common.push.interfaze.IAccountService
    public String getSecUid() {
        com.ss.android.ug.bus.account.IAccountService iAccountService = (com.ss.android.ug.bus.account.IAccountService) UgBusFramework.getService(com.ss.android.ug.bus.account.IAccountService.class);
        if (iAccountService == null) {
            return null;
        }
        return iAccountService.getSecUid();
    }

    @Override // com.bytedance.common.push.interfaze.IAccountService
    public List<String> getLoginHistoryUids() {
        com.ss.android.ug.bus.account.IAccountService iAccountService = (com.ss.android.ug.bus.account.IAccountService) UgBusFramework.getService(com.ss.android.ug.bus.account.IAccountService.class);
        if (iAccountService == null) {
            return null;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ArrayList arrayList = new ArrayList();
        iAccountService.getHistoryLoginInfo(new IAccountService.HistoryLoginInfoCallback() { // from class: com.bytedance.common.push.user.AccountSDKImpl.1
            @Override // com.ss.android.ug.bus.account.IAccountService.HistoryLoginInfoCallback
            public void onSucc(List<HistoryLoginInfo> list) {
                if (list != null) {
                    Iterator<HistoryLoginInfo> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getSecUid());
                    }
                }
                countDownLatch.countDown();
            }

            @Override // com.ss.android.ug.bus.account.IAccountService.HistoryLoginInfoCallback
            public void onError() {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
