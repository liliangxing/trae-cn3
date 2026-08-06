package com.bytedance.sync.p005v4.presistence.converter;

import com.bytedance.sync.model.DataType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DataTypeConverter {
    public static DataType revertDate(int i) {
        DataType fromValue = DataType.fromValue(i);
        return fromValue == null ? DataType.ORIGIN : fromValue;
    }

    public static int converterDate(DataType dataType) {
        if (dataType == null) {
            return DataType.ORIGIN.getValue();
        }
        return dataType.getValue();
    }
}
