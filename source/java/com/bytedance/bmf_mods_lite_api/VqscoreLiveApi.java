package com.bytedance.bmf_mods_lite_api;

import android.content.Context;
import com.bytedance.bmf_mods_lite_api.callback.VqscoreDownloadCallback;
import java.util.Map;

/* loaded from: classes3.dex */
public interface VqscoreLiveApi {
    default void DownloadModel(Context context, Map<String, String> params) {
    }

    default String GetDownloadedModelPath() {
        return "";
    }

    default void SetDownloadCallback(VqscoreDownloadCallback callback) {
    }
}
