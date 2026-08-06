package com.bytedance.sdk.account.save;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.save.SaveConstants;
import com.bytedance.sdk.account.save.async.Command;
import com.bytedance.sdk.account.save.callback.DeleteCallback;
import com.bytedance.sdk.account.save.callback.QueryCallback;
import com.bytedance.sdk.account.save.callback.QueryListCallback;
import com.bytedance.sdk.account.save.callback.SaveCallback;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.account.save.database.DBService;
import com.bytedance.sdk.account.save.database.Task;
import com.bytedance.sdk.account.save.entity.LoginInfo;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import com.ss.android.LogHelper;
import com.ss.android.account.TTAccountInit;
import com.ss.android.account.model2.BDAccountPlatformEntity;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SaveService {
    private static final String TAG = "SaveService";
    private static String sCacheInfo;
    private static Integer sCacheType;

    public static void cacheLoginInfo(Integer num, String str) {
        sCacheType = num;
        sCacheInfo = str;
    }

    public static LoginInfo getInfoCacheLogin(IBDAccountUserEntity iBDAccountUserEntity) {
        LoginInfo loginInfo;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sCacheType != null) {
            LoginInfo.Builder withTime = new LoginInfo.Builder().withTime(new Date().getTime());
            if (iBDAccountUserEntity != null && iBDAccountUserEntity.getRawData() != null) {
                withTime.withUid(iBDAccountUserEntity.getUserId());
                withTime.withSecUid(iBDAccountUserEntity.getSecUid());
                String optString = iBDAccountUserEntity.getRawData().optString(DBData.FIELD_SCREEN_NAME);
                String optString2 = iBDAccountUserEntity.getRawData().optString("avatar_url");
                withTime.withScreenName(optString);
                withTime.withAvatarUrl(optString2);
                if (sCacheType.intValue() == 6) {
                    Map<String, BDAccountPlatformEntity> bindMap = iBDAccountUserEntity.getBindMap();
                    if (bindMap != null) {
                        for (String str : bindMap.keySet()) {
                            if (str.contains(sCacheInfo)) {
                                sCacheInfo = str;
                                BDAccountPlatformEntity bDAccountPlatformEntity = bindMap.get(str);
                                if (bDAccountPlatformEntity != null) {
                                    String str2 = bDAccountPlatformEntity.mNickname;
                                    withTime.withPlatformAvatarUrl(bDAccountPlatformEntity.mAvatar);
                                    withTime.withPlatformScreenName(str2);
                                }
                            }
                        }
                    }
                } else if (sCacheType.intValue() == 1) {
                    sCacheInfo = iBDAccountUserEntity.mobile;
                    withTime.withCountryCode(Integer.valueOf(iBDAccountUserEntity.getCountryCode()));
                } else if (sCacheType.intValue() == 2 || sCacheType.intValue() == 3) {
                    int countryCode = iBDAccountUserEntity.getCountryCode();
                    if (!TextUtils.isEmpty(sCacheInfo) && sCacheInfo.startsWith("+")) {
                        sCacheInfo = sCacheInfo.replace("+" + countryCode, "");
                    }
                    withTime.withCountryCode(Integer.valueOf(countryCode));
                }
            }
            withTime.withType(sCacheType.intValue()).withInfo(sCacheInfo);
            loginInfo = withTime.build();
            sCacheType = null;
            sCacheInfo = null;
            return loginInfo;
        }
        loginInfo = null;
        sCacheType = null;
        sCacheInfo = null;
        return loginInfo;
    }

    public static void saveLoginInfo(final LoginInfo loginInfo, final SaveCallback saveCallback) {
        if (TTAccountInit.getConfig().isSaveLoginInfo()) {
            if (loginInfo == null || loginInfo.getType() != 7) {
                new Command<Result>() { // from class: com.bytedance.sdk.account.save.SaveService.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.bytedance.sdk.account.save.async.Command
                    public Result doInBackground() {
                        if (LoginInfo.this == null) {
                            return new Result(-6, SaveConstants.Error.MSG_LOGIN_INFO_EMPTY);
                        }
                        final Result result = new Result(0, null);
                        final int type = LoginInfo.this.getType();
                        final String info = LoginInfo.this.getInfo();
                        final long uid = LoginInfo.this.getUid();
                        final DBService dBService = DBService.getInstance();
                        dBService.runTransaction(new Task() { // from class: com.bytedance.sdk.account.save.SaveService.1.1
                            @Override // com.bytedance.sdk.account.save.database.Task
                            public void onCompleted() {
                            }

                            @Override // com.bytedance.sdk.account.save.database.Task
                            public void onRunning() {
                                int queryCount = dBService.queryCount();
                                int maxCacheNumber = SaveSettingManager.getMaxCacheNumber();
                                if (queryCount > maxCacheNumber) {
                                    int i = queryCount - maxCacheNumber;
                                    for (int i2 = 0; i2 < i; i2++) {
                                        dBService.deleteOldest();
                                    }
                                    queryCount = maxCacheNumber;
                                }
                                if (dBService.querySame(type, info, uid) != null) {
                                    if (dBService.update(LoginInfo.this)) {
                                        return;
                                    }
                                    result.code = -1;
                                    result.msg = SaveConstants.Error.MSG_UPDATE_ERROR;
                                    return;
                                }
                                if (queryCount == maxCacheNumber) {
                                    dBService.deleteOldest();
                                    if (dBService.insert(LoginInfo.this)) {
                                        return;
                                    }
                                    result.code = -2;
                                    result.msg = SaveConstants.Error.MSG_INSERT_ERROR;
                                    return;
                                }
                                if (dBService.insert(LoginInfo.this)) {
                                    return;
                                }
                                result.code = -2;
                                result.msg = SaveConstants.Error.MSG_INSERT_ERROR;
                            }
                        });
                        return result;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.bytedance.sdk.account.save.async.Command
                    public void onPostExecute(Result result) {
                        if (saveCallback == null) {
                            return;
                        }
                        if (result.code == 0) {
                            saveCallback.onSuccess();
                        } else {
                            saveCallback.onError(result.code, result.msg);
                        }
                    }
                }.execute();
            }
        }
    }

    public static void queryByTime(long j, QueryListCallback queryListCallback) {
        queryList(1, Long.valueOf(j), queryListCallback);
    }

    public static void queryByType(int i, QueryListCallback queryListCallback) {
        queryList(2, Integer.valueOf(i), queryListCallback);
    }

    public static void queryByInfo(String str, QueryListCallback queryListCallback) {
        queryList(3, str, queryListCallback);
    }

    public static void queryByUid(long j, QueryListCallback queryListCallback) {
        queryList(4, Long.valueOf(j), queryListCallback);
    }

    public static void queryLatestAccounts(QueryListCallback queryListCallback) {
        queryList(5, null, queryListCallback);
    }

    public static void queryAll(QueryListCallback queryListCallback) {
        queryList(0, null, queryListCallback);
    }

    private static void queryList(final int i, final Object obj, final QueryListCallback queryListCallback) {
        new Command<List<LoginInfo>>() { // from class: com.bytedance.sdk.account.save.SaveService.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.account.save.async.Command
            public List<LoginInfo> doInBackground() {
                return DBService.getInstance().queryDatas(i, obj);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.account.save.async.Command
            public void onPostExecute(List<LoginInfo> list) {
                if (queryListCallback == null) {
                    return;
                }
                if (list == null || list.size() == 0) {
                    queryListCallback.onError(-3, SaveConstants.Error.MSG_QUERY_LIST_ERROR);
                } else {
                    queryListCallback.onSuccess(list);
                }
            }
        }.execute();
    }

    public static void queryLatest(QueryCallback queryCallback) {
        query(1, null, null, null, null, queryCallback);
    }

    public static void queryOldest(QueryCallback queryCallback) {
        query(2, null, null, null, null, queryCallback);
    }

    public static void querySame(int i, String str, QueryCallback queryCallback) {
        query(3, null, Integer.valueOf(i), str, null, queryCallback);
    }

    public static void querySame(int i, String str, long j, QueryCallback queryCallback) {
        query(3, null, Integer.valueOf(i), str, Long.valueOf(j), queryCallback);
    }

    public static void queryMask(int i, String str, QueryCallback queryCallback) {
        query(4, null, Integer.valueOf(i), str, null, queryCallback);
    }

    private static void query(final int i, final Long l, final Integer num, final String str, final Long l2, final QueryCallback queryCallback) {
        new Command<LoginInfo>() { // from class: com.bytedance.sdk.account.save.SaveService.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.sdk.account.save.async.Command
            public LoginInfo doInBackground() {
                return DBService.getInstance().queryData(i, l, num, str, l2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.account.save.async.Command
            public void onPostExecute(LoginInfo loginInfo) {
                QueryCallback queryCallback2 = queryCallback;
                if (queryCallback2 == null) {
                    return;
                }
                if (loginInfo == null) {
                    queryCallback2.onError(-4, SaveConstants.Error.MSG_QUERY_ERROR);
                } else {
                    queryCallback2.onSuccess(loginInfo);
                }
            }
        }.execute();
    }

    public static void deleteLatest(DeleteCallback deleteCallback) {
        delete(1, null, deleteCallback);
    }

    public static void deleteOldest(DeleteCallback deleteCallback) {
        delete(2, null, deleteCallback);
    }

    public static void deleteByTime(long j, DeleteCallback deleteCallback) {
        delete(3, Long.valueOf(j), deleteCallback);
    }

    public static void deleteByType(int i, DeleteCallback deleteCallback) {
        delete(4, Integer.valueOf(i), deleteCallback);
    }

    public static void deleteByInfo(String str, DeleteCallback deleteCallback) {
        delete(5, str, deleteCallback);
    }

    private static void delete(final int i, final Object obj, final DeleteCallback deleteCallback) {
        new Command<Result>() { // from class: com.bytedance.sdk.account.save.SaveService.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.sdk.account.save.async.Command
            public Result doInBackground() {
                if (DBService.getInstance().delete(i, obj)) {
                    return new Result(0, null);
                }
                return new Result(-5, SaveConstants.Error.MSG_DELETE_ERROR);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.account.save.async.Command
            public void onPostExecute(Result result) {
                if (deleteCallback == null) {
                    return;
                }
                if (result.code == 0) {
                    deleteCallback.onSuccess();
                } else {
                    deleteCallback.onError(result.code, result.msg);
                }
            }
        }.execute();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Result {
        public int code;
        public String msg;

        Result(int i, String str) {
            this.code = i;
            this.msg = str;
        }
    }

    public static void updateSecUid(final Context context, final String str, final String str2, final DeleteCallback deleteCallback) {
        new Command<Result>() { // from class: com.bytedance.sdk.account.save.SaveService.5
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.sdk.account.save.async.Command
            public Result doInBackground() {
                boolean updateSecUid = DBService.getInstance().updateSecUid(str, str2);
                LogHelper.d(SaveService.TAG, "updateSecUid res = " + updateSecUid);
                if (updateSecUid) {
                    BDAccountDelegateInner.instance(context).addHasUpdateSecUids(str);
                    return new Result(0, null);
                }
                return new Result(-1, SaveConstants.Error.MSG_UPDATE_ERROR);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.account.save.async.Command
            public void onPostExecute(Result result) {
                if (deleteCallback == null) {
                    return;
                }
                if (result.code == 0) {
                    deleteCallback.onSuccess();
                } else {
                    deleteCallback.onError(result.code, result.msg);
                }
            }
        }.execute();
    }
}
