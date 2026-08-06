package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.ReturnStatus;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes7.dex */
public class RTCAudioDeviceManager implements IRTCAudioDeviceManager {
    private long mAudioDeviceManager;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private final ReentrantReadWriteLock mReadWriteLock;

    public RTCAudioDeviceManager(long nativeAudioDeviceManager) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mAudioDeviceManager = nativeAudioDeviceManager;
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int startAudioPlaybackDeviceTest(String testAudioFilePath, int interval) {
        int nativeStartAudioPlaybackDeviceTest;
        this.mJniReadLock.lock();
        try {
            long j = this.mAudioDeviceManager;
            if (j == -1) {
                nativeStartAudioPlaybackDeviceTest = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartAudioPlaybackDeviceTest = NativeAudioDeviceManagerFunctions.nativeStartAudioPlaybackDeviceTest(j, testAudioFilePath, interval);
            }
            return nativeStartAudioPlaybackDeviceTest;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int stopAudioPlaybackDeviceTest() {
        int nativeStopAudioPlaybackDeviceTest;
        this.mJniReadLock.lock();
        try {
            long j = this.mAudioDeviceManager;
            if (j == -1) {
                nativeStopAudioPlaybackDeviceTest = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopAudioPlaybackDeviceTest = NativeAudioDeviceManagerFunctions.nativeStopAudioPlaybackDeviceTest(j);
            }
            return nativeStopAudioPlaybackDeviceTest;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int startAudioDeviceRecordTest(int interval) {
        int nativeStartAudioDeviceRecordTest;
        this.mJniReadLock.lock();
        try {
            long j = this.mAudioDeviceManager;
            if (j == -1) {
                nativeStartAudioDeviceRecordTest = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartAudioDeviceRecordTest = NativeAudioDeviceManagerFunctions.nativeStartAudioDeviceRecordTest(j, interval);
            }
            return nativeStartAudioDeviceRecordTest;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int stopAudioDeviceRecordAndPlayTest() {
        int nativeStopAudioDeviceRecordAndPlayTest;
        this.mJniReadLock.lock();
        try {
            long j = this.mAudioDeviceManager;
            if (j == -1) {
                nativeStopAudioDeviceRecordAndPlayTest = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopAudioDeviceRecordAndPlayTest = NativeAudioDeviceManagerFunctions.nativeStopAudioDeviceRecordAndPlayTest(j);
            }
            return nativeStopAudioDeviceRecordAndPlayTest;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int stopAudioDevicePlayTest() {
        int nativeStopAudioDevicePlayTest;
        this.mJniReadLock.lock();
        try {
            long j = this.mAudioDeviceManager;
            if (j == -1) {
                nativeStopAudioDevicePlayTest = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopAudioDevicePlayTest = NativeAudioDeviceManagerFunctions.nativeStopAudioDevicePlayTest(j);
            }
            return nativeStopAudioDevicePlayTest;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            this.mAudioDeviceManager = -1L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }
}
