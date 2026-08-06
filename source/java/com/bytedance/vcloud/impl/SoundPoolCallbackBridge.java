package com.bytedance.vcloud.impl;

import kotlin.Metadata;

/* compiled from: SoundPoolImpl.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/vcloud/impl/SoundPoolCallbackBridge;", "", "onNotify", "", "soundId", "", "what", "arg1", "", "arg2", "info", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface SoundPoolCallbackBridge {
    void onNotify(int soundId, int what, long arg1, long arg2, String info);
}
