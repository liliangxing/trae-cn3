package com.bytedance.sync.v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: classes5.dex */
public enum TopicType implements WireEnum {
    SpecTopic(0),
    GlobalTopic(1),
    CustomTopic(2);

    public static final ProtoAdapter<TopicType> ADAPTER = new EnumAdapter<TopicType>() { // from class: com.bytedance.sync.v4.protocal.TopicType.ProtoAdapter_TopicType
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.EnumAdapter
        public TopicType fromValue(int i) {
            return TopicType.fromValue(i);
        }
    };
    private final int value;

    TopicType(int i) {
        this.value = i;
    }

    public static TopicType fromValue(int i) {
        if (i == 0) {
            return SpecTopic;
        }
        if (i == 1) {
            return GlobalTopic;
        }
        if (i != 2) {
            return null;
        }
        return CustomTopic;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
