package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.base.openentity.HashtagTitleMarker;
import com.bytedance.sdk.open.aweme.base.openentity.MentionTitleMarker;
import com.bytedance.sdk.open.aweme.base.openentity.PublishTitleMarker;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TitleObject {
    private static final String TAG = "TitleObject";
    private ArrayList<HashtagTitleMarker> hashtagTitleMarkers;
    private ArrayList<MentionTitleMarker> mentionTitleMarkers;
    public String title;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.aweme.base.TitleObject$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0097a extends TypeToken<List<MentionTitleMarker>> {
        C0097a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.open.aweme.base.TitleObject$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0098b extends TypeToken<List<HashtagTitleMarker>> {
        C0098b() {
        }
    }

    public static TitleObject unSerialize(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        TitleObject titleObject = new TitleObject();
        titleObject.title = bundle.getString(ParamKeyConstants.ShareParams.SHARE_TITLE);
        Gson gson = new Gson();
        String string = bundle.getString(ParamKeyConstants.ShareParams.SHARE_TITLE_MENTION_LIST);
        if (!TextUtils.isEmpty(string)) {
            try {
                titleObject.mentionTitleMarkers = (ArrayList) gson.fromJson(string, new C0097a().getType());
            } catch (JsonSyntaxException e) {
                LogUtils.m30w(TAG, e.getMessage());
            }
        }
        String string2 = bundle.getString(ParamKeyConstants.ShareParams.SHARE_TITLE_HASHTAG_LIST);
        if (!TextUtils.isEmpty(string2)) {
            try {
                titleObject.hashtagTitleMarkers = (ArrayList) gson.fromJson(string2, new C0098b().getType());
            } catch (JsonSyntaxException e2) {
                LogUtils.m30w(TAG, e2.getMessage());
            }
        }
        return titleObject;
    }

    public boolean addMarker(PublishTitleMarker publishTitleMarker) {
        ArrayList arrayList;
        PublishTitleMarker publishTitleMarker2;
        if (publishTitleMarker == null || !publishTitleMarker.checkArgs()) {
            return false;
        }
        if (publishTitleMarker instanceof HashtagTitleMarker) {
            if (this.hashtagTitleMarkers == null) {
                this.hashtagTitleMarkers = new ArrayList<>();
            }
            arrayList = this.hashtagTitleMarkers;
            publishTitleMarker2 = (HashtagTitleMarker) publishTitleMarker;
        } else {
            if (!(publishTitleMarker instanceof MentionTitleMarker)) {
                return false;
            }
            if (this.mentionTitleMarkers == null) {
                this.mentionTitleMarkers = new ArrayList<>();
            }
            arrayList = this.mentionTitleMarkers;
            publishTitleMarker2 = (MentionTitleMarker) publishTitleMarker;
        }
        return arrayList.add(publishTitleMarker2);
    }

    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_TITLE, this.title);
        Gson gson = new Gson();
        ArrayList<HashtagTitleMarker> arrayList = this.hashtagTitleMarkers;
        if (arrayList != null && !arrayList.isEmpty()) {
            bundle.putString(ParamKeyConstants.ShareParams.SHARE_TITLE_HASHTAG_LIST, gson.toJson(this.hashtagTitleMarkers));
        }
        ArrayList<MentionTitleMarker> arrayList2 = this.mentionTitleMarkers;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        bundle.putString(ParamKeyConstants.ShareParams.SHARE_TITLE_MENTION_LIST, gson.toJson(this.mentionTitleMarkers));
    }
}
