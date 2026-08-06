package com.ss.ttm.player.UnifiedCodec.pool;

import com.ss.ttm.player.UnifiedCodec.codec.FormatWrapper;
import com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface CodecAdapterTransformer {
    void clearAll();

    ReuseCodecAdapter obtainCodecAdapter(FormatWrapper formatWrapper);

    void removeFromRunning(ReuseCodecAdapter codecAdapter);

    void transToPersist(ReuseCodecAdapter codecAdapter);

    void transToRunning(ReuseCodecAdapter codecAdapter);
}
