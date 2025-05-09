package com.jmonzonm.rickmortyapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jmonzonm.rickmortyapp.data.database.RickMortyDatabase
import com.jmonzonm.rickmortyapp.data.remote.ApiService
import com.jmonzonm.rickmortyapp.data.remote.paging.CharactersPagingSource
import com.jmonzonm.rickmortyapp.data.remote.paging.EpisodesPagingSource
import com.jmonzonm.rickmortyapp.domain.Repository
import com.jmonzonm.rickmortyapp.domain.model.CharacterModel
import com.jmonzonm.rickmortyapp.domain.model.CharacterOfTheDayModel
import com.jmonzonm.rickmortyapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val api: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val episodesPagingSource: EpisodesPagingSource,
    private val rickMortyDatabase: RickMortyDatabase
) : Repository {
    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id = id).toDomain()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { charactersPagingSource }).flow
    }

    override suspend fun getCharacterDB(): CharacterOfTheDayModel? {
        return rickMortyDatabase.getPreferenceDao().getCharacterOfTheDayDB()?.toDomain()
    }

    override suspend fun saveCharacterDB(characterOfTheDayModel: CharacterOfTheDayModel) {
        rickMortyDatabase.getPreferenceDao().saveCharacter(characterOfTheDayModel.toEntity())
    }

    override suspend fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { episodesPagingSource }
        ).flow
    }
}