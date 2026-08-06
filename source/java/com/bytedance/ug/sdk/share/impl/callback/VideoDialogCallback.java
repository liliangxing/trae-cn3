package com.bytedance.ug.sdk.share.impl.callback;

/* loaded from: classes4.dex */
public interface VideoDialogCallback {

    /* loaded from: classes4.dex */
    public static abstract class EmptyVideoDialogCallback implements VideoDialogCallback {
        @Override // com.bytedance.ug.sdk.share.impl.callback.VideoDialogCallback
        public boolean skipDownloadVideo() {
            return false;
        }

        @Override // com.bytedance.ug.sdk.share.impl.callback.VideoDialogCallback
        public boolean skipVideoShareDialog() {
            return false;
        }
    }

    boolean skipDownloadVideo();

    boolean skipVideoShareDialog();
}
