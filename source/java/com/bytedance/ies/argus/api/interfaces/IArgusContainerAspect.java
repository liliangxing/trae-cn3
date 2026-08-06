package com.bytedance.ies.argus.api.interfaces;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.ies.argus.api.params.ArgusMotionEventParams;
import com.bytedance.ies.argus.api.params.ContainerCreatedParams;
import kotlin.Metadata;

/* compiled from: IArgusContainerAspect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/IArgusContainerAspect;", "", "monitorContainerCreated", "", "activity", "Landroid/app/Activity;", "params", "Lcom/bytedance/ies/argus/api/params/ContainerCreatedParams;", "monitorCreateContainer", "openContext", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "monitorOnMotionEvent", "Lcom/bytedance/ies/argus/api/params/ArgusMotionEventParams;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IArgusContainerAspect {
    void monitorContainerCreated(Activity activity, ContainerCreatedParams params);

    void monitorCreateContainer(Context openContext, Bundle bundle);

    void monitorOnMotionEvent(ArgusMotionEventParams params);
}
