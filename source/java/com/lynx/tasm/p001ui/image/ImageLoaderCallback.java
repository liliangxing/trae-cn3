package com.lynx.tasm.p001ui.image;

import com.lynx.tasm.LynxError;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ImageLoaderCallback {
    public boolean isPendingLoad() {
        return false;
    }

    public void onImageDstSize(int i, int i2) {
    }

    public void onImageLoadFailed(String str) {
    }

    public void onImageLoadFailed(String str, int i, int i2) {
    }

    public void onImageLoadSuccess(int i, int i2) {
    }

    public void onImageStartLoad() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onImageLoadFailed(LynxError lynxError, int i, int i2) {
        onImageLoadFailed(lynxError != null ? lynxError.getSummaryMessage() + ": " + lynxError.getRootCause() : "", i, i2);
    }
}
