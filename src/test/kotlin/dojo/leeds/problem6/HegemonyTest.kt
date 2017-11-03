package dojo.leeds.problem6

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

class HegemonyTest {

    @Test
    fun `Given 1 2 3 6 7 then hegemony should return 5`(){
        assertThat(hegemony("1 2 3 6 7"), equalTo(5.0))
    }

    @Test
    fun `Given 1 2 3 4 7 then hegemony should return 4`(){
        assertThat(hegemony("1 2 3 4 7"), equalTo(4.0))
    }

    @Test
    fun `Given 7 7 7 then hegemony should return 7`(){
        assertThat(hegemony("7 7 7"), equalTo(7.0))
    }

    @Test
    fun `Given 7 8 7 9 9 then hegemony should return 8`(){
        assertThat(hegemony("7 8 7 9 9"), equalTo(8.0))
    }

    @Test
    fun `Given 1 2 2 2 2 2 then hegemony should return 1937500`(){
        assertThat(hegemony("1 2 2 2 2 2"), equalTo(1.937500))
    }

}


