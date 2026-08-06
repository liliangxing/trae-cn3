package com.bytedance.sync.p005v4.presistence.converter;

import com.bytedance.sync.p005v4.protocal.TopicStatus;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TopicStatusConverter {
    public static TopicStatus revertStatus(int i) {
        TopicStatus fromValue = TopicStatus.fromValue(i);
        return fromValue == null ? TopicStatus.NotExist : fromValue;
    }

    public static int converterStatus(TopicStatus topicStatus) {
        if (topicStatus == null) {
            return TopicStatus.NotExist.getValue();
        }
        return topicStatus.getValue();
    }
}
