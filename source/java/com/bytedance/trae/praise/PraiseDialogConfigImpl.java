package com.bytedance.trae.praise;

import com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogAsyncThreadConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogLocalConditionConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogNetworkConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogStartActivityConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig;
import kotlin.Metadata;

/* compiled from: PraiseDialogConfigImpl.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialogConfigImpl;", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogConfig;", "<init>", "()V", "getNetworkConfig", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogNetworkConfig;", "getAppConfig", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogAppConfig;", "getUiConfig", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogUIConfig;", "getLocalConfig", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogLocalConditionConfig;", "getAsyncThreadConfig", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogAsyncThreadConfig;", "getStartActivityConfig", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogStartActivityConfig;", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PraiseDialogConfigImpl implements IPraiseDialogConfig {
    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogConfig
    public IPraiseDialogStartActivityConfig getStartActivityConfig() {
        return null;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogConfig
    public IPraiseDialogNetworkConfig getNetworkConfig() {
        return new PraiseDialogNetworkImpl();
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogConfig
    public IPraiseDialogAppConfig getAppConfig() {
        return new PraiseDialogAppConfigImpl();
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogConfig
    public IPraiseDialogUIConfig getUiConfig() {
        return new PraiseDialogUIConfigImpl();
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogConfig
    public IPraiseDialogLocalConditionConfig getLocalConfig() {
        return new PraiseDialogLocalConditionImpl();
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogConfig
    public IPraiseDialogAsyncThreadConfig getAsyncThreadConfig() {
        return new PraiseDialogAsyncThreadImpl();
    }
}
