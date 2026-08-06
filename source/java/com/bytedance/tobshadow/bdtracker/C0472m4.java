package com.bytedance.tobshadow.bdtracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.bytedance.tobshadow.bdtracker.m4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0472m4 extends AbstractC0486o4 {

    /* renamed from: c */
    public final AccountManager f814c;

    /* renamed from: d */
    public Account f815d;

    /* renamed from: e */
    public final ConcurrentHashMap<String, String> f816e = new ConcurrentHashMap<>();

    /* renamed from: f */
    public final C0467m f817f;

    /* renamed from: com.bytedance.tobshadow.bdtracker.m4$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Account f818a;

        public a(Account account) {
            this.f818a = account;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (C0472m4.this.f816e.size() > 0 && C0472m4.this.f814c != null) {
                    for (Map.Entry<String, String> entry : C0472m4.this.f816e.entrySet()) {
                        if (entry != null) {
                            C0472m4.this.f814c.setUserData(this.f818a, entry.getKey(), entry.getValue());
                        }
                    }
                    C0472m4.this.f816e.clear();
                }
            } catch (Throwable th) {
                C0472m4.this.f817f.f764D.error(Collections.singletonList("AccountCacheHelper"), "Set account failed", th, new Object[0]);
            }
        }
    }

    public C0472m4(C0467m c0467m, Context context) {
        this.f817f = c0467m;
        this.f814c = AccountManager.get(context);
    }

    /* renamed from: a */
    public void m529a(Account account) {
        if (account != null) {
            this.f815d = account;
            if (this.f816e.size() <= 0) {
                return;
            }
            this.f896b.post(new a(account));
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4
    /* renamed from: a */
    public void mo531a(String str, String str2) {
        Account account = this.f815d;
        if (account == null) {
            this.f816e.put(str, str2);
            return;
        }
        if (str == null || str2 == null) {
            return;
        }
        try {
            this.f814c.setUserData(account, str, str2);
        } catch (Throwable th) {
            this.f817f.f764D.error(Collections.singletonList("AccountCacheHelper"), "Set user data failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4
    /* renamed from: b */
    public String mo532b(String str) {
        Account account = this.f815d;
        if (account == null) {
            return this.f816e.get(str);
        }
        try {
            return this.f814c.getUserData(account, str);
        } catch (Throwable th) {
            this.f817f.f764D.error(Collections.singletonList("AccountCacheHelper"), "Get user data failed", th, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4
    /* renamed from: a */
    public void mo530a(String str) {
        AccountManager accountManager;
        this.f816e.remove(str);
        try {
            Account account = this.f815d;
            if (account != null && (accountManager = this.f814c) != null) {
                accountManager.setUserData(account, str, null);
            }
        } catch (Throwable unused) {
        }
        AbstractC0486o4 abstractC0486o4 = this.f895a;
        if (abstractC0486o4 != null) {
            abstractC0486o4.mo530a(str);
        }
    }
}
