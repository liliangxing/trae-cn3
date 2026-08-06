package com.bytedance.dataplatform;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ExperimentPanel {
    private static IExperimentPanel experimentPanel;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface FragmentFactory {
        Fragment create();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IExperimentPanel {
        void add(String key, Set<ExperimentEntity> experimentEntitys);

        void addSingleFragment(String key, FragmentFactory fragmentFactory);

        void enableExperimentPanel(boolean enable);

        <T> T getPanalValue(String key, Type type);

        void init(Application application, ISettings settings, ISerializationService serializationService, ExperimentCache experimentCache);

        boolean isExperimentPanelEnable();

        void show(Context context);
    }

    private ExperimentPanel() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setExperimentPanel(IExperimentPanel experimentPanel2) {
        experimentPanel = experimentPanel2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Application application, ISettings settings, ISerializationService serializationService, ExperimentCache experimentCache) {
        IExperimentPanel iExperimentPanel = experimentPanel;
        if (iExperimentPanel == null) {
            return;
        }
        iExperimentPanel.init(application, settings, serializationService, experimentCache);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T getPanalValue(String str, Type type) {
        IExperimentPanel iExperimentPanel = experimentPanel;
        if (iExperimentPanel == null) {
            return null;
        }
        return (T) iExperimentPanel.getPanalValue(str, type);
    }

    public static void add(String key, Set<ExperimentEntity> experimentEntitys) {
        IExperimentPanel iExperimentPanel = experimentPanel;
        if (iExperimentPanel == null) {
            return;
        }
        iExperimentPanel.add(key, experimentEntitys);
    }

    public static void add(String key, ExperimentEntity entity) {
        HashSet hashSet = new HashSet();
        hashSet.add(entity);
        add(key, hashSet);
    }

    public static void addSingleFragment(String key, FragmentFactory fragmentFactory) {
        IExperimentPanel iExperimentPanel = experimentPanel;
        if (iExperimentPanel == null) {
            return;
        }
        iExperimentPanel.addSingleFragment(key, fragmentFactory);
    }

    public static void show(Context context) {
        IExperimentPanel iExperimentPanel = experimentPanel;
        if (iExperimentPanel == null) {
            return;
        }
        iExperimentPanel.show(context);
    }

    public static void enableExperimentPanel(boolean enable) {
        IExperimentPanel iExperimentPanel = experimentPanel;
        if (iExperimentPanel == null) {
            return;
        }
        iExperimentPanel.enableExperimentPanel(enable);
    }
}
