package com.bytedance.trae.home.solo.setting;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.fragment.CmpConnectComputerGuideFragment;
import com.bytedance.trae.home.solo.setting.fragment.CmpDeviceManagementFragment;
import com.bytedance.trae.home.solo.setting.fragment.CmpSettingsAboutFragment;
import com.bytedance.trae.home.solo.setting.platform.CmpPageSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CmpSettingsNavigator.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "openAbout", "", "openDeviceManagement", "openConnectComputerGuide", "openNative", "fragment", "Landroidx/fragment/app/Fragment;", "pop", "", "push", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CmpSettingsNavigator {
    public static final int $stable = 8;
    private final FragmentManager fragmentManager;

    public CmpSettingsNavigator(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.fragmentManager = fragmentManager;
    }

    public final void openAbout() {
        push((Fragment) CmpSettingsAboutFragment.INSTANCE.newInstance());
    }

    public final void openDeviceManagement() {
        DeviceManagementFragment newInstance;
        if (CmpPageSettings.INSTANCE.isDeviceManagementEnabled()) {
            newInstance = (Fragment) CmpDeviceManagementFragment.INSTANCE.newInstance();
        } else {
            newInstance = DeviceManagementFragment.INSTANCE.newInstance();
        }
        push(newInstance);
    }

    public final void openConnectComputerGuide() {
        push((Fragment) CmpConnectComputerGuideFragment.INSTANCE.newInstance());
    }

    public final void openNative(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        push(fragment);
    }

    public final boolean pop() {
        if (this.fragmentManager.getBackStackEntryCount() == 0) {
            return false;
        }
        this.fragmentManager.popBackStack();
        return true;
    }

    private final void push(Fragment fragment) {
        Fragment findFragmentById = this.fragmentManager.findFragmentById(C0820R.id.settings_fragment_container);
        FragmentTransaction customAnimations = this.fragmentManager.beginTransaction().setCustomAnimations(C0820R.anim.trae_slide_in_right, C0820R.anim.trae_slide_out_left, C0820R.anim.trae_slide_in_left, C0820R.anim.trae_slide_out_right);
        if (findFragmentById != null) {
            customAnimations.hide(findFragmentById);
        }
        customAnimations.add(C0820R.id.settings_fragment_container, fragment).addToBackStack((String) null).commit();
    }
}
