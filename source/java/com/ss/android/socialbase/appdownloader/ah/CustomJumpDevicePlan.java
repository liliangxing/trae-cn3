package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class CustomJumpDevicePlan extends AbsDevicePlan {
    private final JSONObject mAntiConfig;

    public CustomJumpDevicePlan(Context context, DownloadSetting downloadSetting, String str, JSONObject jSONObject) {
        super(context, downloadSetting, str);
        this.mAntiConfig = jSONObject;
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String optString = this.mAntiConfig.optString(StrategyConstants.ACTION);
        String optString2 = this.mAntiConfig.optString("category");
        int optInt = this.mAntiConfig.optInt(RouterConstants.QUERY_KEY_FLAGS, 1342210048);
        String optString3 = this.mAntiConfig.optString("path_extra_key");
        String optString4 = this.mAntiConfig.optString("path_data_key");
        JSONObject optJSONObject = this.mAntiConfig.optJSONObject("extra");
        JSONObject optJSONObject2 = this.mAntiConfig.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, this.mJumpPath)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.mJumpPath);
        }
        putExtra(intent, optJSONObject, optJSONObject2);
        return intent;
    }

    private static void putExtra(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject2.optString(next);
            if (optString != null) {
                parseValueAndPut(jSONObject, next, optString, intent);
            }
        }
    }

    private static void parseValueAndPut(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1325958191:
                if (str2.equals("double")) {
                    c = 0;
                    break;
                }
                break;
            case -891985903:
                if (str2.equals("string")) {
                    c = 1;
                    break;
                }
                break;
            case 104431:
                if (str2.equals("int")) {
                    c = 2;
                    break;
                }
                break;
            case 3327612:
                if (str2.equals("long")) {
                    c = 3;
                    break;
                }
                break;
            case 64711720:
                if (str2.equals("boolean")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                intent.putExtra(str, jSONObject.optDouble(str));
                return;
            case 1:
                intent.putExtra(str, jSONObject.optString(str));
                return;
            case 2:
                intent.putExtra(str, jSONObject.optInt(str));
                return;
            case 3:
                intent.putExtra(str, jSONObject.optLong(str));
                return;
            case 4:
                intent.putExtra(str, jSONObject.optBoolean(str));
                return;
            default:
                return;
        }
    }
}
