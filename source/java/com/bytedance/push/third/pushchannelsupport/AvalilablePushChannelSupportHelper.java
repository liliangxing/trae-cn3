package com.bytedance.push.third.pushchannelsupport;

import android.content.Context;
import com.bytedance.push.third.IPushAdapter;

/* loaded from: classes4.dex */
public class AvalilablePushChannelSupportHelper extends BaseChannelSupportHelper {
    private Context mContext;

    public AvalilablePushChannelSupportHelper(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.push.third.pushchannelsupport.BaseChannelSupportHelper
    public boolean isSupportChannel(IPushAdapter iPushAdapter, int i) {
        return iPushAdapter != null && iPushAdapter.isPushAvailable(this.mContext, i);
    }
}
