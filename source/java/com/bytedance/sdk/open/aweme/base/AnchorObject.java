package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class AnchorObject {

    @SerializedName("anchor_icon")
    UrlModel anchorIcon;

    @SerializedName("anchor_business_type")
    int mAnchorBusinessType;

    @SerializedName("anchor_content")
    String mAnchorContent;

    @SerializedName("anchor_title")
    String mAnchorTitle;

    public static AnchorObject unserialize(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(ParamKeyConstants.ShareParams.SHARE_ANCHOR_INFO);
        try {
            if (!TextUtils.isEmpty(string)) {
                return (AnchorObject) new Gson().fromJson(string, AnchorObject.class);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getAnchorBusinessType() {
        return this.mAnchorBusinessType;
    }

    public String getAnchorContent() {
        return this.mAnchorContent;
    }

    public String getAnchorIconUrl() {
        List<String> list;
        UrlModel urlModel = this.anchorIcon;
        if (urlModel == null || (list = urlModel.urlList) == null || list.isEmpty()) {
            return null;
        }
        return this.anchorIcon.urlList.get(0);
    }

    public String getAnchorTitle() {
        return this.mAnchorTitle;
    }

    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_ANCHOR_INFO, new Gson().toJson(this));
    }

    public void setAnchorBusinessType(int i) {
        this.mAnchorBusinessType = i;
    }

    public void setAnchorContent(String str) {
        this.mAnchorContent = str;
    }

    public void setAnchorIconUrl(String str) {
        UrlModel urlModel = new UrlModel();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        urlModel.urlList = arrayList;
        this.anchorIcon = urlModel;
    }

    public void setAnchorTitle(String str) {
        this.mAnchorTitle = str;
    }
}
