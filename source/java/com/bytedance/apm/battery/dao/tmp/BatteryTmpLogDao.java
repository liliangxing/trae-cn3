package com.bytedance.apm.battery.dao.tmp;

import android.content.ContentValues;
import com.bytedance.apm.battery.dao.BaseDao;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.entity.BatteryLogEntity;
import java.util.List;

/* loaded from: classes3.dex */
public class BatteryTmpLogDao extends BaseDao<BatteryLogEntity> implements BaseDao.CursorGetter<BatteryLogEntity> {
    private static String WHERE_CLAUSE_ID_LESS_THAN = "_id <= ? ";
    private static volatile BatteryTmpLogDao singleton;
    private static final String[] BATTERY_LOG_COL_ARRAY = {"_id", "front", "type", "timestamp", DBHelper.BATTERY_COL_ACCUMULATION, DBHelper.COL_VERSION_ID, "source", "status", "scene", "process", DBHelper.BATTERY_COL_MAIN_PROCESS, "sid"};
    private static String WHERE_CLAUSE_MAIN_PROCESS = "main_process = 1 AND delete_flag = 0";
    private static String WHERE_CLAUSE_NOT_MAIN_PROCESS = "main_process = 0 AND delete_flag = 0 AND timestamp <= ? ";

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public String getTableName() {
        return DBHelper.T_BATTERY;
    }

    private BatteryTmpLogDao() {
    }

    public static BatteryTmpLogDao getInstance() {
        if (singleton == null) {
            synchronized (BatteryTmpLogDao.class) {
                if (singleton == null) {
                    singleton = new BatteryTmpLogDao();
                }
            }
        }
        return singleton;
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public String[] getColumns() {
        return BATTERY_LOG_COL_ARRAY;
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public ContentValues getContentValues(BatteryLogEntity batteryLogEntity) {
        if (batteryLogEntity == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("front", Integer.valueOf(batteryLogEntity.isFront() ? 1 : 0));
        contentValues.put("source", batteryLogEntity.getSource());
        contentValues.put("type", batteryLogEntity.getType());
        contentValues.put("timestamp", Long.valueOf(batteryLogEntity.getTime()));
        contentValues.put(DBHelper.BATTERY_COL_ACCUMULATION, Long.valueOf(batteryLogEntity.getAccumulation()));
        contentValues.put(DBHelper.COL_VERSION_ID, Long.valueOf(batteryLogEntity.getVersionId()));
        contentValues.put("status", Integer.valueOf(batteryLogEntity.isStatus() ? 1 : 0));
        contentValues.put("scene", batteryLogEntity.getScene());
        contentValues.put(DBHelper.BATTERY_COL_MAIN_PROCESS, Integer.valueOf(batteryLogEntity.isMainProcess() ? 1 : 0));
        contentValues.put("process", batteryLogEntity.getProcessName());
        contentValues.put("sid", batteryLogEntity.getStartUuid());
        return contentValues;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.apm.battery.dao.BaseDao.CursorGetter
    public BatteryLogEntity get(BaseDao.CursorWrapper cursorWrapper) {
        long j = cursorWrapper.getLong("_id");
        long j2 = cursorWrapper.getLong("front");
        String string = cursorWrapper.getString("type");
        long j3 = cursorWrapper.getLong("timestamp");
        long j4 = cursorWrapper.getLong(DBHelper.BATTERY_COL_ACCUMULATION);
        long j5 = cursorWrapper.getLong(DBHelper.COL_VERSION_ID);
        String string2 = cursorWrapper.getString("source");
        long j6 = cursorWrapper.getLong("status");
        String string3 = cursorWrapper.getString("scene");
        int i = cursorWrapper.getInt(DBHelper.BATTERY_COL_MAIN_PROCESS);
        String string4 = cursorWrapper.getString("process");
        BatteryLogEntity batteryLogEntity = new BatteryLogEntity(j2 != 0, j3, string, j6 != 0, j4, string3, string2);
        batteryLogEntity.setProcessName(string4);
        batteryLogEntity.setId(j);
        batteryLogEntity.setVersionId(j5);
        batteryLogEntity.setMainProcess(i == 1);
        batteryLogEntity.setStartUuid(cursorWrapper.getString("sid"));
        return batteryLogEntity;
    }

    public synchronized long saveLog(BatteryLogEntity batteryLogEntity) {
        if (batteryLogEntity == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            int i = 1;
            contentValues.put("front", Integer.valueOf(batteryLogEntity.isFront() ? 1 : 0));
            contentValues.put("source", batteryLogEntity.getSource());
            contentValues.put("type", batteryLogEntity.getType());
            contentValues.put("timestamp", Long.valueOf(batteryLogEntity.getTime()));
            contentValues.put(DBHelper.BATTERY_COL_ACCUMULATION, Long.valueOf(batteryLogEntity.getAccumulation()));
            contentValues.put(DBHelper.COL_VERSION_ID, Long.valueOf(batteryLogEntity.getVersionId()));
            contentValues.put("status", Integer.valueOf(batteryLogEntity.isStatus() ? 1 : 0));
            contentValues.put("scene", batteryLogEntity.getScene());
            if (!batteryLogEntity.isMainProcess()) {
                i = 0;
            }
            contentValues.put(DBHelper.BATTERY_COL_MAIN_PROCESS, Integer.valueOf(i));
            contentValues.put("process", batteryLogEntity.getProcessName());
            contentValues.put("sid", batteryLogEntity.getStartUuid());
            return insert(contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public synchronized List<BatteryLogEntity> getLogs(boolean z, long j) {
        List<BatteryLogEntity> query;
        if (z) {
            query = query(WHERE_CLAUSE_MAIN_PROCESS, null, "_id", this);
        } else {
            query = query(WHERE_CLAUSE_NOT_MAIN_PROCESS, new String[]{String.valueOf(j)}, "_id", this);
        }
        return query;
    }

    public synchronized void updateDeleteFlag(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_DELETE, (Integer) 1);
        update(contentValues, WHERE_CLAUSE_ID_LESS_THAN, new String[]{String.valueOf(j)});
    }
}
