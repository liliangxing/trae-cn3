package com.bytedance.sdk.account.save;

import com.bytedance.sdk.account.save.callback.QueryCallback;
import com.bytedance.sdk.account.save.callback.QueryListCallback;
import com.bytedance.sdk.account.save.callback.SaveCallback;
import com.bytedance.sdk.account.save.database.DBService;
import com.bytedance.sdk.account.save.entity.LoginInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDSaveImpl implements IBDSaveAPI {
    private static volatile IBDSaveAPI sInstance;

    private BDSaveImpl() {
    }

    public static IBDSaveAPI instance() {
        if (sInstance == null) {
            synchronized (BDSaveImpl.class) {
                if (sInstance == null) {
                    sInstance = new BDSaveImpl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.save.IBDSaveAPI
    public void queryLatestAccounts(QueryListCallback queryListCallback) {
        SaveService.queryLatestAccounts(queryListCallback);
    }

    @Override // com.bytedance.sdk.account.save.IBDSaveAPI
    public void queryByUid(long j, QueryListCallback queryListCallback) {
        SaveService.queryByUid(j, queryListCallback);
    }

    @Override // com.bytedance.sdk.account.save.IBDSaveAPI
    public void queryLatest(QueryCallback queryCallback) {
        SaveService.queryLatest(queryCallback);
    }

    @Override // com.bytedance.sdk.account.save.IBDSaveAPI
    public void saveLoginInfo(LoginInfo loginInfo, SaveCallback saveCallback) {
        SaveService.saveLoginInfo(loginInfo, saveCallback);
    }

    @Override // com.bytedance.sdk.account.save.IBDSaveAPI
    public void onTerminate() {
        DBService.getInstance().closeBD();
    }
}
