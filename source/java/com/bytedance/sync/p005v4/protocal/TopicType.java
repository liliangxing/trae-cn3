package com.bytedance.sync.p005v4.protocal;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public enum TopicType implements WireEnum {
    SpecTopic(0),
    GlobalTopic(1),
    CustomTopic(2);

    public static final ProtoAdapter<TopicType> ADAPTER = new EnumAdapter<TopicType>() { // from class: com.bytedance.sync.v4.protocal.TopicType.ProtoAdapter_TopicType
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: fromValue, reason: merged with bridge method [inline-methods] */
        public TopicType m1020fromValue(int i) {
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

    public int getValue() {
        return this.value;
    }
}
