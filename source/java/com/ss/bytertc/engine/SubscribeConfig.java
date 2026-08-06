package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class SubscribeConfig {
    public int framerate;
    public boolean isScreen;
    public boolean subAudio;
    public int subHeight;
    public boolean subVideo;
    public int subVideoIndex;
    public int subWidth;
    public SVCLayer svcLayer;
    public int videoIndex;

    /* loaded from: classes7.dex */
    public enum SVCLayer {
        DEFAULT(0),
        BASE(1),
        MAIN(2),
        HIGH(3);

        private int value;

        SVCLayer(int v) {
            this.value = v;
        }

        public static SVCLayer convertFromInt(int v) {
            return values()[v];
        }

        public int getValue() {
            return this.value;
        }
    }

    public SubscribeConfig() {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        this.svcLayer = SVCLayer.DEFAULT;
        this.framerate = 0;
    }

    public SubscribeConfig(SubscribeConfig oldConfig) {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        this.svcLayer = SVCLayer.DEFAULT;
        this.framerate = 0;
        if (oldConfig != null) {
            this.isScreen = oldConfig.isScreen;
            this.subVideo = oldConfig.subVideo;
            this.subAudio = oldConfig.subAudio;
            this.videoIndex = oldConfig.videoIndex;
            this.svcLayer = oldConfig.svcLayer;
            this.subWidth = oldConfig.subWidth;
            this.subHeight = oldConfig.subHeight;
            this.subVideoIndex = oldConfig.subVideoIndex;
        }
    }

    public SubscribeConfig(boolean isScreen, boolean subVideo, boolean subAudio, int videoIndex) {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        this.svcLayer = SVCLayer.DEFAULT;
        this.framerate = 0;
        this.isScreen = isScreen;
        this.subVideo = subVideo;
        this.subAudio = subAudio;
        this.videoIndex = videoIndex;
        this.svcLayer = SVCLayer.DEFAULT;
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
    }

    public SubscribeConfig(boolean isScreen, boolean subVideo, boolean subAudio, int videoIndex, int svcLayer) {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        this.svcLayer = SVCLayer.DEFAULT;
        this.framerate = 0;
        this.isScreen = isScreen;
        this.subVideo = subVideo;
        this.subAudio = subAudio;
        this.videoIndex = videoIndex;
        this.svcLayer = SVCLayer.convertFromInt(svcLayer);
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
    }

    public SubscribeConfig(boolean isScreen, boolean subVideo, boolean subAudio, int videoIndex, int svcLayer, int subWidth, int subHeight, int subVideoIndex) {
        this.subWidth = 0;
        this.subHeight = 0;
        this.subVideoIndex = -1;
        this.svcLayer = SVCLayer.DEFAULT;
        this.framerate = 0;
        this.isScreen = isScreen;
        this.subVideo = subVideo;
        this.subAudio = subAudio;
        this.videoIndex = videoIndex;
        this.svcLayer = SVCLayer.convertFromInt(svcLayer);
        this.subWidth = subWidth;
        this.subHeight = subHeight;
        this.subVideoIndex = subVideoIndex;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubscribeConfig subscribeConfig = (SubscribeConfig) o;
        return this.isScreen == subscribeConfig.isScreen && this.subVideo == subscribeConfig.subVideo && this.subAudio == subscribeConfig.subAudio && this.videoIndex == subscribeConfig.videoIndex && this.svcLayer == subscribeConfig.svcLayer && this.subWidth == subscribeConfig.subWidth && this.subHeight == subscribeConfig.subHeight;
    }

    public String toString() {
        return "SubscribeConfig{isScreen=" + this.isScreen + ", subVideo=" + this.subVideo + ", subAudio=" + this.subAudio + ", videoIndex=" + this.videoIndex + ", svcLayer=" + this.svcLayer + ", sub_width=" + this.subWidth + ", sub_height=" + this.subHeight + ", sub_video_index=" + this.subVideoIndex + "}";
    }

    private static SubscribeConfig create(boolean isScreen, boolean subVideo, boolean subAudio, int videoIndex, int svcLayer, int subWidth, int subHeight, int subVideoIndex) {
        return new SubscribeConfig(isScreen, subVideo, subAudio, videoIndex, svcLayer, subWidth, subHeight, subVideoIndex);
    }
}
