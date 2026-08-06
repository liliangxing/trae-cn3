package com.ss.ttm.player;

import android.media.AudioTrack;
import com.ss.ttm.utils.AVLogger;

/* loaded from: classes7.dex */
public class AudioLatencyTuner {
    private static final int STATE_LOWERING = 1;
    private static final int STATE_PRIMING = 0;
    private static final int STATE_RAISING = 2;
    private static final int STATE_STABLE = 3;
    private static final String TAG = "AudioLatencyTuner";
    private float mSuggestedInitialSizeRate = 1.0f;
    private boolean mEnableInitialSizeAdaptFrameSize = false;
    private AudioTrack mAudioTrack = null;
    private int mOutputPcmFrameSize = 0;
    private int mInitialSize = 0;
    private int mActualSize = 0;
    private float mActualSizeRate = 1.0f;
    private boolean mEnableChangeSize = false;
    private int mChangeSizeRate = 2;
    private boolean mEnableAutoUpdateSize = false;
    private int mFramesPerBlock = 64;
    private int mPrimingThreshold = 8;
    private int mState = 0;
    private int mPreviousUnderrunCount = 0;
    private int mStableStopUpdateThresh = 0;
    private int mAutoUpdateSizeStableNum = 0;
    private int mGlobalUpdateSizeMode = 0;
    private boolean mAudioTrackWillBlock = true;
    private int mAudioTrackBlockCount = 0;
    private int mMinTrackSize = 0;
    private boolean[] mHistoryUnderRunRise = {false, false};

    public AudioLatencyTuner() {
        AVLogger.Debug(TAG, this, "AudioLatencyTuner log: Construct AudioLatencyTuner");
    }

    public void setIntOption(int key, int value) {
        if (key == 10) {
            this.mEnableInitialSizeAdaptFrameSize = value > 0;
            return;
        }
        switch (key) {
            case 13:
                this.mEnableChangeSize = value > 0;
                return;
            case 14:
                this.mChangeSizeRate = value;
                return;
            case 15:
                this.mEnableAutoUpdateSize = value > 0;
                return;
            case 16:
                this.mPrimingThreshold = value;
                return;
            case 17:
                this.mStableStopUpdateThresh = value;
                return;
            case 18:
                this.mGlobalUpdateSizeMode = value;
                return;
            default:
                return;
        }
    }

    public void setFloatOption(int key, float value) {
        if (key == 11) {
            this.mSuggestedInitialSizeRate = value;
        } else {
            if (key != 12) {
                return;
            }
            this.mActualSizeRate = value;
        }
    }

    public int getSuggestedInitialSize(int sampleRateInHz, int channelConfig, int audioFormat, int frameSizeInBytes) {
        int minBufferSize = AudioTrack.getMinBufferSize(sampleRateInHz, channelConfig, audioFormat);
        this.mMinTrackSize = minBufferSize;
        int i = (int) (minBufferSize * this.mSuggestedInitialSizeRate);
        this.mInitialSize = i;
        if (this.mEnableInitialSizeAdaptFrameSize) {
            this.mInitialSize = ((i / frameSizeInBytes) + 1) * frameSizeInBytes;
        }
        AVLogger.Debug(TAG, this, "AudioLatencyTuner log: return initialSize:" + this.mInitialSize + ", mMinTrackSize:" + this.mMinTrackSize);
        return this.mInitialSize;
    }

    public int updateAudioTrack(AudioTrack audioTrack, int outputPcmFrameSize) {
        if (audioTrack == null) {
            return -1;
        }
        this.mAudioTrack = audioTrack;
        this.mOutputPcmFrameSize = outputPcmFrameSize;
        int value = TTPlayerConfiger.getValue(74, 0);
        if (this.mGlobalUpdateSizeMode > 0 && value > 0) {
            this.mActualSize = this.mAudioTrack.setBufferSizeInFrames(value / this.mOutputPcmFrameSize) * this.mOutputPcmFrameSize;
            if (this.mGlobalUpdateSizeMode == 2) {
                this.mState = 3;
            }
        } else {
            this.mActualSize = this.mAudioTrack.setBufferSizeInFrames((int) ((this.mInitialSize * this.mActualSizeRate) / this.mOutputPcmFrameSize)) * this.mOutputPcmFrameSize;
        }
        AVLogger.Debug(TAG, this, "AudioLatencyTuner log: update audioTrack:" + this.mAudioTrack + ", actualSize:" + this.mActualSize);
        return this.mActualSize;
    }

