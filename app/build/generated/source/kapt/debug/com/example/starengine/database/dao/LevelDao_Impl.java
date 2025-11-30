package com.example.starengine.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.starengine.database.entities.Level;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LevelDao_Impl implements LevelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Level> __insertionAdapterOfLevel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllLevels;

  public LevelDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLevel = new EntityInsertionAdapter<Level>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `levels` (`levelNumber`,`difficultySpeed`,`alienRate`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Level entity) {
        statement.bindLong(1, entity.getLevelNumber());
        statement.bindDouble(2, entity.getDifficultySpeed());
        statement.bindDouble(3, entity.getAlienRate());
      }
    };
    this.__preparedStmtOfDeleteAllLevels = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM levels";
        return _query;
      }
    };
  }

  @Override
  public Object insertLevel(final Level level, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLevel.insert(level);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllLevels(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllLevels.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllLevels.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getLevel(final int levelNumber, final Continuation<? super Level> $completion) {
    final String _sql = "SELECT * FROM levels WHERE levelNumber = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, levelNumber);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Level>() {
      @Override
      @Nullable
      public Level call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLevelNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "levelNumber");
          final int _cursorIndexOfDifficultySpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "difficultySpeed");
          final int _cursorIndexOfAlienRate = CursorUtil.getColumnIndexOrThrow(_cursor, "alienRate");
          final Level _result;
          if (_cursor.moveToFirst()) {
            final int _tmpLevelNumber;
            _tmpLevelNumber = _cursor.getInt(_cursorIndexOfLevelNumber);
            final float _tmpDifficultySpeed;
            _tmpDifficultySpeed = _cursor.getFloat(_cursorIndexOfDifficultySpeed);
            final float _tmpAlienRate;
            _tmpAlienRate = _cursor.getFloat(_cursorIndexOfAlienRate);
            _result = new Level(_tmpLevelNumber,_tmpDifficultySpeed,_tmpAlienRate);
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

  @Override
  public Flow<List<Level>> getAllLevels() {
    final String _sql = "SELECT * FROM levels";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"levels"}, new Callable<List<Level>>() {
      @Override
      @NonNull
      public List<Level> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLevelNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "levelNumber");
          final int _cursorIndexOfDifficultySpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "difficultySpeed");
          final int _cursorIndexOfAlienRate = CursorUtil.getColumnIndexOrThrow(_cursor, "alienRate");
          final List<Level> _result = new ArrayList<Level>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Level _item;
            final int _tmpLevelNumber;
            _tmpLevelNumber = _cursor.getInt(_cursorIndexOfLevelNumber);
            final float _tmpDifficultySpeed;
            _tmpDifficultySpeed = _cursor.getFloat(_cursorIndexOfDifficultySpeed);
            final float _tmpAlienRate;
            _tmpAlienRate = _cursor.getFloat(_cursorIndexOfAlienRate);
            _item = new Level(_tmpLevelNumber,_tmpDifficultySpeed,_tmpAlienRate);
            _result.add(_item);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
