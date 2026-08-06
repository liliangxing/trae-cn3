package com.bytedance.common.wschannel.event;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MessageAckEvent {
    private final int mChannelId;
    private JSONObject mLogInfo;
    private final int mMethodId;
    private final int mServiceId;
    private MessageState mState = MessageState.Default;
    private final String mUniqueId;

    /* loaded from: classes3.dex */
    public enum MessageState {
        Default(0),
        TimeOut(1),
        Failed(2),
        Success(3);

        final int mState;

        MessageState(int i) {
            this.mState = i;
        }

        public int getTypeValue() {
            return this.mState;
        }

        public static MessageState valueOf(int i) {
            if (i == 1) {
                return TimeOut;
            }
            if (i == 2) {
                return Failed;
            }
            if (i == 3) {
                return Success;
            }
            return Default;
        }
    }

    public MessageAckEvent(String str, int i, int i2, int i3, String str2) {
        this.mUniqueId = str;
        this.mChannelId = i;
        this.mServiceId = i2;
        this.mMethodId = i3;
        try {
            this.mLogInfo = new JSONObject(str2);
        } catch (JSONException unused) {
        }
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public MessageState getState() {
        return this.mState;
    }

    public void setState(MessageState messageState) {
        this.mState = messageState;
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    public int getMethodId() {
        return this.mMethodId;
    }

    public JSONObject getLogInfo() {
        return this.mLogInfo;
    }

    public String toString() {
        return "UniqueId:" + this.mUniqueId + ", ChannelId:" + this.mChannelId + ", methodId:" + this.mMethodId + ", state:" + this.mState + ", logInfo:" + this.mLogInfo.toString();
    }
}
