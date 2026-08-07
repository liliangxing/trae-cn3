package com.bytedance.trae.im.database;

import java.util.List;
import java.util.ArrayList;

/**
 * stub for compilation only.
 * 关键：构造函数参数必须是 DatabaseOpenHelper，不能是 Object。
 * 真实签名: <init>(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V
 */
public class ChatMessageDao {
    public ChatMessageDao(DatabaseOpenHelper dbHelper) {}
    public List queryByTaskId(String taskId) { return new ArrayList(); }
}
