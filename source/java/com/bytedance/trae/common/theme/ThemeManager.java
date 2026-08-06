package com.bytedance.trae.common.theme;

import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatDelegate;
import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeManager.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/common/theme/ThemeManager;", "", "<init>", "()V", "REPO_NAME", "", "KEY_DARK_MODE", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "darkMode", "", "value", "", "isDarkMode", "()Z", "init", "", "getCurrentMode", "applyDarkMode", "mode", "updateDarkModeFlag", "configuration", "Landroid/content/res/Configuration;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThemeManager {
    private static final String KEY_DARK_MODE = "dark_mode";
    private static final String REPO_NAME = "trae_theme";
    private static volatile boolean isDarkMode;
    public static final ThemeManager INSTANCE = new ThemeManager();

    /* renamed from: keva$delegate, reason: from kotlin metadata */
    private static final Lazy keva = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.common.theme.ThemeManager$$ExternalSyntheticLambda0
        public final Object invoke() {
            Keva keva_delegate$lambda$0;
            keva_delegate$lambda$0 = ThemeManager.keva_delegate$lambda$0();
            return keva_delegate$lambda$0;
        }
    });
    private static volatile int darkMode = -1;

    private ThemeManager() {
    }

    private final Keva getKeva() {
        Object value = keva.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Keva) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Keva keva_delegate$lambda$0() {
        return Keva.getRepo(REPO_NAME, 0);
    }

    public final boolean isDarkMode() {
        return isDarkMode;
    }

    public final void init() {
        darkMode = 1;
        AppCompatDelegate.setDefaultNightMode(darkMode);
    }

    public final int getCurrentMode() {
        return darkMode;
    }

    public final void applyDarkMode(int mode) {
        darkMode = mode;
        getKeva().storeInt(KEY_DARK_MODE, mode);
        AppCompatDelegate.setDefaultNightMode(mode);
    }

    public final void updateDarkModeFlag(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        isDarkMode = (configuration.uiMode & 48) == 32;
    }
}
