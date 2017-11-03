package dojo.leeds.problem4

import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.*
import org.junit.Test

class PupilReaderTest {

    private val pupilReader = PupilReader()

    @Test
    fun `given a PupilReader then readFile should return a list of lines `(){
        val lines = pupilReader.readPupilFile()
        assertThat(lines, not(nullValue()))
        assertThat(lines.count(), equalTo(121))
    }

    @Test
    fun `given the PupilReader then fetchPupils should return a list of pupils`(){
        val pupils = pupilReader.fetchPupils()
        assertThat(pupils, not(nullValue()))
        assertThat(pupils.count(), equalTo(121))
    }

    @Test
    fun `given then count the pupils in each class`(){
        val pupils = pupilReader.fetchPupils()
        val pupilsInClass = pupils.byClass()
        pupilsInClass
                .forEach{ println("${it.key} : ${it.value.size}")}
    }

    @Test
    fun `find the class with the highest average score`(){
        val pupils = pupilReader.fetchPupils()
        pupils.byClass()
                .map { Pair(it.key, it.value.sumBy { pupil -> pupil.totalMarks }/it.value.size.toDouble()) }
                .forEach { println("Class ${it.first}  : ${it.second} ")}
    }

    @Test
    fun `find pupils who have scored all Grade A's`(){
        val pupils = pupilReader.fetchPupils()
        val passGrades = listOf(Grade.A)
        pupils.filter { it.grades.values.all { it in passGrades }}
                .forEach { println(it) }
    }

    @Test
    fun `find pupils who have scored all Grade C and above`(){
        val pupils = pupilReader.fetchPupils()
        val passGrades = listOf(Grade.A, Grade.B, Grade.C)
        pupils.filter { it.grades.values.all { it in passGrades }}
                .forEach { println(it) }
    }

    @Test
    fun `find highest scoring boy and girl in each class`(){
        val pupils = pupilReader.fetchPupils()

        val bestPupilsByGender = pupils.byClass()
                .map { Pair(it.key, it.value.partition { it.gender == "M" }) }
                .map { Triple(it.first,
                        it.second.first.maxBy { it.totalMarks },
                        it.second.second.maxBy { it.totalMarks }) }

        bestPupilsByGender.forEach {
            println("${it.first} : ${it.second} : ${it.third}")
        }
    }

}