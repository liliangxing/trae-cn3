package com.bytedance.sdk.open.aweme.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.open.aweme.share.Share;

/* loaded from: classes5.dex */
public interface IShareApplier {
    void addIntentFlags(Context context, Intent intent);

    void fillBundle(Context context, Share.Request request, Bundle bundle);

    String getClientKey();

    String getComponentClassName();

    String getPackageName();
}
