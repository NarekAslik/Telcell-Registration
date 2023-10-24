package com.example.telcellregistration.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.example.telcellregistration.R

class PinInputView(c: Context, attrs: AttributeSet) : AppCompatEditText(c, attrs) {
    private val spacing: Int = 20
    private var rectList = arrayListOf<RectF>()
    private var leftXCoordinate = 0f
    private var rectWidth: Float = 0f
    private val paint = Paint()
    private val paintText = Paint()
    private var keyBoardTextList: List<Char> = arrayListOf()

    init {
        paint.color = context.getColor(R.color.grey_light)
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 4f
        paintText.color = context.getColor(R.color.orange)
        paintText.textSize = 40f
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        rectWidth = (w - (5 * spacing)) / 6f
        for (i in 0..5) {
            val rect = RectF(leftXCoordinate, 0f, leftXCoordinate + rectWidth, rectWidth)
            rectList.add(rect)
            leftXCoordinate += spacing + rectWidth
        }

    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        rectList.forEach { rect ->
            canvas.drawRoundRect(rect, 20f, 20f, paint)
        }
        keyBoardTextList.forEachIndexed { index, text ->
            val rect = rectList[index]
            canvas.drawText(text.toString(), rect.centerX(), rect.centerY(), paintText)
        }

    }


    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if (text != null && text.isNotEmpty()) {
            keyBoardTextList = text.toList()
        }
        invalidate()
    }
}