package dojo.leeds.problem5

import com.github.kittinunf.fuel.httpGet
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test


fun readJson(fileName: String): String{
    return String.javaClass.classLoader.getResourceAsStream(fileName)
            .bufferedReader().readLines().joinToString("")
}

class PokemonDAOTest {

    val pokemonDao:PokemonDao = PokemonRestDao()

    private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    private val pokemonAdapter = moshi.adapter(Pokemon::class.java)

    private fun pokemonUrl(id: Int) = "https://pokeapi.co/api/v2/pokemon/$id/"

    fun getPokemonById(id: Int): Pokemon? {
        val headers = mapOf("User-Agent" to "Mozilla/5.0")
        val (_, response, result) = pokemonUrl(id)
                .httpGet().header(headers).responseString()
        return pokemonAdapter.fromJson(result.get())
    }

    @Test
    fun `given a valid pokemon id then a populated Pokemon should be returned`(){
        val pokemon = getPokemonById(2)
        assertThat(pokemon, not(nullValue()))
        pokemon?.apply {
            assertThat(id, equalTo(2))
            assertThat(order, equalTo(2))
            assertThat(name, equalTo("ivysaur"))
            assertThat(height, equalTo(10))
            assertThat(weight, equalTo(130))
            assertThat(sprites, not(nullValue()))
            assertThat(sprites.size, equalTo(8))
        }
    }

    @Test
    fun `fetch many pokemon`(){
        (21..30).map { getPokemonById(it) }
    }
}

