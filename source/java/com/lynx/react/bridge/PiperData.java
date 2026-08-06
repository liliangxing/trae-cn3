package com.lynx.react.bridge;

import android.text.TextUtils;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.common.LepusBuffer;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class PiperData {
    private ByteBuffer mBuffer;
    private boolean mIsDisposable;
    private long mNativeDataPtr;
    private Object mRawData;
    private DataType mType;

    /* loaded from: classes6.dex */
    public enum DataType {
        Empty,
        String,
        Map
    }

    private static native long nativeParseStringData(String str);

    private static native void nativeReleaseData(long j);

    public static PiperData fromString(String str) {
        if (checkIfEnvPrepared() && !TextUtils.isEmpty(str)) {
            return new PiperData(str, false);
        }
        return new PiperData();
    }

    public static PiperData fromObject(Object obj) {
        return new PiperData(obj, false);
    }

    public static PiperData createDisposableFromString(String str) {
        if (checkIfEnvPrepared() && !TextUtils.isEmpty(str)) {
            return new PiperData(str, true);
        }
        return new PiperData();
    }

    public static PiperData createDisposableFromObject(Object obj) {
        return new PiperData(obj, true);
    }

    private PiperData() {
        this.mNativeDataPtr = 0L;
        this.mBuffer = null;
        this.mType = DataType.Empty;
        this.mIsDisposable = false;
        this.mRawData = null;
    }

    private PiperData(String str, boolean z) {
        this.mNativeDataPtr = 0L;
        this.mBuffer = null;
        this.mType = DataType.Empty;
        this.mIsDisposable = false;
        this.mRawData = null;
        this.mType = DataType.String;
        this.mNativeDataPtr = nativeParseStringData(str);
        this.mIsDisposable = z;
        this.mRawData = str;
    }

    private PiperData(Object obj, boolean z) {
        this.mNativeDataPtr = 0L;
        this.mBuffer = null;
        this.mType = DataType.Empty;
        this.mIsDisposable = false;
        this.mRawData = null;
        this.mType = DataType.Map;
        this.mBuffer = LepusBuffer.INSTANCE.encodeMessage(obj);
        this.mIsDisposable = z;
        this.mRawData = obj;
    }

    public Object getRawData() {
        return this.mRawData;
    }

    public boolean hasParseError() {
        return this.mType == DataType.String && this.mNativeDataPtr == 0;
    }

    public void markDisposable() {
        this.mIsDisposable = true;
    }

    public long getNativePtr() {
        return this.mNativeDataPtr;
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public int getBufferPosition() {
        ByteBuffer byteBuffer = this.mBuffer;
        if (byteBuffer == null) {
            return 0;
        }
        return byteBuffer.position();
    }

    public boolean isDisposable() {
        return this.mIsDisposable;
    }

    public int getDataType() {
        return this.mType.ordinal();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mType != DataType.Empty) {
            recycle();
        }
    }

    private boolean recycleIfIsDisposable() {
        if (this.mIsDisposable && this.mType != DataType.Empty) {
            recycle();
        }
        return this.mIsDisposable;
    }

    private void recycle() {
        if (this.mNativeDataPtr != 0 && checkIfEnvPrepared()) {
            nativeReleaseData(this.mNativeDataPtr);
            this.mNativeDataPtr = 0L;
        }
        this.mType = DataType.Empty;
        this.mBuffer = null;
    }

    private static boolean checkIfEnvPrepared() {
        return LynxEnv.inst().isNativeLibraryLoaded();
    }
}
