package com.bytedance.bdinstall.loader;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.util.RomUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class RomLoader extends BaseLoader {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RomLoader() {
        super(true, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder(16);
        if (RomUtils.isMiui()) {
            sb.append("MIUI-");
        } else if (RomUtils.isFlyme()) {
            sb.append("FLYME-");
        } else {
            String emuiInfo = RomUtils.getEmuiInfo();
            if (RomUtils.isHwOrHonor(emuiInfo)) {
                sb.append("EMUI-");
                if (!TextUtils.isEmpty(emuiInfo)) {
                    sb.append(emuiInfo).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put(Api.KEY_ROM, sb.toString());
        String romInfo = RomUtils.getRomInfo();
        if (TextUtils.isEmpty(romInfo)) {
            return true;
        }
        jSONObject.put("rom_version", romInfo);
        return true;
    }
}
