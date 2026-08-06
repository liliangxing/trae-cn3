package com.bytedance.bdturing.utils;

import android.os.Build;
import kotlin.Metadata;

/* compiled from: Consts.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdturing/utils/Consts;", "", "()V", "DEVICE_BRAND", "", "kotlin.jvm.PlatformType", "DEVICE_MODEL", "OS_API_VERSION", "", "OS_NAME", "OS_TYPE", "SDK_VERSION", "SYSTEM_VERSION", "TTNET_TARGET_VERSION", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Consts {
    public static final String OS_NAME = "android";
    public static final int OS_TYPE = 0;
    public static final String SDK_VERSION = "4.1.1.cn";
    public static final String TTNET_TARGET_VERSION = "4.1.70.7";
    public static final Consts INSTANCE = new Consts();
    public static final String DEVICE_BRAND = Build.BRAND;
    public static final String DEVICE_MODEL = Build.MODEL;
    public static final int OS_API_VERSION = Build.VERSION.SDK_INT;
    public static final String SYSTEM_VERSION = Build.VERSION.RELEASE;

    private Consts() {
    }
}
