package com.bytedance.ug.sdk.share.api.callback;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface OnPanelActionCallback {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class EmptyPanelActionCallback implements OnPanelActionCallback {
        @Override // com.bytedance.ug.sdk.share.api.callback.OnPanelActionCallback
        public boolean interceptPanelClick(IPanelItem iPanelItem, ShareContent shareContent, IExecuteListener iExecuteListener) {
            return false;
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.OnPanelActionCallback
        public void onPanelClick(IPanelItem iPanelItem) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.OnPanelActionCallback
        public void onPanelDismiss(boolean z) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.OnPanelActionCallback
        public void onPanelShow() {
        }
    }

    boolean interceptPanelClick(IPanelItem iPanelItem, ShareContent shareContent, IExecuteListener iExecuteListener);

    void onPanelClick(IPanelItem iPanelItem);

    void onPanelDismiss(boolean z);

    void onPanelShow();
}
