package com.diegofajardo.stackexchangeapp.data.model

interface QueryModel {
    val inname: String
    val site: String
    val page: Int
    val pageSize: Int
    val fromDate: Int?
    val toDate: Int?
    val order: String
    val min: String?
    val max: String?
    val sort: String
}