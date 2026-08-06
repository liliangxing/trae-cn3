package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum Version implements WireEnum {
    Unknown(0),
    V1(1),
    V2(2),
    V21(3),
    V4(4);

    public static final ProtoAdapter<Version> ADAPTER = new EnumAdapter<Version>() { // from class: com.bytedance.sync.v4.protocal.Version.ProtoAdapter_Version
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public Version m1021fromValue(int i) {
            return Version.fromValue(i);
        }
    };
    private final int value;

    Version(int i) {
        this.value = i;
    }

    public static Version fromValue(int i) {
        if (i == 0) {
            return Unknown;
        }
        if (i == 1) {
            return V1;
        }
        if (i == 2) {
            return V2;
        }
        if (i == 3) {
            return V21;
        }
        if (i != 4) {
            return null;
        }
        return V4;
    }

    public int getValue() {
        return this.value;
    }
}
