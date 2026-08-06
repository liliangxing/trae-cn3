package com.bytedance.bmf_mods_lite_api.packageHandler;

/* loaded from: classes3.dex */
public interface PackageHandlerApi {
    default int disableAlg(int instance_id) {
        return -1;
    }

    default int enableAlg(ParamApi param) {
        return -1;
    }

    default int enableAlgAsync(ParamApi param) {
        return -1;
    }

    default int getAlgInstanceId() {
        return -1;
    }

    default int getAlgStatus() {
        return -1;
    }

    default int getInfo(ParamApi param) {
        return -1;
    }

    default int init(ParamApi param) {
        return -1;
    }

    default int process(VideoFrameApi frame_in, ParamApi param_in, VideoFrameApi frame_out, ParamApi param_out) {
        return -1;
    }

    default int release() {
        return -1;
    }

    default int setCurrentThreadGlobalDeviceContext() {
        return -1;
    }

    default int unrefVideoFrame(VideoFrameApi frame) {
        return -1;
    }
}
