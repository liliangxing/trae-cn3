package com.bytedance.realx.video;

import com.ss.ttm.player.UnifiedCodec.util.MimeTypes;

/* compiled from: RXVideoCodecDesc.java */
/* loaded from: classes4.dex */
enum RXVideoCodecStandard {
    H264(0),
    ByteVC1(1),
    Unknown(2),
    VP8(8),
    VP9(9);

    private final int value;

    RXVideoCodecStandard(int value) {
        this.value = value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String mimeType() {
        int i = this.value;
        return i != 1 ? i != 8 ? "video/avc" : MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_H265;
    }

    public int toInt() {
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RXVideoCodecStandard fromValue(int value) {
        if (value == 0) {
            return H264;
        }
        if (value == 1) {
            return ByteVC1;
        }
        if (value == 8) {
            return VP8;
        }
        return H264;
    }
}
