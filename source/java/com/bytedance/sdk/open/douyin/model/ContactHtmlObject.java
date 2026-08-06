package com.bytedance.sdk.open.douyin.model;

import android.os.Bundle;
import com.bytedance.sdk.open.tt.InterfaceC0136b;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ContactHtmlObject {

    @SerializedName("discription")
    private String mDiscription;

    @SerializedName("html")
    private String mHtml;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("thumburl")
    private String thumbUrl;

    public static ContactHtmlObject unserialize(Bundle bundle) {
        String string = bundle.getString(InterfaceC0136b.a.f202b, "");
        if (string == null) {
            return null;
        }
        try {
            return (ContactHtmlObject) new Gson().fromJson(string, ContactHtmlObject.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getDiscription() {
        return this.mDiscription;
    }

    public String getHtml() {
        return this.mHtml;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putSerializable(InterfaceC0136b.a.f202b, new Gson().toJson(this));
    }

    public void setDiscription(String str) {
        this.mDiscription = str;
    }

    public void setHtml(String str) {
        this.mHtml = str;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}
