package com.gelatotest.data.mapper

import com.gelatotest.data.entity.PicsumPhotosEntity
import com.gelatotest.domain.model.PicsumPhotos
import javax.inject.Inject

class PhotoListDataMapper @Inject constructor() {
    fun mapFrom(picsumPhotosEntity: List<PicsumPhotosEntity>): List<PicsumPhotos> {
        return picsumPhotosEntity.map {
            PicsumPhotos(it.id, it.author, it.width, it.height, it.url, it.download_url)
        }
    }
}