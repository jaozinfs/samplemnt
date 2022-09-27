package br.com.sodep.minetrackrwrk.toolkit.customview.statusbar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.sodep.core.NetworkManager.networkMonitor
import br.com.sodep.core.NetworkState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.random.Random

class StatusBarViewModel(application: Application) : AndroidViewModel(application) {
    private val _statusBarState = MutableStateFlow(StatusBarState())
    val statusBarState = _statusBarState.asStateFlow()

    init {
       collectDataState()
        collectNetworkState()
    }

    private fun collectDataState() {
        viewModelScope.launch {
            do {
                _statusBarState.update {
                    when (Random.nextInt(2)) {
                        0 -> {
                            it.copy(lp = "LP ${Random.nextInt(10)}")
                        }
                        1 -> {
                            it.copy(lg = "LG ${Random.nextInt(10)}")
                        }
                        else -> {
                            it.copy(la = "LA ${Random.nextInt(10)}")
                        }
                    }
                }
                delay(2_000)
            } while (coroutineContext.isActive)
        }
    }

    private fun collectNetworkState() {
        getApplication<Application>().applicationContext.networkMonitor().onEach { newState ->
            _statusBarState.update {
                it.copy(networkState = newState is NetworkState.IsConnected)
            }
        }.launchIn(viewModelScope)
    }

    data class StatusBarState(
        val lp: String = "LP 0",
        val lg: String = "LG 0",
        val la: String = "LA 0",
        val networkState: Boolean = false
    )
}