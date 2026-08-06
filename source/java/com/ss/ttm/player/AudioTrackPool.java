package com.ss.ttm.player;

import android.media.AudioTrack;
import com.ss.ttm.utils.AVLogger;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public final class AudioTrackPool {
    private static final int S_FAIL = -1;
    private static final int S_OK = 0;
    private static final String TAG = "AudioTrackPool";
    private static volatile AudioTrackPool instance;
    private int mCheckIntervalMs;
    private boolean mEnableFrameSamplesCheck;
    private int mMaxSameCount;
    private AtomicInteger trackPoolSizeLimit = new AtomicInteger(3);
    private Queue<AudioTrackBuffer> trackPool = new LinkedBlockingQueue();
    private int mMaxUsedCount = TTPlayerConfiger.getValue(50, 20);

    private AudioTrackPool() {
        this.mCheckIntervalMs = 30000;
        this.mEnableFrameSamplesCheck = TTPlayerConfiger.getValue(51, 0) != 0;
        this.mMaxSameCount = TTPlayerConfiger.getValue(89, 0);
        setAudioTrackPoolSize(TTPlayerConfiger.getValue(47, 3));
        boolean z = TTPlayerConfiger.getValue(81, 0) != 0;
        int value = TTPlayerConfiger.getValue(82, 30000);
        this.mCheckIntervalMs = value;
        if (z && value > 0) {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            Runnable runnable = new Runnable() { // from class: com.ss.ttm.player.AudioTrackPool$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AudioTrackPool.this.checkExpireThreadPeriod();
                }
            };
            int i = this.mCheckIntervalMs;
            newScheduledThreadPool.scheduleWithFixedDelay(runnable, i, i, TimeUnit.MILLISECONDS);
        }
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: maxUsedCount:" + this.mMaxUsedCount + ", poolSize:" + this.trackPoolSizeLimit.get() + ", needCheckExpire:" + z + ", checkIntervalMs:" + this.mCheckIntervalMs + ", maxSameCount:" + this.mMaxSameCount);
    }

    public static AudioTrackPool getInstance() {
        if (instance == null) {
            synchronized (AudioTrackPool.class) {
                if (instance == null) {
                    instance = new AudioTrackPool();
                    AVLogger.d(TAG, "AudioTrackPool log: Construct AudioTrackPool!");
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkExpireThreadPeriod() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (AudioTrackPool.class) {
            while (!this.trackPool.isEmpty() && currentTimeMillis - this.trackPool.peek().mFreeTimePoint > this.mCheckIntervalMs) {
                linkedBlockingQueue.offer(this.trackPool.peek());
                this.trackPool.poll();
            }
        }
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: exist audioTrack after check expire:" + this.trackPool.size() + ", clean size:" + linkedBlockingQueue.size());
        while (!linkedBlockingQueue.isEmpty()) {
            AudioTrack audioTrack = ((AudioTrackBuffer) linkedBlockingQueue.poll()).AudioTrack;
            if (audioTrack != null) {
                releaseAudioTrack(audioTrack);
            }
        }
    }

    public AudioTrackBuffer getReuseAudioTrack(int streamType, int sampleRate, int channelsLayout, int audioFormat, int frameSamples) {
        AudioTrackBuffer audioTrackBuffer;
        AudioTrackBuffer audioTrackBuffer2;
        if (this.trackPool.isEmpty()) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: trackPool is empty!");
            return null;
        }
        synchronized (this) {
            Iterator<AudioTrackBuffer> it = this.trackPool.iterator();
            audioTrackBuffer = null;
            while (true) {
                if (!it.hasNext()) {
                    audioTrackBuffer2 = null;
                    break;
                }
                audioTrackBuffer2 = it.next();
                if (audioTrackBuffer2.streamType == streamType && audioTrackBuffer2.sampleRate == sampleRate && audioTrackBuffer2.channelsLayout == channelsLayout && audioTrackBuffer2.audioFormat == audioFormat) {
                    if (audioTrackBuffer2.frameSamples == frameSamples) {
                        this.trackPool.remove(audioTrackBuffer2);
                        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: find best-matched AudioTrack:" + audioTrackBuffer2.AudioTrack);
                        break;
                    }
                    audioTrackBuffer = audioTrackBuffer2;
                }
            }
            if (audioTrackBuffer2 != null || audioTrackBuffer == null) {
                audioTrackBuffer = audioTrackBuffer2;
            } else {
                this.trackPool.remove(audioTrackBuffer);
                AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: find find sampleNumber-unmatched AudioTrack:" + audioTrackBuffer.AudioTrack);
            }
        }
        if (audioTrackBuffer != null) {
            if (audioTrackBuffer.AudioTrack.getPlayState() == 2) {
                return audioTrackBuffer;
            }
            releaseAudioTrack(audioTrackBuffer.AudioTrack);
        }
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: find best-matched AudioTrack fail");
        return null;
    }

    public int pushAudioTrackBack(AudioTrackBuffer audioTrackBuffer, float volume) {
        AudioTrack audioTrack;
        if (audioTrackBuffer == null || audioTrackBuffer.AudioTrack == null) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: audioTrack is null!");
            return 0;
        }
        audioTrackBuffer.usedCount++;
        if (audioTrackBuffer.usedCount > this.mMaxUsedCount) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: usedCount > maxUsedCount.");
            return -1;
        }
        if (audioTrackBuffer.AudioTrack.getPlayState() != 2) {
            audioTrackBuffer.AudioTrack.pause();
        }
        audioTrackBuffer.AudioTrack.flush();
        if (volume != 1.0f) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: reset volume, before: " + volume);
            audioTrackBuffer.AudioTrack.setVolume(1.0f);
        }
        setAudioTrackPoolSize(TTPlayerConfiger.getValue(47, 3));
        synchronized (this) {
            int i = 0;
            for (AudioTrackBuffer audioTrackBuffer2 : this.trackPool) {
                if (audioTrackBuffer2.streamType == audioTrackBuffer.streamType && audioTrackBuffer2.sampleRate == audioTrackBuffer.sampleRate && audioTrackBuffer2.channelsLayout == audioTrackBuffer.channelsLayout && audioTrackBuffer2.audioFormat == audioTrackBuffer.audioFormat && audioTrackBuffer2.frameSamples == audioTrackBuffer.frameSamples && (i = i + 1) > this.mMaxSameCount) {
                    AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: pool has similarity audioTrack.");
                    return -1;
                }
            }
            if (this.trackPool.size() < this.trackPoolSizeLimit.get()) {
                if (this.trackPool.offer(audioTrackBuffer)) {
                    audioTrackBuffer.resetFreeTimePoint();
                    AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: pushback AudioTrack success! AudioTrack: " + audioTrackBuffer.AudioTrack + ", poolSize: " + this.trackPool.size() + ", usedCount:" + audioTrackBuffer.usedCount + ", sameCount:" + i);
                }
                audioTrack = null;
            } else {
                AudioTrack audioTrack2 = this.trackPool.poll().AudioTrack;
                if (this.trackPool.offer(audioTrackBuffer)) {
                    audioTrackBuffer.resetFreeTimePoint();
                    AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: pushback AudioTrack success after poll! AudioTrack: " + audioTrackBuffer.AudioTrack + ", poolSize: " + this.trackPool.size() + ", usedCount:" + audioTrackBuffer.usedCount + ", sameCount:" + i);
                }
                audioTrack = audioTrack2;
            }
            if (audioTrack != null) {
                releaseAudioTrack(audioTrack);
            }
            return 0;
        }
    }

    public void resetQueue() {
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: reset queue, size:" + this.trackPool.size());
        if (this.trackPool.isEmpty()) {
            return;
        }
        synchronized (this) {
            this.trackPool.size();
            while (!this.trackPool.isEmpty()) {
                AudioTrack audioTrack = this.trackPool.poll().AudioTrack;
                if (audioTrack != null) {
                    releaseAudioTrack(audioTrack);
                }
            }
        }
    }

    public void releaseAudioTrack(final AudioTrack audioTrack) {
        if (audioTrack != null) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: release AudioTrack task:" + audioTrack);
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AudioTrackPool.1
                    @Override // java.lang.Runnable
                    public void run() {
                        audioTrack.flush();
                        audioTrack.release();
                    }
                });
            } catch (Throwable th) {
                AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: create close thread fail: " + th);
                audioTrack.flush();
                audioTrack.release();
            }
        }
    }

    public void setAudioTrackPoolSize(int size) {
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: set audioTrack pool size:" + size);
        this.trackPoolSizeLimit.set(size);
    }

    public synchronized int getAudioTrackPoolSize() {
        return this.trackPool.size();
    }

    public void preBuild() {
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: start pre build audioTrack");
        AudioTrack audioTrack = new AudioTrack(3, 44100, 12, 2, AudioTrack.getMinBufferSize(44100, 12, 2), 1);
        if (audioTrack.getState() == 1) {
            pushAudioTrackBack(new AudioTrackBuffer(audioTrack, 3, 44100, 12, 2, 2048, 0), 1.0f);
        }
    }
}
