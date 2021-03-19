package com.gelatotest.data.mapper

import com.gelatotest.data.entity.PicsumPhotosEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PhotoListDataMapperTest {
    @InjectMocks
    private lateinit var subject: PhotoListDataMapper

    @Test
    fun mapsFrom_givenPicsumPhotosEntity_returnsPicsumPhotos() {
        val actual = subject.mapFrom(getPicsumPhotosEntity())
        assertThat(actual.size).isEqualTo(2)

        assertThat(actual[0])
            .extracting("photoId","author","width","height","url","downloadUrl")
            .containsExactly("1","author1", 111, 111, "url1","downloadurl1")

        assertThat(actual[1])
            .extracting("photoId","author","width","height","url","downloadUrl")
            .containsExactly("2","author2", 222, 222, "url2","downloadurl2")
    }

    fun getPicsumPhotosEntity(): List<PicsumPhotosEntity> {
        return listOf(
            PicsumPhotosEntity(
                "1",
                "author1",
                111,
                111,
                "url1",
                "downloadurl1"
            ),
            PicsumPhotosEntity(
                "2",
                "author2",
                222,
                222,
                "url2",
                "downloadurl2"
            )
        )
    }
}