package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class WsComponent implements Parcelable {
    public static final Parcelable.Creator<WsComponent> CREATOR = new Parcelable.Creator<WsComponent>() { // from class: com.bytedance.common.wschannel.model.WsComponent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WsComponent createFromParcel(Parcel parcel) {
            WsComponent wsComponent = new WsComponent();
            wsComponent.componentName = (ComponentName) parcel.readParcelable(getClass().getClassLoader());
            wsComponent.acceptApis = parcel.createTypedArrayList(WsApi.CREATOR);
            return wsComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WsComponent[] newArray(int i) {
            return new WsComponent[i];
        }
    };
    List<WsApi> acceptApis;
    ComponentName componentName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ComponentName getComponentName() {
        return this.componentName;
    }

    public void setComponentName(ComponentName componentName) {
        this.componentName = componentName;
    }

    public List<WsApi> getAcceptApis() {
        return this.acceptApis;
    }

    public void setAcceptApis(List<WsApi> list) {
        this.acceptApis = list;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ComponentName componentName = this.componentName;
        if (componentName != null) {
            jSONObject.put("package_name", componentName.getPackageName());
            jSONObject.put("class_name", this.componentName.getClassName());
        }
        List<WsApi> list = this.acceptApis;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<WsApi> it = this.acceptApis.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            jSONObject.put("accept_services", jSONArray);
        }
        return jSONObject;
    }

    public void parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("package_name");
        String optString2 = jSONObject.optString("class_name");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            this.componentName = new ComponentName(optString, optString2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("accept_services");
        if (optJSONArray != null) {
            this.acceptApis = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                WsApi wsApi = new WsApi();
                wsApi.parseFromJson(optJSONArray.optJSONObject(i));
                this.acceptApis.add(wsApi);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.componentName, i);
        parcel.writeTypedList(this.acceptApis);
    }
}
