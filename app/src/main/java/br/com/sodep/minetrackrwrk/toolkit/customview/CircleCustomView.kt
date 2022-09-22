package br.com.sodep.minetrackrwrk.toolkit.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.sodep.minetrackrwrk.R

class CircleCustomView(private val ctx: Context, private val attrSet: AttributeSet) :
    ConstraintLayout(ctx, attrSet) {
    private val view = inflate(ctx, R.layout.view_circle_profile, this)
    private val firstCharNameTextView by lazy { view.findViewById<TextView>(R.id.first_chart_name) }

    init {
        loadAttributes()
    }

    private fun loadAttributes() =
        ctx.obtainStyledAttributes(attrSet, R.styleable.CircleCustomView).let {
            val firstCharName = it.getString(R.styleable.CircleCustomView_firstChartName)
            setupView(firstCharName ?: "")
            it.recycle()
        }

    private fun setupView(firstCharName: String) {
        firstCharNameTextView.text = firstCharName.first().toString()
    }
}