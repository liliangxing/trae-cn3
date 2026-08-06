package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {

    /* renamed from: a */
    private static final OpenDeviceHmsClientBuilder f1591a = new OpenDeviceHmsClientBuilder();

    /* renamed from: b */
    private static final Api<OpenDeviceOptions> f1592b = new Api<>(HuaweiApiAvailability.HMS_API_NAME_OD);

    /* renamed from: c */
    private static OpenDeviceOptions f1593c = new OpenDeviceOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenDeviceClientImpl(Context context) {
        super(context, f1592b, f1593c, f1591a);
        super.setKitSdkVersion(61300300);
    }

    @Override // com.huawei.hms.opendevice.OpenDeviceClient
    public Task<OdidResult> getOdid() {
        return doWrite(new OpenDeviceTaskApiCall(HuaweiOpendeviceNaming.GET_ODID, JsonUtil.createJsonString(null), HiAnalyticsClient.reportEntry(getContext(), HuaweiOpendeviceNaming.GET_ODID, 61300300)));
    }
}
