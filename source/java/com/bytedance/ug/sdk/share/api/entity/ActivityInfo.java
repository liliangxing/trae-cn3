package com.bytedance.ug.sdk.share.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class ActivityInfo implements Serializable {

    @SerializedName("act_id")
    private String mActId;

    @SerializedName("client_pop_type")
    private String mClientPopType;

    @SerializedName("domain_id")
    private String mDomainId;

    @SerializedName("id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("template_id")
    private String mTemplateId;

    public String getDomainId() {
        return this.mDomainId;
    }

    public String getTemplateId() {
        return this.mTemplateId;
    }

    public String getClientPopType() {
        return this.mClientPopType;
    }

    public void setDomainId(String str) {
        this.mDomainId = str;
    }

    public void setTemplateId(String str) {
        this.mTemplateId = str;
    }

    public void setClientPopType(String str) {
        this.mClientPopType = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getActId() {
        return this.mActId;
    }

    public void setActId(String str) {
        this.mActId = str;
    }
}
