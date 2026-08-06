package com.bytedance.sdk.account.save.entity;

import java.util.List;

/* loaded from: classes5.dex */
public enum InfoType {
    INFO_TYPE_1(1),
    INFO_TYPE_2(2),
    INFO_TYPE_3(4);

    private int type;

    InfoType(int i) {
        this.type = i;
    }

    public int getValue() {
        return this.type;
    }

    public static int getValue(List<InfoType> list) {
        if (list == null) {
            return 0;
        }
        InfoType infoType = INFO_TYPE_1;
        int i = list.contains(infoType) ? 0 + infoType.type : 0;
        InfoType infoType2 = INFO_TYPE_2;
        if (list.contains(infoType2)) {
            i += infoType2.type;
        }
        InfoType infoType3 = INFO_TYPE_3;
        return list.contains(infoType3) ? i + infoType3.type : i;
    }
}
