package com.bytedance.sdk.account.information;

import android.content.Context;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.information.method.RemainUpdateTimesJob;
import com.bytedance.sdk.account.information.method.RemainUpdateTimesResponse;
import com.bytedance.sdk.account.information.method.UploadPicJob;
import com.bytedance.sdk.account.information.method.UploadPicResponse;
import com.bytedance.sdk.account.information.method.can_modify.CanModifyUserCallback;
import com.bytedance.sdk.account.information.method.can_modify.CanModifyUserJob;
import com.bytedance.sdk.account.information.method.check_default_info.CheckDefaultInfoCallback;
import com.bytedance.sdk.account.information.method.check_default_info.CheckDefaultInfoJob;
import com.bytedance.sdk.account.information.method.update_user_info.UpdateUserInfoCallback;
import com.bytedance.sdk.account.information.method.update_user_info.UpdateUserInfoJob;
import com.bytedance.sdk.account.information.method.upload_avatar.UploadAvatarCallback;
import com.bytedance.sdk.account.information.method.upload_avatar.UploadAvatarJob;
import com.ss.android.account.TTAccountInit;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDInformationAPIImpl implements IBDInformationAPI {
    private static volatile IBDInformationAPI sInstance;
    private Context mContext = TTAccountInit.getConfig().getApplicationContext();

    private BDInformationAPIImpl() {
    }

    public static IBDInformationAPI instance() {
        if (sInstance == null) {
            synchronized (BDInformationAPIImpl.class) {
                if (sInstance == null) {
                    sInstance = new BDInformationAPIImpl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.information.IBDInformationAPI
    public void canModifyUser(Set<String> set, CanModifyUserCallback canModifyUserCallback) {
        CanModifyUserJob.canModifyUser(this.mContext, set, canModifyUserCallback).start();
    }

    @Override // com.bytedance.sdk.account.information.IBDInformationAPI
    public void uploadAvatar(String str, UploadAvatarCallback uploadAvatarCallback) {
        UploadAvatarJob.uploadAvatar(this.mContext, str, uploadAvatarCallback).start();
    }

    @Override // com.bytedance.sdk.account.information.IBDInformationAPI
    public void uploadPic(boolean z, String str, Map<String, String> map, CommonCallBack<UploadPicResponse> commonCallBack) {
        UploadPicJob.uploadPic(this.mContext, z, str, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.information.IBDInformationAPI
    public void updateUserInfo(Map<String, String> map, JSONObject jSONObject, UpdateUserInfoCallback updateUserInfoCallback) {
        updateUserInfo(map, jSONObject, false, updateUserInfoCallback);
    }

    @Override // com.bytedance.sdk.account.information.IBDInformationAPI
    public void updateUserInfo(Map<String, String> map, JSONObject jSONObject, String[] strArr, UpdateUserInfoCallback updateUserInfoCallback) {
        UpdateUserInfoJob.updateUserInfo(this.mContext, map, jSONObject, strArr, false, updateUserInfoCallback).start();
    }

    @Override // com.bytedance.sdk.account.information.IBDInformationAPI
    public void updateUserInfo(Map<String, String> map, JSONObject jSONObject, boolean z, UpdateUserInfoCallback updateUserInfoCallback) {
        UpdateUserInfoJob.updateUserInfo(this.mContext, map, jSONObject, null, z, updateUserInfoCallback).start();
    }

    @Override // com.bytedance.sdk.account.information.IBDInformationAPI
    public void checkDefaultInfo(int i, CheckDefaultInfoCallback checkDefaultInfoCallback) {
        checkDefaultInfo(i, null, checkDefaultInfoCallback);
    }

    @Override // com.bytedance.sdk.account.information.IBDInformationAPI
    public void checkDefaultInfo(int i, Map<String, String> map, CheckDefaultInfoCallback checkDefaultInfoCallback) {
        CheckDefaultInfoJob.checkDefaultInfo(this.mContext, i, map, checkDefaultInfoCallback).start();
    }

    @Override // com.bytedance.sdk.account.information.IBDInformationAPI
    public void getRemainUpdateTimes(String str, String str2, Map<String, String> map, CommonCallBack<RemainUpdateTimesResponse> commonCallBack) {
        RemainUpdateTimesJob.getRemainUpdateTimes(this.mContext, str, str2, map, commonCallBack).start();
    }
}
