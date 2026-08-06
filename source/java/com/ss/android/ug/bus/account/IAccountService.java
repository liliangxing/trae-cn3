package com.ss.android.ug.bus.account;

import com.ss.android.ug.bus.IUgBusService;
import com.ss.android.ug.bus.account.model.HistoryLoginInfo;
import java.util.List;

/* loaded from: classes7.dex */
public interface IAccountService extends IUgBusService {

    /* loaded from: classes7.dex */
    public interface HistoryLoginInfoCallback {
        void onError();

        void onSucc(List<HistoryLoginInfo> list);
    }

    void getHistoryLoginInfo(HistoryLoginInfoCallback historyLoginInfoCallback);

    String getSecUid();
}
