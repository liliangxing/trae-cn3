package com.bytedance.apm.agent.p003v2.instrumentation;

import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.helper.PageShowCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FragmentShowAgent {
    private static final String TAG = "FragmentShowAgent";

    public static void onResume(Fragment fragment) {
        if (!fragment.getUserVisibleHint() || fragment.isHidden()) {
            return;
        }
        PageShowCallback.onPageShowHideAction(fragment, true);
    }

    public static void onPause(Fragment fragment) {
        if (!fragment.getUserVisibleHint() || fragment.isHidden()) {
            return;
        }
        PageShowCallback.onPageShowHideAction(fragment, false);
    }

    public static void onHiddenChanged(Fragment fragment, boolean z) {
        PageShowCallback.onPageShowHideAction(fragment, !z);
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        if (!fragment.isResumed() || fragment.isHidden()) {
            return;
        }
        PageShowCallback.onPageShowHideAction(fragment, z);
    }
}
