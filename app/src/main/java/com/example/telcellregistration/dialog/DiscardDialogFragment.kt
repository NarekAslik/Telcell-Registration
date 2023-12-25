package com.example.telcellregistration.dialog

import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.example.telcellregistration.R
import com.example.telcellregistration.databinding.DiscardLayoutBinding

const val CONFIRM_RESULT = "confirm_result"
const val KEY_CONFIRM_TEXT = "key_confirm_text"

class DiscardDialogFragment : DialogFragment() {
    private lateinit var binding: DiscardLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.round_corner)
        return inflater.inflate(R.layout.discard_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DiscardLayoutBinding.bind(view)
        setWithPercent(90)
        this.isCancelable = false
        binding.apply {
            cancelButton.setOnClickListener {
                dismiss()
            }
            confirmButton.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(KEY_CONFIRM_TEXT, "discard confirm")
                setFragmentResult(CONFIRM_RESULT, bundle)
                dismiss()
            }
        }
    }

    private fun setWithPercent(percent: Int) {
        val percent = percent.toFloat() / 100
        val dm = Resources.getSystem().displayMetrics
        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
        val percentWidth = percent * rect.width()
        dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}