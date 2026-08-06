package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.InstallOptions;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class StorageSettings {
    private Account account;
    private String fileName;
    private boolean isAnonymous;
    private boolean isLocalTest;
    private boolean needSharedStorage = false;
    private InstallOptions options;

    /* renamed from: sp */
    private SharedPreferences f92sp;
    private String suffix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public SharedPreferences getSp() {
        return this.f92sp;
    }

    public void setSp(SharedPreferences sharedPreferences) {
        this.f92sp = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLocalTest() {
        return this.isLocalTest;
    }

    public void setLocalTest(boolean z) {
        this.isLocalTest = z;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnonymous(boolean z) {
        this.isAnonymous = z;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account, String str) {
        this.account = account;
        this.suffix = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSuffix() {
        return this.suffix;
    }

    public boolean isNeedSharedStorage() {
        return this.needSharedStorage;
    }

    public void setNeedSharedStorage(boolean z) {
        this.needSharedStorage = z;
    }

    public void setOptions(InstallOptions installOptions) {
        this.options = installOptions;
    }

    public InstallOptions getOptions() {
        return this.options;
    }
}
