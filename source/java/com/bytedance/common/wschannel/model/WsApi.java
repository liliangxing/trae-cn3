package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class WsApi implements Parcelable {
    public static final Parcelable.Creator<WsApi> CREATOR = new Parcelable.Creator<WsApi>() { // from class: com.bytedance.common.wschannel.model.WsApi.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WsApi createFromParcel(Parcel parcel) {
            WsApi wsApi = new WsApi();
            wsApi.service = parcel.readInt();
            wsApi.method = parcel.readInt();
            return wsApi;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WsApi[] newArray(int i) {
            return new WsApi[i];
        }
    };
    int method;
    int service;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("service", this.service);
        jSONObject.put("method", this.method);
        return jSONObject;
    }

    public void parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.service = jSONObject.optInt("service");
        this.method = jSONObject.optInt("method");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.service);
        parcel.writeInt(this.method);
    }
}
