package com.ss.bytertc.base.media.camera;

import android.graphics.ImageFormat;
import com.lynx.canvas.camera.CameraSize;
import com.ss.bytertc.base.media.Size;
import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes7.dex */
public class CameraEnumerationAndroid {
    static final ArrayList<Size> COMMON_RESOLUTIONS = new ArrayList<>(Arrays.asList(new Size(160, 120), new Size(240, 160), new Size(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 240), new Size(400, 240), new Size(480, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME), new Size(640, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL), new Size(640, 480), new Size(768, 480), new Size(MediaPlayer.MEDIA_PLAYER_OPTION_OPT_REUSE_OF_SUB_DETACHING, 480), new Size(800, 600), new Size(MediaPlayer.MEDIA_PLAYER_OPTION_SET_SESSIONID, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON), new Size(MediaPlayer.MEDIA_PLAYER_OPTION_SET_SESSIONID, 640), new Size(1024, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND), new Size(1024, 600), new Size(CameraSize.highHeight, 720), new Size(CameraSize.highHeight, 1024), new Size(1920, 1080), new Size(1920, 1440), new Size(2560, 1440), new Size(3840, 2160)));
    private static final String TAG = "CameraEnumerationAndroid";

    /* loaded from: classes7.dex */
    public static class CaptureFormat {
        public final FramerateRange framerate;
        public final int height;
        public final int imageFormat = 17;
        public final int width;

        /* loaded from: classes7.dex */
        public static class FramerateRange {
            public int max;
            public int min;

            public FramerateRange(int min, int max) {
                this.min = min;
                this.max = max;
            }

            public String toString() {
                return "[" + (this.min / 1000.0f) + Constants.COLON_SEPARATOR + (this.max / 1000.0f) + "]";
            }

            public boolean equals(Object other) {
                if (!(other instanceof FramerateRange)) {
                    return false;
                }
                FramerateRange framerateRange = (FramerateRange) other;
                return this.min == framerateRange.min && this.max == framerateRange.max;
            }

            public int hashCode() {
                return (this.min * 65537) + 1 + this.max;
            }
        }

        public CaptureFormat(int width, int height, int minFramerate, int maxFramerate) {
            this.width = width;
            this.height = height;
            this.framerate = new FramerateRange(minFramerate, maxFramerate);
        }

        public CaptureFormat(int width, int height, FramerateRange framerate) {
            this.width = width;
            this.height = height;
            this.framerate = framerate;
        }

        public int frameSize() {
            return frameSize(this.width, this.height, 17);
        }

        public static int frameSize(int width, int height, int imageFormat) {
            if (imageFormat != 17) {
                throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
            }
            return ((width * height) * ImageFormat.getBitsPerPixel(imageFormat)) / 8;
        }

        public String toString() {
            return this.width + "x" + this.height + "@" + this.framerate;
        }

        public boolean equals(Object other) {
            if (!(other instanceof CaptureFormat)) {
                return false;
            }
            CaptureFormat captureFormat = (CaptureFormat) other;
            return this.width == captureFormat.width && this.height == captureFormat.height && this.framerate.equals(captureFormat.framerate);
        }

        public int hashCode() {
            return (((this.width * 65497) + this.height) * MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR) + 1 + this.framerate.hashCode();
        }
    }

    /* loaded from: classes7.dex */
    private static abstract class ClosestComparator<T> implements Comparator<T> {
        abstract int diff(T supportedParameter);

        private ClosestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(T t1, T t2) {
            return diff(t1) - diff(t2);
        }
    }

    public static CaptureFormat.FramerateRange getClosestSupportedFramerateRange(List<CaptureFormat.FramerateRange> supportedFramerates, final int requestedFps) {
        return (CaptureFormat.FramerateRange) Collections.min(supportedFramerates, new ClosestComparator<CaptureFormat.FramerateRange>() { // from class: com.ss.bytertc.base.media.camera.CameraEnumerationAndroid.1
            private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
            private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
            private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
            private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
            private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
            private static final int MIN_FPS_THRESHOLD = 8000;

            private int progressivePenalty(int value, int threshold, int lowWeight, int highWeight) {
                if (value < threshold) {
                    return value * lowWeight;
                }
                return ((value - threshold) * highWeight) + (lowWeight * threshold);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.ss.bytertc.base.media.camera.CameraEnumerationAndroid.ClosestComparator
            public int diff(CaptureFormat.FramerateRange range) {
                return progressivePenalty(Math.abs((requestedFps * 1000) - range.min), 5000, 1, 3) + progressivePenalty(Math.abs((requestedFps * 1000) - range.max), 5000, 1, 3);
            }
        });
    }

    public static Size getClosestSupportedSize(List<Size> supportedSizes, final int requestedWidth, final int requestedHeight) {
        return (Size) Collections.min(supportedSizes, new ClosestComparator<Size>() { // from class: com.ss.bytertc.base.media.camera.CameraEnumerationAndroid.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.ss.bytertc.base.media.camera.CameraEnumerationAndroid.ClosestComparator
            public int diff(Size size) {
                return Math.abs(requestedWidth - size.width) + Math.abs(requestedHeight - size.height);
            }
        });
    }

    public static Size getUpClosestSupportedSize(List<Size> supportedSizes, final int requestedWidth, final int requestedHeight) {
        int abs;
        Size size = new Size(0, 0);
        int i = Integer.MAX_VALUE;
        boolean z = false;
        for (int i2 = 0; i2 < supportedSizes.size(); i2++) {
            Size size2 = supportedSizes.get(i2);
            if (size2.width >= requestedWidth && (abs = Math.abs(requestedWidth - size2.width) + Math.abs(requestedHeight - size2.height)) <= i) {
                z = true;
                size = size2;
                i = abs;
            }
        }
        return !z ? getClosestSupportedSize(supportedSizes, requestedWidth, requestedHeight) : size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportCameraResolution(Histogram histogram, Size resolution) {
        histogram.addSample(COMMON_RESOLUTIONS.indexOf(resolution) + 1);
    }
}
