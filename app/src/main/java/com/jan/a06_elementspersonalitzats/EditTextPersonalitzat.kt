package com.jan.a06_elementspersonalitzats

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat

class EditTextPersonalitzat: AppCompatEditText {

    constructor(context : Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        val regexAcabaAmbZero = Regex("[0-9]+${0}")
        inputType = InputType.TYPE_CLASS_NUMBER

        addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (!p0.isNullOrEmpty() && !regexAcabaAmbZero.matches(p0)) {
                    setBackgroundColor(ContextCompat.getColor(context, R.color.verd))
                }else{
                    setBackgroundColor(ContextCompat.getColor(context, R.color.vermell))
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }
}