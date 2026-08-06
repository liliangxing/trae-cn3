package com.bytedance.sdk.account.platform;

import android.os.Bundle;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
abstract class PlatformDelegate {
    PlatformBindAdapter bindDelegate;
    PlatformLoginAdapter loginDelegate;
    PlatformProfileAdapter profileAdapter;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    interface IFactory {
        PlatformDelegate createBind(PlatformBindAdapter platformBindAdapter);

        PlatformDelegate createLogin(PlatformLoginAdapter platformLoginAdapter);

        PlatformDelegate createProfile(PlatformProfileAdapter platformProfileAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void cancelBind();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void cancelLogin();

    abstract void cancelProfile();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void requestBind(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void requestLogin(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void requestProfile(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlatformDelegate(PlatformBindAdapter platformBindAdapter) {
        this.bindDelegate = platformBindAdapter;
        this.loginDelegate = null;
        this.profileAdapter = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlatformDelegate(PlatformLoginAdapter platformLoginAdapter) {
        this.loginDelegate = platformLoginAdapter;
        this.bindDelegate = null;
        this.profileAdapter = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlatformDelegate(PlatformProfileAdapter platformProfileAdapter) {
        this.profileAdapter = platformProfileAdapter;
        this.loginDelegate = null;
        this.bindDelegate = null;
    }
}
