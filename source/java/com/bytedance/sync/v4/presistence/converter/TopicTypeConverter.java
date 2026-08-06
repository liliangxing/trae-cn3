package com.bytedance.sync.v4.presistence.converter;

import com.bytedance.sync.v4.protocal.TopicType;

/* loaded from: classes5.dex */
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
