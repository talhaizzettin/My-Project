package com.example.alifbee.classes

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.alifbee.R


@SuppressLint("ResourceAsColor")
class MyCustomView(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    var text: TextView
    var icon: ImageView
    var btnBg: LinearLayout
    var btnShdow: View
    var btnBorder : View
    var btn : RelativeLayout


    init {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_button, this)
        text = view.findViewById(R.id.button_text)
        icon = view.findViewById(R.id.button_icon)
        btnBg = view.findViewById(R.id.btn_bg)
        btnShdow = view.findViewById(R.id.btn_shadow)
        btnBorder = view.findViewById(R.id.btn_border)
        btn = view.findViewById(R.id.btn)


        context.theme.obtainStyledAttributes(attrs, R.styleable.MyCustomView, 0, 0).apply {

            val isIConVis = getBoolean(R.styleable.MyCustomView_btnIconVisible, false)
            val btnText = getString(R.styleable.MyCustomView_btnText)
            val textColor = getColor(R.styleable.MyCustomView_btnTextColor, R.color.num)
            val textSize = getDimensionPixelSize(R.styleable.MyCustomView_btnTextSize, 1).toFloat()
            val btnBgSp = getDrawable(R.styleable.MyCustomView_btnBackgrond)
            val btnShadowSp = getDrawable(R.styleable.MyCustomView_btnShadow)
            val btnBorderSp = getDrawable(R.styleable.MyCustomView_btnBorder)

            if (isIConVis) {
                icon.setImageDrawable(getDrawable(R.styleable.MyCustomView_btnIconId))
                icon.visibility = View.VISIBLE
            } else icon.visibility = View.GONE

            text.text = btnText
            text.setTextColor(textColor)
            text.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
            btnBg.setBackgroundDrawable(btnBgSp)
            btnShdow.setBackgroundDrawable(btnShadowSp)
            btnBorder.setBackgroundDrawable(btnBorderSp)

        }

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val param = btnBg.layoutParams as ViewGroup.MarginLayoutParams
        val parambtn = btn.layoutParams as ViewGroup.MarginLayoutParams
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                animate().apply {
                    duration = 100
                    parambtn.setMargins(0,15,0,0,)
                    param.setMargins(1,1,1,1)
                    btnBg.layoutParams = param
                    btn.layoutParams = parambtn
                }.start()
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                animate().apply {
                    duration = 100
                    parambtn.setMargins(0,0,0,0,)
                    param.setMargins(1,1,1,15)
                    btn.layoutParams = parambtn
                    btnBg.layoutParams = param
                }.start()
            }
            MotionEvent.ACTION_MOVE -> {
                val rect = Rect(left, top, right, bottom)
                if (!rect.contains(
                        left + event.x.toInt(),
                        top + event.y.toInt()
                    )
                ) {
                    parambtn.setMargins(0,0,0,0,)
                    btn.layoutParams = parambtn
                    param.setMargins(1,1,1,15)
                    btnBg.layoutParams = param
                }
            }
        }
        return super.onTouchEvent(event)
    }

}