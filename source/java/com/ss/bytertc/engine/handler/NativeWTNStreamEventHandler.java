package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IWTNStreamEventHandler;
import com.ss.bytertc.engine.InternalRemoteAudioStats;
import com.ss.bytertc.engine.InternalRemoteVideoStats;
import com.ss.bytertc.engine.WTNStream;
import com.ss.bytertc.engine.data.DataMessageSourceType;
import com.ss.bytertc.engine.data.VideoFrameInfo;
import com.ss.bytertc.engine.data.WTNSubscribeState;
import com.ss.bytertc.engine.data.WTNSubscribeStateChangeReason;
import com.ss.bytertc.engine.type.RemoteAudioStats;
import com.ss.bytertc.engine.type.RemoteVideoStats;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeWTNStreamEventHandler {
    private static final String TAG = "NativeWTNStreamEventHandler";
    private WeakReference<WTNStream> mWTNStream;

    public NativeWTNStreamEventHandler(WTNStream WTNStream) {
        this.mWTNStream = new WeakReference<>(WTNStream);
    }

    public void onWTNRemoteVideoStats(String streamId, InternalRemoteVideoStats stats) {
        IWTNStreamEventHandler wTNStreamEventHandler;
        LogUtil.m215d(TAG, "onWTNRemoteVideoStats, streamid" + streamId);
        try {
            WTNStream wTNStream = this.mWTNStream.get();
            if (wTNStream == null || (wTNStreamEventHandler = wTNStream.getWTNStreamEventHandler()) == null) {
                return;
            }
            wTNStreamEventHandler.onWTNRemoteVideoStats(streamId, new RemoteVideoStats(stats));
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onWTNRemoteVideoStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onWTNRemoteAudioStats(String streamId, InternalRemoteAudioStats stats) {
        IWTNStreamEventHandler wTNStreamEventHandler;
        LogUtil.m215d(TAG, "onWTNRemoteAudioStats, streamid" + streamId);
        try {
            WTNStream wTNStream = this.mWTNStream.get();
            if (wTNStream == null || (wTNStreamEventHandler = wTNStream.getWTNStreamEventHandler()) == null) {
                return;
            }
            wTNStreamEventHandler.onWTNRemoteAudioStats(streamId, new RemoteAudioStats(stats));
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onWTNRemoteAudioStats callback catch exception.\n" + e.getMessage());
        }
    }

    public void onWTNVideoSubscribeStateChanged(String streamId, WTNSubscribeState state_code, WTNSubscribeStateChangeReason reason) {
        IWTNStreamEventHandler wTNStreamEventHandler;
        LogUtil.m215d(TAG, "onWTNVideoSubscribeStateChanged state(" + state_code + ") state(" + reason + ") streamId:" + streamId);
        try {
            WTNStream wTNStream = this.mWTNStream.get();
            if (wTNStream == null || (wTNStreamEventHandler = wTNStream.getWTNStreamEventHandler()) == null) {
                return;
            }
            wTNStreamEventHandler.onWTNVideoSubscribeStateChanged(streamId, state_code, reason);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onWTNVideoSubscribeStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onWTNAudioSubscribeStateChanged(String streamId, WTNSubscribeState state_code, WTNSubscribeStateChangeReason reason) {
        IWTNStreamEventHandler wTNStreamEventHandler;
        LogUtil.m215d(TAG, "onWTNAudioSubscribeStateChanged state(" + state_code + ") state(" + reason + ") streamId:" + streamId);
        try {
            WTNStream wTNStream = this.mWTNStream.get();
            if (wTNStream == null || (wTNStreamEventHandler = wTNStream.getWTNStreamEventHandler()) == null) {
                return;
            }
            wTNStreamEventHandler.onWTNAudioSubscribeStateChanged(streamId, state_code, reason);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onWTNAudioSubscribeStateChanged callback catch exception.\n" + e.getMessage());
        }
    }

    public void onWTNSEIMessageReceived(String streamId, int channelId, ByteBuffer message) {
        IWTNStreamEventHandler wTNStreamEventHandler;
        try {
            WTNStream wTNStream = this.mWTNStream.get();
            if (wTNStream == null || (wTNStreamEventHandler = wTNStream.getWTNStreamEventHandler()) == null) {
                return;
            }
            wTNStreamEventHandler.onWTNSEIMessageReceived(streamId, channelId, message);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onWTNSEIMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onWTNDataMessageReceived(String streamId, ByteBuffer msg, int sourceType) {
        IWTNStreamEventHandler wTNStreamEventHandler;
        try {
            WTNStream wTNStream = this.mWTNStream.get();
            if (wTNStream == null || (wTNStreamEventHandler = wTNStream.getWTNStreamEventHandler()) == null) {
                return;
            }
            wTNStreamEventHandler.onWTNDataMessageReceived(streamId, msg, DataMessageSourceType.fromId(sourceType));
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onWTNDataMessageReceived callback catch exception.\n" + e.getMessage());
        }
    }

    public void onWTNFirstRemoteVideoFrameDecoded(String streamId, VideoFrameInfo info) {
        IWTNStreamEventHandler wTNStreamEventHandler;
        LogUtil.m215d(TAG, "onWTNFirstRemoteVideoFrameDecoded...streamid: " + streamId + ", width: " + info.getWidth() + ", height: " + info.getHeight());
        try {
            WTNStream wTNStream = this.mWTNStream.get();
            if (wTNStream == null || (wTNStreamEventHandler = wTNStream.getWTNStreamEventHandler()) == null) {
                return;
            }
            wTNStreamEventHandler.onWTNFirstRemoteVideoFrameDecoded(streamId, info);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onWTNFirstRemoteVideoFrameDecoded callback catch exception.\n" + e.getMessage());
        }
    }

    public void onWTNFirstRemoteAudioFrame(String streamId) {
        IWTNStreamEventHandler wTNStreamEventHandler;
        LogUtil.m215d(TAG, "onWTNFirstRemoteAudioFrame...streamid: " + streamId);
        try {
            WTNStream wTNStream = this.mWTNStream.get();
            if (wTNStream == null || (wTNStreamEventHandler = wTNStream.getWTNStreamEventHandler()) == null) {
                return;
            }
            wTNStreamEventHandler.onWTNFirstRemoteAudioFrame(streamId);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onWTNFirstRemoteAudioFrame callback catch exception.\n" + e.getMessage());
        }
    }

    public static ByteBuffer allocateDirectByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity);
    }
}
