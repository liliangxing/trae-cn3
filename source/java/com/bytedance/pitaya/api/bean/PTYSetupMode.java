package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* compiled from: PTYSetupMode.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYSetupMode;", "", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "None", "Pre", "Lite", "Normal", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public enum PTYSetupMode implements ReflectionCall {
    None(0),
    Pre(1),
    Lite(2),
    Normal(3);

    private final int code;

    PTYSetupMode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
