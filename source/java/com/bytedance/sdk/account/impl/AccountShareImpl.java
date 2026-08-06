package com.bytedance.sdk.account.impl;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.sdk.account.api.IAccountShare;
import com.bytedance.sdk.account.api.IBDAccountAPIV3;
import com.bytedance.sdk.account.api.OnShareAccountListener;
import com.bytedance.sdk.account.api.callback.CanChainQuickLoginCallback;
import com.bytedance.sdk.account.api.response.CanChainLoginResponse;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.user.AccountShareInfo;
import com.ss.android.account.TTAccountInit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AccountShareImpl implements WeakHandler.IHandler, IAccountShare {
    private static volatile IAccountShare sInstance;
    private IBDAccountAPIV3 mAccountAPI = BDAccountAPIV3Impl.instance();
    private WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);

    public void handleMsg(Message message) {
    }

    private AccountShareImpl() {
    }

    public static IAccountShare instance() {
        if (sInstance == null) {
            synchronized (AccountShareImpl.class) {
                if (sInstance == null) {
                    sInstance = new AccountShareImpl();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccountShareInfo covertModel(Cursor cursor) {
        AccountShareInfo accountShareInfo = new AccountShareInfo();
        accountShareInfo.secUserId = cursor.getString(cursor.getColumnIndex(AccountConstants.AccountShareCols.SEC_USER_ID));
        accountShareInfo.userName = cursor.getString(cursor.getColumnIndex("user_name"));
        accountShareInfo.userAvatar = cursor.getString(cursor.getColumnIndex(AccountConstants.AccountShareCols.USER_AVATAR));
        accountShareInfo.userSession = cursor.getString(cursor.getColumnIndex(AccountConstants.AccountShareCols.USER_SESSION));
        accountShareInfo.accountType = cursor.getInt(cursor.getColumnIndex(AccountConstants.AccountShareCols.ACCOUNT_TYPE));
        accountShareInfo.isLogin = cursor.getInt(cursor.getColumnIndex(AccountConstants.AccountShareCols.ACCOUNT_ONLINE));
        accountShareInfo.fromInstallId = cursor.getString(cursor.getColumnIndex(AccountConstants.AccountShareCols.FROM_INSTALL_ID));
        accountShareInfo.accountExtra = cursor.getString(cursor.getColumnIndex(AccountConstants.AccountShareCols.ACCOUNT_EXTRA));
        return accountShareInfo;
    }

    @Override // com.bytedance.sdk.account.api.IAccountShare
    public void queryShareAccount(final String str, final ContentResolver contentResolver, boolean z, final OnShareAccountListener onShareAccountListener) {
        if (z) {
            this.mAccountAPI.canChainLogin(new CanChainQuickLoginCallback() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.1
                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onSuccess(CanChainLoginResponse canChainLoginResponse) {
                    if (canChainLoginResponse != null && canChainLoginResponse.mCanChainLogin) {
                        AccountShareImpl.this.queryData(str, contentResolver, onShareAccountListener);
                        return;
                    }
                    OnShareAccountListener onShareAccountListener2 = onShareAccountListener;
                    if (onShareAccountListener2 != null) {
                        onShareAccountListener2.onQueryResult(new AccountShareInfo("response == null or can not chain login"));
                    }
                }

                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onError(CanChainLoginResponse canChainLoginResponse, int i) {
                    OnShareAccountListener onShareAccountListener2 = onShareAccountListener;
                    if (onShareAccountListener2 != null) {
                        onShareAccountListener2.onQueryResult(new AccountShareInfo("error: " + i + ", msg: " + canChainLoginResponse.errorMsg));
                    }
                }
            });
        } else {
            queryData(str, contentResolver, onShareAccountListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryData(String str, final ContentResolver contentResolver, final OnShareAccountListener onShareAccountListener) {
        final Uri parse = Uri.parse(str);
        new ThreadPlus(new Runnable() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.2
            /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Cursor cursor;
                Throwable th;
                String message;
                final AccountShareInfo accountShareInfo = null;
                try {
                    try {
                        cursor = contentResolver.query(parse, null, null, null, null);
                        if (cursor != null) {
                            try {
                                try {
                                    cursor.moveToFirst();
                                    message = null;
                                    accountShareInfo = AccountShareImpl.covertModel(cursor);
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                    message = e.getMessage();
                                    if (cursor != null) {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    }
                                    if (accountShareInfo == null) {
                                    }
                                    AccountShareImpl.this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (onShareAccountListener != null) {
                                                onShareAccountListener.onQueryResult(accountShareInfo);
                                            }
                                        }
                                    });
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } else {
                            message = "cursor == null";
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th3) {
                    cursor = null;
                    th = th3;
                    if (cursor != null) {
                    }
                    throw th;
                }
                if (cursor != null) {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                }
                if (accountShareInfo == null) {
                    accountShareInfo = new AccountShareInfo(message);
                }
                AccountShareImpl.this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (onShareAccountListener != null) {
                            onShareAccountListener.onQueryResult(accountShareInfo);
                        }
                    }
                });
            }
        }, "query_account_share", true).start();
    }

    @Override // com.bytedance.sdk.account.api.IAccountShare
    public void queryShareAccount(String str, OnShareAccountListener onShareAccountListener) {
        getShareAccountInfoFromSystemAccounts(str, onShareAccountListener);
    }

    @Override // com.bytedance.sdk.account.api.IAccountShare
    public void queryShareAccountData(final String str, final String str2, final OnShareAccountListener onShareAccountListener) {
        if (onShareAccountListener == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            onQueryShareAccountEvent(false, "param invalid");
        } else {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AccountManager accountManager = AccountManager.get(TTAccountInit.getConfig().getApplicationContext());
                        Account[] accountsByType = accountManager.getAccountsByType(str);
                        final String str3 = null;
                        if (accountsByType != null) {
                            for (Account account : accountsByType) {
                                str3 = accountManager.getUserData(account, str2);
                                if (!TextUtils.isEmpty(str3)) {
                                    break;
                                }
                            }
                        }
                        AccountShareImpl.this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (TextUtils.isEmpty(str3)) {
                                    onShareAccountListener.onQueryResult(new AccountShareInfo("no share account data"));
                                    AccountShareImpl.this.onQueryShareAccountEvent(false, "no share account data");
                                } else {
                                    AccountShareInfo accountShareInfo = new AccountShareInfo();
                                    accountShareInfo.accountExtra = str3;
                                    onShareAccountListener.onQueryResult(accountShareInfo);
                                    AccountShareImpl.this.onQueryShareAccountEvent(true, null);
                                }
                            }
                        });
                    } catch (Exception e) {
                        AccountShareImpl.this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                String message = e.getMessage();
                                onShareAccountListener.onQueryResult(new AccountShareInfo(message));
                                AccountShareImpl.this.onQueryShareAccountEvent(false, message);
                            }
                        });
                    }
                }
            });
        }
    }

    private void getShareAccountInfoFromSystemAccounts(final String str, final OnShareAccountListener onShareAccountListener) {
        if (TextUtils.isEmpty(str) || onShareAccountListener == null) {
            onQueryShareAccountEvent(false, "param invalid");
        } else {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AccountManager accountManager = AccountManager.get(TTAccountInit.getConfig().getApplicationContext());
                        Account[] accountsByType = accountManager.getAccountsByType(str);
                        final String str2 = null;
                        if (accountsByType != null) {
                            for (Account account : accountsByType) {
                                str2 = accountManager.getUserData(account, AccountConstants.ACCOUNT_SYNC_SHARE_ACCOUNT_INFO_KEY);
                                if (!TextUtils.isEmpty(str2)) {
                                    break;
                                }
                            }
                        }
                        AccountShareImpl.this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (TextUtils.isEmpty(str2)) {
                                    onShareAccountListener.onQueryResult(new AccountShareInfo("no share account info"));
                                    AccountShareImpl.this.onQueryShareAccountEvent(false, "no share account info");
                                    return;
                                }
                                AccountShareInfo fromJsonString = AccountShareInfo.fromJsonString(str2);
                                if (fromJsonString == null) {
                                    onShareAccountListener.onQueryResult(new AccountShareInfo("share account info invalid"));
                                    AccountShareImpl.this.onQueryShareAccountEvent(false, "share account info invalid");
                                } else {
                                    onShareAccountListener.onQueryResult(fromJsonString);
                                    AccountShareImpl.this.onQueryShareAccountEvent(true, null);
                                }
                            }
                        });
                    } catch (Exception e) {
                        AccountShareImpl.this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.account.impl.AccountShareImpl.4.2
                            @Override // java.lang.Runnable
                            public void run() {
                                String message = e.getMessage();
                                onShareAccountListener.onQueryResult(new AccountShareInfo(message));
                                AccountShareImpl.this.onQueryShareAccountEvent(false, message);
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQueryShareAccountEvent(boolean z, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put("result", 1);
            } else {
                jSONObject.put("result", 0);
                jSONObject.put("errorMsg", str);
            }
            AccountMonitorUtil.onEventV3("passport_query_share_account", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
