package br.com.sodep.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import br.com.sodep.core.NetworkUtils.isNetworkAvailable
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

sealed class NetworkState {
    object IsConnected : NetworkState()
    object NoConnection : NetworkState()
}

@OptIn(DelicateCoroutinesApi::class)
object NetworkManager {
    fun Context.networkMonitor() = flow {
        do {
            delay(300)
            emit(if (isNetworkAvailable(this@networkMonitor)) NetworkState.IsConnected else NetworkState.NoConnection)
        } while (currentCoroutineContext().isActive)
    }.stateIn(GlobalScope, SharingStarted.WhileSubscribed(), NetworkState.NoConnection)
}

private object NetworkUtils {
    fun isNetworkAvailable(context: Context): Boolean {
        var result = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }

                }
            }
        }
        return result
    }
}