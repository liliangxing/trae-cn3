package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.video.IVideoFrame;

/* loaded from: classes7.dex */
public interface IChorusCacheSyncObserver {
    void onSyncEvent(ChorusCacheSyncEvent event, ChorusCacheSyncError error);

    void onSyncedUsersChanged(int count, String[] uids);

    void onSyncedVideoFrames(int count, String[] uids, IVideoFrame[] videoFrames);
}
