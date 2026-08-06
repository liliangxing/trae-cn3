package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.network.NetTrafficManagerImpl;
import com.ss.android.socialbase.downloader.network.NetworkQuality;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadNetTrafficManagerService implements IDownloadNetTrafficManagerService {
    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public void addBandwidth(long j, long j2) {
        NetTrafficManagerImpl.getInstance().addBandwidth(j, j2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public NetworkQuality getCurrentNetworkQuality() {
        return NetTrafficManagerImpl.getInstance().getCurrentNetworkQuality();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public void reset() {
        NetTrafficManagerImpl.getInstance().reset();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public double getDownloadKBitsPerSecond() {
        return NetTrafficManagerImpl.getInstance().getDownloadKBitsPerSecond();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public double getRealTimeSpeed() {
        return NetTrafficManagerImpl.getInstance().getRealTimeSpeed();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public long getTaskRunningTime() {
        return DeviceBandwidthSampler.getInstance().getTaskRunningTime();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public NetworkQuality register(NetTrafficManager.NetworkStateChangeListener networkStateChangeListener) {
        return NetTrafficManagerImpl.getInstance().register(networkStateChangeListener);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public void remove(NetTrafficManager.NetworkStateChangeListener networkStateChangeListener) {
        NetTrafficManagerImpl.getInstance().remove(networkStateChangeListener);
    }
}
