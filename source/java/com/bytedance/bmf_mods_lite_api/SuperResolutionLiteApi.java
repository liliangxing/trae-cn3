package com.bytedance.bmf_mods_lite_api;

import android.graphics.Bitmap;
import com.bytedance.bmf_mods_lite_api.bean.MultiScaleParams;
import com.bytedance.bmf_mods_lite_api.bean.OesParams;
import com.bytedance.bmf_mods_lite_api.bean.PackageParams;
import com.bytedance.bmf_mods_lite_api.bean.PerfConfig;
import com.bytedance.bmf_mods_lite_api.bean.PerfReport;
import com.bytedance.bmf_mods_lite_api.bean.RenderParams;
import com.bytedance.bmf_mods_lite_api.bean.RoiParams;
import com.bytedance.bmf_mods_lite_api.bean.SRConfig;
import com.bytedance.bmf_mods_lite_api.bean.SharpLevelParams;
import com.bytedance.bmf_mods_lite_api.bean.SuperAlgParam;
import com.bytedance.bmf_mods_lite_api.callback.SRInitCallback;
import com.bytedance.bmf_mods_lite_api.exception.BmfException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface SuperResolutionLiteApi {
    default int DisableAlg(int instanceId) {
        return -1;
    }

    default int EnableAlg(SuperAlgParam algParam) {
        return -1;
    }

    default int EnableAlgAsync(SuperAlgParam algParam, SRInitCallback callback) {
        return -1;
    }

    default void Free() {
    }

    default PerfReport GetPerformanceReport() {
        return null;
    }

    default int GetQueuingTaskNum() {
        return -1;
    }

    default void GiveBackBuffer(int texture_id) {
    }

    default int Init(int alg_type, int backend, int scale_type, int pool_size, String libpath, String licenseModuleName, String programCacheDir, int max_width, int max_height) {
        return -1;
    }

    default int Init(int alg_type, int backend, int scale_type, int pool_size, String libpath, String licenseModuleName, String programCacheDir, int max_width, int max_height, int scene) {
        return -1;
    }

    default int Init(int alg_type, int backend, int scale_type, int pool_size, String libpath, String licenseModuleName, String programCacheDir, int max_width, int max_height, SRConfig config, SRInitCallback callback) {
        return -1;
    }

    default int InitPackage(PackageParams package_params) {
        return -1;
    }

    default void PerformanceMeasurementConfig(PerfConfig config) {
    }

    default Bitmap ProcessMultiScaleBitmap(Bitmap srcBmp, int optimizeLevel, MultiScaleParams multiScaleParams, SharpLevelParams sharpLevelParams) throws BmfException {
        return null;
    }

    default int ProcessOesTexture(int textureId, int width, int height, float[] matrix, RoiParams roiParams, MultiScaleParams multiScaleParams, SharpLevelParams sharpLevelParams, OesParams oesParams) {
        return -1;
    }

    default int ProcessOesTexture(int textureId, int width, int height, float[] matrix, RoiParams roiParams, MultiScaleParams multiScaleParams, SharpLevelParams sharpLevelParams, OesParams oesParams, RenderParams renderParams) {
        return -1;
    }

    default int ProcessTexture(int textureId, int width, int height, RoiParams roiParams, MultiScaleParams multiScaleParams, SharpLevelParams sharpLevelParams) {
        return -1;
    }

    default int ProcessTexture(int textureId, int width, int height, RoiParams roiParams, MultiScaleParams multiScaleParams, SharpLevelParams sharpLevelParams, RenderParams renderParams) {
        return -1;
    }

    default int ProcessTextureWithAlgParam(int textureId, int textureTarget, int width, int height, float[] matrix, RoiParams roiParams, MultiScaleParams multiScaleParams, SharpLevelParams sharpLevelParams, OesParams oesParams, SuperAlgParam algParam) {
        return -1;
    }
}
