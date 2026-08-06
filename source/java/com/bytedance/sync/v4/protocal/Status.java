package com.bytedance.sync.v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: classes5.dex */
public enum Status implements WireEnum {
    InValid(0),
    Valid(1);

    public static final ProtoAdapter<Status> ADAPTER = new EnumAdapter<Status>() { // from class: com.bytedance.sync.v4.protocal.Status.ProtoAdapter_Status
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.EnumAdapter
        public Status fromValue(int i) {
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

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
