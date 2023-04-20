package com.test.core_pin.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.test.core_pin.data.model.CachedPinModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

internal class PinManager @Inject constructor(context: Context) {

    private val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()
    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        PIN_SHARED_PREFS,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    private var listener: SharedPreferences.OnSharedPreferenceChangeListener? = null

    fun observePinList(): Observable<List<CachedPinModel>> =
        Observable.create { emitter ->
            fun SharedPreferences.getAllData(): List<CachedPinModel> {
                return all.filter { (_, value) -> value is Int }
                    .map { (key, value) -> key to value as Int }
            }

            listener = SharedPreferences.OnSharedPreferenceChangeListener { _, _ ->
                emitter.onNext(sharedPreferences.getAllData())
            }
            sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
            emitter.onNext(sharedPreferences.getAllData())
        }
            .doOnDispose {
                if (listener != null) {
                    sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
                    listener = null
                }
            }

    fun savePin(cachedPinModel: CachedPinModel): Completable =
        Completable.fromAction {
            sharedPreferences.edit(true) {
                putInt(cachedPinModel.first, cachedPinModel.second)
            }
        }

    fun deletePin(name: String): Completable =
        Completable.fromAction {
            sharedPreferences.edit(true) {
                remove(name)
            }
        }

    fun deleteAll(): Completable =
        Completable.fromAction {
            sharedPreferences.edit(true) {
                clear()
            }
        }

    companion object {
        private const val PIN_SHARED_PREFS = "Pin_shared_prefs"
    }
}