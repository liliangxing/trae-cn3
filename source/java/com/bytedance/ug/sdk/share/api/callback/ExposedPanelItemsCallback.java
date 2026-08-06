package com.bytedance.ug.sdk.share.api.callback;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ExposedPanelItemsCallback {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class EmptyExposedPanelItemsCallback implements ExposedPanelItemsCallback {
        @Override // com.bytedance.ug.sdk.share.api.callback.ExposedPanelItemsCallback
        public void resetPanelItemOriginalData(ShareContent shareContent) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.ExposedPanelItemsCallback
        public void resetPanelItemServerData(ShareContent shareContent) {
        }
    }

    void resetPanelItemOriginalData(ShareContent shareContent);

    void resetPanelItemServerData(ShareContent shareContent);
}
