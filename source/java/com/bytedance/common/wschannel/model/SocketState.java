package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ChannelType;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SocketState implements Parcelable {
    public static final Parcelable.Creator<SocketState> CREATOR = new Parcelable.Creator<SocketState>() { // from class: com.bytedance.common.wschannel.model.SocketState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SocketState createFromParcel(Parcel parcel) {
            return new SocketState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SocketState[] newArray(int i) {
            return new SocketState[i];
        }
    };
    public int channelId;
    public int channelType;
    public int connectionState;
    public int connectionType;
    public String connectionUrl;
    public String error;

    @Deprecated
    public int errorCode;
    private boolean privateProtocolEnabled;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SocketState() {
    }

    public static SocketState fromJson(JSONObject jSONObject) {
        SocketState socketState = new SocketState();
        socketState.channelId = jSONObject.optInt(WsConstants.KEY_CHANNEL_ID, Integer.MIN_VALUE);
        socketState.connectionType = jSONObject.optInt("type", -1);
        socketState.connectionState = jSONObject.optInt("state", -1);
        socketState.connectionUrl = jSONObject.optString("url", "");
        socketState.channelType = jSONObject.optInt(WsConstants.KEY_CHANNEL_TYPE);
        socketState.error = jSONObject.optString("error", "");
        socketState.errorCode = jSONObject.optInt("error_code");
        socketState.privateProtocolEnabled = jSONObject.optInt(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 0) > 0;
        return socketState;
    }

    public String toString() {
        return "SocketState{connectionType=" + this.connectionType + ", connectionState=" + this.connectionState + ", connectionUrl='" + this.connectionUrl + "', channelId=" + this.channelId + ", channelType=" + this.channelType + ", error='" + this.error + "', privateProtocol=" + this.privateProtocolEnabled + "'}";
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public void setConnectionType(int i) {
        this.connectionType = i;
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public void setConnectionState(int i) {
        this.connectionState = i;
    }

    public String getConnectionUrl() {
        return this.connectionUrl;
    }

    public void setConnectionUrl(String str) {
        this.connectionUrl = str;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public void setChannelId(int i) {
        this.channelId = i;
    }

    public boolean isPrivateProtocolEnabled() {
        return this.privateProtocolEnabled;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WsConstants.KEY_CHANNEL_ID, this.channelId);
            jSONObject.put("type", this.connectionType);
            jSONObject.put("state", this.connectionState);
            jSONObject.put("url", this.connectionUrl);
            jSONObject.put(WsConstants.KEY_CHANNEL_TYPE, this.channelType);
            jSONObject.put("error", this.error);
            jSONObject.put("error_code", this.errorCode);
            jSONObject.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, this.privateProtocolEnabled ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public ChannelType getChannelType() {
        return ChannelType.of(this.channelType);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.connectionType);
        parcel.writeInt(this.connectionState);
        parcel.writeString(this.connectionUrl);
        parcel.writeInt(this.channelId);
        parcel.writeInt(this.channelType);
        parcel.writeString(this.error);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.privateProtocolEnabled ? 1 : 0);
    }

    protected SocketState(Parcel parcel) {
        this.connectionType = parcel.readInt();
        this.connectionState = parcel.readInt();
        this.connectionUrl = parcel.readString();
        this.channelId = parcel.readInt();
        this.channelType = parcel.readInt();
        this.error = parcel.readString();
        this.errorCode = parcel.readInt();
        this.privateProtocolEnabled = parcel.readInt() > 0;
    }
}
