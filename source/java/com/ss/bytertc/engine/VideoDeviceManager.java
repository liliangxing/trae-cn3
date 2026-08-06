package com.ss.bytertc.engine;

import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IVideoDeviceManager;
import com.ss.bytertc.engine.video.VideoDeviceInfo;
import java.util.List;

/* loaded from: classes7.dex */
public class VideoDeviceManager implements IVideoDeviceManager {
    private static final String TAG = "VideoDeviceManager";
    private long mVideoDevicemanager;

    public VideoDeviceManager(long nativeVideoDeviceManager) {
        this.mVideoDevicemanager = nativeVideoDeviceManager;
    }

    @Override // com.ss.bytertc.engine.video.IVideoDeviceManager
    public List<VideoDeviceInfo> enumerateVideoCaptureDevices() {
        long j = this.mVideoDevicemanager;
        if (j == 0) {
            LogUtil.e(TAG, "native VideoDeviceManager is invalid, enumerateVideoCaptureDevices failed.");
            return null;
        }
        return NativeVideoDeviceManagerFunctions.nativeEnumerateVideoCaptureDevices(j);
    }

    @Override // com.ss.bytertc.engine.video.IVideoDeviceManager
    public int setVideoCaptureDevice(final String deviceId) {
        long j = this.mVideoDevicemanager;
        if (j == 0) {
            LogUtil.e(TAG, "native VideoDeviceManager is invalid, setVideoCaptureDevice failed.");
            return -1;
        }
        return NativeVideoDeviceManagerFunctions.nativeSetVideoCaptureDevice(j, deviceId);
    }
}
