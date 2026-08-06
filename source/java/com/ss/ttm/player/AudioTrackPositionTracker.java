package com.ss.ttm.player;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.ss.ttm.utils.Util;
import java.lang.reflect.Method;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes7.dex */
final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private AudioTimestampPoller audioTimestampPoller;
    private AudioTrack audioTrack;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastRawPlaybackHeadPosition;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    /* loaded from: classes7.dex */
    public interface Listener {
        void onInvalidLatency(long latencyUs);

        void onPositionFramesMismatch(long audioTimestampPositionFrames, long audioTimestampSystemTimeUs, long systemTimeUs, long playbackPositionUs);

        void onSystemTimeUsMismatch(long audioTimestampPositionFrames, long audioTimestampSystemTimeUs, long systemTimeUs, long playbackPositionUs);

        void onUnderrun(int bufferSize, long bufferSizeMs);
    }

    public static boolean isEncodingLinearPcm(int encoding) {
        return encoding == 3 || encoding == 2 || encoding == Integer.MIN_VALUE || encoding == 1073741824 || encoding == 4;
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.listener = listener;
        if (Util.SDK_INT >= 18) {
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.playheadOffsets = new long[10];
    }

    public void setAudioTrack(AudioTrack audioTrack, int outputEncoding, int outputPcmFrameSize, int bufferSize) {
        this.audioTrack = audioTrack;
        this.outputPcmFrameSize = outputPcmFrameSize;
        this.bufferSize = bufferSize;
        this.audioTimestampPoller = new AudioTimestampPoller(audioTrack);
        this.outputSampleRate = audioTrack.getSampleRate();
        this.needsPassthroughWorkarounds = needsPassthroughWorkarounds(outputEncoding);
        boolean isEncodingLinearPcm = isEncodingLinearPcm(outputEncoding);
        this.isOutputPcm = isEncodingLinearPcm;
        this.bufferSizeUs = isEncodingLinearPcm ? framesToDurationUs(bufferSize / outputPcmFrameSize) : -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.rawPlaybackHeadWrapCount = 0L;
        this.passthroughWorkaroundPauseOffset = 0L;
        this.hasData = false;
        this.stopTimestampUs = -9223372036854775807L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.latencyUs = 0L;
    }

    public long getCurrentPositionUs(boolean sourceEnded) {
        long j;
        if (this.audioTrack.getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        AudioTimestampPoller audioTimestampPoller = this.audioTimestampPoller;
        if (audioTimestampPoller.hasTimestamp()) {
            long framesToDurationUs = framesToDurationUs(audioTimestampPoller.getTimestampPositionFrames());
            return !audioTimestampPoller.isTimestampAdvancing() ? framesToDurationUs : framesToDurationUs + (nanoTime - audioTimestampPoller.getTimestampSystemTimeUs());
        }
        if (this.playheadOffsetCount == 0) {
            j = getPlaybackHeadPositionUs();
        } else {
            j = nanoTime + this.smoothedPlayheadOffsetUs;
        }
        return !sourceEnded ? j - this.latencyUs : j;
    }

    public void start() {
        this.audioTimestampPoller.reset();
    }

    public boolean isPlaying() {
        return this.audioTrack.getPlayState() == 3;
    }

    public boolean mayHandleBuffer(long writtenFrames) {
        Listener listener;
        int playState = this.audioTrack.getPlayState();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2) {
                this.hasData = false;
                return false;
            }
            if (playState == 1 && getPlaybackHeadPosition() == 0) {
                return false;
            }
        }
        boolean z = this.hasData;
        boolean hasPendingData = hasPendingData(writtenFrames);
        this.hasData = hasPendingData;
        if (z && !hasPendingData && playState != 1 && (listener = this.listener) != null) {
            listener.onUnderrun(this.bufferSize, this.bufferSizeUs / 1000);
        }
        return true;
    }

    public int getAvailableBufferSize(long writtenBytes) {
        return this.bufferSize - ((int) (writtenBytes - (getPlaybackHeadPosition() * this.outputPcmFrameSize)));
    }

    public boolean isStalled(long writtenFrames) {
        return this.forceResetWorkaroundTimeMs != -9223372036854775807L && writtenFrames > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= 200;
    }

    public void handleEndOfStream(long writtenFrames) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = writtenFrames;
    }

    public boolean hasPendingData(long writtenFrames) {
        return writtenFrames > getPlaybackHeadPosition() || forceHasPendingData();
    }

    public boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs != -9223372036854775807L) {
            return false;
        }
        this.audioTimestampPoller.reset();
        return true;
    }

    public void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    private void maybeSampleSyncParams() {
        long playbackHeadPositionUs = getPlaybackHeadPositionUs();
        if (playbackHeadPositionUs == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
            long[] jArr = this.playheadOffsets;
            int i = this.nextPlayheadOffsetIndex;
            jArr[i] = playbackHeadPositionUs - nanoTime;
            this.nextPlayheadOffsetIndex = (i + 1) % 10;
            int i2 = this.playheadOffsetCount;
            if (i2 < 10) {
                this.playheadOffsetCount = i2 + 1;
            }
            this.lastPlayheadSampleTimeUs = nanoTime;
            this.smoothedPlayheadOffsetUs = 0L;
            int i3 = 0;
            while (true) {
                int i4 = this.playheadOffsetCount;
                if (i3 >= i4) {
                    break;
                }
                this.smoothedPlayheadOffsetUs += this.playheadOffsets[i3] / i4;
                i3++;
            }
        }
        if (this.needsPassthroughWorkarounds) {
            return;
        }
        maybePollAndCheckTimestamp(nanoTime, playbackHeadPositionUs);
        maybeUpdateLatency(nanoTime);
    }

    private void maybePollAndCheckTimestamp(long systemTimeUs, long playbackPositionUs) {
        AudioTimestampPoller audioTimestampPoller = this.audioTimestampPoller;
        if (audioTimestampPoller == null || !audioTimestampPoller.maybePollTimestamp(systemTimeUs)) {
            return;
        }
        long timestampSystemTimeUs = audioTimestampPoller.getTimestampSystemTimeUs();
        long timestampPositionFrames = audioTimestampPoller.getTimestampPositionFrames();
        if (Math.abs(timestampSystemTimeUs - systemTimeUs) > 5000000) {
            Listener listener = this.listener;
            if (listener != null) {
                listener.onSystemTimeUsMismatch(timestampPositionFrames, timestampSystemTimeUs, systemTimeUs, playbackPositionUs);
            }
            audioTimestampPoller.rejectTimestamp();
            return;
        }
        if (Math.abs(framesToDurationUs(timestampPositionFrames) - playbackPositionUs) > 5000000) {
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onPositionFramesMismatch(timestampPositionFrames, timestampSystemTimeUs, systemTimeUs, playbackPositionUs);
            }
            audioTimestampPoller.rejectTimestamp();
            return;
        }
        audioTimestampPoller.acceptTimestamp();
    }

    private void maybeUpdateLatency(long systemTimeUs) {
        Method method;
        if (!this.isOutputPcm || (method = this.getLatencyMethod) == null || systemTimeUs - this.lastLatencySampleTimeUs < 500000) {
            return;
        }
        try {
            long intValue = (((Integer) method.invoke(this.audioTrack, new Object[0])).intValue() * 1000) - this.bufferSizeUs;
            this.latencyUs = intValue;
            long max = Math.max(intValue, 0L);
            this.latencyUs = max;
            if (max > 5000000) {
                Listener listener = this.listener;
                if (listener != null) {
                    listener.onInvalidLatency(max);
                }
                this.latencyUs = 0L;
            }
        } catch (Exception unused) {
            this.getLatencyMethod = null;
        }
        this.lastLatencySampleTimeUs = systemTimeUs;
    }

    private long framesToDurationUs(long frameCount) {
        return (frameCount * 1000000) / this.outputSampleRate;
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0L;
    }

    private boolean forceHasPendingData() {
        return this.needsPassthroughWorkarounds && this.audioTrack.getPlayState() == 2 && getPlaybackHeadPosition() == 0;
    }

    private static boolean needsPassthroughWorkarounds(int outputEncoding) {
        return Util.SDK_INT < 23 && (outputEncoding == 5 || outputEncoding == 6);
    }

    private long getPlaybackHeadPositionUs() {
        return framesToDurationUs(getPlaybackHeadPosition());
    }

    private long getPlaybackHeadPosition() {
        int playState;
        AudioTrack audioTrack = this.audioTrack;
        if (this.stopTimestampUs != -9223372036854775807L) {
            return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * this.outputSampleRate) / 1000000));
        }
        if (audioTrack == null || (playState = audioTrack.getPlayState()) == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & BodyPartID.bodyIdMax;
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
            }
            playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
        }
        if (Util.SDK_INT <= 28) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.rawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }
}
