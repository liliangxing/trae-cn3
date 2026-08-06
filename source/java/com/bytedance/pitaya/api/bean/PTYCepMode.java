package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* compiled from: PTYCepMode.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYCepMode;", "", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "Independent", "Dependent", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public enum PTYCepMode implements ReflectionCall {
    Independent(0),
    Dependent(1);

    private final int code;

    PTYCepMode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
