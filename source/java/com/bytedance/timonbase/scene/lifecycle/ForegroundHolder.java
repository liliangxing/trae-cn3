package com.bytedance.timonbase.scene.lifecycle;

import android.app.Application;
import android.os.Process;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.report.TMDataCollector;
import com.bytedance.timonbase.scene.SensesUpdateBroadcastReceiver;
import com.bytedance.timonbase.scene.config.SenseConfigManager;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForegroundHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nJ\b\u0010\u0013\u001a\u00020\rH\u0002J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/timonbase/scene/lifecycle/ForegroundHolder;", "", "()V", "TAG", "", "buffer", "Ljava/nio/MappedByteBuffer;", "fileChannel", "Ljava/nio/channels/FileChannel;", "isLocalForeground", "", "threadLock", "getForegroundState", "Lcom/bytedance/timonbase/scene/lifecycle/ForegroundState;", "init", "", "ctx", "Landroid/app/Application;", "initForeground", "readForegroundState", "setForeground", "foreground", "setForeground$timonbase_release", "syncStateByBroadcast", "pid", "", DBData.FIELD_TIME, "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ForegroundHolder {
    private static final String TAG = "ForegroundHolder";
    private static MappedByteBuffer buffer;
    private static FileChannel fileChannel;
    private static boolean isLocalForeground;
    public static final ForegroundHolder INSTANCE = new ForegroundHolder();
    private static final Object threadLock = new Object();

    private ForegroundHolder() {
    }

    public final void init(Application ctx, boolean initForeground) {
        Intrinsics.checkParameterIsNotNull(ctx, "ctx");
        isLocalForeground = initForeground;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(ctx.getFilesDir(), "foreground.status"), "rw");
            fileChannel = randomAccessFile.getChannel();
            buffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 13L);
        } catch (Exception e) {
            TMDataCollector.INSTANCE.reportException("ForegroundHolder_error", e, "ForegroundHolder init failed ", MapsKt.emptyMap(), false);
        }
    }

    private final ForegroundState readForegroundState() {
        ForegroundState foregroundState;
        synchronized (threadLock) {
            FileLock fileLock = null;
            try {
                try {
                    MappedByteBuffer mappedByteBuffer = buffer;
                    if (mappedByteBuffer == null) {
                        Intrinsics.throwNpe();
                    }
                    FileChannel fileChannel2 = fileChannel;
                    if (fileChannel2 == null) {
                        Intrinsics.throwNpe();
                    }
                    fileLock = fileChannel2.lock();
                    mappedByteBuffer.position(0);
                    int i = mappedByteBuffer.getInt();
                    byte b = mappedByteBuffer.get();
                    long j = mappedByteBuffer.getLong();
                    boolean z = true;
                    if (b != 1) {
                        z = false;
                    }
                    foregroundState = new ForegroundState(i, z, j);
                } catch (Exception e) {
                    TMDataCollector.INSTANCE.reportException("ForegroundHolder_error", e, "readForegroundState failed ", MapsKt.emptyMap(), false);
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    return new ForegroundState(Process.myPid(), false, System.currentTimeMillis());
                }
            } finally {
                if (fileLock != null) {
                    fileLock.release();
                }
            }
        }
        return foregroundState;
    }

    public final ForegroundState getForegroundState() {
        if (buffer == null || isLocalForeground) {
            return new ForegroundState(Process.myPid(), isLocalForeground, System.currentTimeMillis());
        }
        try {
            ForegroundState readForegroundState = readForegroundState();
            return new File(new StringBuilder("/proc/").append(readForegroundState.getPid()).toString()).exists() ? readForegroundState : ForegroundState.copy$default(readForegroundState, 0, false, 0L, 5, null);
        } catch (Exception e) {
            TMDataCollector.INSTANCE.reportException("ForegroundHolder_error", e, "getForegroundState failed ", MapsKt.emptyMap(), false);
            return new ForegroundState(Process.myPid(), isLocalForeground, System.currentTimeMillis());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b6, code lost:
    
        if (r3 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setForeground$timonbase_release(boolean foreground) {
        isLocalForeground = foreground;
        MappedByteBuffer mappedByteBuffer = buffer;
        if (mappedByteBuffer != null) {
            TMLogger.INSTANCE.m219d(TAG, Process.myPid() + " -> setForegroundState(" + foreground + ')');
            synchronized (threadLock) {
                FileLock fileLock = null;
                try {
                    try {
                        FileChannel fileChannel2 = fileChannel;
                        if (fileChannel2 != null) {
                            fileLock = fileChannel2.lock();
                            if (foreground) {
                                mappedByteBuffer.position(0);
                                int myPid = Process.myPid();
                                long currentTimeMillis = System.currentTimeMillis();
                                mappedByteBuffer.putInt(myPid);
                                mappedByteBuffer.put((byte) 1);
                                mappedByteBuffer.putLong(currentTimeMillis);
                                INSTANCE.syncStateByBroadcast(myPid, true, currentTimeMillis);
                            } else {
                                mappedByteBuffer.position(0);
                                int i = mappedByteBuffer.getInt();
                                if (Process.myPid() == i) {
                                    mappedByteBuffer.position(0);
                                    mappedByteBuffer.putInt(i);
                                    mappedByteBuffer.put((byte) 0);
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    mappedByteBuffer.putLong(currentTimeMillis2);
                                    INSTANCE.syncStateByBroadcast(i, false, currentTimeMillis2);
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    } catch (Exception e) {
                        TMDataCollector.INSTANCE.reportException("ForegroundHolder_error", e, "setForeground failed " + foreground, MapsKt.emptyMap(), false);
                        INSTANCE.syncStateByBroadcast(Process.myPid(), false, System.currentTimeMillis());
                        Unit unit2 = Unit.INSTANCE;
                    }
                } finally {
                    if (fileLock != null) {
                        fileLock.release();
                    }
                }
            }
        }
    }

    private final void syncStateByBroadcast(int pid, boolean foreground, long time) {
        if (SenseConfigManager.INSTANCE.foregroundUseBroadcast()) {
            SensesUpdateBroadcastReceiver.INSTANCE.updateForegroundMode(new ForegroundState(pid, foreground, time));
        }
    }
}
