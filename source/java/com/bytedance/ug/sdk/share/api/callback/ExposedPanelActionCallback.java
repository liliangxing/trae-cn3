package com.bytedance.ug.sdk.share.api.callback;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ExposedPanelActionCallback {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class EmptyExposedPanelActionCallback implements ExposedPanelActionCallback {
        @Override // com.bytedance.ug.sdk.share.api.callback.ExposedPanelActionCallback
        public boolean dismissLoading() {
            return false;
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.ExposedPanelActionCallback
        public boolean interceptPanelClick(ShareContent shareContent, IExecuteListener iExecuteListener) {
            return false;
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.ExposedPanelActionCallback
        public boolean showLoading() {
            return false;
        }
    }

    boolean dismissLoading();

    boolean interceptPanelClick(ShareContent shareContent, IExecuteListener iExecuteListener);

    boolean showLoading();
}
