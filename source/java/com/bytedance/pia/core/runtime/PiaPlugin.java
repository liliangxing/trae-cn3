package com.bytedance.pia.core.runtime;

import android.view.View;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.utils.IReleasable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class PiaPlugin implements IReleasable {
    protected final PiaRuntime runtime;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getName();

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IResourceResponse onAfterLoadResource(IResourceRequest iResourceRequest, IResourceResponse iResourceResponse) {
        return iResourceResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IResourceResponse onBeforeLoadResource(IResourceRequest iResourceRequest) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBindView(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onEvent(String str, Object... objArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadFinished() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadStarted() {
    }

    @Override // com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
    }

    public PiaPlugin(PiaRuntime piaRuntime) {
        this.runtime = piaRuntime;
    }
}
