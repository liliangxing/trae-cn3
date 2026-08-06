package com.bytedance.bdinstall;

import com.bytedance.trae.applog.api.BDTrackerConsts;

/* loaded from: classes3.dex */
public class Env extends AbsEnv {
    public static Env CHINA = new Env(InstallUrl.createUriByDomain(BDTrackerConsts.EVENT_VERIFY_HOST, true), false, false);
    public static Env CHINA_BOE = new Env(InstallUrl.createUriByDomain("https://boe.i.snssdk.com", true), false, true);
    public static final Env DEFAULT = CHINA;

    public Env(InstallUrl installUrl, boolean z, boolean z2) {
        this(installUrl, z, z2, false);
    }

    public Env(InstallUrl installUrl, boolean z, boolean z2, boolean z3) {
        super(installUrl, z, z2, z3);
    }
}
