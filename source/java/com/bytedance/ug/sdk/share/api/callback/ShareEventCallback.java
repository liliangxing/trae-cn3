package com.bytedance.ug.sdk.share.api.callback;

import com.bytedance.ug.sdk.share.api.entity.DialogEventType;
import com.bytedance.ug.sdk.share.api.entity.DialogType;
import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.PermissionType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.model.ShareTokenType;
import com.bytedance.ug.sdk.share.impl.network.model.GetShareInfoResponse;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ShareEventCallback {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class EmptyShareEventCallBack implements ShareEventCallback {
        @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
        public void onDownloadEvent(DownloadStatus downloadStatus, String str, ShareContent shareContent) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
        public void onGetShareInfoFailed(int i, String str) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
        public void onGetShareInfoSuccess(GetShareInfoResponse getShareInfoResponse) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
        public void onPermissionEvent(PermissionType permissionType, ShareContent shareContent, String str) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
        public void onShareResultEvent(ShareResult shareResult) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
        public void onTokenDialogEvent(DialogType dialogType, DialogEventType dialogEventType, ShareTokenType shareTokenType, ShareContent shareContent) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.ShareEventCallback
        public void onWillLaunchThirdAppEvent(ShareChannelType shareChannelType) {
        }
    }

    void onDownloadEvent(DownloadStatus downloadStatus, String str, ShareContent shareContent);

    void onGetShareInfoFailed(int i, String str);

    void onGetShareInfoSuccess(GetShareInfoResponse getShareInfoResponse);

    void onPermissionEvent(PermissionType permissionType, ShareContent shareContent, String str);

    void onShareResultEvent(ShareResult shareResult);

    void onTokenDialogEvent(DialogType dialogType, DialogEventType dialogEventType, ShareTokenType shareTokenType, ShareContent shareContent);

    void onWillLaunchThirdAppEvent(ShareChannelType shareChannelType);
}
