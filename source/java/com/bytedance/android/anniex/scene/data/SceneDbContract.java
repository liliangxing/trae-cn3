package com.bytedance.android.anniex.scene.data;

import kotlin.Metadata;

/* compiled from: SceneDbContract.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/scene/data/SceneDbContract;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "Scenes", "Transitions", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class SceneDbContract {
    public static final String DATABASE_NAME = "scene_recognition.db";
    public static final int DATABASE_VERSION = 3;
    public static final SceneDbContract INSTANCE = new SceneDbContract();

    private SceneDbContract() {
    }

    /* compiled from: SceneDbContract.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/scene/data/SceneDbContract$Scenes;", "", "()V", "COLUMN_ATTACH_SCENE", "", "COLUMN_CLIENT_COMPONENT", "COLUMN_COUNT", "COLUMN_ID", "COLUMN_ORIGIN", "COLUMN_TIMESTAMP", "COLUMN_VIEW_COUNT", "TABLE_NAME", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Scenes {
        public static final String COLUMN_ATTACH_SCENE = "attach_scene";
        public static final String COLUMN_CLIENT_COMPONENT = "client_component";
        public static final String COLUMN_COUNT = "count";
        public static final String COLUMN_ID = "scene_id";
        public static final String COLUMN_ORIGIN = "origin";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_VIEW_COUNT = "view_count";
        public static final Scenes INSTANCE = new Scenes();
        public static final String TABLE_NAME = "scenes";

        private Scenes() {
        }
    }

    /* compiled from: SceneDbContract.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/scene/data/SceneDbContract$Transitions;", "", "()V", "COLUMN_AVG_DURATION", "", "COLUMN_COUNT", "COLUMN_FROM_ID", "COLUMN_LAST_UPDATE", "COLUMN_TO_ID", "TABLE_NAME", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Transitions {
        public static final String COLUMN_AVG_DURATION = "avg_duration";
        public static final String COLUMN_COUNT = "count";
        public static final String COLUMN_FROM_ID = "from_scene_id";
        public static final String COLUMN_LAST_UPDATE = "last_update";
        public static final String COLUMN_TO_ID = "to_scene_id";
        public static final Transitions INSTANCE = new Transitions();
        public static final String TABLE_NAME = "transitions";

        private Transitions() {
        }
    }
}
