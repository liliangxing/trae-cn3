package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum Status implements WireEnum {
    InValid(0),
    Valid(1);

    public static final ProtoAdapter<Status> ADAPTER = new EnumAdapter<Status>() { // from class: com.bytedance.sync.v4.protocal.Status.ProtoAdapter_Status
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public Status m1018fromValue(int i) {
            return Status.fromValue(i);
        }
    };
    private final int value;

    Status(int i) {
        this.value = i;
    }

    public static Status fromValue(int i) {
        if (i == 0) {
            return InValid;
        }
        if (i != 1) {
            return null;
        }
        return Valid;
    }

    public int getValue() {
        return this.value;
    }
}
