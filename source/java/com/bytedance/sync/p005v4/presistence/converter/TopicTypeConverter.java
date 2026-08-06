package com.bytedance.sync.p005v4.presistence.converter;

import com.bytedance.sync.p005v4.protocal.TopicType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TopicTypeConverter {
    public static TopicType revertTopicType(int i) {
        TopicType fromValue = TopicType.fromValue(i);
        return fromValue == null ? TopicType.SpecTopic : fromValue;
    }

    public static int converterStatus(TopicType topicType) {
        if (topicType == null) {
            return TopicType.SpecTopic.getValue();
        }
        return topicType.getValue();
    }
}
