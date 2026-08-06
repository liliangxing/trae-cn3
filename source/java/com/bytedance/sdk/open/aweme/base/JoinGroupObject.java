package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.tt.InterfaceC0136b;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class JoinGroupObject {
    private static final String TAG = "JoinGroupObject";

    @SerializedName(Constant.KEY_APP_ID)
    public int appId;

    @SerializedName("group_id")
    public String groupId;

    @SerializedName("group_type")
    public int groupType;

    @SerializedName(DBData.FIELD_TYPE)
    public int type;

    @SerializedName("user_open_id")
    public String userOpenId;

    public static JoinGroupObject unserialize(Bundle bundle) {
        String string = bundle.getString(InterfaceC0136b.a.f207g, "");
        if (string == null) {
            return null;
        }
        try {
            return (JoinGroupObject) new Gson().fromJson(string, JoinGroupObject.class);
        } catch (Exception e) {
            LogUtils.m30w(TAG, "", e);
            return null;
        }
    }

    public final void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putSerializable(InterfaceC0136b.a.f207g, new Gson().toJson(this));
    }
}
