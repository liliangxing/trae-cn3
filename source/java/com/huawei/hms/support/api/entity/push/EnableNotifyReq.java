package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class EnableNotifyReq implements IMessageEntity {

    @Packed
    private boolean enable;

    @Packed
    private String packageName;

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EnableNotifyReq{packageName='");
        sb.append(this.packageName).append("', enable=");
        sb.append(this.enable);
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
