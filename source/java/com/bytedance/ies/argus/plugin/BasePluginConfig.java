package com.bytedance.ies.argus.plugin;

import com.bytedance.ies.argus.bean.ArgusSwitch;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: ISecurePlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/plugin/BasePluginConfig;", "", "()V", "switch", "Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "getSwitch", "()Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "verifyMode", "", "getVerifyMode", "()Ljava/lang/Integer;", "setVerifyMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public abstract class BasePluginConfig {

    @SerializedName("verify_mode")
    private Integer verifyMode = 2;

    public final Integer getVerifyMode() {
        return this.verifyMode;
    }

    public final void setVerifyMode(Integer num) {
        this.verifyMode = num;
    }

    public final ArgusSwitch getSwitch() {
        return new ArgusSwitch(this.verifyMode);
    }
}
