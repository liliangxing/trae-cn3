package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.video.IVideoFrame;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ChorusCacheSyncObserver {
    private IChorusCacheSyncObserver observer = null;

    public void onSyncedVideoFrames(int count, String[] uids, IVideoFrame[] videoFrame) {
        IChorusCacheSyncObserver iChorusCacheSyncObserver = this.observer;
        if (iChorusCacheSyncObserver != null) {
            iChorusCacheSyncObserver.onSyncedVideoFrames(count, uids, videoFrame);
        }
    }

    public void onSyncEvent(ChorusCacheSyncEvent event, ChorusCacheSyncError error) {
        IChorusCacheSyncObserver iChorusCacheSyncObserver = this.observer;
        if (iChorusCacheSyncObserver != null) {
            iChorusCacheSyncObserver.onSyncEvent(event, error);
        }
    }

    public void onSyncedUsersChanged(int count, String[] uids) {
        IChorusCacheSyncObserver iChorusCacheSyncObserver = this.observer;
        if (iChorusCacheSyncObserver != null) {
            iChorusCacheSyncObserver.onSyncedUsersChanged(count, uids);
        }
    }

    public void setUserObserver(IChorusCacheSyncObserver chorusObserver) {
        if (chorusObserver != null) {
            this.observer = chorusObserver;
        }
    }
}
