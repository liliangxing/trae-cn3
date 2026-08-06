package com.bytedance.ug.sdk.share.api.callback;

import com.bytedance.ug.sdk.share.impl.network.model.ShareInfo;
import java.util.List;

/* loaded from: classes4.dex */
public interface ShareInfoCallback {
    void onFailed();

    void onSuccess(List<ShareInfo> list);
}
