package com.bytedance.ies.uikit.base;

/* loaded from: classes4.dex */
public interface LifeCycleMonitor {

    /* loaded from: classes4.dex */
    public static class Stub implements LifeCycleMonitor {
        @Override // com.bytedance.ies.uikit.base.LifeCycleMonitor
        public void onDestroy() {
        }

        @Override // com.bytedance.ies.uikit.base.LifeCycleMonitor
        public void onPause() {
        }

        @Override // com.bytedance.ies.uikit.base.LifeCycleMonitor
        public void onResume() {
        }

        @Override // com.bytedance.ies.uikit.base.LifeCycleMonitor
        public void onStop() {
        }
    }

    void onDestroy();

    void onPause();

    void onResume();

    void onStop();
}
