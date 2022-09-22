package br.com.sodep.minetrackrwrk.toolkit.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.sodep.minetrackrwrk.R

class ToolbarCustomView(private val ctx: Context, private val attrSet: AttributeSet): ConstraintLayout(ctx, attrSet) {

    private val view = inflate(ctx, R.layout.view_toolbar, this)
    private val rightIconImageView by lazy { view.findViewById<ImageView>(R.id.icon_right) }
    private val leftIconImageView by lazy { view.findViewById<ImageView>(R.id.icon_left) }

    init {
        loadAttributes()
    }

    private fun loadAttributes() = ctx.obtainStyledAttributes(attrSet, R.styleable.ToolbarCustomView).let {
        val rightIcon = it.getDrawable(R.styleable.ToolbarCustomView_rightIcon)
        val leftIcon = it.getDrawable(R.styleable.ToolbarCustomView_leftIcon)

        loadIconImages(rightIcon, leftIcon)

        it.recycle()
    }

    private fun loadIconImages(rightIcon: Drawable?, leftIcon: Drawable?){
        rightIconImageView.setImageDrawable(rightIcon)
        leftIconImageView.setImageDrawable(leftIcon)
    }

}

