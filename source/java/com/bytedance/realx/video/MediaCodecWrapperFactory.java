package com.bytedance.realx.video;

import java.io.IOException;

/* loaded from: classes4.dex */
interface MediaCodecWrapperFactory {
    MediaCodecWrapper createByCodecName(String name) throws IOException;
}
