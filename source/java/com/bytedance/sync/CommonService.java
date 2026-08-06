package com.bytedance.sync;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.sync.interfaze.ICommonService;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.ss.android.ug.bus.UgBusFramework;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class CommonService implements ICommonService {
    private final Configuration mConfiguration = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
    private final Context mContext;

    @Override // com.bytedance.sync.interfaze.ICommonService
    public void onNonMainEvent(String str, JSONObject jSONObject) {
    }

    public CommonService(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.sync.interfaze.ICommonService
    public boolean isNetWorkAvailable(Context context) {
        Configuration configuration = this.mConfiguration;
        if (configuration != null && configuration.commonService != null) {
            try {
                return this.mConfiguration.commonService.isNetWorkAvailable(context);
            } catch (Throwable unused) {
            }
        }
        return NetworkUtils.isNetworkAvailableFast(context);
    }
}
