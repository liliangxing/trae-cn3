package com.bytedance.push.third.pushchannelsupport;

import android.content.Context;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.IPushAdapter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ConfigAvailableChannelSupportHelper extends BaseChannelSupportHelper {
    private Context context;

    public ConfigAvailableChannelSupportHelper(Context context) {
        this.context = context;
    }

    @Override // com.bytedance.push.third.pushchannelsupport.BaseChannelSupportHelper
    public boolean isSupportChannel(IPushAdapter iPushAdapter, int i) {
        return (iPushAdapter == null || !iPushAdapter.isPushAvailable(this.context, i) || PushSupporter.thirdService().getPushConfig(i) == null) ? false : true;
    }
}
