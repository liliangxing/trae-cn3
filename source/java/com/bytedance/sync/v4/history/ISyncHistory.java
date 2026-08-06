package com.bytedance.sync.v4.history;

import com.bytedance.sync.model.Topic;
import com.bytedance.sync.v4.protocal.TopicType;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes5.dex */
public interface ISyncHistory {

    /* loaded from: classes5.dex */
    public @interface HistoryDataType {
        public static final int SPEC = TopicType.SpecTopic.getValue();
        public static final int GLOBAL = TopicType.GlobalTopic.getValue();
        public static final int CUSTOM = TopicType.CustomTopic.getValue();
    }

    /* loaded from: classes5.dex */
    public static class HistoryDataConfiguration {
        public long businessId;
        public int dataType;
        public int limit;
        public Topic topic;

        public HistoryDataConfiguration(int i, long j, int i2, Topic topic) {
            this.dataType = i;
            this.businessId = j;
            this.limit = i2;
            this.topic = topic;
        }

        public HistoryDataConfiguration(int i, long j, int i2) {
            this.dataType = i;
            this.businessId = j;
            this.limit = i2;
            this.topic = null;
        }

        /* loaded from: classes5.dex */
        public static class Builder {
            private long businessId;
            private int dataType;
            private int limit;
            private Topic topic;

            public Builder dataType(int i) {
                this.dataType = i;
                return this;
            }

            public Builder businessId(long j) {
                this.businessId = j;
                return this;
            }

            public Builder limit(int i) {
                this.limit = i;
                return this;
            }

            public Builder topic(Topic topic) {
                this.topic = topic;
                return this;
            }

            public HistoryDataConfiguration build() {
                Topic topic;
                if (this.dataType == HistoryDataType.CUSTOM && ((topic = this.topic) == null || topic.getTopic() == null)) {
                    throw new IllegalArgumentException("historyConfiguration error, please check topic");
                }
                return new HistoryDataConfiguration(this.dataType, this.businessId, this.limit, this.topic);
            }
        }

        public String toKey() {
            String str = this.dataType + Constants.COLON_SEPARATOR + this.businessId;
            return this.topic != null ? str + Constants.COLON_SEPARATOR + this.topic.getTopic() : str;
        }
    }

    /* loaded from: classes5.dex */
    public static class HistoryData {
        public long businessId;
        public int count;
        public int dataType;
        public Topic topic;

        public HistoryData(int i, long j, Topic topic, int i2) {
            this.dataType = i;
            this.businessId = j;
            this.count = i2;
            this.topic = topic;
        }

        public HistoryData(int i, long j, int i2) {
            this.dataType = i;
            this.businessId = j;
            this.count = i2;
            this.topic = null;
        }

        /* loaded from: classes5.dex */
        public static class Builder {
            private long businessId;
            private int count;
            private int dataType;
            private Topic topic;

            public Builder dataType(int i) {
                this.dataType = i;
                return this;
            }

            public Builder businessId(long j) {
                this.businessId = j;
                return this;
            }

            public Builder count(int i) {
                this.count = i;
                return this;
            }

            public Builder topic(Topic topic) {
                this.topic = topic;
                return this;
            }

            public HistoryData build() {
                Topic topic;
                if (this.dataType == HistoryDataType.CUSTOM && ((topic = this.topic) == null || topic.getTopic() == null)) {
                    throw new IllegalArgumentException("historyConfiguration error, please check topic");
                }
                return new HistoryData(this.dataType, this.businessId, this.topic, this.count);
            }
        }
    }
}
