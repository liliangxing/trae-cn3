package com.bytedance.push.interfaze;

import com.bytedance.push.PushSupporter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface SoLoader {
    void loadLibrary(String str);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class DefaultSoLoader implements SoLoader {
        @Override // com.bytedance.push.interfaze.SoLoader
        public void loadLibrary(String str) {
            if (PushSupporter.logger().debug()) {
                PushSupporter.logger().mo244d("load so library by DefaultSoLoader");
            }
            System.loadLibrary(str);
        }
    }
}
