package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService;

/* loaded from: classes7.dex */
public class NetTrafficManager {
    private IDownloadNetTrafficManagerService service;

    /* loaded from: classes7.dex */
    public interface NetworkStateChangeListener {
        void onBandwidthStateChange(NetworkQuality networkQuality);
    }

    /* loaded from: classes7.dex */
    private static class ConnectionClassManagerHolder {
        public static final NetTrafficManager instance = new NetTrafficManager();

        private ConnectionClassManagerHolder() {
        }
    }

    public static NetTrafficManager getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    private NetTrafficManager() {
        this.service = (IDownloadNetTrafficManagerService) DownloadServiceManager.getService(IDownloadNetTrafficManagerService.class);
    }

    public void addBandwidth(long j, long j2) {
        this.service.addBandwidth(j, j2);
    }

    public NetworkQuality getCurrentNetworkQuality() {
        return this.service.getCurrentNetworkQuality();
    }

    public void reset() {
        this.service.reset();
    }

    public double getDownloadKBitsPerSecond() {
        return this.service.getDownloadKBitsPerSecond();
    }

    public double getRealTimeSpeed() {
        return this.service.getRealTimeSpeed();
    }

    public long getTaskRunningTime() {
        return this.service.getTaskRunningTime();
    }

    public NetworkQuality register(NetworkStateChangeListener networkStateChangeListener) {
        return this.service.register(networkStateChangeListener);
    }

    public void remove(NetworkStateChangeListener networkStateChangeListener) {
        this.service.remove(networkStateChangeListener);
    }
}
