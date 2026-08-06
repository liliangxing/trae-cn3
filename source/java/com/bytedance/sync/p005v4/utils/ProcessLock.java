package com.bytedance.sync.p005v4.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ProcessLock {
    private static final Map<String, Lock> mProcessLocksHashMap = new HashMap();
    private FileLock mProcessFileLock;
    private FileChannel mProcessFileLockChannel;
    private final File mProcessLockFile;
    private final Lock mProcessLockObj;

    public ProcessLock(String str, File file) {
        File file2 = new File(file, str + ".lck");
        this.mProcessLockFile = file2;
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable unused) {
            }
        }
        if (this.mProcessLockFile.exists()) {
            Map<String, Lock> map = mProcessLocksHashMap;
            synchronized (map) {
                String absolutePath = this.mProcessLockFile.getAbsolutePath();
                Lock lock = map.get(absolutePath);
                if (lock == null) {
                    lock = new ReentrantLock();
                    map.put(absolutePath, lock);
                }
                this.mProcessLockObj = lock;
            }
            return;
        }
        this.mProcessLockObj = null;
    }

    public boolean processLockOk() {
        return this.mProcessLockObj != null;
    }

    public void processLock() {
        try {
            File parentFile = this.mProcessLockFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(this.mProcessLockFile).getChannel();
            this.mProcessFileLockChannel = channel;
            this.mProcessFileLock = channel.lock();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to grab file lock.", e);
        }
    }

    public boolean tryProcessLock() {
        this.mProcessLockObj.lock();
        try {
            File parentFile = this.mProcessLockFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(this.mProcessLockFile).getChannel();
            this.mProcessFileLockChannel = channel;
            FileLock tryLock = channel.tryLock();
            this.mProcessFileLock = tryLock;
            return tryLock != null;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to grab file lock.", e);
        }
    }

    public void unProcessLock() {
        FileChannel fileChannel = this.mProcessFileLockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
                this.mProcessFileLock = null;
            } catch (IOException unused) {
            }
        }
        this.mProcessLockObj.unlock();
    }
}
