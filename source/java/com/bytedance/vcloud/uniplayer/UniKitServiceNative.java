package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: UniKitService.android.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u0004H\u0087 ¢\u0006\u0002\b\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0087 ¢\u0006\u0002\b\tJ\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0087 ¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniKitServiceNative;", "", "()V", "nativeGetAbConfig", "", "getAbConfig", "nativeInitOnce", "", "abConfigPtr", "init", "nativeUpdateConfig", "isIncremental", "", "update", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UniKitServiceNative {
    public static final UniKitServiceNative INSTANCE = new UniKitServiceNative();

    @JvmStatic
    public static final native long getAbConfig();

    @JvmStatic
    public static final native void init(long abConfigPtr);

    @JvmStatic
    public static final native void update(long abConfigPtr, boolean isIncremental);

    private UniKitServiceNative() {
    }
}
