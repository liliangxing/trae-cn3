package com.ss.bytertc.engine.video;

import android.util.SparseArray;
import com.lynx.canvas.camera.CameraSize;
import com.ss.android.download.api.constant.Downloads;
import com.ss.bytertc.engine.VideoStreamDescription;
import com.ss.bytertc.engine.data.RTCData;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes7.dex */
public class VideoProfile {
    private static SparseArray<VideoPreset> sVideoProfileMap;

    static {
        SparseArray<VideoPreset> sparseArray = new SparseArray<>();
        sVideoProfileMap = sparseArray;
        sparseArray.put(0, new VideoPreset(160, 120, 15, 65));
        sVideoProfileMap.put(2, new VideoPreset(120, 120, 15, 50));
        sVideoProfileMap.put(10, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 180, 15, 140));
        sVideoProfileMap.put(12, new VideoPreset(180, 180, 15, 100));
        sVideoProfileMap.put(13, new VideoPreset(240, 180, 15, 120));
        sVideoProfileMap.put(14, new VideoPreset(240, 180, 15, 240));
        sVideoProfileMap.put(20, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 240, 15, 200));
        sVideoProfileMap.put(21, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 240, 15, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL));
        sVideoProfileMap.put(22, new VideoPreset(240, 240, 15, 140));
        sVideoProfileMap.put(23, new VideoPreset(424, 240, 15, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM));
        sVideoProfileMap.put(30, new VideoPreset(640, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 15, 600));
        sVideoProfileMap.put(32, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 15, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME));
        sVideoProfileMap.put(33, new VideoPreset(640, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 30, 600));
        sVideoProfileMap.put(34, new VideoPreset(640, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 15, 800));
        sVideoProfileMap.put(35, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 30, 400));
        sVideoProfileMap.put(36, new VideoPreset(480, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 15, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
        sVideoProfileMap.put(37, new VideoPreset(480, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 30, Downloads.Impl.STATUS_CANCELED));
        sVideoProfileMap.put(40, new VideoPreset(640, 480, 15, 500));
        sVideoProfileMap.put(42, new VideoPreset(480, 480, 15, 400));
        sVideoProfileMap.put(43, new VideoPreset(640, 480, 30, MediaPlayer.MEDIA_PLAYER_OPTION_AI_BARRAGE_URL));
        sVideoProfileMap.put(45, new VideoPreset(480, 480, 30, 600));
        sVideoProfileMap.put(46, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DIFF_LIST, 480, 15, 1200));
        sVideoProfileMap.put(47, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DIFF_LIST, 480, 30, 800));
        sVideoProfileMap.put(48, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DIFF_LIST, 480, 30, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST));
        sVideoProfileMap.put(50, new VideoPreset(CameraSize.highHeight, 720, 15, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_TAG_BASED_SPEED));
        sVideoProfileMap.put(52, new VideoPreset(CameraSize.highHeight, 720, 30, 1710));
        sVideoProfileMap.put(54, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_SET_SESSIONID, 720, 15, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_SPACE));
        sVideoProfileMap.put(55, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_SET_SESSIONID, 720, 30, 1380));
    }

    public static VideoPreset getVideoVideoPresetById(int profileId) {
        VideoPreset videoPreset = sVideoProfileMap.get(profileId);
        return videoPreset == null ? sVideoProfileMap.get(33) : videoPreset;
    }

    public static VideoPreset getVideoVideoPreset() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (VideoStreamDescription videoStreamDescription : RTCData.instance().getVideoStreamDescriptions()) {
            if (((Integer) videoStreamDescription.videoSize.first).intValue() > i) {
                i = ((Integer) videoStreamDescription.videoSize.first).intValue();
            }
            if (((Integer) videoStreamDescription.videoSize.second).intValue() > i2) {
                i2 = ((Integer) videoStreamDescription.videoSize.second).intValue();
            }
            if (videoStreamDescription.frameRate > i3) {
                i3 = videoStreamDescription.frameRate;
            }
            if (videoStreamDescription.maxKbps > i4) {
                i4 = videoStreamDescription.maxKbps;
            }
        }
        return new VideoPreset(i, i2, i3, i4);
    }

    public static void addVideoVideoPreset(int profileId, VideoPreset videoPreset) {
        sVideoProfileMap.put(profileId, videoPreset);
    }

    public static SparseArray<VideoPreset> getsVideoProfileMap() {
        return sVideoProfileMap;
    }
}
