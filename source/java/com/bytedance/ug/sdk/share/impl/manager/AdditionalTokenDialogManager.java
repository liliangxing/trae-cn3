package com.bytedance.ug.sdk.share.impl.manager;

import com.bytedance.ug.sdk.share.api.ui.IAdditionalRecognizeTokenDialog;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class AdditionalTokenDialogManager {
    private ArrayList<IAdditionalRecognizeTokenDialog> mRecognizeTokenDialogList;

    /* loaded from: classes4.dex */
    private static class Singleton {
        private static AdditionalTokenDialogManager sInstance = new AdditionalTokenDialogManager();

        private Singleton() {
        }
    }

    public static AdditionalTokenDialogManager getInstance() {
        return Singleton.sInstance;
    }

    public ArrayList<IAdditionalRecognizeTokenDialog> getRecognizeTokenDialogList() {
        return this.mRecognizeTokenDialogList;
    }

    public void register(ArrayList<IAdditionalRecognizeTokenDialog> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (this.mRecognizeTokenDialogList == null) {
            this.mRecognizeTokenDialogList = new ArrayList<>();
        }
        this.mRecognizeTokenDialogList.addAll(arrayList);
    }
}
