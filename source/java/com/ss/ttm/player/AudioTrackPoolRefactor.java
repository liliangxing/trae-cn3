package com.ss.ttm.player;

import android.media.AudioTrack;
import com.ss.ttm.utils.AVLogger;
import com.ss.vcbkit.ResourcePool;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class AudioTrackPoolRefactor extends ResourcePool {
    private static final int DEFAULT_POOL_SIZE = 3;
    private static final int REASON_DISABLE_POOL = 1;
    private static final int REASON_EMPTY_POOL = 2;
    private static final int REASON_PARA_NOT_MATCH = 3;
    private static final int REASON_STATE_ERROR = 4;
    private static final long RESOURCE_POOL_ID = (ResourcePool.Type.Voice << 48) | 1;
    private static final int S_FAIL = -1;
    private static final int S_OK = 0;
    private static final String TAG = "AudioTrackPoolRefactor";
    private static volatile AudioTrackPoolRefactor instance;
    private ScheduledExecutorService mExpireExecutor;
    private AtomicInteger trackPoolSizeLimit = new AtomicInteger(TTPlayerConfiger.getValue(47, 3));
    private Queue<AudioTrackBufferRefactor> trackPool = new LinkedBlockingQueue();
    private int mCheckIntervalMs = TTPlayerConfiger.getValue(82, 30000);
    private int mMaxUsedCount = TTPlayerConfiger.getValue(50, 20);
    private int mMaxSameCount = TTPlayerConfiger.getValue(89, 0);

    private AudioTrackPoolRefactor() {
        int i;
        setMaxSize(this.trackPoolSizeLimit.get());
        boolean z = TTPlayerConfiger.getValue(81, 0) != 0;
        if (z && (i = this.mCheckIntervalMs) > 0) {
            updateExpireCheckInterval(i);
        }
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: maxUsedCount:" + this.mMaxUsedCount + ", poolSize:" + this.trackPoolSizeLimit.get() + ", needCheckExpire:" + z + ", checkIntervalMs:" + this.mCheckIntervalMs + ", maxSameCount:" + this.mMaxSameCount);
    }

    public static AudioTrackPoolRefactor getInstance() {
        if (instance == null) {
            synchronized (AudioTrackPoolRefactor.class) {
                if (instance == null) {
                    instance = new AudioTrackPoolRefactor();
                }
            }
        }
        return instance;
    }

    @Override // com.ss.vcbkit.ResourcePool
    public long getId() {
        return RESOURCE_POOL_ID;
    }

    @Override // com.ss.vcbkit.ResourcePool
    public boolean setPoolConfig(int key, int arg1, Object arg2) {
        switch (key) {
            case 1001:
                updatePoolSize(arg1);
                return true;
            case 1002:
                updateExpireCheckInterval(arg1);
                return true;
            case 1003:
                preCreate(arg1);
                return true;
            case 1004:
                shrinkAudioTrack(arg1);
                return true;
            default:
                return false;
        }
    }

    private synchronized void updateExpireCheckInterval(int intervalMs) {
        this.mCheckIntervalMs = intervalMs;
        if (intervalMs <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.mExpireExecutor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.mExpireExecutor = null;
            }
            return;
        }
        if (this.mExpireExecutor == null) {
            this.mExpireExecutor = Executors.newSingleThreadScheduledExecutor();
            Runnable runnable = new Runnable() { // from class: com.ss.ttm.player.AudioTrackPoolRefactor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AudioTrackPoolRefactor.this.checkExpireThreadPeriod();
                }
            };
            ScheduledExecutorService scheduledExecutorService2 = this.mExpireExecutor;
            int i = this.mCheckIntervalMs;
            scheduledExecutorService2.scheduleWithFixedDelay(runnable, i, i, TimeUnit.MILLISECONDS);
        }
    }

    private long getResourceId(AudioTrack audioTrack) {
        if (audioTrack == null) {
            return 0L;
        }
        return System.identityHashCode(audioTrack);
    }

    private void updatePoolSize(int size) {
        if (size >= 0) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: update pool size:" + size);
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            this.trackPoolSizeLimit.set(size);
            setMaxSize(size);
            synchronized (this) {
                while (this.trackPool.size() > size) {
                    linkedBlockingQueue.offer(this.trackPool.peek());
                    this.trackPool.poll();
                }
            }
            while (!linkedBlockingQueue.isEmpty()) {
                AudioTrack audioTrack = ((AudioTrackBufferRefactor) linkedBlockingQueue.poll()).AudioTrack;
                if (audioTrack != null) {
                    releaseAudioTrack(audioTrack);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkExpireThreadPeriod() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            while (!this.trackPool.isEmpty() && currentTimeMillis - this.trackPool.peek().mFreeTimePoint > this.mCheckIntervalMs) {
                linkedBlockingQueue.offer(this.trackPool.peek());
                this.trackPool.poll();
            }
        }
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: exist audioTrack after check expire:" + this.trackPool.size() + ", clean size:" + linkedBlockingQueue.size());
        while (!linkedBlockingQueue.isEmpty()) {
            AudioTrack audioTrack = ((AudioTrackBufferRefactor) linkedBlockingQueue.poll()).AudioTrack;
            if (audioTrack != null) {
                releaseAudioTrack(audioTrack);
            }
        }
    }

    private void shrinkAudioTrack(int size) {
        int size2;
        if (size <= 0) {
            return;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        synchronized (this) {
            size2 = this.trackPool.size();
            for (int i = size; !this.trackPool.isEmpty() && i > 0; i--) {
                linkedBlockingQueue.offer(this.trackPool.peek());
                this.trackPool.poll();
            }
        }
        AVLogger.InfoTrackLife(TAG, this, "shrinkAudioTrack, size:" + size + ", origin size:" + size2 + ", current size:" + this.trackPool.size());
        while (!linkedBlockingQueue.isEmpty()) {
            AudioTrack audioTrack = ((AudioTrackBufferRefactor) linkedBlockingQueue.poll()).AudioTrack;
            if (audioTrack != null) {
                releaseAudioTrack(audioTrack);
            }
        }
    }

    private void releaseAudioTrack(final AudioTrack audioTrack) {
        if (audioTrack != null) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: release AudioTrack task:" + audioTrack);
            onItemDestroy(getResourceId(audioTrack));
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AudioTrackPoolRefactor.1
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

    private AudioTrackBufferRefactor createAudioTrack(AudioTrackBufferRefactor buffer) {
        try {
            if (buffer.trackBufferSize <= 0) {
                buffer.trackBufferSize = AudioTrack.getMinBufferSize(buffer.sampleRate, buffer.channelsLayout, buffer.audioFormat);
            }
            buffer.AudioTrack = new AudioTrack(buffer.streamType, buffer.sampleRate, buffer.channelsLayout, buffer.audioFormat, buffer.trackBufferSize, 1);
            onItemCreate(getResourceId(buffer.AudioTrack));
        } catch (Throwable th) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: create audiotrack fail: " + th);
        }
        return buffer;
    }

    public void preCreate(final int size) {
        if (size <= 0) {
            return;
        }
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: start pre create audioTrack, size:" + size);
        Runnable runnable = new Runnable() { // from class: com.ss.ttm.player.AudioTrackPoolRefactor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AudioTrackPoolRefactor.this.m9514lambda$preCreate$0$comssttmplayerAudioTrackPoolRefactor(size);
            }
        };
        if (TTPlayerConfiger.getValue(91, 0) > 0) {
            AVThreadPool.addTask(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$preCreate$0$com-ss-ttm-player-AudioTrackPoolRefactor, reason: not valid java name */
    public /* synthetic */ void m9514lambda$preCreate$0$comssttmplayerAudioTrackPoolRefactor(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            AudioTrackBufferRefactor createAudioTrack = createAudioTrack(new AudioTrackBufferRefactor(null, 3, 44100, 12, 2, 2048, 0, 0));
            if (createAudioTrack.AudioTrack != null && createAudioTrack.AudioTrack.getState() == 1 && (pushAudioTrackBack(createAudioTrack, 1.0f, false) != 0 || this.trackPool.size() >= this.trackPoolSizeLimit.get())) {
                return;
            }
        }
    }

    public synchronized int getPoolSize() {
        return this.trackPool.size();
    }

    public AudioTrackBufferRefactor getReuseAudioTrack(AudioTrackBufferRefactor initBuffer) {
        AudioTrackBufferRefactor audioTrackBufferRefactor;
        if (this.trackPool.isEmpty()) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: trackPool is empty!");
            initBuffer.reuseFailReason = 2;
            return createAudioTrack(initBuffer);
        }
        synchronized (this) {
            Iterator<AudioTrackBufferRefactor> it = this.trackPool.iterator();
            AudioTrackBufferRefactor audioTrackBufferRefactor2 = null;
            audioTrackBufferRefactor = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AudioTrackBufferRefactor next = it.next();
                if (next.streamType == initBuffer.streamType && next.sampleRate == initBuffer.sampleRate && next.channelsLayout == initBuffer.channelsLayout && next.audioFormat == initBuffer.audioFormat) {
                    if (next.frameSamples == initBuffer.frameSamples) {
                        this.trackPool.remove(next);
                        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: find best-matched AudioTrack:" + next.AudioTrack);
                        audioTrackBufferRefactor2 = next;
                        break;
                    }
                    audioTrackBufferRefactor = next;
                }
            }
            if (audioTrackBufferRefactor2 != null || audioTrackBufferRefactor == null) {
                audioTrackBufferRefactor = audioTrackBufferRefactor2;
            } else {
                this.trackPool.remove(audioTrackBufferRefactor);
                AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: find find sampleNumber-unmatched AudioTrack:" + audioTrackBufferRefactor.AudioTrack);
            }
        }
        if (audioTrackBufferRefactor != null) {
            int playState = audioTrackBufferRefactor.AudioTrack.getPlayState();
            if (playState == 2 || playState == 1) {
                onItemAcquire(getResourceId(audioTrackBufferRefactor.AudioTrack));
                return audioTrackBufferRefactor;
            }
            releaseAudioTrack(audioTrackBufferRefactor.AudioTrack);
            initBuffer.reuseFailReason = 4;
        } else {
            initBuffer.reuseFailReason = 3;
        }
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: find best-matched AudioTrack fail");
        return createAudioTrack(initBuffer);
    }

    public int pushAudioTrackBack(AudioTrackBufferRefactor audioTrackBuffer, float volume, boolean forceRelease) {
        if (audioTrackBuffer == null || audioTrackBuffer.AudioTrack == null) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: audioTrack is null!");
            return -1;
        }
        AudioTrack audioTrack = null;
        if (forceRelease) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: force release audiotrack.");
            releaseAudioTrack(audioTrackBuffer.AudioTrack);
            audioTrackBuffer.AudioTrack = null;
            return -1;
        }
        audioTrackBuffer.usedCount++;
        if (audioTrackBuffer.usedCount > this.mMaxUsedCount) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: usedCount > maxUsedCount.");
            releaseAudioTrack(audioTrackBuffer.AudioTrack);
            audioTrackBuffer.AudioTrack = null;
            return -1;
        }
        int playState = audioTrackBuffer.AudioTrack.getPlayState();
        if (playState != 2 && playState != 1) {
            audioTrackBuffer.AudioTrack.pause();
        }
        audioTrackBuffer.AudioTrack.flush();
        if (volume != 1.0f) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: reset volume, before: " + volume);
            audioTrackBuffer.AudioTrack.setVolume(1.0f);
        }
        synchronized (this) {
            int i = 0;
            for (AudioTrackBufferRefactor audioTrackBufferRefactor : this.trackPool) {
                if (audioTrackBufferRefactor.streamType == audioTrackBuffer.streamType && audioTrackBufferRefactor.sampleRate == audioTrackBuffer.sampleRate && audioTrackBufferRefactor.channelsLayout == audioTrackBuffer.channelsLayout && audioTrackBufferRefactor.audioFormat == audioTrackBuffer.audioFormat && audioTrackBufferRefactor.frameSamples == audioTrackBuffer.frameSamples && (i = i + 1) > this.mMaxSameCount) {
                    AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: the same audioTrack is more than mMaxSameCount.");
                    releaseAudioTrack(audioTrackBuffer.AudioTrack);
                    audioTrackBuffer.AudioTrack = null;
                    return -1;
                }
            }
            if (this.trackPool.size() < this.trackPoolSizeLimit.get()) {
                if (this.trackPool.offer(audioTrackBuffer)) {
                    audioTrackBuffer.resetFreeTimePoint();
                    onItemRecycle(getResourceId(audioTrackBuffer.AudioTrack));
                    AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: pushback AudioTrack success! AudioTrack: " + audioTrackBuffer.AudioTrack + ", poolSize: " + this.trackPool.size() + ", usedCount:" + audioTrackBuffer.usedCount + ", sameCount:" + i);
                }
            } else {
                audioTrack = this.trackPool.poll().AudioTrack;
                if (this.trackPool.offer(audioTrackBuffer)) {
                    audioTrackBuffer.resetFreeTimePoint();
                    onItemRecycle(getResourceId(audioTrackBuffer.AudioTrack));
                    AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: pushback AudioTrack success after poll! AudioTrack: " + audioTrackBuffer.AudioTrack + ", poolSize: " + this.trackPool.size() + ", usedCount:" + audioTrackBuffer.usedCount + ", sameCount:" + i);
                }
            }
            if (audioTrack != null) {
                releaseAudioTrack(audioTrack);
            }
            return 0;
        }
    }
}
