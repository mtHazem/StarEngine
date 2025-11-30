package com.example.starengine.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.starengine.database.dao.LevelDao;
import com.example.starengine.database.dao.LevelDao_Impl;
import com.example.starengine.database.dao.ScoreDao;
import com.example.starengine.database.dao.ScoreDao_Impl;
import com.example.starengine.database.dao.UpgradeDao;
import com.example.starengine.database.dao.UpgradeDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ScoreDao _scoreDao;

  private volatile UpgradeDao _upgradeDao;

  private volatile LevelDao _levelDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `scores` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `points` INTEGER NOT NULL, `date` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `upgrades` (`id` INTEGER NOT NULL, `speed` REAL NOT NULL, `fireRate` REAL NOT NULL, `power` INTEGER NOT NULL, `shipWidth` REAL NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `levels` (`levelNumber` INTEGER NOT NULL, `difficultySpeed` REAL NOT NULL, `alienRate` REAL NOT NULL, PRIMARY KEY(`levelNumber`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '858cfb2748d3b1f4508ee31f8a9be4ec')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `scores`");
        db.execSQL("DROP TABLE IF EXISTS `upgrades`");
        db.execSQL("DROP TABLE IF EXISTS `levels`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsScores = new HashMap<String, TableInfo.Column>(3);
        _columnsScores.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScores.put("points", new TableInfo.Column("points", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScores.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysScores = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesScores = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScores = new TableInfo("scores", _columnsScores, _foreignKeysScores, _indicesScores);
        final TableInfo _existingScores = TableInfo.read(db, "scores");
        if (!_infoScores.equals(_existingScores)) {
          return new RoomOpenHelper.ValidationResult(false, "scores(com.example.starengine.database.entities.Score).\n"
                  + " Expected:\n" + _infoScores + "\n"
                  + " Found:\n" + _existingScores);
        }
        final HashMap<String, TableInfo.Column> _columnsUpgrades = new HashMap<String, TableInfo.Column>(5);
        _columnsUpgrades.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("speed", new TableInfo.Column("speed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("fireRate", new TableInfo.Column("fireRate", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("power", new TableInfo.Column("power", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUpgrades.put("shipWidth", new TableInfo.Column("shipWidth", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUpgrades = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUpgrades = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUpgrades = new TableInfo("upgrades", _columnsUpgrades, _foreignKeysUpgrades, _indicesUpgrades);
        final TableInfo _existingUpgrades = TableInfo.read(db, "upgrades");
        if (!_infoUpgrades.equals(_existingUpgrades)) {
          return new RoomOpenHelper.ValidationResult(false, "upgrades(com.example.starengine.database.entities.Upgrade).\n"
                  + " Expected:\n" + _infoUpgrades + "\n"
                  + " Found:\n" + _existingUpgrades);
        }
        final HashMap<String, TableInfo.Column> _columnsLevels = new HashMap<String, TableInfo.Column>(3);
        _columnsLevels.put("levelNumber", new TableInfo.Column("levelNumber", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLevels.put("difficultySpeed", new TableInfo.Column("difficultySpeed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLevels.put("alienRate", new TableInfo.Column("alienRate", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLevels = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLevels = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLevels = new TableInfo("levels", _columnsLevels, _foreignKeysLevels, _indicesLevels);
        final TableInfo _existingLevels = TableInfo.read(db, "levels");
        if (!_infoLevels.equals(_existingLevels)) {
          return new RoomOpenHelper.ValidationResult(false, "levels(com.example.starengine.database.entities.Level).\n"
                  + " Expected:\n" + _infoLevels + "\n"
                  + " Found:\n" + _existingLevels);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "858cfb2748d3b1f4508ee31f8a9be4ec", "a34ec134f75dfe037a85721a882476da");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "scores","upgrades","levels");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `scores`");
      _db.execSQL("DELETE FROM `upgrades`");
      _db.execSQL("DELETE FROM `levels`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ScoreDao.class, ScoreDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UpgradeDao.class, UpgradeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LevelDao.class, LevelDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ScoreDao scoreDao() {
    if (_scoreDao != null) {
      return _scoreDao;
    } else {
      synchronized(this) {
        if(_scoreDao == null) {
          _scoreDao = new ScoreDao_Impl(this);
        }
        return _scoreDao;
      }
    }
  }

  @Override
  public UpgradeDao upgradeDao() {
    if (_upgradeDao != null) {
      return _upgradeDao;
    } else {
      synchronized(this) {
        if(_upgradeDao == null) {
          _upgradeDao = new UpgradeDao_Impl(this);
        }
        return _upgradeDao;
      }
    }
  }

  @Override
  public LevelDao levelDao() {
    if (_levelDao != null) {
      return _levelDao;
    } else {
      synchronized(this) {
        if(_levelDao == null) {
          _levelDao = new LevelDao_Impl(this);
        }
        return _levelDao;
      }
    }
  }
}
