package com.bytedance.sync.p005v4.presistence;

import androidx.room.RoomDatabase;
import com.bytedance.sync.p004v3.presistence.dao.UploadDaoV4;
import com.bytedance.sync.p005v4.presistence.dao.BusinessDao;
import com.bytedance.sync.p005v4.presistence.dao.HistoryDaoV4;
import com.bytedance.sync.p005v4.presistence.dao.SyncDaoV4;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AppDatabaseV4 extends RoomDatabase {
    public abstract BusinessDao businessDao();

    public abstract HistoryDaoV4 historyDao();

    public abstract SyncDaoV4 syncDao();

    public abstract UploadDaoV4 upStreamDao();
}