    public int update(int availableSize, long writeCostTime) {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null) {
            return this.mActualSize;
        }
        int i = 1;
        boolean z = this.mAudioTrackWillBlock || writeCostTime >= 5;
        if (z) {
            this.mAudioTrackBlockCount++;
        }
        this.mAudioTrackWillBlock = availableSize <= 256 && availableSize >= 0;
        if (this.mEnableChangeSize && this.mAudioTrackBlockCount > this.mChangeSizeRate) {
            int i2 = this.mActualSize;
            int i3 = this.mMinTrackSize;
            if (i2 != i3) {
                this.mActualSize = audioTrack.setBufferSizeInFrames(i3 / this.mOutputPcmFrameSize) * this.mOutputPcmFrameSize;
                this.mEnableChangeSize = false;
                AVLogger.Debug(TAG, this, "AudioLatencyTuner log: SizeHasChanged:" + this.mActualSize);
            }
        }
        if (this.mEnableAutoUpdateSize && z) {
            int i4 = this.mState;
            if (i4 == 0) {
                if (this.mAudioTrackBlockCount > this.mPrimingThreshold) {
                    this.mPreviousUnderrunCount = this.mAudioTrack.getUnderrunCount();
                    this.mState = i;
                }
                i = i4;
                this.mState = i;
            } else {
                if (i4 != 1) {
                    if (i4 == 2) {
                        int underrunCount = this.mAudioTrack.getUnderrunCount();
                        if (underrunCount > this.mPreviousUnderrunCount) {
                            boolean[] zArr = this.mHistoryUnderRunRise;
                            if (zArr[0] || zArr[1]) {
                                incrementThreshold(3);
                            }
                            this.mAutoUpdateSizeStableNum = 0;
                            boolean[] zArr2 = this.mHistoryUnderRunRise;
                            zArr2[0] = zArr2[1];
                            zArr2[1] = true;
                        } else {
                            int i5 = this.mAutoUpdateSizeStableNum + 1;
                            this.mAutoUpdateSizeStableNum = i5;
                            boolean[] zArr3 = this.mHistoryUnderRunRise;
                            zArr3[0] = zArr3[1];
                            zArr3[1] = false;
                            int i6 = this.mStableStopUpdateThresh;
                            if (i6 > 0 && i5 > i6) {
                                AVLogger.Debug(TAG, this, "AudioLatencyTuner log: update size stable:" + this.mActualSize + ", underRunCount:" + underrunCount);
                                i = 3;
                                this.mPreviousUnderrunCount = underrunCount;
                            }
                        }
                        i = i4;
                        this.mPreviousUnderrunCount = underrunCount;
                    }
                    i = i4;
                } else {
                    int underrunCount2 = this.mAudioTrack.getUnderrunCount();
                    if (underrunCount2 > this.mPreviousUnderrunCount) {
                        boolean[] zArr4 = this.mHistoryUnderRunRise;
                        if (zArr4[0] || zArr4[1]) {
                            incrementThreshold(3);
                            i4 = 2;
                        }
                        boolean[] zArr5 = this.mHistoryUnderRunRise;
                        zArr5[0] = zArr5[1];
                        zArr5[1] = true;
                    } else {
                        boolean[] zArr6 = this.mHistoryUnderRunRise;
                        if (!zArr6[0] && !zArr6[1] && incrementThreshold(-1)) {
                            i4 = 2;
                        }
                        boolean[] zArr7 = this.mHistoryUnderRunRise;
                        zArr7[0] = zArr7[1];
                        zArr7[1] = false;
                    }
                    i = i4;
                    this.mPreviousUnderrunCount = underrunCount2;
                }
                this.mState = i;
            }
        } else if (this.mActualSize < this.mMinTrackSize && z) {
            int underrunCount3 = this.mAudioTrack.getUnderrunCount();
            if (underrunCount3 > this.mPreviousUnderrunCount) {
                boolean[] zArr8 = this.mHistoryUnderRunRise;
                if (zArr8[0] || zArr8[1]) {
                    this.mActualSize = this.mAudioTrack.setBufferSizeInFrames(this.mMinTrackSize / this.mOutputPcmFrameSize) * this.mOutputPcmFrameSize;
                    AVLogger.Debug(TAG, this, "AudioLatencyTuner log: SizeHasChanged:" + this.mActualSize + ", underRunCount:" + underrunCount3);
                }
                boolean[] zArr9 = this.mHistoryUnderRunRise;
                zArr9[0] = zArr9[1];
                zArr9[1] = true;
            } else {
                boolean[] zArr10 = this.mHistoryUnderRunRise;
                zArr10[0] = zArr10[1];
                zArr10[1] = false;
            }
            this.mPreviousUnderrunCount = underrunCount3;
        }
        return this.mActualSize;
    }

    private boolean incrementThreshold(int deltaBlocks) {
        int bufferSizeInFrames = this.mAudioTrack.getBufferSizeInFrames();
        int i = this.mFramesPerBlock;
        this.mActualSize = this.mAudioTrack.setBufferSizeInFrames(((bufferSizeInFrames / i) + deltaBlocks) * i) * this.mOutputPcmFrameSize;
        AVLogger.Debug(TAG, this, "AudioLatencyTuner log: Buffer size changed from " + (this.mOutputPcmFrameSize * bufferSizeInFrames) + " to " + this.mActualSize);
        return this.mActualSize == bufferSizeInFrames * this.mOutputPcmFrameSize;
    }

    public void close() {
        if (this.mGlobalUpdateSizeMode > 0 && this.mState == 3) {
            TTPlayerConfiger.setValue(74, this.mActualSize);
        }
        this.mAudioTrack = null;
    }
}
