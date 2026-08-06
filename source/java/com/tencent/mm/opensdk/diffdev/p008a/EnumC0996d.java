package com.tencent.mm.opensdk.diffdev.p008a;

import com.ss.ttm.player.MediaPlayer;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public enum EnumC0996d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE);


    /* renamed from: a */
    private int f203a;

    EnumC0996d(int i) {
        this.f203a = i;
    }

    /* renamed from: a */
    public int m263a() {
        return this.f203a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f203a;
    }
}
