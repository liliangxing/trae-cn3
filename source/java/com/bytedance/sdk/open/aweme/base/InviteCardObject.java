package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.tt.InterfaceC0136b;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InviteCardObject {
    public static int DirectInvitation = 1;
    public static int NormalInvitation = 0;
    public static final int ROOM_STATE_END = 99;
    public static final int ROOM_STATE_FULL = 10;
    public static final int ROOM_STATE_TEAMING = 1;
    private static final String TAG = "InviteCardObject";
    private static final List<Integer> VALID_STATE = Arrays.asList(99, 10, 1);

    @SerializedName(Constant.KEY_APP_ID)
    public int appId;

    @SerializedName("cover_img")
    public String coverImg;

    @SerializedName("download_schema")
    public String downloadSchema;

    @SerializedName("download_title_hint")
    public String downloadTitleHint;

    @SerializedName("extra")
    public String extra;

    @SerializedName("game_name")
    public String gameName;

    @SerializedName("im_card_data")
    public String imCardData;

    @SerializedName("invitee_open_id")
    public String inviteeOpenId;

    @SerializedName("link_id")
    public String linkId;

    @SerializedName("room_cur_num")
    public int roomCurNum;

    @SerializedName("room_id")
    public String roomId;

    @SerializedName("room_info")
    public String roomInfo;

    @SerializedName("room_state")
    public int roomState;

    @SerializedName("room_total_num")
    public int roomTotalNum;

    @SerializedName("room_type")
    public String roomType;

    @SerializedName("schema")
    public String schema;

    @SerializedName("title_hint")
    public String titleHint;

    @SerializedName("user_name")
    public String userName;

    @SerializedName("user_open_id")
    public String userOpenId;

    @SerializedName("user_rank")
    public String userRank;

    @SerializedName("user_tag")
    public String userTag;

    @SerializedName("invite_type")
    public int inviteType = NormalInvitation;

    @SerializedName("share_version")
    public int shareVersion = 1;

    public static InviteCardObject unserialize(Bundle bundle) {
        String string = bundle.getString(InterfaceC0136b.a.f206f, "");
        if (string == null) {
            return null;
        }
        try {
            return (InviteCardObject) new Gson().fromJson(string, InviteCardObject.class);
        } catch (Exception e) {
            LogUtils.m30w(TAG, "", e);
            return null;
        }
    }

    public final boolean checkArgs() {
        String str = this.imCardData;
        if (str == null || str.isEmpty()) {
            LogUtils.m30w(TAG, "imCardData is invalid");
            return false;
        }
        int i = this.inviteType;
        if (i != DirectInvitation && i != NormalInvitation) {
            LogUtils.m30w(TAG, "inviteType is invalid");
            return false;
        }
        if (TextUtils.isEmpty(this.userOpenId)) {
            LogUtils.m27d(TAG, "open_id is empty");
            return false;
        }
        if (this.inviteType != DirectInvitation || !TextUtils.isEmpty(this.inviteeOpenId)) {
            return true;
        }
        LogUtils.m27d(TAG, "The direct invitation requires the open_id of the invitee");
        return false;
    }

    public final void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putSerializable(InterfaceC0136b.a.f206f, new Gson().toJson(this));
    }
}
