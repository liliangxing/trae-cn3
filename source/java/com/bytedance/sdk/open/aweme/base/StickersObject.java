package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.base.openentity.CustomSticker;
import com.bytedance.sdk.open.aweme.base.openentity.HashtagSticker;
import com.bytedance.sdk.open.aweme.base.openentity.MentionSticker;
import com.bytedance.sdk.open.aweme.base.openentity.PoiSticker;
import com.bytedance.sdk.open.aweme.base.openentity.QuickFlashSticker;
import com.bytedance.sdk.open.aweme.base.openentity.Sticker;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class StickersObject {
    private static final String TAG = "StickersObject";
    private ArrayList<CustomSticker> customStickers;
    private ArrayList<HashtagSticker> hashtagStickers;
    private ArrayList<MentionSticker> mentionStickers;
    private PoiSticker poiSticker;
    private QuickFlashSticker quickFlashSticker;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.aweme.base.StickersObject$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0094a extends TypeToken<List<MentionSticker>> {
        C0094a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.aweme.base.StickersObject$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0095b extends TypeToken<List<HashtagSticker>> {
        C0095b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.aweme.base.StickersObject$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0096c extends TypeToken<List<CustomSticker>> {
        C0096c() {
        }
    }

    public static StickersObject unSerialize(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StickersObject stickersObject = new StickersObject();
        Gson gson = new Gson();
        String string = bundle.getString(ParamKeyConstants.ShareParams.SHARE_MENTION_STICKER_LIST);
        if (!TextUtils.isEmpty(string)) {
            try {
                stickersObject.mentionStickers = (ArrayList) gson.fromJson(string, new C0094a().getType());
            } catch (JsonSyntaxException e) {
                LogUtils.m30w(TAG, e.getMessage());
            }
        }
        String string2 = bundle.getString(ParamKeyConstants.ShareParams.SHARE_HASHTAG_STICKER_LIST);
        if (!TextUtils.isEmpty(string2)) {
            try {
                stickersObject.hashtagStickers = (ArrayList) gson.fromJson(string2, new C0095b().getType());
            } catch (JsonSyntaxException e2) {
                LogUtils.m30w(TAG, e2.getMessage());
            }
        }
        String string3 = bundle.getString(ParamKeyConstants.ShareParams.SHARE_CUSTOM_STICKER_LIST);
        if (!TextUtils.isEmpty(string3)) {
            try {
                stickersObject.customStickers = (ArrayList) gson.fromJson(string3, new C0096c().getType());
            } catch (JsonSyntaxException e3) {
                LogUtils.m30w(TAG, e3.getMessage());
            }
        }
        String string4 = bundle.getString(ParamKeyConstants.ShareParams.SHARE_POI_STICKER);
        if (!TextUtils.isEmpty(string4)) {
            try {
                stickersObject.poiSticker = (PoiSticker) gson.fromJson(string4, PoiSticker.class);
            } catch (Exception unused) {
            }
        }
        String string5 = bundle.getString(ParamKeyConstants.ShareParams.SHARE_QUICK_FLASH_STICKER);
        if (!TextUtils.isEmpty(string5)) {
            try {
                stickersObject.quickFlashSticker = (QuickFlashSticker) gson.fromJson(string5, QuickFlashSticker.class);
            } catch (Exception unused2) {
            }
        }
        return stickersObject;
    }

    public boolean addSticker(Sticker sticker) {
        ArrayList arrayList;
        Sticker sticker2;
        if (sticker == null || !sticker.checkArg()) {
            return false;
        }
        if (sticker instanceof HashtagSticker) {
            if (this.hashtagStickers == null) {
                this.hashtagStickers = new ArrayList<>();
            }
            arrayList = this.hashtagStickers;
            sticker2 = (HashtagSticker) sticker;
        } else if (sticker instanceof MentionSticker) {
            if (this.mentionStickers == null) {
                this.mentionStickers = new ArrayList<>();
            }
            arrayList = this.mentionStickers;
            sticker2 = (MentionSticker) sticker;
        } else {
            if (!(sticker instanceof CustomSticker)) {
                if (sticker instanceof PoiSticker) {
                    this.poiSticker = (PoiSticker) sticker;
                    return true;
                }
                if (!(sticker instanceof QuickFlashSticker)) {
                    return false;
                }
                this.quickFlashSticker = (QuickFlashSticker) sticker;
                return true;
            }
            if (this.customStickers == null) {
                this.customStickers = new ArrayList<>();
            }
            arrayList = this.customStickers;
            sticker2 = (CustomSticker) sticker;
        }
        return arrayList.add(sticker2);
    }

    public void serialize(Bundle bundle) {
        Gson gson = new Gson();
        ArrayList<HashtagSticker> arrayList = this.hashtagStickers;
        if (arrayList != null && !arrayList.isEmpty()) {
            bundle.putString(ParamKeyConstants.ShareParams.SHARE_HASHTAG_STICKER_LIST, gson.toJson(this.hashtagStickers));
        }
        ArrayList<MentionSticker> arrayList2 = this.mentionStickers;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            bundle.putString(ParamKeyConstants.ShareParams.SHARE_MENTION_STICKER_LIST, gson.toJson(this.mentionStickers));
        }
        ArrayList<CustomSticker> arrayList3 = this.customStickers;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            bundle.putString(ParamKeyConstants.ShareParams.SHARE_CUSTOM_STICKER_LIST, gson.toJson(this.customStickers));
        }
        PoiSticker poiSticker = this.poiSticker;
        if (poiSticker != null) {
            bundle.putString(ParamKeyConstants.ShareParams.SHARE_POI_STICKER, gson.toJson(poiSticker));
        }
        QuickFlashSticker quickFlashSticker = this.quickFlashSticker;
        if (quickFlashSticker != null) {
            bundle.putString(ParamKeyConstants.ShareParams.SHARE_QUICK_FLASH_STICKER, gson.toJson(quickFlashSticker));
        }
    }
}
