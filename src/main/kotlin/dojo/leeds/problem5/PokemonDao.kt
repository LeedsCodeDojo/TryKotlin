package dojo.leeds.problem5

import com.github.kittinunf.fuel.httpGet
import com.squareup.moshi.Json
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi

data class Pokemon(val id: Int, val order: Int, val name:String,
                   val weight:Int, val height:Int,
                   val species: NamedApiResource,
                   val sprites: Map<String,String?>,
                   val abilities: List<Ability>)

data class NamedApiResource(val name: String, val url : String?)

data class Ability(val ability: NamedApiResource,
                   val slot: Int,
                   @Json(name="is_hidden") val hidden: Boolean)


interface PokemonDao {
    fun getPokemon(id: Int) : Pokemon?
}

abstract class AbstractRestDao{
    protected val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

}

class PokemonRestDao : PokemonDao, AbstractRestDao() {
    private val pokemonAdapter = moshi.adapter(Pokemon::class.java)

    private fun pokemonUrl(id: Int) = "https://pokeapi.co/api/v2/pokemon/$id/"

    override fun getPokemon(id: Int): Pokemon? {
        val headers = mapOf("User-Agent" to "Mozilla/5.0")
        val (_, response, result) = pokemonUrl(id)
                .httpGet().header(headers).responseString()
        return pokemonAdapter.fromJson(result.get())
    }
}


