package com.ss.ttm.player;

import com.ss.vcbkit.UnExpected;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes7.dex */
public class TraitObject {
    public static final int AVLoadControl = 5;
    public static final int ExtRender = 6;
    public static final int ExtVoice = 1;
    public static final int Illegal = 0;
    public static final int VoiceCb = 11;
    private long mNativeObj;
    private long mRecycleObj;
    private ReleaseNativeTrait mReleaseFunc;
    private final int mType;
    private final int mVersion;

    /* loaded from: classes7.dex */
    public interface ReleaseNativeTrait {
        void releaseNativeTrait(long nativeObj);
    }

    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes7.dex */
    public @interface Type {
    }

    private static native void _nativeRelease(long obj);

    private static native void _nativeUnref(long obj);

    public TraitObject(int type, long nativeObj) {
        this.mReleaseFunc = null;
        this.mType = type;
        this.mVersion = -1;
        this.mNativeObj = nativeObj;
        this.mRecycleObj = 0L;
    }

    public TraitObject(int type, int version, long unused) {
        this.mReleaseFunc = null;
        this.mType = type;
        this.mVersion = version;
        this.mNativeObj = 0L;
        this.mRecycleObj = 0L;
    }

    public final void setReleaseFunc(ReleaseNativeTrait releaseFunc) {
        this.mReleaseFunc = releaseFunc;
    }

    public final int type() {
        return this.mType;
    }

    public final int version() {
        return this.mVersion;
    }

    public boolean sameAs(TraitObject traitObject) {
        if (traitObject == null) {
            return false;
        }
        return equals(traitObject);
    }

    public final void release() {
        long takeNativeObj = takeNativeObj();
        if (takeNativeObj != 0) {
            try {
                _nativeRelease(takeNativeObj);
            } catch (UnsatisfiedLinkError unused) {
                if (this.mReleaseFunc != null) {
                    this.mReleaseFunc.releaseNativeTrait(takeNativeObj);
                } else {
                    UnExpected.notReachHere(new Throwable("MemLeak"), "NativeTrait");
                }
            }
        }
        releaseRecycleObj();
    }

    protected void finalize() {
        release();
    }

    private long takeNativeObj() {
        long j = this.mNativeObj;
        this.mNativeObj = 0L;
        return j;
    }

    private void releaseRecycleObj() {
        long j = this.mRecycleObj;
        this.mRecycleObj = 0L;
        if (j != 0) {
            _nativeUnref(j);
        }
    }

    private void setRecycleObj(long recycle) {
        releaseRecycleObj();
        this.mRecycleObj = recycle;
    }

    private long getRecycleObj() {
        return this.mRecycleObj;
    }
}
