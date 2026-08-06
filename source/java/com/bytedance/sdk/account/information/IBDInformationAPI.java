package com.bytedance.sdk.account.information;

import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.information.method.RemainUpdateTimesResponse;
import com.bytedance.sdk.account.information.method.UploadPicResponse;
import com.bytedance.sdk.account.information.method.can_modify.CanModifyUserCallback;
import com.bytedance.sdk.account.information.method.check_default_info.CheckDefaultInfoCallback;
import com.bytedance.sdk.account.information.method.update_user_info.UpdateUserInfoCallback;
import com.bytedance.sdk.account.information.method.upload_avatar.UploadAvatarCallback;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBDInformationAPI {
    void canModifyUser(Set<String> set, CanModifyUserCallback canModifyUserCallback);

    void checkDefaultInfo(int i, CheckDefaultInfoCallback checkDefaultInfoCallback);

    void checkDefaultInfo(int i, Map<String, String> map, CheckDefaultInfoCallback checkDefaultInfoCallback);

    void getRemainUpdateTimes(String str, String str2, Map<String, String> map, CommonCallBack<RemainUpdateTimesResponse> commonCallBack);

    void updateUserInfo(Map<String, String> map, JSONObject jSONObject, UpdateUserInfoCallback updateUserInfoCallback);

    void updateUserInfo(Map<String, String> map, JSONObject jSONObject, boolean z, UpdateUserInfoCallback updateUserInfoCallback);

    void updateUserInfo(Map<String, String> map, JSONObject jSONObject, String[] strArr, UpdateUserInfoCallback updateUserInfoCallback);

    void uploadAvatar(String str, UploadAvatarCallback uploadAvatarCallback);

    void uploadPic(boolean z, String str, Map<String, String> map, CommonCallBack<UploadPicResponse> commonCallBack);
}
