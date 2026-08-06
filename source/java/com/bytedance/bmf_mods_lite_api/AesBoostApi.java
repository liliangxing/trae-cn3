package com.bytedance.bmf_mods_lite_api;

import com.bytedance.bmf_mods_lite_api.bean.AesBoostConfig;
import com.bytedance.bmf_mods_lite_api.bean.AesBoostProcessParams;
import com.bytedance.bmf_mods_lite_api.bean.PerfConfig;
import com.bytedance.bmf_mods_lite_api.bean.PerfReport;
import com.bytedance.bmf_mods_lite_api.callback.AesBoostInitCallback;

/* loaded from: classes3.dex */
public interface AesBoostApi {
    default void Free() {
    }

    default PerfReport GetPerformanceReport() {
        return null;
    }

    default int GetResultTexture() {
        return -1;
    }

    default int GetResultTextureMix() {
        return -1;
    }

    default int Init(int algType, int maxWidth, int maxHeight, int poolSize, String licenseModuleName, String programCacheDir, AesBoostConfig config, AesBoostInitCallback callback) {
        return -1;
    }

    default void PerformanceMeasurementConfig(PerfConfig config) {
    }

    default int ProcessOesTexture(int textureId, int width, int height, float[] matrix, AesBoostProcessParams params) {
        return -1;
    }

    default int ProcessOesTexture(int textureId, int width, int height, float[] matrix, boolean newVideo, int interval, int groupIndex) {
        return -1;
    }

    default int ProcessOesTextureMix(int textureId, int width, int height, float[] matrix, AesBoostProcessParams params) {
        return -1;
    }

    default int ProcessOesTextureMix(int textureId, int width, int height, float[] matrix, boolean newVideo, int interval, int groupIndex) {
        return -1;
    }

    default int ProcessTexture(int textureId, int width, int height, AesBoostProcessParams params) {
        return -1;
    }

    default int ProcessTexture(int textureId, int width, int height, boolean newVideo, int interval, int groupIndex) {
        return -1;
    }

    default int ProcessTextureMix(int textureId, int width, int height, AesBoostProcessParams params) {
        return -1;
    }

    default int ProcessTextureMix(int textureId, int width, int height, boolean newVideo, int interval, int groupIndex) {
        return -1;
    }
}
