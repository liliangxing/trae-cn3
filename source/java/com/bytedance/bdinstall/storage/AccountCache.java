package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AccountCache extends Cache {
    private static final String TAG = "AccountCache";
    private Account mAccount;
    private final AccountManager mAccountManager;
    private final ConcurrentHashMap<String, String> mCache = new ConcurrentHashMap<>();
    private InstallOptions mOptions;
    private final String mSuffix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountCache(Context context, String str, InstallOptions installOptions) {
        this.mAccountManager = AccountManager.get(context);
        this.mSuffix = str;
        this.mOptions = installOptions;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String str, String str2) {
        String wrapKey = wrapKey(str);
        Account account = this.mAccount;
        if (account == null) {
            this.mCache.put(wrapKey, str2);
        } else {
            if (str2 == null) {
                return;
            }
            try {
                this.mAccountManager.setUserData(account, wrapKey, str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private String wrapKey(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(this.mSuffix);
        if (!this.mOptions.isMainInstance()) {
            stringBuffer.append("_");
            stringBuffer.append(this.mOptions.getAidString());
        }
        return stringBuffer.toString();
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String str) {
        String wrapKey = wrapKey(str);
        String str2 = this.mCache.get(wrapKey);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        Account account = this.mAccount;
        if (account == null) {
            return null;
        }
        try {
            return this.mAccountManager.getUserData(account, wrapKey);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected String[] getCachedStringArray(String str) {
        String cachedString = getCachedString(str);
        if (TextUtils.isEmpty(cachedString)) {
            return null;
        }
        return cachedString.split("\n");
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected void cacheStringArray(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return;
        }
        cacheString(str, TextUtils.join("\n", strArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAccount(String str, final Account account) {
        if (account != null) {
            this.mAccount = account;
            if (this.mCache.size() <= 0) {
                return;
            }
            ExecutorUtil.runOnIOExecutor(str, new Runnable() { // from class: com.bytedance.bdinstall.storage.AccountCache.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (AccountCache.this.mCache.size() > 0 && AccountCache.this.mAccountManager != null) {
                            for (Map.Entry entry : AccountCache.this.mCache.entrySet()) {
                                if (entry != null) {
                                    AccountCache.this.mAccountManager.setUserData(account, (String) entry.getKey(), (String) entry.getValue());
                                }
                            }
                            AccountCache.this.mCache.clear();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> list) {
        AccountManager accountManager;
        if (list == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String wrapKey = wrapKey(it.next());
            this.mCache.remove(wrapKey);
            try {
                Account account = this.mAccount;
                if (account != null && (accountManager = this.mAccountManager) != null) {
                    accountManager.setUserData(account, wrapKey, null);
                }
            } catch (Exception unused) {
            }
        }
        super.clear(list);
    }
}
