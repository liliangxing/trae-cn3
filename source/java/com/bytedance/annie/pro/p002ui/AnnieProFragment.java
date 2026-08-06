package com.bytedance.annie.pro.p002ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.anniex.R;
import com.bytedance.annie.pro.utils.SchemaUtils;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieProFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/annie/pro/ui/AnnieProFragment;", "Landroidx/fragment/app/Fragment;", "()V", "bundleRelativePath", "", "cardView", "Lcom/bytedance/ies/bullet/ui/common/BulletCardView;", "navigateTo", "", "relativePath", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AnnieProFragment extends Fragment {
    public static final String BUNDLE_KEY_RELATIVE_PATH = "relative_path";
    private String bundleRelativePath;
    private BulletCardView cardView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        this.bundleRelativePath = arguments != null ? arguments.getString(BUNDLE_KEY_RELATIVE_PATH) : null;
        AnnieProActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.bytedance.annie.pro.ui.AnnieProActivity");
        Uri parse = Uri.parse(activity.getMSchema());
        String str = this.bundleRelativePath;
        if (str != null) {
            SchemaUtils schemaUtils = SchemaUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(parse, "realUri");
            parse = schemaUtils.replaceQueryParameterSafely(parse, "start_page", str);
        }
        Uri uri = parse;
        View inflate = inflater.inflate(R.layout.layout_annie_pro, (ViewGroup) null);
        BulletCardView findViewById = inflate != null ? inflate.findViewById(R.id.annie_pro_frag_view) : null;
        this.cardView = findViewById;
        if (findViewById != null) {
            Intrinsics.checkNotNullExpressionValue(uri, "realUri");
            IBulletContainer.DefaultImpls.loadUri$default((IBulletContainer) findViewById, uri, (Bundle) null, (IBulletLifeCycle) null, 6, (Object) null);
        }
        return inflate;
    }

    public final void navigateTo(String relativePath) {
        FragmentTransaction add;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        FragmentActivity activity = getActivity();
        FragmentTransaction beginTransaction = (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.beginTransaction();
        if (beginTransaction != null) {
            beginTransaction.setCustomAnimations(R.anim.anim_x_100_to_0, R.anim.anim_x_0_to_m100, R.anim.anim_x_m100_to_0, R.anim.anim_x_0_to_100);
        }
        if (beginTransaction != null) {
            beginTransaction.hide(this);
        }
        AnnieProFragment annieProFragment = new AnnieProFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_RELATIVE_PATH, relativePath);
        annieProFragment.setArguments(bundle);
        if (beginTransaction != null && (add = beginTransaction.add(R.id.annie_pro_fragment_container, annieProFragment)) != null) {
            add.addToBackStack((String) null);
        }
        if (beginTransaction != null) {
            beginTransaction.commit();
        }
    }
}
