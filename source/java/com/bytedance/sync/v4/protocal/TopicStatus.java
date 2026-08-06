package com.bytedance.sync.v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: classes5.dex */
public enum TopicStatus implements WireEnum {
    NotExist(0),
    Active(1),
    Closed(2);

    public static final ProtoAdapter<TopicStatus> ADAPTER = new EnumAdapter<TopicStatus>() { // from class: com.bytedance.sync.v4.protocal.TopicStatus.ProtoAdapter_TopicStatus
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.EnumAdapter
        public TopicStatus fromValue(int i) {
            return TopicStatus.fromValue(i);
        }
    };
    private final int value;

    TopicStatus(int i) {
        this.value = i;
    }

    public static TopicStatus fromValue(int i) {
        if (i == 0) {
            return NotExist;
        }
        if (i == 1) {
            return Active;
        }
        if (i != 2) {
            return null;
        }
        return Closed;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
