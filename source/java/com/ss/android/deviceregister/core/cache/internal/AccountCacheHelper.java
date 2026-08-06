package com.ss.android.deviceregister.core.cache.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.LogUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AccountCacheHelper extends CacheHelper {
    private static final String TAG = "AccountCacheHelper";
    private Account mAccount;
    private final AccountManager mAccountManager;
    private final ConcurrentHashMap<String, String> mCache = new ConcurrentHashMap<>();
    private volatile Set<String> mPendingClearKey = null;

    public AccountCacheHelper(Context context) {
        this.mAccountManager = AccountManager.get(context);
    }

    @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper
    protected void cacheString(String str, String str2) {
        LogUtils.m88d(LogUtils.TAG, "AccountCacheHelper#cacheString key=" + str + " value=" + str2 + " mAccount=" + this.mAccount);
        if (this.mAccount == null) {
            this.mCache.put(str, str2);
            return;
        }
        if (str == null || str2 == null) {
            return;
        }
        try {
            if (Logger.debug()) {
                TLog.m73d("AccountCacheHelper cache string : key = " + str + ",value = " + str2);
            }
            this.mAccountManager.setUserData(this.mAccount, str, str2);
        } catch (Throwable th) {
            if (Logger.debug()) {
                TLog.m76e("save string error,please fix it : ", th);
            }
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper
    protected String getCachedString(String str) {
        Account account = this.mAccount;
        if (account == null) {
            return null;
        }
        try {
            String userData = this.mAccountManager.getUserData(account, str);
            if (Logger.debug()) {
                TLog.m73d("AccountCacheHelper get cached string : key = " + str + ",value = " + userData);
            }
            return userData;
        } catch (Throwable th) {
            if (Logger.debug()) {
                TLog.m75e("get string error,please fix it : ");
            }
            th.printStackTrace();
            return null;
        }
    }

    public void setAccount(final Account account) {
        if (account != null) {
            synchronized (this) {
                this.mAccount = account;
                if (this.mCache.size() <= 0) {
                    return;
                }
                if (this.mPendingClearKey != null) {
                    Iterator<String> it = this.mPendingClearKey.iterator();
                    while (it.hasNext()) {
                        try {
                            this.mAccountManager.setUserData(this.mAccount, it.next(), null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.android.deviceregister.core.cache.internal.AccountCacheHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (AccountCacheHelper.this.mCache != null && AccountCacheHelper.this.mCache.size() > 0 && AccountCacheHelper.this.mAccountManager != null) {
                                for (Map.Entry entry : AccountCacheHelper.this.mCache.entrySet()) {
                                    if (entry != null) {
                                        AccountCacheHelper.this.mAccountManager.setUserData(account, (String) entry.getKey(), (String) entry.getValue());
                                    }
                                }
                                AccountCacheHelper.this.mCache.clear();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper
    public void clear(String str) {
        AccountManager accountManager;
        ConcurrentHashMap<String, String> concurrentHashMap = this.mCache;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            this.mCache.remove(str);
        }
        try {
            synchronized (this) {
                if (this.mAccount == null) {
                    if (this.mPendingClearKey == null) {
                        this.mPendingClearKey = new CopyOnWriteArraySet();
                    }
                    if (!this.mPendingClearKey.contains(str)) {
                        this.mPendingClearKey.add(str);
                    }
                }
            }
            Account account = this.mAccount;
            if (account != null && (accountManager = this.mAccountManager) != null) {
                accountManager.setUserData(account, str, null);
            }
        } catch (Exception unused) {
        }
        LogUtils.m88d(LogUtils.TAG, "AccountCacheHelper#clear key=" + str + " mAccount=" + this.mAccount + " getCachedString(key)=" + getCachedString(str));
        super.clear(str);
    }
}
