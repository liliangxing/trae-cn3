package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* loaded from: classes5.dex */
public class ShareParam {
    private static final float DAILY_SCALE_NORMAL = 0.58f;
    public MusicParamObject musicParamObject;
    public String poiId;
    public String shareDailyBGUrl;
    public String shareDailyH5Path;
    public StickersObject stickersObject;
    public TitleObject titleObject;
    public int shareDailyBGBaseColor = 0;
    public int shareDailyBGComplementaryColor = 0;
    public float dailyScale = DAILY_SCALE_NORMAL;

    public static ShareParam unserialize(Bundle bundle) {
        ShareParam shareParam = new ShareParam();
        shareParam.stickersObject = StickersObject.unSerialize(bundle);
        shareParam.titleObject = TitleObject.unSerialize(bundle);
        shareParam.musicParamObject = MusicParamObject.unSerialize(bundle);
        shareParam.shareDailyH5Path = bundle.getString(ParamKeyConstants.ShareParams.SHARE_DAILY_H5_PATH);
        shareParam.shareDailyBGUrl = bundle.getString(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_URL);
        shareParam.shareDailyBGBaseColor = bundle.getInt(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_BASE_COLOR, 0);
        shareParam.shareDailyBGComplementaryColor = bundle.getInt(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_COMPLEMENTARY_COLOR, 0);
        shareParam.poiId = bundle.getString(ParamKeyConstants.ShareParams.SHARE_POI_ID);
        shareParam.dailyScale = bundle.getFloat(ParamKeyConstants.ShareParams.SHARE_DAILY_SCALE, DAILY_SCALE_NORMAL);
        return shareParam;
    }

    public void serialize(Bundle bundle) {
        StickersObject stickersObject = this.stickersObject;
        if (stickersObject != null) {
            stickersObject.serialize(bundle);
        }
        TitleObject titleObject = this.titleObject;
        if (titleObject != null) {
            titleObject.serialize(bundle);
        }
        MusicParamObject musicParamObject = this.musicParamObject;
        if (musicParamObject != null) {
            musicParamObject.serialize(bundle);
        }
        String str = this.shareDailyH5Path;
        if (str != null) {
            bundle.putString(ParamKeyConstants.ShareParams.SHARE_DAILY_H5_PATH, str);
        }
        String str2 = this.shareDailyBGUrl;
        if (str2 != null) {
            bundle.putString(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_URL, str2);
        }
        bundle.putInt(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_BASE_COLOR, this.shareDailyBGBaseColor);
        bundle.putInt(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_COMPLEMENTARY_COLOR, this.shareDailyBGComplementaryColor);
        if (!TextUtils.isEmpty(this.poiId)) {
            bundle.putString(ParamKeyConstants.ShareParams.SHARE_POI_ID, this.poiId);
        }
        bundle.putFloat(ParamKeyConstants.ShareParams.SHARE_DAILY_SCALE, this.dailyScale);
    }
}
