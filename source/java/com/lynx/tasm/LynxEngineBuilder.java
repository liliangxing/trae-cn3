package com.lynx.tasm;

import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxEngineBuilder extends LynxViewBuilder {
    public LynxEngineBuilder() {
        m2925setEnablePendingJsTask(true);
    }

    public ILynxEngine build() {
        TraceEvent.beginSection(TraceEventDef.ENGINE_BUILDER_BUILD);
        LynxTemplateRender lynxTemplateRender = new LynxTemplateRender(this);
        TraceEvent.endSection(TraceEventDef.ENGINE_BUILDER_BUILD);
        return lynxTemplateRender;
    }
}
