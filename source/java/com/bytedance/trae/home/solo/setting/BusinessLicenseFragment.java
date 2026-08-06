package com.bytedance.trae.home.solo.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BusinessLicenseFragment.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BusinessLicenseFragment extends Fragment {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_business_license, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.BusinessLicenseFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BusinessLicenseFragment.onViewCreated$lambda$1(BusinessLicenseFragment.this, view2);
            }
        });
        ImageView imageView = (ImageView) view.findViewById(C0820R.id.iv_license);
        int identifier = getResources().getIdentifier("ic_business_license", "drawable", requireContext().getPackageName());
        if (identifier != 0) {
            imageView.setImageResource(identifier);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(final BusinessLicenseFragment businessLicenseFragment, View view) {
        view.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.BusinessLicenseFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BusinessLicenseFragment.onViewCreated$lambda$1$lambda$0(BusinessLicenseFragment.this);
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$lambda$0(BusinessLicenseFragment businessLicenseFragment) {
        businessLicenseFragment.getParentFragmentManager().popBackStack();
    }

    /* compiled from: BusinessLicenseFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BusinessLicenseFragment newInstance() {
            return new BusinessLicenseFragment();
        }
    }
}
