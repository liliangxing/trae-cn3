package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.SensitiveUtils;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LocaleLoader extends BaseLoader {
    private final Context mApp;
    private final InstallOptions mOptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleLoader(Context context, InstallOptions installOptions) {
        super(true, true);
        this.mApp = context;
        this.mOptions = installOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_LANGUAGE, this.mApp.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put(Api.KEY_TIMEZONE, rawOffset);
        Utils.putStringIfNotEmpty(jSONObject, "region", SensitiveUtils.getCountry(this.mOptions));
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        Utils.putStringIfNotEmpty(jSONObject, Api.KEY_TZ_NAME, timeZone.getID());
        jSONObject.put(Api.KEY_TZ_OFFSET, timeZone.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }
}
