package com.jan.a06_elementspersonalitzats

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class DniValidatorView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs), TextWatcher {
    var successColor: Int
    var errorColor: Int
    lateinit var tvErrorCode: TextView
    lateinit var etMail: EditText
    val regexEsDNI = Regex("\\d\\d\\d\\d\\d\\d\\d\\d[A-Z|a-z]")
    
    
    init {
        inflate(context, R.layout.dni_validator, this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.MailValidator)

        setupViews()

        tvErrorCode.text = attributes.getString(R.styleable.MailValidator_textError)
        errorColor = attributes.getColor(R.styleable.MailValidator_underlineErrorColor, ContextCompat.getColor(context, R.color.black))
        successColor = attributes.getColor(R.styleable.MailValidator_underlineSuccessColor, ContextCompat.getColor(context, R.color.black))
        attributes.recycle()
    }

    private fun setupViews() {
        tvErrorCode = findViewById(R.id.tvErrorCode)
        etMail = findViewById(R.id.etMail)
        etMail.addTextChangedListener(this)
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if (!p0.isNullOrEmpty() && regexEsDNI.matches(p0)) {
            tvErrorCode.visibility = GONE
            etMail.background.setTint(successColor)
        }else{
            tvErrorCode.visibility = VISIBLE
            etMail.background.setTint(errorColor)
        }
    }

    override fun afterTextChanged(p0: Editable?) {

    }
}