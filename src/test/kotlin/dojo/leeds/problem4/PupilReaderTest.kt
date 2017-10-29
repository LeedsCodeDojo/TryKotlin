package dojo.leeds.problem4

import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.*
import org.junit.Test

class PupilReaderTest {

    val pupilReader = PupilReader()

    @Test
    fun `given a PupilReader then readFile should return a list of lines `(){
        val lines = pupilReader.readPupilFile()
        assertThat(lines, not(nullValue()))
        assertThat(lines.count(), equalTo(122))
    }
}