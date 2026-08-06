package com.bytedance.trae.common.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.trae.common.theme.ThemeManager;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.utils.LocaleManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeCommonAppCompatActivity.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0017J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u0013\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0014J\"\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0012H\u0014J\b\u0010$\u001a\u00020\nH\u0014J\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0016H\u0004¨\u0006'"}, d2 = {"Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "isEdgeToEdgeEnabled", "", "isLightStatusBar", "getDecorViewBackgroundColor", "", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "applyOverrideConfiguration", "overrideConfiguration", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "layoutResID", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "setupEdgeToEdge", "applySystemBarAppearance", "onContentViewSet", "onResume", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onSaveInstanceState", "outState", "onDestroy", "applySystemBarInsets", "rootView", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TraeCommonAppCompatActivity extends AppCompatActivity {
    public boolean isEdgeToEdgeEnabled() {
        return true;
    }

    public boolean isLightStatusBar() {
        return !ThemeManager.INSTANCE.isDarkMode();
    }

    public int getDecorViewBackgroundColor() {
        return getColor(C0591R.color.trae_bg_bg_base_secondary);
    }

    protected void attachBaseContext(Context newBase) {
        Context wrapContext;
        if (newBase != null && (wrapContext = LocaleManager.INSTANCE.wrapContext(newBase)) != null) {
            newBase = wrapContext;
        }
        super.attachBaseContext(newBase);
    }

    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        if (overrideConfiguration == null) {
            overrideConfiguration = new Configuration();
        }
        Locale appLocale = LocaleManager.INSTANCE.getAppLocale();
        Locale.setDefault(appLocale);
        overrideConfiguration.setLocale(appLocale);
        LocaleList localeList = new LocaleList(appLocale);
        LocaleList.setDefault(localeList);
        overrideConfiguration.setLocales(localeList);
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        if (isEdgeToEdgeEnabled()) {
            setupEdgeToEdge();
        }
        super.onCreate(savedInstanceState);
        ThemeManager themeManager = ThemeManager.INSTANCE;
        Configuration configuration = getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        themeManager.updateDarkModeFlag(configuration);
        if (isEdgeToEdgeEnabled()) {
            applySystemBarAppearance();
        }
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onContentViewSet();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        onContentViewSet();
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        onContentViewSet();
    }

    private final void setupEdgeToEdge() {
        int navigationBarColor = getWindow().getNavigationBarColor();
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(navigationBarColor);
    }

    private final void applySystemBarAppearance() {
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(...)");
        insetsController.setAppearanceLightStatusBars(isLightStatusBar());
    }

    private final void onContentViewSet() {
        View findViewById;
        if (isEdgeToEdgeEnabled() && (findViewById = findViewById(R.id.content)) != null) {
            findViewById.setBackgroundColor(getDecorViewBackgroundColor());
            applySystemBarInsets(findViewById);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
        } catch (Exception unused) {
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    protected final void applySystemBarInsets(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ViewCompat.setOnApplyWindowInsetsListener(rootView, new OnApplyWindowInsetsListener() { // from class: com.bytedance.trae.common.activity.TraeCommonAppCompatActivity$$ExternalSyntheticLambda0
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat applySystemBarInsets$lambda$1;
                applySystemBarInsets$lambda$1 = TraeCommonAppCompatActivity.applySystemBarInsets$lambda$1(view, windowInsetsCompat);
                return applySystemBarInsets$lambda$1;
            }
        });
        ViewCompat.requestApplyInsets(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applySystemBarInsets$lambda$1(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        view.setPadding(insets.left, insets.top, insets.right, Math.max(insets.bottom, insets2.bottom));
        return WindowInsetsCompat.CONSUMED;
    }
}
