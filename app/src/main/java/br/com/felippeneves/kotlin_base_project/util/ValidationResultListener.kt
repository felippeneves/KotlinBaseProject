package br.com.felippeneves.kotlin_base_project.util

import androidx.annotation.IntDef

class ValidationResultListener(
    @StatusResult
    var result: Int = SUCESS,
    var erroMessage: String? = null
) {

    companion object {

        @IntDef(SUCESS, FAILURE, EMPTY)
        annotation class StatusResult

        const val SUCESS = 1
        const val FAILURE = 2
        const val EMPTY = 3
    }
}