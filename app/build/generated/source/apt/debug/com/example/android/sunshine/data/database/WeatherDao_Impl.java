package com.example.android.sunshine.data.database;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import android.support.annotation.NonNull;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class WeatherDao_Impl implements WeatherDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfWeatherEntry;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOldWeather;

  public WeatherDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherEntry = new EntityInsertionAdapter<WeatherEntry>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `weather`(`id`,`weatherIconId`,`date`,`min`,`max`,`humidity`,`pressure`,`wind`,`degrees`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherEntry value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getWeatherIconId());
        final Long _tmp;
        _tmp = DateConverter.toTimestamp(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        stmt.bindDouble(4, value.getMin());
        stmt.bindDouble(5, value.getMax());
        stmt.bindDouble(6, value.getHumidity());
        stmt.bindDouble(7, value.getPressure());
        stmt.bindDouble(8, value.getWind());
        stmt.bindDouble(9, value.getDegrees());
      }
    };
    this.__preparedStmtOfDeleteOldWeather = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM weather WHERE date < ?";
        return _query;
      }
    };
  }

  @Override
  public void bulkInsert(WeatherEntry... weather) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfWeatherEntry.insert(weather);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteOldWeather(Date date) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOldWeather.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      final Long _tmp;
      _tmp = DateConverter.toTimestamp(date);
      if (_tmp == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindLong(_argIndex, _tmp);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteOldWeather.release(_stmt);
    }
  }

  @Override
  public LiveData<List<ListWeatherEntry>> getCurrentWeatherForecasts(Date date) {
    final String _sql = "SELECT id, weatherIconId, date, min, max FROM weather WHERE date >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final Long _tmp;
    _tmp = DateConverter.toTimestamp(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    return new ComputableLiveData<List<ListWeatherEntry>>() {
      private Observer _observer;

      @Override
      protected List<ListWeatherEntry> compute() {
        if (_observer == null) {
          _observer = new Observer("weather") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfWeatherIconId = _cursor.getColumnIndexOrThrow("weatherIconId");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("date");
          final int _cursorIndexOfMin = _cursor.getColumnIndexOrThrow("min");
          final int _cursorIndexOfMax = _cursor.getColumnIndexOrThrow("max");
          final List<ListWeatherEntry> _result = new ArrayList<ListWeatherEntry>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ListWeatherEntry _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpWeatherIconId;
            _tmpWeatherIconId = _cursor.getInt(_cursorIndexOfWeatherIconId);
            final Date _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = DateConverter.toDate(_tmp_1);
            final double _tmpMin;
            _tmpMin = _cursor.getDouble(_cursorIndexOfMin);
            final double _tmpMax;
            _tmpMax = _cursor.getDouble(_cursorIndexOfMax);
            _item = new ListWeatherEntry(_tmpId,_tmpWeatherIconId,_tmpDate,_tmpMin,_tmpMax);
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
    }.getLiveData();
  }

  @Override
  public int countAllFutureWeather(Date date) {
    final String _sql = "SELECT COUNT(id) FROM weather WHERE date >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final Long _tmp;
    _tmp = DateConverter.toTimestamp(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<WeatherEntry> getWeatherByDate(Date date) {
    final String _sql = "SELECT * FROM weather WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final Long _tmp;
    _tmp = DateConverter.toTimestamp(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    return new ComputableLiveData<WeatherEntry>() {
      private Observer _observer;

      @Override
      protected WeatherEntry compute() {
        if (_observer == null) {
          _observer = new Observer("weather") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfWeatherIconId = _cursor.getColumnIndexOrThrow("weatherIconId");
          final int _cursorIndexOfDate = _cursor.getColumnIndexOrThrow("date");
          final int _cursorIndexOfMin = _cursor.getColumnIndexOrThrow("min");
          final int _cursorIndexOfMax = _cursor.getColumnIndexOrThrow("max");
          final int _cursorIndexOfHumidity = _cursor.getColumnIndexOrThrow("humidity");
          final int _cursorIndexOfPressure = _cursor.getColumnIndexOrThrow("pressure");
          final int _cursorIndexOfWind = _cursor.getColumnIndexOrThrow("wind");
          final int _cursorIndexOfDegrees = _cursor.getColumnIndexOrThrow("degrees");
          final WeatherEntry _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpWeatherIconId;
            _tmpWeatherIconId = _cursor.getInt(_cursorIndexOfWeatherIconId);
            final Date _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = DateConverter.toDate(_tmp_1);
            final double _tmpMin;
            _tmpMin = _cursor.getDouble(_cursorIndexOfMin);
            final double _tmpMax;
            _tmpMax = _cursor.getDouble(_cursorIndexOfMax);
            final double _tmpHumidity;
            _tmpHumidity = _cursor.getDouble(_cursorIndexOfHumidity);
            final double _tmpPressure;
            _tmpPressure = _cursor.getDouble(_cursorIndexOfPressure);
            final double _tmpWind;
            _tmpWind = _cursor.getDouble(_cursorIndexOfWind);
            final double _tmpDegrees;
            _tmpDegrees = _cursor.getDouble(_cursorIndexOfDegrees);
            _result = new WeatherEntry(_tmpId,_tmpWeatherIconId,_tmpDate,_tmpMin,_tmpMax,_tmpHumidity,_tmpPressure,_tmpWind,_tmpDegrees);
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
    }.getLiveData();
  }
}
