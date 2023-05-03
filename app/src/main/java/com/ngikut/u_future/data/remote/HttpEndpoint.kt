package com.ngikut.u_future.data.remote

object HttpEndpoint {
    const val BASE_URL = "http://103.37.124.173:8080/api/v1"
    const val LOGIN = "$BASE_URL/student/login"
    const val REGISTER = "$BASE_URL/student/register"
    const val GET_USER = "$BASE_URL/student/profile"
    const val SEARCH_SCHOOL = "$BASE_URL/school/search"
    const val SINGLE_SCHOOL = "$BASE_URL/school/single"
}