package br.com.sodep.minetrackrwrk.toolkit.customview.statusbar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.random.Random

class StatusBarViewModel : ViewModel() {
    private val _statusBarState = MutableStateFlow(StatusBarState())
    val statusBarState = _statusBarState.asStateFlow()


    init {
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

    data class StatusBarState(
        val lp: String = "LP 0",
        val lg: String = "LG 0",
        val la: String = "LA 0"
    )
}