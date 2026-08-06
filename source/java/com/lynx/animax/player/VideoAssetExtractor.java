package com.lynx.animax.player;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.lynx.animax.util.AnimaXLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class VideoAssetExtractor {
    private static final String TAG = "VideoAssetExtractor";

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VideoInfo extractVideoInfo(String str) {
        boolean z;
        if (str == null || str.isEmpty()) {
            return null;
        }
        VideoInfo videoInfo = new VideoInfo();
        MediaExtractor mediaExtractor = new MediaExtractor();
        if (!setDataSource(mediaExtractor, str)) {
            AnimaXLog.e(TAG, "load fail, MediaExtractor setDataSource error");
        } else {
            findVideoTrack(mediaExtractor, videoInfo);
            if (videoInfo.getVideoTrackIndex() < 0) {
                AnimaXLog.e(TAG, "load fail, there is no video track");
            } else {
                updateWidth(videoInfo);
                updateHeight(videoInfo);
                updateFrameRate(videoInfo);
                updateFrameCount(videoInfo);
                z = true;
                mediaExtractor.release();
                if (z) {
                    return null;
                }
                return videoInfo;
            }
        }
        z = false;
        mediaExtractor.release();
        if (z) {
        }
    }

    public static VideoRawData extractVideoRawData(String str, int i) {
        boolean z;
        if (str == null || str.isEmpty() || i < 0) {
            return null;
        }
        VideoRawData videoRawData = new VideoRawData();
        MediaExtractor mediaExtractor = new MediaExtractor();
        if (!setDataSource(mediaExtractor, str)) {
            AnimaXLog.e(TAG, "load fail, MediaExtractor setDataSource error");
            z = false;
        } else {
            mediaExtractor.selectTrack(i);
            doExtractVideoRawData(mediaExtractor, videoRawData, (int) new File(str).length());
            z = true;
        }
        mediaExtractor.release();
        if (z) {
            return videoRawData;
        }
        return null;
    }

    private static void doExtractVideoRawData(MediaExtractor mediaExtractor, VideoRawData videoRawData, int i) {
        int readFrameData;
        if (i <= 0) {
            AnimaXLog.e(TAG, "doExtractVideoRawData fail, videoSize = " + i);
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        ArrayList<Integer> keyFrames = videoRawData.getKeyFrames();
        ArrayList<FrameInfo> frameInfos = videoRawData.getFrameInfos();
        int i2 = 0;
        while (true) {
            readFrameData = readFrameData(mediaExtractor, i2, allocate);
            if (readFrameData <= 0) {
                break;
            }
            if ((mediaExtractor.getSampleFlags() & 1) > 0) {
                keyFrames.add(Integer.valueOf(frameInfos.size()));
            }
            int i3 = readFrameData + i2;
            frameInfos.add(new FrameInfo(i2, i3, mediaExtractor.getSampleTime()));
            mediaExtractor.advance();
            i2 = i3;
        }
        if (readFrameData == -1) {
            AnimaXLog.i(TAG, "video size: " + i2 + " bytes, frame count: " + frameInfos.size() + ", key frame count: " + keyFrames.size());
            videoRawData.setFrameBuffer(allocate);
        } else {
            AnimaXLog.e(TAG, "doExtractVideoRawData fail");
            keyFrames.clear();
            frameInfos.clear();
        }
    }

    private static boolean setDataSource(MediaExtractor mediaExtractor, String str) {
        try {
            mediaExtractor.setDataSource(str);
            return true;
        } catch (IOException e) {
            AnimaXLog.e(TAG, "setDataSource IOException: " + e.getMessage());
            return false;
        }
    }

    private static void findVideoTrack(MediaExtractor mediaExtractor, VideoInfo videoInfo) {
        String str;
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            try {
                str = trackFormat.getString("mime");
            } catch (ClassCastException e) {
                AnimaXLog.e(TAG, "format doesn't has mine property: " + e.getMessage());
                str = null;
            }
            if (str != null && str.startsWith("video/")) {
                videoInfo.setVideoTrackIndex(i);
                videoInfo.setFormat(trackFormat);
                return;
            }
        }
    }

    private static void updateWidth(VideoInfo videoInfo) {
        try {
            videoInfo.setWidth(videoInfo.getFormat().getInteger("width"));
        } catch (ClassCastException | NullPointerException e) {
            AnimaXLog.e(TAG, "format doesn't has width property: " + e.getMessage());
            videoInfo.setWidth(0);
        }
    }

    private static void updateHeight(VideoInfo videoInfo) {
        try {
            videoInfo.setHeight(videoInfo.getFormat().getInteger("height"));
        } catch (ClassCastException | NullPointerException e) {
            AnimaXLog.e(TAG, "format doesn't has height property: " + e.getMessage());
            videoInfo.setHeight(0);
        }
    }

    private static void updateFrameRate(VideoInfo videoInfo) {
        MediaFormat format = videoInfo.getFormat();
        try {
            videoInfo.setFrameRate(format.getInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE));
        } catch (ClassCastException | NullPointerException e) {
            AnimaXLog.e(TAG, "format doesn't has int frame-rate property: " + e.getMessage());
            videoInfo.setFrameRate(0.0f);
        }
        if (0.0f != videoInfo.getFrameRate()) {
            return;
        }
        try {
            videoInfo.setFrameRate(format.getFloat(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE));
        } catch (ClassCastException | NullPointerException e2) {
            AnimaXLog.e(TAG, "format doesn't has float frame-rate property: " + e2.getMessage());
        }
    }

    private static void updateFrameCount(VideoInfo videoInfo) {
        long j;
        try {
            j = videoInfo.getFormat().getLong("durationUs");
        } catch (ClassCastException | NullPointerException e) {
            AnimaXLog.e(TAG, "format doesn't has long durationUs property: " + e.getMessage());
            j = 0;
        }
        videoInfo.setFrameCount(Math.round((videoInfo.getFrameRate() * ((float) j)) / 1000000.0f));
        AnimaXLog.i(TAG, "frame count: " + videoInfo.getFrameCount());
    }

    private static int readFrameData(MediaExtractor mediaExtractor, int i, ByteBuffer byteBuffer) {
        try {
            return mediaExtractor.readSampleData(byteBuffer, i);
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "current buffer may not have enough space to read";
            }
            AnimaXLog.e(TAG, "readSampleData IllegalArgumentException: " + message);
            return 0;
        }
    }
}
