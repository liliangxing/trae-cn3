package com.bytedance.platform.godzilla.crash;

import com.bytedance.platform.godzilla.crash.uncaughtexecption.FinalizeTimeoutPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.JsDialogBadTokenPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.OppoMessageNPEPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.StopActivityNPEPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.ToastBadTokenPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.TopResumedActivityPlugin;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.platform.godzilla.plugin.PluginGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CrashPluginGroup extends PluginGroup {
    @Override // com.bytedance.platform.godzilla.plugin.PluginGroup, com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CrashPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.PluginGroup
    protected List<BasePlugin> getPluginList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FinalizeTimeoutPlugin());
        arrayList.add(new JsDialogBadTokenPlugin());
        arrayList.add(new OppoMessageNPEPlugin());
        arrayList.add(new StopActivityNPEPlugin());
        arrayList.add(new ToastBadTokenPlugin());
        arrayList.add(new TopResumedActivityPlugin());
        arrayList.add(new HWReceiverCrashPlugin());
        arrayList.add(new BadParcelableExceptionPlugin());
        arrayList.add(new EnterTransitionCrashPlugin());
        arrayList.add(new LayoutInflaterAsyncCrashPlugin());
        return arrayList;
    }
}
