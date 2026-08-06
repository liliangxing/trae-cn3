package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class JumpUtils {
    public static boolean jumpProductionManager(Activity activity, String str, String str2, String str3, String str4) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            DouYinOpenApi create = AbstractC0113a.create(activity);
            if (create != null && create.isSupportCommonAbility(3)) {
                CommonAbility.Request request = new CommonAbility.Request();
                request.commonType = 3;
                request.mState = "jump_producation_from_sdk";
                request.callerLocalEntry = str3;
                Bundle bundle = new Bundle();
                bundle.putString("launch_method", str2);
                bundle.putString("show_card_type", str4);
                request.extras = bundle;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from_open_id", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                request.data = jSONObject.toString();
                return create.openCommon(request);
            }
            Toast.makeText(activity, "当前抖音版本过低，请将抖音更新到最新版本", 0).show();
        }
        return false;
    }

    public static boolean jumpToDouyinIM(Activity activity, String str, String str2, String str3, String str4) {
        if (activity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            DouYinOpenApi create = AbstractC0113a.create(activity);
            if (create != null && create.isSupportCommonAbility(2)) {
                CommonAbility.Request request = new CommonAbility.Request();
                request.commonType = 2;
                request.mState = "jump_im_from_sdk";
                request.callerLocalEntry = str4;
                Bundle bundle = new Bundle();
                bundle.putString("launch_method", str3);
                request.extras = bundle;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from_open_id", str);
                    jSONObject.put("target_open_id", str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                request.data = jSONObject.toString();
                return create.openCommon(request);
            }
            Toast.makeText(activity, "当前抖音版本过低，请将抖音更新到最新版本", 0).show();
        }
        return false;
    }

    public static boolean jumpToDouyinProfile(Activity activity, String str, String str2, String str3, String str4) {
        if (activity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            DouYinOpenApi create = AbstractC0113a.create(activity);
            if (create != null && create.isSupportCommonAbility(1)) {
                CommonAbility.Request request = new CommonAbility.Request();
                request.commonType = 1;
                request.mState = "jump_profile_from_sdk";
                request.callerLocalEntry = str4;
                Bundle bundle = new Bundle();
                bundle.putString("launch_method", str3);
                request.extras = bundle;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from_open_id", str);
                    jSONObject.put("target_open_id", str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                request.data = jSONObject.toString();
                return create.openCommon(request);
            }
            Toast.makeText(activity, "当前抖音版本过低，请将抖音更新到最新版本", 0).show();
        }
        return false;
    }
}
