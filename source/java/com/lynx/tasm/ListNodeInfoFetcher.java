package com.lynx.tasm;

import com.lynx.react.bridge.JavaOnlyMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ListNodeInfoFetcher implements IListNodeInfoFetcher {
    private LynxTemplateRender mRenderer;

    public ListNodeInfoFetcher(LynxTemplateRender lynxTemplateRender) {
        this.mRenderer = lynxTemplateRender;
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public JavaOnlyMap getPlatformInfo(int i) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.getListPlatformInfo(i);
        }
        return null;
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public void renderChild(int i, int i2, long j) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.renderChild(i, i2, j);
        }
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public void updateChild(int i, int i2, int i3, long j) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.updateChild(i, i2, i3, j);
        }
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public void removeChild(int i, int i2) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.removeChild(i, i2);
        }
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public int obtainChild(int i, int i2, long j, boolean z) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.obtainChild(i, i2, j, z);
        }
        return -1;
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public void recycleChild(int i, int i2) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.recycleChild(i, i2);
        }
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public void obtainChildAsync(int i, int i2, long j) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.obtainChildAsync(i, i2, j);
        }
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public void recycleChildAsync(int i, int i2) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.recycleChildAsync(i, i2);
        }
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public void scrollByListContainer(int i, float f, float f2, float f3, float f4) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.scrollByListContainer(i, f, f2, f3, f4);
        }
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public void scrollToPosition(int i, int i2, float f, int i3, boolean z) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.scrollToPosition(i, i2, f, i3, z);
        }
    }

    @Override // com.lynx.tasm.IListNodeInfoFetcher
    public void scrollStopped(int i) {
        LynxTemplateRender lynxTemplateRender = this.mRenderer;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.scrollStopped(i);
        }
    }
}
