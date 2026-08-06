package com.bytedance.android.monitorV2.jsb;

import android.view.View;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LynxHandler implements Icache {
    private Map<LynxView, NativeCommon> cache = Collections.synchronizedMap(new WeakHashMap());

    @Override // com.bytedance.android.monitorV2.jsb.Icache
    public boolean isMatch(View view) {
        return view instanceof LynxView;
    }

    @Override // com.bytedance.android.monitorV2.jsb.Icache
    public NativeCommon getNativeCommon(View view, String str) {
        if (view == null || !(view instanceof LynxView)) {
            return null;
        }
        LynxView lynxView = (LynxView) view;
        NativeCommon nativeCommon = this.cache.get(lynxView);
        if (nativeCommon != null) {
            return nativeCommon;
        }
        NativeCommon nativeCommon2 = new NativeCommon();
        nativeCommon2.containerType = "lynx";
        nativeCommon2.url = str;
        this.cache.put(lynxView, nativeCommon2);
        lynxView.addLynxViewClient(new LynxPageStartCallback(this.cache, lynxView));
        return nativeCommon2;
    }

    @Override // com.bytedance.android.monitorV2.jsb.Icache
    public String getUrl(View view) {
        if (view == null || !(view instanceof LynxView)) {
            return null;
        }
        return ((LynxView) view).getTemplateUrl();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class LynxPageStartCallback extends LynxViewClient {
        private Map<LynxView, NativeCommon> cache;
        private LynxView lynxView;

        LynxPageStartCallback(Map<LynxView, NativeCommon> map, LynxView lynxView) {
            this.cache = map;
            this.lynxView = lynxView;
        }

        public void onPageStart(String str) {
            super.onPageStart(str);
            NativeCommon nativeCommon = new NativeCommon();
            nativeCommon.containerType = "lynx";
            nativeCommon.url = str;
            this.cache.put(this.lynxView, nativeCommon);
        }
    }
}
