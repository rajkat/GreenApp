package tg.myapps.rajkat.greendaointegration.model.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import tg.myapps.rajkat.greendaointegration.model.Person;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PERSON".
*/
public class PersonDao extends AbstractDao<Person, Long> {

    public static final String TABLENAME = "PERSON";

    /**
     * Properties of entity Person.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Firstname = new Property(1, String.class, "firstname", false, "FIRSTNAME");
        public final static Property Lastname = new Property(2, String.class, "lastname", false, "LASTNAME");
        public final static Property Username = new Property(3, String.class, "username", false, "USERNAME");
    };


    public PersonDao(DaoConfig config) {
        super(config);
    }
    
    public PersonDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PERSON\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"FIRSTNAME\" TEXT," + // 1: firstname
                "\"LASTNAME\" TEXT," + // 2: lastname
                "\"USERNAME\" TEXT);"); // 3: username
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PERSON\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Person entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String firstname = entity.getFirstname();
        if (firstname != null) {
            stmt.bindString(2, firstname);
        }
 
        String lastname = entity.getLastname();
        if (lastname != null) {
            stmt.bindString(3, lastname);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(4, username);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Person readEntity(Cursor cursor, int offset) {
        Person entity = new Person( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // firstname
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // lastname
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // username
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Person entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFirstname(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLastname(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUsername(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Person entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Person entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
