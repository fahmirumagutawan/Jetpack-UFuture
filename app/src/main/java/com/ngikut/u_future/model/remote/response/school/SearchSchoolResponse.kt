package com.ngikut.u_future.model.remote.response.school

import com.ngikut.u_future.model.remote.response.base.MetaResponse
import com.ngikut.u_future.model.remote.response.base.SingleSchoolResponse

data class SearchSchoolResponse(
    val meta:MetaResponse,
    val data:List<SingleSchoolResponse>
)
