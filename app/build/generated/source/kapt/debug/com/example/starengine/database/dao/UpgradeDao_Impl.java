package com.example.starengine.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.starengine.database.entities.Upgrade;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UpgradeDao_Impl implements UpgradeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Upgrade> __insertionAdapterOfUpgrade;

  private final EntityDeletionOrUpdateAdapter<Upgrade> __updateAdapterOfUpgrade;

  public UpgradeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUpgrade = new EntityInsertionAdapter<Upgrade>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `upgrades` (`id`,`speed`,`fireRate`,`power`,`shipWidth`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Upgrade entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getSpeed());
        statement.bindDouble(3, entity.getFireRate());
        statement.bindLong(4, entity.getPower());
        statement.bindDouble(5, entity.getShipWidth());
      }
    };
    this.__updateAdapterOfUpgrade = new EntityDeletionOrUpdateAdapter<Upgrade>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `upgrades` SET `id` = ?,`speed` = ?,`fireRate` = ?,`power` = ?,`shipWidth` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Upgrade entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getSpeed());
        statement.bindDouble(3, entity.getFireRate());
        statement.bindLong(4, entity.getPower());
        statement.bindDouble(5, entity.getShipWidth());
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public Object insertUpgrade(final Upgrade upgrade, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUpgrade.insert(upgrade);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUpgrade(final Upgrade upgrade, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUpgrade.handle(upgrade);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<Upgrade> getUpgrade() {
    final String _sql = "SELECT * FROM upgrades WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"upgrades"}, new Callable<Upgrade>() {
      @Override
      @Nullable
      public Upgrade call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "speed");
          final int _cursorIndexOfFireRate = CursorUtil.getColumnIndexOrThrow(_cursor, "fireRate");
          final int _cursorIndexOfPower = CursorUtil.getColumnIndexOrThrow(_cursor, "power");
          final int _cursorIndexOfShipWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "shipWidth");
          final Upgrade _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final float _tmpSpeed;
            _tmpSpeed = _cursor.getFloat(_cursorIndexOfSpeed);
            final float _tmpFireRate;
            _tmpFireRate = _cursor.getFloat(_cursorIndexOfFireRate);
            final int _tmpPower;
            _tmpPower = _cursor.getInt(_cursorIndexOfPower);
            final float _tmpShipWidth;
            _tmpShipWidth = _cursor.getFloat(_cursorIndexOfShipWidth);
            _result = new Upgrade(_tmpId,_tmpSpeed,_tmpFireRate,_tmpPower,_tmpShipWidth);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getUpgradeSync(final Continuation<? super Upgrade> $completion) {
    final String _sql = "SELECT * FROM upgrades WHERE id = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Upgrade>() {
      @Override
      @Nullable
      public Upgrade call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "speed");
          final int _cursorIndexOfFireRate = CursorUtil.getColumnIndexOrThrow(_cursor, "fireRate");
          final int _cursorIndexOfPower = CursorUtil.getColumnIndexOrThrow(_cursor, "power");
          final int _cursorIndexOfShipWidth = CursorUtil.getColumnIndexOrThrow(_cursor, "shipWidth");
          final Upgrade _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final float _tmpSpeed;
            _tmpSpeed = _cursor.getFloat(_cursorIndexOfSpeed);
            final float _tmpFireRate;
            _tmpFireRate = _cursor.getFloat(_cursorIndexOfFireRate);
            final int _tmpPower;
            _tmpPower = _cursor.getInt(_cursorIndexOfPower);
            final float _tmpShipWidth;
            _tmpShipWidth = _cursor.getFloat(_cursorIndexOfShipWidth);
            _result = new Upgrade(_tmpId,_tmpSpeed,_tmpFireRate,_tmpPower,_tmpShipWidth);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
