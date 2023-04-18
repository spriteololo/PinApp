package com.test.core_base.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.test.core_android_base.R
import com.test.core_android_base.databinding.DialogBinding
import com.test.core_base.viewbinding.viewBinding

class OkCancelDialog : AppCompatDialogFragment(R.layout.dialog) {

    private val binding: DialogBinding by viewBinding(DialogBinding::bind)

    companion object {

        private const val ARG_DIALOG_TAG = "tag"
        private const val ARG_TITLE = "title"
        private const val ARG_MESSAGE = "message"
        private const val ARG_OK = "ok"
        private const val ARG_CANCEL = "cancel"
        private const val ARG_REQUEST_ARGUMENT = "request_argument"

        fun show(
            activity: AppCompatActivity,
            tag: String,
            title: String? = null,
            message: String? = null,
            okButton: String? = activity.getString(R.string.ok),
            cancelButton: String? = activity.getString(R.string.cancel),
            requestCode: String? = null,
        ): DialogFragment =
            OkCancelDialog().apply {
                arguments = bundleOf(
                    ARG_TITLE to title,
                    ARG_DIALOG_TAG to tag,
                    ARG_MESSAGE to message,
                    ARG_CANCEL to cancelButton,
                    ARG_OK to okButton,
                    ARG_REQUEST_ARGUMENT to requestCode,
                )
                show(activity.supportFragmentManager, tag)
            }

        fun show(
            activity: AppCompatActivity,
            tag: String,
            title: Int? = null,
            message: Int? = null,
            okButton: Int? = null,
            cancelButton: Int? = null,
            requestCode: String? = null,
        ): DialogFragment = show(
            activity = activity,
            tag = tag,
            title = title?.let { id -> activity.getString(id) },
            message = message?.let { id -> activity.getString(id) },
            okButton = okButton?.let { id -> activity.getString(id) },
            cancelButton = cancelButton?.let { id -> activity.getString(id) },
            requestCode = requestCode,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tag = requireArguments().getString(ARG_DIALOG_TAG)
            ?: throw NullPointerException("No tag for dialog")

        requireArguments().getString(ARG_TITLE)?.also { title ->
            binding.title.text = title
            binding.title.visibility = View.VISIBLE
        }
        requireArguments().getString(ARG_MESSAGE)?.also { title -> binding.message.text = title }
        requireArguments().getString(ARG_OK)?.also { title ->
            binding.okButton.text = title
            binding.okButton.setOnClickListener {
                setFragmentResult(
                    tag,
                    DialogResult.OK.toBundle(requireArguments().getString(ARG_REQUEST_ARGUMENT))
                )
                dismiss()
            }
        }
        requireArguments().getString(ARG_CANCEL)?.also { title ->
            binding.cancelButton.text = title
            binding.cancelButton.visibility = View.VISIBLE
            binding.cancelButton.setOnClickListener {
                setFragmentResult(
                    tag,
                    DialogResult.CANCEL.toBundle(requireArguments().getString(ARG_REQUEST_ARGUMENT))
                )
                dismiss()
            }
        } ?: run {
            binding.cancelButton.visibility = View.GONE
        }
    }
}