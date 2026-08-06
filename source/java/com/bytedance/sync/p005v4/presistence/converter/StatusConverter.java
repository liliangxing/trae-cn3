package com.bytedance.sync.p005v4.presistence.converter;

import com.bytedance.sync.p005v4.protocal.Status;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class StatusConverter {
    public static Status revertStatus(int i) {
        Status fromValue = Status.fromValue(i);
        return fromValue == null ? Status.InValid : fromValue;
    }

    public static int converterStatus(Status status) {
        if (status == null) {
            return Status.InValid.getValue();
        }
        return status.getValue();
    }
}
