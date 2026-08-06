package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes6.dex */
public class NotificationEnableReq implements IMessageEntity {

    @Packed
    String pkgName;

    public void setPkgName(String str) {
        this.pkgName = str;
    }
}
