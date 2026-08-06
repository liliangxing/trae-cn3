package com.bytedance.timonbase;

import com.bytedance.timonbase.teen.ITeenExtra;
import com.bytedance.upc.Configuration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMInitialExtra.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0002\u0010\u0010R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/timonbase/TMInitialExtra;", "", "versionName", "", "versionCode", "", "updateVersionCode", "upcConfig", "Lcom/bytedance/upc/Configuration;", "enableApiControl", "", "teenConfig", "Lcom/bytedance/timonbase/teen/ITeenExtra;", "bpeaEnable", "", "enableApiControlALog", "(Ljava/lang/String;JJLcom/bytedance/upc/Configuration;ZLcom/bytedance/timonbase/teen/ITeenExtra;Ljava/lang/Integer;Z)V", "getBpeaEnable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableApiControl", "()Z", "getEnableApiControlALog", "getTeenConfig", "()Lcom/bytedance/timonbase/teen/ITeenExtra;", "getUpcConfig", "()Lcom/bytedance/upc/Configuration;", "getUpdateVersionCode", "()J", "getVersionCode", "getVersionName", "()Ljava/lang/String;", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMInitialExtra {
    private final Integer bpeaEnable;
    private final boolean enableApiControl;
    private final boolean enableApiControlALog;
    private final ITeenExtra teenConfig;
    private final Configuration upcConfig;
    private final long updateVersionCode;
    private final long versionCode;
    private final String versionName;

    public TMInitialExtra(String str, long j, long j2, Configuration configuration, boolean z, ITeenExtra iTeenExtra, Integer num, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "versionName");
        this.versionName = str;
        this.versionCode = j;
        this.updateVersionCode = j2;
        this.upcConfig = configuration;
        this.enableApiControl = z;
        this.teenConfig = iTeenExtra;
        this.bpeaEnable = num;
        this.enableApiControlALog = z2;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final long getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TMInitialExtra(String str, long j, long j2, Configuration configuration, boolean z, ITeenExtra iTeenExtra, Integer num, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, r9, r10, r11, r12, (i & 128) != 0 ? false : z2);
        Configuration configuration2;
        ITeenExtra iTeenExtra2;
        Integer num2;
        if ((i & 8) != 0) {
            configuration2 = null;
        } else {
            configuration2 = configuration;
        }
        boolean z3 = (i & 16) != 0 ? false : z;
        if ((i & 32) != 0) {
            iTeenExtra2 = null;
        } else {
            iTeenExtra2 = iTeenExtra;
        }
        if ((i & 64) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
    }

    public final Configuration getUpcConfig() {
        return this.upcConfig;
    }

    public final boolean getEnableApiControl() {
        return this.enableApiControl;
    }

    public final ITeenExtra getTeenConfig() {
        return this.teenConfig;
    }

    public final Integer getBpeaEnable() {
        return this.bpeaEnable;
    }

    public final boolean getEnableApiControlALog() {
        return this.enableApiControlALog;
    }
}
