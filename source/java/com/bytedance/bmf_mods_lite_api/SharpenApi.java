package com.bytedance.bmf_mods_lite_api;

import android.graphics.Bitmap;
import com.bytedance.bmf_mods_lite_api.bean.OesParams;
import com.bytedance.bmf_mods_lite_api.bean.RenderParams;
import com.bytedance.bmf_mods_lite_api.exception.BmfException;

/* loaded from: classes3.dex */
public interface SharpenApi {
    default void Free() {
    }

    default int GetResult() {
        return -1;
    }

    default int Init(int alg_type, int max_width, int max_height, int pool_size, String program_cache, float wt, float thr, float ovrt, boolean adaptive, float g0, float lc_wt_thr) {
        return -1;
    }

    default int Init(int alg_type, int max_width, int max_height, int pool_size, String program_cache, int scene, float wt, float thr, float ovrt, boolean adaptive, float g0, float lc_wt_thr) {
        return -1;
    }

    default Bitmap ProcessBitmap(Bitmap bitmap, float wt, float thr, float ovrt, boolean adaptive, float g0, float lc_wt_thr) throws BmfException {
        return null;
    }

    default int ProcessOesTexture(int textureId, int width, int height, float[] matrix, float wt, float thr, float ovrt, boolean adaptive, float g0, float lc_wt_thr, OesParams oesParams) {
        return -1;
    }

    default int ProcessOesTexture(int textureId, int width, int height, float[] matrix, float wt, float thr, float ovrt, boolean adaptive, float g0, float lc_wt_thr, OesParams oesParams, RenderParams renderParams) {
        return -1;
    }

    default int ProcessOesTexture(int textureId, int width, int height, float[] matrix, OesParams oesParams) {
        return -1;
    }

    default int ProcessOesTexture(int textureId, int width, int height, float[] matrix, OesParams oesParams, RenderParams renderParams) {
        return -1;
    }

    default int ProcessTexture(int textureId, int width, int height) {
        return -1;
    }

    default int ProcessTexture(int textureId, int width, int height, float wt, float thr, float ovrt, boolean adaptive, float g0, float lc_wt_thr) {
        return -1;
    }

    default int ProcessTexture(int textureId, int width, int height, float wt, float thr, float ovrt, boolean adaptive, float g0, float lc_wt_thr, RenderParams renderParams) {
        return -1;
    }

    default int ProcessTexture(int textureId, int width, int height, RenderParams renderParams) {
        return -1;
    }

    default int getQueuingTaskNum() {
        return -1;
    }
}
