package com.bytedance.trae.login.api;

import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ILoginService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/login/api/LoginDeviceListResult;", "", "devices", "", "Lcom/bytedance/trae/login/api/LoginDeviceInfo;", "maxDeviceCount", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "getDevices", "()Ljava/util/List;", "getMaxDeviceCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedance/trae/login/api/LoginDeviceListResult;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoginDeviceListResult {
    private final List<LoginDeviceInfo> devices;
    private final Integer maxDeviceCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoginDeviceListResult copy$default(LoginDeviceListResult loginDeviceListResult, List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = loginDeviceListResult.devices;
        }
        if ((i & 2) != 0) {
            num = loginDeviceListResult.maxDeviceCount;
        }
        return loginDeviceListResult.copy(list, num);
    }

    public final List<LoginDeviceInfo> component1() {
        return this.devices;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getMaxDeviceCount() {
        return this.maxDeviceCount;
    }

    public final LoginDeviceListResult copy(List<LoginDeviceInfo> devices, Integer maxDeviceCount) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        return new LoginDeviceListResult(devices, maxDeviceCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginDeviceListResult)) {
            return false;
        }
        LoginDeviceListResult loginDeviceListResult = (LoginDeviceListResult) other;
        return Intrinsics.areEqual(this.devices, loginDeviceListResult.devices) && Intrinsics.areEqual(this.maxDeviceCount, loginDeviceListResult.maxDeviceCount);
    }

    public int hashCode() {
        int hashCode = this.devices.hashCode() * 31;
        Integer num = this.maxDeviceCount;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "LoginDeviceListResult(devices=" + this.devices + ", maxDeviceCount=" + this.maxDeviceCount + ')';
    }

    public LoginDeviceListResult(List<LoginDeviceInfo> devices, Integer num) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        this.devices = devices;
        this.maxDeviceCount = num;
    }

    public final List<LoginDeviceInfo> getDevices() {
        return this.devices;
    }

    public final Integer getMaxDeviceCount() {
        return this.maxDeviceCount;
    }
}
