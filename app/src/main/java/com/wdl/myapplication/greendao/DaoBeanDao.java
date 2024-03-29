/*
package com.wdl.myapplication.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
*/
/**
 * DAO for table "DAO_BEAN".
*//*

public class DaoBeanDao extends AbstractDao<DaoBean, Void> {

    public static final String TABLENAME = "DAO_BEAN";

    */
/**
     * Properties of entity DaoBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     *//*

    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", false, "ID");
        public final static Property Tel = new Property(1, String.class, "tel", false, "TEL");
        public final static Property Nick = new Property(2, String.class, "nick", false, "NICK");
        public final static Property Sid = new Property(3, String.class, "sid", false, "SID");
        public final static Property Headpic = new Property(4, String.class, "headpic", false, "HEADPIC");
        public final static Property Date_reg = new Property(5, String.class, "date_reg", false, "DATE_REG");
        public final static Property Date_lastaction = new Property(6, String.class, "date_lastaction", false, "DATE_LASTACTION");
    }


    public DaoBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DaoBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    */
/** Creates the underlying database table. *//*

    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DAO_BEAN\" (" + //
                "\"ID\" TEXT," + // 0: id
                "\"TEL\" TEXT," + // 1: tel
                "\"NICK\" TEXT," + // 2: nick
                "\"SID\" TEXT," + // 3: sid
                "\"HEADPIC\" TEXT," + // 4: headpic
                "\"DATE_REG\" TEXT," + // 5: date_reg
                "\"DATE_LASTACTION\" TEXT);"); // 6: date_lastaction
    }

    */
/** Drops the underlying database table. *//*

    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DAO_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DaoBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String tel = entity.getTel();
        if (tel != null) {
            stmt.bindString(2, tel);
        }
 
        String nick = entity.getNick();
        if (nick != null) {
            stmt.bindString(3, nick);
        }
 
        String sid = entity.getSid();
        if (sid != null) {
            stmt.bindString(4, sid);
        }
 
        String headpic = entity.getHeadpic();
        if (headpic != null) {
            stmt.bindString(5, headpic);
        }
 
        String date_reg = entity.getDate_reg();
        if (date_reg != null) {
            stmt.bindString(6, date_reg);
        }
 
        String date_lastaction = entity.getDate_lastaction();
        if (date_lastaction != null) {
            stmt.bindString(7, date_lastaction);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DaoBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String tel = entity.getTel();
        if (tel != null) {
            stmt.bindString(2, tel);
        }
 
        String nick = entity.getNick();
        if (nick != null) {
            stmt.bindString(3, nick);
        }
 
        String sid = entity.getSid();
        if (sid != null) {
            stmt.bindString(4, sid);
        }
 
        String headpic = entity.getHeadpic();
        if (headpic != null) {
            stmt.bindString(5, headpic);
        }
 
        String date_reg = entity.getDate_reg();
        if (date_reg != null) {
            stmt.bindString(6, date_reg);
        }
 
        String date_lastaction = entity.getDate_lastaction();
        if (date_lastaction != null) {
            stmt.bindString(7, date_lastaction);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public DaoBean readEntity(Cursor cursor, int offset) {
        DaoBean entity = new DaoBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // tel
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // nick
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sid
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // headpic
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // date_reg
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // date_lastaction
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DaoBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTel(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setNick(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSid(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setHeadpic(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDate_reg(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDate_lastaction(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(DaoBean entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(DaoBean entity) {
        return null;
    }

    @Override
    public boolean hasKey(DaoBean entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
*/
