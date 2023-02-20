package com.hamalawey.data.repo

import com.hamalawey.data.remote.ApiService
import com.hamalawey.domain.entity.CategoryResponse
import com.hamalawey.domain.repo.MealsRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealsRepoImpl @Inject constructor(private val apiService: ApiService): MealsRepo {
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}