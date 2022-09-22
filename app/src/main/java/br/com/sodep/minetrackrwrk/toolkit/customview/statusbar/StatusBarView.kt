package br.com.sodep.minetrackrwrk.toolkit.customview.statusbar

import android.content.Context
import android.util.AttributeSet
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import br.com.sodep.minetrackrwrk.R
import com.google.android.material.textview.MaterialTextView
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class StatusBarView(private val ctx: Context, private val attrs: AttributeSet) :
    ConstraintLayout(ctx, attrs) {

    private val view = inflate(ctx, R.layout.view_status_bar, this)
    private val statusViewModel by (ctx as FragmentActivity).viewModels<StatusBarViewModel>()

    private val lpView by lazy { view.findViewById<MaterialTextView>(R.id.lp) }
    private val lgView by lazy { view.findViewById<MaterialTextView>(R.id.lg) }
    private val laView by lazy { view.findViewById<MaterialTextView>(R.id.la) }
    private var jobCollector: Job? = null

    init {
        statusViewModel.statusBarState.flowWithLifecycle((ctx as FragmentActivity).lifecycle)
            .onEach {
                updateView(it)
            }.launchIn(ctx.lifecycleScope)
    }

    private fun updateView(statusBarState: StatusBarViewModel.StatusBarState) {
        lpView.text = statusBarState.lp
        lgView.text = statusBarState.lg
        laView.text = statusBarState.la
    }
}