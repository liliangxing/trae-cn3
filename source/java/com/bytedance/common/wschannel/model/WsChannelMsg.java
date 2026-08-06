package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.common.wschannel.utils.Utils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class WsChannelMsg implements Parcelable {
    public static final Parcelable.Creator<WsChannelMsg> CREATOR = new Parcelable.Creator<WsChannelMsg>() { // from class: com.bytedance.common.wschannel.model.WsChannelMsg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WsChannelMsg createFromParcel(Parcel parcel) {
            return new WsChannelMsg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WsChannelMsg[] newArray(int i) {
            return new WsChannelMsg[i];
        }
    };
    public static WsChannelMsg EMPTY = new WsChannelMsg();
    private int channelId;
    private boolean isAckMsg;
    private long logId;
    private String logInfo;
    private int method;
    private List<MsgHeader> msgHeaders;
    private String msgId;
    private NewMsgTimeHolder newMsgTimeHolder;
    private byte[] payload;
    private String payloadEncoding;
    private String payloadType;
    public transient long receiveDataFromIpcTs;
    private ComponentName replayToComponentName;
    private long seqId;
    private String serverTiming;
    private int service;
    private MessageAckEvent.MessageState state;
    private String uuid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public WsChannelMsg() {
        this.state = MessageAckEvent.MessageState.Default;
    }

    public WsChannelMsg(int i, int i2, int i3, String str, boolean z) {
        this.state = MessageAckEvent.MessageState.Default;
        this.channelId = i;
        this.service = i2;
        this.method = i3;
        this.uuid = str;
        this.isAckMsg = z;
    }

    public WsChannelMsg(int i, long j, long j2, int i2, int i3, List<MsgHeader> list, String str, String str2, byte[] bArr, ComponentName componentName) {
        this.state = MessageAckEvent.MessageState.Default;
        this.channelId = i;
        this.seqId = j;
        this.logId = j2;
        this.service = i2;
        this.method = i3;
        this.msgHeaders = list;
        this.payloadEncoding = str;
        this.payloadType = str2;
        this.payload = bArr;
        this.replayToComponentName = componentName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WsChannelMsg(WsChannelMsg wsChannelMsg) {
        this.state = MessageAckEvent.MessageState.Default;
        setSeqId(wsChannelMsg.getSeqId());
        setLogId(wsChannelMsg.getLogId());
        setService(wsChannelMsg.getService());
        setMethod(wsChannelMsg.getMethod());
        setMsgHeaders(wsChannelMsg.getMsgHeaders());
        setPayload(wsChannelMsg.getPayload());
        setPayloadEncoding(wsChannelMsg.getPayloadEncoding());
        setPayloadType(wsChannelMsg.getPayloadType());
        setChannelId(wsChannelMsg.getChannelId());
        setReplayToComponentName(wsChannelMsg.getReplayToComponentName());
        setNewMsgTimeHolder(wsChannelMsg.getNewMsgTimeHolder());
        setIsAckMsg(wsChannelMsg.isAckMsg());
        setUUID(wsChannelMsg.getUUID());
        setState(wsChannelMsg.getState());
        setLogInfo(wsChannelMsg.logInfo);
        setServerTiming(wsChannelMsg.serverTiming);
        setMsgId(wsChannelMsg.msgId);
    }

    public String getUUID() {
        return this.uuid;
    }

    public void setUUID(String str) {
        this.uuid = str;
    }

    public boolean isAckMsg() {
        return this.isAckMsg;
    }

    public void setIsAckMsg(boolean z) {
        this.isAckMsg = z;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public String getServerTiming() {
        return this.serverTiming;
    }

    public void setServerTiming(String str) {
        this.serverTiming = str;
    }

    public String getLogInfo() {
        return this.logInfo;
    }

    public void setLogInfo(String str) {
        this.logInfo = str;
    }

    public MessageAckEvent.MessageState getState() {
        return this.state;
    }

    public void setState(MessageAckEvent.MessageState messageState) {
        this.state = messageState;
    }

    public long getSeqId() {
        return this.seqId;
    }

    public void setSeqId(long j) {
        this.seqId = j;
    }

    public long getLogId() {
        return this.logId;
    }

    public void setLogId(long j) {
        this.logId = j;
    }

    public int getService() {
        return this.service;
    }

    public void setService(int i) {
        this.service = i;
    }

    public int getMethod() {
        return this.method;
    }

    public void setMethod(int i) {
        this.method = i;
    }

    public List<MsgHeader> getMsgHeaders() {
        return this.msgHeaders;
    }

    public void setMsgHeaders(List<MsgHeader> list) {
        this.msgHeaders = list;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public void setChannelId(int i) {
        this.channelId = i;
    }

    public String getPayloadEncoding() {
        return this.payloadEncoding;
    }

    public void setPayloadEncoding(String str) {
        this.payloadEncoding = str;
    }

    public String getPayloadType() {
        return this.payloadType;
    }

    public void setPayloadType(String str) {
        this.payloadType = str;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            this.payload = new byte[1];
        }
        return this.payload;
    }

    public void setPayload(byte[] bArr) {
        this.payload = bArr;
    }

    public ComponentName getReplayToComponentName() {
        return this.replayToComponentName;
    }

    public void setReplayToComponentName(ComponentName componentName) {
        this.replayToComponentName = componentName;
    }

    public NewMsgTimeHolder getNewMsgTimeHolder() {
        return this.newMsgTimeHolder;
    }

    public void setNewMsgTimeHolder(NewMsgTimeHolder newMsgTimeHolder) {
        this.newMsgTimeHolder = newMsgTimeHolder;
    }

    public String toString() {
        return "WsChannelMsg{, channelId = " + this.channelId + ", logId=" + this.logId + ", service=" + this.service + ", method=" + this.method + ", msgHeaders=" + this.msgHeaders + ", payloadEncoding='" + this.payloadEncoding + "', payloadType='" + this.payloadType + "', payload=" + Arrays.toString(this.payload) + ", replayToComponentName=" + this.replayToComponentName + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.seqId);
        parcel.writeLong(this.logId);
        parcel.writeInt(this.service);
        parcel.writeInt(this.method);
        parcel.writeTypedList(this.msgHeaders);
        parcel.writeString(this.payloadEncoding);
        parcel.writeString(this.payloadType);
        parcel.writeByteArray(this.payload);
        parcel.writeParcelable(this.replayToComponentName, i);
        parcel.writeInt(this.channelId);
        parcel.writeString(this.uuid);
        parcel.writeByte(this.isAckMsg ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.state.getTypeValue());
        parcel.writeParcelable(this.newMsgTimeHolder, i);
        parcel.writeString(this.logInfo);
        parcel.writeString(this.serverTiming);
        parcel.writeString(this.msgId);
    }

    /* loaded from: classes3.dex */
    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = new Parcelable.Creator<MsgHeader>() { // from class: com.bytedance.common.wschannel.model.WsChannelMsg.MsgHeader.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MsgHeader createFromParcel(Parcel parcel) {
                MsgHeader msgHeader = new MsgHeader();
                msgHeader.key = parcel.readString();
                msgHeader.value = parcel.readString();
                return msgHeader;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MsgHeader[] newArray(int i) {
                return new MsgHeader[i];
            }
        };
        String key;
        String value;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }

        public String toString() {
            return "MsgHeader{key='" + this.key + "', value='" + this.value + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.key);
            parcel.writeString(this.value);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private long logId;
        private final int mChannelId;
        private int method;
        private byte[] payload;
        private ComponentName replyComponentName;
        private long seqId;
        private int service;
        private Map<String, String> headers = new HashMap();
        private String payloadType = "";
        private String payloadEncoding = "";

        public Builder(int i) {
            this.mChannelId = i;
        }

        public static Builder create(int i) {
            return new Builder(i);
        }

        public Builder addMsgHeader(String str, String str2) {
            this.headers.put(str, str2);
            return this;
        }

        public Builder setLogId(long j) {
            this.logId = j;
            return this;
        }

        public Builder setService(int i) {
            this.service = i;
            return this;
        }

        public Builder setSeqId(long j) {
            this.seqId = j;
            return this;
        }

        public Builder setMethod(int i) {
            this.method = i;
            return this;
        }

        public Builder setPayload(byte[] bArr) {
            this.payload = bArr;
            return this;
        }

        public Builder setPayloadType(String str) {
            this.payloadType = str;
            return this;
        }

        public Builder setPayloadEncoding(String str) {
            this.payloadEncoding = str;
            return this;
        }

        public Builder setReplyComponentName(ComponentName componentName) {
            this.replyComponentName = componentName;
            return this;
        }

        public WsChannelMsg build() {
            if (this.mChannelId <= 0) {
                throw new IllegalArgumentException("illegal channelId");
            }
            if (this.service < 0) {
                throw new IllegalArgumentException("illegal service");
            }
            if (this.method <= 0) {
                throw new IllegalArgumentException("illegal method");
            }
            if (this.payload == null) {
                throw new IllegalArgumentException("illegal payload");
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                MsgHeader msgHeader = new MsgHeader();
                msgHeader.setKey(entry.getKey());
                msgHeader.setValue(entry.getValue());
                arrayList.add(msgHeader);
            }
            return new WsChannelMsg(this.mChannelId, this.seqId, this.logId, this.service, this.method, arrayList, this.payloadEncoding, this.payloadType, this.payload, this.replyComponentName);
        }
    }

    protected WsChannelMsg(Parcel parcel) {
        this.state = MessageAckEvent.MessageState.Default;
        this.seqId = parcel.readLong();
        this.logId = parcel.readLong();
        this.service = parcel.readInt();
        this.method = parcel.readInt();
        this.msgHeaders = parcel.createTypedArrayList(MsgHeader.CREATOR);
        this.payloadEncoding = parcel.readString();
        this.payloadType = parcel.readString();
        this.payload = parcel.createByteArray();
        this.replayToComponentName = (ComponentName) parcel.readParcelable(ComponentName.class.getClassLoader());
        this.channelId = parcel.readInt();
        this.uuid = parcel.readString();
        this.isAckMsg = parcel.readByte() != 0;
        this.state = MessageAckEvent.MessageState.valueOf(parcel.readInt());
        this.newMsgTimeHolder = (NewMsgTimeHolder) parcel.readParcelable(NewMsgTimeHolder.class.getClassLoader());
        this.logInfo = parcel.readString();
        this.serverTiming = parcel.readString();
        this.msgId = parcel.readString();
    }

    public Map<String, String> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("seqId", String.valueOf(this.seqId));
        linkedHashMap.put("logId", String.valueOf(this.logId));
        linkedHashMap.put("service", String.valueOf(this.service));
        linkedHashMap.put("method", String.valueOf(this.method));
        linkedHashMap.put("payloadEncoding", this.payloadEncoding);
        linkedHashMap.put("payloadType", this.payloadType);
        try {
            linkedHashMap.put(WsConstants.KEY_PAYLOAD_MD5, Utils.byte2HexStr(MessageDigest.getInstance("MD5").digest(this.payload), ""));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        linkedHashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, String.valueOf(this.channelId));
        for (MsgHeader msgHeader : this.msgHeaders) {
            linkedHashMap.put(msgHeader.key, msgHeader.value);
        }
        return linkedHashMap;
    }

    public void addHeader(String str, String str2) {
        MsgHeader msgHeader = new MsgHeader();
        msgHeader.setKey(str);
        msgHeader.setValue(str2);
        this.msgHeaders.add(msgHeader);
    }
}
