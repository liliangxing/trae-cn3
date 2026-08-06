package com.bytedance.sdk.account.save;

import com.bytedance.sdk.account.save.callback.QueryCallback;
import com.bytedance.sdk.account.save.callback.QueryListCallback;
import com.bytedance.sdk.account.save.callback.SaveCallback;
import com.bytedance.sdk.account.save.entity.LoginInfo;

/* loaded from: classes5.dex */
public interface IBDSaveAPI {
    void onTerminate();

    void queryByUid(long j, QueryListCallback queryListCallback);

    void queryLatest(QueryCallback queryCallback);

    void queryLatestAccounts(QueryListCallback queryListCallback);

    void saveLoginInfo(LoginInfo loginInfo, SaveCallback saveCallback);
}
