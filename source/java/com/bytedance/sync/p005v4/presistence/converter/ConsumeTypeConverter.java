package com.bytedance.sync.p005v4.presistence.converter;

import com.bytedance.sync.p005v4.protocal.ConsumeType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ConsumeTypeConverter {
    public static ConsumeType revertDate(int i) {
        ConsumeType fromValue = ConsumeType.fromValue(i);
        return fromValue == null ? ConsumeType.Increment : fromValue;
    }

    public static int converterDate(ConsumeType consumeType) {
        return consumeType.getValue();
    }
}
