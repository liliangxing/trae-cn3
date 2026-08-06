package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class ViewModelProviders {
    @Deprecated
    public ViewModelProviders() {
    }

    private static Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    private static Activity checkActivity(Fragment fragment) {
        ComponentActivity activity = fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    /* renamed from: of */
    public static ViewModelProvider m59of(Fragment fragment) {
        return m60of(fragment, (ViewModelProvider.Factory) null);
    }

    /* renamed from: of */
    public static ViewModelProvider m61of(FragmentActivity fragmentActivity) {
        return m62of(fragmentActivity, (ViewModelProvider.Factory) null);
    }

    /* renamed from: of */
    public static ViewModelProvider m60of(Fragment fragment, ViewModelProvider.Factory factory) {
        Application checkApplication = checkApplication(checkActivity(fragment));
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(checkApplication);
        }
        return new ViewModelProvider(fragment.get_viewModelStore(), factory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: of */
    public static ViewModelProvider m62of(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory) {
        Application checkApplication = checkApplication(fragmentActivity);
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(checkApplication);
        }
        return new ViewModelProvider(fragmentActivity.getViewModelStore(), factory);
    }

    @Deprecated
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(Application application) {
            super(application);
        }
    }
}
